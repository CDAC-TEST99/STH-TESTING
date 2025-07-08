package new_opd.transaction.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import new_opd.transaction.controller.data.MCPathLabSampleHandoverDetailTransMcNewDATA;
import new_opd.transaction.controller.fb.MCPathLabSampleHandoverDetailFB;

public class MCPathLabSampleHandoverDetailTransMcNewCNT extends CSRFGardTokenAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		MCPathLabSampleHandoverDetailFB formBean = (MCPathLabSampleHandoverDetailFB) form;

		if (formBean.getStrWarningMsg().trim().length() > 0) {

			request.setAttribute("strWarningMsg", formBean.getStrWarningMsg());

		}   //System.out.println("1.1");
		
		if(request.getParameter("userValue") !=null && request.getParameter("userValue").equals("1")){
			
			return this.WebServicesSent(mapping, formBean, request, response);
			
		} 

		return this.INITVAL(mapping, formBean, request, response);

	}

	public ActionForward INITVAL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		MCPathLabSampleHandoverDetailFB formBean = (MCPathLabSampleHandoverDetailFB) form;

		MCPathLabSampleHandoverDetailTransMcNewDATA.getPatientsDtlNew(formBean, request);
		//System.out.println("1.2");
		String target = "issue";
		return mapping.findForward(target);
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException,Exception {

		MCPathLabSampleHandoverDetailFB fb = (MCPathLabSampleHandoverDetailFB) form;
		MCPathLabSampleHandoverDetailTransMcNewDATA.save(fb);

		return this.INITVAL(mapping, fb, request, response);
	}
	
	//get Details of Pending Failed Webservices
	public ActionForward WebServicesSent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		MCPathLabSampleHandoverDetailFB formBean = (MCPathLabSampleHandoverDetailFB) form;

		MCPathLabSampleHandoverDetailTransMcNewDATA.getPatientsDtlForWebservicesSent(formBean, request);
		//System.out.println("1.2");
		String target = "webServicesSent";
		return mapping.findForward(target);
	}

	
	
	public ActionForward WebServicesSentAjax(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException{
	       
	        
	        MCPathLabSampleHandoverDetailFB fb = (MCPathLabSampleHandoverDetailFB) form;

			fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			MCPathLabSampleHandoverDetailTransMcNewDATA.getPatDetailsWebServicesSentAjax(response,request);
			//System.out.println("INSIDE WebServicesSentAjax CNT ");
		
			return null;
	    }
	

	public ActionForward saveForWebServicesSent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MCPathLabSampleHandoverDetailFB fb = (MCPathLabSampleHandoverDetailFB) form;

			//System.out.println("INSIDE saveForWebServicesSent");
		MCPathLabSampleHandoverDetailTransMcNewDATA.resendFailedWebservices(fb);

		return this.WebServicesSent(mapping, fb, request, response);
	}

	public ActionForward BACK(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		return this.INITVAL(mapping, form, request, response);

	}

}
