package new_investigation.reports.delegate;


import hisglobal.business.Delegate;
import hisglobal.vo.UserVO;

import java.util.Map;

import new_investigation.reports.bo.SampleRejectionReportListBO;
import new_investigation.vo.SampleRejectionReportListVO;

public class SampleRejectionReportListDELEGATE extends Delegate
{
	public SampleRejectionReportListDELEGATE()
	{
		super(new SampleRejectionReportListBO());
	}  

	public Map AjaxGetLabList(SampleRejectionReportListVO vo, UserVO userVO) {
		SampleRejectionReportListBO serviceBO =(SampleRejectionReportListBO) super.getServiceProvider();
		return serviceBO.AjaxGetLabList(vo, userVO);
	}
	
	
	public Map AjaxGetMachineList(SampleRejectionReportListVO vo, UserVO userVO) {
		SampleRejectionReportListBO serviceBO =(SampleRejectionReportListBO) super.getServiceProvider();
		return serviceBO.AjaxGetMachineList(vo, userVO);
	}
	
	
	public Map AjaxGetMachineTestReportList(SampleRejectionReportListVO vo, UserVO userVO) {
		SampleRejectionReportListBO serviceBO =(SampleRejectionReportListBO) super.getServiceProvider();
		return serviceBO.AjaxGetMachineTestReportList(vo, userVO);
	}




}