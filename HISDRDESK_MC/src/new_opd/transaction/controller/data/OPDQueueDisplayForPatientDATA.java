package new_opd.transaction.controller.data;

import org.json.JSONArray;

import new_opd.bo.DoctorDeskBO;
import new_opd.transaction.controller.fb.OPDQMSFB;

public class OPDQueueDisplayForPatientDATA {

	public static String getPatientQueueDtl(OPDQMSFB formBean) {
		JSONArray objjson = new JSONArray();
		try {
			DoctorDeskBO bo = new DoctorDeskBO();
			objjson = bo.getPatientQueueDtl(formBean.getBenId());
			
			

		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			
		}
		return objjson.toString();
	}

}
