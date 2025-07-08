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
import new_investigation.transactions.controller.fb.InvOfflineResultEntryFB;
import new_investigation.transactions.controller.utl.InvOfflineResultEntryUTIL;

public class InvOfflineResultEntryACT extends TokenConfig {	

public ActionForward unspecified(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
		throws SQLException, IOException, ServletException
{
	generateToken(request);
	//HttpSession session=WebUTIL.getSession(request);
	//WebUTIL.refreshTransState(request);
	return this.NEW(mapping,form,request,response);
}

public ActionForward NEW(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
		throws SQLException, IOException, ServletException
{
	generateToken(request);
	InvOfflineResultEntryFB fb=(InvOfflineResultEntryFB)form;
	
	fb.setStrParentHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
	
	InvOfflineResultEntryUTIL.getEssential(fb,request);
	return mapping.findForward("NEW");
}
		
public ActionForward AJX_TEST_DTL(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
		HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
{
	System.out.println("in AJX_TEST_DTL");
	generateToken(objRequest_p);
	InvOfflineResultEntryFB fb=(InvOfflineResultEntryFB)objForm_p;			
	InvOfflineResultEntryUTIL.pouplateTestDetails(fb, objRequest_p,objResponse_p);	
	return null;
}

//Added By Deepti to Insert the offline result Entry records. 18.01.2021

public ActionForward insert(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
		HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
 {
	InvOfflineResultEntryFB fb;
	try {

			fb = (InvOfflineResultEntryFB)objForm_p;
			fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			InvOfflineResultEntryUTIL.insertOffllineResultEntry(fb,objRequest_p);
		}
	catch (Exception e)
		{
			e.printStackTrace();
		}
	return this.unspecified(objMapping_p, objForm_p, objRequest_p, objResponse_p);
 }

//Added By Deepti to show the offline result Entry records. 21.01.2021  
public ActionForward viewResultEntries(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
		HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
 {
	try {
			InvOfflineResultEntryFB fb;
			fb = (InvOfflineResultEntryFB)objForm_p;
			
			//Get Hospital Code & SeatId of User from the Session.
			fb.setHospitalcode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			
			InvOfflineResultEntryUTIL.viewResultEntriesList(fb,objRequest_p);
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		String target = "VIEWRESULTENTRY";
		return objMapping_p.findForward(target);
 }

 public ActionForward showPatientDetail(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
		HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
 {
	try {
		InvOfflineResultEntryFB fb = (InvOfflineResultEntryFB)objForm_p;		
		fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
		InvOfflineResultEntryUTIL.showPatientDetail(fb,objRequest_p);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	String target = "VIEWRESULTENTRY";
	return objMapping_p.findForward(target);
 } 

 public ActionForward getuploadedfile(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
	 System.out.println("1+++++++++++++++");
	 
	 	InvOfflineResultEntryFB formBean = (InvOfflineResultEntryFB) form;
	 	formBean.setStrParentHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
	 	InvOfflineResultEntryUTIL.DownloadFile(formBean, request, response);
		return null;

	}
 
 
 public ActionForward viewResultEntries_onHospChange(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, SQLException, IOException, ServletException {
	 
	 	InvOfflineResultEntryFB formBean = (InvOfflineResultEntryFB) objForm_p;
	 	formBean.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
	 	formBean.setHospitalcode(objRequest_p.getParameter("hosp_code"));
	 	formBean.setFromDate(objRequest_p.getParameter("from_dt"));
	 	formBean.setToDate(objRequest_p.getParameter("to_dt"));
	 	
	 	InvOfflineResultEntryUTIL.viewResultEntries_onHospChange(formBean, objRequest_p);
	 	
	 	objResponse_p.setContentType("text/html");  
	 	objResponse_p.setCharacterEncoding("UTF-8"); 
	 	objResponse_p.getWriter().write(formBean.getStrOfflineResEntPatDtl()); 
	    
		return null;

	}
 
 public ActionForward getRegisteredPatientDetail(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
	 {
	 	InvOfflineResultEntryFB fb = (InvOfflineResultEntryFB)objForm_p;	
		try {
			fb.setPatCRNo(objRequest_p.getParameter("cr_no"));
			fb.setPatMobNo(objRequest_p.getParameter("mob_no"));
			fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			
			InvOfflineResultEntryUTIL.getAllPatListResultEntry(fb, objRequest_p);
			//InvOfflineResultEntryUTIL.getRegisteredPatientDtl(fb,objRequest_p);
			
			objResponse_p.setContentType("text/plain");  
		 	objResponse_p.setCharacterEncoding("UTF-8"); 
		 	objResponse_p.getWriter().write(fb.getStrMultiPatList()); 
		 	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	 } 
 
 public ActionForward saveAlreadyRegPat(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
	 {
	 	InvOfflineResultEntryFB fb;
	try {

			fb = (InvOfflineResultEntryFB)objForm_p;
			fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			InvOfflineResultEntryUTIL.insertAlreadyRegPat(fb,objRequest_p);
		}
	catch (Exception e)
		{
			e.printStackTrace();
		}
	return this.unspecified(objMapping_p, objForm_p, objRequest_p, objResponse_p);
	 }
 
 public ActionForward modify(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		generateToken(request);
		InvOfflineResultEntryFB fb=(InvOfflineResultEntryFB)form;
		
		fb.setStrParentHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		InvOfflineResultEntryUTIL.getPatDtlsForModify(fb,request);
		return mapping.findForward("MODIFY");
	}
 
 public ActionForward updatePatientDtl(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
	 {
		InvOfflineResultEntryFB fb;
		try {

				fb = (InvOfflineResultEntryFB)objForm_p;
				fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
				fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
				InvOfflineResultEntryUTIL.updateOffllineResultEntry(fb,objRequest_p);
			}
		catch (Exception e)
			{
				e.printStackTrace();
			}
		return this.unspecified(objMapping_p, objForm_p, objRequest_p, objResponse_p);
	 }
 
 public ActionForward isDuplicacyReqd(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
	 {
	 	InvOfflineResultEntryFB fb = (InvOfflineResultEntryFB)objForm_p;	
		try {
			
			fb.setStrPatHospCode(objRequest_p.getParameter("hospCode"));
			fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			String isDupChkRqd = InvOfflineResultEntryUTIL.isDuplicacyReqd(fb,objRequest_p);
			
			objResponse_p.setContentType("text/plain");  
		 	objResponse_p.setCharacterEncoding("UTF-8"); 
		 	objResponse_p.getWriter().write(isDupChkRqd); 
		 	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	 } 
 
 public ActionForward getDuplicateRecord(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, Exception, SQLException
	 {
	 	InvOfflineResultEntryFB fb = (InvOfflineResultEntryFB)objForm_p;	
		try {
			fb.setPatName(objRequest_p.getParameter("p_name"));
			fb.setStrPatAge(objRequest_p.getParameter("p_age"));
			fb.setStrPatAgeUnit(objRequest_p.getParameter("p_ageUnit"));
			fb.setPatGenderCode(objRequest_p.getParameter("p_gender"));
			fb.setPatGuardianName(objRequest_p.getParameter("p_guadianName"));
			fb.setPatMobNo(objRequest_p.getParameter("p_mob"));
			fb.setStrPatHospCode(objRequest_p.getParameter("p_hospCode"));
			
			fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			
			InvOfflineResultEntryUTIL.getDuplicatePatientDtl(fb,objRequest_p);
			
			objResponse_p.setContentType("text/plain");  
		 	objResponse_p.setCharacterEncoding("UTF-8"); 
		 	objResponse_p.getWriter().write(fb.getStrDupPatList()); 
		 	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	 } 
}
