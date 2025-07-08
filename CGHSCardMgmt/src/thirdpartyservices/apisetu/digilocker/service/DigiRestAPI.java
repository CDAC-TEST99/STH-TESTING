package thirdpartyservices.apisetu.digilocker.service;

import java.io.StringWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.json.JSONObject;

import thirdpartyservices.apisetu.digilocker.client.req.PullURIRequest;

@Path("/apisetu/digilocker/v1")
public class DigiRestAPI {

	@POST
	@Path("/test")
	@Produces({ MediaType.APPLICATION_XML })
	public Response test() {
		JSONObject objFilterJson=new JSONObject();
		objFilterJson.put("APPID", "BenId");
		return Response.ok(objFilterJson.toString()).build();

	}

	
	@POST
	@Path("/pull/bendtls")
	@Produces({ MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_XML })
	public Response pullBenIdDetails(PullURIRequest request) throws Exception{
		
		JAXBContext jaxbContext = JAXBContext.newInstance(PullURIRequest.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(request, sw);
		String xmlString = sw.toString();
		//System.out.println("xmlString::"+ xmlString);
		
		return Response.ok(new DigiBenDetailsService().buildDigiResponse(request)).build();

	}
}
