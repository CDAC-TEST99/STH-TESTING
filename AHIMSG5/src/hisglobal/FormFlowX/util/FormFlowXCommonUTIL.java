package hisglobal.FormFlowX.util;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Header;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.PdfWriter;

import hisglobal.FormFlowX.fb.FormFlowXCommonFB;
import hisglobal.FormFlowX.vo.FormFlowXUserVO;
import hisglobal.utility.HisUtil;

public class FormFlowXCommonUTIL {

	private static final int BUFFER_SIZE = 4096;
	private static final String configFileName = "usm.Configuration";

	public static void CallService(FormFlowXCommonFB fb, HttpServletRequest request, HttpServletResponse response) {

		JSONObject objDataJson = new JSONObject();

		FormFlowXUserVO objuser = FormFlowXCommonUTIL.getUserVO(request, fb);

		if (objuser == null) {
			try {
				objDataJson.put("message", "ERROR: Session Expired. Please Login Again!");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Usefulmethods.writeInResponse(response, objDataJson.toString(), true);
			return;
		}

		try {
			boolean dataNotFoundInSession = false;
			if (fb.getIsDataStoredInSession() != null && fb.getIsDataStoredInSession().equals("yes")) {
				String str = (String) request.getSession().getAttribute(fb.getServiceName());
				if (str != null) {
					dataNotFoundInSession = true;
					objDataJson = new JSONObject(str);
				}
			}

			if (dataNotFoundInSession == false) {
				JSONObject filtervo = null;
				if (fb.getInputData() != null)
					filtervo = new JSONObject(fb.getInputData());
				else
					filtervo = new JSONObject();
				filtervo.put("seatId", objuser.getSeatId());
				filtervo.put("hospitalCode", objuser.getHospitalCode());
				filtervo.put("modeFordata", fb.getInitMode());
				filtervo.put("processName", fb.getProcessName());
				if (fb.getServiceName().contains("/getData/")) {
					if (fb.getPrimaryKeys() != null && fb.getPrimaryKeys().length > 0) {
						for (int i = 0; i < fb.getPrimaryKeys().length; i++) {
							filtervo.put("pk" + i, fb.getPrimaryKeys()[i]);
						}

					}
				} else {
					String ids = "";
					if (fb.getPrimaryKeys() != null && fb.getPrimaryKeys().length > 0) {
						for (int i = 0; i < fb.getPrimaryKeys().length; i++) {
							ids += fb.getPrimaryKeys()[i] + ",";
						}
						ids = ids.substring(0, ids.length() - 1);
						filtervo.put("ids", ids);
					}
				}

				Usefulmethods objUsefulmethods = new Usefulmethods();
				objDataJson = objUsefulmethods.callService(filtervo, fb.getServiceName());
				if (fb.getIsDataStoredInSession() != null && fb.getIsDataStoredInSession().equals("yes")) {
					request.getSession().setAttribute(fb.getServiceName(), objDataJson.toString());
				}

			} /*
				 * else { System.out.println("getting " + fb.getServiceName() +
				 * " data from session"); }
				 */

		} catch (Exception e) {
			e.printStackTrace();
			try {
				objDataJson.put("message", "ERROR: Problem in service");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			Usefulmethods.writeInResponse(response, objDataJson.toString(), true);
		}
	}

	public static void callGenerateReportService(FormFlowXCommonFB fb, HttpServletRequest request,
			HttpServletResponse response) {

		JSONObject objDataJson = new JSONObject();
		JSONObject objCurrentDateJson = new JSONObject();
		JSONObject filtervo = null;

		FormFlowXUserVO objuser = FormFlowXCommonUTIL.getUserVO(request, fb);

		if (objuser == null) {
			try {
				objDataJson.put("message", "ERROR: Session Expired. Please Login Again!");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Usefulmethods.writeInResponse(response, objDataJson.toString(), true);
			return;
		}

		try {
			boolean dataNotFoundInSession = false;
			if (fb.getIsDataStoredInSession() != null && fb.getIsDataStoredInSession().equals("yes")) {
				String str = (String) request.getSession().getAttribute(fb.getServiceName());
				if (str != null) {
					dataNotFoundInSession = true;
					objDataJson = new JSONObject(str);
				}
			}

			if (dataNotFoundInSession == false) {

				if (fb.getInputData() != null)
					filtervo = new JSONObject(fb.getInputData());
				else
					filtervo = new JSONObject();
				filtervo.put("seatId", objuser.getSeatId());
				filtervo.put("hospitalCode", objuser.getHospitalCode());
				filtervo.put("modeFordata", fb.getInitMode());
				filtervo.put("processName", fb.getProcessName());
				if (fb.getServiceName().contains("/getData/")) {
					if (fb.getPrimaryKeys() != null && fb.getPrimaryKeys().length > 0) {
						for (int i = 0; i < fb.getPrimaryKeys().length; i++) {
							filtervo.put("pk" + i, fb.getPrimaryKeys()[i]);
						}

					}
				} else {
					String ids = "";
					if (fb.getPrimaryKeys() != null && fb.getPrimaryKeys().length > 0) {
						for (int i = 0; i < fb.getPrimaryKeys().length; i++) {
							ids += fb.getPrimaryKeys()[i] + ",";
						}
						ids = ids.substring(0, ids.length() - 1);
						filtervo.put("ids", ids);
					}
				}

				Usefulmethods objUsefulmethods = new Usefulmethods();
				objDataJson = objUsefulmethods.callService(filtervo, fb.getServiceName());
				objCurrentDateJson = objUsefulmethods.callService(filtervo,
						"/getData/getCurrentDate/getcurrentdateWithTime");
				if (fb.getIsDataStoredInSession() != null && fb.getIsDataStoredInSession().equals("yes")) {
					request.getSession().setAttribute(fb.getServiceName(), objDataJson.toString());
				}

			} /*
				 * else { System.out.println("getting " + fb.getServiceName() +
				 * " data from session"); }
				 */
			generateReport(objDataJson, request, objCurrentDateJson, response, filtervo, fb.getFormat());

		} catch (Exception e) {
			e.printStackTrace();
			try {
				objDataJson.put("message", "ERROR: Problem in service");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// Usefulmethods.writeInResponse(response, objDataJson.toString(), true);
		}
	}

	@SuppressWarnings("unchecked")
	public static void generateReport(JSONObject objDataJson, HttpServletRequest request, JSONObject objCurrentDateJson,
			HttpServletResponse objResponse, JSONObject filtervo, String format) throws Exception {
		int fontSize = 12;

		String tempStr = "";
		Document document = new Document(PageSize.A4.rotate());
		PdfWriter writer = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		if (format.equalsIgnoreCase("PDF")) {
			writer = PdfWriter.getInstance(document, baos);
		} else {
			HtmlWriter.getInstance(document, baos);
		}

		document.addAuthor("C-DAC");

		// Footer
		if (format.equalsIgnoreCase("PDF")) {
			HeaderFooter footer = new HeaderFooter(
					new Phrase("Page No.", FontFactory.getFont("Arial", fontSize, Font.BOLD)), true);
			footer.setBorder(Rectangle.NO_BORDER);
			footer.setAlignment(Element.ALIGN_CENTER);
			document.setFooter(footer);

		}
		if (format.equalsIgnoreCase("html")) {
			document.add(new Header(HtmlTags.JAVASCRIPT, tempStr));
			document.setJavaScript_onLoad("load()");
		}
		document.open();
		ArrayList<String> headers = new ArrayList<String>();

		JSONArray jsonArray = objDataJson.getJSONArray("data");

		JSONObject headerObject = jsonArray.getJSONObject(0);

		Iterator<String> keys = headerObject.keys();

		while (keys.hasNext()) {
			String key = keys.next();
			if (!key.equalsIgnoreCase("pkcolumn")) {
				headers.add(key);
			} else
				headers.add("SNo");

			//System.out.println("key >>>> " + key);
		}

		//System.out.println(headers);

		int width = headers.size();
		String moduleName = filtervo.getString("moduleId");

		document.add(getReportHeaderStateWise(width, request, format, objCurrentDateJson, filtervo));

		Table pbrTab = new Table(width);
		pbrTab.setAlignment(Element.ALIGN_CENTER);
		pbrTab.setPadding(0);
		pbrTab.setSpacing(1);
		pbrTab.setBorder(0);
		pbrTab.setWidth(100);
		pbrTab.setCellsFitPage(true);

		document.add(getReportTable(writer, jsonArray, headers, width));
		pbrTab.addCell(endOfReport(width));
		document.add(pbrTab);
		document.close();

		objResponse.setHeader("Expires", "0");
		objResponse.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		objResponse.setHeader("Pragma", "public");

		if (format.equalsIgnoreCase("PDF")) {
			objResponse.setContentType("application/pdf");
		} else if (format.equalsIgnoreCase("XLS")) {
			objResponse.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			objResponse.addHeader("Content-Disposition", "attachment; filename=" + moduleName + ".xls");
		} else if (format.equalsIgnoreCase("HTML")) {
			objResponse.setContentType("text/html");
			objResponse.setHeader("Content-Disposition", "inline; filename=" + moduleName + ".html");
		}
		objResponse.setContentLength(baos.size());
		ServletOutputStream out = objResponse.getOutputStream();
		baos.writeTo(out);
		out.flush();

	}

	@SuppressWarnings("unchecked")
	public static Table getReportHeaderStateWise(int cols, HttpServletRequest objRequest, String reportFormat,
			JSONObject objCurrentDateJson, JSONObject filtervo) throws Exception {
		Table tab = new Table(cols);
		tab.setAlignment(Element.ALIGN_CENTER);
		tab.setPadding(5);
		tab.setBorder(0);
		tab.setWidth(100);
		tab.setCellsFitPage(true);

		try {
			Cell pcell;

			Font fontH1 = new Font(Font.TIMES_ROMAN, 10, Font.NORMAL);
			Font fontH2 = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
			Font fontH3 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
			Font fontB = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
			fontB.setColor(Color.WHITE);
			// logo
			Image logo = null;
			try {
				logo = Image.getInstance("C:/eSushrut_Clinic/AHIMSG5/Logo/newlogo.png");
				logo.scaleToFit(200f, 200f);
			} catch (Exception e) {
				// System.out.println(" img path is " +
				// objRequest.getServletContext().getResource("/hisglobal/images/Logout.png"));
				// System.out.println("Error in getting logo");
			}

			// Date time

			JSONArray jsonArray = objCurrentDateJson.getJSONArray("data");

			JSONObject headerObject = jsonArray.getJSONObject(0);

			Iterator<String> keys = headerObject.keys();
			String Date = null;
			while (keys.hasNext()) {
				String key = keys.next();
				if (!key.equalsIgnoreCase("pkcolumn")) {
					Date = (String) headerObject.get(key);
				}

				//System.out.println("key >>>> " + key);
			}

		//	System.out.println(filtervo);

			keys = filtervo.keys();
			String filter = "";
			while (keys.hasNext()) {
				String key = keys.next();
				//System.out.println("filter vo  key>>>> " + key);

				if (!(key.equalsIgnoreCase("seatId") || key.equalsIgnoreCase("hospitalCode")
						|| key.equalsIgnoreCase("moduleId"))) {
					//System.out.println("iff >> " + key);
					filter += (key.toUpperCase()) + ":"
							+ (filtervo.get(key).toString().equals("") ? "--" : (String) filtervo.get(key)) + ",";
				}

			}

			if (filter != null && filter.length() > 0 && !filter.equals(""))
				filter = filter.substring(0, filter.length() - 1);

			//System.out.println("filter >>>> " + filter);

			// Header

			if (logo != null && (!(reportFormat.equalsIgnoreCase("XLS") || (reportFormat.equalsIgnoreCase("HTML"))))) {
				pcell = new Cell("");
				pcell.add(logo);
				pcell.setColspan(cols);
				pcell.setBorder(0);
				pcell.setWidth("20%");
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tab.addCell(pcell);
			} /*
				 * else { pcell = new Cell(""); pcell.setColspan(cols); pcell.setBorder(0);
				 * pcell.setWidth("20%"); pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 * tab.addCell(pcell); }
				 */

			/*
			 * if (reportFormat.equalsIgnoreCase("XLS")) { pcell = new Cell("");
			 * pcell.setColspan(1); pcell.setBorder(0);
			 * pcell.setHorizontalAlignment(Element.ALIGN_LEFT); tab.addCell(pcell); } else
			 * { if (logo != null) { System.out.println("Logo"); pcell = new Cell("");
			 * pcell.add(logo); pcell.setColspan(cols); pcell.setBorder(0);
			 * pcell.setHorizontalAlignment(Element.ALIGN_CENTER); tab.addCell(pcell); }
			 * else { pcell = new Cell(""); pcell.setColspan(cols); pcell.setBorder(0);
			 * pcell.setHorizontalAlignment(Element.ALIGN_LEFT); tab.addCell(pcell); } }
			 */

			if ((reportFormat.equalsIgnoreCase("XLS")) || (reportFormat.equalsIgnoreCase("HTML"))) {
				pcell = new Cell("");

				pcell.add(new Phrase("E-SUSHRUT CGHS", fontH3));
				/*
				 * pcell.add(new
				 * Phrase("Ministry of Health and Family Welfare (Govt. of India)", fontH3));
				 */

				pcell.setColspan(cols);

				pcell.setBorder(0);
				pcell.setWidth("100%");
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tab.addCell(pcell);
			}
			/*
			 * if (reportFormat.equalsIgnoreCase("XLS")) { pcell = new Cell("");
			 * pcell.setColspan(1); pcell.setBorder(0);
			 * pcell.setHorizontalAlignment(Element.ALIGN_RIGHT); tab.addCell(pcell); } else
			 * { pcell = new Cell(""); pcell.setColspan(1); pcell.setBorder(0);
			 * pcell.setHorizontalAlignment(Element.ALIGN_RIGHT); tab.addCell(pcell); }
			 */
			// filter
			if (filter != null && filter.length() > 0 && !filter.equals("")) {
				pcell = new Cell("");
				pcell.add(new Phrase("Filter : ", fontH2));
				pcell.add(new Phrase(filter, fontH1));
				pcell.setColspan((cols / 2));
				pcell.setBorder(0);
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				tab.addCell(pcell);
			}

			// date
			pcell = new Cell("");
			pcell.add(new Phrase("Report Date & Time : ", fontH2));
			pcell.add(new Phrase(Date, fontH1));
			if (filter != null && filter.length() > 0 && !filter.equals("")) {
				pcell.setColspan((cols / 2));
			} else {
				pcell.setColspan((cols));
			}
			pcell.setBorder(0);
			pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tab.addCell(pcell);

//			System.out.println(tab);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tab;
	}

	public static Table getReportTable(PdfWriter writer, JSONArray jsonArray, List<String> headers, int cols)
			throws Exception {

		Font fontTextNormal = new Font(Font.TIMES_ROMAN, 10, Font.NORMAL);
		Font fontTextBold = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);

		Table tab = new Table(cols);
		tab.setWidth(100);
		// tab.setTableFitsPage(true);
		tab.setCellsFitPage(true);
		tab.setPadding(4);

		Cell pcell = new Cell(new Phrase("\n"));

		for (String h : headers) {
			pcell = new Cell(new Phrase(h, fontTextBold));
			pcell.setBackgroundColor(Color.GRAY);
			// pcell.setBorder(0);
			tab.addCell(pcell);
		}

		tab.endHeaders();

		// int finalTotal = 0;

		if (jsonArray != null && jsonArray.length() > 0) {

			for (int i = 0; i < jsonArray.length(); i++) {

				// store each object in JSONObject
				JSONObject explrObject = jsonArray.getJSONObject(i);

				for (String h : headers) {
					if (h.equalsIgnoreCase("SNo")) {
						pcell = new Cell(new Phrase(String.valueOf(i + 1), fontTextNormal));
						tab.addCell(pcell);
					} else {
						pcell = new Cell(new Phrase(explrObject.getString(h).replaceAll("<[^>]*>", ""), fontTextNormal));
						tab.addCell(pcell);
					}
				}

			}

		} else {
			pcell = new Cell(new Phrase("******* No Record Found *******", fontTextNormal));
			pcell.setColspan(cols);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setBorder(0);
			tab.addCell(pcell);
		}

		return tab;
	}

	public static Cell endOfReport(int cols) throws Exception {
		Font fontH = new Font(Font.TIMES_ROMAN, 8, Font.BOLD);
		Cell pcell = null;
		pcell = new Cell("");
		pcell.add(new Phrase("****************************End Of Report****************************", fontH));
		pcell.setColspan(cols);
		pcell.setBorder(0);
		pcell.setWidth("100%");
		pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		return pcell;
	}

	public static JSONObject CallServiceFromOtherProcess(String processName, String serviceName,
			JSONObject filterDataJson, HttpServletRequest request) {

		JSONObject objDataJson = new JSONObject();

		FormFlowXUserVO objuser = FormFlowXCommonUTIL.getUserVO(request, null);
		if (filterDataJson == null)
			filterDataJson = new JSONObject();

		if (objuser == null) {
			try {
				objDataJson.put("message", "ERROR: Session Expired. Please Login Again!");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return objDataJson;
		}

		try {

			filterDataJson.put("seatId", objuser.getSeatId());
			filterDataJson.put("hospitalCode", objuser.getHospitalCode());
			filterDataJson.put("processName", processName);
			Usefulmethods objUsefulmethods = new Usefulmethods();
			objDataJson = objUsefulmethods.callService(filterDataJson, serviceName);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				objDataJson.put("message", "ERROR: Problem in service");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

		}
		return objDataJson;
	}

	public static void fileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// reads input file from an absolute path

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date now = new Date();
		FileInputStream inStream = null;
		String time = dateFormat.format(now);

		String filename = request.getParameter("fileName");

		//System.out.println("filename>>>>.." + filename);
		String filePath = "C:/IMCS/EMMS_DOC/" + time + "/" + filename;
		File downloadFile = new File(filePath);
		inStream = new FileInputStream(downloadFile);

		response.setContentLength((int) downloadFile.length());

		// forces download
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// obtains response's output stream
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inStream.close();
		outStream.close();

	}

	public static void downloadFileFromDrivePath(HttpServletRequest request, HttpServletResponse response_p)
			throws IOException {

		File resourceFile = null;
		FileInputStream io = null;
		try {
			String strFileName = request.getParameter("fileName");

			String osType = System.getProperties().getProperty("os.name");
			String filePath = "";
			if (osType.startsWith("Win")) {

				filePath = Usefulmethods.getQuery(configFileName, "UPLOAD_URL_WINDOWS");
			} else {
				filePath = Usefulmethods.getQuery(configFileName, "UPLOAD_URL_LINUX");

			}

			resourceFile = new File(filePath + "/" + strFileName);
			io = new FileInputStream(resourceFile);

			response_p.setHeader("Content-Disposition", "attachment;filename=" + strFileName);
			byte[] buf = new byte[4096];
			int read = 0;
			while ((read = io.read(buf)) > 0)
				response_p.getOutputStream().write(buf, 0, read);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (io != null) {
				io.close();
				io = null;
			}
			if (resourceFile != null)
				resourceFile = null;

		}

	}

	public static void downloadFileFromFTP(HttpServletRequest request, HttpServletResponse response_p)
			throws Exception {

		InputStream io = null;
		URL urlftp = null;
		URLConnection urlc = null;
		try {
			String isFileUploadOnFTP = Usefulmethods.getQuery(configFileName, "IsFileUploadOnFTP");

			if (!isFileUploadOnFTP.equalsIgnoreCase("YES")) {
				downloadFileFromDrivePath(request, response_p);
				return;
			}

			String strFileName = request.getParameter("fileName");
			// String ftpUrl = Usefulmethods.getQuery(configFileName, "FTPURL");

			String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");

			String ftpFinalDir = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FINAL_DIR");

			urlftp = new URL(ftpUrl + "/" + ftpFinalDir + "/" + strFileName);
			urlc = urlftp.openConnection();
			io = urlc.getInputStream();

			response_p.setHeader("Content-Disposition", "attachment;filename=" + strFileName);
			byte[] buf = new byte[4096];
			int read = 0;
			while ((read = io.read(buf)) > 0)
				response_p.getOutputStream().write(buf, 0, read);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (io != null) {

				io.close();
				io = null;

			}

			urlftp = null;
			urlc = null;

		}

	}

	public static void downloadFileFromTempFTP(HttpServletRequest request, HttpServletResponse response_p)
			throws Exception {

		InputStream io = null;
		URL urlftp = null;
		URLConnection urlc = null;
		try {
			String isFileUploadOnFTP = Usefulmethods.getQuery(configFileName, "IsFileUploadOnFTP");

			if (!isFileUploadOnFTP.equalsIgnoreCase("YES")) {
				downloadFileFromDrivePath(request, response_p);
				return;
			}

			String strFileName = request.getParameter("fileName");
			// String ftpUrl = Usefulmethods.getQuery(configFileName, "FTPURL");

			String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");

			String ftpFinalDir = "";
			String mode = (String) request.getParameter("mode");
			if (mode != null) {
				try {
					ftpFinalDir = Usefulmethods.getQuery(configFileName, "mode_" + mode);
				} catch (Exception e) {
					ftpFinalDir = "";
					System.out.println("mode_" + mode + " not found in config file");
				}
			}

			urlftp = new URL(ftpUrl + ftpFinalDir + "/FTPTEMP_" + strFileName);
			urlc = urlftp.openConnection();
			io = urlc.getInputStream();

			response_p.setHeader("Content-Disposition", "attachment;filename=" + strFileName);
			byte[] buf = new byte[4096];
			int read = 0;
			while ((read = io.read(buf)) > 0)
				response_p.getOutputStream().write(buf, 0, read);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (io != null) {

				io.close();
				io = null;

			}
			urlftp = null;
			urlc = null;

		}

	}

	public static boolean validateFileExtention(String strFileExt) {

		if (!("JPEG".equalsIgnoreCase(strFileExt) || "JPG".equalsIgnoreCase(strFileExt)
				|| "PNG".equalsIgnoreCase(strFileExt) || "XLS".equalsIgnoreCase(strFileExt)
				// || "DOCX".equalsIgnoreCase(strFileExt)
				|| "PDF".equalsIgnoreCase(strFileExt))) {

			return false;

		}

		return true;
	}

	public static boolean validateFileName(String strFileName) {

		Pattern fileExtnPtrn = Pattern.compile("^[A-Za-z0-9-_,\\s]+[.]{1}[A-Za-z]{3,4}$");

		Matcher mtch = fileExtnPtrn.matcher(strFileName);
		if (!mtch.matches()) {
			return false;
		}

		return true;
	}

	public static FormFlowXUserVO getUserVO(HttpServletRequest request, FormFlowXCommonFB fb) {
		FormFlowXUserVO objuser = (FormFlowXUserVO) request.getSession().getAttribute("OBJUSER");

		if (objuser == null) {
			if (fb == null) {
				fb = new FormFlowXCommonFB();
				fb.setIsGlobal("0");
			}
			if (fb.getIsGlobal() == null)
				fb.setIsGlobal("0");

			if (fb.getIsGlobal().equals("0")) {
				fb.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				fb.setSeatId(request.getSession().getAttribute("SEATID").toString());

				// fb.setHospitalCode("2010001");
				// fb.setSeatId("21210005");
				if (fb.getSeatId() != null) {
					objuser = new FormFlowXUserVO(fb.getHospitalCode(), fb.getSeatId(), null, null, null, null);
					request.getSession().setAttribute("OBJUSER", objuser);
				} else {
					objuser = null;
				}
			} else if (fb.getIsGlobal().equals("1")) {
				if (fb.getHospitalCode() == null) {
					fb.setHospitalCode("998");
					fb.setSeatId("10001");
				} else if (fb.getSeatId() == null) {
					fb.setSeatId("10001");

				}

				if (fb.getSeatId() != null) {
					objuser = new FormFlowXUserVO(fb.getHospitalCode(), fb.getSeatId(), null, null, null, null);
					request.getSession().setAttribute("OBJUSER", objuser);
				} else {
					objuser = null;
				}

			}
		}
		return objuser;

	}

public static void viewImage(HttpServletRequest request, HttpServletResponse response_p) throws IOException {
		
		InputStream io = null;
		URL urlftp = null;
		URLConnection urlc = null;
		
		try {

			String strFileName = request.getParameter("fileName");
			String fileExt=strFileName.split("\\.")[1].toLowerCase();
			String folderName = (String) request.getParameter("folderName");
			// String ftpUrl = Usefulmethods.getQuery(configFileName, "FTPURL");
			
			if(fileExt=="jpg" || fileExt=="jpeg"){
				response_p.setContentType("image/jpeg");   
			}
			else if(fileExt=="png"){
				response_p.setContentType("image/png");   
			}

			String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");


			urlftp = new URL(ftpUrl + "/" + folderName + "/" + strFileName);
			urlc = urlftp.openConnection();
			io = urlc.getInputStream();
			
			BufferedInputStream bin = new BufferedInputStream(io);
	        BufferedOutputStream bout = new BufferedOutputStream(response_p.getOutputStream());

			response_p.setHeader("Content-Disposition", "attachment;filename=" + strFileName);
			//byte[] buf = new byte[4096];
			int ch =0; ;
	        while((ch=bin.read())!=-1)
	            bout.write(ch);

	        bin.close();
	        io.close();
	        bout.close();
	        

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (io != null) {

				io.close();
				io = null;

			}

			urlftp = null;
			urlc = null;

		}
		
	}

}
