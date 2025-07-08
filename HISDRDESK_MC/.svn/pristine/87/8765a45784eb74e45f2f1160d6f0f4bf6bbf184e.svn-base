package new_opd.transaction.controller.data;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import HisWeb.bo.PathCareLabsHandOverObject;
import new_opd.DAO.MCPathLabSampleHandoverDetailMcNewDAO;
import new_opd.transaction.controller.fb.MCPathLabSampleHandoverDetailFB;

public class MCPathLabSampleHandoverDetailTransMcNewDATA {

	/*
	public static void getDrugDetails(MCPathLabSampleHandoverDetailFB fb) {

		String postContent = "{\"primaryKeys\":[\"1\",\"" + fb.getStrHospitalCode() + "\"]}";

		// String postContent = "{\"primaryKeys\":[\"1\",\"gaurav1\"]}";

		fb.setStrWarningMsg("");

		try {
			String drugList = postRequest("", postContent, HisUtil.getParameterFromHisPathXML("EAUSHADI_GETDRUG_URL"));
			//System.out.println("drugList---" + drugList);
			fb.setStrDrugList(drugList);
		} catch (Exception e) {
			e.printStackTrace();

			fb.setStrWarningMsg(
					"Unable to Connect with eAushadhi System, Please Try Later. or Contact System Administrator");
		}

	}

	private static String postRequest(String url, String requestContent, String baseUrl) throws Exception {

		//System.out.println("requestContent >> " + requestContent);

		// String baseUrl =
		// "https://eaushadhipb.in/HISUtilities/services/restful/DataService/getFilterWiseDataJSON/";
		// // 7

		// String baseUrl =
		// "https://uatphsc.dcservices.in/HISUtilities/services/restful/DataService/getFilterWiseDataJSON/";
		// // 14

		//System.out.println(" POST >> " + baseUrl + url + " >> " + requestContent);

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

		//System.out.println("response code >> " + HttpResult);

		if (HttpResult == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			//System.out.println("" + sb.toString());
		} else {
			//System.out.println(con.getResponseMessage());
			throw new Exception(con.getResponseMessage());
		}

		return sb.toString();

	}

	public static void getPreviousIssueDtls(MCPathLabSampleHandoverDetailFB fb, HttpServletResponse response) {

		try {

			String strIssueDetails = MCPathLabSampleHandoverDetailMcNewDAO.getPreviousIssueDtls(fb.getStrHospitalCode(),
					fb.getStrCrNo());

			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().print(strIssueDetails);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getPreviousIssueItemDtls(MCPathLabSampleHandoverDetailFB fb, HttpServletResponse response) {

		try {

			String strIssueDetails = MCPathLabSampleHandoverDetailMcNewDAO.getIssueItemDtls(fb.getStrHospitalCode(),
					fb.getStrIssueNo());

			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().print(strIssueDetails);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
*/
	
	public static void save(MCPathLabSampleHandoverDetailFB fb) throws Exception {

		PathCareLabsHandOverObject pathCareLabHandOverObj =null;
		try {
			pathCareLabHandOverObj = MCPathLabSampleHandoverDetailMcNewDAO.saveSampleHandoverDtls(fb);
		}
		catch (Exception e) {
			fb.setStrNormalMsg("Data Not Saved Successfully!!!");
			throw e;
		}
		
		//if data saved successfully, then call PathCare API
			MCPathLabSampleHandoverDetailMcNewDAO mcPathLabHandover = new MCPathLabSampleHandoverDetailMcNewDAO();
			mcPathLabHandover.callPathService(fb,pathCareLabHandOverObj);		
			fb.setStrNormalMsg("Data Saved Successfully!!!");
	}
	
	
	public static void resendFailedWebservices(MCPathLabSampleHandoverDetailFB fb) {

		//System.out.println("INSIDE SAVE DATA >>saveForWebServicesSent ");
		try {
			MCPathLabSampleHandoverDetailMcNewDAO.resendFailedWebservices(fb);
		} catch (Exception e) {

			fb.setStrErrMsg("Error Occured, Please Contact System Administrator");

		}
		
		fb.setStrNormalMsg("Data Saved Successfully!!!");

	}

	public static void getPatientsDtlNew(MCPathLabSampleHandoverDetailFB formBean, HttpServletRequest request) {
		SimpleDateFormat sdf = null;
		Calendar c1 = null;

		try {
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
			c1 = Calendar.getInstance();
			c1.add(Calendar.DATE, 0);

			if (formBean.getStrPresDate() == null || formBean.getStrPresDate().trim().equals("")
					|| formBean.getStrPresDate().trim().equals("0"))
				formBean.setStrCtDate(sdf.format(c1.getTime()));
			else
				formBean.setStrCtDate(formBean.getStrPresDate());

			formBean.setStrPresDate(formBean.getStrCtDate());

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			MCPathLabSampleHandoverDetailMcNewDAO.getPatientsDtl(formBean);
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());

			formBean.setStrPatDtl(getPatientsDtl(formBean));
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());

			/*
			 * MCPathLabSampleHandoverDetailMcNewDAO.getPatientsIssuedDtl(formBean); if
			 * (formBean.getStrMsgType().equals("1")) throw new
			 * Exception(formBean.getStrMsgString());
			 * 
			 * formBean.setStrPatIssuedDtl(getPatientsIssuedDtl(formBean)); if
			 * (formBean.getStrMsgType().equals("1")) throw new
			 * Exception(formBean.getStrMsgString());
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPatientsDtl(MCPathLabSampleHandoverDetailFB fb) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		String strCrNo = "0",strPrevCrNo = "0";
		String strVialNo = "0", strPrevVialNo = "0";
		String strTestNames = "";
		String strHidden_Values="";
		try {
			int nVialWiseTestsPerPatient = 0;
			wbResult = fb.getStrPatDtlsWs(); //crNo,patName,mob,gender||'/'||age,test_name,vialNo,hospName,testCode,reqNo,reqDate,episodeCode,nVialWiseTestsPerPatient--> order by hrgnum_puk,hrgstr_vial_no,hrgstr_test_name,hrgnum_requisition_no
			// br.append("<tbody>");
			br.append("<tbody id='myTable'>");

			if (wbResult != null && wbResult.size() > 0) {

				while (wbResult.next()) {
					
					strCrNo = wbResult.getString(1);
					strVialNo = wbResult.getString(6);
					
					if(!strCrNo.equalsIgnoreCase(strPrevCrNo))
					{
						nVialWiseTestsPerPatient = Integer.parseInt(wbResult.getString(12)); // No. of Tests per Vial per Patient
						
						if(nVialWiseTestsPerPatient==1) {
							strTestNames = wbResult.getString(5);
							
							//vialNo,reqNo,crNo,hospcode,testCode,  pat_name,mobile_no,gender_code||''/''||age,test_name,hosp_name,reqDate,episode_code
							strHidden_Values = wbResult.getString(6)+ "^"+ wbResult.getString(9) + "^"+ wbResult.getString(1) 
							  + "^"+ fb.getStrHospitalCode()+ "^" + wbResult.getString(8) 
							  + "^" + wbResult.getString(2)+ "^" + wbResult.getString(3)+ "^" + wbResult.getString(4)+ "^" + wbResult.getString(5)
							  + "^" + wbResult.getString(7)+ "^" + wbResult.getString(10)+ "^" + wbResult.getString(11);
							
							br.append("<tr><td width='5%' style='text-align:center;'><input type='checkbox' name='strHiddenValues' value=\"" + strHidden_Values +"\" /></td>");
							
							br.append("<td width='10%' style='text-align:center;'>" + wbResult.getString(6) + "</td>");
							br.append("<td width='25%' style='text-align:center;'>" + wbResult.getString(2) + " ( "+ (wbResult.getString(1))+ " ) "+ "</td>");
							br.append("<td width='10%' style='text-align:center;'>" + wbResult.getString(3) + "</td>");
							br.append("<td width='20%' style='text-align:center;'>" + wbResult.getString(4) + "</td>");
							br.append("<td width='30%' style='text-align:left;'>" + wbResult.getString(5) + "</td></tr>");
						}	
						else
						{
							//vialNo,reqNo,crNo,hospcode,testCode,  pat_name,mobile_no,gender_code||''/''||age,test_name,hosp_name,reqDate,episode_code
							strHidden_Values = wbResult.getString(6)+ "^"+ wbResult.getString(9) + "^"+ wbResult.getString(1) 
							  + "^"+ fb.getStrHospitalCode()+ "^" + wbResult.getString(8) 
							  + "^" + wbResult.getString(2)+ "^" + wbResult.getString(3)+ "^" + wbResult.getString(4)+ "^" + wbResult.getString(5)
							  + "^" + wbResult.getString(7)+ "^" + wbResult.getString(10)+ "^" + wbResult.getString(11) +"#";// # appended
							
							strTestNames = wbResult.getString(5)+",<br>";
							nVialWiseTestsPerPatient--;
							strPrevCrNo 	= strCrNo;
							strPrevVialNo 	= strVialNo;
							continue;
						}
							
					}
					else
					{
						if(!strVialNo.equalsIgnoreCase(strPrevVialNo) )	//same patient(crNo), different vialNo
						{
							nVialWiseTestsPerPatient = Integer.parseInt(wbResult.getString(12)); // No. of Tests per Vial per Patient
							
							if(nVialWiseTestsPerPatient==1) {
								strTestNames = wbResult.getString(5);
								
								//vialNo,reqNo,crNo,hospcode,testCode,  pat_name,mobile_no,gender_code||''/''||age,test_name,hosp_name,reqDate,episode_code
								strHidden_Values = wbResult.getString(6)+ "^"+ wbResult.getString(9) + "^"+ wbResult.getString(1) 
								  + "^"+ fb.getStrHospitalCode()+ "^" + wbResult.getString(8) 
								  + "^" + wbResult.getString(2)+ "^" + wbResult.getString(3)+ "^" + wbResult.getString(4)+ "^" + wbResult.getString(5)
								  + "^" + wbResult.getString(7)+ "^" + wbResult.getString(10)+ "^" + wbResult.getString(11);
								
								br.append("<tr><td width='5%' style='text-align:center;'><input type='checkbox' name='strHiddenValues' value=\"" + strHidden_Values +"\" /></td>");
								
								br.append("<td width='10%' style='text-align:center;'>" + wbResult.getString(6) + "</td>");
								br.append("<td width='25%' style='text-align:center;'>" + wbResult.getString(2) + " ( "+ (wbResult.getString(1))+ " ) "+ "</td>");
								br.append("<td width='10%' style='text-align:center;'>" + wbResult.getString(3) + "</td>");
								br.append("<td width='20%' style='text-align:center;'>" + wbResult.getString(4) + "</td>");
								br.append("<td width='30%' style='text-align:left;'>" + strTestNames + "</td></tr>");
							}	
							else
							{
								//vialNo,reqNo,crNo,hospcode,testCode,  pat_name,mobile_no,gender_code||''/''||age,test_name,hosp_name,reqDate,episode_code
								strHidden_Values = wbResult.getString(6)+ "^"+ wbResult.getString(9) + "^"+ wbResult.getString(1) 
								  + "^"+ fb.getStrHospitalCode()+ "^" + wbResult.getString(8) 
								  + "^" + wbResult.getString(2)+ "^" + wbResult.getString(3)+ "^" + wbResult.getString(4)+ "^" + wbResult.getString(5)
								  + "^" + wbResult.getString(7)+ "^" + wbResult.getString(10)+ "^" + wbResult.getString(11) +"#";// # appended
								
								strTestNames = wbResult.getString(5)+",<br>";
								nVialWiseTestsPerPatient--;
								strPrevCrNo 	= strCrNo;
								strPrevVialNo 	= strVialNo;
								continue;
							}
								
						}
						else//same patient(crNo), same vialNo
						{
							if(nVialWiseTestsPerPatient==1) {
								strTestNames += wbResult.getString(5);
								
								//vialNo,reqNo,crNo,hospcode,testCode,  pat_name,mobile_no,gender_code||''/''||age,test_name,hosp_name,reqDate,episode_code
								strHidden_Values += wbResult.getString(6)+ "^"+ wbResult.getString(9) + "^"+ wbResult.getString(1) 
								  + "^"+ fb.getStrHospitalCode()+ "^" + wbResult.getString(8) 
								  + "^" + wbResult.getString(2)+ "^" + wbResult.getString(3)+ "^" + wbResult.getString(4)+ "^" + wbResult.getString(5)
								  + "^" + wbResult.getString(7)+ "^" + wbResult.getString(10)+ "^" + wbResult.getString(11);
								
								br.append("<tr><td width='5%' style='text-align:center;'><input type='checkbox' name='strHiddenValues' value=\"" + strHidden_Values +"\" /></td>");
								
								br.append("<td width='10%' style='text-align:center;'>" + wbResult.getString(6) + "</td>");
								br.append("<td width='25%' style='text-align:center;'>" + wbResult.getString(2) + " ( "+ (wbResult.getString(1))+ " ) "+ "</td>");
								br.append("<td width='10%' style='text-align:center;'>" + wbResult.getString(3) + "</td>");
								br.append("<td width='20%' style='text-align:center;'>" + wbResult.getString(4) + "</td>");
								br.append("<td width='30%' style='text-align:left;'>" + strTestNames + "</td></tr>");
							}	
							else
							{
								//vialNo,reqNo,crNo,hospcode,testCode,  pat_name,mobile_no,gender_code||''/''||age,test_name,hosp_name,reqDate,episode_code
								strHidden_Values += wbResult.getString(6)+ "^"+ wbResult.getString(9) + "^"+ wbResult.getString(1) 
								  + "^"+ fb.getStrHospitalCode()+ "^" + wbResult.getString(8) 
								  + "^" + wbResult.getString(2)+ "^" + wbResult.getString(3)+ "^" + wbResult.getString(4)+ "^" + wbResult.getString(5)
								  + "^" + wbResult.getString(7)+ "^" + wbResult.getString(10)+ "^" + wbResult.getString(11) +"#";// # appended
								
								strTestNames += wbResult.getString(5)+",<br>";
								nVialWiseTestsPerPatient--;
								strPrevCrNo 	= strCrNo;
								strPrevVialNo 	= strVialNo;
								continue;
							}
						}
							
					}					 

					strPrevCrNo 	= strCrNo;
					strPrevVialNo 	= strVialNo;
					
				}
			} else {
				br.append("<tr>");
				br.append("<td width='100%' colspan='5'>No Record Found</td>");
				br.append("</tr>");
			}

			br.append("</tbody>");

		} catch (Exception _err) {
			_err.printStackTrace();
			fb.setStrMsgString("MCPathLabSampleHandoverDetailTransMcNewDATA.getPatientsDtl() --> " + _err.getMessage());
			fb.setStrMsgType("1");
		}
		return br.toString();
	}
	
	
	public static void getPatientsDtlForWebservicesSent(MCPathLabSampleHandoverDetailFB formBean, HttpServletRequest request) {
		SimpleDateFormat sdf = null;
		Calendar c1 = null;
		String optionsDeskCmb = "";
		String optionsSentAPICmb = "";

		try {
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
			c1 = Calendar.getInstance();
			c1.add(Calendar.DATE, 0);
			
			if (formBean.getStrPresDate() == null || formBean.getStrPresDate().trim().equals("")
					|| formBean.getStrPresDate().trim().equals("0"))
				formBean.setStrCtDate(sdf.format(c1.getTime()));
			else
				formBean.setStrCtDate(formBean.getStrPresDate());
			
			
			if (formBean.getStrDeskCombo() == null || formBean.getStrDeskCombo().trim().equals(""))
				formBean.setStrDeskCombo("1");
			
			
			if (formBean.getStrAPIStatus() == null || formBean.getStrAPIStatus().trim().equals(""))
				formBean.setStrAPIStatus("0");
			

			formBean.setStrPresDate(formBean.getStrCtDate());

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			//System.out.println("DATE"+formBean.getStrCtDate());
		//	System.out.println("DESKCOMBO"+ formBean.getStrComboDrDesk());
			//System.out.println("STATUS"+formBean.getStrAPIStatus());
			
			MCPathLabSampleHandoverDetailMcNewDAO.getPatientsDtlForWebservicesSent(formBean);
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());

			formBean.setStrPatDtl(getPatientsDtlForWebservicesSentHLP(formBean));
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());
			
			
			if(formBean.getStrDeskCombo().equals("1"))
			 optionsDeskCmb = "<option value='1' selected>Dr. Desk</option><option value='2'>Sample Handover Details</option>";
		    else {
		    	 optionsDeskCmb = "<option value='1' >Dr. Desk</option><option value='2' selected>Sample Handover Details</option>";
		    }
			
			formBean.setStrComboDrDesk(optionsDeskCmb);
			
			if(formBean.getStrAPIStatus().equals("0"))
				optionsSentAPICmb = "<option value='0' selected>Success</option><option value='1'>Failed</option>";
			    
			    
			    else {
			    	optionsSentAPICmb = "<option value='0' >Success</option><option value='1' selected>Failed</option>";
				    
			    }  
		    formBean.setStrComboAPISent(optionsSentAPICmb);

		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	 public static void getPatDetailsWebServicesSentAjax(HttpServletResponse response, HttpServletRequest request) {
		 MCPathLabSampleHandoverDetailFB formBean= new MCPathLabSampleHandoverDetailFB();
		 
		 
	        try {
	        	String strPresDate = request.getParameter("strPresDate");
		        String strDeskCombo = request.getParameter("strDeskCombo");
		        String strAPIStatus = request.getParameter("strAPIStatus");
		        
		        formBean.setStrPresDate(strPresDate);
		        formBean.setStrDeskCombo(strDeskCombo);
		        formBean.setStrAPIStatus(strAPIStatus);
		        
	            response.setHeader("Cache-Control", "no-cache");
	            
	            MCPathLabSampleHandoverDetailMcNewDAO.getPatientsDtlForWebservicesSent(formBean);
	            
	            String result = getPatientsDtlForWebservicesSentHLP(formBean);
	            
	            response.getWriter().print(result);
	            
	            //System.out.println("INSIDE WebServicesSentAjax DATA " +result);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	
	
	
	
	public static String getPatientsDtlForWebservicesSentHLP(MCPathLabSampleHandoverDetailFB fb) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		String strCrNo = "0";
		
		String strHidden_JSON="";
	
		
		try {
			
			wbResult = fb.getStrPatDtlsWs(); //crNo,patName,mob,gender||'/'||age,test_name,vialNo,hospName,testCode,reqNo,reqDate,episodeCode,nVialWiseTestsPerPatient--> order by hrgnum_puk,hrgstr_vial_no,hrgstr_test_name,hrgnum_requisition_no
			// br.append("<tbody>");
			br.append("<tbody id='myTable'>");

			if (wbResult != null && wbResult.size() > 0) {

				while (wbResult.next()) {
					
					strCrNo = wbResult.getString(1);
					
					strHidden_JSON =  wbResult.getString(6);
					
							
					br.append("<tr>");
					
					if(fb.getStrAPIStatus().equals("0")) // success
						br.append("<td width='10%' style='text-align:center;'><input type='checkbox' disabled name='strCheckALL' value=\"" + wbResult.getString(1)+"^"+wbResult.getString(7) +"\" /></td>");
					else						
						br.append("<td width='10%' style='text-align:center;'><input type='checkbox' name='strCheckALL' value=\"" + wbResult.getString(1)+"^"+wbResult.getString(7) +"\" /></td>");
					
							
							br.append("<td width='10%' style='text-align:center;'>" + wbResult.getString(1) + "</td>");
							br.append("<td width='15%' style='text-align:center;'>" + wbResult.getString(2) + " </td>");
							br.append("<td width='10%' style='text-align:center;'>" + wbResult.getString(3) + "</td>");
							br.append("<td width='20%' style='text-align:center;'>" + wbResult.getString(4) + "</td>");
							br.append("<td width='20%' style='text-align:left;'>" + wbResult.getString(5) + "</td>");
							br.append("<td width='20%' style='text-align:left;'>" + wbResult.getString(8) + "</td></tr>");
							
							br.append("<input type='hidden' name='strHiddenValues' value='" + strHidden_JSON +"' />");
			} 
			}
				
			else {
				br.append("<tr>");
				br.append("<td width='100%' colspan='5'>No Record Found</td>");
				br.append("</tr>");
			}

			br.append("</tbody>");

		} catch (Exception _err) {
			_err.printStackTrace();
			fb.setStrMsgString("MCPathLabSampleHandoverDetailTransMcNewDATA.getPatientsDtl() --> " + _err.getMessage());
			fb.setStrMsgType("1");
		}
		return br.toString();
	}


/*
	public static void getPresDrugDtlNew(MCPathLabSampleHandoverDetailFB formBean, HttpServletRequest request) {
		try {
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			MCPathLabSampleHandoverDetailMcNewDAO.getPresDtls(formBean);
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());

			formBean.setStrPatDtl(getPresDrugDtls(formBean));
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPresDrugDtls(MCPathLabSampleHandoverDetailFB fb) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		String strPresHidDtls = "";

		try {
			int nTmpJ = 0;
			wbResult = fb.getStrPresDtlsWs();

			if (wbResult != null && wbResult.size() > 0) {

				while (wbResult.next()) {

//					Hmis ItembrandId ^ DosageId ^ Days ^ FrequencyId ^ DoseQty ^ EpisodeCode ^ DeptCode ^ Dept Unit Code ^ Issue Qty ^ Balance Qty 
//					^ SNo ^ VisitNo ^ Eaushadhi ItembrandId
					strPresHidDtls = wbResult.getString(4) + "^" + wbResult.getString(6) + "^" + wbResult.getString(8)
							+ "^" + wbResult.getString(10) + "^" + wbResult.getString(9) + "^" + wbResult.getString(3)
							+ "^" + wbResult.getString(12) + "^" + wbResult.getString(13) + "^" + wbResult.getString(14)
							+ "^" + wbResult.getString(15) + "^" + wbResult.getString(16) + "^" + wbResult.getString(17)
							+ "^" + wbResult.getString(18);

					br.append("<div class='col-sm-1'>" + (nTmpJ + 1) + ".</div>");
					br.append("<div class='col-sm-3'>" + wbResult.getString(5));
					br.append("<input type='hidden' name='strPresHidDtls' id='strPresHidDtls" + nTmpJ + "' value='"
							+ strPresHidDtls + "' >");
					br.append("</div>");
					br.append("<div class='col-sm-1'>" + wbResult.getString(7) + "</div>");
					br.append("<div class='col-sm-1'>" + wbResult.getString(8) + "</div>");
					br.append("<div class='col-sm-1'>" + wbResult.getString(11) + "</div>");
					br.append("<div class='col-sm-2'>" + wbResult.getString(9) + "</div>");
					br.append("<div class='col-sm-1'><span id='issueQtySpanId" + nTmpJ + "'>0</span></div>");
//					br.append("<div class='col-sm-2'>"+wbResult.getString(15)+"</div>"); //Balance Qty
					br.append("<div class='col-sm-1'>" + "<span title='Add/Modify' onclick='editPresDrug(\""
							+ wbResult.getString(18) + "\"," + nTmpJ
							+ ");' ><i class='fas fa-edit' style='color:blue;' aria-hidden='true'></i></span>"
							+ "</div>");
					br.append("<div class='col-sm-1'>" + "<img id='checkImgId" + nTmpJ
							+ "' class='img-fluid' src='/HIS/hisglobal/images/avai/check.png' alt='Responsive image' style='display:none;'>"
							+ "</div>");
					nTmpJ++;
				}
			} else {
				br.append("<div class=\"col-sm-12\">");
				br.append("No Records Available");
				br.append("</div>");
			}

		} catch (Exception _err) {
			_err.printStackTrace();
			fb.setStrMsgString("IssueToPatientTransMcNewDATA.getPresDrugDtls() --> " + _err.getMessage());
			fb.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getPatientsIssuedDtl(MCPathLabSampleHandoverDetailFB fb) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;

		try {
			int nTmpJ = 0;
			wbResult = fb.getStrPatIssueDtlsWs();
			// br.append("<tbody>");
			br.append("<tbody id='myTable'>");

			if (wbResult != null && wbResult.size() > 0) {

				while (wbResult.next()) {

					if (wbResult.getString(6).equals("0"))
						br.append("<tr style='background:lavender;'>");
					else
						br.append("<tr>");

					br.append("<td width='10%' style='text-align:center;'>" + (nTmpJ + 1) + ".</td>");
					br.append("<td width='20%' style='text-align:left;'>" + wbResult.getString(2) + "</td>");
					br.append("<td width='15%' style='text-align:center;'>" + wbResult.getString(1) + "</td>");
					br.append("<td width='20%' style='text-align:center;'>" + wbResult.getString(3) + " / "
							+ wbResult.getString(4) + " / " + wbResult.getString(5) + "</td>");
					br.append("<td width='20%' style='text-align:center;'>" + wbResult.getString(16) + "</td>"); // wbResult.getString(7)+"
																													// /
																													// "+
					br.append("<td width='15%' style='text-align:center;'>");

//					if(wbResult.getString(8).equals("0")) {
//						br.append("<img class='img-fluid' src='/HIS/hisglobal/images/avai/GO.png' "
//								+ "onclick='openIssueDtl("+nTmpJ+");' alt='Responsive image' style='cursor:pointer;height:20px;'>");
//					}	

					br.append("</td>");

					br.append("<input type='hidden' id='strHiddenDtl" + nTmpJ + "' name='strHiddenDtl' " + "value='"
							+ wbResult.getString(1) + "' />");

					// EpisodeCode ^ VisitNo ^ HospCode ^ DeptCode ^ Dept Unit Code
					String dtls = wbResult.getString(9) + "^" + wbResult.getString(10) + "^" + wbResult.getString(13)
							+ "^" + wbResult.getString(14) + "^" + wbResult.getString(15);

					br.append("<input type='hidden' id='hiddenOtherDtl" + nTmpJ + "' name='hiddenOtherDtl' " + "value='"
							+ dtls + "' />");

					br.append("</tr>");

					nTmpJ++;
				}
			} else {
				br.append("<tr>");
				br.append("<td width='100%' colspan='5'>No Record Found</td>");
				br.append("</tr>");
			}

			br.append("</tbody>");

		} catch (Exception _err) {
			_err.printStackTrace();
			fb.setStrMsgString("IssueToPatientTransMcNewDATA.getPatientsIssuedDtl() --> " + _err.getMessage());
			fb.setStrMsgType("1");
		}
		return br.toString();
	}
*/
}
