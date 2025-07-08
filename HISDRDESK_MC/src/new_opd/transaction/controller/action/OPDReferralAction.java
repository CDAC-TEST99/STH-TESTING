package new_opd.transaction.controller.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import new_opd.transaction.controller.data.OpdReferralDATA;
import new_opd.transaction.controller.fb.OPDReferralFB;



public class OPDReferralAction extends DispatchAction
{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		OPDReferralFB formBean = (OPDReferralFB) form;
		return this.OREFERRAL(mapping, formBean, request, response);
	}
	
	public ActionForward OREFERRAL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	
		return mapping.findForward("OREFERRAL");
	}	
	public void populatestrExternalDepartmentList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("123::::::::::");
		OPDReferralFB formBean = (OPDReferralFB) form;
		OpdReferralDATA.populatestrExternalDepartmentList(request, response,formBean);	
		
	}
	
	public void getExternalRefralConfiguration(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("123::::::::::");
		OPDReferralFB formBean = (OPDReferralFB) form;
		OpdReferralDATA.getExternalRefralConfiguration(request, response,formBean);	
		
	}
	
	
	public void populateEndorsementCity(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		OpdReferralDATA.populateEndorsementCity(request, response);	
		
	}
	public void populateEndorsementHospital(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		OpdReferralDATA.populateEndorsementHospital(request, response);	
		
	}
	public void populateEndorsementDepartment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("123::::::::::");
		OPDReferralFB formBean = (OPDReferralFB) form;
		OpdReferralDATA.populateEndorsementDepartment(request, response,formBean);	
		
	}
	public void populateExternalInvestigation(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("123::::::::::");
		OPDReferralFB formBean = (OPDReferralFB) form;
		OpdReferralDATA.populateExternalInvestigation(request, response,formBean);	
		
	}
	public void populateExternalProcedure(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("123::::::::::");
		OPDReferralFB formBean = (OPDReferralFB) form;
		OpdReferralDATA.populateExternalProcedure(request, response,formBean);	
		
	}
	public void populateExternalFollowup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("123::::::::::");
		OPDReferralFB formBean = (OPDReferralFB) form;
		OpdReferralDATA.populateExternalFollowup(request, response,formBean);	
		
	}	
}