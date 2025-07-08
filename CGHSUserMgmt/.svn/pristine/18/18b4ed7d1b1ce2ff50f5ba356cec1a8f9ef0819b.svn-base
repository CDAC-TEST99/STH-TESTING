package hissso.client.service;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import application.config.HISApplicationConfig;

public class HISSSOClientServiceCLN
{

	public HISClientSO isServiceTicketExpired(HISClientSO objSO_p)
	{
		HISClientSO objHISClientSO = null;
		try
		{
			//System.out.println("HISSSOClientServiceCLN :: isServiceTicketExpired()");

			ResteasyClient client = new ResteasyClientBuilder().build();
			String uri = HISApplicationConfig.HIS_SERVICES_SERVER_URL + objSO_p.getObjService().getContext() + "/services/restful" + "/HISSSOClientService"
					+ "/isServiceTicketExpiredAtClient";
			//System.out.println("uri in HISSSOClientServiceCLN.isServiceTicketExpired == "+ uri);
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().post(Entity.entity(objSO_p, MediaType.APPLICATION_XML));
			// Read the entity
			// objHISServiceSO = response.readEntity(HISServiceSO.class);
			// objHISServiceTicket = objHISServiceSO.getObjServiceTicket();
			objHISClientSO = response.readEntity(HISClientSO.class);
			response.close();

			//System.out.println("HISSSOClientServiceCLN :: Expiry Status -> " + objHISClientSO.getActionStatus());
		}
		catch (Exception e)
		{
			objHISClientSO = null;
			e.printStackTrace();
		}
		return objHISClientSO;
	}

	public HISClientSO killServiceTicket(HISClientSO objSO_p)
	{
		HISClientSO objHISClientSO = null;
		try
		{
			//System.out.println("HISSSOClientServiceCLN :: killServiceTicket()");

			ResteasyClient client = new ResteasyClientBuilder().build();
			String uri = HISApplicationConfig.HIS_SERVICES_SERVER_URL + objSO_p.getObjService().getContext() + "/services/restful" + "/HISSSOClientService"
					+ "/killServiceTicketAtClient";
			//System.out.println("uri in HISSSOClientServiceCLN.killServiceTicket == "+ uri);
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().post(Entity.entity(objSO_p, MediaType.APPLICATION_XML));
			// Read the entity
			// objHISServiceSO = response.readEntity(HISServiceSO.class);
			// objHISServiceTicket = objHISServiceSO.getObjServiceTicket();
			objHISClientSO = response.readEntity(HISClientSO.class);
			response.close();

			//System.out.println("HISSSOClientServiceCLN :: Service Killed -> " + objHISClientSO.getActionStatus());
		}
		catch (Exception e)
		{
			objHISClientSO = null;
			e.printStackTrace();
		}
		return objHISClientSO;
	}

}
