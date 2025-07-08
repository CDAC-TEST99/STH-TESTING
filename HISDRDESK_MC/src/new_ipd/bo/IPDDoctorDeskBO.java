package new_ipd.bo;

import javax.servlet.http.HttpServletRequest;

import new_ipd.dao.IPDDoctorDeskDAO;
import new_ipd.vo.IPDDoctorDeskVO;
import new_opd.DAO.IpdDoctorDeskDAO;

public class IPDDoctorDeskBO {

	public void getInitilasData(IPDDoctorDeskVO vo) {
		
		//IPDDoctorDeskDAO.getDeptDtl(vo);
		IPDDoctorDeskDAO.getInitilaData(vo);
		IPDDoctorDeskDAO.getConfigData(vo);
		IPDDoctorDeskDAO.getInvestogation(vo);
		IPDDoctorDeskDAO.getdrugdtl(vo);
		IPDDoctorDeskDAO.getdrug_dosage_dtl(vo);
		IPDDoctorDeskDAO.getMacrosDtl(vo);
		IPDDoctorDeskDAO.getRefferalDeptDtl(vo);
		IPDDoctorDeskDAO.getBookMarksTestDtl(vo);
		IPDDoctorDeskDAO.getGroupTestDtl(vo);
		IPDDoctorDeskDAO.getDIAGNOSISDtl(vo);
		IPDDoctorDeskDAO.getClinicalProcedureDtls(vo);
		IPDDoctorDeskDAO.getDrugProfileDtl(vo);
		IPDDoctorDeskDAO.getPresriptionProfileDtl(vo);
		IPDDoctorDeskDAO.getpatientTeleConsultancyData(vo);
		IPDDoctorDeskDAO.getpatientRefferalConsultancyData(vo);
		IPDDoctorDeskDAO.getTemplateDtl(vo);
		IPDDoctorDeskDAO.getDrugProfileDtl(vo);
		IPDDoctorDeskDAO.getHospitalHeaderName(vo);
		IPDDoctorDeskDAO.getExternalHospital(vo);
		IPDDoctorDeskDAO.getExternalInstitute(vo);
		IPDDoctorDeskDAO.getExternalDepartmentList(vo);
		IPDDoctorDeskDAO.getEmpanelledDepartmentList(vo);
		IPDDoctorDeskDAO.getServiceAreaList(vo);
		IPDDoctorDeskDAO.getOperationList(vo);
		IPDDoctorDeskDAO.getSurgeonList(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("getInitilaData.getInitilasData() --> "
					+ vo.getStrMsgString());
		}
	}
public void getInitilasData1(IPDDoctorDeskVO vo , HttpServletRequest request) {
		
		IPDDoctorDeskDAO.getDeptDtl(vo,request);
		IPDDoctorDeskDAO.getWardDtl(vo,request);
		/*IPDDoctorDeskDAO.getInitilaData(vo);
		IPDDoctorDeskDAO.getInvestogation(vo);
		IPDDoctorDeskDAO.getdrugdtl(vo);
		IPDDoctorDeskDAO.getdrug_dosage_dtl(vo);
		IPDDoctorDeskDAO.getMacrosDtl(vo);
		IPDDoctorDeskDAO.getRefferalDeptDtl(vo);
		IPDDoctorDeskDAO.getBookMarksTestDtl(vo);
		IPDDoctorDeskDAO.getDIAGNOSISDtl(vo);
		IPDDoctorDeskDAO.getClinicalProcedureDtls(vo);*/
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("getInitilaData.getInitilasData() --> "
					+ vo.getStrMsgString());
		}
	}
	

public void getInitilasDataForMobileApp(IPDDoctorDeskVO vo , HttpServletRequest request) {
	
	IPDDoctorDeskDAO.getDeptDtl(vo,request);
	IPDDoctorDeskDAO.getInitilaData(vo);
	IPDDoctorDeskDAO.getInvestogation(vo);
	IPDDoctorDeskDAO.getdrugdtl(vo);
	IPDDoctorDeskDAO.getdrug_dosage_dtl(vo);
	IPDDoctorDeskDAO.getMacrosDtl(vo);
	IPDDoctorDeskDAO.getRefferalDeptDtl(vo);
	IPDDoctorDeskDAO.getBookMarksTestDtl(vo);
	IPDDoctorDeskDAO.getDIAGNOSISDtl(vo);
	IPDDoctorDeskDAO.getClinicalProcedureDtls(vo);
	IPDDoctorDeskDAO.getDrugProfileDtl(vo);
	IPDDoctorDeskDAO.getPresriptionProfileDtl(vo);
	IPDDoctorDeskDAO.getpatientTeleConsultancyData(vo);
	IPDDoctorDeskDAO.getpatientRefferalConsultancyData(vo);
	IPDDoctorDeskDAO.getDrugProfileDtl(vo);
	IPDDoctorDeskDAO.getExternalHospital(vo);
	IPDDoctorDeskDAO.getExternalInstitute(vo);
	IPDDoctorDeskDAO.getHospitalHeaderName(vo);
	IPDDoctorDeskDAO.getExternalDepartmentList(vo);
	IPDDoctorDeskDAO.getHospitalHeaderName(vo);
	IPDDoctorDeskDAO.getExternalHospital(vo);
	IPDDoctorDeskDAO.getExternalInstitute(vo);
	IPDDoctorDeskDAO.getExternalDepartmentList(vo);
	IPDDoctorDeskDAO.getServiceAreaList(vo);
	
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("getInitilaData.getInitilasData() --> "
				+ vo.getStrMsgString());
	}
}
	public void getPrevData(IPDDoctorDeskVO vo)
	{
		IPDDoctorDeskDAO.getPrevData(vo);
		IPDDoctorDeskDAO.getPrevDataInv(vo);
		IPDDoctorDeskDAO.getPrevVisitReason(vo);
		//IPDDoctorDeskDAO.getPrevDiagnosisDtl(vo);
		IPDDoctorDeskDAO.getPrevVitalDtls(vo);
		IPDDoctorDeskDAO.getPrevVitalforeTeleConsultancy(vo);
		IPDDoctorDeskDAO.getPrevvisitresonData(vo);
		IPDDoctorDeskDAO.getPrevChronicDtl(vo);
		IPDDoctorDeskDAO.getPrevAllergyDtl(vo);
		//IPDDoctorDeskDAO.getLastThreePatientVisitData(vo);
	}

	public void getHospitalHeader(IPDDoctorDeskVO vo) {
		IPDDoctorDeskDAO.getHospitalHeaderName(vo);
	}
	public void saveFileData(IPDDoctorDeskVO vo) {
		IPDDoctorDeskDAO.saveFileData(vo);
	}
}
