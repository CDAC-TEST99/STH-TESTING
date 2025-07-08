package new_investigation.reports.controller.data;


import java.util.Map;
import new_investigation.reports.delegate.PatientDiagnosisReportDELEGATE;
import new_investigation.vo.PatientDiagnosisReportVO;
import hisglobal.vo.UserVO;



public class PatientDiagnosisReportDATA {

	

	public static  Map AjaxGetLabList(PatientDiagnosisReportVO vo, UserVO userVO) {
		PatientDiagnosisReportDELEGATE reportDelegate = new PatientDiagnosisReportDELEGATE();
		return reportDelegate.AjaxGetLabList(vo, userVO);
	}
	

	public static  Map AjaxGetMachineList(PatientDiagnosisReportVO vo, UserVO userVO) {
		PatientDiagnosisReportDELEGATE reportDelegate = new PatientDiagnosisReportDELEGATE();
		return reportDelegate.AjaxGetMachineList(vo, userVO);
	}
	

	public static  Map AjaxGetMachineTestReportList(PatientDiagnosisReportVO vo, UserVO userVO) {
		PatientDiagnosisReportDELEGATE reportDelegate = new PatientDiagnosisReportDELEGATE();
		return reportDelegate.AjaxGetMachineTestReportList(vo, userVO);
	}

}
