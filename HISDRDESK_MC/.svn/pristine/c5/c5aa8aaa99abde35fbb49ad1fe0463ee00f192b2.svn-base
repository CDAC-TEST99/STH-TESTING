package new_opd.transaction.controller.data;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import new_opd.DAO.MCPathLabSampleDrawnDetailDAO;
//import new_opd.transaction.bo.IssueResponse;
import new_opd.transaction.controller.fb.MCPathLabSampleDrawnDetailFB;

public class MCPathLabSampleDrawnDetailDATA {

	
	public static void onSave(MCPathLabSampleDrawnDetailFB fb) {

//		System.out.println("crDtls >> "+crDtls);
//			for (int i = 0; i < fb.getStrVialNo().length; i++) {
//				System.out.println("vialDtls >> "+fb.getStrVialNo()[i]);
//				System.out.println("testCodeDtls >> "+fb.getStrTestCode()[i]);
//			}		

//		fb.setStrIssueNo(eAushadhiIssueId);

		try {
			MCPathLabSampleDrawnDetailDAO.saveVialDtls(fb);
		} catch (Exception e) {

			fb.setStrErrMsg("Error Occured, Please Contact System Administrator");

		}
		fb.setStrNormalMsg("Data Saved Successfully!!!");
	}

	
	
	public static void getPatientsDtlNew(MCPathLabSampleDrawnDetailFB formBean, HttpServletRequest request) 
	{
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		
		try 
		{
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
            c1 = Calendar.getInstance();	    
            c1.add(Calendar.DATE,0);
            
            if(formBean.getStrVisitDate()==null || formBean.getStrVisitDate().trim().equals("") || formBean.getStrVisitDate().trim().equals("0"))
            {
            	formBean.setStrCtDate(sdf.format(c1.getTime()));
            	formBean.setStrVisitDate(formBean.getStrCtDate());
            }	
            else
            	formBean.setStrCtDate(formBean.getStrVisitDate());

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			//formBean.setStrVialSeries(request.getParameter("vialSeries"));
			//System.out.println("vialSeries::"+request.getParameter("vialSeries"));
			
			MCPathLabSampleDrawnDetailDAO.getPatientsDtl(formBean);
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
	
	public static void getPrescribedTestDtl(MCPathLabSampleDrawnDetailFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		
		try 
		{
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
            c1 = Calendar.getInstance();	    
            c1.add(Calendar.DATE,0);
            
            if(formBean.getStrVisitDate()==null || formBean.getStrVisitDate().trim().equals("") || formBean.getStrVisitDate().trim().equals("0"))
            {
            	formBean.setStrCtDate(sdf.format(c1.getTime()));
            	formBean.setStrVisitDate(formBean.getStrCtDate());
            }	
            else
            	formBean.setStrCtDate(formBean.getStrVisitDate());
			
            formBean.setStrHiddenOtherDtl(new String(Base64.getDecoder().decode((String) request.getParameter("hiddenOtherDtl"))));
         //   formBean.setStrVialSeries(request.getParameter("vialSeries"));
//            System.out.println("str::"+formBean.getStrHiddenOtherDtl());//860012300054060^3786001^8600110076230905100006^05-Sep-2023
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
				
			MCPathLabSampleDrawnDetailDAO.getPrescribedTestDtl(formBean);
			if (formBean.getStrMsgType().equals("1")) 
				throw new Exception(formBean.getStrMsgString());
			
			formBean.setStrPatInvDtl(getPrescribedTestDtlHlp(formBean));
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());
			
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(formBean.getStrPatInvDtl());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void checkDuplicateVial(MCPathLabSampleDrawnDetailFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{
		String strVialCount="0";
		
		try 
		{
			//System.out.println("currentVialNo::"+request.getParameter("currentVialNo"));
			//System.out.println("index::"+request.getParameter("index"));
			//System.out.println("vialSeriesDUplicateVial::"+request.getParameter("vialSeries"));
			//formBean.setStrVialSeries(request.getParameter("vialSeries"));
			
			formBean.setCurrentVialNo(request.getParameter("currentVialNo"));
			
			//System.out.println("checkVIal DATA ::"+request.getParameter("completeVial"));
			
			formBean.setStrCompleteVial(request.getParameter("completeVial"));
			
			//System.out.println("CURERNT"+formBean.getCurrentVialNo());
			
			MCPathLabSampleDrawnDetailDAO.checkDuplicateVial(formBean);
			
			if(formBean.getStrPatTestDtlsWs()!=null && formBean.getStrPatTestDtlsWs().size()>0)
			{
				if(formBean.getStrPatTestDtlsWs().next())
					strVialCount = formBean.getStrPatTestDtlsWs().getString(1);
			}
			
			
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strVialCount+"^"+request.getParameter("index"));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	
		
	}
	
	
	public static String getPatientsDtl(MCPathLabSampleDrawnDetailFB fb) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		
		try {
			int nTmpJ = 0;			
			wbResult = fb.getStrPatDtlsWs();
			//br.append("<tbody>");
			br.append("<tbody id='myTable'>");
//			hrgnum_puk,hrgstr_pat_name,hrgnum_mobile_no,gstr_gender_code||''/''||hrgstr_age,
//			gstr_hosp_name,hrgnum_requisition_no,to_char(hrgdt_requisition_date,''dd-Mon-yyyy'') as requisition_date
			if(wbResult != null && wbResult.size()>0) {				
				
				while (wbResult.next()) {					
					
					//hrgnum_puk ^ hospCode ^ hrgnum_requisition_no ^ hrgdt_requisition_date
					String dtls = wbResult.getString(1) +"^"+ fb.getStrHospitalCode() +"^"+ wbResult.getString(6) +"^"+ wbResult.getString(7);
					
					if(wbResult.getString(6).equals("0"))
						br.append("<tr style='background:lavender;'>");
					else
						br.append("<tr>");
					
					br.append("<td width='10%' style='text-align:center;'>"+(nTmpJ+1)+".</td>");
					br.append("<td width='10%' style='text-align:center;'><input type='radio' id='hiddenOtherDtl"+nTmpJ+"' name='hiddenOtherDtl' " + "value='"+dtls+"' onclick='openPrescribedTestDtl(\""+nTmpJ+"\");' /></td>");
					br.append("<td width='20%' style='text-align:center;'>"+wbResult.getString(1)+"</td>");
					br.append("<td width='20%' style='text-align:left;'>"+wbResult.getString(2)+"</td>");
					br.append("<td width='20%' style='text-align:center;'>"+wbResult.getString(4)+"</td>"); //wbResult.getString(7)+" / "+
					br.append("<td width='20%' style='text-align:center;'>"+wbResult.getString(3)+"</td>");
					
					/*
					 * if(wbResult.getString(8).equals("0")) {
					 * br.append("<img class='img-fluid' src='/HIS/hisglobal/images/avai/GO.png' " +
					 * "onclick='openIssueDtl("+
					 * nTmpJ+");' alt='Responsive image' style='cursor:pointer;height:20px;'>"); }
					 */					
					
					br.append("<input type='hidden' id='strHiddenDtl"+nTmpJ+"' name='strHiddenDtl' "+ "value='"+wbResult.getString(1)+"' />");
					
					
					br.append("</tr>");
					 
					nTmpJ++;
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
			fb.setStrMsgString("MCPathLabSampleDrawnDetailDATA.getPatientsDtl() --> "+ _err.getMessage());
			fb.setStrMsgType("1");
		}
		return br.toString();
	}
	
	/*
	public static void getPresDrugDtlNew(MCPathLabSampleDrawnDetailFB formBean, HttpServletRequest request) 
	{		
		try 
		{			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			MCPathLabSampleDrawnDetailDAO.getPresDtls(formBean);
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
	
	
	public static String getPresDrugDtls(MCPathLabSampleDrawnDetailFB fb) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		String strPresHidDtls = "";
		
		try {
			int nTmpJ = 0;			
			wbResult = fb.getStrPresDtlsWs();
			
			if(wbResult != null && wbResult.size()>0) {				
				
				while (wbResult.next()) {	
					
//					Hmis ItembrandId ^ DosageId ^ Days ^ FrequencyId ^ DoseQty ^ EpisodeCode ^ DeptCode ^ Dept Unit Code ^ Issue Qty ^ Balance Qty 
//					^ SNo ^ VisitNo ^ Eaushadhi ItembrandId
					strPresHidDtls = wbResult.getString(4) +"^"+ wbResult.getString(6) +"^"+ wbResult.getString(8) +"^"+ wbResult.getString(10) 
						+"^"+ wbResult.getString(9) +"^"+ wbResult.getString(3) +"^"+ wbResult.getString(12) +"^"+ wbResult.getString(13) 
						+"^"+ wbResult.getString(14) +"^"+ wbResult.getString(15) +"^"+ wbResult.getString(16) +"^"+ wbResult.getString(17) 
						+"^"+ wbResult.getString(18);
					
					br.append("<div class='col-sm-1'>"+(nTmpJ+1)+".</div>");
					br.append("<div class='col-sm-3'>"+wbResult.getString(5));
					br.append("<input type='hidden' name='strPresHidDtls' id='strPresHidDtls"+nTmpJ+"' value='"+strPresHidDtls+"' >");
					br.append("</div>");
					br.append("<div class='col-sm-1'>"+wbResult.getString(7)+"</div>");
					br.append("<div class='col-sm-1'>"+wbResult.getString(8)+"</div>");
					br.append("<div class='col-sm-1'>"+wbResult.getString(11)+"</div>");
					br.append("<div class='col-sm-2'>"+wbResult.getString(9)+"</div>");
					br.append("<div class='col-sm-1'><span id='issueQtySpanId"+nTmpJ+"'>0</span></div>");
//					br.append("<div class='col-sm-2'>"+wbResult.getString(15)+"</div>"); //Balance Qty
					br.append("<div class='col-sm-1'>"
							+ "<span title='Add/Modify' onclick='editPresDrug(\""+wbResult.getString(18)+"\","+nTmpJ+");' ><i class='fas fa-edit' style='color:blue;' aria-hidden='true'></i></span>"
							+ "</div>");
					br.append("<div class='col-sm-1'>"
							+ "<img id='checkImgId"+nTmpJ+"' class='img-fluid' src='/HIS/hisglobal/images/avai/check.png' alt='Responsive image' style='display:none;'>"
							+ "</div>");
					nTmpJ++;
				}
			}
			else {
				br.append("<div class=\"col-sm-12\">");
				br.append("No Records Available");
				br.append("</div>");
			}

		} catch (Exception _err) {
			_err.printStackTrace();
			fb.setStrMsgString("MCPathLabSampleDrawnDetailDATA.getPresDrugDtls() --> "+ _err.getMessage());
			fb.setStrMsgType("1");
		}
		return br.toString();
	}
	*/
	
	public static String getPrescribedTestDtlHlp(MCPathLabSampleDrawnDetailFB fb) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		
		try {
			int nTmpJ = 0,nCount=0;
			String strContainerTypeId = "0",strPrevContainerTypeId="0";
			String strContainerType = "";
			String strColor="";
			int nContainerGroupNo=0;
			wbResult = fb.getStrPatTestDtlsWs();
			//br.append("<tbody>");
			br.append("<table class=\"table\" >");
			br.append("<tbody id='myTable'>");
			
			//System.out.println("fb.getStrVialSeries()"+fb.getStrVialSeries());
			// testCode,testName,strContainerTypeId, strContainerType Name, Container Image
			if(wbResult != null && wbResult.size()>0) {
				
				while (wbResult.next()) {					
					
					strContainerTypeId = wbResult.getString(3);
					
					if(strContainerTypeId.equalsIgnoreCase("0"))
						continue;
					
//					if(wbResult.getString(6).equals("0"))
						br.append("<tr>"); //style='background:lavender;'
//					else
//						br.append("<tr>");
						
						if(!strContainerTypeId.equalsIgnoreCase(strPrevContainerTypeId))
						{	
							strContainerType =((wbResult.getString(5)!=null && !wbResult.getString(5).equals(""))?"<img class='img-fluid' src='/HISDRDESK_MC/new_opd/img/"+wbResult.getString(5)+"'  style='cursor:pointer;height:20px;width:20px;'>":"")+ "  " +wbResult.getString(4) ;
							nTmpJ = 0;
							
							
							if(nContainerGroupNo++%2==1)
								strColor="lightgrey";
							else
								strColor="";
						}		
						else
						{
							strContainerType ="";							
						}	
							
					br.append("<td width='10%' bgcolor='"+strColor+"' style='text-align:left;'>"+strContainerType+ "</td>");
					
					if(!strContainerType.equals(""))
						br.append("<td width='10%' bgcolor='"+strColor+"' style='text-align:center;'><input type='checkbox' id='strTestCode"+strContainerTypeId+"-"+nTmpJ+"' name='strTestCode' " + "value='"+wbResult.getString(1)+"^"+wbResult.getString(3)+"' onclick='onClickTestDtl(\""+nCount+"\");' /></td>");
					else
						br.append("<td width='10%' bgcolor='"+strColor+"' style='text-align:center;'><input type='hidden' id='strTestCode"+strContainerTypeId+"-"+nTmpJ+"' name='strTestCode' " + "value='"+wbResult.getString(1)+"^"+wbResult.getString(3)+"' /></td>");
					
					br.append("<td width='20%' bgcolor='"+strColor+"' style='text-align:center;'>"+wbResult.getString(2)+"</td>");
					
					if(!strContainerTypeId.equalsIgnoreCase(strPrevContainerTypeId)) {
						br.append("<td width='15%' bgcolor='"+strColor+"' style='text-align:center;'>"+"  <input type='text' id='strVialNo"+strContainerTypeId+"-"+nTmpJ+"' name='strVialNo' readonly "
								+ "onblur='onBlurMethod(\""+strContainerTypeId+"-"+nTmpJ+"\") ; validateInputLength(\"" + strContainerTypeId + "-" + nTmpJ + "\");'"
								+"onkeypress=\"return validateData(event,23);\" maxlength='8' value=''/></td>");
					}
					
					else {
						br.append("<td width='15%' bgcolor='"+strColor+"' style='text-align:center;'><input type='hidden' id='strVialNo"+strContainerTypeId+"-"+nTmpJ+"' name='strVialNo' value=''/></td>");
					}
					
					//br.append("<input type='hidden' id='strVialSeries"+nTmpJ+"' name='strVialSeries' "+ "value='"+fb.getStrVialSeries()+"' />");
										

//					br.append("<td width='15%' style='text-align:center;'>");
					
//					if(wbResult.getString(8).equals("0")) {
//						br.append("<img class='img-fluid' src='/HIS/hisglobal/images/avai/GO.png' "
//								+ "onclick='openIssueDtl("+nTmpJ+");' alt='Responsive image' style='cursor:pointer;height:20px;'>");
//					}	
					
//					br.append("</td>");
					
//					br.append("<input type='hidden' id='strHiddenDtl"+nTmpJ+"' name='strHiddenDtl' "+ "value='"+wbResult.getString(1)+"' />");
					
					//EpisodeCode ^ VisitNo ^ HospCode ^ DeptCode ^ Dept Unit Code
//					String dtls = wbResult.getString(9) +"^"+ wbResult.getString(10) +"^"+ wbResult.getString(13) +"^"+ wbResult.getString(14)+"^"+ wbResult.getString(15);
					
//					br.append("<input type='hidden' id='hiddenOtherDtl"+nTmpJ+"' name='hiddenOtherDtl' "+ "value='"+dtls+"' />");
					
					br.append("</tr>");
					 
					nTmpJ++;
					nCount++;
					strPrevContainerTypeId = strContainerTypeId;
				}
				br.append("</table>");
			}
			else {
				br.append("<tr>");
				br.append("<td width='100%' colspan='5'>No Record Found</td>");
				br.append("</tr>");
			}
			
			br.append("</tbody>");

		} catch (Exception _err) {
			_err.printStackTrace();
			fb.setStrMsgString("MCPathLabSampleDrawnDetailDATA.getPatientsIssuedDtl() --> "+ _err.getMessage());
			fb.setStrMsgType("1");
		}
		return br.toString();
	}

}
