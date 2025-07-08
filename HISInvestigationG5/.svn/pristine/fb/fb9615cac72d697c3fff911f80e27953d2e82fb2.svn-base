/*
 * Author: DEEPTI AGRAWAL
 * 
 * Process Name: VIEW RESULT REPORT (OFFLINE RESULT ENTRY)
 * 
 * Created on: 28.01.2021
 */

package new_investigation.transactions.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.TokenConfig;
import hisglobal.backutil.HisException;
import hisglobal.presentation.ControllerUTIL;
import hisglobal.utility.Base64Utils;
import hisglobal.vo.UserVO;
import new_investigation.transactions.controller.fb.InvOfflineResultEntryFB;
import new_investigation.transactions.controller.fb.NEWOfflineResultEntryFB;
import new_investigation.transactions.controller.utl.InvOfflineResultEntryUTIL;

public class InvOfflineResultEntryViewACT extends TokenConfig{
	

	/**
	 * forwards control to the Page invOfflineResultEntryViewPrintReport.jsp
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	
 	
	
	public ActionForward unspecified(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		//generateToken(request);
		InvOfflineResultEntryFB fb = (InvOfflineResultEntryFB)form;
				String primaryKey=request.getParameter("primaryKey");
				
				if(primaryKey!=null) {
					String patCrNo=Base64Utils.decode(primaryKey).split("@")[1];
					fb.setPatCRNo(patCrNo);
					fb.setPatCrNo(patCrNo);
					request.setAttribute("patCrNo", patCrNo);
					  System.out.println("patCrNo"+fb.getPatCRNo());
					return this.NEW(mapping,form,request,response);
					
					
				}
				
				
		
		
		return this.NEW(mapping,form,request,response);
	}
	
	public ActionForward NEW(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		try {
			InvOfflineResultEntryFB fb = (InvOfflineResultEntryFB)form;
			
			
			
			   UserVO userVO = ControllerUTIL.getUserVO(request); String
			  hospitalCode=userVO.getHospitalCode();
			  System.out.println("newhospitalcodeis:"+hospitalCode);
			
			//fb.setHospitalcode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  fb.setHospitalcode(hospitalCode);
			  System.out.println("patCrNo"+fb.getPatCRNo());
			System.out.println("HospitalCode---"+fb.getHospitalcode());
			fb.setSeatId(request.getSession().getAttribute("SEATID").toString());
			
			InvOfflineResultEntryUTIL.viewResultEntriesListForReportView(fb,request);
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		String target = "NEW";
		return mapping.findForward(target);
	}
	
	//Method to get the Demographic and Test Details of Patient for the provided CR number.
	
	public ActionForward showPatientDetail(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
	 {
		try {
			InvOfflineResultEntryFB fb = (InvOfflineResultEntryFB)objForm_p;	
			
			fb.setPatCRNo(objRequest_p.getParameter("cr_no"));
			fb.setPatMobNo(objRequest_p.getParameter("mob_no"));
			fb.setPatName(objRequest_p.getParameter("p_name"));
			fb.setPatGenderCode(objRequest_p.getParameter("p_gender"));
			fb.setStrPatAge(objRequest_p.getParameter("p_age"));
			fb.setStrPatAgeUnit(objRequest_p.getParameter("p_ageunit"));
			fb.setPatGuardianName(objRequest_p.getParameter("p_guardian"));
			fb.setStrPatHospCode(objRequest_p.getParameter("p_coll_centre"));
			fb.setStrParentHospitalCode(objRequest_p.getParameter("p_parent_hospital"));
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			
			InvOfflineResultEntryUTIL.showPatientDetail(fb,objRequest_p);
			
			objResponse_p.setContentType("text/html");  
		 	objResponse_p.setCharacterEncoding("UTF-8"); 
		 	objResponse_p.getWriter().write(fb.getStrOfflineResEntPatDtl()); 
		 	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * String target = "NEW"; return objMapping_p.findForward(target);
		 */
		
		return null;
	 } 
	
	
	public ActionForward getAllPatList(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
	 {
		try {
			InvOfflineResultEntryFB fb = (InvOfflineResultEntryFB)objForm_p;	
			
			fb.setPatCRNo(objRequest_p.getParameter("cr_no"));
			fb.setPatMobNo(objRequest_p.getParameter("mob_no"));
			fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			
			InvOfflineResultEntryUTIL.getAllPatList(fb,objRequest_p);
			
			objResponse_p.setContentType("text/html");  
		 	objResponse_p.setCharacterEncoding("UTF-8"); 
		 	objResponse_p.getWriter().write(fb.getStrMultiPatList()); 
		 	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * String target = "NEW"; return objMapping_p.findForward(target);
		 */
		
		return null;
	 }
	//Method to download the Test Result Report.
	
	public ActionForward getuploadedfile(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
		System.out.println("2+++++++++");
	 
	 	InvOfflineResultEntryFB formBean = (InvOfflineResultEntryFB) form;
	 	//formBean.setStrParentHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
	 	
	 	UserVO userVO = ControllerUTIL.getUserVO(request); String
		  hospitalCode=userVO.getHospitalCode();
		  System.out.println("newhospitalcodeis:"+hospitalCode);
	 	formBean.setStrParentHospitalCode(hospitalCode);
	 	
	 	
	 	InvOfflineResultEntryUTIL.DownloadFile(formBean, request, response);
		return null;

	}
 

}
