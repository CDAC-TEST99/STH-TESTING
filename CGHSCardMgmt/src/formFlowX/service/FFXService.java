package formFlowX.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;





@Path("/FFXService")
public class FFXService  {
	
	
	@GET
	@Path("/test")
	@Produces({ MediaType.TEXT_PLAIN })
	public String test() {
		//System.out.println("EMMSComplaintDataWebService :: test");

		return "service is working";
	}
	
	@POST
	@Path("/callService/{serviceName}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response  getData(@PathParam("serviceName") String serviceName,String filters ) {
		JSONObject objFilterJson=null;
		JSONObject objResponse=new JSONObject();
		String queryfilename=  "formFlowX.cardMgmtQuery";
		String strServiceName=null;
		try {
			String str=Usefulmethods.getQuery(queryfilename, serviceName);
			if(str==null)
				throw new Exception();
		
		}catch(Exception e) {
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity(
	                String.format("Invalid Service Name!"))
	                .build();
		}
			try {
			objFilterJson=new JSONObject(filters);
			objFilterJson.put("processName", "/FFXService/callService/"+serviceName);
			}catch(Exception e) {
				return Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(
		                String.format("please provide valid filters for getting data!"))
		                .build();
			}
			if(objFilterJson.length()==0) {
				objFilterJson=null;//  setting to null so that filter is not used in query
			}
		
		
		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();
			strServiceName="service/"+serviceName;
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
			return Response.ok(objResponse.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
	                .status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(
	                String.format("Problem in service !"))
	                .build();
		} 
			
	}
	
	
	@POST
	@Path("/GoldenApi/getBenIdWiseDtl")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response  getBenIdWiseDtl(String filters ) {
		JSONObject objFilterJson=null;
		JSONObject objResponse=new JSONObject();
		// getBenIdWiseDtl
		try {
			objFilterJson=new JSONObject(filters);
			objFilterJson.put("processName", "/FFXService/GoldenApi/getBenIdWiseDtl");
			}catch(Exception e) {
				return Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(
		                String.format("please provide valid filters for getting data!"))
		                .build();
			}
			if(objFilterJson.length()==0) {
				objFilterJson=null;//  setting to null so that filter is not used in query
			}
		
			
			
		
		try {
			/*
			 * Usefulmethods objUsefulmethods = new Usefulmethods(); String
			 * strServiceName="service/getmaincardholderdetails"; objResponse1 =
			 * objresponse1=objUsefulmethods.callService(objFilterJson, strServiceName);
			 * 
			 * Usefulmethods objUsefulmethods = new Usefulmethods(); String
			 * strServiceName="service/getBenDepandentdtl"; objResponse2 =
			 * objresponse2=objUsefulmethods.callService(objFilterJson, strServiceName);
			 * 
			 * ftpdtl
			 */
			
			
			
			return Response.ok(objResponse.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
	                .status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(
	                String.format("Problem in service !"))
	                .build();
		} 
			
	}
	
	/*@POST
	@Path("/SAVE/{serviceInternalName}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response  DMLSAVE(@PathParam("serviceInternalName") String serviceInternalName,String inputjson ) {
		//CommonService objCommonService= new CommonService();
		return objCommonService.DMLSAVE(serviceInternalName, inputjson,moduleName);
	}*/
	
		
	
}
