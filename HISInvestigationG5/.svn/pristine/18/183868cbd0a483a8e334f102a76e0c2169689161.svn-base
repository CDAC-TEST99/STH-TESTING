package new_investigation.transactions.controller.utl;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;     
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;                                                            
import java.io.InputStream;
import java.io.OutputStream;      
import java.io.StringBufferInputStream;            
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;                                                
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.jboss.security.Base64Encoder;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.hisconfig.Config;                                 
import hisglobal.presentation.ControllerUTIL;
import hisglobal.presentation.Status;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.HisUtil;
import hisglobal.vo.UserVO;
import new_investigation.InvestigationConfig;
import new_investigation.transactions.controller.Helper.InvOfflineResultEntryHLP;
import new_investigation.transactions.controller.data.InvOfflineResultEntryDATA;
import new_investigation.transactions.controller.fb.InvOfflineResultEntryFB;
import new_investigation.transactions.dao.InvOfflineResultEntryDAO;
import new_investigation.vo.InvOfflineResultEntryVO;
import new_investigation.vo.NEWOfflineResultEntryVO;

public class InvOfflineResultEntryUTIL extends ControllerUTIL
{
	public static void getEssential(InvOfflineResultEntryFB fb,HttpServletRequest request) throws IOException
	{
		Status objStatus= new Status();
		UserVO userVO = ControllerUTIL.getUserVO(request);
		InvOfflineResultEntryVO invresultentryvo=new InvOfflineResultEntryVO();
		String strResultDtl="";
		try{
			ControllerUTIL.setSysdate(request);
			Date dt= (Date)request.getSession().getAttribute(Config.SYSDATEOBJECT); 
			WebUTIL.getSession(request).setAttribute(InvestigationConfig.SYSDATEOBJECT,dt);			
			System.out.println("before test1");
			InvOfflineResultEntryDATA data = new InvOfflineResultEntryDATA();
			data.getOfflineTestDetail(invresultentryvo,userVO);
			System.out.println("before init123");
			strResultDtl = InvOfflineResultEntryHLP.getOfflineResultEntryDtls(invresultentryvo, request);
			String tDate = WebUTIL.getCustomisedSysDate((Date)request.getSession().getAttribute(Config.SYSDATEOBJECT), "dd-MMM-yyyy");
			System.out.println("tDate "+tDate);
			fb.setLabCode("%");
			fb.setStrResultDtl(strResultDtl);
			objStatus.add(Status.TRANSINPROCESS);
			
			//Getting the List of hospitals in the hierarchy. 18.01.2021 Deepti
			invresultentryvo.setStrParentHospitalCode(fb.getStrParentHospitalCode());
			data.getHospitalList(invresultentryvo);
			String strHospitalList = "";
			HisUtil hisutil = new HisUtil("Offline Result Entry", "InvOfflineResultEntryFB");
			
			if (invresultentryvo.getStrMsgType().equals("1")) {
				throw new Exception(invresultentryvo.getStrMsgString());
			}
	 		if (invresultentryvo.getStrHospitalListWS() != null && invresultentryvo.getStrHospitalListWS().size() > 0) {
						 
				strHospitalList = hisutil.getOptionValue(invresultentryvo.getStrHospitalListWS(),"", "0^Select Value", false);
			}
			
			else {
				strHospitalList = "<option value='0'>Select Value</option>";
			
			}
			fb.setStrHospitalList(strHospitalList);

		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			objStatus.add(Status.UNSUCESSFULL,"","Data Not Found");
		}
		
	}
	
	
	/**
	 * AJAX Response : populating Test Combo based on labCode using AJAX
	 * @param objFB_p
	 * @param objRequest_p
	 */
	public static StringBuffer pouplateTestDetails(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p,HttpServletResponse response)
	{
		StringBuffer sbAjaxRes = new StringBuffer();
		HttpSession session=objRequest_p.getSession();
		String strMsgText = "";
		String  strTestCombo="";
		Map mp=new HashMap();
		String strResultDtl="";
		
		try
		{
			UserVO userVO=ControllerUTIL.getUserVO(objRequest_p);
			InvOfflineResultEntryVO invresultentryvo=new InvOfflineResultEntryVO();
			InvOfflineResultEntryDATA data = new InvOfflineResultEntryDATA();
			data.getOfflineTestDetail(invresultentryvo,userVO);
			//System.out.println("before init123");
			strResultDtl = InvOfflineResultEntryHLP.getOfflineResultEntryDtls(invresultentryvo, objRequest_p);
			//System.out.println("strResultDtl "+strResultDtl);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strResultDtl);
			
		}
		catch (Exception e)
		{
			strMsgText = "SampleCollectionUTIL.checkSampleNoDuplicacy() -> " + e.getMessage();
			new HisException(strMsgText);
		}
		finally
		{
		}
		return sbAjaxRes;
	}

public static void insertOffllineResultEntry(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
	System.out.println("nandu----");
		
	InvOfflineResultEntryVO vo=(InvOfflineResultEntryVO) TransferObjectFactory.populateData("new_investigation.vo.InvOfflineResultEntryVO", fb);
	
	String pdfString="",strFileName="",saveFileString="";
		File tempFile = null;
		String strSignFileName="",strSign="";

		String saveFlag="";
		try
		{
			
			
			InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
			String strDate = new SimpleDateFormat("dd-MMM-yyyyHH-mm-SS").format(new Date());
			
			//Save Offline data.
			offlineResEntryData.insertOffllineResultEntry(vo);
		
			strFileName = vo.getStrPatFileName();  // For Result Report card file name.
		//	strSignFileName = InvOfflineResultEntryDAO.getUserSignFileName(vo);; //For pathologist sign file name.
		//	strSign= readImageFromLocation(strSignFileName);
			vo.setStrUserSign(strSign);  
			
			//Get the saved data.
			offlineResEntryData.getOffllineResultEntryPatientData(vo);
			offlineResEntryData.getOffllineResultEntryPatientTestData(vo);
			
				if(vo.getStrMsgType().equals("1"))
				{
					saveFlag="1";
					fb.setStrMsgType("1");
					fb.setStrMsgString("Error occurred while saving data. Please try again ! ");
					throw new Exception(vo.getStrMsgString());
				}
				else {
						saveFlag="2";
						fb.setStrMsgType("0");
						System.out.println("Data Saved Successfully for the CR No. : "+vo.getPatCRNo());
						fb.setStrMsgString("Data Saved Successfully for the Reg. No. : "+vo.getPatCRNo());
						
						// Make the Slip
						
						pdfString = InvOfflineResultEntryHLP.printSlipTestWise(vo);
						
						System.out.println("UTIL >>>> SAVE >>>> the PDF > for new pat>> > "+pdfString);
						
						String strTempfileName = "temp" + strDate;
						tempFile = File.createTempFile(strTempfileName, ".pdf");
						String strDirector = tempFile.getParentFile().getAbsolutePath();
						String strTempFilePath = strDirector + File.separator + strTempfileName + ".pdf";
						tempFile.delete();
						convertHtmlToPDFAndSave(pdfString, strTempfileName, strDirector);
						
						File originalFile = new File(strTempFilePath);
					    String encodedBase64 = null;
					    try {
					        FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
					        byte[] bytes = new byte[(int) originalFile.length()];			        
					        fileInputStreamReader.read(bytes);
					        encodedBase64 = hisglobal.utility.Base64Utils.base64Encode(bytes);
					        fileInputStreamReader.close();
					        byte[] bytes2 = hisglobal.utility.Base64Utils.base64Decode(encodedBase64);
					        File f = File.createTempFile("signed_Pdf", "pdf");
							FileOutputStream fis = new FileOutputStream(f);
							fis.write(bytes2);
							fis.close();
							
							FileInputStream fisGlobal = new FileInputStream(f);
							try {
						//		saveFileString = saveFileToFTPLocation(strFileName, fisGlobal);
								saveFlag="3";
							} catch (Exception e) {	
								saveFlag="4";
								fb.setStrMsgString("Error occurred while Generating File. Please try again! Reg. No.: "+vo.getPatCRNo());
								//throw new Exception(e.getMessage());
							}
					        
					    } catch (Exception e) {
					    	saveFlag="4";
					    	fb.setStrMsgString("Error occurred while Generating File. Please try again! Reg. No.: "+vo.getPatCRNo());
					        e.printStackTrace();
					    }
				}
	 }
		catch(Exception e)
		{
			e.printStackTrace();
			if(saveFlag=="1")
				fb.setStrMsgString("Error occurred while Saving Data. Please Try Again !");	
			if(saveFlag=="4")
				fb.setStrMsgString("Data Saved but Error occurred while Generating File ! Reg. No: "+vo.getPatCRNo());	
			//fb.setStrMsgString("InvOfflineResultEntryUTIL.insertOffllineResultEntry() --> "+ e.getMessage());
		}
}

public synchronized static String saveFileToFTP(String strHospCode, String strFileName, InputStream inputStream ) throws Exception {

	String strReturnString = "";
	OutputStream out1 = null;
	FTPClient ftp = null;

	try {

		// String fileName=
		// String fileName = "logo_"+System.currentTimeMillis();

		ftp = new FTPClient();

		System.out.println(
				"ftp connecting to " + HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
		System.out.println("with credentials : " + HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME")
				+ " & " + HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));

		ftp.connect(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
		ftp.login(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME"),
				HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
		ftp.setFileType(FTP.BINARY_FILE_TYPE);

		/*
		 * String crNo = vo.getPatCRNo(); String year = crNo.substring(5, 7); String
		 * insideyear = getInsideYear(crNo); String count = getcount(crNo); String
		 * Ftpurl="/"+"punjab"+"/"+ vo.getStrParentHospitalCode() +"/"+"20"+
		 * year+"/"+insideyear+"/"+count+"/"+vo.getPatCRNo();
		 * System.out.println("pdffile1 >>" +"/punjab/"+strFileName);
		 */

		out1 = ftp.storeFileStream("/var/ftp/dev_mso_ftp/OPDLiteTemplate/" + strFileName);
		System.out.println("pdffile1 >> " + "/var/ftp/dev_mso_ftp/OPDLiteTemplate/" + strFileName);
	

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
	
	public synchronized static String saveFileToFTPLocation(String FileName, InputStream inputStream) throws Exception {
		BufferedOutputStream bos = null;
		
		String strFtpurl = "";
		String strReturnString = "";
		URL urlftp = null;
		URLConnection urlc = null;
		try {
							
				strFtpurl= getFTPDtl();
				
				urlftp = new URL(strFtpurl + "/" + FileName);
				urlc = urlftp.openConnection();
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
	
	public static void convertHtmlToPDFAndSave(String _htmlCode,String fileName,String strFilePath)
	{
		
		 OutputStream os = null;				
		  try 
		  {
			    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			    
			    /* _htmlCode = _htmlCode.replaceAll("& lt;", "<").replaceAll("& gt;", ">");
	            _htmlCode = _htmlCode.replaceAll("& #40;", "\\(").replaceAll("& #41;", "\\)");*/
	            
	            Document doc = builder.parse(new StringBufferInputStream(_htmlCode)); 
	            ITextRenderer renderer = new ITextRenderer();
	            renderer.setDocument(doc, null);
	            renderer.layout();
	            final FileOutputStream fileOutputStream =new FileOutputStream(new File(strFilePath+"/"+fileName+".pdf"));
	            renderer.createPDF(fileOutputStream);
	            fileOutputStream.close();
	            
	        } 
		    catch (Exception ex) 
		    {
	            ex.printStackTrace();
	        }
	        finally 
	        {
				// close the streams using close method
				try 
				{
					if (os != null) 
					{
						os.close();
					}
				}
				catch (Exception ioe) 
				{
					System.out.println("Error while closing stream: " + ioe);
				}

			}
		
		 
	}

	public static void viewResultEntriesList(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
		
		try {
			
			InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
			InvOfflineResultEntryVO vo= new InvOfflineResultEntryVO();
			
			vo.setHospitalcode(fb.getHospitalcode());
			vo.setStrFromDate(fb.getStrFromDate());
			vo.setStrToDate(fb.getStrToDate());
			vo.setStrParentHospitalCode(fb.getHospitalcode());
			
			offlineResEntryData.viewResultEntriesList(vo);
			
			//Get the Hospital Combo in  the view page.
			offlineResEntryData.getHospitalList(vo); 
			
			String offlineResultEntryList = InvOfflineResultEntryHLP.viewResultEntriesList(vo);
			
			fb.setStrResEntryList(offlineResultEntryList);
			fb.setStrFromDate(vo.getStrFromDate());
			fb.setStrToDate(vo.getStrToDate());
			fb.setStrGoFlag("0");
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
public static void viewResultEntriesListForReportView(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
		
		try {
			
			InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
			InvOfflineResultEntryVO vo= new InvOfflineResultEntryVO();
			
			vo.setHospitalcode(fb.getHospitalcode());
			vo.setStrFromDate(fb.getStrFromDate());
			vo.setStrToDate(fb.getStrToDate());
			vo.setPatCRNo(fb.getPatCRNo());
			offlineResEntryData.viewResultEntriesListForReportView(vo);
			
			String offlineResultEntryList = InvOfflineResultEntryHLP.viewResultEntriesListForReportView(vo);
			
			fb.setStrResEntryList(offlineResultEntryList);
			fb.setStrGoFlag("0");
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	public static void showPatientDetail(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
		
		try
		{
			InvOfflineResultEntryVO vo=(InvOfflineResultEntryVO) TransferObjectFactory.populateData("new_investigation.vo.InvOfflineResultEntryVO", fb);
			
			InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
			
			//Get the saved data of Patient.
			offlineResEntryData.getOffllineResultEntryPatientDataForViewPg(vo);
			offlineResEntryData.getOffllineResultEntryPatientTestDataForViewPg(vo);
			vo.getStrPatientDtlWS().beforeFirst();
			
			String printOfflineEntryPatData = InvOfflineResultEntryHLP.getPatOfflineResDtl(vo);
			fb.setStrOfflineResEntPatDtl(printOfflineEntryPatData);
			fb.setStrGoFlag("1");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fb.setStrMsgString("InvOfflineResultEntryUTIL.insertOffllineResultEntry() --> "+ e.getMessage());
		}
		
	}
	
	public static void getRegisteredPatientDtl(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
		
		try
		{
			InvOfflineResultEntryVO vo=(InvOfflineResultEntryVO) TransferObjectFactory.populateData("new_investigation.vo.InvOfflineResultEntryVO", fb);
			
			InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
			WebRowSet ws = null;
			//Get the saved data of Patient.
			offlineResEntryData.getOffllineResultEntryPatientDataForView(vo);
			
			if(!vo.getStrMsgType().equalsIgnoreCase("1") || !vo.getStrMsgType().equalsIgnoreCase("2")) {
				vo.getStrPatientDtlWS().beforeFirst();
				ws= vo.getStrPatientDtlWS();
			
			//Arrange result set into String to put into the Ajax Response.
			String alreadyRegOfflineEntryPatData = "";
			while(ws.next())
			{
				alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+(ws.getString(1).trim()); // Append Name
				
				if(ws.getString(2).equalsIgnoreCase("Male")) //Append Gender
					alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+","+"M";
				else if(ws.getString(2).equalsIgnoreCase("Female")) 
					alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+","+"F";
				else
					alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+","+"T";
				
				alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+","+(ws.getString(3).trim()); // Append Age.
				
				if(ws.getString(4).contains("Day")) //Append Age Unit.
				{
					alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+","+"D";
					fb.setStrPatAgeUnit("D");
				}
				else if(ws.getString(4).contains("Month")) {
					alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+","+"M";
					fb.setStrPatAgeUnit("M");
				}	
				else if(ws.getString(4).contains("Weeks")) {
					alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+","+"W";
					fb.setStrPatAgeUnit("W");
				}	
				else {
					alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+","+"Y";
					fb.setStrPatAgeUnit("Y");
				}
				
				//Append Father/Spouse Name, Mobile number, Address, CR No., Sample Date
				alreadyRegOfflineEntryPatData = alreadyRegOfflineEntryPatData+","+ws.getString(11).trim()+","+ws.getString(6).trim()+","+ws.getString(5).trim()+","+ws.getString(12).trim()+","+ws.getString(9).trim();
				
				fb.setStrOfflineResEntPatDtl(alreadyRegOfflineEntryPatData);
				
				//System.out.println(" in UTIL >> the fb pat string >> "+alreadyRegOfflineEntryPatData);
			 }
		}
		else
			{
				fb.setStrMsgType("1");
				fb.setStrMsgString(vo.getStrMsgString());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fb.setStrMsgString("InvOfflineResultEntryUTIL.getRegisteredPatientDtl() --> "+ e.getMessage());
		}
		
	}
	
	public static void DownloadFile(InvOfflineResultEntryFB formBean, HttpServletRequest request,
			HttpServletResponse response) {
		
			String strmsgText = null;		 
			File f = null;
			FileInputStream fis = null;
			FileOutputStream fos = null;		 
			try {
				
				System.out.println("hospitalcode"+formBean.getStrParentHospitalCode());
				System.out.println("uploadfieldid"+formBean.getStrUploadFileId());

				downloadFileFromFTP(formBean.getStrParentHospitalCode(),formBean.getStrUploadFileId(), response);
			} 	
			catch (Exception e) {
				e.printStackTrace();
				strmsgText = "Drug Inventory.SupplierDeskInterfaceTransDATA.DownloadFile(vo) --> "+ e.getMessage();
				HisException eObj = new HisException("mms","SupplierDeskInterfaceTransDATA->DownloadFile()", strmsgText);
				formBean.setStrMsgString("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
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

public static void downloadFileFromFTP( String hospitalCode ,  String strFileName ,  HttpServletResponse response_p)
		throws Exception  {
	 
	InputStream io = null;
	 FTPClient ftp = null;
	try {
		
		System.out.println("strFileName"+strFileName);
		
		String[] strTemp = strFileName.replace(".", "#").split("#");
		String strExt = strTemp[strTemp.length - 1];

		if (strExt.equalsIgnoreCase("txt")
				|| strExt.equalsIgnoreCase("txt")) {

			response_p.setContentType("application/txt");
			response_p.setHeader("Content-disposition", " filename=" + strFileName);

		} else if (strExt.equalsIgnoreCase("pdf")) {

			response_p.setContentType("application/pdf");
			response_p.setHeader("Content-disposition",	"attachment; filename="+ strFileName);

		} 
		
		else if (strExt.equalsIgnoreCase("jpeg")
				|| strExt.equalsIgnoreCase("jpg")) {

			response_p.setContentType("image/jpg");
			response_p.setHeader("Content-disposition",	"attachment; filename=" + strFileName);

		} 
		
		else if (strExt.equalsIgnoreCase("html")
				|| strExt.equalsIgnoreCase("htm")) {

			response_p.setContentType("text/html;charset=utf-8");
			response_p.setHeader("Content-disposition",	"attachment; filename="	+ strFileName);

		} else if (strExt.equalsIgnoreCase("xlsx")
				|| strExt.equalsIgnoreCase("xlsx")) {

			response_p.setContentType("application/xlsx");
			response_p.setHeader("Content-disposition", "attachment; filename="+ strFileName);

		} else if (strExt.equalsIgnoreCase("xml")) {

			response_p.setContentType("application/xml");
			response_p.setHeader("Content-disposition",	"attachment; filename=" + strFileName);

		} else if (strExt.equalsIgnoreCase("doc")
				|| strExt.equalsIgnoreCase("docx")) {

			response_p.setContentType("application/msword");
			response_p.setHeader("Content-disposition",	"attachment; filename="+ strFileName);

		} else if (strExt.equalsIgnoreCase("rdf")) {
			response_p.setContentType("application/msword");
			response_p.setHeader("Content-disposition",	"attachment; filename="+ strFileName);

		} else if (strExt.equalsIgnoreCase("rtf")) {

			response_p.setContentType("application/msword");
			response_p.setHeader("Content-disposition",	"attachment; filename="+ strFileName);

		} else {

			response_p.setContentType("text/html;charset=utf-8");
			response_p.setHeader("Content-disposition","attachment; filename="+ strFileName);

		}

		
		  ftp = new FTPClient();  
		  
	 	  System.out.println("ftp connecting to "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
	     System.out.println("with credentials : "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME")+" & "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
		  
		  ftp.connect(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
           ftp.login(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME"), HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
           ftp.setFileType(FTP.BINARY_FILE_TYPE);
		
		 
         //  System.out.println("download file name >>>>>>>>>>> "+"/FTP/OPDLiteTemplate/2010019/"+strFileName);
           
        //   905040807_10_2024_17_08_58.pdf
      //     905040807_10_2024_17_08_58.pdf
		/// io = ftp.retrieveFileStream("/FTP/"+strFileName);
           
           
           
       
		 

          String filename= HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FILEPATH")+strFileName;
           
          
           System.out.println("download file name >>>>>>>>>>> "+strFileName);
         
         
           
           
          // String  filename= strFileName.replace("/", "_");
           System.out.println("filename"+filename);
           
           
      	 io = ftp.retrieveFileStream(filename);
    	 
 		byte[] buf = new byte[4096];
 		int read = 0;
 		
 		while ((read = io.read(buf)) > 0) 
 			response_p.getOutputStream().write(buf, 0, read);	

	} catch (Exception e) {
		throw e;
	} finally {

		if(io != null){
			io.close();
			io = null;
		}
		 
        
		if(ftp !=null) {
			  ftp.logout();
			  ftp = null;
		}
		
		 
	}
}

//Method to get the FTP details dynamically - 22.02.2021 Deepti.
private static String getFTPDtl() {
	
	String ftpUrl= InvOfflineResultEntryDAO.getFTPDtl();
	return ftpUrl;
}

private static String getFTPDtlSignFile() {
	
	String ftpUrl= InvOfflineResultEntryDAO.getFTPDtlSignFile();
	//String ftpUrl= HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
	return ftpUrl;
}

public static void insertAlreadyRegPat(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
	
	String pdfString="",strFileName="",saveFileString="";
	File tempFile = null; 
	String strSignFileName="", strSign="";
	String saveFlag="";
	InvOfflineResultEntryVO vo=(InvOfflineResultEntryVO) TransferObjectFactory.populateData("new_investigation.vo.InvOfflineResultEntryVO", fb);
	try
	{
		InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
		String strDate = new SimpleDateFormat("dd-MMM-yyyyHH-mm-SS").format(new Date());
		
		//Save Offline data.
		offlineResEntryData.insertAlreadyRegPat(vo);
		
		strFileName = vo.getStrPatFileName();// For Result Report card file name.
		strSignFileName = InvOfflineResultEntryDAO.getUserSignFileName(vo); //For pathologist sign file name.
		//strSign= readImageFromLocation(strSignFileName);
	//	vo.setStrUserSign(strSign);
		
		vo.setStrParentHospitalCode(vo.getStrPatHospCode()); // For query to execute. Here parent hospcode is not useful but the collection centre.
		//Get the saved data.
		offlineResEntryData.getOffllineResultEntryPatientData(vo);
		offlineResEntryData.getOffllineResultEntryPatientTestData(vo);
		
			if(vo.getStrMsgType().equals("1"))
			{	
				saveFlag="1";
				fb.setStrMsgType("1");
				fb.setStrMsgString("Error occurred while saving data. Please try again ! ");
				throw new Exception(vo.getStrMsgString());
			}
			else {
					saveFlag="2";
					fb.setStrMsgType("0");
					System.out.println("THE DATA SAVED >>>> CR NO :: "+vo.getPatCRNo());
					fb.setStrMsgString("Data Saved Successfully for Reg. No: "+vo.getPatCRNo());
					
					// Make the Slip
					pdfString = InvOfflineResultEntryHLP.printSlipTestWise(vo);
					System.out.println("pdfString >>>>>>>>>>>> UTIL for old pats>>> "+pdfString);
					String strTempfileName = "temp" + strDate;
					tempFile = File.createTempFile(strTempfileName, ".pdf");
					String strDirector = tempFile.getParentFile().getAbsolutePath();
					String strTempFilePath = strDirector + File.separator + strTempfileName + ".pdf";
					tempFile.delete();
					convertHtmlToPDFAndSave(pdfString, strTempfileName, strDirector);
					
					//System.out.println("strTempFilePath "+strTempFilePath);
					
					File originalFile = new File(strTempFilePath);
				    String encodedBase64 = null;
				    try {
				        FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
				        byte[] bytes = new byte[(int) originalFile.length()];			        
				        fileInputStreamReader.read(bytes);
				        encodedBase64 = hisglobal.utility.Base64Utils.base64Encode(bytes);
				        fileInputStreamReader.close();
				        byte[] bytes2 = hisglobal.utility.Base64Utils.base64Decode(encodedBase64);
				        File f = File.createTempFile("signed_Pdf", "pdf");
						FileOutputStream fis = new FileOutputStream(f);
						fis.write(bytes2);
						fis.close();
						
						FileInputStream fisGlobal = new FileInputStream(f);
						try {
							saveFileString =  saveFileToFTP(vo.getStrPatHospCode() , strFileName , fisGlobal);   // saveFileToFTPLocation(strFileName, fisGlobal);
							saveFlag="3";
						} catch (Exception e) {	
							saveFlag="4";
							fb.setStrMsgString("Error occurred while Generating File. Please try again ! ");
							throw new Exception(e.getMessage());
						}
				        
				    } catch (Exception e) {
				    	saveFlag="4";
				    	fb.setStrMsgString("Error occurred. Please try again ! ");
				        e.printStackTrace();
				    }
			}
 }
	catch(Exception e)
	{
		e.printStackTrace();
		if(saveFlag=="1")
			fb.setStrMsgString("Error occurred while Saving Data. Please Try Again !");	
		if(saveFlag=="4")
			fb.setStrMsgString("Data Saved but Error occurred while Generating File ! Reg. No. : "+vo.getPatCRNo());	
		//fb.setStrMsgString("InvOfflineResultEntryUTIL.insertOffllineResultEntry() --> "+ e.getMessage());
	}
}


public static void viewResultEntries_onHospChange(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
	try {
		
		InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
		InvOfflineResultEntryVO vo= new InvOfflineResultEntryVO();
		
		vo.setHospitalcode(fb.getHospitalcode());
		vo.setStrFromDate(fb.getStrFromDate());
		vo.setStrToDate(fb.getStrToDate());
		vo.setStrParentHospitalCode(fb.getStrParentHospitalCode());
		
		offlineResEntryData.viewResultEntriesListForReportView(vo);
		
		//Get the Hospital Combo in  the view page.
		offlineResEntryData.getHospitalList(vo); 
		
		String offlineResultEntryList = InvOfflineResultEntryHLP.viewResultEntries_onHospChange(vo);
		
		fb.setStrOfflineResEntPatDtl(offlineResultEntryList);
		
		fb.setStrGoFlag("1");
		
	} catch(Exception e) {
		
		e.printStackTrace();
	}
}

public static String readImageFromLocation(String FileName) {
	//Image image = null;
	InputStream io=null;
	BufferedImage image = null;
    int width=70;
    int height=68;
    ByteArrayOutputStream bos = null;
	String Fileurl;
	String asB64="";
	try {
		Fileurl = getFTPDtlSignFile();
		URL urlftp = new URL(Fileurl + "/" + FileName);
		System.out.println("FileUrl==="+Fileurl);
		URLConnection urlc = urlftp.openConnection();
		io = urlc.getInputStream();
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
          asB64 = "data:image/jpg;base64,"+new Base64Encoder().encode(buffer);
        //  fileNames.add(asB64);
          long end = System.currentTimeMillis();
          //System.out.println(end);
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    image = ImageIO.read(io);
	    //  System.out.println("Reading complete-> "+image);
	} catch(Exception e) {
		e.printStackTrace();
	}
	return asB64;
}


public static void getPatDtlsForModify(InvOfflineResultEntryFB fb, HttpServletRequest request) {
	
	InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
	InvOfflineResultEntryVO vo= new InvOfflineResultEntryVO();
	
	try {
			vo.setPatCRNo(fb.getPatCRNo());
			vo.setPatMobNo(fb.getPatMobNo());
			vo.setStrParentHospitalCode(fb.getStrParentHospitalCode());
		
			//Get the saved data of Patient.
			offlineResEntryData.getOffllineResultEntryPatientData(vo);
			offlineResEntryData.getOffllineResultEntryPatientTestData(vo);
			
			vo.getStrPatientDtlWS().beforeFirst();
			WebRowSet wsPatDtls= vo.getStrPatientDtlWS();
			
			vo.getStrPatientTestListWS().beforeFirst();
			WebRowSet wsPatTestDtls = vo.getStrPatientTestListWS();
			
			if(wsPatDtls.size()>0) {
				
				while(wsPatDtls.next()) {
					
					fb.setPatName(wsPatDtls.getString(1)); //Name.
					
					if(wsPatDtls.getString(2).equalsIgnoreCase("Male")) //Gender.
						fb.setPatGenderCode("M");
					else if(wsPatDtls.getString(2).equalsIgnoreCase("Female")) 
						fb.setPatGenderCode("F");
					else
						fb.setPatGenderCode("T");
					
					fb.setStrPatAge(wsPatDtls.getString(3)); //Age. 
					
					if(wsPatDtls.getString(4).equalsIgnoreCase("Days")) //Age Unit.
					{
						fb.setStrPatAgeUnit("D");
					}
					else if(wsPatDtls.getString(4).equalsIgnoreCase("Month")) {
						fb.setStrPatAgeUnit("M");
					}	
					else if(wsPatDtls.getString(4).equalsIgnoreCase("Weeks")) {
						fb.setStrPatAgeUnit("W");
					}	
					else {
						fb.setStrPatAgeUnit("Y");
					}
					
					fb.setPatGuardianName(wsPatDtls.getString(11)); //Father/Spouse Name.
					fb.setMobileNo(wsPatDtls.getString(6)); 		//Mobile no.
					fb.setPatAdd(wsPatDtls.getString(5));			//Address
					fb.setSamplecoldate(wsPatDtls.getString(9));	//sample collection date.
					fb.setResultDate(wsPatDtls.getString(10));		//Result Entry Date.
					fb.setStrPatHospCode(wsPatDtls.getString(13));//+"^"+wsPatDtls.getString(7));		//Sample Collecting Hospital
				}
			}
			//offlineResEntryData.getOfflineTestDetail(vo,userVO);
			String strResultDtl = InvOfflineResultEntryHLP.getOfflineResultEntryDtls(vo, request);
			fb.setStrResultDtl(strResultDtl);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
}


public static void updateOffllineResultEntry(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
	
}


public static String isDuplicacyReqd(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
	String isDupChkRqd="";
	try {
		
		InvOfflineResultEntryVO vo= new InvOfflineResultEntryVO();
		
		vo.setStrPatHospCode(fb.getStrPatHospCode());
		isDupChkRqd = InvOfflineResultEntryDAO.isDuplicacyReqd(vo);
	}catch (Exception e) {
		e.printStackTrace();
	}
	return isDupChkRqd;
}


public static void getDuplicatePatientDtl(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
	
	InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
	InvOfflineResultEntryVO vo=(InvOfflineResultEntryVO) TransferObjectFactory.populateData("new_investigation.vo.InvOfflineResultEntryVO", fb);
	
	offlineResEntryData.getDuplicatePatientDtl(vo);
	
	if(vo.getDupPatListWS().size()>0) {  //If Duplicate records Found.
		String dupPatientList = InvOfflineResultEntryHLP.getDuplicatePatientDtl(vo);
		System.out.println("Duplicates = "+dupPatientList);
		fb.setStrDupPatList(dupPatientList);
	}
	else {
		fb.setStrDupPatList("");
	}
 }


public static void getAllPatList(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p) {
	
	try
	{
		InvOfflineResultEntryVO vo=(InvOfflineResultEntryVO) TransferObjectFactory.populateData("new_investigation.vo.InvOfflineResultEntryVO", fb);
		
		InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
		
		//Get the saved data of Patient.
		offlineResEntryData.getOffllineResultEntryPatientCount(vo);
		//offlineResEntryData.getOffllineResultEntryPatientTestDataForView(vo);
		vo.getPatientListWS().beforeFirst();
		
		String printOfflineEntryPatData = InvOfflineResultEntryHLP.getAllPatList(vo);
		
		fb.setStrMultiPatList(printOfflineEntryPatData);
		fb.setStrGoFlag("1");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		fb.setStrMsgString("InvOfflineResultEntryUTIL.insertOffllineResultEntry() --> "+ e.getMessage());
	}
	
}


public static void getAllPatListResultEntry(InvOfflineResultEntryFB fb, HttpServletRequest objRequest_p)
{
	try
	{
		InvOfflineResultEntryVO vo=(InvOfflineResultEntryVO) TransferObjectFactory.populateData("new_investigation.vo.InvOfflineResultEntryVO", fb);
		
		InvOfflineResultEntryDATA offlineResEntryData = new InvOfflineResultEntryDATA();
		
		//Get the saved data of Patient.
		offlineResEntryData.getOffllineResultEntryPatientCount(vo);
		//offlineResEntryData.getOffllineResultEntryPatientTestDataForView(vo);
		vo.getPatientListWS().beforeFirst();
		
		String printOfflineEntryPatData = InvOfflineResultEntryHLP.getAllPatListResultEntry(vo);
		
		fb.setStrMultiPatList(printOfflineEntryPatData);
		fb.setStrGoFlag("1");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		fb.setStrMsgString("InvOfflineResultEntryUTIL.getAllPatListResultEntry() --> "+ e.getMessage());
	}

	
}

}
	
