package new_opd.transaction.controller.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import application.filters.Base64Utils;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.utility.SecurityUtil;
import hisglobal.vo.HospitalMstVO;
import new_opd.transaction.controller.fb.DoctorDeskFB;



public class PrintPatientPrescriptionAction extends DispatchAction
{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		return this.PRINTPRESC(mapping, form, request, response);
		
	}

	
	
	public ActionForward PRINTPRESC(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		DoctorDeskFB formBean = (DoctorDeskFB) form;
		//System.out.println("Key:: "+formBean.getKey());
		String key="";
		
		if(formBean.getKey()!=null &&  !formBean.getKey().contains("%")) {
			String query="SELECT  hrstr_json_data as patientdetaljson"+
					" FROM registration.hrgt_ehrjson_dtl  where (hrstr_json_data::jsonb)->>'crc' ='"+ formBean.getKey() + "' limit 1";
		//	System.out.println("query>>>" + query);		
			JSONObject resultjson= HelperMethodsDAO.executeQueryAndReturnJsonArray(null, null, null, query);
			if(resultjson.has("data")) {
				JSONArray arr=  resultjson.getJSONArray("data");
				JSONObject obj=arr.getJSONObject(0);
				key=obj.getString("patientdetaljson");
				formBean.setKey(key);
				 
			}else {
				formBean.setKey("");
			}
			
		}
		
			
			
			
		return mapping.findForward("NEW1");
	}	
}