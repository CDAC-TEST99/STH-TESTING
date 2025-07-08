package hisglobal.utility;

import java.io.FileOutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

public class HtmlToPdf {

	public static void convert(String htmlContent, String pdfFile) throws Exception {

		Document document = new Document(com.itextpdf.text.PageSize.A4);

		FileOutputStream fos = new FileOutputStream(pdfFile);

		PdfWriter.getInstance(document, fos);

		document.open();

		// **********************************************************
		// if required, you can add document meta data
		document.addAuthor("Balasubramaniam M");
		// document.addCreator( creator );
		document.addSubject("CDAC");
		document.addCreationDate();
		document.addTitle("e-Sushrut Clinic");
		// **********************************************************/

		 HTMLWorker htmlWorker = new  HTMLWorker(
				document);
		htmlWorker.parse(new StringReader(htmlContent));

		document.close();
		fos.close();

	}
	 

	// let's test !!

	public static void main(String[] args) throws Exception {
		convert("<html> " + "<body > " + "<center> "
				+ "<table width=\"85%\"   border=\"1\" style='border-collapse:collapse'  >  " + " <tbody> " + "  "
				+ "  <tr >  " + " " + "    <td colspan=\"4\"  ><center><h3>e-Sushrut Clinic</h3></center></td> "
				+ "  </tr> " + "  " + " <tr >  " + " "
				+ "    <td colspan=\"4\"><h4>Institute Registration Details<h4></td> " + "  </tr> " + "  <tr>  "
				+ "    <td  width=\"25%\"> Institute Registration ID </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\"><b>220321000001</b>  " + "     " + "    </td> " + "    "
				+ "    <td  width=\"25%\"> Registration Date </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">21-Mar-2022 11:45:28 </td> " + "  </tr> " + "   "
				+ "   <tr>  " + "    <td  width=\"25%\"> Institute Type </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">Lab </td> " + "   "
				+ "    <td  width=\"25%\"> GST No. </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">07AABCU9603R1ZP </td> " + "  </tr> " + "   " + "  <tr>  "
				+ "    <td  width=\"25%\"> Institute Name </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">Dr Lalpath Labs </td> " + "   "
				+ "    <td  width=\"25%\"> Institute Short Name </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">Lalpath </td> " + "  </tr> " + "   " + "  <tr>  "
				+ "    <td  width=\"25%\"> Institute Address Line 1 </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">Lal path labs, new ring road, </td> " + "    "
				+ "    <td  width=\"25%\"> Institute Address Line 2 </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">ashok nagar, delhi 110031  </td> " + "  </tr> " + "   "
				+ "  <tr>  " + "    <td  width=\"25%\"> Pin Code </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">110031 </td> " + "   "
				+ "    <td  width=\"25%\"> City </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">Delhi </td> " + "  </tr> " + "   " + "   <tr>  "
				+ "    <td  width=\"25%\"> District </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">New Delhi </td> " + "    "
				+ "    <td  width=\"25%\"> State </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">Delhi </td> " + "  </tr> " + "   " + "   " + "   <tr>  "
				+ "    <td  width=\"25%\"> Contact Person </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">Dr Lal Path Labs </td> " + "    "
				+ "    <td  width=\"25%\"> Phone No. </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">8373673673 </td> " + "  </tr> " + "   " + "   <tr>  "
				+ "    <td  width=\"25%\"> Fax No. </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">- </td> " + "    "
				+ "    <td  width=\"25%\"> Email </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">labs@drlalpath.com </td> " + "  </tr> " + "   " + "   <tr>  "
				+ "    <td  width=\"25%\">  Patient Handling Rate per Month  </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">  More than 1000  </td> " + "    "
				+ "    <td  width=\"25%\"> Amount Payable </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">Rs. 15000.00 </td> " + "  </tr> " + "   " + "    " + "     "
				+ "</tbody></table> " + " " + "<br/> " + "<br/> " + " "
				+ "<table width='85%'    border=\"1\" style=\"border-collapse:collapse;height:80px;\"  >  "
				+ " <tbody> " + "  " + " <tr>  " + "    <td  width=\"25%\">  Signature  </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\"> ........................</td> " + "    "
				+ "    <td  width=\"25%\"> Date & Place </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">......................... </td> " + "  </tr> " + "     "
				+ "</tbody></table> " + "</center> " + "<body> " + "</html>", "d:/test.pdf");
	}

}
