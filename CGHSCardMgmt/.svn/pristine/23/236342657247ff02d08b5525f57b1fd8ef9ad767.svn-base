package formFlowX.dao;

import hisglobal.transactionmgnt.HisDAO;

public class FormFlowXDao {

	public static String getBenValidationValue(String strMode, String strBenId, String strHospCode) {

		HisDAO dao = null;
		String strParamValue = null;

		try {

			dao = new HisDAO("card Mgmt", "FormFlowXDao");
			// config_dtl (modval NUMBER, hosp_code NUMBER, paramname VARCHAR2)
			String strFuncName = "{? = call pkg_cghs_card_bulk_renewal.get_ben_dtl (?, ?, ?)}";
			// FUNCTION get_groupNameAndId_dtl (modeval NUMBER, hosp_code
			// NUMBER, itemId NUMBER)
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, strMode);
			dao.setFuncInValue(nFuncIndex, 3, strBenId);
			dao.setFuncInValue(nFuncIndex, 4, strHospCode);
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strParamValue = dao.getFuncString(nFuncIndex);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return strParamValue;

	}

}
