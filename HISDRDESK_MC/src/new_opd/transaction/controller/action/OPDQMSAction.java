package new_opd.transaction.controller.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import new_opd.transaction.controller.data.OPDQMSDATA;
import new_opd.transaction.controller.fb.OPDQMSFB;



public class OPDQMSAction extends DispatchAction
{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		OPDQMSFB formBean = (OPDQMSFB) form;
		return this.NEW(mapping, formBean, request, response);
	}
	public ActionForward NEW(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("123::::::::::");
		OPDQMSFB formBean = (OPDQMSFB) form;
		
		
		OPDQMSDATA.getDeptDtlData(formBean, request);
		
	
		return mapping.findForward("INITIAL");
	}
}