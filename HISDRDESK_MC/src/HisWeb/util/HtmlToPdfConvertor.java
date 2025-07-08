package HisWeb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

import HisWeb.dao.EHRDetailsDAO;
import application.filters.Base64Utils;

public class HtmlToPdfConvertor {
	
	public static void convert(String html , String outputPath) throws IOException {
		
		 String xhtml = HtmlToPdfConvertor.htmlToXhtml(html);
		 //System.out.println("xhtml>>>>" + xhtml);
		  try {
			HtmlToPdfConvertor.xhtmlToPdf(xhtml, outputPath);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //System.out.println("after xhtmlToPdf>" );
	}
	
	  private  static String htmlToXhtml(String html) {
	        Document document = Jsoup.parse(html);
	        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
	        return document.html();
	    }

	  private static void xhtmlToPdf(String xhtml, String outFileName) throws IOException, DocumentException {
		  
		  //System.out.println("inside xhtmlToPdf method ");
		  
	        File output = new File(outFileName);
	        
	        
	        //System.out.println("below file creation ");
	        
	        if (!output.getParentFile().exists()) {
	        	output.getParentFile().mkdirs();
	        }
	        
	        
	        //System.out.println("parent file creation ");
	        
	        ITextRenderer iTextRenderer = new ITextRenderer();
	        
	        iTextRenderer.setDocumentFromString(xhtml);
	        iTextRenderer.layout();
	        OutputStream os = new FileOutputStream(output);	        
	        iTextRenderer.createPDF(os);
	        
	        //System.out.println("pdf complete");
	        
	        os.close();
	        
	        //System.out.println("pdf file close");
	    }
	
	    public static String get_pat_prescription_pdf(String modval, String crNo, String episodeCode,	String visitNo, String seatId, String entrydate, String hosp_code) {
	    	//System.out.println("inside HtmlToPdfConvertor.get_pat_prescription_html_details ");
			String pdfbase64=null;
			List<String> lst = EHRDetailsDAO.get_pat_prescription_html_details(modval, crNo, episodeCode, visitNo, seatId, entrydate, hosp_code,1);
			StringBuilder sb= new StringBuilder();
			
			String osType = System.getProperties().getProperty("os.name");
			String filePath = "";
			if (osType.startsWith("Win")) {
				filePath = "C:/CGHS/FileHandling/prescriptions/";
			} else {
				filePath = "/opt/Arunachal_PHDM/FileHandling/prescriptions/";
			}
			
			//filePath = filePath  + crNo.replace("/", "-") + "_"+episodeCode+"_"+visitNo+ ".pdf";
			filePath = filePath  + "prescription.pdf";
			
			//System.out.println("filePath?>>> " + filePath);
			
			
			sb.append( "<html> <head> <style>"
					+ ".examination,.investigation,.printPrescTreatmentLst,ul#menu li{margin:0!important}.printPrescPage p,ul#menu li{letter-spacing:inherit!important;color:#5a5a5a!important}.printPrescTreatmentTbl tr td,.printPrescTreatmentTbl tr th{border-top:0 solid #ddd!important}#footer,#header{visibility:hidden;position:fixed}#footer,#header,#watermark{position:fixed}.tablePrecrption,.tablePrecrption td{border:1px solid #000}ul#menu li{display:inline;font-size:14px;text-align:justify}.page-break{page-break-after:always}body{padding-bottom:80px}#printPrescPage{margin-bottom:45px}.examination li,.investigation li,.printPrescTreatmentLst li{text-align:left!important}.examination li p,.investigation li p,.printPrescTreatmentLst li p{margin:0!important;font-size:14px}.printPrescPage{color:#000!important}.printPrescPage p{font-weight:600;text-align:justify}.printPrescPage p small{font-weight:400!important;font-size:14px}.printPrescPatDtlTbl tr td,.printPrescPatDtlTbl tr th{border-top:0 solid #ddd!important;padding:2px 5px}.printPrescPatDtlTbl{font-size:13px;margin:10px 0}.printPrescTreatmentTbl{font-size:13px}.printPrescTreatmentTbl tr th{border-bottom:0 solid #ddd!important}#watermark{top:42%;left:25%;opacity:.1;font-size:90px;z-index:-1;color:#000;transform:rotate(-20deg)}#header{top:0;width:100%}#footer{bottom:0;left:0;right:0;text-align:center;color:#7e7e7e;padding-bottom:0}@media only screen and (min-width:1100px){#prHeaderr{right:14px!important;margin-top:11px!important}#printPrescPage{width:95%!important}}@media only screen and (max-width:851px){#prHeaderr{right:174px!important;margin-top:50px!important}#printPrescPage{width:100%!important;margin-right:none!important}}#printPrescFrameBody .row{z-index:-1;position:relative}.tablePrecrption td{width:33%}.tablePrecrption td span{font-weight:700}hr{border-style:inset;border-width:1px}table{border-collapse:collapse;border-spacing:0}td,th{padding:0}.pull-right{float:right!important}.pull-left{float:left!important}@media print{#footer,#header{visibility:visible}.prescPrintBtn,.prescSaveBtn,.withHeaderLabel{display:none}@page{margin-top:0;margin-bottom:0}body{padding-top:0;padding-bottom:72px}}"
					+ "</style> </head><body>" );
			
			////System.out.println("lst length>>>" + lst.size());
			for(int i=0;i<lst.size();i++){
				String htmlBase64=lst.get(i);
				//System.out.println("htmlBase64>> " + htmlBase64);
				String prescriptionHtml= Base64Utils.decode(htmlBase64);
				//System.out.println("prescriptionHtml>>>>" + prescriptionHtml);
				sb.append(prescriptionHtml);		
				sb.append("<p style='page-break: always;'>&nbsp;</p>");
			}
			
			sb.append(" </body></html>");
			
			// //System.out.println("finalHTML>>>>" + finalHTML);
				try {
					//System.out.println("before  convert?>>> ");
					convert(sb.toString() , filePath);
					//System.out.println("after  convert?>>> ");
					pdfbase64 =convertPDFToBase64(filePath);
					//System.out.println("pdfbase64>>>" + pdfbase64);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return pdfbase64;
		}
	    
	    
	    public static String get_pat_referral_pdf(String modval, String crNo, String episodeCode,	String visitNo, String seatId, String entrydate, String hosp_code ) {
	    	//System.out.println("inside HtmlToPdfConvertor.get_pat_prescription_html_details ");
			String pdfbase64=null;
			List<String> lst = EHRDetailsDAO.get_pat_prescription_html_details(modval, crNo, episodeCode, visitNo, seatId, entrydate, hosp_code,2);
			StringBuilder sb= new StringBuilder();
			
			String osType = System.getProperties().getProperty("os.name");
			String filePath = "";
			if (osType.startsWith("Win")) {
				filePath = "C:/CGHS/FileHandling/prescriptions/";
			} else {
				filePath = "/opt/Arunachal_PHDM/FileHandling/prescriptions/";
			}
			
			//filePath = filePath  + crNo.replace("/", "-") + "_"+episodeCode+"_"+visitNo+ ".pdf";
			filePath = filePath  + "prescription.pdf";
			
			//System.out.println("filePath?>>> " + filePath);
			
			
			sb.append( "<html> <head> <style>"
					+ ".examination,.investigation,.printPrescTreatmentLst,ul#menu li{margin:0!important}.printPrescPage p,ul#menu li{letter-spacing:inherit!important;color:#5a5a5a!important}.printPrescTreatmentTbl tr td,.printPrescTreatmentTbl tr th{border-top:0 solid #ddd!important}#footer,#header{visibility:hidden;position:fixed}#footer,#header,#watermark{position:fixed}.tablePrecrption,.tablePrecrption td{border:1px solid #000}ul#menu li{display:inline;font-size:14px;text-align:justify}.page-break{page-break-after:always}body{padding-bottom:80px}#printPrescPage{margin-bottom:45px}.examination li,.investigation li,.printPrescTreatmentLst li{text-align:left!important}.examination li p,.investigation li p,.printPrescTreatmentLst li p{margin:0!important;font-size:14px}.printPrescPage{color:#000!important}.printPrescPage p{font-weight:600;text-align:justify}.printPrescPage p small{font-weight:400!important;font-size:14px}.printPrescPatDtlTbl tr td,.printPrescPatDtlTbl tr th{border-top:0 solid #ddd!important;padding:2px 5px}.printPrescPatDtlTbl{font-size:13px;margin:10px 0}.printPrescTreatmentTbl{font-size:13px}.printPrescTreatmentTbl tr th{border-bottom:0 solid #ddd!important}#watermark{top:42%;left:25%;opacity:.1;font-size:90px;z-index:-1;color:#000;transform:rotate(-20deg)}#header{top:0;width:100%}#footer{bottom:0;left:0;right:0;text-align:center;color:#7e7e7e;padding-bottom:0}@media only screen and (min-width:1100px){#prHeaderr{right:14px!important;margin-top:11px!important}#printPrescPage{width:95%!important}}@media only screen and (max-width:851px){#prHeaderr{right:174px!important;margin-top:50px!important}#printPrescPage{width:100%!important;margin-right:none!important}}#printPrescFrameBody .row{z-index:-1;position:relative}.tablePrecrption td{width:33%}.tablePrecrption td span{font-weight:700}hr{border-style:inset;border-width:1px}table{border-collapse:collapse;border-spacing:0}td,th{padding:0}.pull-right{float:right!important}.pull-left{float:left!important}@media print{#footer,#header{visibility:visible}.prescPrintBtn,.prescSaveBtn,.withHeaderLabel{display:none}@page{margin-top:0;margin-bottom:0}body{padding-top:0;padding-bottom:72px}}"
					+ "</style> </head><body>" );
			
			////System.out.println("lst length>>>" + lst.size());
			for(int i=0;i<lst.size();i++){
				String htmlBase64=lst.get(i);
				//System.out.println("htmlBase64>> " + htmlBase64);
				String prescriptionHtml= Base64Utils.decode(htmlBase64);
				//System.out.println("prescriptionHtml>>>>" + prescriptionHtml);
				sb.append(prescriptionHtml);		
				sb.append("<p style='page-break: always;'>&nbsp;</p>");
			}
			
			sb.append(" </body></html>");
			
			// //System.out.println("finalHTML>>>>" + finalHTML);
				try {
					//System.out.println("before  convert?>>> ");
					convert(sb.toString() , filePath);
					//System.out.println("after  convert?>>> ");
					pdfbase64 =convertPDFToBase64(filePath);
					//System.out.println("pdfbase64>>>" + pdfbase64);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return pdfbase64;
		}
	    
	    
	    public static String convertPDFToBase64(String filePath) {
	        File file = new File(filePath);
	        try (FileInputStream fileInputStream = new FileInputStream(file)) {
	            // Read PDF file into byte array
	            byte[] pdfBytes = new byte[(int) file.length()];
	            fileInputStream.read(pdfBytes);

	            // Convert byte array to Base64 string
	            String base64String = Base64.getEncoder().encodeToString(pdfBytes);
	            file.delete();
	            file=null;
	            return base64String;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	        finally {
	        	
	        }
	    }
	    
	    
	    public static String get_pat_prescription_html_details(String modval, String crNo, String episodeCode,	String visitNo, String seatId, String entrydate, String hosp_code) {
	    	List<String> lst = EHRDetailsDAO.get_pat_prescription_html_details(modval, crNo, episodeCode, visitNo, seatId, entrydate, hosp_code,1);
			StringBuilder sb= new StringBuilder();
			
			for(int i=0;i<lst.size();i++){
				String htmlBase64=lst.get(i);
				//String prescriptionHtml= Base64Utils.decode(htmlBase64);
				sb.append(htmlBase64);
			}
			
			
			return sb.toString();
		}
	    
	    public static String get_pat_referral_details(String modval, String crNo, String episodeCode,	String visitNo, String seatId, String entrydate, String hosp_code) {
	    	List<String> lst = EHRDetailsDAO.get_pat_prescription_html_details(modval, crNo, episodeCode, visitNo, seatId, entrydate, hosp_code,2);
			StringBuilder sb= new StringBuilder();
			
			for(int i=0;i<lst.size();i++){
				String htmlBase64=lst.get(i);
				//String prescriptionHtml= Base64Utils.decode(htmlBase64);
				sb.append(htmlBase64);
			}
			
			
			return sb.toString();
		}

}