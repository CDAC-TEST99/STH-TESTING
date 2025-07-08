package DataProcessing;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.text.DocumentException;

import DataHelper.JakartaFTPWrapper;
import DataHelper.PropertiesHelper;

public class HtmlToPdf {
	
	
	public static void main(String[] args) throws FileNotFoundException, DocumentException, java.io.IOException {
		
		String testHTML = "<div style='width:95%;margin-left:3%'>" + 
				"<table cellspacing='0' cellpadding='0' border='0' style='width:100%;text-align:center' >" + 
				"    <tr>" + 
				"        <td ><img  src='data:image/jpeg;base64,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' height='50' width='50' /></td></tr></table> " + 
				"       <table cellspacing='0' cellpadding='0' border='0' style='width:100%;text-align:center'><tr><td><font color='black' size='4'><b>For Testing Only</b></font></td></tr>" + 
				"        <tr><td><font color='black' size='3'><b>Testing Only</b></font></td></tr>" + 
				"        <tr><td><font color='black' size='3'><b>Testing</b></font></td></tr>" + 
				"        <tr><td><font color='black' size='3'><b>North Andaman-123,Sikkim, INDIA</b></font></td></tr></table>" + 
				"" + 
				"<table cellspacing='0' cellpadding='0' border='0' style='width:100%;text-align:center'>" + 
				"    <tr>" + 
				"        <td><font color='black' size='4'>  Lab Report </font></td>" + 
				"    </tr>" + 
				"     <tr>" + 
				"         <td style='text-align:left;'><font color='black' size='3'><b style='background-color:#FFDDC1;'>Clinical Pathology Lab Test</b></font></td>" + 
				"         </tr></table> " + 
				"<table style='width:100%;'>" + 
				"    <tr><td align='right' colspan='7'></td></tr>" + 
				"    <tr><td style='border-bottom:1px solid #000;' colspan='20'> </td></tr>" + 
				"    " + 
				"    <tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>CR No</b></font></div></td><td colspan='3'><div align='left'>: <font style='font-size: 12px;'>190012400002095</font></div></td>" + 
				"    <td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Lab/Study No.</b></font></div></td><td colspan='2'><div align='left'> <font style='font-size: 12px;'>: 240531000001</font></div></td>" + 
				"    <td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Requisition Date</b></font></div></td><td colspan='2'><div align='left'>: <font style='font-size: 12px;'>31-May-2024 10:53</font></div></td>" + 
				"    </tr>" + 
				"    <tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Patient Name</b></font></div></td>" + 
				"    <td colspan='3'><div align='left'>: <font style='font-size: 12px;'>Test    </font></div></td>" + 
				"    <td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Age/Sex</b></font></div></td>" + 
				"    <td colspan='2'><div align='left'>: <font style='font-size: 12px;'>56 Yr/M</font></div></td>" + 
				"    <td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Coll./Study Date</b></font></div></td>" + 
				"    <td colspan='2'><div align='left'>: <font style='font-size: 11px;'>31-May-2024 10:54</font></div></td></tr>" + 
				"    <tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Sample Type/No</b></font></div></td>" + 
				"    <td colspan='3'><div align='left'> <font style='font-size: 12px;'>: Ascitic /240531000001</font></div></td>" + 
				"    <td  colspan='2'><div align='left'><font style='font-size: 12px;'><b>Ward/OPD</b></font></div></td>" + 
				"    <td  colspan='2'><div align='left'>: <font size='1'>OPD</font></div></td>" + 
				"    <td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Reporting Date</b></font></div></td>" + 
				"    <td colspan='2'><div align='left'>: <font style='font-size: 12px;'>11-Jun-2024 14:19</font></div></td></tr><tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Dept/Unit6</b></font></div></td>" + 
				"    <td colspan='11'><div align='left'>: <font style='font-size: 12px;'>Unit 1</font></div></td>" + 
				"    </tr>" + 
				"    <tr><td align='right' colspan='7'></td></tr>" + 
				"    <tr><td style='border-bottom:2px solid #000;' colspan='20'> </td></tr>" + 
				"</table>" + 
				"<table>" + 
				"    <tr>" + 
				"        <td width='30%'><font color='black' size='3'><b>Investigation</b></font></td>" + 
				"        <td colspan='1' width='40%'   ><div ><font color='black' size='3'><b>         Result</b></font></div></td>" + 
				"        <td width='35%'><div ><font color='black' size='3'><b>         Unit</b></font></div></td>" + 
				"        <td width='15%'><div ><font color='black' size='3'><b>Ref.Range</b></font></div></td> " + 
				"    </tr>" + 
				"    <tr><td align='right' colspan='7'></td></tr><tr><td style='border-bottom:2px solid #000;' colspan='20'> </td></tr>" + 
				"    " + 
				"    <tr><td colspan=\"1\" width=\"40%\" >Test Combo Test</td><td colspan=\"1\"   width=\"35%\">Negative</td><td width=\"20%\" >Ml</td><td width=\"15%\" align=\"center\">   25 - 33 </td></tr>" + 
				"     <tr><td align='right' colspan='7'></td></tr><tr><td style='border-bottom:2px solid #000;' colspan='20'> </td></tr>" + 
				"</table>" + 
				"" + 
				"<table  style='margin-top:25px'><tr><td><font color='black' size='3'><b><u>Comments : </u></b></font></td></tr><tr><td colspan='13'></td></tr></table> " + 
				"" + 
				"<table cellspacing='0' cellpadding='0' border='0' width='100%' >" + 
				"    <tr>" + 
				"        <td align='center' width='100%'><font color='black' size='2px;' ><b>********** END OF THE REPORT **********</b></font>" + 
				"        </td>" + 
				"        </tr>" + 
				"        </table>" + 
				"        <br/>" + 
				"        <table width='100%' height='5%' cellspacing='0' cellpadding='0' border='0'>" + 
				"            <tr>" + 
				"                <td ><font color='black' size='1px;'>All reports need clinical correlation. Kindly discuss if necessary. No part of the report can be reproduced without written permission of the department.</font>" + 
				"                </td>" + 
				"                </tr>" + 
				"                <tr>" + 
				"                    <td><font color='black' size='1'><br/><b>Validated By: </b></font></td></tr>" + 
				"                    <tr><td ><font color='black' size='1'><b> This is computer generated report. Signature not required </b></font>" + 
				"                    </td>" + 
				"                    </tr>" + 
				"                    <tr>" + 
				"                        <td style='border-bottom:2px solid #000;' colspan='13'> " + 
				"                        </td>" + 
				"                        </tr>" + 
				"                        </table>" + 
				"" + 
				"</div>";
		
		System.out.println(testHTML);
		
		 ITextRenderer iTextRenderer = new ITextRenderer();
	        iTextRenderer.setDocumentFromString(testHTML);
	        iTextRenderer.layout();
	        iTextRenderer.createPDF(new FileOutputStream(new File("e:/test.pdf")));
	}
	
	
	
	public static  void convert(String inputStreamReader , String styleSheet, String pdfFileurl) throws IOException, DocumentException, java.io.IOException {
		
		inputStreamReader=inputStreamReader.replace("&nbsp;", " ");
		inputStreamReader=inputStreamReader.replace("<br>", "<br/>");
		System.out.println("inputStreamReader>>>>" + inputStreamReader);
		 String xhtml = htmlToXhtml(inputStreamReader);
		// System.out.println("xhtml>>>>" + xhtml);
		  xhtmlToPdf(xhtml, styleSheet,pdfFileurl);
		  System.out.println("after xhtmlToPdf>" );
		 
	}
	
	
	

	private  static String htmlToXhtml(String inputStreamReader) {
	        Document document = Jsoup.parse(inputStreamReader);
	        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
	        return document.html();
	    }

	  private static void xhtmlToPdf(String xhtml, String styleSheet,String pdfFileurl) throws IOException, DocumentException, java.io.IOException {
		  
		  System.out.println("inside xhtmlToPdf method ");
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();
          ByteArrayOutputStream output = new ByteArrayOutputStream();
		  

			URL urlftp =new URL(styleSheet);
			System.out.println("urlftp>>123>>>"+urlftp);
		//	System.out.println("pdfFileName>>345>>>"+pdfFileName);
			URLConnection urlc=	urlftp.openConnection();
			
				BufferedOutputStream bos=null;
				try
			{
				bos=new BufferedOutputStream(urlc.getOutputStream());
				
			}
			catch(Exception ex)
			{
				System.out.println("catch");
				ex.printStackTrace();
			}
			
				if(bos==null)
			{
				String[] folder=pdfFileurl.replace("/", "#").split("#");
				
				if(folder[2]!=null && folder[2].replace("@", "#").split("#").length>1)
					createDirectoryStructure(folder[2].replace("@", "#").split("#")[1],folder);
				else
					createDirectoryStructure(folder[2],folder);	
				
				bos=new BufferedOutputStream(urlc.getOutputStream());
			}
		  
		  
		  
	        //File output1 = new File(styleSheet);
	        
	        
	        System.out.println("below file creation ");
	        
	     //   if (!output1.getParentFile().exists()) {
	     //   	output1.getParentFile().mkdirs();
	     //   }
	        
	        System.out.println("parent file creation ");
	        
	      //  ITextRenderer iTextRenderer = new ITextRenderer();
	     //    FontResolver resolver = iTextRenderer.getFontResolver();
	     //   iTextRenderer.getFontResolver().addFont("MyFont.ttf", true);
	    //    iTextRenderer.setDocumentFromString(xhtml);
	    //    iTextRenderer.layout();
	    //    OutputStream os = new FileOutputStream(output1);
	    //    iTextRenderer.createPDF(os);
	    ///  --------------------------------------------------     
	        ITextRenderer iTextRenderer = new ITextRenderer();
	        iTextRenderer.setDocumentFromString(xhtml);
	        iTextRenderer.layout();
	        iTextRenderer.createPDF(baos);
	        
	        
	        System.out.println("pdf complete");
	        
	        baos.writeTo(bos);
	        bos.flush();
	        bos.close();
	        
	        System.out.println("pdf file close");
	    }
	  
	  
	  
	  private synchronized static void createDirectoryStructure(String ftpserver, String[] folders) {
			JakartaFTPWrapper ftp = null;
			try {
				 ftp = new JakartaFTPWrapper();
				
			//	HisAppletConfigurator hisAppletConfigurator=new HisAppletConfigurator();
				//new TemplateProcessingClass(1,"101").readingAppletConfiguratorXML(hisAppletConfigurator);
				
				
				/*String ftpUserName=hisAppletConfigurator.getResultprintingusername();
				String ftpUserPassword=hisAppletConfigurator.getResultprintinguserpassword();*/
				
				String ftpUserName= PropertiesHelper.getFTPConnectionUsername();
				String ftpUserPassword=PropertiesHelper.getFTPConnectionPassword();
				
				System.out.println("nandini134"+ ftpserver);		
				System.out.println("Connecting to " + ftpserver + "ftpUserName :"+ftpUserName+" ftpUserPassword :"+ftpUserPassword);
				if (ftp.connectAndLogin(ftpserver, ftpUserName, ftpUserPassword))
				{
					System.out.println("Connected to " + ftpserver);
					ftp.setPassiveMode(true);
					ftp.changeWorkingDirectory("ftpserver");
					System.out.println("Present Working Directory :"+ftp.pwd());
					for(int i=4;i<folders.length;i++)
					{
							//System.out.println("directory "+folders[i]+" created");
					ftp.mkd(folders[i]);
					ftp.changeWorkingDirectory(folders[i]);
					}
				}
				else 
				{
					System.out.println("Unable to connect to" + ftpserver);
				}
				
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		
		finally {
			try
			{
				if(ftp!=null)
				{
				ftp.logout();
				ftp.disconnect();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		}

	

}
