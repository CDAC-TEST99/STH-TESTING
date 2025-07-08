package new_opd.bo;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import new_opd.DAO.DoctorDeskDAO;
import new_opd.vo.DoctorDeskVO;
import new_opd.vo.OPDReferralVO;

public class DoctorDeskBO {

	public void getInitilasData(DoctorDeskVO vo) {
		
		//DoctorDeskDAO.getDeptDtl(vo);
		DoctorDeskDAO.getInitilaData(vo);
		DoctorDeskDAO.getConfigData(vo);
		//DoctorDeskDAO.getInvestogation(vo);
		
		DoctorDeskDAO.getdrug_dosage_dtl(vo);
		//DoctorDeskDAO.getMacrosDtl(vo);
		
		DoctorDeskDAO.getBookMarksTestDtl(vo);
		//DoctorDeskDAO.getGroupTestDtl(vo);
		DoctorDeskDAO.getDIAGNOSISDtl(vo);
		//DoctorDeskDAO.getClinicalProcedureDtls(vo);
		//DoctorDeskDAO.getDrugProfileDtl(vo);
		DoctorDeskDAO.getPresriptionProfileDtl(vo);
		//DoctorDeskDAO.getpatientTeleConsultancyData(vo);
		//DoctorDeskDAO.getpatientRefferalConsultancyData(vo);
		//DoctorDeskDAO.getTemplateDtl(vo);
		//DoctorDeskDAO.getDrugProfileDtl(vo);
		DoctorDeskDAO.getHospitalHeaderName(vo);
		//DoctorDeskDAO.getEmpanelledDepartmentList(vo);
		//DoctorDeskDAO.getServiceAreaList(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("getInitilaData.getInitilasData() --> "
					+ vo.getStrMsgString());
		}
	}
public void getInitilasData1(DoctorDeskVO vo , HttpServletRequest request) {
		
		DoctorDeskDAO.getDeptDtl(vo,request);
		/*DoctorDeskDAO.getInitilaData(vo);
		DoctorDeskDAO.getInvestogation(vo);
		DoctorDeskDAO.getdrugdtl(vo);
		DoctorDeskDAO.getdrug_dosage_dtl(vo);
		DoctorDeskDAO.getMacrosDtl(vo);
		DoctorDeskDAO.getRefferalDeptDtl(vo);
		DoctorDeskDAO.getBookMarksTestDtl(vo);
		DoctorDeskDAO.getDIAGNOSISDtl(vo);
		DoctorDeskDAO.getClinicalProcedureDtls(vo);*/
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("getInitilaData.getInitilasData() --> "
					+ vo.getStrMsgString());
		}
	}
	

public void getInitilasDataForMobileApp(DoctorDeskVO vo , HttpServletRequest request) {
	
	DoctorDeskDAO.getDeptDtl(vo,request);
	DoctorDeskDAO.getInitilaData(vo);
	DoctorDeskDAO.getInvestogation(vo);
	DoctorDeskDAO.getdrugdtl(vo);
	DoctorDeskDAO.getdrug_dosage_dtl(vo);
	DoctorDeskDAO.getMacrosDtl(vo);
	DoctorDeskDAO.getRefferalDeptDtl(vo);
	DoctorDeskDAO.getBookMarksTestDtl(vo);
	DoctorDeskDAO.getDIAGNOSISDtl(vo);
	DoctorDeskDAO.getClinicalProcedureDtls(vo);
	DoctorDeskDAO.getDrugProfileDtl(vo);
	DoctorDeskDAO.getPresriptionProfileDtl(vo);
	DoctorDeskDAO.getpatientTeleConsultancyData(vo);
	DoctorDeskDAO.getpatientRefferalConsultancyData(vo);
	DoctorDeskDAO.getDrugProfileDtl(vo);
	DoctorDeskDAO.getExternalHospital(vo);
	DoctorDeskDAO.getExternalInstitute(vo);
	DoctorDeskDAO.getHospitalHeaderName(vo);
	DoctorDeskDAO.getExternalDepartmentList(vo);
	DoctorDeskDAO.getHospitalHeaderName(vo);
	DoctorDeskDAO.getExternalHospital(vo);
	DoctorDeskDAO.getExternalInstitute(vo);
	DoctorDeskDAO.getExternalDepartmentList(vo);
	DoctorDeskDAO.getServiceAreaList(vo);
	
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("getInitilaData.getInitilasData() --> "
				+ vo.getStrMsgString());
	}
}
	public void getPrevData(DoctorDeskVO vo)
	{
		DoctorDeskDAO.getPrevData(vo);
		DoctorDeskDAO.getPrevDataInv(vo);
		DoctorDeskDAO.getPrevVisitReason(vo);
		//DoctorDeskDAO.getPrevDiagnosisDtl(vo);
		DoctorDeskDAO.getPrevVitalDtls(vo);
		DoctorDeskDAO.getPrevVitalforeTeleConsultancy(vo);
		DoctorDeskDAO.getPrevvisitresonData(vo);
		if(vo.getStrPatReferred().equalsIgnoreCase("1")) {
			DoctorDeskDAO.getPatReferredData(vo);
		}
		//DoctorDeskDAO.getLastThreePatientVisitData(vo);
		DoctorDeskDAO.getPrevChronicDtl(vo);
		DoctorDeskDAO.getPrevAllergyDtl(vo);
		DoctorDeskDAO.getInventoryDrugPrevData(vo);
	}

	public void getHospitalHeader(DoctorDeskVO vo) {
		DoctorDeskDAO.getHospitalHeaderName(vo);
	}
	public void saveFileData(DoctorDeskVO vo) {
		DoctorDeskDAO.saveFileData(vo);
	}

	public void getRefferalDeptDtl(DoctorDeskVO vo) {
		DoctorDeskDAO.getRefferalDeptDtl(vo);
	}
	
	public void getExternalHospital(DoctorDeskVO vo) {
		DoctorDeskDAO.getExternalHospital(vo);
	}
	public void getExternalInstitute(DoctorDeskVO vo) {
		DoctorDeskDAO.getExternalInstitute(vo);
	}
	public void getExternalDepartmentList(DoctorDeskVO vo) {
		DoctorDeskDAO.getExternalDepartmentList(vo);
	}
	
	public void  getUnRegisteredDrugDtl(DoctorDeskVO vo) {
		DoctorDeskDAO.getUnRegisteredDrugDtl(vo);
	}
	public void getStoreDrugs(DoctorDeskVO vo) {
		DoctorDeskDAO.getStoreDrugs(vo);
	}
	public JSONObject queueoperationbydr(JSONObject objInputJson) {
		return DoctorDeskDAO.queueoperationbydr(objInputJson);
	}
	public void getDeptForQMS(DoctorDeskVO vo) {
		DoctorDeskDAO.getDeptForQMS(vo);
		
	}
	public JSONObject saveSickFormData(JSONObject objInputJson) {
		//System.out.println("inside saveSickFormData BO  >>> objInputJson " +objInputJson);
		return DoctorDeskDAO.saveSickFormData(objInputJson);
		
	}
	public JSONObject updateSickFormStatus(JSONObject objInputJson) {
		//System.out.println("inside updateSickFormStatus BO  >>> objInputJson " +objInputJson);
		return DoctorDeskDAO.updateSickFormStatus(objInputJson);
		
	}
	
	public JSONObject getMedFromsRecords(JSONObject objInputJson) {
		//System.out.println("inside getMedFromsRecords BO  >>> objInputJson " +objInputJson);
		return DoctorDeskDAO.getMedFromsRecords(objInputJson);
		
	}
	public JSONArray getPatientQueueDtl(String benId) {
		return DoctorDeskDAO.getPatientQueueDtl(benId);
	}
	
	public static void getReferalLists(OPDReferralVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_refral_dtl(?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("OPD","DocDeskDao");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", vo.getMode() ,1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getExternalHospital wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrExternalHospitalweb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Lite","OPDReferralDAO.getRefferalDeptDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("OPDReferralVO.getExternalHospital() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}

	
}
