package new_opd.transaction.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.JsonIOException;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import hisglobal.utility.HisUtil;
///import mms.transactions.controller.data.IssueToPatientTransMcDATA;
//// mms.transactions.controller.fb.IssueToPatientTransMcFB;
import new_opd.transaction.controller.data.MCPathLabReportDetailDATA;
import new_opd.transaction.controller.data.MCPathLabSampleDrawnDetailDATA;
import new_opd.transaction.controller.fb.MCPathLabReportDetailFB;
import new_opd.transaction.controller.fb.MCPathLabSampleDrawnDetailFB;

public class MCPathLabReportDetailCNT extends CSRFGardTokenAction {
	
	String error="File Error Message>> :";
	

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		MCPathLabReportDetailFB formBean = (MCPathLabReportDetailFB) form;

		if (formBean.getStrWarningMsg().trim().length() > 0) {

			request.setAttribute("strWarningMsg", formBean.getStrWarningMsg());

		}
		return this.INITVAL(mapping, formBean, request, response);
	}

	public ActionForward INITVAL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		 MCPathLabReportDetailFB formBean = (MCPathLabReportDetailFB) form;
		MCPathLabReportDetailDATA.getPatientsDtlNew(formBean, request);
		
		String target = "issue";
		return mapping.findForward(target);
	}
	
	public ActionForward saveHardCopyRecdDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		MCPathLabReportDetailFB fb = (MCPathLabReportDetailFB) form;

		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		MCPathLabReportDetailDATA.saveHardCopyRecdDetails(fb, request,response);

		if (fb.getStrWarningMsg().trim().length() > 0) 
			request.setAttribute("strWarningMsg", fb.getStrWarningMsg());
		else if (fb.getStrErrMsg().trim().length() > 0) {

			request.setAttribute("strErrMsg", fb.getStrErrMsg());
		}
			return this.INITVAL(mapping, fb, request, response);
	}
	
	
	 public ActionForward getuploadedfile(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
		 
		 MCPathLabReportDetailFB formBean = (MCPathLabReportDetailFB) form;
		 	formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		 	 //System.out.println("nandini3>>>>>>>>>>> ");
		 	MCPathLabReportDetailDATA.DownloadFile(formBean, request, response);
			return null;

		}

	/*
	public ActionForward issueToPatGo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		MCPathLabReportDetailFB fb = (MCPathLabReportDetailFB) form;

		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		MCPathLabReportDetailDATA.getPresDrugDtlNew(fb, request);
		MCPathLabReportDetailDATA.getDrugDetails(fb);

		if (fb.getStrWarningMsg().trim().length() > 0) {
			request.setAttribute("strWarningMsg", fb.getStrWarningMsg());
			return this.INITVAL(mapping, fb, request, response);
		}

		String target = "issueGo";
		return mapping.findForward(target);
	}
	
	public ActionForward getPreviousIssues(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
	{
		MCPathLabReportDetailFB fb = (MCPathLabReportDetailFB) form;

		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		MCPathLabReportDetailDATA.getPreviousIssueDtls(fb, response);
		return null;
	}
	
	public ActionForward getPreviousIssuesPopup(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
	{
		MCPathLabReportDetailFB fb = (MCPathLabReportDetailFB) form;

		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		MCPathLabReportDetailDATA.getPreviousIssueItemDtls(fb, response);
		return null;
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MCPathLabReportDetailFB fb = (MCPathLabReportDetailFB) form;

		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		MCPathLabReportDetailDATA.save(fb);

		if (fb.getStrWarningMsg().trim().length() > 0) {
			request.setAttribute("strWarningMsg", fb.getStrWarningMsg());
		} else if (fb.getStrErrMsg().trim().length() > 0) {

			request.setAttribute("strErrMsg", fb.getStrErrMsg());
		} else {
			request.setAttribute("strNormalMsg", "Drugs Issued successfully with Issue No. " + fb.getStrIssueNo());
		}
		return this.INITVAL(mapping, fb, request, response);
	}
	*/
	
	public ActionForward BACK(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		return this.INITVAL(mapping, form, request, response);

	}
	

	public ActionForward AjaxGetPDFReport(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
		MCPathLabReportDetailFB fb=(MCPathLabReportDetailFB)form;
		try {
			//System.out.println("Print 1.1");
			//ControllerUTIL.setSysdate(request);
			fb.setShowStatus("1");
		
			boolean flg=false;
			
			String ftpserver=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL"); //InvTrackingReportUTIL.isfromFTPorMONGO(request,response);
	        fb.setFtpserver(ftpserver);
	    	//System.out.println("Print 1.2");
			if(ftpserver==null || ftpserver.equals(""))
				//System.out.println("ftp server detail missing in hispath.xml");
			else   
				MCPathLabReportDetailDATA.AjaxGetPDFReportFTP(fb,request,response);
		}
		catch (JsonIOException e) {
			e.printStackTrace();
			StringWriter sw=new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try { response.getWriter().print(error+sw.toString()); }
			catch (IOException e1) { e1.printStackTrace(); }
		}
		catch (Exception e) {
			e.printStackTrace();
			StringWriter sw=new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			response.setContentType("text/html");
			try { response.getWriter().print(error+sw.toString()); }
			catch (IOException e1) { e1.printStackTrace(); }
		}
		return null;
	} 
	
	
	
	
	
	
	
	

}
