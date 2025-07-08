package new_investigation.transactions.controller.action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
<!--
 
## Copyright Information				: C-DAC, Noida  
## Project Name				       		: NIMS
## Name of Developer		 			: PAWAN KUMAR B N
## Module Name					        : INVESTIGATION
## Process/Database Object Name	    	: Sample Collection

## Purpose						        : 
## Date of Creation						: 23-Feb-2015
## Modification Log						:				
## Modify Date					        :  
## Reason	(CR/PRS)			    	: 
## Modify By				        	: 


*/

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
//import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

import hisglobal.backutil.exception.HisException;
import hisglobal.hisconfig.Config;
import hisglobal.presentation.CSRFGardTokenAction;
import hisglobal.presentation.ControllerUTIL;
import hisglobal.presentation.Status;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.Base64Utils;
import hisglobal.utility.HTMLParsingUTIL;
import hisglobal.utility.HTMLToPDFUTIL;
import hisglobal.vo.UserVO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import new_investigation.transactions.controller.fb.NEWOfflineResultEntryFB;
//import new_investigation.transactions.controller.fb.NEWOfflineResultEntryFB;
//import new_investigation.transactions.controller.utl.NEWOfflineResultEntryUTL;
import new_investigation.transactions.controller.utl.NEWOfflineResultEntryUTL;
//import new_investigation.transactions.delegate.InvestigationEssentialOfflineDelegate;
import new_investigation.transactions.delegate.InvestigationEssentialOfflineDelegate;
import new_investigation.vo.NEWOfflineResultEntryVO;

public class NEWOfflineResultEntryACT extends CSRFGardTokenAction {
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
	//	generateToken(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		// HttpSession session=WebUTIL.getSession(request);
		// session.setAttribute("printDivContent", "");
		String primaryKey=request.getParameter("primaryKey");
		
		if(primaryKey!=null) {
			String patCrNo=Base64Utils.decode(primaryKey).split("@")[1];
			String episodecode=Base64Utils.decode(primaryKey).split("@")[2];
			String visitNo=Base64Utils.decode(primaryKey).split("@")[3];
			
		
	        fb.setPatEpisodeCode(episodecode);
	        fb.setPatVisitNo(visitNo);
	        // Set the visitNo in the bean
	      //  bean.setVisitNo(visitNo);
			
			request.setAttribute("patCrNo", patCrNo);
			System.out.println("");
			return this.PatientwiseDtl(mapping, form, request, response);
			
			
		}	
		
		
		return this.PATIENT_LISTING(mapping, form, request, response);
	}

	public ActionForward PATIENT_LISTING(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
	//	generateToken(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		NEWOfflineResultEntryUTL.initPatientListing(request, fb);

		return mapping.findForward("PATIENT_LISTING");
	}

	public void GET_PATIENT_LIST(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
	//	generateToken(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		
	
		
		/*
		 * HttpSession objSession_p = request.getSession(); String
		 * hospital_codenew=(String) objSession_p.getAttribute(HISConfig.HOSPITAL_VO);
		 * System.out.println("hospital_codenew"+hospital_codenew);
		 * fb.setHospitalCode(hospital_codenew);
		 */
		 

		
		/*  HttpSession objSession_p = request.getSession();
		  
		
		 * 
		 * 
		 * String client_code=(String) objSession_p.getAttribute("CLIENT_CODE"); String
		 * client_short_name=(String) objSession_p.getAttribute("CLIENT_SHORT_NAME");
		 * String client_name=(String) objSession_p.getAttribute("CLIENT_NAME"); String
		 * client_start_year=(String) objSession_p.getAttribute("CLIENT_START_YEAR");
		 * 
		 * 
		 * System.out.println("client_code"+client_code+"client_short_name"+
		 * client_short_name+"client_start_year"+client_start_year+"client_name"+
		 * client_name); fb.setVarClientId(client_code);
		 * fb.setVarclientshort(client_short_name); System.out.println("clientshortt"+
		 * fb.getVarclientshort());
		 * //fb.setGetVarClientShort(objSession_p.getAttribute("CLIENT_SHORT_NAME"));
		 * request.setAttribute("clientShortName", fb.getVarclientshort());
		 */
		 

		NEWOfflineResultEntryUTL.getPatientListPageData(request, response, fb);

	}

	public void GET_EPISODE_LIST(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
	//	generateToken(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		//String crNoInput=fb.getCrNoInput();
		
	   String patcrno=request.getParameter("patCrNo");
	   fb.setCrNoInput(patcrno);
	
	   
	   /*for entry of lab test
	    * 
	    */
	   
		String patcrnum=request.getParameter("ptcr");
	
		request.setAttribute("patCrNum", patcrnum);
		
		NEWOfflineResultEntryUTL.getEpisodeListData(request, response, fb);
	

	}

	public void SBX_AJX_TEST_DTL(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) {
	//	generateToken(objRequest_p);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) objForm_p;
		NEWOfflineResultEntryUTL.pouplateEpisodeTestDtl(objRequest_p, objResponse_p, fb);

	}

	/*
	 * public ActionForward EPI_AJX_TEST_DTL(ActionMapping objMapping_p, ActionForm
	 * objForm_p, HttpServletRequest objRequest_p, HttpServletResponse
	 * objResponse_p) throws HisException, Exception, SQLException {
	 * System.out.println("in EPI_AJX_TEST_DTL"); generateToken(objRequest_p);
	 * NEWOfflineResultEntryFB fb=(NEWOfflineResultEntryFB)objForm_p;
	 * NEWOfflineResultEntryUTL.pouplateTestDetails(fb, objRequest_p,objResponse_p);
	 * return null; }
	 */

	public ActionForward NEW(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		
		
		//generateToken(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		
		HttpSession objSession_p = request.getSession();
		
		
	

		String isDuplicateBarecodeprint = fb.getDuplicateBarcodeGeneration() == null ? ""
				: fb.getDuplicateBarcodeGeneration();

		if (fb.getShowStatus() != null) {
			if (fb.getShowStatus().equals("1")) {
				fb.setShowStatus("1");
			} else if (fb.getShowStatus().equals("3")) {
				fb.setShowStatus("0");
				fb.setIsSampleAreaSelected("");

			} else {

				fb.setShowStatus("0");
			}
		} else
			fb.setShowStatus("0");

		//
		if (fb.getIsSampleAreaSelected() != null) {
			if (fb.getIsSampleAreaSelected().equals("1")) {
				fb.setIsSampleAreaSelected("1");
			} else
				fb.setIsSampleAreaSelected("0");
		} else
			fb.setIsSampleAreaSelected("0");

		// session.removeAttribute(InvestigationConfig.COMPONENT_WISE_INDICATION_MAP);
		if (!fb.getIsSampleAreaSelected().equals("1")) {
			WebUTIL.refreshTransState(request);
			fb.setLabTestCodeArray("");
			NEWOfflineResultEntryUTL.getSampleCollectionArea(fb, request);
		} else {

			NEWOfflineResultEntryUTL.getPatList(fb, request);
			try {
				NEWOfflineResultEntryUTL.getEssential(fb, request);
			} catch (Exception e) {
				//
			}

		}

//		else if()
//		{    
//			InvOfflineResultEntryUTIL.getEssential(fb,request);
//		}

		fb.setDuplicateBarcodeGeneration("2");
		
		/*
		 * if (fb.getPatCrNo() != null || fb.getPatCrNo() != "") {
		 * 
		 * }
		 */
		return mapping.findForward("NEW");
	}
	
	
	
	
	
	
public ActionForward PatientwiseDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * String patcrnum=request.getParameter("ptcr");
		 * System.out.println("patcrnum"+patcrnum); 
		 * request.setAttribute("patCrNo",
		 * patcrnum);
		 */

	//String patcrnum=request.getParameter("patCrNo");
	//System.out.println("patcrnum"+patCrNo);
	//request.setAttribute("patCrNo", patcrnum);

		
	//	generateToken(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		
		HttpSession objSession_p = request.getSession();
		
		
	

		String isDuplicateBarecodeprint = fb.getDuplicateBarcodeGeneration() == null ? ""
				: fb.getDuplicateBarcodeGeneration();

		if (fb.getShowStatus() != null) {
			if (fb.getShowStatus().equals("1")) {
				fb.setShowStatus("1");
			} else if (fb.getShowStatus().equals("3")) {
				fb.setShowStatus("0");
				fb.setIsSampleAreaSelected("");

			} else {

				fb.setShowStatus("0");
			}
		} else
			fb.setShowStatus("0");

		//
		if (fb.getIsSampleAreaSelected() != null) {
			if (fb.getIsSampleAreaSelected().equals("1")) {
				fb.setIsSampleAreaSelected("1");
			} else
				fb.setIsSampleAreaSelected("0");
		} else
			fb.setIsSampleAreaSelected("0");

		// session.removeAttribute(InvestigationConfig.COMPONENT_WISE_INDICATION_MAP);
		if (!fb.getIsSampleAreaSelected().equals("1")) {
			WebUTIL.refreshTransState(request);
			fb.setLabTestCodeArray("");
			NEWOfflineResultEntryUTL.getSampleCollectionArea(fb, request);
			
			
		} else {

			NEWOfflineResultEntryUTL.getPatList(fb, request);
			try {
				NEWOfflineResultEntryUTL.getEssential(fb, request);
			} catch (Exception e) {
				//
			}

		}

//		else if()
//		{    
//			InvOfflineResultEntryUTIL.getEssential(fb,request);
//		}

		fb.setDuplicateBarcodeGeneration("2");
		
		/*
		 * if (fb.getPatCrNo() != null || fb.getPatCrNo() != "") {
		 * 
		 * }
		 */
		
		return mapping.findForward("patientdtl");
	}
	
	
	
	

	public ActionForward AJX_TEST_DTL(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, Exception, SQLException {
		System.out.println("in AJX_TEST_DTL ACT");
	//	generateToken(objRequest_p);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) objForm_p;
				
		NEWOfflineResultEntryUTL.pouplateTestDetails(fb, objRequest_p, objResponse_p);
		return null;
		
	}

	public ActionForward insert(ActionMapping objMapping_p, ActionForm objForm_p, HttpServletRequest objRequest_p,
			HttpServletResponse objResponse_p) throws HisException, Exception, SQLException {
		NEWOfflineResultEntryFB fb;
		try {

			fb = (NEWOfflineResultEntryFB) objForm_p;
			//fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			UserVO userVO = ControllerUTIL.getUserVO(objRequest_p);
			String hospitalCode=userVO.getHospitalCode();
			System.out.println("newhospitalcodeis:"+hospitalCode);
			fb.setStrParentHospitalCode(hospitalCode);
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			
			System.out.println("helllllllo");
			String patcrnum=objRequest_p.getParameter("patCrNum");

			objRequest_p.setAttribute("patCrNo", patcrnum);

			NEWOfflineResultEntryUTL.insertOffllineResultEntry(fb, objRequest_p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return this.unspecified(objMapping_p, objForm_p, objRequest_p,
		// objResponse_p);
		return this.NEW(objMapping_p, objForm_p, objRequest_p, objResponse_p);
	}

//	public ActionForward getuploadedfile(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
//	 
//		NEWOfflineResultEntryFB formBean = (NEWOfflineResultEntryFB) form;
//	 	formBean.setStrParentHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
//	 	NEWOfflineResultEntryUTL.DownloadFile(formBean, request, response);
//		return null;
//
//	}

	public ActionForward GETPATLIST(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("InvestigationRaisingDtlACT: GETPATList  ");
		// WebUTIL.refreshTransState(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		String mode = fb.getModebarcode();
		// fb.setShowStatus("0");

		NEWOfflineResultEntryUTL.getPatList(fb, request);
		System.out.println("Fb " + fb.getFromDate());
		fb.setPatCrNo(null);
		Date date1;
		Date date2;
		try {
			date1 = new SimpleDateFormat("dd-MMM-yyyy").parse(fb.getFromDate());
			date2 = new SimpleDateFormat("dd-MMM-yyyy").parse(fb.getToDate());
			WebUTIL.setAttributeInSession(request, Config.SELECTED_FROM_DATE, date1);
			WebUTIL.setAttributeInSession(request, Config.SELECTED_TO_DATE, date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fb.setModebarcode(mode);
		return mapping.findForward("NEW");
	}

	public ActionForward SHOWPATDETAILS(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("InvestigationRaisingDtlACT: SHOWPATDETAILS  ");
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		fb.setShowStatus("1");

		NEWOfflineResultEntryUTL.showPatDetails(fb, request);
		if (fb.getSampleAreaCode().equals("15"))
			fb.setFlagforipddesk("16");
		// fb.setFlagforipddesk("11");
		return mapping.findForward("NEW");
	}

	public ActionForward PAGINATION(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		Status objStatus = new Status();
		objStatus.add(Status.TRANSINPROCESS);
		WebUTIL.setStatus(request, objStatus);
		return mapping.findForward("NEW");
	}

	public ActionForward CANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		Status objStatus = new Status();
		objStatus.add(Status.NEW);
		WebUTIL.setStatus(request, objStatus);
		return mapping.findForward("NEW");
	}

	public ActionForward SAVE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = WebUTIL.getSession(request);
		validateToken(request, response);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;

		NEWOfflineResultEntryUTL.saveSampleCollectionDetails(fb, request);
		if (fb.getFlagforipddesk() != null && fb.getFlagforipddesk().equals("15"))
			fb.setFlagforipddesk("16");
		else
			fb.setShowStatus("0");
		session.removeAttribute("deskcrno");
		return this.NEW(mapping, form, request, response);
	}

	/**
	 * AJX_DUPLICACY_SAMPLENO Ajax Function for Checking Duplicacy
	 * 
	 * @param objMapping_p
	 * @param objForm_p
	 * @param objRequest_p
	 * @param objResponse_p
	 * @return
	 * @throws Exception,HisException,SQLException
	 */
	public ActionForward AJX_DUPLICACY_SAMPLENO(ActionMapping objMapping_p, ActionForm objForm_p,
			HttpServletRequest objRequest_p, HttpServletResponse objResponse_p)
			throws HisException, Exception, SQLException {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) objForm_p;

		StringBuffer strBuff = NEWOfflineResultEntryUTL.checkSampleNoDuplicacy(fb, objRequest_p);
		objResponse_p.setHeader("Cache-Control", "no-cache");
		objResponse_p.getWriter().print(strBuff.toString());
		return null;
	}

	/**
	 * AJX_CHECK_AUTO_SAMPLENO_GEN Ajax Function for Checking Duplicacy
	 * 
	 * @param objMapping_p
	 * @param objForm_p
	 * @param objRequest_p
	 * @param objResponse_p
	 * @return
	 * @throws Exception,HisException,SQLException
	 */
	public ActionForward AJX_CHECK_AUTO_SAMPLENO_GEN(ActionMapping objMapping_p, ActionForm objForm_p,
			HttpServletRequest objRequest_p, HttpServletResponse objResponse_p)
			throws HisException, Exception, SQLException {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) objForm_p;

		StringBuffer strBuff = NEWOfflineResultEntryUTL.checkAutoGenFormate(fb, objRequest_p);
		objResponse_p.setHeader("Cache-Control", "no-cache");
		objResponse_p.getWriter().print(strBuff.toString());
		return null;
	}

	public ActionForward PRINT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		return mapping.findForward("PRINT");

	}

	public ActionForward GETPATLISTBAROCDE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("InvestigationRaisingDtlACT: GETPATList  ");
		// WebUTIL.refreshTransState(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		// fb.setShowStatus("0");
		String todate = fb.getToDate();
		String fromdate = fb.getFromDate();
		String crno = fb.getPatCrNo();
		NEWOfflineResultEntryUTL.getPatListBarcode(fb, request);
		// fb.setIsSampleAreaSelected("0");
		fb.setIsSampleAreaSelected("0");
		fb.setShowStatus("3");

		fb.setSampleAreaCode("-1");
		fb.setDuplicateBarcodeGeneration("0");
		// fb.setShowStatus("0");
		request.getSession().setAttribute("todate_dup", todate);
		request.getSession().setAttribute("fromdate_dup", fromdate);
		request.getSession().setAttribute("crno_dup", crno);

		/*
		 * fb.setPatCRNo(""); fb.setFromDate(""); fb.setToDate("");
		 */
		fb.setStatuschange("1");
		return mapping.findForward("NEW");
	}

	public ActionForward DUPLICATEBARCODE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BarcodeException, OutputException {
		System.out.println("InvestigationRaisingDtlACT: DUPLICATEBARCODE  ");
		// WebUTIL.refreshTransState(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		// fb.setShowStatus("0");
		String todate = (String) request.getSession().getAttribute("todate_dup");
		String fromdate = (String) request.getSession().getAttribute("fromdate_dup");
		String crno = (String) request.getSession().getAttribute("crno_dup");
		fb.setToDate(todate);
		fb.setFromDate(fromdate);
		fb.setPatCrNo(crno);

		NEWOfflineResultEntryUTL.duplicateBarCodeDetails(fb, request);
		fb.setShowStatus("0");
		fb.setIsSampleAreaSelected("1");
		fb.setSampleAreaCode("-1");
		fb.setFromDate(fromdate);
		fb.setToDate(todate);
		fb.setPatCrNo(crno);
		/*
		 * fb.setPatCRNo(""); fb.setFromDate(""); fb.setToDate("");
		 */
		fb.setDuplicateBarcodeGeneration("0");
		// fb.setFlagforipddesk("90");

		/* return this.NEW(mapping, form, request, response); */
		return this.GETPATLISTBAROCDE(mapping, form, request, response);
		// return mapping.findForward("GETPATLISTBAROCDE");
	}

	public ActionForward AJX_CHECK_REQ_FORM_MASTER(ActionMapping objMapping_p, ActionForm objForm_p,
			HttpServletRequest objRequest_p, HttpServletResponse objResponse_p)
			throws HisException, Exception, SQLException {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) objForm_p;

		StringBuffer strBuff = NEWOfflineResultEntryUTL.checkAutoGenFormate(fb, objRequest_p);
		objResponse_p.setHeader("Cache-Control", "no-cache");
		objResponse_p.getWriter().print(strBuff.toString());
		return null;
	}

	public ActionForward AJX_CHECK_REQFORM_TESTTYPE(ActionMapping objMapping_p, ActionForm objForm_p,
			HttpServletRequest objRequest_p, HttpServletResponse objResponse_p)
			throws HisException, Exception, SQLException {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) objForm_p;

		StringBuffer strBuff = NEWOfflineResultEntryUTL.getRequisitionFormMasterData(fb, objRequest_p);
		// System.out.println("strBuff act"+strBuff);
		objResponse_p.setHeader("Cache-Control", "no-cache");
		objResponse_p.getWriter().print(strBuff.toString());
		return null;
	}

	public ActionForward NEWW(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
	//	generateToken(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		HttpSession session = WebUTIL.getSession(request);
		Date dt = new Date();
		String iscallfromdesk = "0";
		// session.setAttribute("SYSDATEOBJECT",dt);

		if (fb.getShowStatus() != null) {
			if (fb.getShowStatus().equals("1")) {
				fb.setShowStatus("1");
			} else if (fb.getShowStatus().equals("3")) {
				fb.setShowStatus("0");
				fb.setIsSampleAreaSelected("");

			} else {

				fb.setShowStatus("0");
			}
		} else
			fb.setShowStatus("0");

		//
		if (fb.getIsSampleAreaSelected() != null) {
			if (fb.getIsSampleAreaSelected().equals("1")) {
				fb.setIsSampleAreaSelected("1");
			} else
				fb.setIsSampleAreaSelected("0");
		} else
			fb.setIsSampleAreaSelected("0");

		// session.removeAttribute(InvestigationConfig.COMPONENT_WISE_INDICATION_MAP);
		if (fb.getWardCode() != null) {
			fb.setFlagforipddesk("1");
			UserVO userVO = ControllerUTIL.getUserVO(request);
			String flag = fb.getWardCode();
			InvestigationEssentialOfflineDelegate daoDelegate = new InvestigationEssentialOfflineDelegate();

//				String collarea=daoDelegate.getcollectionareafromward(flag,userVO.getHospitalCode(),userVO.getUserSeatId());
			String collarea = daoDelegate.getcollectionareafromward(flag, userVO.getHospitalCode());

			fb.setSampleAreaCode(collarea);
			fb.setFlagforipddesk("10");
			NEWOfflineResultEntryUTL.getPatList(fb, request);

		} else {
			if (!fb.getIsSampleAreaSelected().equals("1") && fb.getWardCode() == null) {
				WebUTIL.refreshTransState(request);
				fb.setLabTestCodeArray("");
				NEWOfflineResultEntryUTL.getSampleCollectionArea(fb, request);
			} else
				NEWOfflineResultEntryUTL.getPatList(fb, request);

		}

		session.setAttribute("deskcrno", fb.getPatCrNo());

		return mapping.findForward("NEW");
	}

	public ActionForward NEWDUP(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
	//	generateToken(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		HttpSession session = WebUTIL.getSession(request);

		String isDuplicateBarecodeprint = fb.getDuplicateBarcodeGeneration() == null ? ""
				: fb.getDuplicateBarcodeGeneration();

		if (fb.getShowStatus() != null) {
			if (fb.getShowStatus().equals("1")) {
				fb.setShowStatus("1");
			} else if (fb.getShowStatus().equals("3")) {
				fb.setShowStatus("0");
				fb.setIsSampleAreaSelected("");

			} else {

				fb.setShowStatus("0");
			}
		} else
			fb.setShowStatus("0");

		//
		if (fb.getIsSampleAreaSelected() != null) {
			if (fb.getIsSampleAreaSelected().equals("1")) {
				fb.setIsSampleAreaSelected("1");
			} else
				fb.setIsSampleAreaSelected("0");
		} else
			fb.setIsSampleAreaSelected("0");

		// session.removeAttribute(InvestigationConfig.COMPONENT_WISE_INDICATION_MAP);
		if (!fb.getIsSampleAreaSelected().equals("1")) {
			WebUTIL.refreshTransState(request);
			fb.setLabTestCodeArray("");
			NEWOfflineResultEntryUTL.getSampleCollectionArea(fb, request);
		} else {

			// NEWOfflineResultEntryUTL.getPatList(fb,request);
		}

		fb.setDuplicateBarcodeGeneration(isDuplicateBarecodeprint);
		return mapping.findForward("NEW");
	}

	public ActionForward AjaxGetPatDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;

		try {
			JsonObject jsonResponse = new JsonObject();

			jsonResponse = NEWOfflineResultEntryUTL.AjaxGetPatDetails(fb, request);

			response.setContentType("application/Json");
			response.getWriter().print(jsonResponse.toString());
			System.out.println("response = : = :" + jsonResponse.toString());

		} catch (JsonIOException e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	public ActionForward AjaxBilledUnbilledDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;

		try {

			String jsonResponse = null;
			jsonResponse = NEWOfflineResultEntryUTL.AjaxBilledUnbilledDetails(fb, request);
			JSONObject json = new JSONObject(jsonResponse);
			response.setContentType("application/Json");
			response.getWriter().print(json.toString());
			System.out.println("response = : = :" + json.toString());

		} catch (JsonIOException e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	public ActionForward AjaxGetDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;

		try {
			String jsonResponse = null;

			jsonResponse = NEWOfflineResultEntryUTL.AjaxGetDetails(fb, request);

			response.setContentType("application/Json");

			// String FinalValue =jsonResponse.toString();

			if (jsonResponse != null) {
				response.getWriter().print(jsonResponse.toString());

			} else {
				response.getWriter().print("No data Found");
			}

			/*
			 * 
			 * response.getWriter().print(jsonResponse.toString());
			 * 
			 * System.out.println("response = : = :"+jsonResponse.toString());
			 * if(jsonResponse.toString().equalsIgnoreCase(null)) {
			 * response.getWriter().print("No data Found"); }
			 */

		} catch (JsonIOException e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	public ActionForward AjaxSaveDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		NEWOfflineResultEntryFB _fb = (NEWOfflineResultEntryFB) form;
		HttpSession session = WebUTIL.getSession(request);
		InvestigationEssentialOfflineDelegate daoDelegate = new InvestigationEssentialOfflineDelegate();

		UserVO userVO = ControllerUTIL.getUserVO(request);

		// session.removeAttribute(InvestigationConfig.UPLOADED_FILE_AS_ARRAY);

		StringBuffer jb = new StringBuffer();

		String line = null;

		Map<String, Map<String, Map<String, List<NEWOfflineResultEntryVO>>>> mp = new LinkedHashMap<String, Map<String, Map<String, List<NEWOfflineResultEntryVO>>>>();

		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null)
			jb.append(line);

		String mobileNo = _fb.getPatMobile() == null ? "" : _fb.getPatMobile();
		String emailId = _fb.getPatEmail() == null ? "" : _fb.getPatEmail();
		String patAddress = _fb.getPatAddress() == null ? "" : _fb.getPatAddress();

		JSONObject json = new JSONObject(jb.toString());
		JSONArray jsonArray = new JSONArray(json.getString("selectedList"));
		// System.out.println(jsonArray.length());
		for (int i = 0; i < jsonArray.length(); i++) {
			// String patientStatus = jsonArray.getJSONObject(0).getString("crno");
			JSONObject childJSONObject = jsonArray.getJSONObject(i);
			String testName = childJSONObject.getString("testName");
			String labName = childJSONObject.getString("labName");
			String requisitionDate = childJSONObject.getString("requisitionDate");
			String sampleName = childJSONObject.getString("sampleName");
			String sampleNo = childJSONObject.getString("sampleNo");
			String sampleQnty = childJSONObject.getString("sampleQnty");
			String UOM = childJSONObject.getString("UOM");
			String container = childJSONObject.getString("container");
			String priorityAll = childJSONObject.getString("priorityAll");
			String machineCode = childJSONObject.getString("machineCode");
			String priorityAllCode = childJSONObject.getString("priorityAllCode");
			String patInstruct = childJSONObject.getString("patInstruct");
			String requisitionNo = childJSONObject.getString("requisitionNo");
			String labCode = childJSONObject.getString("labCode");
			String testCode = childJSONObject.getString("testCode");
			String isConfidential = childJSONObject.getString("isConfidential");
			String requisitionDNo = childJSONObject.getString("requisitionDNo");
			String reqDtlStatus = childJSONObject.getString("reqDtlStatus");
			String sampleCode = childJSONObject.getString("sampleCode");
			String defaultContainerCode = childJSONObject.getString("defaultContainerCode");
			String defaultUOMCode = childJSONObject.getString("defaultUOMCode");
			String samplenoConfig = childJSONObject.getString("sampleNoConfiguration");
			String collInstruct = childJSONObject.getString("collInstruct");
			String isrequisitionformneeded = childJSONObject.getString("isrequisitionformneeded");
			String miscDate = childJSONObject.getString("miscDate");
			String billDetail = childJSONObject.getString("billDetail");
			String billNo = childJSONObject.getString("billNo");
			String patType = childJSONObject.getString("patType");
			String sampleNoFormat = childJSONObject.getString("sampleNoFormat");
			String initDate = childJSONObject.getString("initDate");
			String noOfSeqDigit = childJSONObject.getString("noOfSeqDigit");
			String fromSeries = childJSONObject.getString("fromSeries");
			String toSeries = childJSONObject.getString("toSeries");
			String initType = childJSONObject.getString("initType");
			String runningSampleNo = childJSONObject.getString("runningSampleNo");
			String configLab = childJSONObject.getString("configLab");
			String configType = childJSONObject.getString("configType");
			String configSeq = childJSONObject.getString("configSeq");
			String configTest = childJSONObject.getString("configTest");
			String configArea = childJSONObject.getString("configArea");
			String crno = childJSONObject.getString("crno");
			String collAreaCode = childJSONObject.getString("sampleAreaCode");
			String wardcode = childJSONObject.getString("wardCode");

			if (wardcode != null && !wardcode.equals("")) {

				String collarea = daoDelegate.getcollectionareafromward(wardcode, userVO.getHospitalCode());

				if (collarea != null && !collarea.equals("")) {
					collAreaCode = collarea;
				}

			}

			String patName = childJSONObject.getString("patName");
			String patCategoryCode = childJSONObject.getString("patCategoryCode");
			_fb.setPatCategoryCode(patCategoryCode);
			_fb.setPatName(patName);
			Map<String, Map<String, List<NEWOfflineResultEntryVO>>> mpReqNo = mp.get(crno);
			// First Time Insertion
			if (mpReqNo == null) {
				mpReqNo = new LinkedHashMap<String, Map<String, List<NEWOfflineResultEntryVO>>>();

				Map<String, List<NEWOfflineResultEntryVO>> mpSample = new LinkedHashMap<String, List<NEWOfflineResultEntryVO>>();

				List<NEWOfflineResultEntryVO> lstSample = new ArrayList<NEWOfflineResultEntryVO>();
				NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();

				if (samplenoConfig.equals("1") || samplenoConfig.equalsIgnoreCase("2"))

				{
					voSample.setTempSampleNo(samplenoConfig);
				} else {
					voSample.setTempSampleNo(sampleNo);
				}

				// Setting VO Values from labStringArray
				voSample.setPatCRNo(crno);
				voSample.setSampleCode(sampleCode);
				voSample.setRequisitionDNo(requisitionDNo);
				voSample.setRequisitionNo(requisitionNo);
				voSample.setLabCode(labCode);
				voSample.setPatMobile(mobileNo);
				voSample.setPatEmail(emailId);
				voSample.setPatAddress(patAddress);
				voSample.setPatName(patName);
				voSample.setPatCategoryCode(_fb.getPatCategoryCode());

				voSample.setSampleAreaCode(collAreaCode);
				voSample.setWardCode(wardcode);

				// voSample.setPrintStatus(printStatus);
				voSample.setSampleQnty(sampleQnty);
				voSample.setDefaultContainerCode(defaultContainerCode);
				voSample.setDefaultmachineCode(machineCode);
				voSample.setDefaultUOMCode(defaultUOMCode);
				voSample.setTypeOfComponent("1"); // Need to Discuss

				voSample.setBillNo(billNo);
				voSample.setTestCode(testCode);
				voSample.setSampleName(sampleName);

				voSample.setCheckAutoLabConfig(samplenoConfig);
				voSample.setTestName(testName);
				voSample.setPatType(patType);
				voSample.setSampleNoFormat(sampleNoFormat);
				voSample.setInitDate(initDate);
				voSample.setNoOfSeqDigit(noOfSeqDigit);
				voSample.setFromSeries(fromSeries);
				voSample.setToSeries(toSeries);
				voSample.setInitType(initType);
				voSample.setRunningSampleNo(runningSampleNo);
				voSample.setRequisitionDate(requisitionDate);
				voSample.setLabName(labName);

				voSample.setConfigLab(configLab);
				voSample.setConfigArea(configArea);
				voSample.setConfigSeq(configSeq);
				voSample.setConfigTest(configTest);
				voSample.setConfigType(configType);

				// Adding List of SampleVO<=>RequisitionDNo's
				lstSample.add(voSample);

				// Putting list in Map of SampleCodes
				mpSample.put(sampleCode + "#" + labCode, lstSample);

				// Putting Map of Samples in Map of Requisitions
				mpReqNo.put(requisitionNo, mpSample);

			} else {
				// Getting Map of Sample Codes
				Map<String, List<NEWOfflineResultEntryVO>> mpSample = mpReqNo.get(requisitionNo);

				// First Time Insertion
				if (mpSample == null) {
					mpSample = new LinkedHashMap<String, List<NEWOfflineResultEntryVO>>();

					List<NEWOfflineResultEntryVO> lstSample = new ArrayList<NEWOfflineResultEntryVO>();
					NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();

					// Setting VO Values from labStringArray
					voSample.setPatCRNo(crno);
					voSample.setSampleCode(sampleCode);
					voSample.setRequisitionDNo(requisitionDNo);
					voSample.setRequisitionNo(requisitionNo);
					voSample.setLabCode(labCode);
					voSample.setPatMobile(mobileNo);
					voSample.setPatEmail(emailId);
					voSample.setPatAddress(patAddress);
					voSample.setPatName(patName);
					voSample.setPatCategoryCode(_fb.getPatCategoryCode());

					voSample.setSampleAreaCode(collAreaCode);
					voSample.setWardCode(wardcode);

					// voSample.setPrintStatus(printStatus);
					voSample.setSampleQnty(sampleQnty);
					voSample.setDefaultContainerCode(defaultContainerCode);
					voSample.setDefaultmachineCode(machineCode);
					voSample.setDefaultUOMCode(defaultUOMCode);
					voSample.setTypeOfComponent("1"); // Need to Discuss

					voSample.setTestName(testName);
					voSample.setBillNo(billNo);
					voSample.setTestCode(testCode);
					voSample.setSampleName(sampleName);
					voSample.setRequisitionDate(_fb.getRequisitionDate());
					voSample.setLabName(_fb.getLabName());
					// Still Some values need to be inserted
					if (samplenoConfig.equals("1") || samplenoConfig.equalsIgnoreCase("2"))

					{
						voSample.setTempSampleNo(samplenoConfig);
					} else {
						voSample.setTempSampleNo(sampleNo);
					}

					voSample.setCheckAutoLabConfig(samplenoConfig);
					voSample.setPatType(patType);

					voSample.setSampleNoFormat(sampleNoFormat);
					voSample.setInitDate(initDate);
					voSample.setNoOfSeqDigit(noOfSeqDigit);
					voSample.setFromSeries(fromSeries);
					voSample.setToSeries(toSeries);
					voSample.setInitType(initType);
					voSample.setRunningSampleNo(runningSampleNo);
					voSample.setRequisitionDate(requisitionDate);
					voSample.setLabName(labName);
					voSample.setConfigLab(configLab);
					voSample.setConfigArea(configArea);
					voSample.setConfigSeq(configSeq);
					voSample.setConfigTest(configTest);
					voSample.setConfigType(configType);

					// Adding List of SampleVO<=>RequisitionDNo's
					lstSample.add(voSample);

					// Putting list in Map of SampleCodes
					mpSample.put(sampleCode + "#" + labCode, lstSample);

				} else {
					List<NEWOfflineResultEntryVO> lstSample = mpSample.get(sampleCode + "#" + labCode);
					if (lstSample == null || lstSample.size() == 0) // First Time Insertion
					{
						lstSample = new ArrayList<NEWOfflineResultEntryVO>();
						NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();

						// Setting VO Values from labStringArray
						voSample.setPatCRNo(crno);
						voSample.setSampleCode(sampleCode);
						voSample.setRequisitionDNo(requisitionDNo);
						voSample.setRequisitionNo(requisitionNo);
						voSample.setLabCode(labCode);
						voSample.setPatMobile(mobileNo);
						voSample.setPatEmail(emailId);
						voSample.setPatAddress(patAddress);
						voSample.setPatName(patName);
						voSample.setPatCategoryCode(_fb.getPatCategoryCode());

						voSample.setTestName(testName);
						voSample.setSampleAreaCode(collAreaCode);
						voSample.setWardCode(wardcode);

						// voSample.setPrintStatus(printStatus);
						voSample.setSampleQnty(sampleQnty);
						voSample.setDefaultContainerCode(defaultUOMCode);
						voSample.setDefaultmachineCode(machineCode);
						voSample.setDefaultUOMCode(defaultUOMCode);
						voSample.setTypeOfComponent("1"); // Need to Discuss
						voSample.setBillNo(billNo);
						voSample.setTestCode(testCode);
						voSample.setSampleName(sampleName);
						// Still Some values need to be inserted
						if (samplenoConfig.equals("1") || samplenoConfig.equalsIgnoreCase("2"))

						{
							voSample.setTempSampleNo(samplenoConfig);
						} else {
							voSample.setTempSampleNo(sampleNo);
						}

						voSample.setCheckAutoLabConfig(samplenoConfig);
						voSample.setPatType(patType);

						voSample.setSampleNoFormat(sampleNoFormat);
						voSample.setInitDate(initDate);
						voSample.setNoOfSeqDigit(noOfSeqDigit);
						voSample.setFromSeries(fromSeries);
						voSample.setToSeries(toSeries);
						voSample.setInitType(initType);
						voSample.setRunningSampleNo(runningSampleNo);
						voSample.setRequisitionDate(requisitionDate);
						voSample.setLabName(labName);

						voSample.setConfigLab(configLab);
						voSample.setConfigArea(configArea);
						voSample.setConfigSeq(configSeq);
						voSample.setConfigTest(configTest);
						voSample.setConfigType(configType);
						// Adding List of SampleVO<=>RequisitionDNo's
						lstSample.add(voSample);

					} else {
						NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();

						// Setting VO Values from labStringArray
						voSample.setPatCRNo(crno);
						voSample.setSampleCode(sampleCode);
						voSample.setRequisitionDNo(requisitionDNo);
						voSample.setRequisitionNo(requisitionNo);
						voSample.setLabCode(labCode);
						voSample.setPatMobile(mobileNo);
						voSample.setPatEmail(emailId);
						voSample.setPatAddress(patAddress);
						voSample.setPatCategoryCode(_fb.getPatCategoryCode());

						voSample.setTestName(testName);
						voSample.setSampleAreaCode(collAreaCode);
						voSample.setWardCode(wardcode);

						// voSample.setPrintStatus(printStatus);
						voSample.setSampleQnty(sampleQnty);
						voSample.setDefaultContainerCode(defaultContainerCode);
						voSample.setDefaultmachineCode(machineCode);
						voSample.setDefaultUOMCode(defaultUOMCode);
						voSample.setTypeOfComponent("1"); // Need to Discuss
						voSample.setBillNo(billNo);
						voSample.setTestCode(testCode);
						voSample.setSampleName(sampleName);
						voSample.setPatName(patName);
						// Still Some values need to be inserted

						if (samplenoConfig.equals("1") || samplenoConfig.equalsIgnoreCase("2"))

						{
							voSample.setTempSampleNo(samplenoConfig);
						} else {
							voSample.setTempSampleNo(sampleNo);
						}

						voSample.setCheckAutoLabConfig(samplenoConfig);
						voSample.setPatType(patType);
						voSample.setSampleNoFormat(sampleNoFormat);
						voSample.setInitDate(initDate);
						voSample.setNoOfSeqDigit(noOfSeqDigit);
						voSample.setFromSeries(fromSeries);
						voSample.setToSeries(toSeries);
						voSample.setInitType(initType);
						voSample.setRunningSampleNo(runningSampleNo);
						voSample.setRequisitionDate(requisitionDate);
						voSample.setLabName(labName);

						voSample.setConfigLab(configLab);
						voSample.setConfigArea(configArea);
						voSample.setConfigSeq(configSeq);
						voSample.setConfigTest(configTest);
						voSample.setConfigType(configType);
						voSample.setPatName(patName);

						// Adding List of SampleVO<=>RequisitionDNo's
						lstSample.add(voSample);
					}

					// Putting list in Map of SampleCodes
					mpSample.put(sampleCode + "#" + labCode, lstSample);
					// }
				}

				// Putting Map of Samples in Map of Requisitions
				mpReqNo.put(requisitionNo, mpSample);

				// }// end while

			} // end main else

			// Putting Map of Requisitions in Map of CrNo's => currently only one CR No is
			// allowed
			mp.put(crno, mpReqNo);

		} // end for loop

		NEWOfflineResultEntryUTL.AJAXsaveSampleCollectionDetails(mp, _fb, request, response);

		if (_fb.getFlagforipddesk() != null && _fb.getFlagforipddesk().equals("15"))
			_fb.setFlagforipddesk("16");
		else
			_fb.setShowStatus("0");

		return null;

	}

	public ActionForward AJAX_CHECK_AUTO_SAMPLENO_GEN(ActionMapping objMapping_p, ActionForm objForm_p,
			HttpServletRequest objRequest_p, HttpServletResponse response)
			throws HisException, Exception, SQLException {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) objForm_p;

		try {
			String jsonResponse = null;
			jsonResponse = NEWOfflineResultEntryUTL.ajaxcheckAutoGenFormate(fb, objRequest_p);
			response.setContentType("application/Json");
			response.getWriter().print(jsonResponse.toString());
			System.out.println("response = : = :" + jsonResponse.toString());

		} catch (JsonIOException e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	public ActionForward AjaxNEWDUP(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, Exception, SQLException {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		String todate = fb.getToDate();
		String fromdate = fb.getFromDate();
		String crno = fb.getPatCrNo();
		try {
			String jsonResponse = null;
			jsonResponse = NEWOfflineResultEntryUTL.AJAXgetPatListBarcode(fb, request);
			response.setContentType("application/Json");
			response.getWriter().print(jsonResponse.toString());
			System.out.println("response = : = :" + jsonResponse.toString());

		} catch (JsonIOException e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try {
				response.getWriter().print("error" + sw.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		fb.setIsSampleAreaSelected("0");
		fb.setShowStatus("3");

		fb.setSampleAreaCode("-1");
		fb.setDuplicateBarcodeGeneration("0");

		request.getSession().setAttribute("todate_dup", todate);
		request.getSession().setAttribute("fromdate_dup", fromdate);
		request.getSession().setAttribute("crno_dup", crno);

		fb.setStatuschange("1");

		return null;
	}

	public ActionForward AJAXDUPLICATEBARCODE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws BarcodeException, OutputException, IOException, JSONException {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		StringBuffer jb = new StringBuffer();
		String line = null;

		List<NEWOfflineResultEntryVO> lstSample = new ArrayList<NEWOfflineResultEntryVO>();

		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null)
			jb.append(line);
		JSONObject json = new JSONObject(jb.toString());
		JSONArray jsonArray = new JSONArray(json.getString("selectedListForDuplicateBarcode"));

		for (int i = 0; i < jsonArray.length(); i++) {
			NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();
			JSONObject childJSONObject = jsonArray.getJSONObject(i);
			String crno = childJSONObject.getString("crno");
			String patName = childJSONObject.getString("patName");
			String labName = childJSONObject.getString("labName");
			String SampleNo = childJSONObject.getString("SampleNo");
			String requisitionDate = childJSONObject.getString("requisitionDate");
			String patStatus = childJSONObject.getString("patStatus");
			String sugarTestCode = childJSONObject.getString("sugarTestCode");
			String sampleCollectionDate = childJSONObject.getString("sampleCollectionDate");
			String requisitionNo = childJSONObject.getString("requisitionNo");
			String sampleCode = childJSONObject.getString("sampleCode");
			String sampleName = childJSONObject.getString("sampleName");

			voSample.setPatCRNo(crno);
			voSample.setSampleName(sampleName);
			voSample.setpatName(patName);
			voSample.setLabName(labName);
			voSample.setRequisitionNo(requisitionNo);
			voSample.setSugarTestCode(sugarTestCode);
			voSample.setSampleCollectionDate(sampleCollectionDate);
			voSample.setRequisitionDate(requisitionDate);
			voSample.setSampleNo(SampleNo);
			;
			lstSample.add(voSample);
		}

		System.out.println(lstSample);

		NEWOfflineResultEntryUTL.AJAXduplicateBarCodeDetails(fb, lstSample, request, response);
		fb.setShowStatus("0");
		fb.setIsSampleAreaSelected("1");
		fb.setSampleAreaCode("-1");
		fb.setDuplicateBarcodeGeneration("0");
		return null;
		// return mapping.findForward("GETPATLISTBAROCDE");
	}

	public ActionForward NEWWW(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
	//	generateToken(request);
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		HttpSession session = WebUTIL.getSession(request);
		// fb.setPatCrNo("9610120000");
//	fb.setCrNo("961012000000732");
		// fb.setPatStatusCode("2");
//	fb.getWardCode()
//	fb.setSampleAreaCode("101");

		// request.removeAttribute("patCrNo") ;
		// request.getAttribute("wardCode") ;
		// request.getAttribute("patStatusCode") ;

//String crno=(String)request.getAttribute("patCrNo");
//String wardcode=(String)request.getAttribute("wardCode");
//String patStatusCode=(String)request.getAttribute("patStatusCode");

//	AjaxGetPatDetails(mapping,form,request,response);
		// AjaxGetDetails(mapping,form,request,response);
//	request.setAttribute("sampleAreaCode", fb.getSampleAreaCode());
		request.setAttribute("patCrNo", fb.getPatCrNo());
		request.setAttribute("wardCode", fb.getWardCode());
		request.setAttribute("patStatusCode", "2");

		return this.NEW(mapping, form, request, response);

	}

	public ActionForward getRegisteredPatientDetail(ActionMapping objMapping_p, ActionForm objForm_p,
			HttpServletRequest objRequest_p, HttpServletResponse objResponse_p)
			throws HisException, Exception, SQLException {
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) objForm_p;
		try {
			fb.setPatCrNo(objRequest_p.getParameter("cr_no"));
			fb.setPatMobNo(objRequest_p.getParameter("mob_no"));
			fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());

			NEWOfflineResultEntryUTL.getAllPatListResultEntry(fb, objRequest_p);
			// InvOfflineResultEntryUTIL.getRegisteredPatientDtl(fb,objRequest_p);

			objResponse_p.setContentType("text/plain");
			objResponse_p.setCharacterEncoding("UTF-8");
			objResponse_p.getWriter().write(fb.getStrMultiPatList());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ActionForward saveAlreadyRegPat(ActionMapping objMapping_p, ActionForm objForm_p,
			HttpServletRequest objRequest_p, HttpServletResponse objResponse_p)
			throws HisException, Exception, SQLException {
		NEWOfflineResultEntryFB fb;
		try {

			fb = (NEWOfflineResultEntryFB) objForm_p;
			fb.setStrParentHospitalCode(objRequest_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setSeatId(objRequest_p.getSession().getAttribute("SEATID").toString());
			System.out.println("nandini2");
			// NEWOfflineResultEntryUTL.insertAlreadyRegPat(fb,objRequest_p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.unspecified(objMapping_p, objForm_p, objRequest_p, objResponse_p);
	}

	public ActionForward getuploadedfile(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {

		System.out.println("3++++++++++++");

		NEWOfflineResultEntryFB formBean = (NEWOfflineResultEntryFB) form;
		formBean.setStrParentHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		NEWOfflineResultEntryUTL.DownloadFile(formBean, request, response);
		return null;

	}

	public ActionForward SAVEDOCPDF(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ByteArrayInputStream inputStream = null;
		byte[] getDoc = saveSummaryPDF(mapping, form, request, response);

		if (getDoc != null) {

			// NEWOfflineResultEntryUTL.updateSummaryStatus("1", request, response,
			// (UniPagePrescriptionFB) form);

			response.setContentType("application/pdf");
			OutputStream os = response.getOutputStream();
			// bos = new BufferedOutputStream(os);
			inputStream = new ByteArrayInputStream(getDoc);
			int c;
			while ((c = inputStream.read()) != -1) {
				os.write(c);
			}
			Status objStatus = new Status();
			objStatus.add(Status.TRANSINPROCESS, "Data Saved Successfully", "");
			request.setAttribute(Config.STATUS_OBJECT, objStatus);
		}
		return mapping.findForward("NULL");
	}

	public byte[] saveSummaryPDF(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
		InputStream inputStream = null;
		String decoded = new String(Base64.decodeBase64(fb.getHtmlPreview().getBytes(StandardCharsets.UTF_8)));

		String docHTML = new String(URLDecoder.decode(decoded, StandardCharsets.UTF_8.name()));// "";

		ByteArrayOutputStream baosPDF = null;
		String strParsedHtmData = HTMLParsingUTIL.makeHTMLPDFCompatible(docHTML); // Save

		// String previewHtml = "<table width='100%' align='center'><tbody><tr><td
		// align='center'><font size='3'><b><u>[For Preview Purpose
		// Only]</u></b></font></td></tr></tbody></table>";
		String strHTMLCode = strParsedHtmData;// previewHtml + strParsedHtmData;

		baosPDF = HTMLToPDFUTIL.convertHtmlToPDFDirect(request, strHTMLCode);

		/*
		 * HisFileControlUtil hfcu = new HisFileControlUtil("abc.pdf",
		 * "F:\\", "/root/"); hfcu.setFileContent(baosPDF.toByteArray());
		 * hfcu.saveFile();
		 */

		fb.setHtmlPreview(strParsedHtmData);

		byte[] getDoc = null;

		baosPDF = HTMLToPDFUTIL.convertHtmlToPDFDirect(request, strHTMLCode);
		getDoc = baosPDF.toByteArray();

//				response.setContentType("application/pdf");
//				OutputStream os = response.getOutputStream();
//				inputStream = new ByteArrayInputStream(getDoc);
//				int c;
//				while ((c = inputStream.read()) != -1)
//				{
//					os.write(c);
//				}    

		return getDoc;
	}
	
	
	
	public void getOfflineLabTestData(ActionMapping mapping, ActionForm form,
	          HttpServletRequest request, HttpServletResponse response) throws Exception {
	          
	          NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
	          NEWOfflineResultEntryUTL.getOfflineLabTestData(request, response,fb);
	          
	          }


	  public void view_Lab_Report(ActionMapping mapping, ActionForm form,
	  HttpServletRequest request, HttpServletResponse response) throws Exception {
	  
		  NEWOfflineResultEntryFB fb = (NEWOfflineResultEntryFB) form;
	  
		  NEWOfflineResultEntryUTL.view_Lab_Report(request, response,fb);
	  
	  }
	 
	


}