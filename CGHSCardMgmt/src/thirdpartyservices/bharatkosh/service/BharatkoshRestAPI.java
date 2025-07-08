package thirdpartyservices.bharatkosh.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;

@Path("/bharatkosh/v1")
public class BharatkoshRestAPI  {
	
	@POST
	@Path("/test")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response test() {
		JSONObject objFilterJson=new JSONObject();
		objFilterJson.put("trackingId", "1");
		return Response.ok(objFilterJson.toString()).build();

	}
	
	@POST
	@Path("/ds/base64SignedXml")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getBase64SignedXml(String filters) throws Exception{ 
		
		System.out.println("Filter::"+ filters);
		JSONObject objFilterJson=new JSONObject(filters);
		JSONObject objFilterJson_signed=new JSONObject(filters);
		JSONObject objResponse = new JSONObject();

		Usefulmethods objUsefulmethods = new Usefulmethods();
		String trackingId = objFilterJson.getString("tracking_id");
		String timestamp = String.valueOf(objFilterJson.get("timestamp"));
		String paymentType = String.valueOf(objFilterJson.opt("payment_type"));
		if(StringUtils.equalsIgnoreCase(paymentType, new CGHSBharatkoshVO().getPaymentMaskCode_OFFLINE())) {
			//System.out.println("inside offline");
			paymentType = new CGHSBharatkoshVO().getPaymentMaskCode_OFFLINE();
		}else {
			//System.out.println("inside online");
			paymentType = new CGHSBharatkoshVO().getPaymentMaskCode_ONLINE();
		}
		objFilterJson.put("base64SignedXml", new BharatkoshClient().sign(trackingId, timestamp, paymentType));
		//System.out.println("calling services is insertsignedxml");
		
	
		//System.out.println("Signed XML length: " + objFilterJson.getString("base64SignedXml").length());
		//System.out.println("Payload sent to DB service: " + objFilterJson_signed.toString());

	
		String strServiceName1 = "service/insertsignedxml";
		objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);
		
		return Response.ok(objFilterJson.toString()).build();

	}
	
	@POST
	@Path("/bkpaystatus")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getBKPaymentStatus(String filters) throws Exception{
		//System.out.println("Filter::"+ filters);
		JSONObject objFilterJson=new JSONObject(filters);
		String trackingId = objFilterJson.getString("tracking_id");
		return Response.ok(new BharatkoshClient().getBKPaymentStatus(trackingId).toString()).build();
	}
			
	@POST
	@Path("/loba/bkpaystatus")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response trackBKPaymentStatus(String filters) throws Exception{
		//System.out.println("Filter::"+ filters);
		JSONObject objFilterJson=new JSONObject(filters);
		String trackingId = objFilterJson.getString("tracking_id");
		return Response.ok(new BharatkoshClient().trackBKPaymentStatus(trackingId).toString()).build();
	}	
}
