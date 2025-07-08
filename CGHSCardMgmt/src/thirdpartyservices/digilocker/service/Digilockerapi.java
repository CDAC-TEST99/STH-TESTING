package thirdpartyservices.digilocker.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import thirdpartyservices.digilocker.util.DigiLockerPullURIDocUtil;
import thirdpartyservices.digilocker.util.DigiLockerPullURIUtil;
import thirdpartyservices.digilocker.vo.PullDocRequest;
import thirdpartyservices.digilocker.vo.PullDocResponse;
import thirdpartyservices.digilocker.vo.PullURIRequest;
import thirdpartyservices.digilocker.vo.PullURIResponse;





@Path("/digilockerapi/v1")
public class Digilockerapi  {
	
	
	@POST
	@Path("/pullURI")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
	public Response handlePullURIRequest(PullURIRequest objPullURIRequest) {
        // Log the received XML request
        System.out.println("Received XML Request: \n" + objPullURIRequest);
        
        
        PullURIResponse objPullURIResponse =DigiLockerPullURIUtil.getPullUriData(objPullURIRequest);
        
        
        return Response.ok(objPullURIResponse, MediaType.APPLICATION_XML).build();
   }
	

	@POST
	@Path("/pullDoc")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
	public Response handlePullDocRequest(PullDocRequest objPullDocRequest) {
		PullDocResponse objPullDocResponse=DigiLockerPullURIDocUtil.getPullDoc(objPullDocRequest);
		return Response.ok(objPullDocResponse, MediaType.APPLICATION_XML).build();
	}
	
		
	
}
