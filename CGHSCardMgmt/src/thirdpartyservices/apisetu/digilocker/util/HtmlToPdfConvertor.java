package thirdpartyservices.apisetu.digilocker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
  

public class HtmlToPdfConvertor {
	
	public static void convert(String html , String outputPath) throws IOException, com.itextpdf.text.DocumentException {
		
		 String xhtml = HtmlToPdfConvertor.htmlToXhtml(html);
		// System.out.println("xhtml>>>>" + xhtml);
		  try {
			xhtmlToPdf(xhtml, outputPath);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//  System.out.println("after xhtmlToPdf>" );
	}
	
	  private  static String htmlToXhtml(String html) {
	        Document document = Jsoup.parse(html);
	        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
	        return document.html();
	    }

	  
	  
	  private static void xhtmlToPdf(String xhtml, String outFileName) throws IOException, DocumentException, com.itextpdf.text.DocumentException {
		  
		  //System.out.println("inside xhtmlToPdf method ");
		  
	        File output = new File(outFileName);
	        
	        
	      //  System.out.println("below file creation ");
	        
	        if (!output.getParentFile().exists()) {
	        	output.getParentFile().mkdirs();
	        }
	        
	        
	      //  System.out.println("parent file creation ");
	        
	        ITextRenderer iTextRenderer = new ITextRenderer();
	        
	        iTextRenderer.setDocumentFromString(xhtml);
	        iTextRenderer.layout();
	        OutputStream os = new FileOutputStream(output);	        
	        iTextRenderer.createPDF(os);
	        
	    //    System.out.println("pdf complete");
	        
	        os.close();
	        
	    //    System.out.println("pdf file close");
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
	    
	     

}