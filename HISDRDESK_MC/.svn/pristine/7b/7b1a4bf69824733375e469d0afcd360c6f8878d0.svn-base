package HisWeb.webservice;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import HisWeb.util.SendSMSUtil;
import HisWeb.util.opdDrDeskUtil;
import jcs.UnregisteredDrugDataManager;
import new_opd.DAO.DoctorDeskDAO;
import new_opd.vo.DoctorDeskVO;

@Path("/DrDesk")
public class opdDrDeskService {
	
	
	
	@POST
	@Path("/saveData")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response SaveDrDesk(@FormParam("JsonData") String JsonData ,@FormParam("FormattedJsonDataArray") String FormattedJsonDataArray) throws JSONException, ParseException{
		boolean flag  =false;
		
		flag =opdDrDeskUtil.SaveDrDesk(JsonData);
		if(flag) {
		//System.out.println("JsonData"+JsonData);
		//System.out.println("FormattedJsonDataArray"+FormattedJsonDataArray);
		this.InsertFormattedData(FormattedJsonDataArray);
		new SendSMSUtil().sendSMSToPatient(JsonData);
		//opdDrDeskUtil.syncPrescriptionToABHA(JsonData);
		 return Response.ok()
	               .entity(JsonData)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		}
		else {
			return Response
	                .status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(JsonData)
	                .build();			 
		}
			
		//return JsonData;
	}	
	
	@POST
	@Path("/generateCRC")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response generateCRC(@FormParam("JsonData") String JsonData) throws JSONException, ParseException{
	
		SendSMSUtil objSendSMSUtil=new SendSMSUtil();
		String resultjson=objSendSMSUtil.generateCRC(JsonData);
		 return Response.ok()
	               .entity(resultjson)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		
	}	
	

	@POST
	@Path("/saveData1")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegistrationDepartments1(@FormParam("JsonData") String JsonData ,@FormParam("FormattedJsonDataArray") String FormattedJsonDataArray ,@FormParam("DeptUnitName") String DeptUnitName) throws JSONException, ParseException{
		//opdDrDeskUtil.SaveDrDesk(JsonData);
		//System.out.println("DeptUnitName "+DeptUnitName);
		//System.out.println("FormattedJsonDataArray"+FormattedJsonDataArray);
		//this.InsertFormattedData(FormattedJsonDataArray);
		opdDrDeskUtil.SaveDrDeskFormattedData1(FormattedJsonDataArray, DeptUnitName);
		
		 return Response.ok()
	               .entity(JsonData)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		//return JsonData;
	}	
	
	
	public void InsertFormattedData(String JsonData) throws JSONException{
		opdDrDeskUtil.SaveDrDeskFormattedData(JsonData);		
	}
	
	
	@POST
	@Path("/referPatient")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response referPatient(@FormParam("JsonData") String JsonData) throws JSONException, ParseException{
		opdDrDeskUtil.referPatient(JsonData);
		//System.out.println("JsonData"+JsonData);
		
		 return Response.ok()
	               .entity(JsonData)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		//return JsonData;
	}	
	
	
	@GET
	@Path("/drugList")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDrugList(@FormParam("JsonData") String JsonData) throws JSONException, ParseException{
		DoctorDeskVO vo = new DoctorDeskVO();
		vo.setStrHospitalCode("37913");
		vo.setStrSeatId("10018");
		DoctorDeskDAO.getdrugdtl(vo);
		Map<String ,List> DrugMap=null;
		List <String> DrugList=null;
        JSONArray obj2 = new JSONArray();   
		try{
			DrugMap=new HashMap<String , List>();
			if(vo.getStrDrugWb().size() > 0)
			{
				while(vo.getStrDrugWb().next())
				{
				
					DrugList=new ArrayList<String>();
				int ColumnLength=	vo.getStrDrugWb().getMetaData().getColumnCount();
					for(int i=1 ;i<=ColumnLength;i++)
					{
						DrugList.add(vo.getStrDrugWb().getString(i));
					}
					DrugMap.put(vo.getStrDrugWb().getString(2), DrugList);
				}
			}
			
			HashMap<String ,List> map1 = (HashMap) DrugMap;  
				for(Map.Entry m1:map1.entrySet()){  
                      JSONObject obj = new JSONObject(); 
                      ArrayList lst = (ArrayList) m1.getValue();
					  obj.put("drugName", lst.get(1)!=null?lst.get(1):"");
					  obj.put("drugId", lst.get(0)!=null?lst.get(0):"");
					  obj.put("drugQuan", lst.get(2)!=null?(lst.get(2).equals("0")?"":lst.get(2)):"");
					  obj.put("expDate", lst.get(3)!=null?lst.get(3):"");
					  obj.put("mfcDate", lst.get(4)!=null?lst.get(4):"");
					  obj.put("rate", lst.get(5)!=null?lst.get(5):"");
                      obj2.put(obj);
				}
		}
		catch(Exception e){
			
		}
		//System.out.println("JsonData"+obj2);
		
		 return Response.ok()
	               .entity(obj2.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		//return JsonData;
	}
	@GET
	@Path("/diagnosisList")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDiagnosisList(@FormParam("JsonData") String JsonData) throws JSONException, ParseException{
		DoctorDeskVO vo = new DoctorDeskVO();
		vo.setStrHospitalCode("37913");
		vo.setStrSeatId("10018");
		vo.setStrDeptCode("0");
		vo.setStrRoomCode("0");
		DoctorDeskDAO.getDIAGNOSISDtl(vo);
		Map<String ,List> DiagnosisMap=null;
		List <String> DiagnosisList=null;
        JSONArray mapIcdCodeLst = new JSONArray();   
		try{ 
			DiagnosisMap=new HashMap<String , List>();
			if(vo.getStrDiagnosisWb().size() > 0)
			{
				while(vo.getStrDiagnosisWb().next())
				{
				
					DiagnosisList=new ArrayList<String>();
				int ColumnLength=	vo.getStrDiagnosisWb().getMetaData().getColumnCount();
					for(int i=1 ;i<=ColumnLength;i++)
					{
						DiagnosisList.add(vo.getStrDiagnosisWb().getString(i));
					}
					DiagnosisMap.put(vo.getStrDiagnosisWb().getString(1), DiagnosisList);
				}
			}
			 
			for(Map.Entry mapIcdCodeItem:DiagnosisMap.entrySet()){  
                  JSONObject mapIcdCodeLstSubObj = new JSONObject(); 
				  String strCode=(String)mapIcdCodeItem.getKey();
                  ArrayList lst = (ArrayList) mapIcdCodeItem.getValue();
                  mapIcdCodeLstSubObj.put("icdCode", strCode!=null?strCode:"");
                  mapIcdCodeLstSubObj.put("diagnosisName", lst.get(1)!=null?lst.get(1):""); 
                  mapIcdCodeLst.put(mapIcdCodeLstSubObj);
			} 
		}
		catch(Exception e){
			
		}
		//System.out.println("JsonData"+mapIcdCodeLst);
		
		 return Response.ok()
	               .entity(mapIcdCodeLst.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		//return JsonData;
	}
	
	
	@POST
	@Path("/saveVital")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveVitalData(@FormParam("JsonData") String JsonData) throws JSONException, ParseException{
		String RetValue=opdDrDeskUtil.saveVitalData(JsonData);
		//System.out.println("JsonData"+JsonData);
		 return Response.ok()
	               .entity(RetValue)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		//return JsonData;
	}

	@POST
	@Path("/ModifyVital")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response ModifyVital(@FormParam("JsonData") String JsonData) throws JSONException, ParseException{
		String RetValue=opdDrDeskUtil.getModifyVitalData(JsonData);
		//System.out.println("RetValue"+RetValue);
		 return Response.ok()
	               .entity(RetValue)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
	}
	
	@POST
	@Path("/savePrscriptionProfileData")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePrscriptionProfileData(@FormParam("JsonData") String JsonData) throws JSONException, ParseException{
		String RetValue=opdDrDeskUtil.savePrescriptionProfileData(JsonData);
		//System.out.println("JsonData"+JsonData);
		 return Response.ok()
	               .entity(RetValue)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		//return JsonData;
	}
	
	@POST
	@Path("/saveOfflinePatCountDtl")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveOfflinePatCountDtl(@FormParam("JsonData") String JsonData) throws JSONException, ParseException{
		String RetValue=opdDrDeskUtil.saveOfflinePatCountDtl(JsonData);
		//System.out.println("JsonData"+JsonData);
		 return Response.ok()
	               .entity(RetValue)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		//return JsonData;
	}
	
	@POST
	@Path("/getAllPreviousVitalDtls")   
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })	
	public Response getAllPreviousVitalDtls(String JsonData) {
		String RetValue;
		try {
			RetValue = opdDrDeskUtil.getAllPreviousVitalDtls(JsonData);
			return Response.ok(RetValue).build();	
		} catch (JSONException | ParseException e) {
			return Response
	                .status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(
	                String.format("{\"status\":\"0\"}"))
	                .build();
		}
		//System.out.println("RetValue"+RetValue);
		
	}
	
	@POST
	@Path("/ReferralVisitStamping")   
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })	
	public Response ReferralVisitStamping(String JsonData) {
		boolean RetValue=false;
		try {
			
			RetValue = opdDrDeskUtil.ReferralVisitStamping(JsonData);
			if(RetValue)
				return Response.ok("{\"status\":\"1\"}").build();
			else {
				return Response
		                .status(Response.Status.INTERNAL_SERVER_ERROR)
		                .entity(String.format("{\"status\":\"0\"}")).build();
			}
		} catch (Exception e) {
			return Response
	                .status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(String.format("{\"status\":\"0\"}")).build();
		}
		
		
	}
	
	@POST
	@Path("/blockReleaseStoreQuantity")   
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })	
	public Response blockReleaseStoreQuantity(String JsonData ) throws JSONException, ParseException{
		
		JSONObject resultObject= new JSONObject();
		resultObject.put("status", "ERROR");
		resultObject =opdDrDeskUtil.blockReleaseStoreQuantity(JsonData);
		if(resultObject.has("status") && resultObject.getString("status").equals("SUCCESS")) {
		 return Response.ok()
	               .entity(resultObject.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		}
		else {
			resultObject.put("status", "ERROR");
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity(resultObject.toString())
	                .build();			 
		}
	}
	
	
	@POST
	@Path("/savePatientReview")   
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })	
	public Response savePatientReview(String JsonData ) throws JSONException, ParseException{
		
		JSONObject resultObject= new JSONObject();
		resultObject.put("status", "ERROR");
		resultObject =opdDrDeskUtil.savePatientReview(JsonData);
		if(resultObject.has("status") && resultObject.getString("status").equals("SUCCESS")) {
		 return Response.ok()
	               .entity(resultObject.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		}
		else {
			resultObject.put("status", "ERROR");
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity(resultObject.toString())
	                .build();			 
		}
	}
	
	
	@POST
	@Path("/AcceptPatientFromPoolSmartQMS")   
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })	
	public Response AcceptPatientFromPoolSmartQMS(String JsonData ) throws JSONException, ParseException{
		
		JSONObject resultObject= new JSONObject();
		resultObject.put("status", "ERROR");
		resultObject =opdDrDeskUtil.AcceptPatientFromPoolSmartQMS(JsonData);
		if(resultObject.has("status") && resultObject.getString("status").equals("SUCCESS")) {
		 return Response.ok()
	               .entity(resultObject.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		}
		else {
			resultObject.put("status", "ERROR");
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity(resultObject.toString())
	                .build();			 
		}
	}
	
	
	
	@POST
	@Path("/UpdateQueueStatus_For_Withoutsmartqueue")   
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })	
	public Response UpdateQueueStatus_For_Withoutsmartqueue(String JsonData ) throws JSONException, ParseException{
		
		JSONObject resultObject= new JSONObject();
		resultObject.put("status", "ERROR");
		resultObject =opdDrDeskUtil.UpdateQueueStatus_For_Withoutsmartqueue(JsonData);
		if(resultObject.has("status") && resultObject.getString("status").equals("SUCCESS")) {
		 return Response.ok()
	               .entity(resultObject.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		}
		else {
			resultObject.put("status", "ERROR");
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity(resultObject.toString())
	                .build();			 
		}
	}
	
	
	@POST
	@Path("/saveSectionBookmark")   
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })	
	public Response saveSectionBookmark(String JsonData ) throws JSONException, ParseException{
		
		JSONObject resultObject= new JSONObject();
		resultObject.put("status", "ERROR");
		resultObject =opdDrDeskUtil.saveSectionBookmark(JsonData);
		if(resultObject.has("status") && resultObject.getString("status").equals("SUCCESS")) {
		 return Response.ok()
	               .entity(resultObject.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		}
		else {
			resultObject.put("status", "ERROR");
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity(resultObject.toString())
	                .build();			 
		}
	}
	
	@POST
	@Path("/UpdateQueueStatus_For_WithoutsmartqueueForApt")   
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })	
	public Response UpdateQueueStatus_For_WithoutsmartqueueForApt(String JsonData ) throws JSONException, ParseException{
		
		JSONObject resultObject= new JSONObject();
		resultObject.put("status", "ERROR");
		resultObject =opdDrDeskUtil.UpdateQueueStatus_For_WithoutsmartqueueForApt(JsonData);
		if(resultObject.has("status") && resultObject.getString("status").equals("SUCCESS")) {
		 return Response.ok()
	               .entity(resultObject.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		}
		else {
			resultObject.put("status", "ERROR");
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity(resultObject.toString())
	                .build();			 
		}
	}
	

	@POST
	@Path("/saveReferralData")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveReferralData( String JsonData) throws JSONException, ParseException{
		boolean flag  =false;
		
		flag =opdDrDeskUtil.saveReferralData(JsonData);
		if(flag) {
		 return Response.ok()
	               .entity(JsonData)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		}
		else {
			return Response
	                .status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(JsonData)
	                .build();			 
		}
			
		//return JsonData;
	}	
	
	
	@GET
	@Path("/clearDrugCache")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response clearDrugCache( String JsonData) {
		
		
		UnregisteredDrugDataManager.getInstance().removeAllFromDrugDataObj();
		return Response.ok()
	               .entity("{\"status\":\"Success\"}")
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		
	}	
	
	
}
