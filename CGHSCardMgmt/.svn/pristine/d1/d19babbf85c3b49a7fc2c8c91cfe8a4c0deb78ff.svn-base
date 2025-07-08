package hissso.services;

import hissso.security.SecureCryptAlgorithm;
import hissso.ticket.HISServiceGrantTicket;
import hissso.validation.credentails.authorization.HISService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import application.config.HISApplicationConfig;

public class HISSSOServiceCLN
{
	// Authenticate Grant Ticket
	public HISServiceGrantTicket authenticate(String grantingTicketId, HISService objHISService, HttpServletRequest request)
	{
		HISServiceGrantTicket objHISGrantTicket = null;
		try
		{
			//System.out.println("HISSSOServiceCLN :: authenticate()");

			HISServiceSO objHISServiceSO = new HISServiceSO();
			objHISServiceSO.setVarGrantingTicketId(grantingTicketId);
			objHISServiceSO.setObjService(objHISService);

			ResteasyClient client = new ResteasyClientBuilder().build();

			String uri = HISApplicationConfig.HIS_SERVICES_SERVER_URL + HISApplicationConfig.HIS_WEB_MODULE_LOGIN + "/services/restful" + "/HISSSOService"   + "/authenticate/"+ SecureCryptAlgorithm.encrypt(request.getHeader("User-Agent").toLowerCase());
			//System.out.println("sso authenticate uri" + uri);

			/*String uri = HISApplicationConfig.HIS_SERVICES_SERVER_URL + HISApplicationConfig.HIS_WEB_MODULE_LOGIN + "/services/restful" + "/HISSSOService"
					+ "/authenticate";*/
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().post(Entity.entity(objHISServiceSO, MediaType.APPLICATION_XML));
			// Read the entity
			// objHISServiceSO = response.readEntity(HISServiceSO.class);
			// objHISServiceTicket = objHISServiceSO.getObjServiceTicket();
			objHISGrantTicket = response.readEntity(HISServiceGrantTicket.class);
			response.close();

			//System.out.println("HISSSOServiceCLN :: HISServiceGrantTicket ID -> " + objHISGrantTicket.getTicketId());
		}
		catch (Exception e)
		{
			objHISGrantTicket = null;
			e.printStackTrace();
		}
		return objHISGrantTicket;
	}
}
