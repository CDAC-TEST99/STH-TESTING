package new_opd.transaction.controller.action;



import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import application.filters.Base64Utils;
import new_opd.transaction.controller.data.OPDQMSDATA;
import new_opd.transaction.controller.fb.OPDQMSFB;



public class OPDDisplayBoard extends DispatchAction
{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		OPDQMSFB formBean = (OPDQMSFB) form;
		return this.QMS(mapping, formBean, request, response);
	}
	
	public ActionForward QMS(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("123::::::::::");
		OPDQMSFB formBean = (OPDQMSFB) form;
		String json= new String(Base64.getDecoder().decode(formBean.getStrKeys()));
		request.getSession().setAttribute("departmentJson", json);
		return mapping.findForward("QMS");
	}	
	
}