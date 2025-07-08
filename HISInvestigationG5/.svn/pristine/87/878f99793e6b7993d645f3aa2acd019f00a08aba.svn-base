package new_investigation.reports.delegate;


import hisglobal.business.Delegate;
import hisglobal.vo.UserVO;

import java.util.Map;

import new_investigation.reports.bo.PatientDiagnosisReportBO;
import new_investigation.vo.PatientDiagnosisReportVO;

public class PatientDiagnosisReportDELEGATE extends Delegate
{
	public PatientDiagnosisReportDELEGATE()
	{
		super(new PatientDiagnosisReportBO());
	}  

	public Map AjaxGetLabList(PatientDiagnosisReportVO vo, UserVO userVO) {
		PatientDiagnosisReportBO serviceBO =(PatientDiagnosisReportBO) super.getServiceProvider();
		return serviceBO.AjaxGetLabList(vo, userVO);
	}
	
	
	public Map AjaxGetMachineList(PatientDiagnosisReportVO vo, UserVO userVO) {
		PatientDiagnosisReportBO serviceBO =(PatientDiagnosisReportBO) super.getServiceProvider();
		return serviceBO.AjaxGetMachineList(vo, userVO);
	}
	
	
	public Map AjaxGetMachineTestReportList(PatientDiagnosisReportVO vo, UserVO userVO) {
		PatientDiagnosisReportBO serviceBO =(PatientDiagnosisReportBO) super.getServiceProvider();
		return serviceBO.AjaxGetMachineTestReportList(vo, userVO);
	}




}