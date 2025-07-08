/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProcessing;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PRAcroForm;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.SimpleBookmark;
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
import com.jscape.inet.ftp.FtpException;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.styledxmlparser.jsoup.Jsoup;

import DataHelper.Config;
import DataHelper.JakartaFTPWrapper;
import DataHelper.PropertiesHelper;
import HisWeb.util.HtmlToPdfConvertor;
import Logging.ServiceLogger;
import MongoHelper.MongoXmlHandler;
import TemplateHelper.EndPage;

/**
 * *************************Start of program***************************** ##
 * Copyright Information	: C-DAC, Noida ## Project Name	: CCD SDK ## Name of
 * Developer	: Siddharth Srivastava ## Module Name	: Health Standards ##
 * Process/Database Object Name	: ## Purpose : ## Date of Creation	: ##
 * Modification Log	: ##	Modify Date	: ##	Reason	(CR/PRS)	: ##	Modify By	:
 */
/**
 *
 * @author Siddharth Srivastava <siddharthsrivastava@cdac.in>
 */
public class SavePDF {
	

    public synchronized static String saveFileToLocation(String headerString, String footerString, String htmlString, String pdfFileName, float footerHeight, float headerHeight, float headerwidth, float footerWidth, String pageHeight, String pageWidth, byte[] oldpdf,String fileuploaddata,String isfileuploadprint,String isfirstpageprint) throws IOException, DocumentException {
        Document document = null;
       /* Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::pageHeight ::" + pageHeight);
        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::pagewidth ::" + pageWidth);
        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::headerHeight ::" + headerHeight);
        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::headerWidth ::" + headerwidth);
        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::footerHeight ::" + footerHeight);
        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::footerWidth ::" + footerWidth);*/
       // headerHeight=Float.parseFloat( Config.HEADER_HEIGHT);
        
       
        
      float  footerHeight1=Float.parseFloat( Config.FOOTER_HEIGHT);
        String returnStatus = null;
        if(htmlString == null )
        {
            Log(Level.SEVERE, "Empty HTML String");
            return null;
        }
        
        if (pageHeight == null) {
            document = new Document(PageSize.A4);
        } else {
            document = new Document(new Rectangle(Float.parseFloat(pageWidth), Float.parseFloat(pageHeight))); // specify the page size
        }
        
        
        // for dynamic test template( canned file issue)
     
     /*   htmlString=htmlString.replace("<","&lt;");
        htmlString=htmlString.replace(">","&gt;");
     */
        
      /*  htmlString=htmlString.replace("&lt;","<");
        htmlString=htmlString.replace("&gt;",">");
        htmlString=htmlString.replace("&amp;","&");
      */ 
        
        
        htmlString=htmlString.replace("&amp;","&");
      //for text area line breaks 
       // htmlString=htmlString.replace("\r\n","<br/>");
        
        
       // String divv="<div style='height:7px;'></div>";
        //htmlString=htmlString.replace("\r\n",divv);
        System.out.println("the main html string is 123:  "+htmlString);
        
        List <byte[]> finalPdfArray= new ArrayList<byte[]>();
        if(oldpdf!=null)
        {
        	if(isfirstpageprint!=null && isfirstpageprint.equals("1")) // not attach oldpdf in case of file upload
            {
        
            }
        	else
        	{
        		finalPdfArray.add(oldpdf);
        	}
        	
         }

        //new addendum report output stream
     /*   ByteArrayOutputStream addendumoutputstream = new ByteArrayOutputStream( );
        byte newdata[] = null;
        if(oldpdf!=null && !oldpdf.equals("null"));
        addendumoutputstream.write( oldpdf );*/
       
        
        
    //    BaseFont bf = BaseFont.createFont("/DataProcessing/FreeSans.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
   //     Font f = new Font(bf, 12);
    //    String htmlStart="<html><head><meta http-equiv='content-type' content='application/xhtml+xml; charset=UTF-8'/></head><body style=\"font-size:12.0pt; font-family:Arial\"><br /><br /><br /><br />";
        String htmlStart="<div style=\"font-size:12.0pt; font-family:Times New Roman\">";//"<html><head><meta http-equiv='content-type' content='application/xhtml+xml; charset=UTF-8'/></head><body style=\"font-family:Arial\">";
        String htmlEnd="</div>";
       // String htmlEnd="</html>";
    //	Paragraph p = new Paragraph(htmlStart+htmlString+htmlEnd, f);
//         String FONT = "C:\\Users\\P.S.KHURANA\\Downloads\\FreeSans.ttf"; // add arial
//        BaseFont bf = BaseFont.createFont(FONT, BaseFont..IDENTITY_H, BaseFont.EMBEDDED);
//        Font f = new Font(bf, 12);
//        Paragraph p = new Paragraph(htmlString, f);
        InputStream s = new ByteArrayInputStream(htmlString.getBytes());
        BufferedOutputStream bos = null;
        List<Element> footerElementList = null;
        List<Element> headerElementList = null;
        System.out.println(headerString);
        try {

            if (footerString != null && (footerString.equals("") == false)) {
                footerElementList = HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(footerString.getBytes())), new StyleSheet());
                
            }

            if (headerString != null && (headerString.equals("") == false)) {
                headerElementList = HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(headerString.getBytes())), new StyleSheet());
            }

            
            document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin() + headerHeight, document.bottomMargin() + footerHeight);
            System.out.println("Header heights" + document.topMargin() + " " + headerHeight);
            System.out.println("footerr heights" + document.bottomMargin()  + " " + footerHeight);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            boolean isfirstpageprintornot=false;
            
            try {
               // System.out.println(htmlString);
                PdfWriter writer = PdfWriter.getInstance(document, baos);
                EndPage endPage = new EndPage();
                endPage.footerElementList = footerElementList; 
                endPage.headerElementList = headerElementList;
                writer.setPageEvent(endPage);
                document.open();
/*                endPage.onCloseDocument(writer, document);
                */
              // document.addHeader("", arg1)
                
               // latest change to print DELTA- 2 lines by adding htm head info
//                XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
//               // worker.parseXHtml(writer, document, s);
//                worker.parseXHtml(writer, document, s,Charset.forName("cp1252"));

                
                ///DataProcessing/
                
                /*this change didn't work
                 * 
                 *    ITextRenderer renderer = new ITextRenderer();
                     renderer.getFontResolver().addFont("c:/work/fonts/TIMES.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
               */
                
                
                
              /* this change didn't work
               * 
               *  XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
                InputStream is = new ByteArrayInputStream(htmlString.getBytes("UTF-8"));
                worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));*/
                
              /*  this change didn't work
               *  XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
                fontImp.register("/DataProcessing/FreeSans.ttf");
                XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                        new FileInputStream(htmlString), null, Charset.forName("UTF-8"), fontImp);*/
                
                
             
                
                
                
                
               /* this change didn't work*/
                 // document.add(p);
                
                
//               HTMLWorker htmlWorker = new HTMLWorker(document);
//                htmlWorker.parse(new StringReader(p.toString()));
//               
                
                
                	
//              String FONT = "C:\\Users\\P.S.KHURANA\\Downloads\\arial.ttf"; // add arial
//             BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//             Font f = new Font(bf, 12);
//             Paragraph p1 = new Paragraph("",f);
//                
//                ElementList list = XMLWorkerHelper.parseToElementList(htmlString, null);
//                for (Element element : list) {
//                    p1.add(element);
//                }
//                
//              // Paragraph para = new Paragraph(p1.toString(), f);
//               document.add(p1);
        /*        original parsing  process      */
              
//         List<Element> elementlist =  HTMLWorker.parseToList(new InputStreamReader(s), new StyleSheet());
//                for (int i = 0; i < elementlist.size(); i++) {
//                    Element element = (Element) elementlist.get(i);
//                    if (elementlist.size() > 0) {
//                        document.add(element);
//                    }
//                }
                CSSResolver cssResolver =
                        XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
         
                
                XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
                fontProvider.register(PropertiesHelper.getFontFile(), "Arial");
                //fontProvider.register("resources/fonts/PT_Serif-Web-Regular.ttf", "Serif");
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
                if(p==null)
                	System.out.println("p is null");
                if(s== null)
                {
                	System.out.println("nullll");
                }
                p.parse(s);
                
            } catch (DocumentException e) {
                //returnStatus = null;
                Log(Level.WARNING, e);
                e.printStackTrace();
            }

            document.close();
            byte[] pdfData = baos.toByteArray();
           
            if(isfirstpageprint!=null && isfirstpageprint.equals("1"))
            {
            	isfirstpageprintornot=true;
            }
            else
            {
            	
            	finalPdfArray.add(pdfData);
            }
            
            
            
        /*    if(oldpdf!=null )
            {
            	
            	 if(isfirstpageprint!=null && isfileuploadprint.equals("1"))
                   {
                 		 output= mergeMyFilesfilesupload(finalPdfArray, output);	
                         pdfData=output.toByteArray();
             
                    }
            	 else
            	 {
                output= mergeMyFiles(finalPdfArray, output);	
                pdfData=output.toByteArray();
                }
            	 
            }*/
            
            
            if(isfileuploadprint!=null && !isfileuploadprint.equals("0"))
            {
            	if(fileuploaddata!=null && !fileuploaddata.equals(""))
            {
            	
            	if(fileuploaddata.contains("#@#"))
            	{
            		for(int k=0;k<fileuploaddata.split("#@#").length;k++)
            		{
            			 byte fileupload[]=null;
                         fileupload = org.apache.commons.codec.binary.Base64.decodeBase64(fileuploaddata.split("#@#")[k]);
                          
                         if(fileupload!=null)
                         	finalPdfArray.add(fileupload);
                         
                       
            		}
            	}
            	else
            	{
            		 byte fileupload[]=null;
                    fileupload = org.apache.commons.codec.binary.Base64.decodeBase64(fileuploaddata);
                     
                    if(fileupload!=null)
                    	finalPdfArray.add(fileupload);
                    

            	}
            	
            }
            }
            

            
          /*  if(oldpdf!=null)
            {
            addendumoutputstream.write( pdfData );
            newdata = addendumoutputstream.toByteArray( );
            }
            
            if(newdata!=null)
            	pdfData=newdata;*/
            
           
            
          
            if(finalPdfArray.size()>0)
            {
            	
            	if(isfirstpageprintornot==true && oldpdf!=null)
            output= mergeMyFiles(finalPdfArray, output);	
            	else
            output= mergeMyFiles(finalPdfArray, output);
            	
            pdfData=output.toByteArray();
            }
            
            MongoXmlHandler.getInstance().savePDFFile(pdfFileName, pdfData);
            returnStatus = "success";

        } catch (IOException e) {
            //  returnStatus = null;
            Log(Level.SEVERE, e);
            //e.printStackTrace();

        } finally {

            try {
                if (document != null) {
                    document.close();
                }
            } catch (Exception e) {
                //  returnStatus = null;
                //e.printStackTrace();
                Log(Level.SEVERE, e);
            }

            try {
                if (bos != null) {
                    
                    bos.close();
                }
            } catch (IOException e) {
                //  returnStatus = null;
                Log(Level.SEVERE, e);
               // e.printStackTrace();
            }
            
        }

        return returnStatus;
    }

    private static void Log(Level level, String msg) {
        ServiceLogger.Log(SavePDF.class.getName(), level, msg);
    }

    private static void Log(Level level, Exception e) {
        ServiceLogger.Log(SavePDF.class.getName(), level, e);
    }

    //to merge files
	private static ByteArrayOutputStream mergeMyFiles(List<byte[]> filesTobeMerges,
			ByteArrayOutputStream byteArrayOutputStream) {
		// TODO Auto-generated method stub
	//	System.out.println("Starting To Merge Files...");
		//System.out.println("Total Number Of Files To Be Merged..."+ filesToBeMerged.length + "\n");D:\root\investigationDetails\watermark\duplicateStamp.jpg D:\NEW_INVESTIGATION_21_05-2015\AHIMS\WebContent\new_investigation\images\duplicateStamp.jpg
		
		
		try {
			//Image img = Image.getInstance(InvestigationConfig.fetchfilepath+"duplicateStamp.jpg");	      
		   //  img.setAbsolutePosition(23,725);
		     
		    // Watermark watermark=new Watermark(img, 25, 725);
			int pageOffset = 0;
			ArrayList masterBookMarkList = new ArrayList();

			int fileIndex = 0;
			//String outFile = mergedFileLocation;
			Document document = null;
			PdfCopy writer = null;
			PdfReader reader = null;

			for (fileIndex = 0; fileIndex < filesTobeMerges.size(); fileIndex++) {

				
				/**
				 * Create a reader for the file that we are reading
				 */
				reader = new PdfReader(filesTobeMerges.get(fileIndex),"Administrator".getBytes()); //filesToBeMerged[fileIndex]
			//	System.out.println("Reading File -");

				/**
				 * Replace all the local named links with the actual
				 * destinations.
				 */
				reader.consolidateNamedDestinations();

				/**
				 * Retrieve the total number of pages for this document
				 */
				int totalPages = reader.getNumberOfPages();

			
				
				
				
				/**
				 * Get the list of bookmarks for the current document If the
				 * bookmarks are not empty, store the bookmarks into a master
				 * list
				 */
				
				System.out.println("Checking for bookmarks...");				
				List bookmarks = SimpleBookmark.getBookmark(reader);
				if (bookmarks != null) {
					if (pageOffset != 0)
						SimpleBookmark.shiftPageNumbers(bookmarks, pageOffset,
								null);
					masterBookMarkList.addAll(bookmarks);
			//		System.out.println("Bookmarks found and storing...");
				} else {
			//		System.out.println("No bookmarks in this file...");
				}
				pageOffset += totalPages;

				/**
				 * Merging the files to the first file. If we are passing file1,
				 * file2 and file3, we will merge file2 and file3 to file1.
				 */
				if (fileIndex == 0) {
					/**
					 * Create the document object from the reader
					 */
					document = new Document(reader.getPageSizeWithRotation(1));

					/**
					 * Create a pdf write that listens to this document. Any
					 * changes to this document will be written the file
					 * 
					 * outFile is a location where the final merged document
					 * will be written to.
					 */
//
			//		System.out.println("Creating an empty PDF...");
					writer = new PdfCopy(document,
							byteArrayOutputStream);
					/**
					 * Open this document
					 */
					
					//writer.add(watermark);
					document.open();
					//document.add(img);
					//document.add(watermark);
				}
				/**
				 * Add the conent of the file into this document (writer). Loop
				 * through multiple Pages
				 */
				System.out.println("Merging File: ");
				PdfImportedPage page;
				for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
					page = writer.getImportedPage(reader, currentPage);					
					writer.addPage(page);					
				}

				/**
				 * This will get the documents acroform. This will return null
				 * if no acroform is part of the document.
				 * 
				 * Acroforms are PDFs that have been turned into fillable forms.
				 */
		//		System.out.println("Checking for Acroforms");
				PRAcroForm form = reader.getAcroForm();
				if (form != null) {
					writer.addDocument(reader);
			//		System.out.println("Acroforms found and copied");
				} else
		//			System.out.println("Acroforms not found for this file");

				System.out.println();
			}
			/**
			 * After looping through all the files, add the master bookmarklist.
			 * If individual PDF documents had separate bookmarks, master
			 * bookmark list will contain a combination of all those bookmarks
			 * in the merged document.
			 */
			if (!masterBookMarkList.isEmpty()) {
				writer.setOutlines(masterBookMarkList);
		//		System.out.println("All bookmarks combined and added");

			} else {
	//			System.out.println("No bookmarks to add in the new file");

			}

			/**
			 * Finally Close the main document, which will trigger the pdfcopy
			 * to write back to the filesystem.
			 */
			if(document!=null)
			document.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArrayOutputStream;
	}


	
	 public synchronized static String saveFileToLocation1(String headerString, String footerString, String htmlString, String pdfFileName, float footerHeight, float headerHeight, float headerwidth, float footerWidth, String pageHeight, String pageWidth, byte[] oldpdf,List <byte[]> finalPdfArray1) throws IOException, DocumentException {
	        Document document = null;
	       /* Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::pageHeight ::" + pageHeight);
	        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::pagewidth ::" + pageWidth);
	        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::headerHeight ::" + headerHeight);
	        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::headerWidth ::" + headerwidth);
	        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::footerHeight ::" + footerHeight);
	        Log(Level.INFO, "DefaultPrintingTemplate::saveFileToLocation::footerWidth ::" + footerWidth);*/
	       // headerHeight=Float.parseFloat( Config.HEADER_HEIGHT);
	      float  footerHeight1=Float.parseFloat( Config.FOOTER_HEIGHT);
	        String returnStatus = null;
	        if(htmlString == null )
	        {
	            Log(Level.SEVERE, "Empty HTML String");
	            return null;
	        }
	        
	        if (pageHeight == null) {
	            document = new Document(PageSize.A4);
	        } else {
	            document = new Document(new Rectangle(Float.parseFloat(pageWidth), Float.parseFloat(pageHeight))); // specify the page size
	        }
	        
	        
	        // for dynamic test template( canned file issue)
	     
	     /*   htmlString=htmlString.replace("<","&lt;");
	        htmlString=htmlString.replace(">","&gt;");
	     */
	        
	      /*  htmlString=htmlString.replace("&lt;","<");
	        htmlString=htmlString.replace("&gt;",">");
	        htmlString=htmlString.replace("&amp;","&");
	      */ 
	        
	        
	        htmlString=htmlString.replace("&amp;","&");
	      //for text area line breaks 
	       // htmlString=htmlString.replace("\r\n","<br/>");
	        
	        
	       // String divv="<div style='height:7px;'></div>";
	        //htmlString=htmlString.replace("\r\n",divv);
	        System.out.println("the main html string is :  "+htmlString);
	        
	        List <byte[]> finalPdfArray= new ArrayList<byte[]>();
	        /*if(oldpdf!=null)
	        	finalPdfArray.add(oldpdf);
	        */
	        if(finalPdfArray1.size()>0)
	        {
	        	finalPdfArray=finalPdfArray1;
	        }
	        //new addendum report output stream
	     /*   ByteArrayOutputStream addendumoutputstream = new ByteArrayOutputStream( );
	        byte newdata[] = null;
	        if(oldpdf!=null && !oldpdf.equals("null"));
	        addendumoutputstream.write( oldpdf );*/
	       
	        
	        
	    //    BaseFont bf = BaseFont.createFont("/DataProcessing/FreeSans.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	   //     Font f = new Font(bf, 12);
	    //    String htmlStart="<html><head><meta http-equiv='content-type' content='application/xhtml+xml; charset=UTF-8'/></head><body style=\"font-size:12.0pt; font-family:Arial\"><br /><br /><br /><br />";
	        String htmlStart="<div style=\"font-size:12.0pt; font-family:Times New Roman\">";//"<html><head><meta http-equiv='content-type' content='application/xhtml+xml; charset=UTF-8'/></head><body style=\"font-family:Arial\">";
	        String htmlEnd="</div>";
	       // String htmlEnd="</html>";
	    //	Paragraph p = new Paragraph(htmlStart+htmlString+htmlEnd, f);
//	         String FONT = "C:\\Users\\P.S.KHURANA\\Downloads\\FreeSans.ttf"; // add arial
//	        BaseFont bf = BaseFont.createFont(FONT, BaseFont..IDENTITY_H, BaseFont.EMBEDDED);
//	        Font f = new Font(bf, 12);
//	        Paragraph p = new Paragraph(htmlString, f);
	        InputStream s = new ByteArrayInputStream(htmlString.getBytes());
	        BufferedOutputStream bos = null;
	        List<Element> footerElementList = null;
	        List<Element> headerElementList = null;
	        System.out.println(headerString);
	        try {

	            if (footerString != null && (footerString.equals("") == false)) {
	                footerElementList = HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(footerString.getBytes())), new StyleSheet());
	            }

	            if (headerString != null && (headerString.equals("") == false)) {
	                headerElementList = HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(headerString.getBytes())), new StyleSheet());
	            }

	            
	            document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin() + headerHeight, document.bottomMargin() + footerHeight);
	            System.out.println("Header heights" + document.topMargin() + " " + headerHeight);
	            System.out.println("footerr heights" + document.bottomMargin()  + " " + footerHeight);
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            ByteArrayOutputStream output = new ByteArrayOutputStream();
	            
	                    
	            try {
	               // System.out.println(htmlString);
	                PdfWriter writer = PdfWriter.getInstance(document, baos);
	                EndPage endPage = new EndPage();
	                endPage.footerElementList = footerElementList; 
	                endPage.headerElementList = headerElementList;
	                writer.setPageEvent(endPage);
	                document.open();
	              // document.addHeader("", arg1)
	                
	               // latest change to print DELTA- 2 lines by adding htm head info
//	                XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
//	               // worker.parseXHtml(writer, document, s);
//	                worker.parseXHtml(writer, document, s,Charset.forName("cp1252"));

	                
	                ///DataProcessing/
	                
	                /*this change didn't work
	                 * 
	                 *    ITextRenderer renderer = new ITextRenderer();
	                     renderer.getFontResolver().addFont("c:/work/fonts/TIMES.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	               */
	                
	                
	                
	              /* this change didn't work
	               * 
	               *  XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
	                InputStream is = new ByteArrayInputStream(htmlString.getBytes("UTF-8"));
	                worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));*/
	                
	              /*  this change didn't work
	               *  XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
	                fontImp.register("/DataProcessing/FreeSans.ttf");
	                XMLWorkerHelper.getInstance().parseXHtml(writer, document,
	                        new FileInputStream(htmlString), null, Charset.forName("UTF-8"), fontImp);*/
	                
	                
	             
	                
	                
	                
	                
	               /* this change didn't work*/
	                 // document.add(p);
	                
	                
//	               HTMLWorker htmlWorker = new HTMLWorker(document);
//	                htmlWorker.parse(new StringReader(p.toString()));
//	               
	                
	                
	                	
//	              String FONT = "C:\\Users\\P.S.KHURANA\\Downloads\\arial.ttf"; // add arial
//	             BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//	             Font f = new Font(bf, 12);
//	             Paragraph p1 = new Paragraph("",f);
//	                
//	                ElementList list = XMLWorkerHelper.parseToElementList(htmlString, null);
//	                for (Element element : list) {
//	                    p1.add(element);
//	                }
//	                
//	              // Paragraph para = new Paragraph(p1.toString(), f);
//	               document.add(p1);
	        /*        original parsing  process      */
	              
//	         List<Element> elementlist =  HTMLWorker.parseToList(new InputStreamReader(s), new StyleSheet());
//	                for (int i = 0; i < elementlist.size(); i++) {
//	                    Element element = (Element) elementlist.get(i);
//	                    if (elementlist.size() > 0) {
//	                        document.add(element);
//	                    }
//	                }
	                CSSResolver cssResolver =
	                        XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
	         
	                
	                XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
	                fontProvider.register(PropertiesHelper.getFontFile(), "Arial");
	                //fontProvider.register("resources/fonts/PT_Serif-Web-Regular.ttf", "Serif");
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
	                if(p==null)
	                	System.out.println("p is null");
	                if(s== null)
	                {
	                	System.out.println("nullll");
	                }
	                p.parse(s);
	                
	            } catch (DocumentException e) {
	                //returnStatus = null;
	                Log(Level.WARNING, e);
	                e.printStackTrace();
	            }

	            document.close();
	            byte[] pdfData = baos.toByteArray();
	            
	            finalPdfArray.add(pdfData);
	            
	          /*  if(oldpdf!=null)
	            {
	            addendumoutputstream.write( pdfData );
	            newdata = addendumoutputstream.toByteArray( );
	            }
	            
	            if(newdata!=null)
	            	pdfData=newdata;*/
	            
	            if(finalPdfArray.size()>0)
	            {
	            output= mergeMyFiles(finalPdfArray, output);	
	            pdfData=output.toByteArray();
	            }
	            
	            
	            MongoXmlHandler.getInstance().savePDFFile(pdfFileName, pdfData);
	            returnStatus = "success";

	        } catch (IOException e) {
	            //  returnStatus = null;
	            Log(Level.SEVERE, e);
	            //e.printStackTrace();

	        } finally {

	            try {
	                if (document != null) {
	                    document.close();
	                }
	            } catch (Exception e) {
	                //  returnStatus = null;
	                //e.printStackTrace();
	                Log(Level.SEVERE, e);
	            }

	            try {
	                if (bos != null) {
	                    
	                    bos.close();
	                }
	            } catch (IOException e) {
	                //  returnStatus = null;
	                Log(Level.SEVERE, e);
	               // e.printStackTrace();
	            }
	            
	        }

	        return returnStatus;
	    }



	 
	 private static ByteArrayOutputStream mergeMyFilesfilesupload(List<byte[]> filesTobeMerges,
				ByteArrayOutputStream byteArrayOutputStream) {
			// TODO Auto-generated method stub
			//System.out.println("Starting To Merge Files...");
			//System.out.println("Total Number Of Files To Be Merged..."+ filesToBeMerged.length + "\n");D:\root\investigationDetails\watermark\duplicateStamp.jpg D:\NEW_INVESTIGATION_21_05-2015\AHIMS\WebContent\new_investigation\images\duplicateStamp.jpg
			
			
			try {
				//Image img = Image.getInstance(InvestigationConfig.fetchfilepath+"duplicateStamp.jpg");	      
			   //  img.setAbsolutePosition(23,725);
			     
			    // Watermark watermark=new Watermark(img, 25, 725);
				int pageOffset = 0;
				ArrayList masterBookMarkList = new ArrayList();

				int fileIndex = 0;
				//String outFile = mergedFileLocation;
				Document document = null;
				PdfCopy writer = null;
				PdfReader reader = null;
				OutputStream output = new ByteArrayOutputStream(); 

				for (fileIndex = 0; fileIndex < filesTobeMerges.size(); fileIndex++) {

					
					/**
					 * Create a reader for the file that we are reading
					 */
					reader = new PdfReader(filesTobeMerges.get(fileIndex),"Administrator".getBytes()); //filesToBeMerged[fileIndex]
			//		System.out.println("Reading File -");

					/**
					 * Replace all the local named links with the actual
					 * destinations.
					 */
					reader.consolidateNamedDestinations();

					/**
					 * Retrieve the total number of pages for this document
					 */
					int totalPages = reader.getNumberOfPages();


					 int n = reader.getNumberOfPages();
					 PdfStamper stamp = new PdfStamper(reader,output);
					  int i = 1;
				      
				      
					if(fileIndex==0)
					{

					      while (i <= n) 
					      {
					    	  
					    	  PdfGState gs = new PdfGState();
						        gs.setFillOpacity(0.8f);
						        
						        PdfContentByte  over = stamp.getUnderContent(i);
						        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
							      
					    	  over.setGState(gs);
					    	  over.beginText();
					    	  over.setFontAndSize(bf, 100);
					    	  over.setColorFill(new BaseColor(255,200,200));	
					    	  over.showTextAligned(Element.ALIGN_CENTER, "Cancelled", 300, 700, 0);
					    	  over.endText();
					    	  stamp.close();
						        
					    	  i++;

					    	   
					      }
						 
				 	
		            
			    //    stamp.close();
			        
					}
					
			        reader = new PdfReader(((ByteArrayOutputStream)output).toByteArray()); 
			        output.flush();
			        
				     
					
					/**
					 * Get the list of bookmarks for the current document If the
					 * bookmarks are not empty, store the bookmarks into a master
					 * list
					 */
					
			//		System.out.println("Checking for bookmarks...");				
					List bookmarks = SimpleBookmark.getBookmark(reader);
					if (bookmarks != null) {
						if (pageOffset != 0)
							SimpleBookmark.shiftPageNumbers(bookmarks, pageOffset,
									null);
						masterBookMarkList.addAll(bookmarks);
			//			System.out.println("Bookmarks found and storing...");
					} else {
			//			System.out.println("No bookmarks in this file...");
					}
					pageOffset += totalPages;

					/**
					 * Merging the files to the first file. If we are passing file1,
					 * file2 and file3, we will merge file2 and file3 to file1.
					 */
					if (fileIndex == 0) {
						/**
						 * Create the document object from the reader
						 */
						document = new Document(reader.getPageSizeWithRotation(1));

						/**
						 * Create a pdf write that listens to this document. Any
						 * changes to this document will be written the file
						 * 
						 * outFile is a location where the final merged document
						 * will be written to.
						 */

						System.out.println("Creating an empty PDF...");
						writer = new PdfCopy(document,
								byteArrayOutputStream);
						/**
						 * Open this document
						 */
						
						//writer.add(watermark);
						document.open();
						//document.add(img);
						//document.add(watermark);
					}
					/**
					 * Add the conent of the file into this document (writer). Loop
					 * through multiple Pages
					 */
			//		System.out.println("Merging File: ");
					PdfImportedPage page;
					for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
						page = writer.getImportedPage(reader, currentPage);					
						writer.addPage(page);					
					}

					/**
					 * This will get the documents acroform. This will return null
					 * if no acroform is part of the document.
					 * 
					 * Acroforms are PDFs that have been turned into fillable forms.
					 */
				//	System.out.println("Checking for Acroforms");
					PRAcroForm form = reader.getAcroForm();
					if (form != null) {
						writer.addDocument(reader);
			//			System.out.println("Acroforms found and copied");
					} else
			//			System.out.println("Acroforms not found for this file");

					System.out.println();
				}
				/**
				 * After looping through all the files, add the master bookmarklist.
				 * If individual PDF documents had separate bookmarks, master
				 * bookmark list will contain a combination of all those bookmarks
				 * in the merged document.
				 */
				if (!masterBookMarkList.isEmpty()) {
					writer.setOutlines(masterBookMarkList);
				//	System.out.println("All bookmarks combined and added");

				} else {
				
					
					//System.out.println("No bookmarks to add in the new file");

				}

				/**
				 * Finally Close the main document, which will trigger the pdfcopy
				 * to write back to the filesystem.
				 */
				if(document!=null)
				document.close();

				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return byteArrayOutputStream;
		}


	 
	public synchronized static String saveFileToFTPLocation(String headerString,String footerString,String htmlString,String pdfFileurl, String pdfFtpurl, String pdfFileName, float footerHeight,float headerHeight) throws IOException, FtpException
		{
			String returnStatus = null;
			String pagewidthprinting=null;
	        String pagewidthheight=null;
			
			//Document document = new Document(new Rectangle(Float.parseFloat(pagewidthprinting), Float.parseFloat(pagewidthheight))); 
	        Document document = null;
	      float  footerHeight1=Float.parseFloat( Config.FOOTER_HEIGHT);
			
			   if(htmlString == null )
		        {
		            Log(Level.SEVERE, "Empty HTML String");
		            return null;
		        }
		        
		        if (pagewidthheight == null) {
		            document = new Document(PageSize.A4);
		        } else {
		            document = new Document(new Rectangle(Float.parseFloat(pagewidthprinting), Float.parseFloat(pagewidthheight))); // specify the page size
		        }
		        
		  
		        
		        htmlString=htmlString.replace("&amp;","&");
		      //for text area line breaks 
		        htmlString=htmlString.replace("\r\n","<br/>");
		        
		        // For 2D ECHO Test
		        htmlString=htmlString.replace("less than","&lt;");
		        htmlString=htmlString.replace("greater than","&gt;");
		        htmlString=htmlString.replace("Greater Than","&gt;");
		        
		        
		        System.out.println("the main html string is :  "+htmlString);
		        
		        List <byte[]> finalPdfArray= new ArrayList<byte[]>();
		      
		    //    String htmlStart="<html><head><meta http-equiv='content-type' content='application/xhtml+xml; charset=UTF-8'/></head><body style=\"font-size:12.0pt; font-family:Arial\"><br /><br /><br /><br />";
		        String htmlStart="<div style=\"font-size:12.0pt; font-family:Times New Roman\">";//"<html><head><meta http-equiv='content-type' content='application/xhtml+xml; charset=UTF-8'/></head><body style=\"font-family:Arial\">";
		        String htmlEnd="</div>";
			// specify the page size
			InputStream s = new ByteArrayInputStream((htmlString).getBytes()); 
			BufferedOutputStream bos = null ;
			List<Element>footerElementList=null;
			List<Element>headerElementList=null;
			System.out.println("headerString14>>>>>> :: "+headerString);
			
			try {
				
				if(footerString!=null && (footerString.equals("")==false))
					footerElementList=HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(footerString.getBytes())), new StyleSheet());
				
				if(headerString != null && (headerString.equals("")==false))
					headerElementList=HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(headerString.getBytes())), new StyleSheet());
				
				//document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin()+headerHeight, document.bottomMargin()+footerHeight);
				
				document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin() + headerHeight, document.bottomMargin() + footerHeight);
	            System.out.println("Header heights" + document.topMargin() + " " + headerHeight);
	            System.out.println("footerr heights" + document.bottomMargin()  + " " + footerHeight);
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            ByteArrayOutputStream output = new ByteArrayOutputStream();
	            
				
				URL urlftp =new URL(pdfFtpurl+"/"+pdfFileName);
				URLConnection urlc=	urlftp.openConnection();
				
			
				
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
					/*String[] folder=pdfFileurl.replace("/", "#").split("#");
					createDirectoryStructure(folder[2],folder);
					*/
					String[] folder=pdfFileurl.replace("/", "#").split("#");
					
					if(folder[2]!=null && folder[2].replace("@", "#").split("#").length>1)
					createDirectoryStructure(folder[2].replace("@", "#").split("#")[1],folder);
					else
					createDirectoryStructure(folder[2],folder);	
					
					bos=new BufferedOutputStream(urlc.getOutputStream());
				}
				
				
				try {
					
					PdfWriter writer =PdfWriter.getInstance(document,	bos);
					EndPage endPage=new  EndPage();
					endPage.footerElementList=footerElementList;
					endPage.headerElementList=headerElementList;
					writer.setPageEvent(endPage);	
					document.open();
					
					
					

			        
			        CSSResolver cssResolver =
	                        XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
	         
	                
	                XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
	                fontProvider.register(PropertiesHelper.getFontFile(), "Arial");
	                //fontProvider.register("resources/fonts/PT_Serif-Web-Regular.ttf", "Serif");
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
	                if(p==null)
	                	System.out.println("p is null");
	                if(s== null)
	                {
	                	System.out.println("nullll");
	                }
	                p.parse(s);
	                
	            } 
					
				
					/*List<Element> elementlist = HTMLWorker.parseToList(new InputStreamReader(s), new StyleSheet()); 
				        for (int i = 0; i < elementlist.size(); i++) 
				        {
							Element element = (Element)elementlist.get(i); 
					        if(elementlist.size()>0) 
					        { 
					                document.add(element);  
					        } 
				    	
						}
				        
				         */
		             
				catch (DocumentException e) 
				{
					e.printStackTrace();
				}
				
				document.close();
				returnStatus = "success";
				Log(Level.INFO, "end of function saveFileToFTPLocation : PDF File Saved on FTP server.");
				
			} 
			
			finally
			{

				try
				{
				if(document!=null)
					document.close();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				try
				{
				if(bos!=null)
					bos.close();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			
			return returnStatus;
		}

	 
	 
	 public synchronized static String saveFileToFTPLocationnew(String headerString, String footerString, String htmlString, String pdfFileName,
			 float footerHeight, float headerHeight, float headerwidth, float footerWidth, String pageHeight, String pageWidth,
			 InputStream oldpdf,String fileuploaddata,String isfileuploadprint,String isfirstpageprint,String pdfFtpurl,String pdfFileurl, String testName) throws IOException, DocumentException {
	        Document document = null;
	        //String testName="Complete Blood Count";
	       
	        
	      float  footerHeight1=Float.parseFloat( Config.FOOTER_HEIGHT);
	        String returnStatus = null;
	        if(htmlString == null )
	        {
	            Log(Level.SEVERE, "Empty HTML String");
	            return null;
	        }
	        
	        if (pageHeight == null) {
	            document = new Document(PageSize.A4);
	        } else {
	            document = new Document(new Rectangle(Float.parseFloat(pageWidth), Float.parseFloat(pageHeight))); // specify the page size
	        }
	       
	        
	        

		/*
		 * if (testName != null) { htmlString =
		 * "<table style='width: 100%; text-align: center;'><tr><td colspan='1' width='10%' align='center'> "
		 * + testName + "</td></tr></table>" + htmlString; } else { htmlString =
		 * htmlString; }
		 */
	             
	           htmlString=htmlString.replace("&amp;","&");
	           System.out.println("htmlString >>>1:  "+htmlString);
		      //for text area line breaks 
		        htmlString=htmlString.replace("\r\n","<br/>");
		        
		        // For 2D ECHO Test
		        htmlString=htmlString.replace("less than","&lt;");
		        htmlString=htmlString.replace("greater than","&gt;");
		        htmlString=htmlString.replace("Greater Than","&gt;");
	
		       
		        //for test space  
		       htmlString="<div style='margin-top:0'>&nbsp;</div>"+ htmlString;   
		       htmlString=htmlString.replace("<br/>" ,"");
	        System.out.println("the main html string is new:  "+htmlString);
	      
	        if (headerString != null && (headerString.equals("") == false)) {
	              //  headerElementList = HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(headerString.getBytes())), new StyleSheet());
	        	htmlString=  headerString+  htmlString; 
	            } 
	        if (footerString != null && (footerString.equals("") == false)) {
	        	htmlString=htmlString+footerString;
            }
	        
		  
	        List <InputStream> finalPdfArray= new ArrayList<InputStream>();
	        if(oldpdf!=null)
	        {
	        	if(isfirstpageprint!=null && isfirstpageprint.equals("1")) 
	            {
	        
	            }
	        	else
	        	{
	        		finalPdfArray.add(oldpdf);
	        	}
	        	
	         }
            String htmlStart="<div style=\"font-size:12.0pt; font-family:Times New Roman\">";
	        String htmlEnd="</div>";
	   
	        InputStream s = new ByteArrayInputStream(htmlString.getBytes());
	        BufferedOutputStream bos = null;
	        List<Element> footerElementList = null;
	        List<Element> headerElementList = null;
	    /// for box css
	     //   htmlString="<div style='width:95%;margin-left:3%; border:1px solid;'>"+htmlString+"</div>";
	        System.out.println("headerString>45>"+headerString);
	        try {

		    	String osType = System.getProperties().getProperty("os.name");
				String filePath = "";
			/*
			 * if (osType.startsWith("Win")) { // filePath = "C:/invReport/test.pdf";
			 * filePath= pdfFtpurl+"/"+pdfFileName; } else { filePath =
			 * "/opt/Arunachal_PHDM/FileHandling/prescriptions/"; }
			 */
				filePath= pdfFtpurl+"/"+pdfFileName;
				System.out.println("filePath>>>"+filePath);
				
		        HtmlToPdf.convert(htmlString, filePath,pdfFileurl);
		        System.out.println("after convert>" );
		        //boolean flagReturn=true;
		        //if(flagReturn)
		        	
		       	//return null;
		    
	            document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin() + headerHeight, document.bottomMargin() + footerHeight);
	            System.out.println("Header heights" + document.topMargin() + " " + headerHeight);
	            System.out.println("footerr heights" + document.bottomMargin()  + " " + footerHeight);
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            ByteArrayOutputStream output = new ByteArrayOutputStream();
	            
	            
	         
	            boolean isfirstpageprintornot=false;
	           
	            
	            
	            returnStatus = "success";

	        }  
	        catch (IOException e) {
	            //  returnStatus = null;
	            Log(Level.SEVERE, e);
	            //e.printStackTrace();

	        } finally {

	            try {
	                if (document != null) {
	                    document.close();
	                }
	            } catch (Exception e) {
	                Log(Level.SEVERE, e);
	            }

	            try {
	                if (bos != null) {
	                    
	                    bos.close();
	                }
	            } catch (IOException e) {
	                //  returnStatus = null;
	                Log(Level.SEVERE, e);
	               // e.printStackTrace();
	            }
	            
	        }

	        return returnStatus;
	    }

	 
	 private synchronized static void createDirectoryStructure(String ftpserver, String[] folders) {
			JakartaFTPWrapper ftp = null;
			try {
				 ftp = new JakartaFTPWrapper();
		
				
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

	 
	 private static ByteArrayOutputStream mergeMyFilesFTP(List<InputStream> filesTobeMerges,
				ByteArrayOutputStream byteArrayOutputStream) {
			// TODO Auto-generated method stub
		//	System.out.println("Starting To Merge Files...");
			//System.out.println("Total Number Of Files To Be Merged..."+ filesToBeMerged.length + "\n");D:\root\investigationDetails\watermark\duplicateStamp.jpg D:\NEW_INVESTIGATION_21_05-2015\AHIMS\WebContent\new_investigation\images\duplicateStamp.jpg
			
			
			try {
				//Image img = Image.getInstance(InvestigationConfig.fetchfilepath+"duplicateStamp.jpg");	      
			   //  img.setAbsolutePosition(23,725);
			     
			    // Watermark watermark=new Watermark(img, 25, 725);
				int pageOffset = 0;
				ArrayList masterBookMarkList = new ArrayList();

				int fileIndex = 0;
				//String outFile = mergedFileLocation;
				Document document = null;
				PdfCopy writer = null;
				PdfReader reader = null;

				for (fileIndex = 0; fileIndex < filesTobeMerges.size(); fileIndex++) {

					
					/**
					 * Create a reader for the file that we are reading
					 */
					reader = new PdfReader(filesTobeMerges.get(fileIndex),"Administrator".getBytes()); //filesToBeMerged[fileIndex]
			//		System.out.println("Reading File -");

					/**
					 * Replace all the local named links with the actual
					 * destinations.
					 */
					reader.consolidateNamedDestinations();

					/**
					 * Retrieve the total number of pages for this document
					 */
					int totalPages = reader.getNumberOfPages();

				
					
					
					
					/**
					 * Get the list of bookmarks for the current document If the
					 * bookmarks are not empty, store the bookmarks into a master
					 * list
					 */
					
					System.out.println("Checking for bookmarks...");				
					List bookmarks = SimpleBookmark.getBookmark(reader);
					if (bookmarks != null) {
						if (pageOffset != 0)
							SimpleBookmark.shiftPageNumbers(bookmarks, pageOffset,
									null);
						masterBookMarkList.addAll(bookmarks);
			//			System.out.println("Bookmarks found and storing...");
					} else {
			//			System.out.println("No bookmarks in this file...");
					}
					pageOffset += totalPages;

					/**
					 * Merging the files to the first file. If we are passing file1,
					 * file2 and file3, we will merge file2 and file3 to file1.
					 */
					if (fileIndex == 0) {
						/**
						 * Create the document object from the reader
						 */
						document = new Document(reader.getPageSizeWithRotation(1));

						/**
						 * Create a pdf write that listens to this document. Any
						 * changes to this document will be written the file
						 * 
						 * outFile is a location where the final merged document
						 * will be written to.
						 */

				//		System.out.println("Creating an empty PDF...");
						writer = new PdfCopy(document,
								byteArrayOutputStream);
						/**
						 * Open this document
						 */
						
						//writer.add(watermark);
						document.open();
						//document.add(img);
						//document.add(watermark);
					}
					/**
					 * Add the conent of the file into this document (writer). Loop
					 * through multiple Pages
					 */
				//	System.out.println("Merging File: ");
					PdfImportedPage page;
					for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
						page = writer.getImportedPage(reader, currentPage);					
						writer.addPage(page);					
					}

					/**
					 * This will get the documents acroform. This will return null
					 * if no acroform is part of the document.
					 * 
					 * Acroforms are PDFs that have been turned into fillable forms.
					 */
				//	System.out.println("Checking for Acroforms");
					PRAcroForm form = reader.getAcroForm();
					if (form != null) {
						writer.addDocument(reader);
						System.out.println("Acroforms found and copied");
					} else
				//		System.out.println("Acroforms not found for this file");

					System.out.println();
				}
				/**
				 * After looping through all the files, add the master bookmarklist.
				 * If individual PDF documents had separate bookmarks, master
				 * bookmark list will contain a combination of all those bookmarks
				 * in the merged document.
				 */
				if (!masterBookMarkList.isEmpty()) {
					writer.setOutlines(masterBookMarkList);
				//	System.out.println("All bookmarks combined and added");

				} else {
			//		System.out.println("No bookmarks to add in the new file");

				}

				/**
				 * Finally Close the main document, which will trigger the pdfcopy
				 * to write back to the filesystem.
				 */
				if(document!=null)
				document.close();

				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return byteArrayOutputStream;
		}

	 
	 public static byte[] getReport(String filename) throws IOException
		{
			byte[] byteArray=null;
			         
			byteArray = MongoXmlHandler.getInstance().latestFetchFileByte(filename);
			    	
		    return byteArray;
		}

	 
	//check pdf save -- convert string to bytearray thn to pdf
			public static void byteArrayToFile(String name) {  
			    try { 
			    	  
			    	byte[] bytearray=org.apache.commons.codec.binary.Base64.decodeBase64(name);
			        OutputStream out = new FileOutputStream(PropertiesHelper.getFTPSaveTempPDFFilePath());
			        out.write(bytearray);
			        out.close();  
			    } catch (Exception e) {  
			        System.err.println("Error: " + e.getMessage());  
			    }  
			}
			
			public static void byteArrayToFileXML(String name) {  
			    try { 
			    	  
			    	byte[] bytearray=org.apache.commons.codec.binary.Base64.decodeBase64(name);
			        OutputStream out = new FileOutputStream(PropertiesHelper.getFTPSaveTempXMLFilePath());
			        out.write(bytearray);
			        out.close();  
			    } catch (Exception e) {  
			        System.err.println("Error: " + e.getMessage());  
			    }  
			}
			
			public static String convertInputStreamReaderToString(InputStreamReader inputStreamReader) throws IOException {
		        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		        StringBuilder stringBuilder = new StringBuilder();
		        String line;
		        while ((line = bufferedReader.readLine()) != null) {
		            stringBuilder.append(line);
		            stringBuilder.append(System.lineSeparator());
		        }
		        return stringBuilder.toString();
		    }	
			
			
			
			 public synchronized static String saveFileToFTPLocationnewold(String headerString, String footerString, String htmlString, String pdfFileName,
					 float footerHeight, float headerHeight, float headerwidth, float footerWidth, String pageHeight, String pageWidth,
					 InputStream oldpdf,String fileuploaddata,String isfileuploadprint,String isfirstpageprint,String pdfFtpurl,String pdfFileurl) throws IOException, DocumentException {
			        Document document = null;
			    
			        
			      float  footerHeight1=Float.parseFloat( Config.FOOTER_HEIGHT);
			        String returnStatus = null;
			        if(htmlString == null )
			        {
			            Log(Level.SEVERE, "Empty HTML String");
			            return null;
			        }
			        
			        if (pageHeight == null) {
			            document = new Document(PageSize.A4);
			        } else {
			            document = new Document(new Rectangle(Float.parseFloat(pageWidth), Float.parseFloat(pageHeight))); // specify the page size
			        }
			        
			        
			        // for dynamic test template( canned file issue)
			     
			     /* htmlString=htmlString.replace("<","&lt;");
			        htmlString=htmlString.replace(">","&gt;");
			     */
			        
			        
			       
			             
			           htmlString=htmlString.replace("&amp;","&");
			           System.out.println("htmlString >>>1:  "+htmlString);
				      //for text area line breaks 
				        htmlString=htmlString.replace("\r\n","<br/>");
				        
				        // For 2D ECHO Test
				        htmlString=htmlString.replace("less than","&lt;");
				        htmlString=htmlString.replace("greater than","&gt;");
				        htmlString=htmlString.replace("Greater Than","&gt;");
			
				        
				        htmlString="<div style='margin-top:0px'>&nbsp;</div>"+ htmlString;   
				        
			        System.out.println("the main html string is new:  "+htmlString);
			      
			        if (headerString != null && (headerString.equals("") == false)) {
			              //  headerElementList = HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(headerString.getBytes())), new StyleSheet());
			        	htmlString=  headerString+  htmlString; 
			            } 
			        if (footerString != null && (footerString.equals("") == false)) {
			        	htmlString=htmlString+footerString;
		            }
			        
			    	        
			      
			        List <InputStream> finalPdfArray= new ArrayList<InputStream>();
			        if(oldpdf!=null)
			        {
			        	if(isfirstpageprint!=null && isfirstpageprint.equals("1")) 
			            {
			        
			            }
			        	else
			        	{
			        		finalPdfArray.add(oldpdf);
			        	}
			        	
			         }
		            String htmlStart="<div style=\"font-size:12.0pt; font-family:Times New Roman\">";
			        String htmlEnd="</div>";
			   
			        InputStream s = new ByteArrayInputStream(htmlString.getBytes());
			        BufferedOutputStream bos = null;
			        List<Element> footerElementList = null;
			        List<Element> headerElementList = null;
			      

			        System.out.println("headerString>45>"+headerString);
			        try {

			        if (footerString != null && (footerString.equals("") == false)) {
			                footerElementList = HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(footerString.getBytes())), new StyleSheet());
			                
			            }

			           if (headerString != null && (headerString.equals("") == false)) {
			                headerElementList = HTMLWorker.parseToList(new InputStreamReader(new ByteArrayInputStream(headerString.getBytes())), new StyleSheet());
			             
			            } 
			        	
			            
			            document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin() + headerHeight, document.bottomMargin() + footerHeight);
			            System.out.println("Header heights" + document.topMargin() + " " + headerHeight);
			            System.out.println("footerr heights" + document.bottomMargin()  + " " + footerHeight);
			            ByteArrayOutputStream baos = new ByteArrayOutputStream();
			            ByteArrayOutputStream output = new ByteArrayOutputStream();
			            
			            
			         
			            boolean isfirstpageprintornot=false;
			            
						
							URL urlftp =new URL(pdfFtpurl+"/"+pdfFileName);
							System.out.println("urlftp>>123>>>"+urlftp);
							System.out.println("pdfFileName>>345>>>"+pdfFileName);
							URLConnection urlc=	urlftp.openConnection();
							
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
								/*String[] folder=pdfFileurl.replace("/", "#").split("#");
								createDirectoryStructure(folder[2],folder);
								*/
								String[] folder=pdfFileurl.replace("/", "#").split("#");
								
								if(folder[2]!=null && folder[2].replace("@", "#").split("#").length>1)
								createDirectoryStructure(folder[2].replace("@", "#").split("#")[1],folder);
								else
								createDirectoryStructure(folder[2],folder);	
								
								bos=new BufferedOutputStream(urlc.getOutputStream());
							}
							
			            try {
			               // System.out.println(htmlString);
			            	
			                //PdfWriter writer = PdfWriter.getInstance(document, baos); chnaged for ftp
			            	PdfWriter writer = PdfWriter.getInstance(document, bos);
			                EndPage endPage = new EndPage();
			                endPage.footerElementList = footerElementList; 
			                endPage.headerElementList = headerElementList;
			                writer.setPageEvent(endPage);
			                document.open();
			                CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
			             
			                XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
			                fontProvider.register(PropertiesHelper.getFontFile(), "Arial");
			                //fontProvider.register("resources/fonts/PT_Serif-Web-Regular.ttf", "Serif");
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
			                if(p==null)
			                	System.out.println("p is null");
			                if(s== null)
			                {
			                	System.out.println("nullll");
			                }
			                p.parse(s);
			                
			            } catch (DocumentException e) {
			                //returnStatus = null;
			                Log(Level.WARNING, e);
			                e.printStackTrace();
			            }

			            document.close();
		        		URL urlftp1 =new URL(pdfFtpurl+"/"+pdfFileName);
						URLConnection urlc1=	urlftp1.openConnection();
			            
			            
			            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
						InputStream is = null;
						try {
						  is = urlftp1.openStream ();
						  byte[] byteChunk = new byte[4897]; // Or whatever size you want to read in at a time.
						  int n;

						  while ( (n = is.read(byteChunk)) > 0 ) {
							  baos1.write(byteChunk, 0, n);
						  }
						}
						catch (IOException e) {
						  System.err.printf ("Failed while reading bytes from %s: %s", urlftp1.toExternalForm(), e.getMessage());
						  e.printStackTrace ();
						  // Perform any other exception handling that's appropriate.
						}
						finally {
						  if (is != null) { is.close(); }
						}

				
						
			            byte[] pdfData1 = baos1.toByteArray();
		      
			            if(isfirstpageprint!=null && isfirstpageprint.equals("1"))
			            {
			            	isfirstpageprintornot=true;
			            }
			            else
			            {
			            	InputStream is1 = null;
			                is1 = new ByteArrayInputStream(pdfData1);
			            	finalPdfArray.add(is1);
			            }
			      
			            
			            if(isfileuploadprint!=null && !isfileuploadprint.equals("0"))
			            {
			            	if(fileuploaddata!=null && !fileuploaddata.equals(""))
			            {
			            	
			            	if(fileuploaddata.contains("#@#"))
			            	{
			            		for(int k=0;k<fileuploaddata.split("#@#").length;k++)
			            		{
			            			 byte fileupload[]=null;
			                         fileupload = org.apache.commons.codec.binary.Base64.decodeBase64(fileuploaddata.split("#@#")[k]);
			                          
			                         if(fileupload!=null)
			                         {
			                        	  	InputStream is1 = null;
			            	                is1 = new ByteArrayInputStream(fileupload);
			            	            	finalPdfArray.add(is1);
			            	            
			                         }
			                       
			            		}
			            	}
			            	else
			            	{
			            		 byte fileupload[]=null;
			                    fileupload = org.apache.commons.codec.binary.Base64.decodeBase64(fileuploaddata);
			                     
			                    if(fileupload!=null)
			                    {
			                     	InputStream is1 = null;
		     	                is1 = new ByteArrayInputStream(fileupload);
		     	            	finalPdfArray.add(is1);
			                    }

			            	}
			            	
			            }
			            }
			            
		     
			            if(finalPdfArray.size()>0)
			            {
			            	
			            	if(isfirstpageprintornot==true && oldpdf!=null)
			            output= mergeMyFilesFTP(finalPdfArray, output);	
			            	else
			            output= mergeMyFilesFTP(finalPdfArray, output);
			      
			            
			        	URL urlftp11 =new URL(pdfFtpurl+"/"+pdfFileName);
						URLConnection urlc11=	urlftp11.openConnection();
				        BufferedOutputStream bos11 = null;

							try
						{
							bos11=new BufferedOutputStream(urlc11.getOutputStream());
							
						}
						catch(Exception ex)
						{
							System.out.println("catch");
							ex.printStackTrace();
						}
							bos11.write(output.toByteArray());
							
		             if (bos11 != null) {
			                    
		             	bos11.close();
			                }
							
			            }
			            
			            
			            returnStatus = "success";

			        }  
			        catch (IOException e) {
			            //  returnStatus = null;
			            Log(Level.SEVERE, e);
			            //e.printStackTrace();

			        } finally {

			            try {
			                if (document != null) {
			                    document.close();
			                }
			            } catch (Exception e) {
			                Log(Level.SEVERE, e);
			            }

			            try {
			                if (bos != null) {
			                    
			                    bos.close();
			                }
			            } catch (IOException e) {
			                //  returnStatus = null;
			                Log(Level.SEVERE, e);
			               // e.printStackTrace();
			            }
			            
			        }

			        return returnStatus;
			    }	
			
	 
}
