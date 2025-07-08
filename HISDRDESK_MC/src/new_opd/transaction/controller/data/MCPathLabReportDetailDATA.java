package new_opd.transaction.controller.data;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.ControllerUTIL;
import hisglobal.presentation.Status;
import hisglobal.utility.HisUtil;
import hisglobal.vo.UserVO;
import new_opd.DAO.MCPathLabReportDetailDAO;
import new_opd.transaction.controller.fb.MCPathLabReportDetailFB;

public class MCPathLabReportDetailDATA {

	/*
	public static void getDrugDetails(MCPathLabReportDetailFB fb) {

		String postContent = "{\"primaryKeys\":[\"1\",\"" + fb.getStrHospitalCode() + "\"]}";

		// String postContent = "{\"primaryKeys\":[\"1\",\"gaurav1\"]}";

		fb.setStrWarningMsg("");

		try {
			String drugList = postRequest("", postContent, HisUtil.getParameterFromHisPathXML("EAUSHADI_GETDRUG_URL"));
			System.out.println("drugList---" + drugList);
			fb.setStrDrugList(drugList);
		} catch (Exception e) {
			e.printStackTrace();

			fb.setStrWarningMsg(
					"Unable to Connect with eAushadhi System, Please Try Later. or Contact System Administrator");
		}

	}

	private static String postRequest(String url, String requestContent, String baseUrl) throws Exception {

		System.out.println("requestContent >> " + requestContent);

		// String baseUrl =
		// "https://eaushadhipb.in/HISUtilities/services/restful/DataService/getFilterWiseDataJSON/";
		// // 7

		// String baseUrl =
		// "https://uatphsc.dcservices.in/HISUtilities/services/restful/DataService/getFilterWiseDataJSON/";
		// // 14

		System.out.println(" POST >> " + baseUrl + url + " >> " + requestContent);

		URL object = new URL(baseUrl + url);

		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("content-type", "text/plain");
		// con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Authorization", "Basic Y2RhYzpjZGFj");

		con.setRequestMethod("POST");

		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(requestContent.toString());
		wr.flush();

		// display what returns the POST request

		StringBuilder sb = new StringBuilder("");

		int HttpResult = con.getResponseCode();

		System.out.println("response code >> " + HttpResult);

		if (HttpResult == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			System.out.println("" + sb.toString());
		} else {
			System.out.println(con.getResponseMessage());
			throw new Exception(con.getResponseMessage());
		}

		return sb.toString();

	}

	public static void getPreviousIssueDtls(MCPathLabReportDetailFB fb, HttpServletResponse response) {

		try {

			String strIssueDetails = MCPathLabReportDetailDAO.getPreviousIssueDtls(fb.getStrHospitalCode(),
					fb.getStrCrNo());

			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().print(strIssueDetails);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void getPreviousIssueItemDtls(MCPathLabReportDetailFB fb, HttpServletResponse response) {

		try {

			String strIssueDetails = MCPathLabReportDetailDAO.getIssueItemDtls(fb.getStrHospitalCode(), fb.getStrIssueNo());

			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().print(strIssueDetails);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	 public static void save(MCPathLabReportDetailFB fb) {

		StringBuffer sb = new StringBuffer("");
		IssueResponse response = null;
		String eAushadhiIssueId = "";

		String[] crDtls = fb.getStrHiddenPatDtl().split("\\^");

		System.out.println("crDtls >> "+crDtls);
		
		String patName = crDtls[0];
		String patAge = crDtls[3].replace("/", "#").split("#")[0];
		String patGender = crDtls[3].replace("/", "#").split("#")[1];
		String patFName = crDtls[1].replace("/", "#").split("#")[0];
		String patMobileNo = crDtls[7];

		System.out.println("below split");
		
		System.out.println("fb.getStrDrugDetailsHidden().length >> "+fb.getStrDrugDetailsHidden().length);
		
		if (fb.getStrDrugDetailsHidden() != null && fb.getStrDrugDetailsHidden().length > 0) {

			sb.append("{\"primaryKeys\":['{")
					.append("\"crNo\":\"" + fb.getStrCrNo() + "\",  \"hospitalId\":\"" + fb.getStrHospitalCode()
							+ "\", \"patName\":\"" + patName + "\", \"patAge\":\"" + patAge + "\", \"patGender\":\""
							+ patGender + "\", \"patFName\":\"" + patFName + "\", \"patMobileNo\":\"" + patMobileNo
							+ "\",");

			sb.append("\"issueDetails\":[");

			for (int i = 0; i < fb.getStrDrugDetailsHidden().length; i++) {

				String[] drugDtls = fb.getStrDrugDetailsHidden()[i].split("\\^");
				
				System.out.println("drugDtls >> "+drugDtls);
				

				if (i != 0)
					sb.append(",");

				// store_id,item_id,store_name,item_name,itembrand_id,batch_no,
				// expiry_date,manuf_date,inhand_qty,hstnum_rate,hstnum_saleprice , qty unit ,
				// rate unit , qty unit name, request qty, issue qty

				sb.append("{ \"storeId\":\"" + drugDtls[0] + "\", \"itemId\":\"" + drugDtls[1]
						+ "\", \"itembrandId\":\"" + drugDtls[4] + "\", \"batchNo\":\"" + drugDtls[5]
						+ "\", \"requestedQty\":\"" + drugDtls[14] + "\", \"issueQty\":\"" + drugDtls[15]
						+ "\", \"unitId\" :\"" + drugDtls[11]+ "\", \"remarks\" :\"" + drugDtls[16] + "\" } ");

			}

			sb.append("] }']}");

		}

		System.out.println(sb.toString());
		

		try {
			String issueDetail = postRequest("", sb.toString(),	HisUtil.getParameterFromHisPathXML("EAUSHADI_SAVEDRUG_URL"));

			System.out.println(issueDetail);
			
			Gson gson = new Gson();

			response = gson.fromJson(issueDetail, IssueResponse.class);

		} catch (Exception e) {
			e.printStackTrace();

			fb.setStrWarningMsg(
					"Unable to Connect with eAushadhi System, Please Try Later. or Contact System Administrator");
		}

		eAushadhiIssueId = response.getDataValue().get(0).get(0);

		System.out.println(" eAushadhiIssueId >>  " + eAushadhiIssueId);

		fb.setStrIssueNo(eAushadhiIssueId);

		try {
			MCPathLabReportDetailDAO.saveIssueDtls(fb);
		} catch (Exception e) {

			fb.setStrErrMsg("Error Occured, Please Contact System Administrator");
		}
	}*/
	
	
	public static void saveHardCopyRecdDetails(MCPathLabReportDetailFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		
		try 
		{
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
            c1 = Calendar.getInstance();	    
            c1.add(Calendar.DATE,0);
            

//            formBean.setStrHiddenOtherDtl(new String(Base64.getDecoder().decode((String) request.getParameter("hiddenOtherDtl"))));
//            System.out.println("str::"+formBean.getStrHiddenOtherDtl());//crNo^requisitionNo^fileName^isHardCopyReceived^index
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				
			MCPathLabReportDetailDAO.saveHardCopyRecdDetails(formBean);
			if (formBean.getStrMsgType().equals("1")) 
				throw new Exception(formBean.getStrMsgString());
			
			/*
			 * try { response.setHeader("Cache-Control", "no-cache");
			 * response.getWriter().print("true^"+formBean.getStrHiddenOtherDtl().split(
			 * "\\^")[3]+"^"+formBean.getStrHiddenOtherDtl().split("\\^")[4]);
			 * 
			 * } catch (Exception e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
			
			formBean.setStrNormalMsg("Data Saved Successfully");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void getPatientsDtlNew(MCPathLabReportDetailFB formBean, HttpServletRequest request) 
	{
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		
		try 
		{
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
            c1 = Calendar.getInstance();	    
            c1.add(Calendar.DATE,0);
            if(formBean.getStrPresDate()==null || formBean.getStrPresDate().trim().equals("") || formBean.getStrPresDate().trim().equals("0"))
            	formBean.setStrCtDate(sdf.format(c1.getTime()));
            else
            	formBean.setStrCtDate(formBean.getStrPresDate());
            
            formBean.setStrPresDate(formBean.getStrCtDate());
            
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			MCPathLabReportDetailDAO.getPatientsDtl(formBean);
			if (formBean.getStrMsgType().equals("1")) 
				throw new Exception(formBean.getStrMsgString());
			
			formBean.setStrPatDtl(getPatientsDtl(formBean));
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static String getPatientsDtl(MCPathLabReportDetailFB fb) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		String strCrNo = "0",strPrevCrNo = "0";//1
		String strPatName="",strPrevPatName="";//2
		String strMobNo = "0",strPrevMobNo = "0";//3
		String strGenderAge = "0",strPrevGenderAge = "0";//4
		String strTestNames = "",strPrevTestNames="";//5		
		String strVialNo = "0",strPrevVialNo = "0";//6
		String strHospName="",strPrevHospName="";//7
		String strReqNo = "0",strPrevReqNo = "0";//8
		
		String strReqDate = "0",strPrevReqDate = "0";//9
		String strPathStatusAccRej = "0",strPrevPathStatusAccRej = "0";//10		
		String strSampleDrawnDate = "0",strPrevSampleDrawnDate = "0";//11		
		String strSampleHandoverDate = "0",strPrevSampleHandoverDate = "0";//12
		String strTat = "0",strPrevTat = "0";//13
		String strFileName = "0",strPrevFileName = "0";//14		
		String strTestDate = "0",strPrevTestDate = "0";//15
		
		String strIsHardCopyRecFlag = "0",strPrevIsHardCopyRecFlag = "0";//16
		
		String strTestCodes="",strPrevTestCodes="";//17
		
		String strColor="";
		int nSizeMinus1 = 0;
		try {
			int nRowCount = 0, nSlNo=0;			
			wbResult = fb.getStrPatDtlsWs();
			nSizeMinus1 = wbResult.size()-1;
			br.append("<tbody>");
			
//			crNo, patName, mobNo, gender_age, test_name, vialNo, hospName, reqNo, 
//			reqDate, path_status_acc_rej, sampleDrawnDate, sampleHandoverDate, tat, fileName, testDate, isHardCopyRecd, testCode  //17 Var
			if(wbResult != null && wbResult.size()>0) {				
				
				while (wbResult.next()) {
						strCrNo 		= wbResult.getString(1);
						strPatName		= wbResult.getString(2);
						strMobNo		= wbResult.getString(3);
						strGenderAge	= wbResult.getString(4);
						strTestNames	= strTestNames.equals("")?wbResult.getString(5):(strTestNames+",<br>"+wbResult.getString(5));
						
						strVialNo		= wbResult.getString(6);
						strHospName		= wbResult.getString(7);
						strReqNo		= wbResult.getString(8);
						
						strReqDate		= wbResult.getString(9);
						strPathStatusAccRej 		= (wbResult.getString(10)!=null && !wbResult.getString(10).equalsIgnoreCase("null"))?wbResult.getString(10):"Acceptance Pending";
						
						strSampleDrawnDate		= wbResult.getString(11);
						strSampleHandoverDate		= wbResult.getString(12);
						strTat		= wbResult.getString(13);
						strFileName		= wbResult.getString(14);
						strTestDate		= wbResult.getString(15);
						
						strIsHardCopyRecFlag	=	wbResult.getString(16);
						strTestCodes	= strTestCodes.equals("")?wbResult.getString(17):(strTestCodes+","+wbResult.getString(17));
						
//						System.out.println("strCrNo::"+strCrNo);
//						System.out.println("strTestNames::"+strTestNames);
//						System.out.println("strStatus::"+strStatus);
//						System.out.println("strFileName::"+strFileName);
					/*
					 * if(wbResult.getString(6).equals("0"))
					 * br.append("<tr style='background:bisque;'>"); else
					 */
						
					
					if((nRowCount>0 && (!strCrNo.equals(strPrevCrNo) || !strPathStatusAccRej.equals(strPathStatusAccRej) || !strFileName.equals(strPrevFileName)))) {
						
						strColor = ((nSlNo%2==1)?"lightgray":"");
						
					br.append("<tr style='background-color:"+strColor+"';>");
					br.append("<td width='3%' style='text-align:center;'>"+(nSlNo+1)+".</td>");
					br.append("<td width='10%' style='text-align:center;'>"+strPrevCrNo+"</td>");
					br.append("<td width='10%' style='text-align:left;'>"+strPrevPatName+"</td>");
					br.append("<td width='8%' style='text-align:center;'>"+strPrevMobNo+"</td>");
					br.append("<td width='7%' style='text-align:center;'>"+strPrevGenderAge+"</td>");
					br.append("<td width='10%' style='text-align:center;'>"+strPrevSampleDrawnDate+"</td>");
					br.append("<td width='10%' style='text-align:center;'>"+strPrevSampleHandoverDate+"</td>");
					br.append("<td width='15%' style='text-align:left;'>"+strPrevTestNames+"</td>");
					
				    br.append("<td width='7%' style='text-align:center;'>"+strPrevPathStatusAccRej+"</td>");
				    
				 ///   br.append("<td width='15%' style='text-align:center;'>"+wbResult.getString(13)+"</td>");
				    //sb.append("<td align='center'><a href='#' class='btn btn-success' onclick = 'view_Print_Slip(this,\"" + ws.getString(3)+"\");'><span>View</span></a></td>");
				    if(strPrevFileName.equals("-"))
				    	br.append("<td width='15%' style='text-align:center;'>"+ "Report Pending" +"</td>");
				    else
				    	br.append("<td width='15%' align='left'><a href='#' class='btn btn-success' onclick = 'printreport(this,\"" + strPrevFileName+"\");'><span>View</span></a><br>("+strPrevTestDate+")</td>");
				    
				    	br.append("<td width='5%' style='text-align:center;'>");
				    	
				    	if(strPrevIsHardCopyRecFlag.equalsIgnoreCase("1")) {
				    		br.append("<input type='checkbox' name='chkHardCopyRecd' checked value="+strPrevIsHardCopyRecFlag+">");
//				    		br.append("<span style='display:block;background-color:lightgreen;' id='recdId-"+nSlNo+"'><br>Received</span>");
//				    		br.append("<span style='display:none;background-color:pink;' id='nRecdId-"+nSlNo+"'><br>Not<br>Received</span>");
				    	}
				    	else {
				    		br.append("<input type='checkbox' name='chkHardCopyRecd' value="+strPrevIsHardCopyRecFlag+">");
//				    		br.append("<span style='display:none;background-color:lightgreen;' id='recdId-"+nSlNo+"'><br>Received</span>");
//				    		br.append("<span style='display:block;background-color:pink;' id='nRecdId-"+nSlNo+"'><br>Not<br>Received</span>");
				    	}	
				    	
				    	br.append("</td>");
				    	
				    	
				    br.append("</tr>");
				    br.append("<input type='hidden' id='strIsHardCopyRecd"+nSlNo+"' name='strIsHardCopyRecd' "+ "value='"+strPrevIsHardCopyRecFlag+"' />");
				  //crNo^requisitionNo^fileName^isHardCopyRecd^strTestCodes
				    br.append("<input type='hidden' id='strHiddenDtl"+nSlNo+"' name='strHiddenDtl' "+ "value='"+strPrevCrNo+"^"+strPrevReqNo+"^"+strPrevFileName+"^"+strPrevIsHardCopyRecFlag+"^"+ strPrevTestCodes+"' />");//crNo^requisitionNo^^fileName^isHardCopyReceived^
				    
					/*
					 * br.append("<td width='15%' style='text-align:center;'>" +
					 * "<img class='img-fluid' src='/HIS/hisglobal/images/avai/GO.png' " +
					 * "onclick='openIssueDtl("+
					 * nRowCount+");' alt='Responsive image' style='cursor:pointer;height:20px;'>");
					 * br.append("<input type='hidden' id='strHiddenDtl"
					 * +nRowCount+"' name='strHiddenDtl' " +
					 * "value='"+wbResult.getString(1)+"' /></td></tr>");
					 */ 
				    	nSlNo++;
				    	strTestNames = wbResult.getString(5);
				    	strTestCodes = wbResult.getString(17);
					}
					
					nRowCount++;
					
					strPrevCrNo 		= strCrNo;//1
					strPrevPatName = strPatName;//2
					strPrevMobNo = strMobNo;//3
					strPrevGenderAge = strGenderAge;//4
					strPrevTestNames	= strTestNames;//5
					
					strPrevVialNo = strVialNo;//6
					strPrevHospName = strHospName;//7
					strPrevReqNo = strReqNo;//8
					strPrevReqDate = strReqDate;//9
					strPrevPathStatusAccRej		= strPathStatusAccRej;//10
					
					strPrevSampleDrawnDate = strSampleDrawnDate;//11
					strPrevSampleHandoverDate = strSampleHandoverDate;//12
					strPrevTat = strTat;//13
					strPrevFileName 	= strFileName;//14
					strPrevTestDate = strTestDate;//15
					strPrevIsHardCopyRecFlag = strIsHardCopyRecFlag;//16					
					strPrevTestCodes	= strTestCodes;//17					
				}
				
						////Last Row
							strColor = ((nSlNo%2==1)?"lightgray":"");
							
						br.append("<tr style='background-color:"+strColor+"';>");
						br.append("<td width='3%' style='text-align:center;'>"+(nSlNo+1)+".</td>");
						br.append("<td width='10%' style='text-align:center;'>"+strPrevCrNo+"</td>");
						br.append("<td width='10%' style='text-align:left;'>"+strPrevPatName+"</td>");
						br.append("<td width='8%' style='text-align:center;'>"+strPrevMobNo+"</td>");
						br.append("<td width='7%' style='text-align:center;'>"+strPrevGenderAge+"</td>");
						br.append("<td width='10%' style='text-align:center;'>"+strPrevSampleDrawnDate+"</td>");
						br.append("<td width='10%' style='text-align:center;'>"+strPrevSampleHandoverDate+"</td>");
						br.append("<td width='15%' style='text-align:left;'>"+strPrevTestNames+"</td>");
						
					    br.append("<td width='7%' style='text-align:center;'>"+strPrevPathStatusAccRej+"</td>");
					    
					 ///   br.append("<td width='15%' style='text-align:center;'>"+wbResult.getString(13)+"</td>");
					    //sb.append("<td align='center'><a href='#' class='btn btn-success' onclick = 'view_Print_Slip(this,\"" + ws.getString(3)+"\");'><span>View</span></a></td>");
					    if(strPrevFileName.equals("-"))
					    	br.append("<td width='15%' style='text-align:center;'>"+ "Report Pending" +"</td>");
					    else
					    	br.append("<td width='15%' align='left'><a href='#' class='btn btn-success' onclick = 'printreport(this,\"" + strPrevFileName+"\");'><span>View</span></a><br>("+strPrevTestDate+")</td>");
					    
					    	br.append("<td width='5%' style='text-align:center;'>");
					    	
					    	if(strPrevIsHardCopyRecFlag.equalsIgnoreCase("1")) {
					    		br.append("<input type='checkbox' name='chkHardCopyRecd' checked value="+strPrevIsHardCopyRecFlag+">");
//					    		br.append("<span style='display:block;background-color:lightgreen;' id='recdId-"+nSlNo+"'><br>Received</span>");
//					    		br.append("<span style='display:none;background-color:pink;' id='nRecdId-"+nSlNo+"'><br>Not<br>Received</span>");
					    	}
					    	else {
					    		br.append("<input type='checkbox' name='chkHardCopyRecd' value="+strPrevIsHardCopyRecFlag+">");
//					    		br.append("<span style='display:none;background-color:lightgreen;' id='recdId-"+nSlNo+"'><br>Received</span>");
//					    		br.append("<span style='display:block;background-color:pink;' id='nRecdId-"+nSlNo+"'><br>Not<br>Received</span>");
					    	}	
					    	
					    	br.append("</td>");
					    	
					    	
					    br.append("</tr>");
					  //crNo^requisitionNo^fileName^isHardCopyRecd^strTestCodes
					    br.append("<input type='hidden' id='strIsHardCopyRecd"+nSlNo+"' name='strIsHardCopyRecd' "+ "value='"+strPrevIsHardCopyRecFlag+"' />");
					    br.append("<input type='hidden' id='strHiddenDtl"+nSlNo+"' name='strHiddenDtl' "+ "value='"+strCrNo+"^"+strPrevReqNo+"^"+strPrevFileName+"^"+strPrevIsHardCopyRecFlag+"^"+ strPrevTestCodes+"' />");//crNo^requisitionNo^^fileName^isHardCopyReceived^
					    ///////////last row	
			}
			else {
				br.append("<tr>");
				br.append("<td width='100%' colspan='5'>No Record Found</td>");
				br.append("</tr>");
			}
			
			br.append("</tbody>");

		} catch (Exception _err) {
			_err.printStackTrace();
			fb.setStrMsgString("IssueToPatientTransMcDATA.getPatientsDtl() --> "+ _err.getMessage());
			fb.setStrMsgType("1");
		}
		return br.toString();
	}
	
	/*
	public static void getPresDrugDtlNew(MCPathLabReportDetailFB formBean, HttpServletRequest request) 
	{		
		try 
		{			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			MCPathLabReportDetailDAO.getPresDtls(formBean);
			if (formBean.getStrMsgType().equals("1")) 
				throw new Exception(formBean.getStrMsgString());
			
			formBean.setStrPatDtl(getPresDrugDtls(formBean));
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static String getPresDrugDtls(MCPathLabReportDetailFB fb) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		String strPresHidDtls = "";
		
		try {
			int nRowCount = 0;			
			wbResult = fb.getStrPresDtlsWs();
			
			if(wbResult != null && wbResult.size()>0) {				
				
				while (wbResult.next()) {	
					
//					ItembrandId ^ DosageId ^ Days ^ FrequencyId ^ DoseQty ^ EpisodeCode ^ DeptCode ^ Dept Unit Code
					strPresHidDtls = wbResult.getString(4) +"^"+ wbResult.getString(6) +"^"+ wbResult.getString(8) +"^"+ wbResult.getString(10) 
						+"^"+ wbResult.getString(9) +"^"+ wbResult.getString(3) +"^"+ wbResult.getString(12) +"^"+ wbResult.getString(13);
					
					br.append("<div class='col-sm-1'>"+(nRowCount+1)+".</div>");
					br.append("<div class='col-sm-3'>"+wbResult.getString(5));
					br.append("<input type='hidden' name='strPresHidDtls' id='strPresHidDtls"+nRowCount+"' value='"+strPresHidDtls+"' >");
					br.append("</div>");
					br.append("<div class='col-sm-2'>"+wbResult.getString(7)+"</div>");
					br.append("<div class='col-sm-2'>"+wbResult.getString(8)+"</div>");
					br.append("<div class='col-sm-2'>"+wbResult.getString(11)+"</div>");
					br.append("<div class='col-sm-2'>"+wbResult.getString(9)+"</div>");
//					br.append("<div class='col-sm-2'>0");
//					br.append("<input type='hidden' name='strDrugDtls' id='strDrugDtls"+nRowCount+"' value='' ></div>");
//					br.append("<div class='col-sm-2'><span title='Edit' onclick='editRow(\""+wbResult.getString(4)+"\");' ><i class='fas fa-edit' style='color:blue;' aria-hidden='true'></i></span></div>");
					nRowCount++;
				}
			}
			else {
				br.append("<div class=\"col-sm-12\">");
				br.append("No Records Available");
				br.append("</div>");
			}

		} catch (Exception _err) {
			_err.printStackTrace();
			fb.setStrMsgString("IssueToPatientTransMcDATA.getPresDrugDtls() --> "+ _err.getMessage());
			fb.setStrMsgType("1");
		}
		return br.toString();
	}
	*/
	
	
	
	public static void DownloadFile(MCPathLabReportDetailFB formBean, HttpServletRequest request,
			HttpServletResponse response) {
		
			String strmsgText = null;		 
			File f = null;
			FileInputStream fis = null;
			FileOutputStream fos = null;		 
			try {  
				
				downloadFileFromFTP(formBean.getStrHospitalCode(),formBean.getStrUploadFileId(), response);
			} 	
			catch (Exception e) {
				e.printStackTrace();
				strmsgText = "MCPathLabReportDetailDATA.DownloadFile(vo) --> "+ e.getMessage();
				HisException eObj = new HisException("mms","MCPathLabReportDetailDATA->DownloadFile()", strmsgText);
				formBean.setStrMsgString("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
				eObj = null;

			} finally {

				if (f != null) {
					f = null;
				}
				if (fis != null) {
					fis = null;
				}
				if (fos != null) {
					fos = null;
				}
			}
		}

	public static void downloadFileFromFTP( String hospitalCode ,  String strFileName ,  HttpServletResponse response_p)
			throws Exception  {
		 
		InputStream io = null;
		 FTPClient ftp = null;
		try {
			
			String[] strTemp = strFileName.replace(".", "#").split("#");
			String strExt = strTemp[strTemp.length - 1];

			if (strExt.equalsIgnoreCase("txt")
					|| strExt.equalsIgnoreCase("txt")) {

				response_p.setContentType("application/txt");
				response_p.setHeader("Content-disposition", " filename=" + strFileName);

			} else if (strExt.equalsIgnoreCase("pdf")) {

				response_p.setContentType("application/pdf");
				response_p.setHeader("Content-disposition",	"attachment; filename="+ strFileName);

			} 
			
			else if (strExt.equalsIgnoreCase("jpeg")
					|| strExt.equalsIgnoreCase("jpg")) {

				response_p.setContentType("image/jpg");
				response_p.setHeader("Content-disposition",	"attachment; filename=" + strFileName);

			} 
			
			else if (strExt.equalsIgnoreCase("html")
					|| strExt.equalsIgnoreCase("htm")) {

				response_p.setContentType("text/html;charset=utf-8");
				response_p.setHeader("Content-disposition",	"attachment; filename="	+ strFileName);

			} else if (strExt.equalsIgnoreCase("xlsx")
					|| strExt.equalsIgnoreCase("xlsx")) {

				response_p.setContentType("application/xlsx");
				response_p.setHeader("Content-disposition", "attachment; filename="+ strFileName);

			} else if (strExt.equalsIgnoreCase("xml")) {

				response_p.setContentType("application/xml");
				response_p.setHeader("Content-disposition",	"attachment; filename=" + strFileName);

			} else if (strExt.equalsIgnoreCase("doc")
					|| strExt.equalsIgnoreCase("docx")) {

				response_p.setContentType("application/msword");
				response_p.setHeader("Content-disposition",	"attachment; filename="+ strFileName);

			} else if (strExt.equalsIgnoreCase("rdf")) {
				response_p.setContentType("application/msword");
				response_p.setHeader("Content-disposition",	"attachment; filename="+ strFileName);

			} else if (strExt.equalsIgnoreCase("rtf")) {

				response_p.setContentType("application/msword");
				response_p.setHeader("Content-disposition",	"attachment; filename="+ strFileName);

			} else {

				response_p.setContentType("text/html;charset=utf-8");
				response_p.setHeader("Content-disposition","attachment; filename="+ strFileName);

			}

			
			  ftp = new FTPClient();  
			  
//		 	  System.out.println("ftp connecting to "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
//		   System.out.println("with credentials : "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME")+" & "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
			  
			  ftp.connect(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
	           ftp.login(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME"), HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
	           ftp.setFileType(FTP.BINARY_FILE_TYPE);
	           String filename=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FILEPATH")+ "pathlab/" + strFileName; //    "/opt/ftp/hmis/pathlab/"+ strFileName
			 
//	           System.out.println("download file name >>>>>>>>>>> "+filename);
	         
			 io = ftp.retrieveFileStream(filename);

		 
			byte[] buf = new byte[4096];
			int read = 0;
			
			while ((read = io.read(buf)) > 0) 
				response_p.getOutputStream().write(buf, 0, read);
			

		} catch (Exception e) {
			throw e;
		} finally {

			if(io != null){
				io.close();
				io = null;
			}
			 
	        
			if(ftp !=null) {
				  ftp.logout();
				  ftp = null;
			}
			
			 
		}
	}	
	
	

	public static void AjaxGetPDFReportFTP(MCPathLabReportDetailFB fb,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		Status status = new Status();
		HttpSession session=request.getSession();
		StringBuffer sbAjaxRes = new StringBuffer();
		Map mp=new HashMap();
		boolean flag=false;
		String filename="";

		InputStream io = null;
		 FTPClient ftp = null;
		 
		String osType = null;
       	String paramValue=null;
       	String _Param="";
		try{			
			List<MCPathLabReportDetailFB> MCPathLabReportDetailFB=null;
			MCPathLabReportDetailFB mcpathlabreportfb = new MCPathLabReportDetailFB();
			List<MCPathLabReportDetailFB> mcpathlabreportdetailFB=new ArrayList<MCPathLabReportDetailFB>();
			List<String> reqList=new ArrayList();
			//fb.setisPatDetailPage("1");
			UserVO userVO = ControllerUTIL.getUserVO(request);
			if(userVO.getHospitalCode()==null) {
				userVO.setHospitalCode(fb.getStrHospitalCode()==null || fb.getStrHospitalCode().equals("")?fb.getStrCrNo().substring(0, 5):fb.getStrHospitalCode());
			}
			String hospCode = userVO.getHospitalCode();
			String selectedPDFName= fb.getSelectedPDFName();
			
			String[] arrSelectedPDFName=selectedPDFName.split("@@");
			
			
				Map<String,String> objMapSamAcc= new HashMap<String,String>();
				List<InputStream> pdfs = new ArrayList<InputStream>();
				
				for(int i1=0;i1<arrSelectedPDFName.length;i1++)
				 {
				

					String pdfname=arrSelectedPDFName[i1];
					objMapSamAcc.put(pdfname,"12");
					
				 }
			
				Set setPdfName=objMapSamAcc.keySet();

				Iterator itrPdfName=setPdfName.iterator();


				//iterate over Crno's
				while(itrPdfName.hasNext())
				{
					  String strPdfName=(String)itrPdfName.next();
						  
						  ftp = new FTPClient();  
						  
					 //	  System.out.println("ftp connecting to "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
					    //  System.out.println("with credentials : "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME")+" & "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
						  
						  ftp.connect(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
				           ftp.login(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME"), HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
				           ftp.setFileType(FTP.BINARY_FILE_TYPE);
				           
				         
				       	
				       	try{
				       	//System.out.println("HISUTIL::getParameterFromHisPathXML");
				       		osType = System.getProperties().getProperty("os.name");
				       		if(osType.startsWith("Win")){
				       			_Param += "_WIN";
				       			//paramValue = getParameterFromXML("c:/RAOL/AHIMS/hisPath.xml", _Param);
				       			paramValue = "/opt/ftp/hmis/pathlab/";
				       		}else{
				       			_Param += "_LIN";
				       	    	paramValue = "/FTP/ehmsphscftp/pathlab/";
				       		}
				       	}catch(Exception e){
				       		e.printStackTrace();
				       	}
				           
				         //  String strPdfPath=paramValue+ strPdfName; 
				       	String strPdfPath=paramValue+ strPdfName;  
						
						 // System.out.println("strPdfPathabcd : "+strPdfPath);
						 // System.out.println("patientcreatefileftpaddress>>>>"+patientcreatefileftpaddress);
						
			          // System.out.println("file name >>>>>>>>>>> "+strPdfName);
			         
					 io = ftp.retrieveFileStream(strPdfPath);
					 
						byte[] buf = new byte[4096];
						int read = 0;
						//response.setContentType("application/pdf");
						if (strPdfName.toLowerCase().indexOf(".pdf") > 0) {
							response.setContentType("application/pdf");
						} else if (strPdfName.toLowerCase().indexOf(".png") > 0) {
							response.setContentType("image/png");
						} else 	
						if (strPdfName.toLowerCase().indexOf(".jpg") > 0) {
							response.setContentType("image/jpg");
						}
						else
						if (strPdfName.toLowerCase().indexOf(".jpeg") > 0) {
							response.setContentType("image/jpeg");
						}
						
						else {
							
							response.setContentType("application/octet-stream");
															
						}
						response.setHeader("Content-Disposition", "filename=\""+strPdfName+"\"");
						
						while ((read = io.read(buf)) > 0) 
							response.getOutputStream().write(buf, 0, read);
		  			
												
						//response.getWriter().print("res");
							
				  }
				
		}
		catch (Exception e) {
			throw e;
		} finally {

			if(io != null){
				io.close();
				io = null;
			}
			 
	        
			if(ftp !=null) {
				  ftp.logout();
				  ftp = null;
			}
			
			 
		}
	}	
	
	
	
	
	
	
	
}
