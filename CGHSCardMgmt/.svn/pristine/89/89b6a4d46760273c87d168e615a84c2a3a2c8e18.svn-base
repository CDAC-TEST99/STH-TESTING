package thirdpartyservices.bharatkosh.service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import formFlowX.action.MainServlet;
import formFlowX.fb.FormFlowXCommonFB;
import formFlowX.util.FormFlowXUTIL;
import formFlowX.vo.FormFlowXUserVO;
import hisglobal.utility.Usefulmethods;
import thirdpartyservices.bharatkosh.client.resp.PaymentService;

@SuppressWarnings("serial")
public class BharatkoshAction extends MainServlet {

	private static final String fileName = "formFlowX.action.masterUI";

	public static void FirstCall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("OBJUSER");
		CallMasterPage(request, response);
	}

	public static void CallMasterPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FormFlowXCommonFB fb = new FormFlowXCommonFB(request);
		FormFlowXUTIL.initABHA(fb, request, response);
		String masterKey = fb.getMasterkey();
		if (masterKey == null) {
			masterKey = Usefulmethods.getQuery(fileName, "defaultmasterkey");
		}

		if (fb.getIsGlobal() == null || fb.getIsGlobal().equals(""))
			fb.setIsGlobal("0");
		/*
		 * if(fb.getAbdmMode().equals("appointment") ) fb.setIsGlobal("1");
		 */

		FormFlowXUserVO objuser = FormFlowXUTIL.getUserVO(request, fb);

		if (objuser == null) {
			masterKey = "sessionExpired";
		}

		String page = Usefulmethods.getQuery(fileName, masterKey);

		try {
			if(masterKey.equals("BKPay")) {
				bharatkoshResponse(request);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		forwardToPage(request, response, fb, page);

	}

	private static void bharatkoshResponse(HttpServletRequest request)
			throws UnsupportedEncodingException, JAXBException, PropertyException, XMLStreamException {
		byte[] decodedBytes = Base64.getDecoder().decode(request.getParameter("BharatkoshResponse"));
		String decodedXml = new String(decodedBytes, "utf-8");
		JAXBContext jaxbContext = JAXBContext.newInstance(PaymentService.class);
		
        XMLInputFactory xif = XMLInputFactory.newInstance();
        xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(decodedXml));

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		PaymentService paymentService = (PaymentService) unmarshaller.unmarshal(xsr);

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(paymentService, sw);
		String xmlString = sw.toString();
		//System.out.println(xmlString);
		
		request.setAttribute("BKPAYRESPONSE", paymentService);
		
		String trackingId = paymentService.getReply().getOrderStatus().getOrderCode().split("\\-")[0];
		String utrStr = paymentService.getReply().getOrderStatus().getReference().getId();
		String paymentStatus = paymentService.getReply().getOrderStatus().getStatus();
	
		BharatkoshClient client = new BharatkoshClient();
		client.updateBharatkoshResp(trackingId, utrStr, paymentStatus, xmlString);
	}

	public static void callService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FormFlowXCommonFB fb = new FormFlowXCommonFB(request);
		FormFlowXUTIL.CallService(fb, request, response);
	}

}
