package new_investigation.transactions.controller.utl;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.io.StringReader;
//import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
//import java.net.URL;
//import java.net.URL;
//import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import hisglobal.utility.HisUtil;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.struts.upload.FormFile;
import org.jboss.security.Base64Encoder;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;


import HisWeb.webservice.WsHttpClient;
import HisWeb.webservice.WsHttpsClient;
import TemplateHelper.EndPage;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.hisconfig.Config;
import hisglobal.presentation.ControllerUTIL;
import hisglobal.presentation.Status;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.Entry;
import hisglobal.utility.HTMLToPDFUTIL;
import hisglobal.utility.HelperMethods;
import hisglobal.utility.HisUtil;
import hisglobal.utility.JakartaFTPWrapper;
import hisglobal.utility.PropertiesHelper;
import hisglobal.vo.UserVO;

//import DataHelper.PGDataHelper;

//import org.json.JSONObject;
//import org.json.JSONArray;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import new_investigation.InvestigationConfig;
import new_investigation.reports.controller.data.InvTrackingReportDATA;
import new_investigation.transactions.controller.Helper.NEWOfflineResultEntryHLP;
import new_investigation.transactions.controller.data.InvestigationRaisingDtlDATA;
import new_investigation.transactions.controller.data.NEWOfflineResultEntryDATA;
//import new_investigation.transactions.controller.data.NEWOfflineResultEntryDATA;
import new_investigation.transactions.controller.fb.InvestigationRaisingDtlFB;
import new_investigation.transactions.controller.fb.NEWOfflineResultEntryFB;
//import new_investigation.transactions.controller.fb.NEWOfflineResultEntryFB;
import new_investigation.transactions.controller.fb.invRaisingCumSamCollectionFB;
import new_investigation.transactions.dao.NEWOfflineResultEntryDAO;
import new_investigation.transactions.dao.NEWOfflineResultEntryServiceDAO;
//import new_investigation.transactions.delegate.InvestigationEssentialOfflineDelegate;
import new_investigation.transactions.delegate.InvestigationEssentialOfflineDelegate;
import new_investigation.vo.InvTrackingReportVO;
import new_investigation.vo.Inv_EpisodeVO;
import new_investigation.vo.Inv_PatientAdmissionDtlVO;
import new_investigation.vo.Inv_RequisitionRaisingPatientVO;
import new_investigation.vo.NEWOfflineResultEntryVO;


public class NEWOfflineResultEntryUTL extends ControllerUTIL {
	public static void setPatientRegistrationEssentials(InvestigationRaisingDtlFB fb, HttpServletRequest request) {
		Status status = new Status();
		// status.add(Status.NEW, "", "");
		List<Inv_EpisodeVO> lstEpisodeVO = new ArrayList<Inv_EpisodeVO>();
		List<Inv_PatientAdmissionDtlVO> lstPatientVO = new ArrayList<Inv_PatientAdmissionDtlVO>();
		Map mp = new HashMap();
		try {
			Inv_RequisitionRaisingPatientVO patVO = null;

			ControllerUTIL.setSysdate(request);
			Date dt = (Date) request.getSession().getAttribute(Config.SYSDATEOBJECT);
			WebUTIL.getSession(request).setAttribute(InvestigationConfig.SYSDATEOBJECT, dt);

			status.add(Status.TRANSINPROCESS, "", "");
		} catch (Exception e) {
			status.add(Status.ERROR_AE, "Application Execution Exception", "");
			e.printStackTrace();
		} finally {
			WebUTIL.setStatus(request, status);
		}
	}

	public static void getPatList(NEWOfflineResultEntryFB fb, HttpServletRequest request) {
		Status status = new Status();
		// status.add(Status.NEW, "", "");
		HttpSession session = request.getSession();
		try {
			List<NEWOfflineResultEntryVO> lstsamplePatinetVO = null;

			lstsamplePatinetVO = new ArrayList<NEWOfflineResultEntryVO>();
			NEWOfflineResultEntryVO objSampleCollectionVO = new NEWOfflineResultEntryVO();

			// WebUTIL.populate(objSampleCollectionVO,fb);
			if (fb.getPatCrNo() != null && !fb.getPatCrNo().equals(""))
				objSampleCollectionVO.setPatCRNo(fb.getPatCrNo());

			if (fb.getPatCrNo() != null && !fb.getPatCrNo().equals(""))
				objSampleCollectionVO.setPatCRNo(fb.getPatCrNo());
			objSampleCollectionVO.setFromDate(fb.getFromDate());
			objSampleCollectionVO.setToDate(fb.getToDate());

			objSampleCollectionVO.setSampleAreaCode(fb.getSampleAreaCode());
			objSampleCollectionVO.setWardCode(fb.getWardCode());

			session.removeAttribute(InvestigationConfig.SELECTED_PAT_DETAILS);
			session.removeAttribute(InvestigationConfig.LIST_SAMPLE_PATIENT_VO);

			session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_BILLED);
			session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_UNBILLED);

			session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_BILLED);
			session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_UNBILLED);

			// InvestigationConfig.SELECTED_PAT_DETAILS

			UserVO userVO = ControllerUTIL.getUserVO(request);
			lstsamplePatinetVO = NEWOfflineResultEntryDATA.getPatList(objSampleCollectionVO, userVO);

			// if(lstsamplePatinetVO!=null)
			// {
			// WebUTIL.populate(fb,lstsamplePatinetVO.get(0));
			WebUTIL.setAttributeInSession(request, InvestigationConfig.LIST_SAMPLE_PATIENT_VO, lstsamplePatinetVO);

			// }
			status.add(Status.TRANSINPROCESS, "", "");
		} catch (Exception e) {
			status.add(Status.ERROR_AE, "Application Execution Exception", "");
			e.printStackTrace();
		} finally {
			WebUTIL.setStatus(request, status);
		}
	}

	public static void getEssential(NEWOfflineResultEntryFB fb, HttpServletRequest request) throws IOException {
		Status objStatus = new Status();
		UserVO userVO = ControllerUTIL.getUserVO(request);
		NEWOfflineResultEntryVO invresultentryvo = new NEWOfflineResultEntryVO();
		String strResultDtl = "";
		try {
			ControllerUTIL.setSysdate(request);
			Date dt = (Date) request.getSession().getAttribute(Config.SYSDATEOBJECT);
			WebUTIL.getSession(request).setAttribute(InvestigationConfig.SYSDATEOBJECT, dt);
			System.out.println("before test1");
			NEWOfflineResultEntryDATA data = new NEWOfflineResultEntryDATA();
			//data.getOfflineTestDetail(invresultentryvo, userVO);
			 invresultentryvo.setPatCRNo(fb.getPatCRNo());
			System.out.println("getIsbillingreq>>>" + fb.getIsbillingreq());
			if(fb.getIsbillingreq().equals("0"))
			{    
				
				
				data.getOfflineTestDetail(invresultentryvo, userVO, "1");

			}
			else if(fb.getIsbillingreq().equals("1"))
			{
				data.getOfflineTestDetail(invresultentryvo, userVO, "4");

			}
			System.out.println("before init123");
			//strResultDtl = NEWOfflineResultEntryHLP.getOfflineResultEntryDtls(invresultentryvo, request);
			if(fb.getIsbillingreq().equals("0"))
			{    
				
				
				strResultDtl = NEWOfflineResultEntryHLP.getOfflineResultEntryDtls(invresultentryvo, request);

			}
			else if(fb.getIsbillingreq().equals("1"))
			{
				strResultDtl = NEWOfflineResultEntryHLP.getOfflineResultEntryDtlswithbilling(invresultentryvo, request);

			}
			
			String tDate = WebUTIL.getCustomisedSysDate((Date) request.getSession().getAttribute(Config.SYSDATEOBJECT),
					"dd-MMM-yyyy");
			System.out.println("tDate " + tDate);
			fb.setLabCode("%");
			fb.setStrResultDtl(strResultDtl);
			objStatus.add(Status.TRANSINPROCESS);

			// Getting the List of hospitals in the hierarchy. 18.01.2021 Deepti
			invresultentryvo.setStrParentHospitalCode(fb.getStrParentHospitalCode());
			data.getHospitalList(invresultentryvo, userVO);
			String strHospitalList = "";
			HisUtil hisutil = new HisUtil("New Offline Result Entry", "NEWOfflineResultEntryFB");

			if (invresultentryvo.getStrMsgType().equals("1")) {
				throw new Exception(invresultentryvo.getStrMsgString());
			}
			if (invresultentryvo.getStrHospitalListWS() != null && invresultentryvo.getStrHospitalListWS().size() > 0) {

				strHospitalList = hisutil.getOptionValue(invresultentryvo.getStrHospitalListWS(), "", "0^Select Value",
						false);
			}

			else {
				strHospitalList = "<option value='0'>Select Value</option>";

			}
			fb.setStrHospitalList(strHospitalList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.UNSUCESSFULL, "", "Data Not Found");
		}

	}

	public static void insertOffllineResultEntry(NEWOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {

		NEWOfflineResultEntryVO vo = (NEWOfflineResultEntryVO) TransferObjectFactory
				.populateData("new_investigation.vo.NEWOfflineResultEntryVO", fb);

		String pdfString = "", strFileName = "", saveFileString = "";
		File tempFile = null;
		String strSignFileName = "", strSign = "";
		UserVO uservo = new UserVO();
		String saveFlag = "";
		String strFtpurl = "";
		String strReturnString = "";
		String strFileExt = "";
		String temp[] = null;
		String strFileSaveMsg = "";

		try {

			NEWOfflineResultEntryDATA offlineResEntryData = new NEWOfflineResultEntryDATA();

			  if(objRequest_p.getAttribute("patCrNo")!=null) {
			  vo.setPatCRNo((String)objRequest_p.getAttribute("patCrNo"));
			  System.out.println("inside");
			  
			  
			  }
			  else
			  {
				  vo.setPatCRNo(fb.getPatCrNo()); 
			  }
			 

			HelperMethods.populate(fb, vo);

			if(fb.getIsbillingreq().equals("0"))
			{    
				
				
				offlineResEntryData.insertOffllineResultEntry(vo, uservo);

			}
			
			if(fb.getIsbillingreq().equals("1"))
			{    
				
				
				offlineResEntryData.insertOffllineResultEntryBilling(vo, uservo);

			}
			
			offlineResEntryData.onlineReqResultEntry(fb.getOnlineReqJson(), uservo);
			
			/*
			 * if(fb.getOnlineReqJson()!=null && !fb.getOnlineReqJson().equals("")) {
			 * offlineResEntryData.onlineReqResultEntry(fb.getOnlineReqJson(), uservo);
			 * 
			 * }
			 */

			
			
			//offlineResEntryData.insertOffllineResultEntry(vo, uservo);
			
			offlineResEntryData.getOffllineResultEntryPatientData(vo, uservo);
			offlineResEntryData.getOffllineResultEntryPatientTestData(vo, uservo);
			// yyy
			if (vo.getStrMsgType().equals("1")) {
				saveFlag = "1";
				fb.setStrMsgType("1");
				fb.setStrMsgString("Error occurred while saving data. Please try again ! ");
				throw new Exception(vo.getStrMsgString());
			} else {
				saveFlag = "2";
				fb.setStrMsgType("0");
				System.out.println("Data Saved Successfully for the CR No. : " + vo.getPatCRNo());
				fb.setStrMsgString("Data Saved Successfully" + vo.getPatCRNo());

				// Make the Slip

				pdfString = NEWOfflineResultEntryHLP.printSlipTestWise(vo);

				System.out.println("UTL >>>> SAVE >>>> the PDF > for new pat>> > " + pdfString);
				// HttpSession session=WebUTIL.getSession(objRequest_p);
				// session.setAttribute("printDivContent", pdfString);
				String strTempfileName = vo.getStrPatFileName().replace(".", "#").split("#")[0];
				tempFile = File.createTempFile(strTempfileName, ".pdf");
				String strDirector = tempFile.getParentFile().getAbsolutePath();
				strTempfileName = strTempfileName.replace("/", "_");
				String strTempFilePath = strDirector + File.separator + strTempfileName + ".pdf";
				System.out.println("strTempFilePath2" + strTempFilePath);
				tempFile.delete();

				convertHtmlToPDFAndSave(pdfString, strTempfileName, (strDirector + File.separator));

				FileInputStream fis = new FileInputStream(new File(strTempFilePath));

				saveFileToFTP(vo.getHospitalCode(), strTempfileName + ".pdf", fis, vo);

				if (fis != null) {

					fis.close();
					fis = null;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			if (saveFlag == "1")
				fb.setStrMsgString("Error occurred while Saving Data. Please Try Again !");
			if (saveFlag == "4")
				fb.setStrMsgString("Data Saved but Error occurred while Generating File ! Cr. No: " + vo.getPatCRNo());
			// fb.setStrMsgString("NEWOfflineResultEntryUTL.insertOffllineResultEntry() -->
			// "+ e.getMessage());
		}
	}

	public synchronized static String saveFileToFTP(String strHospCode, String strFileName, InputStream inputStream,
			NEWOfflineResultEntryVO vo) throws Exception {

		String strReturnString = "";
		OutputStream out1 = null;
		FTPClient ftp = null;

		try {

			ftp = new FTPClient();

			System.out.println(
					"ftp connecting to " + HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
			System.out.println("with credentials : " + HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME")
					+ " & " + HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));

			ftp.connect(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
			ftp.login(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME"),
					HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
			ftp.setFileType(FTP.BINARY_FILE_TYPE);

			 System.out.println("strFileName >> "+strFileName); 
			
		    //out1 = ftp.storeFileStream("/FTP/"+strFileName);
		
			
			
			out1 = ftp.storeFileStream(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FILEPATH") + strFileName);
			System.out.println("pdffile_nandini >> " + HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FILEPATH") + strFileName);

			byte[] buf = new byte[1024];

			for (int readNum; (readNum = inputStream.read(buf)) != -1;) {
				out1.write(buf, 0, readNum);
			}

			strReturnString = "1";

		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {

			if (out1 != null) {
				out1.close();
				out1 = null;
			}

			if (ftp != null) {
				ftp.logout();
				ftp = null;
			}

		}
		return strReturnString;
	}

	public synchronized static String saveFileToFTPLocationnew(String pdfString, String pdfFileName,
			String fileuploaddata, String isfileuploadprint, String isfirstpageprint, String pdfFtpurl,
			String pdfFileurl) throws IOException, DocumentException {
		Document document = null;

		float footerHeight = Float.parseFloat("48.0");
		float headerHeight = Float.parseFloat("200");
		float headerwidth = Float.parseFloat("0");
		float footerWidth = Float.parseFloat("0");
		String pageHeight = ("0");
		String pageWidth = ("0");
		float footerHeight1 = Float.parseFloat("34.0");
		String returnStatus = null;
		if (pdfString == null) {
			System.out.println("Empty HTML String");
			return null;
		}

		if (pageHeight == null) {
			document = new Document(PageSize.A4);
		} else {
			document = new Document(new Rectangle(Float.parseFloat(pageWidth), Float.parseFloat(pageHeight))); // specify
																												// the
																												// page
																												// size
		}

		pdfString = pdfString.replace("&amp;", "&");
		// for text area line breaks
		pdfString = pdfString.replace("\r\n", "<br/>");

		// For 2D ECHO Test
		pdfString = pdfString.replace("less than", "&lt;");
		pdfString = pdfString.replace("greater than", "&gt;");
		pdfString = pdfString.replace("Greater Than", "&gt;");

		System.out.println("the main html string is :  " + pdfString);

		List<InputStream> finalPdfArray = new ArrayList<InputStream>();

		String htmlStart = "<div style=\"font-size:12.0pt; font-family:Times New Roman\">";// "<html><head><meta
																							// http-equiv='content-type'
																							// content='application/xhtml+xml;
																							// charset=UTF-8'/></head><body
																							// style=\"font-family:Arial\">";
		String htmlEnd = "</div>";
		InputStream s = new ByteArrayInputStream(pdfString.getBytes());
		BufferedOutputStream bos = null;
		List<Element> footerElementList = null;
		List<Element> headerElementList = null;

		try {

			document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin() + headerHeight,
					document.bottomMargin() + footerHeight);
			System.out.println("Header heights" + document.topMargin() + " " + headerHeight);
			System.out.println("footerr heights" + document.bottomMargin() + " " + footerHeight);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			boolean isfirstpageprintornot = false;

			URL urlftp = new URL(pdfFtpurl + "/" + pdfFileName);
			URLConnection urlc = urlftp.openConnection();
			System.out.println("nandini1" + pdfFileName);
			System.out.println("nandini2" + urlc);
			System.out.println("urlftp" + urlftp);

			try {
				bos = new BufferedOutputStream(urlc.getOutputStream());

			} catch (Exception ex) {
				System.out.println("catch");
				ex.printStackTrace();
			}

			if (bos == null) {

				String[] folder = pdfFileurl.replace("/", "#").split("#");

				if (folder[2] != null && folder[2].replace("@", "#").split("#").length > 1)
					createDirectoryStructure(folder[2].replace("@", "#").split("#")[1], folder);
				else
					createDirectoryStructure(folder[2], folder);

				bos = new BufferedOutputStream(urlc.getOutputStream());
			}

			try {
				// System.out.println(htmlString);

				// PdfWriter writer = PdfWriter.getInstance(document, baos); chnaged for ftp
				PdfWriter writer = PdfWriter.getInstance(document, bos);
				EndPage endPage = new EndPage();
				endPage.footerElementList = footerElementList;
				endPage.headerElementList = headerElementList;
				writer.setPageEvent(endPage);
				document.open();

				CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);

				XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
				fontProvider.register("C:\\PHDM/investigationReportEssential/ARIALUNI.TTF", "Arial");
				// fontProvider.register("resources/fonts/PT_Serif-Web-Regular.ttf", "Serif");
				CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);

				// HTML
				HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
				htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
				htmlContext.setImageProvider(new Base64ImageProvider());

				// Pipelines
				PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
				HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
				CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

				// XML Worker
				XMLWorker worker = new XMLWorker(css, true);
				XMLParser p = new XMLParser(worker, Charset.forName("UTF-8"));
				if (p == null)
					System.out.println("p is null");
				if (s == null) {
					System.out.println("nullll");
				}
				p.parse(s);

			} catch (DocumentException e) {
				// returnStatus = null;

				e.printStackTrace();
			}

			document.close();

			URL urlftp1 = new URL(pdfFtpurl + "/" + pdfFileName);
			URLConnection urlc1 = urlftp1.openConnection();

			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			InputStream is = null;
			try {
				is = urlftp1.openStream();
				byte[] byteChunk = new byte[4897]; // Or whatever size you want to read in at a time.
				int n;

				while ((n = is.read(byteChunk)) > 0) {
					baos1.write(byteChunk, 0, n);
				}
			} catch (IOException e) {
				System.err.printf("Failed while reading bytes from %s: %s", urlftp1.toExternalForm(), e.getMessage());
				e.printStackTrace();
				// Perform any other exception handling that's appropriate.
			} finally {
				if (is != null) {
					is.close();
				}
			}

			byte[] pdfData1 = baos1.toByteArray();

			if (isfirstpageprint != null && isfirstpageprint.equals("1")) {
				isfirstpageprintornot = true;
			} else {
				InputStream is1 = null;
				is1 = new ByteArrayInputStream(pdfData1);
				finalPdfArray.add(is1);
			}

			if (isfileuploadprint != null && !isfileuploadprint.equals("0")) {
				if (fileuploaddata != null && !fileuploaddata.equals("")) {

					if (fileuploaddata.contains("#@#")) {
						for (int k = 0; k < fileuploaddata.split("#@#").length; k++) {
							byte fileupload[] = null;
							fileupload = org.apache.commons.codec.binary.Base64
									.decodeBase64(fileuploaddata.split("#@#")[k]);

							if (fileupload != null) {
								InputStream is1 = null;
								is1 = new ByteArrayInputStream(fileupload);
								finalPdfArray.add(is1);

							}

						}
					} else {
						byte fileupload[] = null;
						fileupload = org.apache.commons.codec.binary.Base64.decodeBase64(fileuploaddata);

						if (fileupload != null) {
							InputStream is1 = null;
							is1 = new ByteArrayInputStream(fileupload);
							finalPdfArray.add(is1);
						}

					}

				}
			}

			if (finalPdfArray.size() > 0) {

				URL urlftp11 = new URL(pdfFtpurl + "/" + pdfFileName);
				URLConnection urlc11 = urlftp11.openConnection();
				BufferedOutputStream bos11 = null;

				try {
					bos11 = new BufferedOutputStream(urlc11.getOutputStream());

				} catch (Exception ex) {
					System.out.println("catch");
					ex.printStackTrace();
				}
				bos11.write(output.toByteArray());

				if (bos11 != null) {

					bos11.close();
				}

			}

			// MongoXmlHandler.getInstance().savePDFFile(pdfFileName, pdfData);
			returnStatus = "success";

		} catch (IOException e) {
			// returnStatus = null;

			e.printStackTrace();

		} finally {

			try {
				if (document != null) {
					document.close();
				}
			} catch (Exception e) {
				// returnStatus = null;
				e.printStackTrace();

			}

			try {
				if (bos != null) {

					bos.close();
				}
			} catch (IOException e) {
				// returnStatus = null;

				e.printStackTrace();
			}

		}

		return returnStatus;
	}

	public synchronized static String saveFileToFTPLocation(String FileName, InputStream inputStream, String getPatCRNo,
			String getStrParentHospitalCode, String getStrPatFileName, NEWOfflineResultEntryVO vo) throws Exception {
		BufferedOutputStream bos = null;

		String strFtpurl = "";
		String strReturnString = "";
		URL urlftp = null;
		URLConnection urlc = null;
		try {

			String crNo = vo.getPatCRNo();
			System.out.println("getPatCRNo " + getPatCRNo);
			// String hospcode=vo.getStrParentHospitalCode();
			// System.out.println("getStrParentHospitalCode "+getStrParentHospitalCode);

			String year = crNo.substring(5, 7);

			String insideyear = getInsideYear(crNo);
			String count = getcount(crNo);
			strFtpurl = getFTPDtl();
			String filename = vo.getStrPatFileName().replace("-", "");
			urlftp = new URL(strFtpurl + "/" + vo.getStrParentHospitalCode() + "/" + "20" + year + "/" + insideyear
					+ "/" + count + "/" + vo.getPatCRNo() + "/" + filename);
			System.out.println("Fileurl " + strFtpurl);
			// System.out.println("FileName" + FileName);
			urlc = urlftp.openConnection();
			System.out.println("urlc1 " + urlc);
			System.out.println("urlftp " + urlftp);

			bos = new BufferedOutputStream(urlc.getOutputStream());
			byte[] buf = new byte[1024];
			for (int readNum; (readNum = inputStream.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}

			strReturnString = "1";

		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {

			if (bos != null) {
				bos.close();
			}

			urlftp = null;
			urlc = null;
		}
		return strReturnString;
	}

	public static void convertHtmlToPDFAndSave(String _htmlCode, String fileName, String strFilePath) {

		OutputStream os = null;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			/*
			 * _htmlCode = _htmlCode.replaceAll("& lt;", "<").replaceAll("& gt;", ">");
			 * _htmlCode = _htmlCode.replaceAll("& #40;", "\\(").replaceAll("& #41;",
			 * "\\)");
			 */

			org.w3c.dom.Document doc = builder.parse(new StringBufferInputStream(_htmlCode));
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocument(doc, null);
			renderer.layout();
			final FileOutputStream fileOutputStream = new FileOutputStream(
					new File(strFilePath + "/" + fileName + ".pdf"));
			System.out.println("234" + fileOutputStream);
			renderer.createPDF(fileOutputStream);
			fileOutputStream.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// close the streams using close method
			try {
				if (os != null) {
					os.close();
				}
			} catch (Exception ioe) {
				System.out.println("Error while closing stream: " + ioe);
			}

		}

	}

	public static String readImageFromLocation(String FileName, String getPatCRNo, String getStrParentHospitalCode,
			NEWOfflineResultEntryVO vo) {
		// Image image = null;
		InputStream io = null;
		BufferedImage image = null;
		int width = 70;
		int height = 68;
		ByteArrayOutputStream bos = null;
		String Fileurl;
		String asB64 = "";
		try {

			String crNo = vo.getPatCRNo();
			String hospcode = vo.getStrParentHospitalCode();
			System.out.println("getPatCRNo1" + getPatCRNo);
			System.out.println("getStrParentHospitalCode " + getStrParentHospitalCode);
			// System.out.println(crNo.substring(5,7));

			String year = crNo.substring(5, 7);

			String insideyear = getInsideYear(crNo);
			String count = getcount(crNo);
			Fileurl = getFTPDtlSignFile();
			URL urlftp = new URL(Fileurl + "/" + vo.getStrParentHospitalCode() + "/" + "20" + year + "/" + insideyear
					+ "/" + count + "/" + vo.getPatCRNo());
			System.out.println("Fileurl " + Fileurl);
			URLConnection urlc = urlftp.openConnection();
			System.out.println("urlc1" + urlc);
			System.out.println("urlftp" + urlftp);
			io = urlc.getInputStream();
			System.out.println("io" + io);
			bos = new ByteArrayOutputStream();
			int length;
			byte[] buf = new byte[2048];
			while (-1 != (length = io.read(buf, 0, buf.length))) {
				bos.write(buf, 0, length);
			}
			ByteArrayInputStream fis = new ByteArrayInputStream(bos.toByteArray());
			bos.flush();
			bos.close();
			byte[] buffer = new byte[fis.available()];
			int offset = 0;
			int numRead = 0;
			while (offset < buffer.length && (numRead = fis.read(buffer, offset, buffer.length - offset)) >= 0) {
				offset += numRead;
			}
			asB64 = "data:image/jpg;base64," + new Base64Encoder().encode(buffer);
			// fileNames.add(asB64);
			long end = System.currentTimeMillis();
			// System.out.println(end);
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(io);
			// System.out.println("Reading complete-> "+image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return asB64;
	}

	public static void DownloadFile(NEWOfflineResultEntryFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strmsgText = null;
		File f = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {

			downloadFileFromFTP(formBean.getStrParentHospitalCode(), formBean.getStrUploadFileId(), response);
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "Drug Inventory.SupplierDeskInterfaceTransDATA.DownloadFile(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "SupplierDeskInterfaceTransDATA->DownloadFile()", strmsgText);
			formBean.setStrMsgString(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;

		} finally {

			if (f != null) {
				f = null;
			}
			if (fis != null) {
				fis = null;
			}
			if (fos != null) {
				fos = null;
			}
		}
	}

	public static void downloadFileFromFTP(String hospitalCode, String strFileName, HttpServletResponse response_p)
			throws Exception {

		URL urlftp = null;
		URLConnection urlc = null;
		InputStream io = null;

		try {

			String fileUrl = getFTPDtl();

			String[] strTemp = strFileName.replace(".", "#").split("#");
			String strExt = strTemp[strTemp.length - 1];

			if (strExt.equalsIgnoreCase("txt") || strExt.equalsIgnoreCase("txt")) {

				response_p.setContentType("application/txt");
				response_p.setHeader("Content-disposition", " filename=" + strFileName);

			} else if (strExt.equalsIgnoreCase("pdf")) {

				response_p.setContentType("application/pdf");
				response_p.setHeader("Content-disposition", "attachment; filename=" + strFileName);

			}

			else if (strExt.equalsIgnoreCase("jpeg") || strExt.equalsIgnoreCase("jpg")) {

				response_p.setContentType("image/jpg");
				response_p.setHeader("Content-disposition", "attachment; filename=" + strFileName);

			}

			else if (strExt.equalsIgnoreCase("html") || strExt.equalsIgnoreCase("htm")) {

				response_p.setContentType("text/html;charset=utf-8");
				response_p.setHeader("Content-disposition", "attachment; filename=" + strFileName);

			} else if (strExt.equalsIgnoreCase("xlsx") || strExt.equalsIgnoreCase("xlsx")) {

				response_p.setContentType("application/xlsx");
				response_p.setHeader("Content-disposition", "attachment; filename=" + strFileName);

			} else if (strExt.equalsIgnoreCase("xml")) {

				response_p.setContentType("application/xml");
				response_p.setHeader("Content-disposition", "attachment; filename=" + strFileName);

			} else if (strExt.equalsIgnoreCase("doc") || strExt.equalsIgnoreCase("docx")) {

				response_p.setContentType("application/msword");
				response_p.setHeader("Content-disposition", "attachment; filename=" + strFileName);

			} else if (strExt.equalsIgnoreCase("rdf")) {
				response_p.setContentType("application/msword");
				response_p.setHeader("Content-disposition", "attachment; filename=" + strFileName);

			} else if (strExt.equalsIgnoreCase("rtf")) {

				response_p.setContentType("application/msword");
				response_p.setHeader("Content-disposition", "attachment; filename=" + strFileName);

			} else {

				response_p.setContentType("text/html;charset=utf-8");
				response_p.setHeader("Content-disposition", "attachment; filename=" + strFileName);

			}

			urlftp = new URL(fileUrl + "/" + strFileName);
			urlc = urlftp.openConnection();
			io = urlc.getInputStream();

			byte[] buf = new byte[4096];
			int read = 0;

			while ((read = io.read(buf)) > 0)
				response_p.getOutputStream().write(buf, 0, read);

		} catch (Exception e) {
			throw e;
		} finally {

			if (io != null) {
				io.close();
				io = null;
			}

			if (urlc != null) {
				urlc = null;
			}
		}
	}

	private static String getFTPDtl() {

		String ftpUrl = NEWOfflineResultEntryDAO.getFTPDtl();
		return ftpUrl;
	}

	private static String getFTPDtlSignFile() {

		String ftpUrl = NEWOfflineResultEntryDAO.getFTPDtl(); // NEWOfflineResultEntryDAO.getFTPDtlSignFile();
		return ftpUrl;
	}

	public static StringBuffer pouplateTestDetails(NEWOfflineResultEntryFB fb, HttpServletRequest objRequest_p,
			HttpServletResponse response) {
		StringBuffer sbAjaxRes = new StringBuffer();
		HttpSession session = objRequest_p.getSession();
		String strMsgText = "";
		String strTestCombo = "";
		Map mp = new HashMap();
		String strResultDtl = "";

		try {
			UserVO userVO = ControllerUTIL.getUserVO(objRequest_p);
			NEWOfflineResultEntryVO invresultentryvo = new NEWOfflineResultEntryVO();
			NEWOfflineResultEntryDATA data = new NEWOfflineResultEntryDATA();
			//data.getOfflineTestDetail(invresultentryvo, userVO);
	
             invresultentryvo.setPatCRNo(fb.getPatCRNo());
			
			System.out.println("getIsbillingreq>>>" + fb.getIsbillingreq());
			if(fb.getIsbillingreq().equals("0"))
			{    
				
				
				data.getOfflineTestDetail(invresultentryvo, userVO, "1");

			}
			else if(fb.getIsbillingreq().equals("1"))
			{
				data.getOfflineTestDetail(invresultentryvo, userVO, "4");

			}
			
			
			//strResultDtl = NEWOfflineResultEntryHLP.getOfflineResultEntryDtls(invresultentryvo, objRequest_p);
			// System.out.println("strResultDtl "+strResultDtl);
			
			
         System.out.println("before init1234");
			
			if(fb.getIsbillingreq().equals("0"))
			{    
				
				
				strResultDtl = NEWOfflineResultEntryHLP.getOfflineResultEntryDtls(invresultentryvo, objRequest_p);

			}
			else if(fb.getIsbillingreq().equals("1"))
			{
				strResultDtl = NEWOfflineResultEntryHLP.getOfflineResultEntryDtlswithbilling(invresultentryvo, objRequest_p);

			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strResultDtl);

		} catch (Exception e) {
			strMsgText = "SampleCollectionUTIL.checkSampleNoDuplicacy() -> " + e.getMessage();
			new HisException(strMsgText);
		} finally {
		}
		return sbAjaxRes;
	}

	public static void getPatListBarcode(NEWOfflineResultEntryFB fb, HttpServletRequest request) {
		Status status = new Status();
		// status.add(Status.NEW, "", "");
		HttpSession session = request.getSession();
		try {
			List<NEWOfflineResultEntryVO> lstsamplePatinetVO = null;

			lstsamplePatinetVO = new ArrayList<NEWOfflineResultEntryVO>();
			NEWOfflineResultEntryVO objSampleCollectionVO = new NEWOfflineResultEntryVO();

			// WebUTIL.populate(objSampleCollectionVO,fb);

			objSampleCollectionVO.setPatCRNo(fb.getPatCrNo());
			objSampleCollectionVO.setFromDate(fb.getFromDate());
			objSampleCollectionVO.setToDate(fb.getToDate());

			objSampleCollectionVO.setSampleAreaCode(fb.getSampleAreaCode());

			session.removeAttribute(InvestigationConfig.SELECTED_PAT_DETAILS);
			session.removeAttribute(InvestigationConfig.LIST_SAMPLE_PATIENT_VO);

			session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_BILLED);
			session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_UNBILLED);

			session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_BILLED);
			session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_UNBILLED);

			// InvestigationConfig.SELECTED_PAT_DETAILS

			UserVO userVO = ControllerUTIL.getUserVO(request);
			lstsamplePatinetVO = NEWOfflineResultEntryDATA.getPatListBarcode(objSampleCollectionVO, userVO);
			// if(lstsamplePatinetVO!=null)
			// {
			// WebUTIL.populate(fb,lstsamplePatinetVO.get(0));
			WebUTIL.setAttributeInSession(request, InvestigationConfig.LIST_SAMPLE_PATIENT_VO_BARCODE,
					lstsamplePatinetVO);

			// }
			status.add(Status.TRANSINPROCESS, "", "");
		} catch (Exception e) {
			status.add(Status.ERROR_AE, "Application Execution Exception", "");
			e.printStackTrace();
		} finally {
			WebUTIL.setStatus(request, status);
		}
	}

	public static void getSampleCollectionArea(NEWOfflineResultEntryFB fb, HttpServletRequest request) {
		Status status = new Status();
		// status.add(Status.NEW, "", "");
		HttpSession session = request.getSession();
		try {
			List<NEWOfflineResultEntryVO> lstsampleAreaVO = null;
			List<NEWOfflineResultEntryVO> lstsamplePatinetVO = null;
			ControllerUTIL.setSysdate(request);
			Date dt = (Date) request.getSession().getAttribute(Config.SYSDATEOBJECT);
			String todayDate = WebUTIL.getCustomisedSysDate(dt, "dd-MMM-yyyy");

			lstsampleAreaVO = new ArrayList<NEWOfflineResultEntryVO>();
			NEWOfflineResultEntryVO objSampleVO = new NEWOfflineResultEntryVO();
			// WebUTIL.populate(lstsampleAreaVO,fb);
			UserVO userVO = ControllerUTIL.getUserVO(request);
			lstsampleAreaVO = NEWOfflineResultEntryDATA.getSampleCollectionArea(userVO);
			if (lstsampleAreaVO != null) {
				WebUTIL.populate(fb, lstsampleAreaVO);

				List<Entry> sampleList = new ArrayList<Entry>();
				for (NEWOfflineResultEntryVO sampleAreaVO : lstsampleAreaVO) {

					Entry entObj = new Entry();

					entObj.setValue(sampleAreaVO.getSampleAreaCode());
					entObj.setLabel(sampleAreaVO.getSampleAreaName());
					sampleList.add(entObj);

				}
				WebUTIL.setAttributeInSession(request, InvestigationConfig.LIST_SAMPLE_COLLECTION_VO, sampleList);
				lstsamplePatinetVO = (List<NEWOfflineResultEntryVO>) session
						.getAttribute(InvestigationConfig.LIST_SAMPLE_PATIENT_VO);
				if (sampleList.size() == 1) {
					lstsamplePatinetVO = new ArrayList<NEWOfflineResultEntryVO>();

					NEWOfflineResultEntryVO objSampleCollectionVO = new NEWOfflineResultEntryVO();
					// WebUTIL.populate(objSampleCollectionVO,fb);

					objSampleCollectionVO.setPatCRNo(fb.getPatCrNo());
					objSampleCollectionVO.setFromDate(todayDate);
					objSampleCollectionVO.setToDate(todayDate);

					objSampleCollectionVO.setSampleAreaCode(((Entry) sampleList.get(0)).getValue());

					session.removeAttribute(InvestigationConfig.SELECTED_PAT_DETAILS);
					session.removeAttribute(InvestigationConfig.LIST_SAMPLE_PATIENT_VO);

					session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_BILLED);
					session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_UNBILLED);

					session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_BILLED);
					session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_UNBILLED);

					lstsamplePatinetVO = NEWOfflineResultEntryDATA.getPatList(objSampleCollectionVO, userVO);
					if (lstsamplePatinetVO != null) {
						WebUTIL.populate(fb, lstsamplePatinetVO);
						WebUTIL.setAttributeInSession(request, InvestigationConfig.LIST_SAMPLE_PATIENT_VO,
								lstsamplePatinetVO);

					}

					fb.setSampleAreaCode(((Entry) sampleList.get(0)).getValue());
					fb.setSampleAreaName(((Entry) sampleList.get(0)).getLabel());
					fb.setIsSampleAreaSelected("1");

				}
			}

			status.add(Status.TRANSINPROCESS, "", "");
		} catch (Exception e) {
			status.add(Status.ERROR_AE, "Application Execution Exception", "");
			e.printStackTrace();
		} finally {
			WebUTIL.setStatus(request, status);
		}
	}

	// Save Logic
	public static void saveSampleCollectionDetails(NEWOfflineResultEntryFB _fb, HttpServletRequest _request)
			throws BarcodeException, OutputException {
		Status objStatus = new Status();
		HttpSession session = _request.getSession();
		String[] msgBuilder;
		// Logic defined as
		// Map<CRNo,Map<RequisitionNo,Map<SampleCode#labCode,List<NEWOfflineResultEntryVO>>>
		Map<String, Map<String, Map<String, List<NEWOfflineResultEntryVO>>>> mp = new LinkedHashMap<String, Map<String, Map<String, List<NEWOfflineResultEntryVO>>>>();
		// OutputStream os=new ByteArrayOutputStream();

		try {
			Date sysdate = (Date) session.getAttribute(Config.SYSDATEOBJECT);
			UserVO _userVO = getUserVO(_request);
			// HelperMethods.populate(bloodRequisitionDtlVO, _fb);

			String mobileNo = _fb.getPatMobile() == null ? "" : _fb.getPatMobile();
			String emailId = _fb.getPatEmail() == null ? "" : _fb.getPatEmail();
			String patAddress = _fb.getPatAddress() == null ? "" : _fb.getPatAddress();
			String patName = _fb.getPatName() == null ? "" : _fb.getPatName().trim();

			if (patName.length() > 10) {
				patName = patName.substring(0, 10);
			}

			String collAreaCode = _fb.getSampleAreaCode() == null ? "" : _fb.getSampleAreaCode();
			String printStatus = "0"; // Need to discuss

			String[] selectedLabTestCodeArray = _fb.getChkSamplePatient();

			int labRowCount = selectedLabTestCodeArray.length;

			for (int i = 0, k = 0; i < labRowCount; i++) {

				// Getting LabCodeValues from split array
				// chkVal Order crNo#requisitionNo#sampleCode#requisitionDNo //Please Ensure the
				// corresponding Changes before changing this order
				String[] testCodeArray = selectedLabTestCodeArray[i].split("#");

				String crNo = testCodeArray[0];
				String requisitionNo = testCodeArray[1];
				String sampleCode = testCodeArray[2];
				String requisitionDNo = testCodeArray[3];
				String labCode = testCodeArray[4];
				String billNo = testCodeArray[5];
				String testCode = testCodeArray[6];
				String sampleName = testCodeArray[7];
				int index = Integer.parseInt(testCodeArray[8]);
				String samplenoConfig = testCodeArray[9];
				String patType = testCodeArray[22];
				String sampleFormate = testCodeArray[15];
				String initDate = testCodeArray[16];
				String noofSegDigits = testCodeArray[17];
				String fromSeries = testCodeArray[18];
				String toSeries = testCodeArray[19];
				String initType = testCodeArray[20];
				String runningSampleNo = testCodeArray[21];
				String requisitionDate = testCodeArray[12];
				String labName = testCodeArray[11];

				String configLab = testCodeArray[23];
				String configType = testCodeArray[24];
				String configSeq = testCodeArray[25];
				String configTest = testCodeArray[26];
				String configArea = testCodeArray[27];

				String is_deptName_print_barcode = testCodeArray[28];
				String departmentname = testCodeArray[29];
				String testname = testCodeArray[13];
				;

				Map<String, Map<String, List<NEWOfflineResultEntryVO>>> mpReqNo = mp.get(crNo);

				// First Time Insertion
				if (mpReqNo == null) {
					mpReqNo = new LinkedHashMap<String, Map<String, List<NEWOfflineResultEntryVO>>>();

					Map<String, List<NEWOfflineResultEntryVO>> mpSample = new LinkedHashMap<String, List<NEWOfflineResultEntryVO>>();

					List<NEWOfflineResultEntryVO> lstSample = new ArrayList<NEWOfflineResultEntryVO>();
					NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();

					if (!samplenoConfig.equals("1") || !samplenoConfig.equals("2"))

					{
						voSample.setTempSampleNo(_fb.getSampleNo()[index]);
					} else {
						voSample.setTempSampleNo(samplenoConfig);
					}
					// Setting VO Values from labStringArray
					voSample.setPatCRNo(crNo);
					voSample.setSampleCode(sampleCode);
					voSample.setRequisitionDNo(requisitionDNo);
					voSample.setRequisitionNo(requisitionNo);
					voSample.setLabCode(labCode);
					voSample.setPatMobile(mobileNo);
					voSample.setPatEmail(emailId);
					voSample.setPatAddress(patAddress);

					voSample.setSampleAreaCode(collAreaCode);
					voSample.setPrintStatus(printStatus);
					voSample.setSampleQnty(_fb.getSampleQnty()[index]);
					voSample.setDefaultContainerCode(_fb.getDefaultContainerCode()[index]);
					voSample.setDefaultmachineCode(_fb.getDefaultmachineCode()[index]);
					voSample.setDefaultUOMCode(_fb.getDefaultUOMCode()[index]);
					voSample.setTypeOfComponent("1"); // Need to Discuss
					voSample.setIs_dept_barcode_print(is_deptName_print_barcode);
					voSample.setDepartmentName(departmentname);

					voSample.setBillNo(billNo);
					voSample.setTestCode(testCode);
					voSample.setSampleName(sampleName);

					voSample.setCheckAutoLabConfig(samplenoConfig);
					voSample.setTestName(testname);
					voSample.setPatType(patType);
					// Still Some values need to be inserted
					/*
					 * String sampleFormate=testCodeArray[13]; String initDate=testCodeArray[14];
					 * String noofSegDigits=testCodeArray[15]; String fromSeries=testCodeArray[16];
					 * String toSeries=testCodeArray[17]; String initType=testCodeArray[18]; String
					 * runningSampleNo=testCodeArray[19];
					 */

					voSample.setSampleNoFormat(sampleFormate);
					voSample.setInitDate(initDate);
					voSample.setNoOfSeqDigit(noofSegDigits);
					voSample.setFromSeries(fromSeries);
					voSample.setToSeries(toSeries);
					voSample.setInitType(initType);
					voSample.setRunningSampleNo(runningSampleNo);
					voSample.setRequisitionDate(requisitionDate);
					voSample.setLabName(labName);

					voSample.setConfigLab(configLab);
					voSample.setConfigArea(configArea);
					voSample.setConfigSeq(configSeq);
					voSample.setConfigTest(configTest);
					voSample.setConfigType(configType);

					// Adding List of SampleVO<=>RequisitionDNo's
					lstSample.add(voSample);

					// Putting list in Map of SampleCodes
					mpSample.put(sampleCode + "#" + labCode, lstSample);

					// Putting Map of Samples in Map of Requisitions
					mpReqNo.put(requisitionNo, mpSample);

				} else {
					// Set setRequisitions=mpReqNo.keySet();

					// Iterator itrReqNo=setRequisitions.iterator();

					// while(itrReqNo.hasNext())
					// {
					// String reqNo=(String)itrReqNo.next();

					// Getting Map of Sample Codes
					Map<String, List<NEWOfflineResultEntryVO>> mpSample = mpReqNo.get(requisitionNo);

					// First Time Insertion
					if (mpSample == null) {
						mpSample = new LinkedHashMap<String, List<NEWOfflineResultEntryVO>>();

						List<NEWOfflineResultEntryVO> lstSample = new ArrayList<NEWOfflineResultEntryVO>();
						NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();

						// Setting VO Values from labStringArray
						voSample.setPatCRNo(crNo);
						voSample.setSampleCode(sampleCode);
						voSample.setRequisitionDNo(requisitionDNo);
						voSample.setRequisitionNo(requisitionNo);
						voSample.setLabCode(labCode);
						voSample.setPatMobile(mobileNo);
						voSample.setPatEmail(emailId);
						voSample.setPatAddress(patAddress);
						voSample.setIs_dept_barcode_print(is_deptName_print_barcode);
						voSample.setDepartmentName(departmentname);
						voSample.setSampleAreaCode(collAreaCode);
						voSample.setPrintStatus(printStatus);
						voSample.setSampleQnty(_fb.getSampleQnty()[index]);
						voSample.setDefaultContainerCode(_fb.getDefaultContainerCode()[index]);
						voSample.setDefaultmachineCode(_fb.getDefaultmachineCode()[index]);
						voSample.setDefaultUOMCode(_fb.getDefaultUOMCode()[index]);
						voSample.setTypeOfComponent("1"); // Need to Discuss

						voSample.setTestName(testname);
						voSample.setBillNo(billNo);
						voSample.setTestCode(testCode);
						voSample.setSampleName(sampleName);
						voSample.setRequisitionDate(_fb.getRequisitionDate());
						voSample.setLabName(_fb.getLabName());

						// Still Some values need to be inserted

						if (!samplenoConfig.equals("1") || !samplenoConfig.equals("2"))

						{
							voSample.setTempSampleNo(_fb.getSampleNo()[index]);
						} else {
							voSample.setTempSampleNo(samplenoConfig);
						}

						voSample.setCheckAutoLabConfig(samplenoConfig);
						voSample.setPatType(patType);

						voSample.setSampleNoFormat(sampleFormate);
						voSample.setInitDate(initDate);
						voSample.setNoOfSeqDigit(noofSegDigits);
						voSample.setFromSeries(fromSeries);
						voSample.setToSeries(toSeries);
						voSample.setInitType(initType);
						voSample.setRunningSampleNo(runningSampleNo);
						voSample.setRequisitionDate(requisitionDate);
						voSample.setLabName(labName);
						voSample.setConfigLab(configLab);
						voSample.setConfigArea(configArea);
						voSample.setConfigSeq(configSeq);
						voSample.setConfigTest(configTest);
						voSample.setConfigType(configType);

						// Adding List of SampleVO<=>RequisitionDNo's
						lstSample.add(voSample);

						// Putting list in Map of SampleCodes
						mpSample.put(sampleCode + "#" + labCode, lstSample);

					} else {
						// Set setSamples=mpSample.keySet();

						// Iterator itrSamples=setSamples.iterator();

						// while(itrSamples.hasNext())
						// {
						// String tmpSampleCode=(String)itrSamples.next(); // sampleCode#labCode

						List<NEWOfflineResultEntryVO> lstSample = mpSample.get(sampleCode + "#" + labCode);
						if (lstSample == null || lstSample.size() == 0) // First Time Insertion
						{
							lstSample = new ArrayList<NEWOfflineResultEntryVO>();
							NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();

							// Setting VO Values from labStringArray
							voSample.setPatCRNo(crNo);
							voSample.setSampleCode(sampleCode);
							voSample.setRequisitionDNo(requisitionDNo);
							voSample.setRequisitionNo(requisitionNo);
							voSample.setLabCode(labCode);
							voSample.setPatMobile(mobileNo);
							voSample.setPatEmail(emailId);
							voSample.setPatAddress(patAddress);
							voSample.setIs_dept_barcode_print(is_deptName_print_barcode);
							voSample.setDepartmentName(departmentname);
							voSample.setTestName(testname);
							voSample.setSampleAreaCode(collAreaCode);
							voSample.setPrintStatus(printStatus);
							voSample.setSampleQnty(_fb.getSampleQnty()[index]);
							voSample.setDefaultContainerCode(_fb.getDefaultContainerCode()[index]);
							voSample.setDefaultmachineCode(_fb.getDefaultmachineCode()[index]);
							voSample.setDefaultUOMCode(_fb.getDefaultUOMCode()[index]);
							voSample.setTypeOfComponent("1"); // Need to Discuss

							voSample.setBillNo(billNo);
							voSample.setTestCode(testCode);
							voSample.setSampleName(sampleName);
							// Still Some values need to be inserted
							if (!samplenoConfig.equals("1") || !samplenoConfig.equals("2"))

							{
								voSample.setTempSampleNo(_fb.getSampleNo()[index]);
							} else {
								voSample.setTempSampleNo(samplenoConfig);
							}

							voSample.setCheckAutoLabConfig(samplenoConfig);
							voSample.setPatType(patType);

							voSample.setSampleNoFormat(sampleFormate);
							voSample.setInitDate(initDate);
							voSample.setNoOfSeqDigit(noofSegDigits);
							voSample.setFromSeries(fromSeries);
							voSample.setToSeries(toSeries);
							voSample.setInitType(initType);
							voSample.setRunningSampleNo(runningSampleNo);
							voSample.setRequisitionDate(requisitionDate);
							voSample.setLabName(labName);

							voSample.setConfigLab(configLab);
							voSample.setConfigArea(configArea);
							voSample.setConfigSeq(configSeq);
							voSample.setConfigTest(configTest);
							voSample.setConfigType(configType);

							// Adding List of SampleVO<=>RequisitionDNo's
							lstSample.add(voSample);

						} else {
							NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();

							// Setting VO Values from labStringArray
							voSample.setPatCRNo(crNo);
							voSample.setSampleCode(sampleCode);
							voSample.setRequisitionDNo(requisitionDNo);
							voSample.setRequisitionNo(requisitionNo);
							voSample.setLabCode(labCode);
							voSample.setPatMobile(mobileNo);
							voSample.setPatEmail(emailId);
							voSample.setPatAddress(patAddress);
							voSample.setIs_dept_barcode_print(is_deptName_print_barcode);
							voSample.setDepartmentName(departmentname);
							voSample.setTestName(testname);
							voSample.setSampleAreaCode(collAreaCode);
							voSample.setPrintStatus(printStatus);
							voSample.setSampleQnty(_fb.getSampleQnty()[index]);
							voSample.setDefaultContainerCode(_fb.getDefaultContainerCode()[index]);
							voSample.setDefaultmachineCode(_fb.getDefaultmachineCode()[index]);
							voSample.setDefaultUOMCode(_fb.getDefaultUOMCode()[index]);
							voSample.setTypeOfComponent("1"); // Need to Discuss

							voSample.setBillNo(billNo);
							voSample.setTestCode(testCode);
							voSample.setSampleName(sampleName);

							// Still Some values need to be inserted

							if (!samplenoConfig.equals("1") || !samplenoConfig.equals("2"))

							{
								voSample.setTempSampleNo(_fb.getSampleNo()[index]);
							} else {
								voSample.setTempSampleNo(samplenoConfig);
							}

							voSample.setCheckAutoLabConfig(samplenoConfig);
							voSample.setPatType(patType);
							voSample.setSampleNoFormat(sampleFormate);
							voSample.setInitDate(initDate);
							voSample.setNoOfSeqDigit(noofSegDigits);
							voSample.setFromSeries(fromSeries);
							voSample.setToSeries(toSeries);
							voSample.setInitType(initType);
							voSample.setRunningSampleNo(runningSampleNo);
							voSample.setRequisitionDate(requisitionDate);
							voSample.setLabName(labName);

							voSample.setConfigLab(configLab);
							voSample.setConfigArea(configArea);
							voSample.setConfigSeq(configSeq);
							voSample.setConfigTest(configTest);
							voSample.setConfigType(configType);

							// Adding List of SampleVO<=>RequisitionDNo's
							lstSample.add(voSample);
						}

						// Putting list in Map of SampleCodes
						mpSample.put(sampleCode + "#" + labCode, lstSample);
						// }
					}

					// Putting Map of Samples in Map of Requisitions
					mpReqNo.put(requisitionNo, mpSample);

					// }// end while

				} // end main else

				// Putting Map of Requisitions in Map of CrNo's => currently only one CR No is
				// allowed
				mp.put(crNo, mpReqNo);

			} // end for loop

			List listReqdtlId = NEWOfflineResultEntryDATA.saveSampleCollectionDetails(mp, _userVO);
			StringBuffer htmlContents = new StringBuffer();

			/*
			 * //send msg
			 * 
			 * //msgBuilder=_fb.getLabTestCodeArray().split("@");
			 */
			/*
			 * StringBuffer msg=new StringBuffer(); msg.append("your insruction for lab " );
			 * String[] selectedLabTestCodeArray1=_fb.getChkSamplePatient(); for(int
			 * k=0;k<selectedLabTestCodeArray1.length;k++) {
			 * 
			 * String[] value=selectedLabTestCodeArray1[k].split("#"); msg.append( value[27]
			 * +"is " + value[26]); msg.append(","); msg.setLength(msg.length() - 1);
			 * 
			 * }
			 */

			// String message = "Hello "+_fb.getPatName()+","+ msg.toString()+".Thanks and
			// Regards.NIMS";
			/*
			 * System.out.println("chand"+msg);
			 * 
			 */

			StringBuilder str = new StringBuilder();
			// str.append( "<br><table width='100%' border='1'><tr><td width='25%'><font
			// color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'><u> ");
			// str.append( "<br>Sample Collection Dtls::" + "<br>");
			HashMap<String, byte[]> t = new HashMap<String, byte[]>();
			for (int i = 0; i < listReqdtlId.size(); i++) {
				String saveString = (String) listReqdtlId.get(i);
				String[] arrSaveString = saveString.split("#");

				boolean flg = false;
				String samplenoo = arrSaveString[2];
				String samplenoomachine = arrSaveString[2];

				if (arrSaveString.length == 12) {
					flg = true;
					samplenoo = arrSaveString[2] + "" + arrSaveString[11] + "";
				}

				if (arrSaveString.length == 11) {
					flg = true;
					samplenoo = arrSaveString[2] + "" + arrSaveString[10] + "";
				}

				str.append(" Sample Collected Succesfully for Patient CR Number::	");
				str.append((arrSaveString[0]));
				str.append(" having Sample Name::	");
				str.append((arrSaveString[1]));
				str.append(" and Sample No::	");
				str.append((arrSaveString[2]));
				// str.append( "<br>");
				str.append(" and Test Name::	");
				str.append((arrSaveString[9]));
				str.append("<br>");

				// START BAR CODE LOGIC ADDED BY PATHAN BASHA ON 14-07-2015
				String barCodeGenSiString = String.valueOf(listReqdtlId.size());

				// Barcode barcode = BarcodeFactory.createCode128(arrSaveString[3]);

				/*
				 * if((arrSaveString[3].length()%2)==1){ arrSaveString[3]=arrSaveString[3]; }
				 */
				System.out.println("len:" + arrSaveString[6].length());
				System.out.println("tempsampleno:" + arrSaveString[6]);

				/*
				 * Linear linear = new Linear(); linear.setType(Linear.INTERLEAVED25);
				 * linear.setData("0123456789012"); linear.renderBarcode("c:/barcode.gif");
				 * Std2of5Barcode barcode = new Std2of5Barcode(arrSaveString[6],true);
				 * //Int2of5Barcode barcode = new Int2of5Barcode(arrSaveString[3]);
				 * 
				 * barcode.setBarWidth(1); barcode.setResolution(203); barcode.setBarHeight(15);
				 */

				OutputStream os = new ByteArrayOutputStream();

				Barcode barcode = BarcodeFactory.createCode128(arrSaveString[6]);

				barcode.setBarWidth(1);
				barcode.setResolution(203);
				// barcode.setBarHeight(10);

				java.awt.Font font = new java.awt.Font("Plain", Font.NORMAL, 0);
				barcode.setFont(font);
				BarcodeImageHandler.writePNG(barcode, os);

				ByteArrayOutputStream bos = (ByteArrayOutputStream) os;
				byte[] data = bos.toByteArray();
				t.put(arrSaveString[6], data);

				try {
					bos.flush();
					os.flush();
					bos.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("cho"+data.toString());

				/*
				 * htmlContents.
				 * append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >"
				 * ); htmlContents.append("<tr><td width='50%'  ><div id='"
				 * +i+"diivBarCodeControl'><img style='margin-left:-13px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
				 * +i+"diivBarCodeControlAll'><img style='margin-left:-25px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray\" alt=\"no image found in session\"   width='100%' ></div></td></tr>"
				 * );
				 * htmlContents.append("<tr><td width='50%'  style='font-size:15px;' ><div id='"
				 * +i+"diivBarCodeControl'><center>"+arrSaveString[6]
				 * +"</center></div></td><td width='50%' align='left' style='font-size:15px;'><div id='"
				 * +i+"diivBarCodeControlAll'><center>"+arrSaveString[6]+
				 * "</center></div></td></tr>"); htmlContents.
				 * append("<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:30px'><tr><td style='font-size:9px; height='10'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
				 * +arrSaveString[0]
				 * +"</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab :</b></td><td height='8' style='font-size:9px;'>"
				 * +arrSaveString[4]
				 * +"</td></tr><tr><td height='8' style='font-size:9px;'><b>Req. Date:</b></td><td height='8' style='font-size:9px;'>"
				 * +arrSaveString[5]
				 * +"</td></tr><tr><td height='8' style='font-size:9px;'><b>Sample:</b></td><td height='8' style='font-size:9px;'>"
				 * +arrSaveString[7]
				 * +"</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:9px;'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
				 * +arrSaveString[0]
				 * +"</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab :</b></td><td height='8' style='font-size:9px;'>"
				 * +arrSaveString[4]
				 * +"</td></tr><tr><td height='8' style='font-size:9px;'><b>Req. Date:</b></td><td height='8' style='font-size:9px;'>"
				 * +arrSaveString[5]
				 * +"</td></tr><tr><td height='8' style='font-size:9px;'><b>Sample:</b></td><td height='8' style='font-size:9px;'>"
				 * +arrSaveString[7]+"</td></tr> </table></td></tr>");
				 * 
				 */

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				Date date = new Date();
				String datee = dateFormat.format(date);
				String reqdatee = arrSaveString[5];

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");

				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy ");
				SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yy ");
				String reqdateee = "";
				String colldateee = "";
				try {
					Date date1 = sdf.parse(reqdatee);
					reqdateee = sdf1.format(date1);
					Date date2 = sdf2.parse(datee);
					colldateee = sdf3.format(date2);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block

				}

				if (_userVO.getHospitalCode().equals("961011") || _userVO.getHospitalCode().equals("10911")) {

					/*
					 * boolean flgg=false; if(flgg) {
					 */
					htmlContents.append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >");
					htmlContents.append("<tr><td width='50%'  ><div id='" + i
							+ "diivBarCodeControl'><img style='margin-left:-13px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
							+ arrSaveString[6]
							+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
							+ i
							+ "diivBarCodeControlAll'><img style='margin-left:-25px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
							+ arrSaveString[6]
							+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
					htmlContents.append("<tr><td width='50%'  style='font-size:15px;' ><div id='" + i
							+ "diivBarCodeControl'><center>" + arrSaveString[6]
							+ "</center></div></td><td width='50%' align='left' style='font-size:15px;'><div id='" + i
							+ "diivBarCodeControlAll'><center>" + arrSaveString[6] + "</center></div></td></tr>");

					htmlContents.append(
							"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:30px'><tr><td style='font-size:9px; height='10'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[0]
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab Name:</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[4]
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[5] + "/" + datee
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Pt:</b></td><td height='8' style='font-size:9px;'>"
									+ patName
									+ "</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:9px;'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[0]
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab Name:</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[4]
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[5] + "/" + datee
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Pt:</b></td><td height='8' style='font-size:9px;'>"
									+ patName + "</td></tr> </table></td></tr>");

					htmlContents.append("<input type='hidden' id='barCodeGenSize' value='" + barCodeGenSiString
							+ "' name='barCodeGenSize'/></table>");

				} else {

					String is_sammple_duplicate_print = NEWOfflineResultEntryDATA.getsamplebarcodeconfig(_userVO);

					htmlContents.append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >");

					if (arrSaveString[6] != null && (arrSaveString[6].contains("F") || arrSaveString[6].contains("A")
							|| arrSaveString[6].contains("R") || arrSaveString[6].contains("B")
							|| arrSaveString[6].contains("P"))) {
						if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
								&& is_sammple_duplicate_print.equals("1"))
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:20px;height: 30px;width:160;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
						else
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:20px;height: 30px;width:160;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
									+ i
									+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:160px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");

					} else if (arrSaveString[6] != null && (arrSaveString[6].contains("GH"))) {
						if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
								&& is_sammple_duplicate_print.equals("1"))
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:10px;height: 30px;width:180;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
						else
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:10px;height: 30px;width:180;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
									+ i
									+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:180px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");

					} else {

						if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
								&& is_sammple_duplicate_print.equals("1"))
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:30px;height: 30px;width:140;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
						else
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:30px;height: 30px;width:140;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
									+ i
									+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:140px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");

					}

					if (flg) {

						if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
								&& is_sammple_duplicate_print.equals("1"))
							htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
									+ "diivBarCodeControl' style='margin-left:80'>" + samplenoo + "</div></td></tr>");
						else
							htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
									+ "diivBarCodeControl' style='margin-left:80'>" + samplenoo
									+ "</div></td><td width='50%' align='left' style='font-size:12px;'><div id='" + i
									+ "diivBarCodeControlAll' style='margin-left:80'>" + samplenoo
									+ "</div></td></tr>");

					} else {

						if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
								&& is_sammple_duplicate_print.equals("1"))
							htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
									+ "diivBarCodeControl' style='margin-left:80'>" + arrSaveString[6]
									+ "</div></td></tr>");
						else
							htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
									+ "diivBarCodeControl' style='margin-left:80'>" + arrSaveString[6]
									+ "</div></td><td width='50%' align='left' style='font-size:12px;'><div id='" + i
									+ "diivBarCodeControlAll' style='margin-left:80'>" + arrSaveString[6]
									+ "</div></td></tr>");

					}

					if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
							&& is_sammple_duplicate_print.equals("1"))
						htmlContents.append(
								"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:9px'><tr><td style='font-size:8px; height='10'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[0]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[4]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[5] + "/" + datee
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
										+ patName + "</td></tr> </table></td></tr>");
					else
						htmlContents.append(
								"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:9px'><tr><td style='font-size:8px; height='10'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[0]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[4]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[5] + "/" + datee
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
										+ patName
										+ "</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:8px;'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[0]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[4]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[5] + "/" + datee
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
										+ patName + "</td></tr> </table></td></tr>");

					htmlContents.append("<input type='hidden' id='barCodeGenSize' value='" + barCodeGenSiString
							+ "' name='barCodeGenSize'/></table>");

				}

				/*
				 * str.append( "<br><table width='90%' border='1'><tr>");
				 * 
				 * 
				 * 
				 * 
				 * 
				 * str.
				 * append("<td width='20%'><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'> "
				 * ); str.append( " Sample Collected Succesfully for Patient CR Number::" +
				 * "</font></td>"); str.append( "<td width='20%' align='left' >"); str.
				 * append("<font color='#FF0000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"
				 * ); str.append((arrSaveString[0])+ "</font>" + "</td><tr>");
				 * 
				 * str.
				 * append("<tr><td width='20%'><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'> "
				 * ); str.append( "Sample Name::" + "</font></td>"); str.append(
				 * "<td width='20%' align='left' >"); str.
				 * append("<font color='#FF0000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"
				 * ); str.append((arrSaveString[1])+ "</font>" + "</td>");
				 * 
				 * str.
				 * append("<td width='20%'><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'> "
				 * ); str.append( "Sample No::" + "</font></td>"); str.append(
				 * "<td width='20%' align='left' >"); str.
				 * append("<font color='#FF0000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"
				 * ); str.append((arrSaveString[2])+ "</font>" + "</td>");
				 * 
				 * 
				 * str.append("</tr></table>");
				 */

			}

			session.setAttribute(InvestigationConfig.UPLOADED_FILE_AS_ARRAY, t);
			session.setAttribute("sampleNoLabelBarCodeString", htmlContents.toString());
			_fb.setSaveConfirmFlag("1");
			// str.append("</table>");
			System.out.println("html Contents" + htmlContents);
			objStatus.add(Status.NEW, str.toString(),
					"<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"
							+ "Sample Collection Successful" + "<br></font>");

		} catch (HisRecordNotFoundException e) {
			objStatus.add(Status.ERROR_DA, e.getMessage(), "");
			System.out.println(e.getMessage());
		} catch (HisDataAccessException e) {
			objStatus.add(Status.ERROR_DA, e.getMessage(), "");
			System.out.println(e.getMessage());
		} catch (HisApplicationExecutionException e) {
			objStatus.add(Status.ERROR_AE, "", "There was Some Problem.Please Try Again");
			System.out.println(e.getMessage());
		} catch (HisException e) {
			objStatus.add(Status.ERROR, "", "Error");
			System.out.println(e.getMessage());
		} finally {
			WebUTIL.setStatus(_request, objStatus);
		}
	}

	public static void showPatDetails(NEWOfflineResultEntryFB fb, HttpServletRequest request) {
		Status status = new Status();
		HttpSession session = request.getSession();
		UserVO _userVO = getUserVO(request);
		Map mp = new HashMap();
		boolean flag = false;
		String staffImage = "";

		try {
			List<NEWOfflineResultEntryVO> lstsamplePatinetVO = null;
			List<String> reqList = new ArrayList();
			NEWOfflineResultEntryVO voSample = new NEWOfflineResultEntryVO();

			List<String> staffDetails = new ArrayList();

			// fb.setisPatDetailPage("1");
			lstsamplePatinetVO = (List<NEWOfflineResultEntryVO>) session
					.getAttribute(InvestigationConfig.LIST_SAMPLE_PATIENT_VO);
			String selectedCheckBoxValue = fb.getSelectedCheckbox();

			String[] arrSelectedRequisitions = selectedCheckBoxValue.split("@");

			String crNo = arrSelectedRequisitions[0].split("#")[0];
			String reqNO = arrSelectedRequisitions[0].split("#")[1];

			for (NEWOfflineResultEntryVO objSampleCollectionVO : lstsamplePatinetVO) {
				if (flag)
					break;
				if (objSampleCollectionVO.getPatCRNo().equals(crNo)
						&& objSampleCollectionVO.getRequisitionNo().equals(reqNO)) {
					// WebUTIL.populate(fb,objSampleCollectionVO);
					WebUTIL.setAttributeInSession(request, InvestigationConfig.SELECTED_PAT_DETAILS,
							objSampleCollectionVO);
					voSample = objSampleCollectionVO;
					flag = true;
					break;
				}
			}

			for (String str : arrSelectedRequisitions)
				reqList.add(str);

			// WebUTIL.populate(fb,voSample);

			// Billed Transactions
			mp = NEWOfflineResultEntryDATA.getBilledPatList(reqList, voSample, _userVO);

			WebUTIL.setMapInSession(mp, request);

			session.setAttribute(InvestigationConfig.STAFF_DEPENDENT_IMAGE, "");

			/*
			 * staffDetails=NEWOfflineResultEntryDATA.getStaffDetails(crNo,_userVO);
			 * 
			 * if(staffDetails != null){
			 * 
			 * staffImage =
			 * getStaffImage(staffDetails.get(0),staffDetails.get(1),staffDetails.get(2));
			 * 
			 * if(staffImage != null){ if(!(staffImage.equals("0"))){
			 * 
			 * session.setAttribute(InvestigationConfig.STAFF_DEPENDENT_IMAGE, staffImage);
			 * } }
			 * 
			 * }
			 */

			status.add(Status.NEW, "", "");
			status.add(Status.TRANSINPROCESS, "", "");
		} catch (Exception e) {
			status.add(Status.ERROR_AE, "Application Execution Exception", "");
			e.printStackTrace();
		} finally {
			WebUTIL.setStatus(request, status);
		}
	}

	public static String getStaffImage(String empId, String slNo, String hosCode) {

		String base64EncodedImage = "";
		String args = empId + "/" + slNo + "/" + hosCode;
		StringBuffer buf = new StringBuffer();

		try {

			// URL url = new
			// URL("http://10.226.2.186:8780/HBIMS/services/restful/hisImageRetrievalUtil/"+args);
			URL url = new URL("");
			System.out.println("URL STAFF DEPENDENT IMAGE -> " + url);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			// System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				buf.append(output);
			}

			JSONParser parser = new JSONParser();

			JSONObject jsonObject = (JSONObject) parser.parse(buf.toString());

			// String name = (String) jsonObject.get("source");
			// System.out.println(name);

			JSONArray getArray = (JSONArray) jsonObject.get("data");
			// System.out.println(getArray);

			for (int i = 0; i < getArray.size(); i++) {
				JSONObject objects = (JSONObject) getArray.get(i);
				Set keyS = objects.keySet();

				Iterator<String> key = keyS.iterator();
				while (key.hasNext()) {
					String k = key.next().toString();
					if (k.equalsIgnoreCase("HRGBYTE_IMAGE")) {
						// System.out.println("Key : " + k + ", value : " + objects.getString(k));
						base64EncodedImage = (String) objects.get(k);
					}

				}
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return base64EncodedImage;
	}

	/**
	 * AJAX Response : Checking Duplicacy of Sample No
	 * 
	 * @param objFB_p
	 * @param objRequest_p Added By Pawan Kumar B N on 2011.12.21
	 */
	public static StringBuffer checkSampleNoDuplicacy(NEWOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
		StringBuffer sbAjaxRes = new StringBuffer();
		String strMsgText = "";
		try {
			UserVO voUser = ControllerUTIL.getUserVO(objRequest_p);

			NEWOfflineResultEntryVO voSampleCollection = new NEWOfflineResultEntryVO();

			// Setting Area Code and Sample No
			voSampleCollection.setSampleAreaCode(fb.getSampleAreaCode());
			voSampleCollection.setTempSampleNo(fb.getStrSampleNo());

			boolean isTempSamplePresent = NEWOfflineResultEntryDATA.checkSampleNoDuplicacy(voSampleCollection, voUser);
			// sbAjaxRes.append("[{isTempSamplePresent:\'");
			sbAjaxRes.append(isTempSamplePresent);
			// sbAjaxRes.append("\'");
			// sbAjaxRes.append("}]");

		} catch (Exception e) {
			strMsgText = "SampleCollectionUTIL.checkSampleNoDuplicacy() -> " + e.getMessage();
			// HisException eObj =
			new HisException("Investigation", "SampleCollectionUTIL.checkSampleNoDuplicacy() --> ", strMsgText);
			// objFB_p.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() +
			// "],Contact System Administrator! ");
			// eObj = null;
		} finally {
		}
		return sbAjaxRes;
	}

	/**
	 * AJAX Response : Checking SampleNO Formate Is Configure Or Not
	 * 
	 * @param objFB_p
	 * @param objRequest_p Added By Pathan Basha on 2015.06.24
	 */
	public static StringBuffer checkAutoGenFormate(NEWOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
		StringBuffer sbAjaxRes = new StringBuffer();
		String strMsgText = "";
		String strFormate = "";
		Map mp = new HashMap();
		try {
			UserVO voUser = ControllerUTIL.getUserVO(objRequest_p);

			NEWOfflineResultEntryVO voSampleCollection = new NEWOfflineResultEntryVO();

			// LabCod ,TestCode,patType And TempSampleNo
			voSampleCollection.setLabCode(fb.getLabCode());
			voSampleCollection.setTestCode(fb.getTestCode());
			voSampleCollection.setPatType(fb.getPatType());
			voSampleCollection.setTempSampleNo(fb.getTempSampleNo());
			voSampleCollection.setConfigArea(fb.getSampleAreaCode());

			strFormate = NEWOfflineResultEntryDATA.checkAutoGenFormate(voSampleCollection, voUser);
			// sbAjaxRes.append("[{isTempSamplePresent:\'");

			sbAjaxRes.append(strFormate);

			// sbAjaxRes.append("\'");
			// sbAjaxRes.append("}]");

		} catch (Exception e) {
			strMsgText = "SampleCollectionUTIL.checkSampleNoDuplicacy() -> " + e.getMessage();
			// HisException eObj =
			new HisException("Investigation", "SampleCollectionUTIL.checkSampleNoDuplicacy() --> ", strMsgText);
			// objFB_p.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() +
			// "],Contact System Administrator! ");
			// eObj = null;
		} finally {
		}
		return sbAjaxRes;
	}

	// new method for raising cum sample collection

	/**
	 * AJAX Response : Checking Duplicacy of Sample No
	 * 
	 * @param objFB_p
	 * @param objRequest_p Added By Pawan Kumar B N on 2011.12.21
	 */
	public static StringBuffer checkSampleNoDuplicacyRaisingCumSampleCollection(invRaisingCumSamCollectionFB fb,
			HttpServletRequest objRequest_p, String sampleNo, String sampleAreaCode) {
		StringBuffer sbAjaxRes = new StringBuffer();
		String strMsgText = "";
		try {
			UserVO voUser = ControllerUTIL.getUserVO(objRequest_p);

			NEWOfflineResultEntryVO voSampleCollection = new NEWOfflineResultEntryVO();

			// Setting Area Code and Sample No
			voSampleCollection.setSampleAreaCode(sampleAreaCode);
			voSampleCollection.setTempSampleNo(sampleNo);

			boolean isTempSamplePresent = NEWOfflineResultEntryDATA.checkSampleNoDuplicacy(voSampleCollection, voUser);
			// sbAjaxRes.append("[{isTempSamplePresent:\'");
			sbAjaxRes.append(isTempSamplePresent);
			// sbAjaxRes.append("\'");
			// sbAjaxRes.append("}]");

		} catch (Exception e) {
			strMsgText = "SampleCollectionUTIL.checkSampleNoDuplicacy() -> " + e.getMessage();
			// HisException eObj =
			new HisException("Investigation", "SampleCollectionUTIL.checkSampleNoDuplicacy() --> ", strMsgText);
			// objFB_p.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() +
			// "],Contact System Administrator! ");
			// eObj = null;
		} finally {
		}
		return sbAjaxRes;
	}

	public static void duplicateBarCodeDetails(NEWOfflineResultEntryFB fb, HttpServletRequest request)
			throws BarcodeException, OutputException {

		HttpSession session = request.getSession();
		StringBuffer htmlContents = new StringBuffer();
		UserVO _userVO = getUserVO(request);

		HashMap<String, byte[]> t = new HashMap<String, byte[]>();
		for (int i = 0; i < fb.getChkSamplePatient().length; i++) {

			boolean flg = false;
			String[] values = null;
			if (fb.getChkSamplePatient()[i].split("#").length == 11) {
				values = new String[11];
				values = fb.getChkSamplePatient()[i].split("#");
				flg = true;
			} else {
				values = new String[10];
				values = fb.getChkSamplePatient()[i].split("#");
			}

			String sampleno = values[2];
			String crno = values[0];
			String samplename = values[1];
			String reqdate = values[5];
			String labname = values[4];
			String reqdateee = "";
			String colldate = values[6];
			String colldatee = "";

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");

			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy ");
			SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yy ");

			try {
				Date date = sdf.parse(reqdate);
				reqdateee = sdf1.format(date);
				Date date1 = sdf2.parse(colldate);
				colldatee = sdf3.format(date1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String sugartestcodesampleno = "";
			String isdeptname_print = "0";
			String deptname = "";

			if (flg == true) {
				sugartestcodesampleno = values[8];
				isdeptname_print = values[9];
				deptname = values[10];
			} else {
				isdeptname_print = values[8];
				deptname = values[9];
			}

			if (isdeptname_print != null && isdeptname_print.equals("1")) {
				labname = deptname;
			}

			String patname = "";

			if (values[7] != null && values[7].trim().length() > 10)
				patname = values[7].trim().substring(0, 10);
			else
				patname = values[7].trim();

			String barCodeGenSiString = String.valueOf(fb.getChkSamplePatient().length);

			OutputStream os = new ByteArrayOutputStream();
			Barcode barcode = BarcodeFactory.createCode128(sampleno);

			barcode.setBarWidth(1);
			barcode.setResolution(203);
			// barcode.setBarHeight(10);

			java.awt.Font font = new java.awt.Font("Plain", Font.NORMAL, 0);
			barcode.setFont(font);
			BarcodeImageHandler.writePNG(barcode, os);

			ByteArrayOutputStream bos = (ByteArrayOutputStream) os;
			byte[] data = bos.toByteArray();

			t.put(sampleno, data);
			// System.out.println("cho"+data.toString());

			try {
				bos.flush();
				os.flush();
				bos.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * htmlContents.
			 * append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >"
			 * ); htmlContents.append("<tr><td width='50%'  ><div id='"
			 * +i+"diivBarCodeControl'><img style='margin-left:-13px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
			 * +i+"diivBarCodeControlAll'><img style='margin-left:-25px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray\" alt=\"no image found in session\"   width='100%' ></div></td></tr>"
			 * );
			 * htmlContents.append("<tr><td width='50%'  style='font-size:15px;' ><div id='"
			 * +i+"diivBarCodeControl'><center>"+
			 * sampleno+"</center></div></td><td width='50%' align='left' style='font-size:15px;'><div id='"
			 * +i+"diivBarCodeControlAll'><center>"+sampleno+"</center></div></td></tr>");
			 * htmlContents.
			 * append("<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:30px'><tr><td style='font-size:9px; height='10'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
			 * +crno+"</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab :</b></td><td height='8' style='font-size:9px;'>"
			 * +labname+"</td></tr><tr><td height='8' style='font-size:9px;'><b>Req. Date:</b></td><td height='8' style='font-size:9px;'>"
			 * +reqdate+"</td></tr><tr><td height='8' style='font-size:9px;'><b>Sample:</b></td><td height='8' style='font-size:9px;'>"
			 * +samplename+"</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:9px;'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
			 * +crno+"</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab :</b></td><td height='8' style='font-size:9px;'>"
			 * +labname+"</td></tr><tr><td height='8' style='font-size:9px;'><b>Req. Date:</b></td><td height='8' style='font-size:9px;'>"
			 * +reqdate+"</td></tr><tr><td height='8' style='font-size:9px;'><b>Sample:</b></td><td height='8' style='font-size:9px;'>"
			 * +samplename+"</td></tr> </table></td></tr>");
			 * 
			 */

			if (_userVO.getHospitalCode().equals("961011") || _userVO.getHospitalCode().equals("10911")) {
				/*
				 * boolean flgg=false; if(flgg) {
				 */

				htmlContents.append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >");
				htmlContents.append("<tr><td width='50%'  ><div id='" + i
						+ "diivBarCodeControl'><img style='margin-left:-13px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
						+ sampleno
						+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
						+ i
						+ "diivBarCodeControlAll'><img style='margin-left:-25px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
						+ sampleno + "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
				htmlContents.append("<tr><td width='50%'  style='font-size:15px;' ><div id='" + i
						+ "diivBarCodeControl'><center>" + sampleno
						+ "</center></div></td><td width='50%' align='left' style='font-size:15px;'><div id='" + i
						+ "diivBarCodeControlAll'><center>" + sampleno + "</center></div></td></tr>");
				htmlContents.append(
						"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:30px'><tr><td style='font-size:9px; height='10'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
								+ crno
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab :</b></td><td height='8' style='font-size:9px;'>"
								+ labname
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Req/Coll Date:</b></td><td height='8' style='font-size:9px;'>"
								+ reqdate + "/" + colldate
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Pt:</b></td><td height='8' style='font-size:9px;'>"
								+ patname
								+ "</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:9px;'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
								+ crno
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab :</b></td><td height='8' style='font-size:9px;'>"
								+ labname
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Req/Coll Date:</b></td><td height='8' style='font-size:9px;'>"
								+ reqdate + "/" + colldate
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Pt:</b></td><td height='8' style='font-size:9px;'>"
								+ patname + "</td></tr> </table></td></tr>");

				htmlContents.append("<input type='hidden' id='barCodeGenSize' value='" + barCodeGenSiString
						+ "' name='barCodeGenSize'/></table>");
			} else {

				String is_sammple_duplicate_print = NEWOfflineResultEntryDATA.getsamplebarcodeconfig(_userVO);
				// String is_sammple_duplicate_print= "1";

				htmlContents.append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >");

				if (sampleno != null && (sampleno.contains("F") || sampleno.contains("A") || sampleno.contains("R")
						|| sampleno.contains("B") || sampleno.contains("P"))) {
					if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
							&& is_sammple_duplicate_print.equals("1"))
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:20px;height: 30px;width:160;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
					else
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:20px;height: 30px;width:160;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno
								+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
								+ i
								+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:160px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image fsound in session\"   width='100%' ></div></td></tr>");
				} else if (sampleno != null && (sampleno.contains("GH"))) {
					if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
							&& is_sammple_duplicate_print.equals("1"))
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:10px;height: 30px;width:180;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
					else
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:10px;height: 30px;width:180;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno
								+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
								+ i
								+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:180px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image fsound in session\"   width='100%' ></div></td></tr>");
				} else {
					if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
							&& is_sammple_duplicate_print.equals("1"))
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:30px;height: 30px;width:140;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
					else
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:30px;height: 30px;width:140;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno
								+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
								+ i
								+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:140px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image fsound in session\"   width='100%' ></div></td></tr>");
				}

				if (flg) {

					if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
							&& is_sammple_duplicate_print.equals("1"))
						htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
								+ "diivBarCodeControl' style='margin-left:80'>" + sampleno + sugartestcodesampleno
								+ "</div></td></tr>");
					else
						htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
								+ "diivBarCodeControl' style='margin-left:80'>" + sampleno + sugartestcodesampleno
								+ "</div></td><td width='50%' align='left' style='font-size:12px;'><div id='" + i
								+ "diivBarCodeControlAll' style='margin-left:80'>" + sampleno + sugartestcodesampleno
								+ "</div></td></tr>");
				} else {

					if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
							&& is_sammple_duplicate_print.equals("1"))
						htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
								+ "diivBarCodeControl' style='margin-left:80'>" + sampleno + "</div></td></tr>");
					else
						htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
								+ "diivBarCodeControl' style='margin-left:80'>" + sampleno
								+ "</div></td><td width='50%' align='left' style='font-size:12px;'><div id='" + i
								+ "diivBarCodeControlAll' style='margin-left:80'>" + sampleno + "</div></td></tr>");
				}

				if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
						&& is_sammple_duplicate_print.equals("1"))
					htmlContents.append(
							"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:9px'><tr><td style='font-size:8px; height='10'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
									+ crno
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
									+ labname
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
									+ reqdate + "/" + colldate
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
									+ patname + "</td></tr> </table></td></tr>");
				else
					htmlContents.append(
							"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:9px'><tr><td style='font-size:8px; height='10'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
									+ crno
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
									+ labname
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
									+ reqdate + "/" + colldate
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
									+ patname
									+ "</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:8px;'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
									+ crno
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
									+ labname
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
									+ reqdate + "/" + colldate
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
									+ patname + "</td></tr> </table></td></tr>");

				htmlContents.append("<input type='hidden' id='barCodeGenSize' value='" + barCodeGenSiString
						+ "' name='barCodeGenSize'/></table>");

			}

		}

		session.setAttribute(InvestigationConfig.UPLOADED_FILE_AS_ARRAY, t);
		session.setAttribute("sampleNoLabelBarCodeString", htmlContents.toString());
		fb.setSaveConfirmFlag("1");
		// str.append("</table>");
		System.out.println("html Contents" + htmlContents);

	}

	public static StringBuffer getRequisitionFormMasterData(NEWOfflineResultEntryFB fb,
			HttpServletRequest objRequest_p) {
		StringBuffer sbAjaxRes = new StringBuffer();
		HttpSession session = objRequest_p.getSession();
		// Map<String, String> mapUnavailableTestCode =(Map<String, String>)
		// session.getAttribute(InvestigationConfig.MAP_USER_CODE_WISE_TEST_AVAILABILITY_DTLS);
		// System.out.println("mapUnavailableTestCode : "+mapUnavailableTestCode);
		String strMsgText = "";
		String remarks = "1";
		String lstEpisodeVOo = "";
		Map mp = new HashMap();
		try {
			UserVO userVO = ControllerUTIL.getUserVO(objRequest_p);
			String testCode = fb.getTestCode();
			// LabTestVO voLabTest = mapUserCodeLabTestVO.get(userTestCode);

			lstEpisodeVOo = InvestigationRaisingDtlDATA.getRequisitionFormMasterData(testCode, userVO);

			// System.out.println("userTestCode getRemarksForUnavailableTest UTL
			// "+userTestCode+ " : remarks -- : "+remarks);

			sbAjaxRes.append(lstEpisodeVOo);

		} catch (Exception e) {
			strMsgText = "---> " + e.getMessage();
			// HisException eObj =
			new HisException(strMsgText);
			// objFB_p.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() +
			// "],Contact System Administrator! ");
			// eObj = null;
		} finally {
		}

		return sbAjaxRes;
	}

	// added by krishnan nema on 25042019
	public static void getPatListSampleColAdvance(NEWOfflineResultEntryFB fb, HttpServletRequest request) {
		Status status = new Status();
		// status.add(Status.NEW, "", "");
		HttpSession session = request.getSession();
		try {
			List<NEWOfflineResultEntryVO> lstsamplePatinetVO = null;

			lstsamplePatinetVO = new ArrayList<NEWOfflineResultEntryVO>();
			NEWOfflineResultEntryVO objSampleCollectionVO = new NEWOfflineResultEntryVO();

			// WebUTIL.populate(objSampleCollectionVO,fb);
			if (fb.getPatCrNo() != null && !fb.getPatCrNo().equals(""))
				objSampleCollectionVO.setPatCRNo(fb.getPatCrNo());

			if (fb.getPatCrNo() != null && !fb.getPatCrNo().equals(""))
				objSampleCollectionVO.setPatCRNo(fb.getPatCrNo());
			objSampleCollectionVO.setFromDate(fb.getFromDate());
			objSampleCollectionVO.setToDate(fb.getToDate());

			objSampleCollectionVO.setSampleAreaCode(fb.getSampleAreaCode());
			objSampleCollectionVO.setWardCode(fb.getWardCode());

			session.removeAttribute(InvestigationConfig.SELECTED_PAT_DETAILS);
			session.removeAttribute(InvestigationConfig.LIST_SAMPLE_PATIENT_VO);

			session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_BILLED);
			session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_UNBILLED);

			session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_BILLED);
			session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_UNBILLED);

			// InvestigationConfig.SELECTED_PAT_DETAILS

			UserVO userVO = ControllerUTIL.getUserVO(request);
			lstsamplePatinetVO = NEWOfflineResultEntryDATA.getPatListSampleColAdvance(objSampleCollectionVO, userVO);

			// if(lstsamplePatinetVO!=null)
			// {
			// WebUTIL.populate(fb,lstsamplePatinetVO.get(0));
			WebUTIL.setAttributeInSession(request, InvestigationConfig.LIST_SAMPLE_PATIENT_VO, lstsamplePatinetVO);

			// }
			status.add(Status.TRANSINPROCESS, "", "");
		} catch (Exception e) {
			status.add(Status.ERROR_AE, "Application Execution Exception", "");
			e.printStackTrace();
		} finally {
			WebUTIL.setStatus(request, status);
		}
	}

	// Added by prachi for patient dtl tile

	public static JsonObject AjaxGetPatDetails(NEWOfflineResultEntryFB fb, HttpServletRequest request) {

		Status objStatus = new Status();
		InvTrackingReportVO vo = new InvTrackingReportVO();
		Map mp = new HashMap();

		JsonObject jsonResponse = new JsonObject();
		JsonArray patDetailsObjectRowContainer = new JsonArray();

		try {
			fb.setSearchType("1"); // CrNo based patient search
			UserVO userVO = ControllerUTIL.getUserVO(request);
			HelperMethods.populate(vo, fb);
			ControllerUTIL.setSysdate(request);

			mp = InvTrackingReportDATA.AjaxGetPatDetails(vo, userVO);
			InvTrackingReportVO vo2 = (InvTrackingReportVO) mp.get("patDetails");

			if (vo2 != null) {
				JsonObject objectRow = new JsonObject();

				/* OPD Patient Data */
				objectRow.addProperty("patientName", vo2.getPatName() == null ? "" : vo2.getPatName());
				objectRow.addProperty("crNumber", vo2.getCrNumber() == null ? "" : vo2.getCrNumber());
				objectRow.addProperty("isUnknown", vo2.getIsUnknown() == null ? "" : vo2.getIsUnknown());
				objectRow.addProperty("isDead", vo2.getIsDead() == null ? "" : vo2.getIsDead());
				objectRow.addProperty("isMlc", vo2.getIsMlc() == null ? "" : vo2.getIsMlc());
				objectRow.addProperty("patFirstName", vo2.getPatFirstName() == null ? "" : vo2.getPatFirstName());
				objectRow.addProperty("patMiddleName", vo2.getPatMiddleName() == null ? "" : vo2.getPatMiddleName());
				objectRow.addProperty("patLastName", vo2.getPatLastName() == null ? "" : vo2.getPatLastName());
				objectRow.addProperty("patGuardianName",
						vo2.getPatGuardianName() == null ? "" : vo2.getPatGuardianName());
				objectRow.addProperty("patCategoryCode",
						vo2.getPatCategoryCode() == null ? "" : vo2.getPatCategoryCode());
				objectRow.addProperty("patAge", vo2.getPatAge() == null ? "" : vo2.getPatAge());
				objectRow.addProperty("patHusbandName", vo2.getPatHusbandName() == null ? "" : vo2.getPatHusbandName());
				objectRow.addProperty("patGenderCode", vo2.getPatGenderCode() == null ? "" : vo2.getPatGenderCode());
				objectRow.addProperty("patCategory", vo2.getPatCategory() == null ? "" : vo2.getPatCategory());
				objectRow.addProperty("patDOB", vo2.getPatDOB() == null ? "" : vo2.getPatDOB());
				objectRow.addProperty("isActualDob", vo2.getIsActualDob() == null ? "" : vo2.getIsActualDob());
				objectRow.addProperty("patGender", vo2.getPatGender() == null ? "" : vo2.getPatGender());
				objectRow.addProperty("patStatusCode", vo2.getPatStatusCode() == null ? "" : vo2.getPatStatusCode());
				objectRow.addProperty("patStatus", vo2.getPatStatus() == null ? "" : vo2.getPatStatus());
				objectRow.addProperty("patMobileNo", vo2.getPatMobileNo() == null ? "" : vo2.getPatMobileNo());
				objectRow.addProperty("patAddress", vo2.getPatAddress() == null ? "" : vo2.getPatAddress());
				objectRow.addProperty("isCatExpired", vo2.getIsCatExpired() == null ? "" : vo2.getIsCatExpired());
				objectRow.addProperty("patEmailId", vo2.getPatEmailId() == null ? "" : vo2.getPatEmailId());
				/* IPD Patient Data */
				objectRow.addProperty("admissionDate", vo2.getAdmissionDate() == null ? "" : vo2.getAdmissionDate());
				objectRow.addProperty("patDeptUnitCode",
						vo2.getPatDeptUnitCode() == null ? "" : vo2.getPatDeptUnitCode());
				objectRow.addProperty("patVisitNo", vo2.getPatVisitNo() == null ? "" : vo2.getPatVisitNo());
				objectRow.addProperty("patEpisodeCode", vo2.getPatEpisodeCode() == null ? "" : vo2.getPatEpisodeCode());
				objectRow.addProperty("admittedDepartmentCode",
						vo2.getAdmittedDepartmentCode() == null ? "" : vo2.getAdmittedDepartmentCode());
				objectRow.addProperty("patAdmissionNo", vo2.getPatAdmissionNo() == null ? "" : vo2.getPatAdmissionNo());
				objectRow.addProperty("patDeptUnit", vo2.getPatDeptUnit() == null ? "" : vo2.getPatDeptUnit());
				objectRow.addProperty("admittedDepartmentName",
						vo2.getAdmittedDepartmentName() == null ? "" : vo2.getAdmittedDepartmentName());
				objectRow.addProperty("patWardCode", vo2.getPatWardCode() == null ? "" : vo2.getPatWardCode());
				objectRow.addProperty("admittedDepartmentCode",
						vo2.getAdmittedDepartmentCode() == null ? "" : vo2.getAdmittedDepartmentCode());
				objectRow.addProperty("patWardName", vo2.getPatWardName() == null ? "" : vo2.getPatWardName());
				objectRow.addProperty("patRoomNo", vo2.getPatRoomNo() == null ? "" : vo2.getPatRoomNo());
				objectRow.addProperty("patRoomName", vo2.getPatRoomName() == null ? "" : vo2.getPatRoomName());
				objectRow.addProperty("bedCode", vo2.getBedCode() == null ? "" : vo2.getBedCode());
				objectRow.addProperty("bedName", vo2.getBedName() == null ? "" : vo2.getBedName());
				objectRow.addProperty("hospitalCode", vo2.getHospitalCode() == null ? "" : vo2.getHospitalCode());
				objectRow.addProperty("consultantName", vo2.getConsultantName() == null ? "" : vo2.getConsultantName());
				objectRow.addProperty("patMlcNo", vo2.getPatMlcNo() == null ? "" : vo2.getPatMlcNo());
				objectRow.addProperty("diagnosis", vo2.getDiagnosis() == null ? "" : vo2.getDiagnosis());
				objectRow.addProperty("patAccNo", vo2.getPatAccNo() == null ? "" : vo2.getPatAccNo());

				patDetailsObjectRowContainer.add(objectRow);
			}
			jsonResponse.add("patDetails", patDetailsObjectRowContainer);

			objStatus.add(Status.TRANSINPROCESS);
		} catch (HisDataAccessException e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.ERROR_DA, "", "Data Access Error");
		} catch (HisApplicationExecutionException e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.ERROR_AE, "", "Application Execution Error");
		} catch (HisException e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.ERROR, "", "Error");
		}
		return jsonResponse;

	}

	public static String AjaxBilledUnbilledDetails(NEWOfflineResultEntryFB fb, HttpServletRequest request) {

		Status objStatus = new Status();

		NEWOfflineResultEntryVO vo = new NEWOfflineResultEntryVO();
		// Map mp=new HashMap();
		String mp = null;
		try {

			UserVO userVO = ControllerUTIL.getUserVO(request);
			HelperMethods.populate(vo, fb);
			if (fb.getPatStatusCode().equalsIgnoreCase("1")) // ------OPD
			{
				vo.setReqType(fb.getPatStatusCode());
			}
			if (fb.getPatStatusCode().equalsIgnoreCase("2")) // -----------IPD
			{
				vo.setReqType(fb.getPatStatusCode());
			}
			if (fb.getPatStatusCode().equalsIgnoreCase("3")) // ---------OPD EMERGENCY
			{
				vo.setReqType(fb.getPatStatusCode());
			}
			if (fb.getPatStatusCode().equalsIgnoreCase("4")) // -----------OPD SPECIAL
			{
				vo.setReqType(fb.getPatStatusCode());
			}

			ControllerUTIL.setSysdate(request);

			mp = NEWOfflineResultEntryDATA.AjaxBilledUnbilledDetails(vo, userVO);

			objStatus.add(Status.TRANSINPROCESS);
		} catch (HisDataAccessException e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.ERROR_DA, "", "Data Access Error");
		} catch (HisApplicationExecutionException e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.ERROR_AE, "", "Application Execution Error");
		} catch (HisException e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.ERROR, "", "Error");
		}
		return mp;

	}

	public static String AjaxGetDetails(NEWOfflineResultEntryFB fb, HttpServletRequest request) {

		Status objStatus = new Status();
		NEWOfflineResultEntryVO vo = new NEWOfflineResultEntryVO();
		String mp = null;

		try {
			InvestigationEssentialOfflineDelegate daoDelegate = new InvestigationEssentialOfflineDelegate();

			UserVO userVO = ControllerUTIL.getUserVO(request);
			HelperMethods.populate(vo, fb);
			if (fb.getPatStatusCode().equalsIgnoreCase("1")) // ------OPD
			{
				vo.setReqType("2");

			}
			if (fb.getPatStatusCode().equalsIgnoreCase("2")) // -----------IPD
			{
				vo.setReqType("1");

				String wardcode = fb.getSampleAreaCode();
				fb.setWardCode(wardcode);
				vo.setWardCode(wardcode);

				String collarea = daoDelegate.getcollectionareafromward(wardcode, userVO.getHospitalCode());

				fb.setSampleAreaCode(collarea);
				vo.setSampleAreaCode(collarea);

			}
			if (fb.getPatStatusCode().equalsIgnoreCase("3")) // ---------OPD EMERGENCY
			{
				vo.setReqType("3");
			}
			if (fb.getPatStatusCode().equalsIgnoreCase("4")) // -----------OPD SPECIAL
			{
				vo.setReqType("4");
			}

			if (fb.getWardCode() != null && !fb.getWardCode().equals("")) {
				vo.setReqType("1");

			}

			String isexist = NEWOfflineResultEntryDATA.getcollectionareafromward(vo.getWardCode(),
					userVO.getHospitalCode());

			if (isexist != null && !isexist.equals("")) {
				request.setAttribute("wardnotfound", "1");
			} else {
				request.setAttribute("wardnotfound", "0");
			}

			ControllerUTIL.setSysdate(request);

			mp = NEWOfflineResultEntryDATA.AjaxGetDetails(vo, userVO);

			objStatus.add(Status.TRANSINPROCESS);
		} catch (HisDataAccessException e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.ERROR_DA, "", "Data Access Error");
		} catch (HisApplicationExecutionException e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.ERROR_AE, "", "Application Execution Error");
		} catch (HisException e) {
			System.out.println(e.getMessage());
			objStatus.add(Status.ERROR, "", "Error");
		}
		return mp;

	}

	public static void AJAXsaveSampleCollectionDetails(
			Map<String, Map<String, Map<String, List<NEWOfflineResultEntryVO>>>> mp, NEWOfflineResultEntryFB _fb,
			HttpServletRequest _request, HttpServletResponse _response)
			throws BarcodeException, OutputException, IOException {
		Status objStatus = new Status();
		HttpSession session = _request.getSession();
		String[] msgBuilder;
		UserVO _userVO = getUserVO(_request);
		String mobileNo = _fb.getPatMobile() == null ? "" : _fb.getPatMobile();
		String emailId = _fb.getPatEmail() == null ? "" : _fb.getPatEmail();
		String patAddress = _fb.getPatAddress() == null ? "" : _fb.getPatAddress();
		String patName = _fb.getPatName() == null ? "" : _fb.getPatName().trim();

		try {
			List listReqdtlId = NEWOfflineResultEntryDATA.saveSampleCollectionDetails(mp, _userVO);
			StringBuffer htmlContents = new StringBuffer();
			StringBuilder str = new StringBuilder();

			HashMap<String, byte[]> t = new HashMap<String, byte[]>();
			for (int i = 0; i < listReqdtlId.size(); i++) {
				String saveString = (String) listReqdtlId.get(i);
				String[] arrSaveString = saveString.split("#");

				boolean flg = false;
				String samplenoo = arrSaveString[2];
				String samplenoomachine = arrSaveString[2];

				if (arrSaveString.length == 12) {
					flg = true;
					samplenoo = arrSaveString[2] + "" + arrSaveString[11] + "";
				}

				if (arrSaveString.length == 11) {
					flg = true;
					samplenoo = arrSaveString[2] + "" + arrSaveString[10] + "";
				}

				str.append(" Sample Collected Succesfully for Patient CR Number::	");
				str.append((arrSaveString[0]));
				str.append(" having Sample Name::	");
				str.append((arrSaveString[1]));
				str.append(" and Sample No::	");
				str.append((arrSaveString[2]));
				// str.append( "<br>");
				str.append(" and Test Name::	");
				str.append((arrSaveString[9]));
				str.append("<br>");

				// START BAR CODE LOGIC ADDED BY PATHAN BASHA ON 14-07-2015
				String barCodeGenSiString = String.valueOf(listReqdtlId.size());

				System.out.println("len:" + arrSaveString[6].length());
				System.out.println("tempsampleno:" + arrSaveString[6]);
				OutputStream os = new ByteArrayOutputStream();

				Barcode barcode = BarcodeFactory.createCode128(arrSaveString[6]);

				barcode.setBarWidth(1);
				barcode.setResolution(203);
				// barcode.setBarHeight(10);

				java.awt.Font font = new java.awt.Font("Plain", Font.NORMAL, 0);
				barcode.setFont(font);
				BarcodeImageHandler.writePNG(barcode, os);

				ByteArrayOutputStream bos = (ByteArrayOutputStream) os;
				byte[] data = bos.toByteArray();
				t.put(arrSaveString[6], data);

				try {
					bos.flush();
					os.flush();
					bos.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				Date date = new Date();
				String datee = dateFormat.format(date);
				String reqdatee = arrSaveString[5];

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");

				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy ");
				SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yy ");
				String reqdateee = "";
				String colldateee = "";
				try {
					Date date1 = sdf.parse(reqdatee);
					reqdateee = sdf1.format(date1);
					Date date2 = sdf2.parse(datee);
					colldateee = sdf3.format(date2);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block

				}

				if (_userVO.getHospitalCode().equals("961011") || _userVO.getHospitalCode().equals("10911")) {

					htmlContents.append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >");
					htmlContents.append("<tr><td width='50%'  ><div id='" + i
							+ "diivBarCodeControl'><img style='margin-left:-13px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
							+ arrSaveString[6]
							+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
							+ i
							+ "diivBarCodeControlAll'><img style='margin-left:-25px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
							+ arrSaveString[6]
							+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
					htmlContents.append("<tr><td width='50%'  style='font-size:15px;' ><div id='" + i
							+ "diivBarCodeControl'><center>" + arrSaveString[6]
							+ "</center></div></td><td width='50%' align='left' style='font-size:15px;'><div id='" + i
							+ "diivBarCodeControlAll'><center>" + arrSaveString[6] + "</center></div></td></tr>");

					htmlContents.append(
							"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:30px'><tr><td style='font-size:9px; height='10'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[0]
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab Name:</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[4]
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[5] + "/" + datee
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Pt:</b></td><td height='8' style='font-size:9px;'>"
									+ patName
									+ "</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:9px;'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[0]
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab Name:</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[4]
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:9px;'>"
									+ arrSaveString[5] + "/" + datee
									+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Pt:</b></td><td height='8' style='font-size:9px;'>"
									+ patName + "</td></tr> </table></td></tr>");

					htmlContents.append("<input type='hidden' id='barCodeGenSize' value='" + barCodeGenSiString
							+ "' name='barCodeGenSize'/></table>");

				} else {

					String is_sammple_duplicate_print = NEWOfflineResultEntryDATA.getsamplebarcodeconfig(_userVO);

					htmlContents.append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >");

					if (arrSaveString[6] != null && (arrSaveString[6].contains("F") || arrSaveString[6].contains("A")
							|| arrSaveString[6].contains("R") || arrSaveString[6].contains("B")
							|| arrSaveString[6].contains("P"))) {
						if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
								&& is_sammple_duplicate_print.equals("1"))
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:20px;height: 30px;width:160;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
						else
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:20px;height: 30px;width:160;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
									+ i
									+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:160px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");

					} else {

						if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
								&& is_sammple_duplicate_print.equals("1"))
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:30px;height: 30px;width:140;margin-top:5px' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
						else
							htmlContents.append("<tr><td width='50%'  ><div id='" + i
									+ "diivBarCodeControl'><img style='margin-left:30px;height: 30px;width:140;margin-top:5px' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
									+ i
									+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:140px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
									+ arrSaveString[6]
									+ "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");

					}

					if (flg) {

						if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
								&& is_sammple_duplicate_print.equals("1"))
							htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
									+ "diivBarCodeControl' style='margin-left:80'>" + samplenoo + "</div></td></tr>");
						else
							htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
									+ "diivBarCodeControl' style='margin-left:80'>" + samplenoo
									+ "</div></td><td width='50%' align='left' style='font-size:12px;'><div id='" + i
									+ "diivBarCodeControlAll' style='margin-left:80'>" + samplenoo
									+ "</div></td></tr>");

					} else {

						if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
								&& is_sammple_duplicate_print.equals("1"))
							htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
									+ "diivBarCodeControl' style='margin-left:80'>" + arrSaveString[6]
									+ "</div></td></tr>");
						else
							htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
									+ "diivBarCodeControl' style='margin-left:80'>" + arrSaveString[6]
									+ "</div></td><td width='50%' align='left' style='font-size:12px;'><div id='" + i
									+ "diivBarCodeControlAll' style='margin-left:80'>" + arrSaveString[6]
									+ "</div></td></tr>");

					}

					if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
							&& is_sammple_duplicate_print.equals("1"))
						htmlContents.append(
								"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:9px'><tr><td style='font-size:8px; height='10'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[0]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[4]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[5] + "/" + datee
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
										+ patName + "</td></tr> </table></td></tr>");
					else
						htmlContents.append(
								"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:9px'><tr><td style='font-size:8px; height='10'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[0]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[4]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[5] + "/" + datee
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
										+ patName
										+ "</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:8px;'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[0]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[4]
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
										+ arrSaveString[5] + "/" + datee
										+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
										+ patName + "</td></tr> </table></td></tr>");

					htmlContents.append("<input type='hidden' id='barCodeGenSize' value='" + barCodeGenSiString
							+ "' name='barCodeGenSize'/></table>");

				}

			}
			// ResponseMgs
			session.setAttribute(InvestigationConfig.UPLOADED_FILE_AS_ARRAY, t);
			session.setAttribute("sampleNoLabelBarCodeString", htmlContents.toString());
			_fb.setSaveConfirmFlag("1");
			// str.append("</table>");
			System.out.println("html Contents" + htmlContents);
			objStatus.add(Status.TRANSINPROCESS);
			WebUTIL.setStatus(_request, objStatus);

			_fb.setResponseMgs(str.toString());

			_response.getWriter().write(_fb.getResponseMgs());
			// _response.getWriter().append(htmlContents.toString());

		} catch (HisRecordNotFoundException e) {
			objStatus.add(Status.ERROR_DA, e.getMessage(), "");
			System.out.println(e.getMessage());
			_fb.setResponseMgs("There is some problem in sample collection ");
		} catch (HisDataAccessException e) {
			objStatus.add(Status.ERROR_DA, e.getMessage(), "");
			System.out.println(e.getMessage());
			_fb.setResponseMgs("There is some problem in sample collection ");
		} catch (HisApplicationExecutionException e) {
			objStatus.add(Status.ERROR_AE, "", "There was Some Problem.Please Try Again");
			System.out.println(e.getMessage());
			_fb.setResponseMgs("There is some problem in sample collection ");
		} catch (HisException e) {
			objStatus.add(Status.ERROR, "", "Error");
			System.out.println(e.getMessage());
			_fb.setResponseMgs("There is some problem in sample collection ");
		} finally {
			WebUTIL.setStatus(_request, objStatus);
		}
	}

	public static String ajaxcheckAutoGenFormate(NEWOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
		StringBuffer sbAjaxRes = new StringBuffer();
		String strFormate = "";
		String json = "";
		Map mp = new HashMap();
		try {
			UserVO voUser = ControllerUTIL.getUserVO(objRequest_p);

			NEWOfflineResultEntryVO voSampleCollection = new NEWOfflineResultEntryVO();

			// LabCod ,TestCode,patType And TempSampleNo
			voSampleCollection.setLabCode(fb.getLabCode());
			voSampleCollection.setTestCode(fb.getTestCode());
			voSampleCollection.setPatType(fb.getPatType());
			voSampleCollection.setTempSampleNo(fb.getTempSampleNo());
			voSampleCollection.setConfigArea(fb.getSampleAreaCode());

			strFormate = NEWOfflineResultEntryDATA.checkAutoGenFormate(voSampleCollection, voUser);

			Gson gson = new Gson();

			json = gson.toJson(strFormate);

			System.out.println(json);

		} catch (Exception e) {

		} finally {
		}
		return json;
	}

	public static String AJAXgetPatListBarcode(NEWOfflineResultEntryFB fb, HttpServletRequest request) {
		Status status = new Status();
		HttpSession session = request.getSession();
		JsonObject jsonObj = new JsonObject();
		try {
			List<NEWOfflineResultEntryVO> lstsamplePatinetVO = null;

			lstsamplePatinetVO = new ArrayList<NEWOfflineResultEntryVO>();
			NEWOfflineResultEntryVO objSampleCollectionVO = new NEWOfflineResultEntryVO();
			objSampleCollectionVO.setPatCRNo(fb.getPatCrNo());
			objSampleCollectionVO.setFromDate(fb.getFromDate());
			objSampleCollectionVO.setToDate(fb.getToDate());

			objSampleCollectionVO.setSampleAreaCode(fb.getSampleAreaCode());

			session.removeAttribute(InvestigationConfig.SELECTED_PAT_DETAILS);
			session.removeAttribute(InvestigationConfig.LIST_SAMPLE_PATIENT_VO);

			session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_BILLED);
			session.removeAttribute(InvestigationConfig.LIST_PAT_SAMPLE_UNBILLED);

			session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_BILLED);
			session.removeAttribute(InvestigationConfig.MAP_PAT_SAMPLE_UNBILLED);

			UserVO userVO = ControllerUTIL.getUserVO(request);
			lstsamplePatinetVO = NEWOfflineResultEntryDATA.getPatListBarcode(objSampleCollectionVO, userVO);

			// -----------------converting arraylist to json object nd then json
			// string--------------------------------
			JsonArray jsonArray2 = new Gson().toJsonTree(lstsamplePatinetVO).getAsJsonArray();

			jsonObj.add("DuplicateBarCodePatientData", jsonArray2);
			System.out.println(jsonObj.toString());

			status.add(Status.TRANSINPROCESS, "", "");
		} catch (Exception e) {
			status.add(Status.ERROR_AE, "Application Execution Exception", "");
			e.printStackTrace();
		} finally {
			WebUTIL.setStatus(request, status);
		}
		return jsonObj.toString();

	}

	public static void AJAXduplicateBarCodeDetails(NEWOfflineResultEntryFB fb, List<NEWOfflineResultEntryVO> lstSample,
			HttpServletRequest request, HttpServletResponse response)
			throws BarcodeException, OutputException, IOException {
		StringBuffer htmlContents = new StringBuffer();
		UserVO _userVO = getUserVO(request);
		Status objStatus = new Status();
		HttpSession session = request.getSession();
		HashMap<String, byte[]> t = new HashMap<String, byte[]>();

		NEWOfflineResultEntryVO voSampleCollection = new NEWOfflineResultEntryVO();

		for (int i = 0; i < lstSample.size(); i++) {
			voSampleCollection = lstSample.get(i);

			String sampleno = voSampleCollection.getSampleNo();
			String crno = voSampleCollection.getPatCRNo();
			String samplename = voSampleCollection.getSampleName();
			String reqdate = voSampleCollection.getRequisitionDate();
			String labname = voSampleCollection.getLabName();
			String colldate = voSampleCollection.getSampleCollectionDate();
			String reqdateee = "";
			String colldatee = "";

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");

			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy ");
			SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yy ");

			try {
				Date date = sdf.parse(reqdate);
				reqdateee = sdf1.format(date);
				Date date1 = sdf2.parse(colldate);
				colldatee = sdf3.format(date1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String sugartestcodesampleno = "";
			sugartestcodesampleno = voSampleCollection.getSugarTestCode();
			String patname = "";

			if (voSampleCollection.getpatName() != null && voSampleCollection.getpatName().trim().length() > 10)
				patname = voSampleCollection.getpatName().trim().substring(0, 10);
			else
				patname = voSampleCollection.getpatName().trim();

			String barCodeGenSiString = String.valueOf(lstSample.size());

			OutputStream os = new ByteArrayOutputStream();
			Barcode barcode = BarcodeFactory.createCode128(sampleno);

			barcode.setBarWidth(1);
			barcode.setResolution(203);
			// barcode.setBarHeight(10);

			java.awt.Font font = new java.awt.Font("Plain", Font.NORMAL, 0);
			barcode.setFont(font);
			BarcodeImageHandler.writePNG(barcode, os);

			ByteArrayOutputStream bos = (ByteArrayOutputStream) os;
			byte[] data = bos.toByteArray();

			t.put(sampleno, data);
			// System.out.println("cho"+data.toString());

			try {
				bos.flush();
				os.flush();
				bos.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (_userVO.getHospitalCode().equals("961011") || _userVO.getHospitalCode().equals("10911")) {
				/*
				 * boolean flgg=false; if(flgg) {
				 */

				htmlContents.append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >");
				htmlContents.append("<tr><td width='50%'  ><div id='" + i
						+ "diivBarCodeControl'><img style='margin-left:-13px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
						+ sampleno
						+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
						+ i
						+ "diivBarCodeControlAll'><img style='margin-left:-25px;height: 30px;' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
						+ sampleno + "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
				htmlContents.append("<tr><td width='50%'  style='font-size:15px;' ><div id='" + i
						+ "diivBarCodeControl'><center>" + sampleno
						+ "</center></div></td><td width='50%' align='left' style='font-size:15px;'><div id='" + i
						+ "diivBarCodeControlAll'><center>" + sampleno + "</center></div></td></tr>");
				htmlContents.append(
						"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:30px'><tr><td style='font-size:9px; height='10'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
								+ crno
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab :</b></td><td height='8' style='font-size:9px;'>"
								+ labname
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Req/Coll Date:</b></td><td height='8' style='font-size:9px;'>"
								+ reqdate + "/" + colldate
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Pt:</b></td><td height='8' style='font-size:9px;'>"
								+ patname
								+ "</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:9px;'><b>CR No.</b></td><td height='8' style='font-size:9px;'>"
								+ crno
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Lab :</b></td><td height='8' style='font-size:9px;'>"
								+ labname
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Req/Coll Date:</b></td><td height='8' style='font-size:9px;'>"
								+ reqdate + "/" + colldate
								+ "</td></tr><tr><td height='8' style='font-size:9px;'><b>Pt:</b></td><td height='8' style='font-size:9px;'>"
								+ patname + "</td></tr> </table></td></tr>");

				htmlContents.append("<input type='hidden' id='barCodeGenSize' value='" + barCodeGenSiString
						+ "' name='barCodeGenSize'/></table>");
			} else {

				String is_sammple_duplicate_print = NEWOfflineResultEntryDATA.getsamplebarcodeconfig(_userVO);
				// String is_sammple_duplicate_print= "1";

				htmlContents.append("<table width='105%' height='30' cellspacing='0'  cellpadding='0'   >");

				if (sampleno != null && (sampleno.contains("F") || sampleno.contains("A") || sampleno.contains("R")
						|| sampleno.contains("B") || sampleno.contains("P"))) {
					if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
							&& is_sammple_duplicate_print.equals("1"))
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:20px;height: 30px;width:160;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
					else
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:20px;height: 30px;width:160;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno
								+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
								+ i
								+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:160px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image fsound in session\"   width='100%' ></div></td></tr>");
				} else {
					if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
							&& is_sammple_duplicate_print.equals("1"))
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:30px;height: 30px;width:140;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image found in session\"   width='100%' ></div></td></tr>");
					else
						htmlContents.append("<tr><td width='50%'  ><div id='" + i
								+ "diivBarCodeControl'><img style='margin-left:30px;height: 30px;width:140;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno
								+ "\" alt=\"no image found in session\"   width='100%' ></div></td><td width='50%' align='left' ><div id='"
								+ i
								+ "diivBarCodeControlAll'><img style='margin-left:20px;height: 30px;width:140px;margin-top:5' src=\"/HISInvestigationG5/ShowImageOutofAnArray?sampleno="
								+ sampleno + "\" alt=\"no image fsound in session\"   width='100%' ></div></td></tr>");
				}

				if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
						&& is_sammple_duplicate_print.equals("1"))
					htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
							+ "diivBarCodeControl' style='margin-left:80'>" + sampleno + "</div></td></tr>");
				else
					htmlContents.append("<tr><td width='50%'  style='font-size:12px;' ><div id='" + i
							+ "diivBarCodeControl' style='margin-left:80'>" + sampleno
							+ "</div></td><td width='50%' align='left' style='font-size:12px;'><div id='" + i
							+ "diivBarCodeControlAll' style='margin-left:80'>" + sampleno + "</div></td></tr>");

				if (is_sammple_duplicate_print != null && !is_sammple_duplicate_print.equals("")
						&& is_sammple_duplicate_print.equals("1"))
					htmlContents.append(
							"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:9px'><tr><td style='font-size:8px; height='10'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
									+ crno
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
									+ labname
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
									+ reqdate + "/" + colldate
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
									+ patname + "</td></tr> </table></td></tr>");
				else
					htmlContents.append(
							"<tr><td width='50%' height='8' ><table cellspacing='0'  cellpadding='0' style='margin-left:9px'><tr><td style='font-size:8px; height='10'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
									+ crno
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
									+ labname
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
									+ reqdate + "/" + colldate
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
									+ patname
									+ "</td></tr> </table></td><td width='50%' height='8'><table cellspacing='0'  cellpadding='0' ><tr><td height='8' style='font-size:8px;'><b>CR No.</b></td><td height='8' style='font-size:8px;'>"
									+ crno
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Lab Name:</b></td><td height='8' style='font-size:8px;'>"
									+ labname
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Req/Col Date:</b></td><td height='8' style='font-size:8px;'>"
									+ reqdate + "/" + colldate
									+ "</td></tr><tr><td height='8' style='font-size:8px;'><b>Pt:</b></td><td height='8' style='font-size:8px;'>"
									+ patname + "</td></tr> </table></td></tr>");

				htmlContents.append("<input type='hidden' id='barCodeGenSize' value='" + barCodeGenSiString
						+ "' name='barCodeGenSize'/></table>");

			}

		}
		fb.setSaveConfirmFlag("1");
		System.out.println("html Contents" + htmlContents);
		session.setAttribute(InvestigationConfig.UPLOADED_FILE_AS_ARRAY, t);
		session.setAttribute("sampleNoLabelBarCodeString", htmlContents.toString());
		objStatus.add(Status.TRANSINPROCESS);
		WebUTIL.setStatus(request, objStatus);

		fb.setResponseMgs("Barcode generated succefully");

		response.getWriter().write(fb.getResponseMgs());

	}

	/*
	 * public static void insertAlreadyRegPat(NEWOfflineResultEntryFB fb,
	 * HttpServletRequest objRequest_p) {
	 * 
	 * String pdfString = "", strFileName = "", saveFileString = ""; File tempFile =
	 * null; String strSignFileName = "", strSign = ""; String saveFlag = ""; UserVO
	 * uservo = new UserVO(); NEWOfflineResultEntryVO vo = (NEWOfflineResultEntryVO)
	 * TransferObjectFactory
	 * .populateData("new_investigation.vo.InvOfflineResultEntryVO", fb); try {
	 * NEWOfflineResultEntryDATA offlineResEntryData = new
	 * NEWOfflineResultEntryDATA(); String strDate = new
	 * SimpleDateFormat("dd-MMM-yyyyHH-mm-SS").format(new Date());
	 * 
	 * // Save Offline data. System.out.println("nandini2");
	 * offlineResEntryData.insertAlreadyRegPat(vo, uservo);
	 * 
	 * strFileName = vo.getStrPatFileName();// For Result Report card file name.
	 * strSignFileName = NEWOfflineResultEntryDAO.getUserSignFileName(vo); // For
	 * pathologist sign file name. // strSign=
	 * readImageFromLocation(strSignFileName); vo.setStrUserSign(strSign);
	 * 
	 * vo.setStrParentHospitalCode(vo.getStrPatHospCode()); // For query to execute.
	 * Here parent hospcode is not // useful but the collection centre. // Get the
	 * saved data. offlineResEntryData.getOffllineResultEntryPatientData(vo,
	 * uservo); offlineResEntryData.getOffllineResultEntryPatientTestData(vo,
	 * uservo);
	 * 
	 * if (vo.getStrMsgType().equals("1")) { saveFlag = "1"; fb.setStrMsgType("1");
	 * fb.setStrMsgString("Error occurred while saving data. Please try again ! ");
	 * throw new Exception(vo.getStrMsgString()); } else { saveFlag = "2";
	 * fb.setStrMsgType("0"); System.out.println("THE DATA SAVED >>>> CR NO :: " +
	 * vo.getPatCRNo()); fb.setStrMsgString("Data Saved Successfully for Reg. No: "
	 * + vo.getPatCRNo());
	 * 
	 * // Make the Slip pdfString = NEWOfflineResultEntryHLP.printSlipTestWise(vo);
	 * System.out.println("pdfString >>>>>>>>>>>> UTIL for old pats>>> " +
	 * pdfString); String strTempfileName = "temp" + strDate;
	 * System.out.println("strTempfileName1  " + strTempfileName);
	 * 
	 * tempFile = File.createTempFile(strTempfileName, ".pdf");
	 * System.out.println("tempFile2" + tempFile); String strDirector =
	 * tempFile.getParentFile().getAbsolutePath(); String strTempFilePath =
	 * strDirector + File.separator + strTempfileName + ".pdf"; tempFile.delete();
	 * convertHtmlToPDFAndSave(pdfString, strTempfileName, strDirector);
	 * 
	 * System.out.println("strTempFilePath3 " + strTempFilePath);
	 * 
	 * File originalFile = new File(strTempFilePath); String encodedBase64 = null;
	 * try { FileInputStream fileInputStreamReader = new
	 * FileInputStream(originalFile); byte[] bytes = new byte[(int)
	 * originalFile.length()]; fileInputStreamReader.read(bytes); encodedBase64 =
	 * hisglobal.utility.Base64Utils.base64Encode(bytes);
	 * fileInputStreamReader.close(); byte[] bytes2 =
	 * hisglobal.utility.Base64Utils.base64Decode(encodedBase64); File f =
	 * File.createTempFile("signed_Pdf", "pdf"); FileOutputStream fis = new
	 * FileOutputStream(f); fis.write(bytes2); fis.close();
	 * 
	 * FileInputStream fisGlobal = new FileInputStream(f); try { // saveFileString =
	 * saveFileToFTPLocation(strFileName, fisGlobal); saveFlag = "3"; } catch
	 * (Exception e) { saveFlag = "4"; fb.
	 * setStrMsgString("Error occurred while Generating File. Please try again ! ");
	 * throw new Exception(e.getMessage()); }
	 * 
	 * } catch (Exception e) { saveFlag = "4";
	 * fb.setStrMsgString("Error occurred. Please try again ! ");
	 * e.printStackTrace(); } } } catch (Exception e) { e.printStackTrace(); if
	 * (saveFlag == "1")
	 * fb.setStrMsgString("Error occurred while Saving Data. Please Try Again !");
	 * if (saveFlag == "4") fb.setStrMsgString(
	 * "Data Saved but Error occurred while Generating File ! Reg. No. : " +
	 * vo.getPatCRNo()); //
	 * fb.setStrMsgString("InvOfflineResultEntryUTIL.insertOffllineResultEntry() -->
	 * // "+ e.getMessage()); } }
	 */
	public static void getAllPatListResultEntry(NEWOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
		UserVO uservo = new UserVO();
		try {
			NEWOfflineResultEntryVO vo = (NEWOfflineResultEntryVO) TransferObjectFactory
					.populateData("new_investigation.vo.InvOfflineResultEntryVO", fb);

			NEWOfflineResultEntryDATA offlineResEntryData = new NEWOfflineResultEntryDATA();

			// Get the saved data of Patient.
			offlineResEntryData.getOffllineResultEntryPatientCount(vo, uservo);
			// offlineResEntryData.getOffllineResultEntryPatientTestDataForView(vo);
			vo.getPatientListWS().beforeFirst();

			String printOfflineEntryPatData = NEWOfflineResultEntryHLP.getAllPatListResultEntry(vo);

			fb.setStrMultiPatList(printOfflineEntryPatData);
			fb.setStrGoFlag("1");

		} catch (Exception e) {
			e.printStackTrace();
			fb.setStrMsgString("NEWOfflineResultEntryUTL.getAllPatListResultEntry() --> " + e.getMessage());
		}

	}

//

	public static String getInsideYear(String crNo) {

		int insideYear = 1000000;

		// String last6Digits = getLastnCharacters(crNo,6);

		String compareYearWith = crNo.substring(7, 14);

		// System.out.println("for year "+compareYearWith);

		if (Integer.parseInt(compareYearWith) <= 100000) {
			insideYear = 100000;
		}

		else if ((Integer.parseInt(compareYearWith)) > 100000 && (Integer.parseInt(compareYearWith)) <= 200000) {
			insideYear = 200000;
		}

		else if ((Integer.parseInt(compareYearWith)) > 200000 && (Integer.parseInt(compareYearWith)) <= 300000) {
			insideYear = 300000;
		} else if ((Integer.parseInt(compareYearWith)) > 300000 && (Integer.parseInt(compareYearWith)) <= 400000) {
			insideYear = 400000;
		} else if ((Integer.parseInt(compareYearWith)) > 400000 && (Integer.parseInt(compareYearWith)) <= 500000) {
			insideYear = 500000;
		}

		else if ((Integer.parseInt(compareYearWith)) > 500000 && (Integer.parseInt(compareYearWith)) <= 600000) {
			insideYear = 600000;
		}

		else if ((Integer.parseInt(compareYearWith)) > 600000 && (Integer.parseInt(compareYearWith)) <= 700000) {
			insideYear = 700000;
		}

		else if ((Integer.parseInt(compareYearWith)) > 700000 && (Integer.parseInt(compareYearWith)) <= 800000) {
			insideYear = 800000;
		}

		else if ((Integer.parseInt(compareYearWith)) > 800000 && (Integer.parseInt(compareYearWith)) <= 900000) {
			insideYear = 900000;
		}

		else if ((Integer.parseInt(compareYearWith)) > 900000 && (Integer.parseInt(compareYearWith)) <= 1000000) {
			insideYear = 1000000;
		}

		// System.out.println(insideYear);
		return Integer.toString(insideYear);
	}

	public static String getcount(String crNo) {

		int count = 100000;

		String last5Digits = crNo.substring(9, 14);
		int digit = Integer.parseInt(last5Digits);

		if (digit <= 10000) {
			count = 10000;
		}

		else if ((digit) > 10000 && (digit) <= 20000) {
			count = 20000;
		}

		else if ((digit) > 20000 && (digit) <= 30000) {
			count = 30000;
		} else if ((digit) > 30000 && (digit) <= 40000) {
			count = 40000;
		} else if ((digit) > 40000 && (digit) <= 50000) {
			count = 50000;
		}

		else if ((digit) > 50000 && (digit) <= 60000) {
			count = 60000;
		}

		else if ((digit) > 60000 && (digit) <= 70000) {
			count = 70000;
		}

		else if ((digit) > 70000 && (digit) <= 80000) {
			count = 80000;
		}

		else if ((digit) > 80000 && (digit) <= 90000) {
			count = 90000;
		}

		else if ((digit) > 90000 && (digit) <= 99999) {
			count = 100000;
		}

		System.out.println(count);
		return Integer.toString(count);

	}

	private synchronized static void createDirectoryStructure(String ftpserver, String[] folders) {
		JakartaFTPWrapper ftp = null;
		try {
			ftp = new JakartaFTPWrapper();

			// HisAppletConfigurator hisAppletConfigurator=new HisAppletConfigurator();
			// new
			// TemplateProcessingClass(1,"101").readingAppletConfiguratorXML(hisAppletConfigurator);

			/*
			 * String ftpUserName=hisAppletConfigurator.getResultprintingusername(); String
			 * ftpUserPassword=hisAppletConfigurator.getResultprintinguserpassword();
			 */

			String ftpUserName = PropertiesHelper.getFTPConnectionUsername();
			String ftpUserPassword = PropertiesHelper.getFTPConnectionPassword();

			System.out.println("ftpserver>>>>>" + ftpserver);
			System.out.println("Connecting to " + ftpserver + "ftpUserName :" + ftpUserName + " ftpUserPassword :"
					+ ftpUserPassword);
			if (ftp.connectAndLogin(ftpserver, ftpUserName, ftpUserPassword)) {
				System.out.println("Connected to " + ftpserver);
				ftp.setPassiveMode(true);
				ftp.changeWorkingDirectory("ftpserver");
				System.out.println("Present Working Directory :" + ftp.pwd());
				for (int i = 4; i < folders.length; i++) {
					System.out.println("directory " + folders[i] + " created");
					ftp.mkd(folders[i]);
					ftp.changeWorkingDirectory(folders[i]);
				}
			} else {
				System.out.println("Unable to connect to" + ftpserver);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (ftp != null) {
					ftp.logout();
					ftp.disconnect();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// static String propertiesFileName = "in.cdac.mhealth.ftp_config";
	static String propertiesFileName = "pdfFileName";
	static String connectionkey = "FTPConnectionURI";
	static String usernamekey = "ftpUserName";
	static String passwordkey = "ftpUserPassword";
	static String ftpDestPathKey = "ftpDestPath";
//	String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
//	String pdfFileurl= PropertiesHelper.getFTPConnectionURI() +"/"+ vo.getStrParentHospitalCode() +"/"+"20"+ year+"/"+insideyear+"/"+count+"/"+vo.getPatCRNo();

//	private static String FTPConnectionURI =PropertiesHelper.getFTPConnectionURI();
//	private static String ftpUserName =PropertiesHelper.getFTPConnectionUsername();
//	private static String ftpUserPassword = PropertiesHelper.getFTPConnectionPassword();

//	private static String FTPConnectionURI = FTPConfig.FTPConnectionURI;
//	private static String ftpUserName = FTPConfig.ftpUserName;
//	private static String ftpUserPassword = FTPConfig.ftpUserPassword;
//
//	private static String destPath="/opt/ftps/raol_ftp/ftpserver/ftpserver/";
	// private static String
	// destPath=GlobalUtils.getQueryFromPropertiesFile(propertiesFileName,ftpDestPathKey);
	// private static String
	// destPath="/FTPSERVERDATA/punjab/3726001/2012/1000000/10000/";
	private static String destPath = "/FTP/OPDLiteTemplate/nan/";

	/*
	 * public static String writeBase64ToFTP(String patCRNo, String hospitalCode,
	 * String episodeCode, String visitNumber, String pageCount, String crntImage) {
	 * int status = 0; String path = ""; // String base64Image =
	 * crntImage.split(",")[1];
	 * 
	 * String base64Image = crntImage; byte[] imageBytes =
	 * DatatypeConverter.parseBase64Binary(base64Image); //
	 * System.out.println(imageBytes); try {
	 * 
	 * // String patCRNo="331011800015989"; // String hospitalCode="33101"; //
	 * String episodeCode="1011"; // String visitNumber="1";
	 * 
	 * String finalDestPath = destPath + generateFTPPath(patCRNo, hospitalCode) +
	 * "pres/" + episodeCode + "/" + visitNumber + "/"; System.out.println("Path:" +
	 * finalDestPath); path = createFTPDirectoryStructureAndWriteFile(finalDestPath,
	 * patCRNo, episodeCode, visitNumber, pageCount, imageBytes); status = 1; }
	 * catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return path; }
	 */

	/*
	 * private synchronized static String
	 * createFTPDirectoryStructureAndWriteFile(String folder,String patCRNo,String
	 * episodeCode,String visiNumber,String pageCount, byte[] imageBytes) {
	 * FTPClient ftp = null; try {
	 * 
	 * ftp = new FTPClient();
	 * 
	 * ftp.connect(FTPConnectionURI); ftp.login(ftpUserName, ftpUserPassword);
	 * 
	 * System.out.println("Checking to create: "+folder.substring(1,
	 * folder.length())+"*END*");
	 * 
	 * makeDirectories( ftp, folder.substring(1, folder.length()) );
	 * 
	 * 
	 * 
	 * ftp.enterLocalPassiveMode(); ftp.changeWorkingDirectory(folder);
	 * System.out.println("Now at: "+ftp.printWorkingDirectory());
	 * 
	 * ftp.setFileType(FTP.BINARY_FILE_TYPE);
	 * 
	 * Date todaysDate = new Date(); String date= new
	 * SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(todaysDate);
	 * 
	 * String filePath=folder+"P"+pageCount+"_"+date+".png";
	 * 
	 * OutputStream outputStream = ftp.storeFileStream(filePath); //
	 * System.out.println(imageBytes.toString()); outputStream.write(imageBytes);
	 * outputStream.close();
	 * 
	 * boolean completed = ftp.completePendingCommand(); if (completed) {
	 * System.out.println("The file is uploaded successfully."); }
	 * 
	 * return filePath;
	 * 
	 * } catch(Exception e) { e.printStackTrace(); } finally { try { if
	 * (ftp.isConnected()) { ftp.logout(); ftp.disconnect(); } } catch (IOException
	 * ex) { ex.printStackTrace(); }
	 * 
	 * } return "No Path Found";
	 * 
	 * }
	 * 
	 *//**
		 * Creates a nested directory structure on a FTP server
		 * 
		 * @param ftpClient an instance of org.apache.commons.net.ftp.FTPClient class.
		 * @param dirPath   Path of the directory, i.e /projects/java/ftp/demo
		 * @return true if the directory was created successfully, false otherwise
		 * @throws IOException if any error occurred during client-server communication
		 *//*
			 * public static boolean makeDirectories(FTPClient ftpClient, String dirPath)
			 * throws IOException { ftpClient.changeWorkingDirectory("/"); String[]
			 * pathElements = dirPath.split("/"); if (pathElements != null &&
			 * pathElements.length > 0) { for (String singleDir : pathElements) { //
			 * System.out.println("Working for : "+singleDir+"\n Now at: "+ftpClient.
			 * printWorkingDirectory()); boolean existed =
			 * ftpClient.changeWorkingDirectory(singleDir); if (!existed) { boolean created
			 * = ftpClient.makeDirectory(singleDir); if (created) {
			 * System.out.println("CREATED directory: " + singleDir);
			 * ftpClient.changeWorkingDirectory(singleDir); showServerReply(ftpClient); }
			 * else { System.out.println("COULD NOT create directory: " + singleDir);
			 * showServerReply(ftpClient); return false; } } } } return true; }
			 */

	/**
	 * This function returns the path on FTP where file is to be saved
	 * 
	 * @param patCRNo
	 * @param hospitalCode
	 * @return
	 */
	/*
	 * public static String generateFTPPath(String patCRNo, String hospitalCode) {
	 * String crNo = patCRNo; // System.out.println(crNo.substring(5,7)); String
	 * year = crNo.substring(5, 7);
	 * 
	 * String insideyear = PGDataHelper.getInsideYear(crNo); String count =
	 * PGDataHelper.getcount(crNo);
	 * 
	 * return hospitalCode + "/" + "20" + year + "/" + insideyear + "/" + count +
	 * "/" + patCRNo + "/"; }
	 */

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}

	public static void pdfGeneration(HttpServletRequest request, HttpServletResponse response) {

		String serverName = "adminftp:admin123D$@10.226.80.125";
		int port = 21;
		String username = "adminftp";
		String password = "admin123D$";

		ByteArrayOutputStream baosPDF = null;
		ServletOutputStream os = null;

		try {
			/*
			 * FTPClient ftpclient = new FTPClient(); ftpclient.connect(serverName,port);
			 * ftpclient.login(username, password);
			 */
			String html = "<p>This is test</p>";

//			ByteArrayOutputStream bytes = HTMLToPDFUTIL.convertHtmlToPDFDirect(request, html);
//		    response.getWriter().write(bytes);

			baosPDF = HTMLToPDFUTIL.convertHtmlToPDFDirect(request, html);
			response.setContentType("application/pdf");
			os = response.getOutputStream();
			os.flush();
			baosPDF.writeTo(os);

			// convert it to pdf
			// save it on ftp with name test.pdf

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void initPatientListing(HttpServletRequest request, NEWOfflineResultEntryFB fb) {
		NEWOfflineResultEntryServiceDAO objNEWOfflineResultEntryServiceDAO = new NEWOfflineResultEntryServiceDAO();
		UserVO uservo = ControllerUTIL.getUserVO(request);
		List<Entry> lstDepartmentUnitList = objNEWOfflineResultEntryServiceDAO.getDepartmentUnitList(uservo);
		String currentDate = objNEWOfflineResultEntryServiceDAO.getCurrentDate();
		// System.out.println("currentDate===" + currentDate);
		fb.setFromDate(currentDate);
		fb.setToDate(currentDate);

		WebUTIL.getSession(request).setAttribute("LSTDEPARTMENTUNITLIST", lstDepartmentUnitList);
	}

	public static void getPatientListPageData(HttpServletRequest request, HttpServletResponse response,
			NEWOfflineResultEntryFB fb) {
		NEWOfflineResultEntryServiceDAO objNEWOfflineResultEntryServiceDAO = new NEWOfflineResultEntryServiceDAO();
		String res = "{}";
		
		UserVO uservo = ControllerUTIL.getUserVO(request);
		System.out.println("fhospcode"+uservo.getHospitalCode());
		org.json.JSONObject objFilter = new org.json.JSONObject();

		try {
			objFilter.put("seatId", uservo.getSeatId());
			objFilter.put("hospitalCode", uservo.getHospitalCode());	
			
			objFilter.put("fromDate", fb.getFromDate());
			objFilter.put("toDate", fb.getToDate());
			objFilter.put("patDeptUnitCode",
					fb.getPatDeptUnitCode().equals("ALL") ? "ALL" : fb.getPatDeptUnitCode().split("#")[1]);

			res = objNEWOfflineResultEntryServiceDAO.getPatientListPageData(objFilter);
			System.out.println("res"+res);
			HelperMethods.writeInResponse(response, res, true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getEpisodeListData(HttpServletRequest request, HttpServletResponse response,
			NEWOfflineResultEntryFB fb) {
		NEWOfflineResultEntryServiceDAO objNEWOfflineResultEntryServiceDAO = new NEWOfflineResultEntryServiceDAO();
		String res = "{}";
		UserVO uservo = ControllerUTIL.getUserVO(request);
		org.json.JSONObject objFilter = new org.json.JSONObject();

		try {
			objFilter.put("seatId", uservo.getSeatId());
			objFilter.put("hospitalCode", uservo.getHospitalCode());
			//objFilter.put("patCrNO", fb.getPatCrNo()); 
			objFilter.put("patCrNO", fb.getCrNoInput()); 
			
			
		
	
			if (fb.getPatEpisodeCode() != null && !fb.getPatEpisodeCode().isEmpty()) {
				objFilter.put("episodeCode", fb.getPatEpisodeCode());
				objFilter.put("visitNo", fb.getPatVisitNo());
			}

			res = objNEWOfflineResultEntryServiceDAO.getEpisodeListData(objFilter);
			HelperMethods.writeInResponse(response, res, true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void pouplateEpisodeTestDtl(HttpServletRequest objRequest_p, HttpServletResponse objresponse_p,
			NEWOfflineResultEntryFB fb) {
		NEWOfflineResultEntryServiceDAO objNEWOfflineResultEntryServiceDAO = new NEWOfflineResultEntryServiceDAO();
		String res = "{}";
		UserVO uservo = ControllerUTIL.getUserVO(objRequest_p);
		org.json.JSONObject objFilter = new org.json.JSONObject();

		try {
			 //getPatCRNo
			objFilter.put("hospitalCode", uservo.getHospitalCode());
			System.out.println("hospitalCode>>"+uservo.getHospitalCode());
			objFilter.put("patCrNO", fb.getPatCRNo());
			System.out.println("PatCrNO>>"+fb.getPatCRNo());
			if (fb.getPatEpisodeCode() != null && !fb.getPatEpisodeCode().isEmpty()) {
				objFilter.put("episodeCode", fb.getPatEpisodeCode());
				System.out.println("episodeCode>>>"+fb.getPatEpisodeCode());
				objFilter.put("visitNo", fb.getPatVisitNo());
				System.out.println("fb.getPatVisitNo()>>>>"+fb.getPatVisitNo());
			}

			res = objNEWOfflineResultEntryServiceDAO.EpisodeTestDtl(objFilter);
			HelperMethods.writeInResponse(objresponse_p, res, true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	 
	 
	 
	 public static void view_Lab_Report(HttpServletRequest request, HttpServletResponse response,	NEWOfflineResultEntryFB fb) {
		String res="0";
	//	NEWOfflineResultEntryBO bo=new NEWOfflineResultEntryBO();
		JSONObject objJSONObject=new JSONObject(); 
		String resultjson="[]";
		PrintWriter out =null;
		URLConnection url = null;
		String sys="";
		
		InputStream io = null;
		OutputStream stream=null;
		try {
			UserVO uservo=ControllerUTIL.getUserVO(request);
	
			response.setContentType("plain/text");
			
			
			
			String serviceurl = "http://" + HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_IP") + ":" + HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_APPPORT");  
			String username = "";
			String password = "";
			String fileId = request.getParameter("fileName");;
			String[] strTemp = fileId.replace(".", "#").split("#");
			String strExt = strTemp[strTemp.length - 1];
			
			
			fileId = fileId.replace("/", "_");
				
			
			
			System.out.println("fileId"+fileId);
			
			
			if(serviceurl.contains("https")){
				String uri =serviceurl +"/HISInvestigationG5/services/restful/InvestigationWebService/getOffileResultEntryReport/"+ fileId;
				//System.out.println("https uri--"+ uri);
				WsHttpsClient objWsHttpsClient= new WsHttpsClient();
				resultjson=objWsHttpsClient.get(uri,  username,  password);
				System.out.println("resultjson-------------->"+resultjson.toString());
		
			}
			else{
				String uri =serviceurl +"/HISInvestigationG5/services/restful/InvestigationWebService/getOffileResultEntryReport/"+ fileId;
				WsHttpClient objWsHttpClient= new WsHttpClient();
		
				resultjson=objWsHttpClient.get(uri,  username,  password);
				
				System.out.println("resultjsonsefs-------------->"+resultjson);
				System.out.println("resultjson-------------->"+resultjson.toString());
				//resultjson=(Base64Utils.decode(resultjson));
				byte[] pdfBytes = Base64.getDecoder().decode(resultjson);
				
				System.out.println("resultjson2-------------->"+pdfBytes);

				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "attachment;filename="+fileId+"");

				OutputStream out4 = response.getOutputStream();
				out4.write(pdfBytes);

				out4.flush();
				out4.close();
				
				
		}}
		
		catch(Exception e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//				out = response.getWriter();
//				out.write(resultjson);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}	
	}
	


	
	 public static void getOfflineLabTestData(HttpServletRequest request, HttpServletResponse response,        NEWOfflineResultEntryFB fb) {
         String res="0";
 //        NEWOfflineResultEntryBO bo=new NEWOfflineResultEntryBO();
         JSONObject objJSONObject=new JSONObject(); 
         String resultjson="[]";
         PrintWriter out =null;
         try {
                 UserVO uservo=ControllerUTIL.getUserVO(request);
         
                
                 objJSONObject.put("patCrno",fb.getCrNoSelected());
                 objJSONObject.put("patEpisodeCode",fb.getEpisodeCode());
                 objJSONObject.put("patEpisodeVisitNo",fb.getPatEpisodeVisitNo());
                 objJSONObject.put("hospitalCode",uservo.getHospitalCode());
                 
                 System.out.println("crNoSelected>>"+fb.getCrNoSelected());
                 System.out.println("episodeCode>>"+fb.getEpisodeCode());
                 System.out.println("patEpisodeVisitNo>>"+fb.getPatEpisodeVisitNo());
                 System.out.println("hospitalCode>>"+uservo.getHospitalCode());
                 
                 
//     objJSONObject.put("patCrno","100012300001748");
//          objJSONObject.put("patEpisodeCode","23511001");
//           objJSONObject.put("patEpisodeVisitNo","1");
//           objJSONObject.put("hospitalCode","2010001");
                 
                  
                 
                 response.setContentType("text/json");
                 
                 
                 
                 String serviceurl = "http://" + HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_IP") + ":" + HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_APPPORT");  
                 
                 String username = "";
                 String password = "";
                 
                 
                 
                 if(serviceurl.contains("https")){
                         String uri =serviceurl +"/HISInvestigationG5/services/restful/InvestigationWebService/getOfflineLabTestData";
                         //System.out.println("https uri--"+ uri);
                         WsHttpsClient objWsHttpsClient= new WsHttpsClient();
         
                         resultjson=objWsHttpsClient.postAndGetInJson(uri,objJSONObject.toString(), username, password);
         
                 }
                 else{
                         String uri =serviceurl +"/HISInvestigationG5/services/restful/InvestigationWebService/getOfflineLabTestData";
                         WsHttpClient objWsHttpClient= new WsHttpClient();
         
                         resultjson=objWsHttpClient.postAndGetInJson(uri, objJSONObject.toString(), username, password);
                         System.out.println("resultjson->->-:"+resultjson.toString());
                 }
                                 
         }catch(Exception e) {
                 e.printStackTrace();
         }
         finally {
                 try {
                         out = response.getWriter();
                         out.write(resultjson);
                 } catch (IOException e) {
                         // TODO Auto-generated catch block
                         e.printStackTrace();
                 }
                 
         }        
 }

	
	
	

}
