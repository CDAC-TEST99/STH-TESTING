package new_investigation.reports.controller.data;


import java.util.Map;
import new_investigation.reports.delegate.SampleRejectionReportListDELEGATE;
import new_investigation.vo.SampleRejectionReportListVO;
import hisglobal.vo.UserVO;



public class SampleRejectionReportListDATA {

	

	public static  Map AjaxGetLabList(SampleRejectionReportListVO vo, UserVO userVO) {
		SampleRejectionReportListDELEGATE reportDelegate = new SampleRejectionReportListDELEGATE();
		return reportDelegate.AjaxGetLabList(vo, userVO);
	}
	

	public static  Map AjaxGetMachineList(SampleRejectionReportListVO vo, UserVO userVO) {
		SampleRejectionReportListDELEGATE reportDelegate = new SampleRejectionReportListDELEGATE();
		return reportDelegate.AjaxGetMachineList(vo, userVO);
	}
	

	public static  Map AjaxGetMachineTestReportList(SampleRejectionReportListVO vo, UserVO userVO) {
		SampleRejectionReportListDELEGATE reportDelegate = new SampleRejectionReportListDELEGATE();
		return reportDelegate.AjaxGetMachineTestReportList(vo, userVO);
	}

}
