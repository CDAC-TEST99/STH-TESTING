package new_investigation.transactions.controller.data;

import java.util.List;
import java.util.Map;

import hisglobal.utility.Entry;
import hisglobal.vo.UserVO;
import new_investigation.transactions.dao.NEWOfflineResultEntryServiceDAO;
//import new_investigation.transactions.delegate.InvestigationEssentialOfflineDelegate;
import new_investigation.transactions.delegate.InvestigationEssentialOfflineDelegate;
import new_investigation.vo.Inv_EpisodeVO;
import new_investigation.vo.Inv_PatientAdmissionDtlVO;
import new_investigation.vo.Inv_RequisitionRaisingPatientVO;
import new_investigation.vo.NEWOfflineResultEntryVO;


public class NEWOfflineResultEntryDATA
{
	public static List<NEWOfflineResultEntryVO> getSampleCollectionArea(UserVO userVO)
	{
		InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
		return daoDelegate.getSampleCollectionArea(userVO);
	}
	
	public static List<NEWOfflineResultEntryVO> getPatList(NEWOfflineResultEntryVO objSampleCollectionVO, UserVO userVO)
	{
		InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
		return daoDelegate.getPatList(objSampleCollectionVO,userVO);
	}
	
	
//	public void  getOfflineTestDetail(NEWOfflineResultEntryVO invresultentryvo, UserVO _UserVO)
//	{    //nandini
//		
//		NEWOfflineResultEntryDAO onlinePatientDao = new NEWOfflineResultEntryDAO();			
//		onlinePatientDao.getOfflineTestDetail(invresultentryvo,_UserVO);
//	}
	
//public void getHospitalList(	NEWOfflineResultEntryVO invresultentryvo) {
//		
//	  NEWOfflineResultEntryDAO offlineResEntryDao = new NEWOfflineResultEntryDAO();			
//		offlineResEntryDao.getHospitalList(invresultentryvo);
//	}
	
//	public void insertOffllineResultEntry(InvOfflineResultEntryVO vo) {
//		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
//		
//		try {
//		offlineResEntryDao.insertOffllineResultEntry(vo);
//		
//			if(vo.getStrMsgType().equals("1"))
//			{
//				throw new Exception(vo.getStrMsgString());
//			}
//			else
//				vo.setStrMsgString("Data Saved Successfully ! ");
//		
//		}catch(Exception e) {
//			e.printStackTrace();
//			vo.setStrMsgString("InvOfflineResultEntryDATA.insertOffllineResultEntry() --> "+ e.getMessage());
//		}
//	}
//
//	
//	public void getOffllineResultEntryPatientData(InvOfflineResultEntryVO vo) {
//		
//		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
//		offlineResEntryDao.getOffllineResultEntryPatientData(vo);
//		
//	}
//
//	public void getOffllineResultEntryPatientTestData(InvOfflineResultEntryVO vo) {
//
//		InvOfflineResultEntryDAO offlineResEntryDao = new InvOfflineResultEntryDAO();			
//		offlineResEntryDao.getOffllineResultEntryPatientTestData(vo);
//	}	
//	
	
	
	
	public  List<NEWOfflineResultEntryVO> getOfflineTestDetail(NEWOfflineResultEntryVO objSampleCollectionVO, UserVO userVO,String mode)
	{
		InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
		return daoDelegate.getOfflineTestDetail(objSampleCollectionVO,userVO,mode);
	}	
	
	
	
	
public  List<NEWOfflineResultEntryVO> getHospitalList(NEWOfflineResultEntryVO objSampleCollectionVO, UserVO userVO)
{
	InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
	return daoDelegate.getHospitalList(objSampleCollectionVO,userVO);
}



	/*
	 * public List<NEWOfflineResultEntryVO>
	 * insertOffllineResultEntry(NEWOfflineResultEntryVO
	 * objSampleCollectionVO,UserVO userVO) {
	 * System.out.println("dfdsf"+objSampleCollectionVO.getPatCRNo());
	 * InvestigationEssentialOfflineDelegate daoDelegate=new
	 * InvestigationEssentialOfflineDelegate();
	 * System.out.println("vo.getPatCRNo() 17::\t"+objSampleCollectionVO.getPatCRNo(
	 * ));
	 * System.out.println("vo.getPatDOB()::\t"+objSampleCollectionVO.getPatDOB());
	 * System.out.println("vo.getPatMobileNo()::\t"+objSampleCollectionVO.
	 * getPatMobileNo()); return
	 * daoDelegate.insertOffllineResultEntry(objSampleCollectionVO,userVO); }
	 */

public List<NEWOfflineResultEntryVO> insertOffllineResultEntry(NEWOfflineResultEntryVO objSampleCollectionVO,UserVO userVO)
{
	InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
	System.out.println("vo.getPatCRNo() 17::\t"+objSampleCollectionVO.getPatCRNo());
	System.out.println("vo.getPatDOB()::\t"+objSampleCollectionVO.getPatDOB());  
	System.out.println("vo.getPatMobileNo()::\t"+objSampleCollectionVO.getPatMobileNo());
	return daoDelegate.insertOffllineResultEntry(objSampleCollectionVO,userVO);    
}	
//insertOffllineResultEntryBilling

public List<NEWOfflineResultEntryVO> insertOffllineResultEntryBilling(NEWOfflineResultEntryVO objSampleCollectionVO,UserVO userVO)
{
	InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
	System.out.println("vo.getPatCRNo() 17::\t"+objSampleCollectionVO.getPatCRNo());
	System.out.println("vo.getPatDOB()::\t"+objSampleCollectionVO.getPatDOB());  
	System.out.println("vo.getPatMobileNo()::\t"+objSampleCollectionVO.getPatMobileNo());
	return daoDelegate.insertOffllineResultEntryBilling(objSampleCollectionVO,userVO);    
}

//onlineReqResultEntry
public List<NEWOfflineResultEntryVO> onlineReqResultEntry(String onlineReqJson,UserVO userVO)
{
	InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
	return daoDelegate.onlineReqResultEntry(onlineReqJson,userVO);    
}	



public static List<NEWOfflineResultEntryVO> insertAlreadyRegPat(NEWOfflineResultEntryVO objSampleCollectionVO,UserVO userVO)
{
	InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
	return daoDelegate.insertAlreadyRegPat(objSampleCollectionVO,userVO);      
}	
	

public  List<NEWOfflineResultEntryVO> getOffllineResultEntryPatientCount(NEWOfflineResultEntryVO objSampleCollectionVO,UserVO userVO)
{
	InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
	return daoDelegate.getOffllineResultEntryPatientCount(objSampleCollectionVO,userVO);      
}	
	

public  List<NEWOfflineResultEntryVO> getOffllineResultEntryPatientData(NEWOfflineResultEntryVO objSampleCollectionVO, UserVO userVO)
{
	InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
	return daoDelegate.getOffllineResultEntryPatientData(objSampleCollectionVO,userVO);
}	




public  List<NEWOfflineResultEntryVO> getOffllineResultEntryPatientTestData(NEWOfflineResultEntryVO objSampleCollectionVO, UserVO userVO)
{
	InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
	return daoDelegate.getOffllineResultEntryPatientTestData(objSampleCollectionVO,userVO);
}	

//public void  getOfflineTestDetail(InvOfflineResultEntryVO invresultentryvo, UserVO _UserVO)
//{
//	
//	InvOfflineResultEntryDAO onlinePatientDao = new InvOfflineResultEntryDAO();			
//	onlinePatientDao.getOfflineTestDetail(invresultentryvo,_UserVO);
//}


	/*
	 * public static Map searchLabWiseTestDetails(InvestigationSearchVO
	 * searchVO,UserVO userVO) { InvestigationEssentialOfflineDelegate daoDelegate=new
	 * InvestigationEssentialOfflineDelegate(); return
	 * daoDelegate.searchLabWiseTestDetails(searchVO,userVO); }
	 * 
	 * 
	 */
	
	
	//Sample Collection Save Logic
	public static List saveSampleCollectionDetails(Map<String,Map<String,Map<String,List<NEWOfflineResultEntryVO>>>> mp,UserVO _userVO)
	{
		InvestigationEssentialOfflineDelegate daoDelegate=new InvestigationEssentialOfflineDelegate();
		return daoDelegate.saveSampleCollectionDetails(mp,_userVO);
	}
	 
		public static List<Inv_EpisodeVO> getPatientEpisodeDetailEssentials(Inv_RequisitionRaisingPatientVO patVO,UserVO _userVO)
		{
			InvestigationEssentialOfflineDelegate daoDelegate=new InvestigationEssentialOfflineDelegate();
			return daoDelegate.getPatientEpisodeDetail(patVO,_userVO);
		}
		
		 
		public static List<Inv_PatientAdmissionDtlVO> getPatientAdmissionDetailEssentials(Inv_RequisitionRaisingPatientVO patVO,UserVO _userVO)
		{
			InvestigationEssentialOfflineDelegate daoDelegate=new InvestigationEssentialOfflineDelegate();
			return daoDelegate.getPatientAdmissionDetail(patVO,_userVO);
		}
		
		public static Map getBilledPatList(List<String> reqList,NEWOfflineResultEntryVO voSample,UserVO userVO)
		{
			InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
			return daoDelegate.getBilledPatList(reqList,voSample,userVO);
		}
		
		public static List<String> getStaffDetails(String crNo, UserVO _UserVO)
		{
			InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
			return daoDelegate.getStaffDetails(crNo, _UserVO);
		}
		
		public static boolean checkSampleNoDuplicacy(NEWOfflineResultEntryVO voSample,UserVO userVO)
		{
			InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
			return daoDelegate.checkSampleNoDuplicacy(voSample, userVO);
		}
	
		
		public static String checkAutoGenFormate(NEWOfflineResultEntryVO voSample,UserVO userVO)
		{
			InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
			return daoDelegate.checkAutoGenFormate(voSample, userVO);
		}
		
		public static List<NEWOfflineResultEntryVO> getPatListBarcode(NEWOfflineResultEntryVO objSampleCollectionVO, UserVO userVO)
		{
			InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
			return daoDelegate.getPatListBarcode(objSampleCollectionVO,userVO);
		}
		//added by krishnan nema on 25042019
		public static List<NEWOfflineResultEntryVO> getPatListSampleColAdvance(NEWOfflineResultEntryVO objSampleCollectionVO, UserVO userVO)
		{
			InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
			return daoDelegate.getPatListSampleColAdvance(objSampleCollectionVO,userVO);
		}
		
		public static String getsamplebarcodeconfig(UserVO userVO)
		{
			InvestigationEssentialOfflineDelegate   daoDelegate=new InvestigationEssentialOfflineDelegate();
			return daoDelegate.getsamplebarcodeconfig( userVO);
		}
		
		//AjaxBilledUnbilledDetails
		
		public static String AjaxBilledUnbilledDetails(NEWOfflineResultEntryVO vo, UserVO userVO) {
			InvestigationEssentialOfflineDelegate reportDelegate = new InvestigationEssentialOfflineDelegate();
			return reportDelegate.AjaxBilledUnbilledDetails(vo, userVO);
		}
		//AjaxGetDetails
		public static String AjaxGetDetails(NEWOfflineResultEntryVO vo, UserVO userVO) {
			InvestigationEssentialOfflineDelegate reportDelegate = new InvestigationEssentialOfflineDelegate();
			return reportDelegate.AjaxGetDetails(vo, userVO);
		}
		
		public static String getcollectionareafromward(String wardcode,String hospitalcode) {
			InvestigationEssentialOfflineDelegate reportDelegate = new InvestigationEssentialOfflineDelegate();
			return reportDelegate.getcollectionareafromward(wardcode, hospitalcode);
		}

	
}
