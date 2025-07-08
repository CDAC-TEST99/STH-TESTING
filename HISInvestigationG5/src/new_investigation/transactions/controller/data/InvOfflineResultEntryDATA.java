package new_investigation.transactions.controller.data;

import hisglobal.vo.UserVO;
import new_investigation.transactions.dao.InvOfflineResultEntryDAO;
import new_investigation.vo.InvOfflineResultEntryVO;

public class InvOfflineResultEntryDATA {
   
	public void  getOfflineTestDetail(InvOfflineResultEntryVO invresultentryvo, UserVO _UserVO)
	{
		
		InvOfflineResultEntryDAO onlinePatientDao = new InvOfflineResultEntryDAO();			
		onlinePatientDao.getOfflineTestDetail(invresultentryvo,_UserVO);
	}

	public void insertOffllineResultEntry(InvOfflineResultEntryVO vo) {
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		
		try {
		offlineResEntryDao.insertOffllineResultEntry(vo);
		
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
				vo.setStrMsgString("Data Saved Successfully ! ");
		
		}catch(Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("InvOfflineResultEntryDATA.insertOffllineResultEntry() --> "+ e.getMessage());
		}
	}

	public void getHospitalList(InvOfflineResultEntryVO invresultentryvo) {
		
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.getHospitalList(invresultentryvo);
	}
	
	/* public void getHospitalList_viewPage(OfflineResultEntryVO invresultentryvo) {
	 * 
	 * InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();
	 * offlineResEntryDao.getHospitalList_viewPage(invresultentryvo); }
	 */

	public void getOffllineResultEntryPatientData(InvOfflineResultEntryVO vo) {
		
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.getOffllineResultEntryPatientData(vo);
		
	}

	public void getOffllineResultEntryPatientTestData(InvOfflineResultEntryVO vo) {

		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.getOffllineResultEntryPatientTestData(vo);
	}

	public void viewResultEntriesList(InvOfflineResultEntryVO vo) {
		
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.viewResultEntriesList(vo);
	}

	public void viewResultEntriesListForReportView(InvOfflineResultEntryVO vo) {
		
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.viewResultEntriesListForReportView(vo);
		
	}

	public void insertAlreadyRegPat(InvOfflineResultEntryVO vo) {
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();

		try {
			offlineResEntryDao.insertAlreadyRegPat(vo);
			
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
					vo.setStrMsgString("Data Saved Successfully ! ");
			
			}catch(Exception e) {
				e.printStackTrace();
				vo.setStrMsgString("InvOfflineResultEntryDATA.insertOffllineResultEntry() --> "+ e.getMessage());
			}
	}

	public void getOffllineResultEntryPatientDataForView(InvOfflineResultEntryVO vo) {
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.getOffllineResultEntryPatientDataForView(vo);
		
	}

	public void getOffllineResultEntryPatientTestDataForView(InvOfflineResultEntryVO vo) {
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.getOffllineResultEntryPatientTestDataForView(vo);
		
	}

	public void getDuplicatePatientDtl(InvOfflineResultEntryVO vo) {
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.getDuplicatePatientDtl(vo);
		
	}

	public void getOffllineResultEntryPatientCount(InvOfflineResultEntryVO vo) {
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.getOffllineResultEntryPatientCount(vo);
	}

	public void getOffllineResultEntryPatientDataForViewPg(InvOfflineResultEntryVO vo) {
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.getOffllineResultEntryPatientDataForViewPg(vo);		
	}

	public void getOffllineResultEntryPatientTestDataForViewPg(InvOfflineResultEntryVO vo) {
		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
		offlineResEntryDao.getOffllineResultEntryPatientTestDataForViewPg(vo);		
	}

}
