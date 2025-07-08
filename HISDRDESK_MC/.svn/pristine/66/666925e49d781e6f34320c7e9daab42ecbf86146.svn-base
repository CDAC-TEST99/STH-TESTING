package new_opd.transaction.controller.action;



import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import new_opd.transaction.controller.data.OPDQueueDisplayForPatientDATA;
import new_opd.transaction.controller.fb.OPDQMSFB;



public class OPDQueueDisplayForPatient extends DispatchAction
{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		OPDQMSFB formBean = (OPDQMSFB) form;
		return this.QMS(mapping, formBean, request, response);
	}
	
	public ActionForward QMS(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		OPDQMSFB formBean = (OPDQMSFB) form;
		String benId=formBean.getBenId();
		if(StringUtils.isBlank(benId) && StringUtils.isNotBlank(formBean.getUserId())) {
			request.getSession().setAttribute("userId", formBean.getUserId());
			byte[] decodedBytes = Base64.getDecoder().decode(formBean.getUserId());
	        String userId = new String(decodedBytes);
			
			benId =userId.replace("^", "#").split("#")[0];
			formBean.setBenId(benId);
			request.getSession().setAttribute("isHeaderRequired", "0");
		}
		else {
			request.getSession().setAttribute("isHeaderRequired", "1");
		}
		
		
		if(StringUtils.isNotBlank(benId)) {
			request.getSession().setAttribute("benId", formBean.getBenId());
			String json =OPDQueueDisplayForPatientDATA.getPatientQueueDtl(formBean);
			if(json!=null) {
				request.getSession().setAttribute("departmentJson", json);
			}
			else {
				request.setAttribute("errorMsg", "No Queue detail found for beneficiary!");				
			}
		}
		else {
			request.setAttribute("errorMsg", "No Queue detail found for beneficiary!");
		}
		return mapping.findForward("QMS");
	}	
	
}