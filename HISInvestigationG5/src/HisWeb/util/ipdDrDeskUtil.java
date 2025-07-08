package HisWeb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import HisWeb.dao.ipdDrDeskDao;

public class ipdDrDeskUtil {

	public static void SaveDrDesk(String JsonData) throws JSONException, ParseException
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		 JSONObject object = new JSONObject(JsonData);
		 Date date1=sdf.parse((String)object.getString("PatCompleteGeneralDtl").split("#")[12]);
		 Date date2=sdf.parse((String)object.getString("PatCompleteGeneralDtl").split("#")[13]);
		 
		 System.out.println("ipd object=="+object);
		 System.out.println("date1::::::"+date1);
		 System.out.println("date2::::::"+date2);
		 
		ipdDrDeskDao.SaveDrugAdviceData(JsonData);
		ipdDrDeskDao.SaveInvData(JsonData);

		  //String PatCompleteGeneralDtl=(String) object.get("PatCompleteGeneralDtl");
 			
		ipdDrDeskDao.SaveGenralData(JsonData);
		ipdDrDeskDao.SaveVisitReasonData(JsonData);
		//ipdDrDeskDao.FollowUpDTL(JsonData);			// no need to update status in HRGT_DAILY_PATIENT_DTL and HRGT_EPISODE_DTL in case of IPD 
		ipdDrDeskDao.SaveEHRData(JsonData);
		
		/*  if(PatCompleteGeneralDtl.split("#")[18].equals("1")){
		  ipdDrDeskDao.SaveEConsultancyData(JsonData); }
		  System.out.println(":::::::::::::::"+((JSONArray)object.get("strReferal")).length()); */
		  if(((JSONArray)object.get("strReferal")).length() > 0){
		  ipdDrDeskDao.saveReferPatientDetails(JsonData); }
		 
		if(((JSONArray) object.get("strChronicDisease")).length() > 0){
			ipdDrDeskDao.SaveChronicData(JsonData);
		}
		if(((JSONArray) object.get("strDrugAllergy")).length() > 0){
			ipdDrDeskDao.SaveAllergyData(JsonData);
		}
		ipdDrDeskDao.SaveHistoryOfPresentIllNess(JsonData);
		
		ipdDrDeskDao.SaveCompleteHistoryData(JsonData);
		
		ipdDrDeskDao.SaveExamniationData(JsonData);
		
		ipdDrDeskDao.SaveChiefComplaintData(JsonData);
		
		ipdDrDeskDao.SaveHoplCourseData(JsonData);
		
		if(((JSONArray) object.get("OtDtl")).length() > 0){
			ipdDrDeskDao.saveOperationDetails(JsonData);
		}
		
		ipdDrDeskDao.saveClinicalProcedure(JsonData);
	}
	
	
	
	public static void referPatient(String JsonData) throws JSONException, ParseException
	{
		//ipdDrDeskDao.saveReferPatientDetails(JsonData);
	}
	
	public static String saveVitalData(String JsonData) throws JSONException, ParseException
	{
		
		String RetValue=ipdDrDeskDao.SaveVitalData(JsonData);
		String RetValue1=ipdDrDeskDao.SaveEMRVitalData(JsonData);
		return RetValue;
	}
	
	public static String savePrescriptionProfileData(String JsonData) throws JSONException, ParseException
	{
		
		String RetValue=ipdDrDeskDao.savePrecriptionProfileData(JsonData);
		//String RetValue1=ipdDrDeskDao.SaveEMRVitalData(JsonData);
		return RetValue;
	}
	
	public static String getModifyVitalData(String JsonData) throws JSONException, ParseException
	{
		
		String RetValue=ipdDrDeskDao.getModifyVitalData(JsonData);
		return RetValue;
	}

	public static void SaveDrDeskFormattedData(String jsonData) throws JSONException {
		 JSONObject object = new JSONObject(jsonData);
		 JSONObject js = new JSONObject(jsonData);
		 String deptflg=  object.getString("strDeptIdflg");
		 String AllDeptFgl=  object.getString("strAllDeptIdflg");
		 String strPresCriptionBookmarkNameval=  object.getString("strPresCriptionBookmarkNameval");
		 
		 js.remove("Patient_Name");
		 js.remove("CR_No");
		 js.remove("EpisodeCode");
		 js.remove("EpisodeVisitNo");
		 js.remove("CurrentVisitDate");
		 js.remove("PatVisitType");
		 js.remove("LastVisitDate");
		 //js.remove("PatientGender");
		// js.remove("PatientAge");
		 
		 js.remove("PatientCat");
		 js.remove("PatientQueueNo");
		 js.remove("hrgnum_is_docuploaded");
		 js.remove("patGaurdianName");		 
		 
		 
		 /*System.out.println("After Remove All Data");*/
		 System.out.println(js.toString());
		 
		 
		ipdDrDeskDao.SaveGenralDataFormattedData(jsonData);
		if(deptflg.equals("1"))
		ipdDrDeskDao.SavePrescriptionBookMarkData(js.toString());
		
	}
	public static String getDrugRoute(String drugItemTypeId)
	{
		
		String RetValue=ipdDrDeskDao.getDrugRoute(drugItemTypeId);
		return RetValue;
	}
	public static String getMotherAdmDtl(String patAdmNo,String hospCode)
	{
		String RetValue=ipdDrDeskDao.getMotherAdmDtl(patAdmNo,hospCode);
		return RetValue;
	}
	public static String revokeDrugData(String JsonData) throws JSONException, ParseException
	{
		return ipdDrDeskDao.revokeDrugData(JsonData);
	}
}
