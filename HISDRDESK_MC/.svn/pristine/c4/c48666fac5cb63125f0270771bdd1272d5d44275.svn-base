package HisWeb.webservice;

import java.text.ParseException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;

import HisWeb.dao.EHRDetailsDAO;
import HisWeb.dao.SearchEMRUtilDao;
import HisWeb.util.opdDrDeskUtil;


@Path("/search")
public class EMRSearchService {
	
	@POST
	@Path("/emr")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegistrationDepartments(@FormParam("JsonData") String JsonData ) throws JSONException, ParseException{
	//	opdDrDeskUtil.SaveDrDesk(JsonData);
		//System.out.println("JsonData"+JsonData);
		
		String Data=SearchEMRUtilDao.getSearchEmrDtls(JsonData);
		//this.InsertFormattedData(FormattedJsonDataArray);
		 return Response.ok()
	               .entity(Data)
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		//return JsonData;
	}	
	
	@GET
	@Path("/labHistoryData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLabHistoryData(@QueryParam("CrNo") String CrNo) throws Exception {
	    //System.out.println("EMR DETAIL CrNo::::::::::: \n" + CrNo);

	    JSONArray response = SearchEMRUtilDao.getLabHistoryDao(CrNo);
	    //System.out.println("EMR DETAIL response::::::::::: \n" + response);

	    return Response.ok(response.toString())
	                   .header("Access-Control-Allow-Origin", "*")
	                   .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
	                   .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
	                   .build();
	}
	@GET
	@Path("/referralHistoryData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReferralHistoryData(@QueryParam("CrNo") String CrNo) throws Exception {
	    //System.out.println("EMR DETAIL CrNo::::::::::: \n" + CrNo);

	    JSONArray response = SearchEMRUtilDao.getReferralHistoryDao(CrNo);
	    //System.out.println("EMR DETAIL response::::::::::: \n" + response);

	    return Response.ok(response.toString())
	                   .header("Access-Control-Allow-Origin", "*")
	                   .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
	                   .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
	                   .build();
	}
	@GET
	@Path("/medicalHistoryData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getmedicalHistoryData(@QueryParam("CrNo") String CrNo) throws Exception {
	    //System.out.println("EMR DETAIL CrNo::::::::::: \n" + CrNo);

	    JSONArray response = SearchEMRUtilDao.getMedicalHistoryDao(CrNo);
	    //System.out.println("EMR DETAIL response::::::::::: \n" + response);

	    return Response.ok(response.toString())
	                   .header("Access-Control-Allow-Origin", "*")
	                   .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
	                   .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
	                   .build();
	}
	
	@GET
	@Path("/getBenShortName")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBenShortName(@QueryParam("CrNo") String CrNo) throws Exception {
	    System.out.println("EMR DETAIL CrNo::::::::::: \n" + CrNo);

	    JSONArray response = SearchEMRUtilDao.getBenShortNameDAO(CrNo);
	    //System.out.println("EMR DETAIL response::::::::::: \n" + response);

	    return Response.ok(response.toString())
	                   .header("Access-Control-Allow-Origin", "*")
	                   .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
	                   .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
	                   .build();
	}


}
