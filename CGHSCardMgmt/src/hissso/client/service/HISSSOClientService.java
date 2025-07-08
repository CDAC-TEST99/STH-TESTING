package hissso.client.service;

import hissso.config.HISSSOSupport;
import hissso.ticket.HISServiceTicket;
import hissso.ticket.ServiceTicket;
import hissso.ticket.registry.HISTicketRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/HISSSOClientService")
public class HISSSOClientService implements HISSSOClientServiceCON
{

	@POST
	@Path("/isServiceTicketExpiredAtClient")
	@Produces({ MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_XML })
	public HISClientSO isServiceTicketExpiredAtClient(HISClientSO objSO_p, @Context HttpServletRequest objRequest)
	{
		boolean flagExpire = true;
		HISClientSO objHISClientSO = new HISClientSO();
		//System.out.println("inside isServiceTicketExpiredAtClient");
		try
		{
			HISTicketRegistry objRegistry = HISSSOSupport.getSSORegister(objRequest);
			String strServiceTicketId = objSO_p.getServiceTicketId();
			ServiceTicket objServiceTicket = (ServiceTicket) objRegistry.getTicket(strServiceTicketId);
			flagExpire = objServiceTicket.isExpired();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (flagExpire) objHISClientSO.setActionStatus("1");
			else objHISClientSO.setActionStatus("0");
		}

		return objHISClientSO;
	}

	@POST
	@Path("/killServiceTicketAtClient")
	@Produces({ MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_XML })
	public HISClientSO killServiceTicketAtClient(HISClientSO objSO_p, @Context HttpServletRequest objRequest)
	{

		HISClientSO objHISClientSO = new HISClientSO();
		objHISClientSO.setActionStatus("0");
		//System.out.println("inside killServiceTicketAtClient" +objSO_p.getObjService().getContext());
		try
		{
			HISTicketRegistry objRegistry = HISSSOSupport.getSSORegister(objRequest);
			String strServiceTicketId = objSO_p.getServiceTicketId();
			ServiceTicket objServiceTicket = (HISServiceTicket) objRegistry.getTicket(strServiceTicketId);

			objServiceTicket.expire();
			objRequest.getSession().invalidate();
			objRegistry.deleteTicket(strServiceTicketId);
			objHISClientSO.setActionStatus("1");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			objHISClientSO.setActionStatus("0");
		}

		return objHISClientSO;
	}

	@GET
	@Path("/test")
	@Produces({ MediaType.TEXT_PLAIN })
	public String test()
	{
		//System.out.println("inside test HISRegistration");

		return "called";
	}

}
