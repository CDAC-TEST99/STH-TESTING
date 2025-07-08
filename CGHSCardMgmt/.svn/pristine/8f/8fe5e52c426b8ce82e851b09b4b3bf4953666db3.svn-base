package formFlowX.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tika.Tika;
import org.json.JSONArray;
import org.json.JSONObject;

import formFlowX.dao.FormFlowXDao;
import formFlowX.fb.FormFlowXCommonFB;
import formFlowX.vo.FormFlowXUserVO;
import hisglobal.security.SecurityUtil;
import hisglobal.utility.Base64Utils;
import hisglobal.utility.HisUtil;
import hisglobal.utility.Usefulmethods;

public class FormFlowXUTIL {

	private static final int BUFFER_SIZE = 4096;
	private static final String configFileName = "usm.Configuration";

	public static void initABHA(FormFlowXCommonFB fb, HttpServletRequest request, HttpServletResponse response) {
		String hipPath = HisUtil.getParameterFromHisPathXML("ABDM_HIP_PATH");
		String hipAuthKey = HisUtil.getParameterFromHisPathXML("ABDM_HIP_AUTH_KEY");
		String abdmEnv = HisUtil.getParameterFromHisPathXML("ABDM_ENV");
		fb.setAbdmEnv(abdmEnv);
		request.setAttribute("abdmEnv", abdmEnv);

	}

	public static void CallService(FormFlowXCommonFB fb, HttpServletRequest request, HttpServletResponse response) {

		JSONObject objDataJson = new JSONObject();

		FormFlowXUserVO objuser = FormFlowXUTIL.getUserVO(request, fb);

		if (objuser == null) {
			objDataJson.put("message", "ERROR: Session Expired. Please Login Again!");
			Usefulmethods.writeInResponse(response, objDataJson.toString(), true);
			return;
		}

		try {

			JSONObject filtervo = null;
			if (fb.getInputData() != null) {
				
				System.out.println(fb.getInputData());
				
				filtervo = new JSONObject(fb.getInputData());
				
			}
				
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
			// System.out.println("objDataJson>>>>>>>>>>>>>"+objDataJson);
			if (objDataJson != null) {
				// System.out.println("fb.getServiceName()>>>>>>>>>>>>>"+fb.getServiceName());
				if (fb.getServiceName().contains("/DMLSAVE/OnlineBenidGenerate")
						|| fb.getServiceName().contains("/DMLSAVE/onlinepensionerbenidgenerate")) {
					// System.out.println(objDataJson.getString("message"));

					String message = objDataJson.getString("message");
					JSONArray messageArray = new JSONArray(message);

					// Iterate over the JSONArray to get the elements
					for (int i = 0; i < messageArray.length(); i++) {
						JSONObject element = messageArray.getJSONObject(i);

						// Access individual fields from each object in the array
						int benId = element.getInt("benId");
						long cardNo = element.getLong("cardNo");
						Integer mainCardHolder = element.isNull("mainCardHolder") ? null
								: element.getInt("mainCardHolder");

						String imagebase64 = element.getString("imgBase64");
						String dispshortname = element.getString("dispshortname");
						//System.out.println("dispshortname>>>>>: " + dispshortname);

						// System.out.println("imagebase64>>>>>>>>>>>"+imagebase64);

						// Print the extracted values
						String benIdvalue = String.valueOf(element.getInt("benId"));
						// System.out.println("benId: " + benId);
						// System.out.println("cardNo: " + cardNo);
						// System.out.println("mainCardHolder: " + mainCardHolder);
						//System.out.println("imagebase64>>>>>>>>>>>" + imagebase64);
						if (imagebase64 != null && !imagebase64.trim().isEmpty()) {
							File imageFile = convertBase64ToImage(imagebase64, benIdvalue);
							if (imageFile != null && imageFile.exists()) {
								// Create FileInputStream from the image file
								try (FileInputStream fileInputStream = new FileInputStream(imageFile)) {
									// Get the file name (you can use imageFile.getName() or customize it)
									String fileName = imageFile.getName();
									// System.out.println("fileName: " + fileName);
									// Call the uploadFile method with FileInputStream and other data
									Response response1 = uploadFile(benIdvalue, fileInputStream, fileName,
											dispshortname);

									// Handle the response (you can log or process it as needed)
									// System.out.println("Upload response: " + response1.getStatus());
								} catch (IOException e) {
									e.getMessage();

									System.out.println("benId: " + benId);
									System.out.println("cardNo: " + cardNo);
									System.out.println("mainCardHolder: " + mainCardHolder);
									System.out.println("Error opening file input stream for image.");
								}
							} else {
								System.out.println("Failed to create the image file from Base64 string.");
							}
						}
					}
				}
				
				if(fb.getServiceName().contains("/DMLSAVE/updatecardreceived"))
				{
					String messageString = objDataJson.getString("message");
				//	System.out.println("message>>>>>>>>>>>"+messageString);
				
				//System.out.println("Raw message string: " + messageString);
				
				// Parse messageString as JSON
				JSONObject messageJson = new JSONObject(messageString);
				System.out.println("messageJson11111111: " + messageJson);
				// Now extract fields
				String receivestatus=messageJson.getString("status");
				System.out.println("receivestatus: " + receivestatus);
				
				if(receivestatus.equals("1"))
				{
				String wcfrom = messageJson.getString("wcfrom");
				String wcto = messageJson.getString("wcto");
				String messageText = messageJson.getString("message");
				String benId = messageJson.getString("benId");
				//System.out.println("benId>>>>>>>>>>"+benId);
				
			
				String[] benIds = benId.split(",");  // Split by comma

				for (String singleBenId : benIds) {
				    singleBenId = singleBenId.trim(); // Trim spaces if any
				//	System.out.println("singleBenId>>>>>>>>>>"+singleBenId);
				    String filename = singleBenId + ".jpg";

				    // Call moveFileOnFtp for each benId individually
				    Response response1 = moveFileOnFtp(singleBenId, wcfrom, wcto, filename);

				    // Handle response1 if needed
				  //  System.out.println("Moved file for benId: " + singleBenId + " with response: " + response1.getEntity());
				}
			
				
				}
				}
                if(fb.getServiceName().contains("/DMLSAVE/updaterenewalRequestdata")) {
					
					//System.out.println("updaterenewalrequestdata-----"+objDataJson.getString("message"));

					String message = objDataJson.getString("message");
					JSONArray messageArray = new JSONArray(message);

					// Iterate over the JSONArray to get the elements
					for (int i = 0; i < messageArray.length(); i++) {
						JSONObject element = messageArray.getJSONObject(i);

						// Access individual fields from each object in the array
						int benId = element.getInt("benId");
						

						String imagebase64 = element.getString("imgBase64");
						String dispshortname = element.getString("dispshortname");
						//System.out.println("dispshortname>>>>>: " + dispshortname);

						 //System.out.println("imagebase64>>>>>>>>>>>"+imagebase64);

						// Print the extracted values
						String benIdvalue = String.valueOf(element.getInt("benId"));
						// System.out.println("benId: " + benId);
						// System.out.println("cardNo: " + cardNo);
						// System.out.println("mainCardHolder: " + mainCardHolder);
						//System.out.println("imagebase64>>>>>>>>>>>" + imagebase64);
						if (imagebase64 != null && !imagebase64.trim().isEmpty()) {
							File imageFile = convertBase64ToImage(imagebase64, benIdvalue);
							if (imageFile != null && imageFile.exists()) {
								// Create FileInputStream from the image file
								try (FileInputStream fileInputStream = new FileInputStream(imageFile)) {
									// Get the file name (you can use imageFile.getName() or customize it)
									String fileName = imageFile.getName();
									// System.out.println("fileName: " + fileName);
									// Call the uploadFile method with FileInputStream and other data
									Response response1 = uploadFile(benIdvalue, fileInputStream, fileName,
											dispshortname);

									// Handle the response (you can log or process it as needed)
									// System.out.println("Upload response: " + response1.getStatus());
								} catch (IOException e) {
									e.getMessage();

									System.out.println("benId: " + benId);
								//	System.out.println("cardNo: " + cardNo);
								//	System.out.println("mainCardHolder: " + mainCardHolder);
									System.out.println("Error opening file input stream for image.");
								}
							} else {
								System.out.println("Failed to create the image file from Base64 string.");
							}
						}
					}
				
					
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			objDataJson.put("message", "ERROR: Problem in service");
		} finally {
			Usefulmethods.writeInResponse(response, objDataJson.toString(), true);
		}
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
				String userName = (String) request.getSession().getAttribute("USER_FULL_NAME");
				fb.setUserName(userName);
				fb.setSeatId(request.getSession().getAttribute("SEATID").toString());
				// fb.setHospitalCode("2010001");
				// fb.setSeatId("21210005");
				if (fb.getSeatId() != null) {
					objuser = new FormFlowXUserVO(fb.getHospitalCode(), fb.getSeatId(), userName, null, null, null);
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
					objuser = new FormFlowXUserVO(fb.getHospitalCode(), fb.getSeatId(), "Global User", null, null,
							null);
					request.getSession().setAttribute("OBJUSER", objuser);
				} else {
					objuser = null;
				}

			}
		} else {
			fb.setHospitalCode(objuser.getHospitalCode());
			fb.setUserName(objuser.getUserName());
			fb.setSeatId(objuser.getSeatId());
		}
		return objuser;

	}

	public static void logABHAError(FormFlowXCommonFB fb, HttpServletRequest request, JSONObject responseJson) {
		FormFlowXUserVO objuser = FormFlowXUTIL.getUserVO(request, fb);
		if (objuser == null) {
			return;
		}
		String strResponse = responseJson.toString();
		JSONObject inputData = new JSONObject();
		inputData.put("service_description", fb.getServiceDescription());
		inputData.put("service_url", fb.getServiceName());
		inputData.put("request_body", fb.getInputData());
		inputData.put("service_response", strResponse);
		inputData.put("seatId", objuser.getSeatId());
		inputData.put("hospitalCode", objuser.getHospitalCode());
		inputData.put("processName", fb.getProcessName());

		if (strResponse.toUpperCase().contains("ERROR") || strResponse.contains("\"HttpStatus\":401")
				|| strResponse.contains("{\"responseCode\":404}") || strResponse.contains("{\"responseCode\":400}")
				|| strResponse.contains("{\"responseCode\":504}") || strResponse.contains("\"HttpStatus\":500")
				|| strResponse.contains("\"isSuccess\":0") || strResponse.contains("{\"status\":\"0\"}")
				|| strResponse.contains("{\"responseCode\":500}")) {
			inputData.put("logtype", "1");
		} else {
			inputData.put("logtype", "2");
		}

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();
			objUsefulmethods.callService(inputData, "/DMLSAVE/dmlServiceFailLog");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Problem in saving logs");
		}

	}

	@SuppressWarnings("unchecked")
	public static void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// System.out.println("iinn method fileUpload");

		String name = null;
		String uniqueKey = null;
		String value = null;
		String UPLOAD_DIRECTORY = "";
		String errCode = null;
		byte[] buffer = new byte[BUFFER_SIZE];
		String tkn = (String) request.getParameter("tkn");

		String folderName = (String) request.getParameter("folderName");

		String tknFieldName = null;
		String tknfileName = null;
		String tknhcode = null;
		PrintWriter out = response.getWriter();

		if (tkn == null) {
			out.print("4");
			return;
		} else {
			try {
				tkn = Base64Utils.decode(tkn);

			} catch (Exception e) {
				out.print("4");
				return;
			}
			JSONObject json = new JSONObject(tkn);
			tknfileName = json.getString("fileName");
			tknFieldName = json.getString("fieldName");
			tknhcode = json.getString("hcode");

		}
		if (tknfileName == null || tknFieldName == null) {
			out.print("4");
			return;
		}

		String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");

		// String ftpFinalDir =
		// HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FINAL_DIR");
		// String ftpTempDir =
		// HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_TEMP_DIR");
		List<FileItem> multiparts = null;
		HttpSession session = request.getSession();
		Map<String, String> params = (Map<String, String>) session.getAttribute("FileMap");
		BufferedOutputStream bos = null;
		InputStream io = null;
		URL url = null;
		URLConnection conn = null;
		// System.out.println("before isMultipartContent");
		if (ServletFileUpload.isMultipartContent(request)) {
			// System.out.println("inside isMultipartContent");
			try {
				multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String orgFileName = item.getName();
						// System.out.println("item.getFieldName()==" +item.getFieldName());
						// System.out.println("item.getName()==" +item.getName());
						/*
						 * tknfileName=json.getString("fileName");
						 * tknFieldName=json.getString("fieldName");
						 */

						if (!item.getFieldName().trim().equals(tknFieldName)
								|| !item.getName().trim().equals(tknfileName)) {
							out.print("5");
							return;
						}

						if (orgFileName != null && orgFileName.trim().length() > 0) {
							String fileExt = orgFileName.substring(orgFileName.lastIndexOf(".") + 1,
									orgFileName.length());
							if (validateFileName(orgFileName) == false) {
								out.print("3");
								return;
							}
							if (validateFileExtention(fileExt) == false) {
								out.print("1");
								return;
							}

							String msg = validateFileContentType(fileExt, item);
							if (msg != null) {
								out.print("2");
								return;
							}

							if (validateFileContent(tknhcode, item, request) == false) {
								out.print("6");
								return;
							}
						} else {
							out.print("3");
							return;
						}

						uniqueKey = item.getFieldName();
						name = new SimpleDateFormat("ddMMYYYYHHmmss").format(new Date()) + "_"
								+ new File(item.getName()).getName();
						// System.out.println("befor url");
						// url = new URL(ftpUrl + "/" + ftpTempDir + "/" + "FTPTEMP_" + name);
						url = new URL(ftpUrl + "/" + folderName + "/" + "" + name);

						// System.out.println("after getHost--" + url.getHost());
						// System.out.println("after url-----------------------" + url);
						conn = url.openConnection();
						// System.out.println("after URLConnection");
						bos = new BufferedOutputStream(conn.getOutputStream());

						// System.out.println(" uploaded file name >>>>>>>>>> " + "FTPTEMP_" + name);

						int bytesRead = -1;
						io = item.getInputStream();
						while ((bytesRead = io.read(buffer)) != -1) {
							bos.write(buffer, 0, bytesRead);
						}

						bos.write(item.get());
						UPLOAD_DIRECTORY = folderName;
						value = name + "^" + UPLOAD_DIRECTORY;
						params.put(item.getFieldName(), value);

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				errCode = "7";
			} finally {
				try {
					if (io != null)
						io.close();

					if (bos != null)
						bos.close();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				multiparts = null;
				buffer = null;
				io = null;
				bos = null;
				url = null;
				conn = null;
			}
			if (errCode != null) {
				out.print(errCode);
			} else {

				/*
				 * HttpSession session = request.getSession(); if
				 * (session.getAttribute("FileMap") != null) { params = (Map<String, String>)
				 * session.getAttribute("FileMap"); params.put(uniqueKey, value);
				 * 
				 * }
				 */
				session.setAttribute("FileMap", params);
				out.print(name);

			}

		} else {
			System.out.println("not a  isMultipartContent");
		}

	}

	public static boolean validateFileExtention(String strFileExt) {

		if (!("JPEG".equalsIgnoreCase(strFileExt) || "JPG".equalsIgnoreCase(strFileExt)
				|| "PNG".equalsIgnoreCase(strFileExt)
				// || "DOC".equalsIgnoreCase(strFileExt)
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

	public static String validateFileContentType(String strFileExt, FileItem myFile) {

		String err = null;

		Tika tika;

		try {
			if (strFileExt.equalsIgnoreCase("pdf")) {

				tika = new Tika();
				// detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
				// System.out.println("Tika File Type-->>>"+filetype);
				if (!filetype.equals("application/pdf")) {
					err = "File Content Type [  " + filetype + " ] is Not Match With File Ext ::" + strFileExt;
				}

			} else if (strFileExt.equalsIgnoreCase("jpeg") || strFileExt.equalsIgnoreCase("jpg")) {

				tika = new Tika();
				// detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
				// System.out.println("Tika File Type-->>>"+filetype);
				if (!filetype.equals("image/jpeg")) {
					err = "File Content Type [  " + filetype + " ] is Not Match With File Ext ::" + strFileExt;
				}

			} else if (strFileExt.equalsIgnoreCase("png")) {

				tika = new Tika();
				// detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
				// System.out.println("Tika File Type-->>>"+filetype);
				if (!filetype.equals("image/png")) {
					err = "File Content Type [  " + filetype + " ] is Not Match With File Ext ::" + strFileExt;
				}

			} else if (strFileExt.equalsIgnoreCase("doc") || strFileExt.equalsIgnoreCase("docx")) {
				tika = new Tika();
				// detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
				// System.out.println("Tika File Type-->>>"+filetype);
				if (!filetype.equals("application/x-tika-ooxml")) {
					err = "File Content Type [  " + filetype + " ] is Not Match With File Ext ::" + strFileExt;
				}

			}
		} catch (Exception e) {
			err = "Error Occured in File Validation";
		}

		return err;

	}

	public static boolean validateFileContent(String tknhcode, FileItem myFile, HttpServletRequest request) {

		boolean flag = false;

		try {

			String hashcode = SecurityUtil.getMd5Hash(Base64Utils.base64Encode(myFile.get()));

			if (hashcode.equals(tknhcode)) {
				// System.out.println("hashcodeInternal=== " + hashcode);
				// System.out.println("tknhcode=== " + tknhcode);
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}

		return flag;

	}

	public static void downloadFileFromTempFTP(HttpServletRequest request, HttpServletResponse response_p)
			throws Exception {

		InputStream io = null;
		URL urlftp = null;
		URLConnection urlc = null;
		String folderName = (String) request.getParameter("folderName");
		try {

			String strFileName = request.getParameter("fileName");
			// String ftpUrl = Usefulmethods.getQuery(configFileName, "FTPURL");

			String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");

			// String ftpFinalDir =
			// HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FINAL_DIR");

			urlftp = new URL(ftpUrl + "/" + folderName + "/" + strFileName);
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

	@SuppressWarnings("unchecked")
	public static void renameTempFileOnGlobalFtp(HttpServletRequest request, HttpServletResponse response) {

		String fileDtl[] = null;

		String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
		// String ftpFinalDir =
		// HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FINAL_DIR");
		ftpUrl = ftpUrl.split("@")[1];

		String server = ftpUrl;
		int port = 21;
		String user = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME");
		String pass = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD");

		HttpSession session = request.getSession(false);
		Map<String, String> params = (Map<String, String>) session.getAttribute("FileMap");
		FTPClient ftpClient = new FTPClient();
		try {
			boolean success = false;
			ftpClient.connect(server, port);
			success = ftpClient.login(user, pass);

			if (success == true) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					fileDtl = entry.getValue().split("\\^");
					String oldFileName = fileDtl[1] + "/FTPTEMP_" + fileDtl[0];
					String newFileName = fileDtl[1] + "/" + fileDtl[0];
					success = ftpClient.rename(oldFileName, newFileName);

					/*
					 * if (success) { System.out.println(oldFileName +
					 * " was successfully renamed to: " + newFileName); } else {
					 * System.out.println("Failed to rename: " + oldFileName); }
					 */
				}
				ftpClient.logout();
				ftpClient.disconnect();
			} else {
				System.out.println("FTP Login failed!");
				return;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (ftpClient != null && ftpClient.isConnected()) {
				try {
					ftpClient.logout();
					ftpClient.disconnect();

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			ftpClient = null;
			params = null;
		}

	}

	public static void downloadFileFromFTP(HttpServletRequest request, HttpServletResponse response_p)
			throws Exception {

		InputStream io = null;
		URL urlftp = null;
		URLConnection urlc = null;

		try {

			String strFileName = request.getParameter("fileName");
			String folderName = (String) request.getParameter("folderName");
			// String ftpUrl = Usefulmethods.getQuery(configFileName, "FTPURL");

			String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");

			urlftp = new URL(ftpUrl + "/" + folderName + "/" + strFileName);
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

	public static Response uploadFile(String benId, InputStream fileInputStream, String fileName,
			String dispshortname) {
		JSONObject objResponse = new JSONObject();
		FTPClient ftpClient = new FTPClient();
		String responseMessage = "";
		JSONObject apiDetails = new JSONObject();
		JSONObject result = new JSONObject();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);

		try {
			// Retrieve FTP server credentials from XML configuration
			String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
			String server = ftpUrl.split("@")[1]; // FTP server address

			// FTP credentials
			String ftpUser = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME");
			String ftpPass = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD");

			// Connect to FTP server
			ftpClient.connect(server, 21); // Default FTP port 21
			if (!ftpClient.isConnected()) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to connect to FTP server")
						.build();
			}

			ftpClient.login(ftpUser, ftpPass);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // Set binary mode for file transfer
			ftpClient.enterLocalPassiveMode(); // Set passive mode for FTP

			// Check FTP server response code after login
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity("FTP login failed, reply code: " + replyCode).build();
			}

			String folderName = "CGHS_PROFILE_PICS"; // Folder name for the file upload
			String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

			// Validate file type (only allow jpg)
			if (!"jpg".equals(fileExtension)) {
				responseMessage = "File is not image type";
				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "F");
				apiDetails.put("message", responseMessage);
				// result.put("result", "null");
				// result.put("apiDetails", apiDetails);
				result.put("result", responseMessage);
				return Response.ok().build();
			}

			/*
			 * String remoteFilePath = "/FTP/" + folderName + "/" + fileName; // Construct
			 * remote file path
			 */
			String remoteFilePath = "/FTP/" + folderName + "/" + dispshortname + "/" + fileName; // Constructs remote
																									// file path with
																									// folder display
																									// short name after
																									// folder name.

			String workingDirectory = "/FTP/" + folderName;

			// Check if the folder exists on the FTP server
			boolean folderExists = ftpClient.changeWorkingDirectory(workingDirectory);
			if (!folderExists) {
				System.out.println("Folder does not exist, attempting to create: " + workingDirectory);
				boolean folderCreated = ftpClient.makeDirectory("/" + folderName);
				if (!folderCreated) {
					// Handle folder creation failure
				}
			}

			// Upload file to FTP server
			boolean success = ftpClient.storeFile(remoteFilePath, fileInputStream);

			// Check FTP upload success
			if (!success) {
				int uploadReplyCode = ftpClient.getReplyCode();
				responseMessage = "Failed to upload file to FTP server.";
				result.put("result", responseMessage);
			} else {
				// If the file upload is successful, execute the database update query
				JSONObject objFilterJson = new JSONObject();
				objFilterJson.put("fileName", fileName);
				objFilterJson.put("benId", benId);
				objFilterJson.put("processName", "/parliament/v1/BenDetails/updatephotofilename");
				String strServiceName = "service/updatephotofilename";
				Usefulmethods objUsefulmethods = new Usefulmethods();
				objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
				System.out.println("objResponse>>>>>>>" + objResponse);

				if (objResponse != null) {

					System.out.println("objResponse>>>>>>>>>>" + objResponse);
					responseMessage = objResponse.getString("message");

					result.put("result", responseMessage);
					// result.put("apiDetails", apiDetails);
				} else {
					responseMessage = "Name Not updated";

					result.put("result", responseMessage);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error uploading file to FTP").build();
		} finally {
			// Disconnect from FTP server
			if (ftpClient.isConnected()) {
				try {
					ftpClient.logout();
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return Response.ok(result.toString()).build();
	}

	public static File convertBase64ToImage(String base64String, String benIdvalue) {
		// Remove the "data:image/png;base64," prefix if it exists
		if (base64String != null && base64String.startsWith("data:image")) {
			base64String = base64String.split(",")[1]; // Split the string and take the part after the comma
		}

		// Define the output file path using the benIdvalue (e.g., benIdvalue.jpg)
		String outputPath = benIdvalue + ".jpg"; // You can change the file extension to .png, .jpg, etc., as needed

		try {
			// Decode the Base64 string into a byte array
			byte[] imageBytes = Base64.getDecoder().decode(base64String);

			// Create a File object where the image will be saved
			File outputFile = new File(outputPath);

			// Write the decoded bytes to the file
			try (FileOutputStream fos = new FileOutputStream(outputFile)) {
				fos.write(imageBytes);
			}

			// Return the created image file
			return outputFile;
		} catch (IOException e) {
			e.printStackTrace();
			return null; // Return null in case of error
		}
	}

	public static void downloadMultipleFilesAsZip(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String base64JsonData = request.getParameter("jsonData");

		if (base64JsonData == null || base64JsonData.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing 'jsonData' parameter.");
			return;
		}

		byte[] decodedBytes = Base64.getDecoder().decode(base64JsonData);
		String json = new String(decodedBytes);

		JSONArray fileArray;
		try {
			fileArray = new JSONArray(json);
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON format.");
			return;
		}

		String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");

		// 7. Get filename from request
		String fileName = request.getParameter("fileName");
		if (fileName == null || fileName.isEmpty()) {
			fileName = "export.xlsx"; // fallback default if missing
		} else {
			// ensure the filename is safe
			fileName = fileName.replaceAll("[\\\\/:*?\"<>|]", "_");
		}

		response.setContentType("application/zip");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		// response.setHeader("Content-Disposition",
		// "attachment;filename=downloaded_photos.zip");

		try (ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream())) {
			byte[] buffer = new byte[4096];

			for (int i = 0; i < fileArray.length(); i++) {
				JSONObject fileObject = fileArray.getJSONObject(i);
				String fileName1 = fileObject.optString("filename");
				String folderName = fileObject.optString("foledername");

				if (fileName.isEmpty() || folderName.isEmpty())
					continue;

				String fileUrlString = ftpUrl + "/" + folderName + "/" + fileName1;

				try (InputStream inputStream = new URL(fileUrlString).openStream()) {
					zipOut.putNextEntry(new ZipEntry(fileName1));

					int bytesRead;
					while ((bytesRead = inputStream.read(buffer)) != -1) {
						zipOut.write(buffer, 0, bytesRead);
					}

					zipOut.closeEntry();
				} catch (IOException fileEx) {
					System.err.println("Failed to fetch file: " + fileUrlString + " - " + fileEx.getMessage());
				}
			}

			zipOut.finish();
		} catch (IOException ex) {
			System.err.println("ZIP generation error: " + ex.getMessage());
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "ZIP creation failed.");
		}
	}

	public static void downloadExcelFromBase64(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		XSSFWorkbook workbook = null;
		OutputStream out = null;

		try {
			// 1. Decode Base64
			String base64JsonData = request.getParameter("jsonData");
			if (base64JsonData == null || base64JsonData.isEmpty()) {
				throw new IllegalArgumentException("Missing 'jsonData' parameter.");
			}

			byte[] decodedBytes = Base64.getDecoder().decode(base64JsonData);
			String jsonString = new String(decodedBytes, StandardCharsets.UTF_8);

			// 2. Parse JSON using org.json
			JSONArray jsonArray = new JSONArray(jsonString);

			// 3. Prepare Excel workbook
			workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Data");

			if (jsonArray.length() > 0) {
				// 4. Define the header order based on the SQL query
				String[] headers = { "SlNo", "BenId", "FirstName", "Gender", "Dob", "Mobile", "CardType", "CardNo",
						"ValidupTo", "CityName", "CardColor", "DepartmentName", "Entitlement",
						"BeneficiaryHospitalCode", "PrintDate", "ListDate" };

				// 5. Create header row
				XSSFRow headerRow = sheet.createRow(0);
				for (int i = 0; i < headers.length; i++) {
					headerRow.createCell(i).setCellValue(headers[i]);
				}

				// 6. Add data rows
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject rowObj = jsonArray.getJSONObject(i);
					XSSFRow row = sheet.createRow(i + 1);

					// Insert data according to the header order
					row.createCell(0).setCellValue(rowObj.optString("SlNo", ""));
					row.createCell(1).setCellValue(rowObj.optString("BenId", ""));
					row.createCell(2).setCellValue(rowObj.optString("FirstName", ""));
					row.createCell(3).setCellValue(rowObj.optString("Gender", ""));
					row.createCell(4).setCellValue(rowObj.optString("Dob", ""));
					row.createCell(5).setCellValue(rowObj.optString("Mobile", ""));
					row.createCell(6).setCellValue(rowObj.optString("CardType", ""));
					row.createCell(7).setCellValue(rowObj.optString("CardNo", ""));
					row.createCell(8).setCellValue(rowObj.optString("ValidupTo", ""));
					row.createCell(9).setCellValue(rowObj.optString("CityName", ""));
					row.createCell(10).setCellValue(rowObj.optString("CardColor", ""));
					row.createCell(11).setCellValue(rowObj.optString("DepartmentName", ""));
					row.createCell(12).setCellValue(rowObj.optString("Entitlement", ""));
					row.createCell(13).setCellValue(rowObj.optString("BeneficiaryHospitalCode", ""));
				}
			}

			// 7. Get filename from request
			String fileName = request.getParameter("fileName");
			if (fileName == null || fileName.isEmpty()) {
				fileName = "export.xlsx"; // fallback default if missing
			} else {
				// ensure the filename is safe
				fileName = fileName.replaceAll("[\\\\/:*?\"<>|]", "_");
			}

			// 8. Set response headers
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

			// 9. Write to response output stream
			out = response.getOutputStream();
			workbook.write(out);

		} finally {
			if (workbook != null) {
				try {
					if (workbook instanceof Closeable) {
						((Closeable) workbook).close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String uploadExcel(HttpServletRequest request, HttpServletResponse response) {
		try {

			// Check if the form is multipart
			System.out.println("inside form flowx util uploadExcel");
			if (!ServletFileUpload.isMultipartContent(request)) {
				response.setContentType("application/json");
				response.getWriter().write("{\"message\":\"Error: Form must be multipart/form-data.\"}");
				return null;
			}

			// Create a factory for disk file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> formItems = upload.parseRequest(request);

			InputStream inputStream = null;
			String seatId = "null";
			String hospitalCode = "null";
			// Retrieve the file input stream
			for (FileItem item : formItems) {
				if ("seatId".equalsIgnoreCase(item.getFieldName())) {
					seatId = item.getString();
				} else if ("hospitalCode".equalsIgnoreCase(item.getFieldName())) {
					hospitalCode = item.getString();
				}
				if (!item.isFormField() && "file".equals(item.getFieldName())) {
					inputStream = item.getInputStream();
				}
			}

			// Check if no file was uploaded
			if (inputStream == null) {
				response.setContentType("application/json");
				response.getWriter().write("{\"message\":\"Error: No file uploaded.\"}");
				return null;
			}

			// Parse the Excel file using Apache POI
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			JSONArray dataArray = new JSONArray();

			// Get header row and validate
			Row headerRow = sheet.getRow(0);
			if (headerRow == null) {
				System.out.println("Header row is missing or empty.");
				response.setContentType("application/json");
				response.getWriter().write("{\"message\":\"Error:Excel sheet is empty or header row is missing.\"}");
				return null;
			}

			int cols = headerRow.getLastCellNum();

			// Iterate through rows and extract data
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				JSONObject rowData = new JSONObject();

				for (int j = 0; j < cols; j++) {
					String columnName = "Column" + j; // default column name
					String cellValue = "";

					try {
						// Retrieve column name from header row
						Cell headerCell = headerRow.getCell(j);
						if (headerCell != null && headerCell.getCellType() == Cell.CELL_TYPE_STRING) {
							String colNameCandidate = headerCell.getStringCellValue();
							if (colNameCandidate != null && !colNameCandidate.trim().isEmpty()) {
								columnName = colNameCandidate.trim();
							}
						}

						// Retrieve cell value and process based on cell type
						Cell cell = row.getCell(j);
						if (cell != null) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								cellValue = cell.getStringCellValue() != null ? cell.getStringCellValue().trim() : "";
								break;
							case Cell.CELL_TYPE_NUMERIC:
								if (DateUtil.isCellDateFormatted(cell)) {
									cellValue = cell.getDateCellValue() != null ? cell.getDateCellValue().toString()
											: "";
								} else {
									cellValue = String.valueOf(cell.getNumericCellValue());
								}
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								cellValue = String.valueOf(cell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_FORMULA:
								cellValue = cell.getCellFormula() != null ? cell.getCellFormula() : "";
								break;
							default:
								cellValue = "";
							}
						}
					} catch (Exception e) {
						cellValue = "[Error: " + e.getMessage() + "]";
					}

					rowData.put(columnName, cellValue);
				}

				// Perform validation on each row's data
				String errorMessage = validateRowData(rowData, i); // i + 1 for human-readable row number
				if (errorMessage != null) {
					response.setContentType("application/json");
					response.getWriter().write("{\"message\":\"Error: " + errorMessage + "\"}");
					return null;
				}

				// Add valid row data to dataArray
				dataArray.put(rowData);
			}

			// Prepare input data for database upload
			JSONObject inputData = new JSONObject();
			inputData.put("excelData", dataArray);
			inputData.put("hospitalCode", hospitalCode);
			inputData.put("seatId", seatId);
			//System.out.println("Parsed Excel Data: " + inputData.toString());

			return uploadExcelDataInTable(inputData, request, response); // your custom logic for DB upload

		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.setContentType("application/json");
				response.getWriter().write("{\"message\":\"ERROR :Exception occurred during upload.\"}");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}

		return null;
	}

	private static String validateRowData(JSONObject rowData, int rowNumber) {
		System.out.println("inside validateRowData");
		if (rowData.optString("BenId", "").isEmpty()) {
			return "BenId should not be null or empty in S No. : " + rowNumber;
		}

		if (rowData.optString("FirstName", "").isEmpty()) {
			return "FirstName should not be null or empty in S No. : " + rowNumber;
		}

		String gender = rowData.optString("Gender", "").trim();
		if (gender.isEmpty()) {
			return " Gender should not be null or empty in S No. :" + rowNumber;
		}

		String Dob = rowData.optString("Dob", "").trim();
		if (Dob.isEmpty()) {
			return " Dob should not be null or empty in S No. :" + rowNumber;
		}
		String mobile = rowData.optString("Mobile", "").trim();
		if (mobile.isEmpty()) {
			return " Mobile number should not be null or empty in  S No. : " + rowNumber;
		}

		String CardType = rowData.optString("CardType", "").trim();
		if (CardType.isEmpty()) {
			return "CardType should not be empty in S No. : " + rowNumber;
		}
		String cardNo = rowData.optString("CardNo", "").trim();
		if (cardNo.isEmpty()) {
			return "CardNo should not be empty in S No. : " + rowNumber;
		}

		String validUpTo = rowData.optString("ValidupTo", "").trim();
		if (validUpTo.isEmpty()) {
			return "ValidUpTo should not be null or empty in S No. : " + rowNumber;
		}

		String CityName = rowData.optString("CityName", "").trim();
		if (CityName.isEmpty()) {
			return "CityName should not be null or empty in S No. : " + rowNumber;
		}

		String CardColor = rowData.optString("CardColor", "").trim();
		if (CardColor.isEmpty()) {
			return "CityName should not be null or empty in S No. : " + rowNumber;
		}

		String departmentName = rowData.optString("DepartmentName", "").trim();
		if (departmentName.isEmpty()) {
			return "DepartmentName should not be null or empty in S No. : " + rowNumber;
		}

		String Entitlement = rowData.optString("Entitlement", "").trim();
		if (Entitlement.isEmpty()) {
			return "Entitlement should not be null or empty in S No. : " + rowNumber;
		}
		String BeneficiaryHospitalCode = rowData.optString("BeneficiaryHospitalCode", "").trim();
		if (BeneficiaryHospitalCode.isEmpty()) {
			return "BeneficiaryHospitalCode should not be null or empty in S No. : " + rowNumber;
		}
		String PrintDate = rowData.optString("PrintDate", "").trim();
		if (PrintDate.isEmpty()) {
			return "PrintDate should not be null or empty in S No. : " + rowNumber;
		}
		String ListDate = rowData.optString("ListDate", "").trim();
		if (ListDate.isEmpty()) {
			return "ListDate should not be null or empty in S No. : " + rowNumber;
		}

		return null;
	}

	private static String uploadExcelDataInTable(JSONObject inputData, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			System.out.println("inside uploadExcelDataInTable");
			JSONObject result = new JSONObject();
			System.out.println("inputData>>>>>>>>" + inputData);
			result = Usefulmethods
					.callDMLProcedureForAPI("cardmgmt.pkg_cghs_card_services_online.uploadcardprintdatadtl", inputData);
			response.setContentType("application/json");
			response.getWriter().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String uploadAirIndiaExcel(HttpServletRequest request, HttpServletResponse response) {
		try {

			// Check if the form is multipart
			System.out.println("inside form flowx util uploadExcel");
			if (!ServletFileUpload.isMultipartContent(request)) {
				response.setContentType("application/json");
				response.getWriter().write("{\"message\":\"Form must be multipart/form-data.\"}");
				return null;
			}

			// Create a factory for disk file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> formItems = upload.parseRequest(request);

			InputStream inputStream = null;
			String seatId = "null";
			String hospitalCode = "null";
			// Retrieve the file input stream
			for (FileItem item : formItems) {
				if ("seatId".equalsIgnoreCase(item.getFieldName())) {
					seatId = item.getString();
				} else if ("hospitalCode".equalsIgnoreCase(item.getFieldName())) {
					hospitalCode = item.getString();
				}
				if (!item.isFormField() && "file".equals(item.getFieldName())) {
					inputStream = item.getInputStream();
				}
			}

			// Check if no file was uploaded
			if (inputStream == null) {
				response.setContentType("application/json");
				response.getWriter().write("{\"message\":\"No file uploaded.\"}");
				return null;
			}

			// Parse the Excel file using Apache POI
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			JSONArray dataArray = new JSONArray();
			JSONArray errordataArray = new JSONArray();

			// Get header row and validate
			Row headerRow = sheet.getRow(0);
			if (headerRow == null) {
				System.out.println("Header row is missing or empty.");
				response.setContentType("application/json");
				response.getWriter().write("{\"message\":\"Excel sheet is empty or header row is missing.\"}");
				return null;
			}

			int cols = headerRow.getLastCellNum();

			System.out.println("cols >> "+cols);
			
			int MAX_ROW = 500;

			if (sheet.getLastRowNum() > MAX_ROW) {

				System.out.println("Rows more than " + MAX_ROW);
				response.setContentType("application/json");
				response.getWriter()
						.write("{\"message\":\"Excel sheet should have Maximum of " + MAX_ROW + " Rows only\"}");
				return null;
			}
			
			
			if (cols != 13) {

				System.out.println("columns not equal to 13");
				response.setContentType("application/json");
				response.getWriter()
						.write("{\"message\":\"Excel sheet should have 13 Columns \"}");
				return null;
			}

			
			String[] defaultColumnName = {"S. No","Ben ID","Name of Beneficiary","Card Type","Entitlement","Valid Upto","Payment Mode","Payment Ref No","Payment Date","Payment Valid From","Payment Valid To","Amount","City code"};
			
			
			for (int j = 0; j < cols; j++) {
				
				String columnName = "Column" + j; 
				
				Cell headerCell = headerRow.getCell(j);
				if (headerCell != null && headerCell.getCellType() == Cell.CELL_TYPE_STRING) {
					String colNameCandidate = headerCell.getStringCellValue();
					if (colNameCandidate != null && !colNameCandidate.trim().isEmpty()) {
						columnName = colNameCandidate.trim();
						
						if(!defaultColumnName[j].equals(columnName)) {
							
							 
							response.setContentType("application/json");
							response.getWriter()
									.write("{\"message\":\"Excel Column name is case sensitive, Column Name '"+columnName+"' should be '"+defaultColumnName[j]+"' \"}");
							return null;
							
						}
						
					}
				}
				
				
				
			}
			
			
			// Iterate through rows and extract data
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				JSONObject rowData = new JSONObject();

				try {
					Field changeMap = rowData.getClass().getDeclaredField("map");
					changeMap.setAccessible(true);
					changeMap.set(rowData, new LinkedHashMap<>());
					changeMap.setAccessible(false);
				} catch (IllegalAccessException | NoSuchFieldException e) {
					System.out.println(e.getMessage());
				}

				for (int j = 0; j < cols; j++) {
					String columnName = "Column" + j; // default column name
					String cellValue = "";

					try {
						// Retrieve column name from header row
						Cell headerCell = headerRow.getCell(j);
						if (headerCell != null && headerCell.getCellType() == Cell.CELL_TYPE_STRING) {
							String colNameCandidate = headerCell.getStringCellValue();
							if (colNameCandidate != null && !colNameCandidate.trim().isEmpty()) {
								columnName = colNameCandidate.trim();
							}
						}

						// Retrieve cell value and process based on cell type
						Cell cell = row.getCell(j);
						if (cell != null) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								cellValue = cell.getStringCellValue() != null ? cell.getStringCellValue().trim() : "";
								break;
							case Cell.CELL_TYPE_NUMERIC:
								if (DateUtil.isCellDateFormatted(cell)) {
									cellValue = cell.getDateCellValue() != null ? cell.getDateCellValue().toString()
											: "";
								} else {
									cellValue = String.valueOf(cell.getNumericCellValue());
								}
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								cellValue = String.valueOf(cell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_FORMULA:
								cellValue = cell.getCellFormula() != null ? cell.getCellFormula() : "";
								break;
							default:
								cellValue = "";
							}
						}
					} catch (Exception e) {
						cellValue = "[Error: " + e.getMessage() + "]";
					}

					if ("Ben ID".equalsIgnoreCase(columnName) || "S. No".equals(columnName)  || "Payment Ref No".equals(columnName) ) {

						if(cellValue.contains("E")) {
							 DecimalFormat df = new DecimalFormat("#");
							Double num = Double.parseDouble(cellValue);
						        cellValue = df.format(num);
						        cellValue = cellValue.replace(".", "#").split("#")[0];
							
						}else {
							cellValue = cellValue.replace(".", "#").split("#")[0];
						}
						
						
						
					}

					if ("Amount".equalsIgnoreCase(columnName)) {
						cellValue = getAmountWithDecimal(cellValue, 2);
					}

					rowData.put(columnName, cellValue);

				}

				// Perform validation on each row's data
				String errorMessage = validateAirIndiaRowData(rowData, i); // i + 1 for human-readable row number
				if (errorMessage != null) {

					rowData.put("Error", "<span style='color:red' >" + errorMessage + "</span>");

					errordataArray.put(rowData);

				} else {

					JSONObject result = null;
					JSONObject result2 = null;
					 
						  result = IntStream.range(0, dataArray.length()).mapToObj(dataArray::getJSONObject)
								.filter(obj -> rowData.getString("Ben ID").equals(obj.getString("Ben ID")))
								// .peek(a -> System.out.println(a.getString("Ben ID")))
								.findFirst().orElse(null);
					 
						  result2 = IntStream.range(0, errordataArray.length()).mapToObj(errordataArray::getJSONObject)
								.filter(obj -> rowData.getString("Ben ID").equals(obj.getString("Ben ID")))
								// .peek(a -> System.out.println(a.getString("Ben ID")))
								.findFirst().orElse(null);
					 

					if (result != null || result2 != null) {
						// System.out.println("Found: " + result);

						rowData.put("Error", "<span style='color:red' >Duplicate Ben Id Found in the Data </span>");

						errordataArray.put(rowData);

					} else {

						// main card holder ^ ad city id ^ ad city name ^ card type ^ card type name ^
						// is valid
						String benDtl = FormFlowXDao.getBenValidationValue("1", rowData.getString("Ben ID"),
								hospitalCode);

						String[] benDtlArray = benDtl.split("\\^");

						String errorMsg = "";

						if ("0".equals(benDtlArray[0])) {

							errorMsg = errorMsg + " Ben is not Main Card Holder ";
						}

						else if (!"1".equals(benDtlArray[0])) {

							errorMsg = errorMsg + "</br> Ben is Deleted / Not Approved ";
						}

						else if (!rowData.optString("Card Type", "").equalsIgnoreCase(benDtlArray[4])) {

							errorMsg = errorMsg + "</br> Ben Card Type is Different in System : (" + benDtlArray[4]+")";
						}

						else if (!rowData.optString("City code", "").equalsIgnoreCase(benDtlArray[2])) {

							errorMsg = errorMsg + "</br> Ben AD City is Different in System : (" + benDtlArray[2];
						}

						if (errorMsg.trim().length() == 0) {

							// Add valid row data to dataArray
							dataArray.put(rowData);

						} else {

							rowData.put("Error", "<span style='color:red' >" + errorMsg + "</span>");

							errordataArray.put(rowData);

						}

					}

				}

			}

			// Prepare input data for database upload
			JSONObject inputData = new JSONObject();
			inputData.put("excelData", dataArray);
			inputData.put("excelDataError", errordataArray);
			inputData.put("hospitalCode", hospitalCode);
			inputData.put("seatId", seatId);
			//System.out.println("Parsed Excel Data: " + inputData.toString());

			response.setContentType("application/json");
			response.getWriter().write(inputData.toString());
			return null;

			// return uploadAiIndiaExcelDataInTable(inputData, request, response); // your
			// custom logic for DB upload

		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.setContentType("application/json");
				response.getWriter().write("{\"message\":\"Exception occurred during upload.\"}");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}

		return null;
	}

	private static String validateAirIndiaRowData(JSONObject rowData, int rowNumber) {
		System.out.println("inside validateRowData");
		if (rowData.optString("Ben ID", "").isEmpty()) {
			return "BenId should not be null or empty";
		}

		if (rowData.optString("Name of Beneficiary", "").isEmpty()) {
			return "Name of Beneficiary should not be null or empty";
		}

		String cardType = rowData.optString("Card Type", "").trim();
		if (cardType.isEmpty() || !"Air India Pensioner".equalsIgnoreCase(cardType)) {
			return " Card Type should be 'Air India Pensioner'";
		}

		String entitilement = rowData.optString("Entitlement", "").trim();
		if (entitilement.isEmpty() || (!"General".equalsIgnoreCase(entitilement)
				&& !"Semi Private".equalsIgnoreCase(entitilement) && !"Private".equalsIgnoreCase(entitilement))) {
			return " Entitilement should be one of the following ' General , Private or Semi Private ' ";
		}

		String date_regex = "^([0-2][0-9]|3[0-1])-([0][1-9]|1[0-2])-(\\d{4})$";
		Pattern pattern = Pattern.compile(date_regex);

		String validUpto = rowData.optString("Valid Upto", "").trim();
		if (validUpto.isEmpty() || !pattern.matcher(validUpto).matches()) {
			return " valid Upto  should be valid date format [dd-MM-yyyy] ";
		}

		String paymentMode = rowData.optString("Payment Mode", "").trim();
		if (paymentMode.isEmpty() || !"BharathKosh".equalsIgnoreCase(paymentMode)) {
			return "Payment Mode should be 'BharathKosh' ";
		}
		
		String num_regex = "\\d+"; 

		
		String paymentRefNo = rowData.optString("Payment Ref No", "").trim();
		if (paymentRefNo.isEmpty() ||!Pattern.matches(num_regex, paymentRefNo)) {
			return "Payment Ref No should be a Valid Number ";
		}

		
		
		String paymentDate = rowData.optString("Payment Date", "").trim();
		if (paymentDate.isEmpty() || !pattern.matcher(paymentDate).matches()) {
			return " Payment Date should be valid date format [dd-MM-yyyy] ";
		}

		String paymentValidFrom = rowData.optString("Payment Valid From", "").trim();
		if (paymentValidFrom.isEmpty() || !pattern.matcher(paymentValidFrom).matches()) {
			return " Payment Valid From should be valid date format [dd-MM-yyyy] ";
		}

		String paymentValidTo = rowData.optString("Payment Valid To", "").trim();
		if (paymentValidTo.isEmpty() || !pattern.matcher(paymentValidTo).matches()) {
			return " Payment Valid To should be valid date format [dd-MM-yyyy] ";
		}

		String amt_regex = "^\\d+(\\.\\d{2})?$";
		String amount = rowData.optString("Amount", "").trim();
		if (amount.isEmpty() || !Pattern.matches(amt_regex, amount)) {
			return " Amount should be valid";
		}

		if (rowData.optString("City code", "").isEmpty()) {
			return "City code should not be null or empty ";
		}

		return null;
	}

	public static String getAmountWithDecimal(String amount, int decimalSize) {

		if (amount == null || (amount != null && amount.trim().length() == 0))
			return "";

		String strAmt = "";

		StringBuffer strPattern = new StringBuffer();

		DecimalFormat df = new DecimalFormat();

		if (decimalSize > 0) {

			strPattern.append(".");

			for (int i = 1; i <= decimalSize; i++) {

				strPattern = strPattern.append("0");

			}

		} else {

			strPattern.append("0");

		}

		df.applyPattern(strPattern.toString());

		if (!amount.equals("0")) {

			strAmt = df.format(Double.parseDouble(amount));

		} else {

			strAmt = "0" + strPattern.toString();
		}

		if (df != null)

			df = null;

		if (strPattern != null)

			strPattern = null;

		return strAmt;

	}

	private static String uploadAiIndiaExcelDataInTable(JSONObject inputData, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			System.out.println("inside uploadExcelDataInTable");
			JSONObject result = new JSONObject();
			System.out.println("inputData>>>>>>>>" + inputData);
			result = Usefulmethods
					.callDMLProcedureForAPI("cardmgmt.pkg_cghs_card_services_online.uploadcardprintdatadtl", inputData);
			response.setContentType("application/json");
			response.getWriter().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/*
	public static Response moveFileOnFtp(String benId, String sourceFolder, String destinationFolder, String fileName) {
	    JSONObject result = new JSONObject();
	    FTPClient ftpClient = new FTPClient();
	    LocalDateTime currentDateTime = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String currentTimestamp = currentDateTime.format(formatter);

	    try {
	        // Retrieve FTP credentials
	        String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
	        String server = ftpUrl.split("@")[1];
	        String ftpUser = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME");
	        String ftpPass = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD");

	        // Connect
	        ftpClient.connect(server, 21);
	        ftpClient.login(ftpUser, ftpPass);
	        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	        ftpClient.enterLocalPassiveMode();

	        int replyCode = ftpClient.getReplyCode();
	        if (!FTPReply.isPositiveCompletion(replyCode)) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity("FTP login failed, reply code: " + replyCode).build();
	        }

	        
	        String folderName = "CGHS_PROFILE_PICS";
	        String sourceFilePath = "/FTP/" + folderName + "/" + sourceFolder + "/" + fileName;
	        String destFolderPath = "/FTP/" + folderName + "/" + destinationFolder;
	        String destFilePath = destFolderPath + "/" + fileName;

	        // Ensure destination folder exists
	        if (!ftpClient.changeWorkingDirectory(destFolderPath)) {
	            boolean folderCreated = ftpClient.makeDirectory(destFolderPath);
	            if (!folderCreated) {
	                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                        .entity("Failed to create destination folder: " + destFolderPath).build();
	            }
	        }

	        // Move (rename) file
	        boolean moved = ftpClient.rename(sourceFilePath, destFilePath);

	        if (moved) {
	            // Call backend to update filename in DB
	            JSONObject objFilterJson = new JSONObject();
	            objFilterJson.put("fileName", fileName);
	            objFilterJson.put("benId", benId);
	            objFilterJson.put("processName", "/parliament/v1/BenDetails/updatephotofilename");

	            String strServiceName = "service/updatephotofilename";
	            Usefulmethods objUsefulmethods = new Usefulmethods();
	            JSONObject objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);

	            String responseMessage = (objResponse != null && objResponse.has("message"))
	                    ? objResponse.getString("message")
	                    : "Name updated, but no response message";

	            result.put("timeStamp", currentTimestamp);
	            result.put("statusCode", "S");
	            result.put("result", responseMessage);
	        } else {
	            result.put("statusCode", "F");
	            result.put("result", "Failed to move file on FTP server.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error moving file on FTP").build();
	    } finally {
	        try {
	            if (ftpClient.isConnected()) {
	                ftpClient.logout();
	                ftpClient.disconnect();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    return Response.ok(result.toString()).build();
	}

}
*/
	
	public static Response moveFileOnFtp(String benId, String sourceFolder, String destinationFolder, String fileName) {
	    JSONObject result = new JSONObject();
	    FTPClient ftpClient = new FTPClient();
	    LocalDateTime currentDateTime = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String currentTimestamp = currentDateTime.format(formatter);

	    try {
	        // Retrieve FTP credentials
	        String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
	        String server = ftpUrl.split("@")[1];
	        String ftpUser = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME");
	        String ftpPass = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD");

	        // Connect and login
	        ftpClient.connect(server, 21);
	        ftpClient.login(ftpUser, ftpPass);
	        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	        ftpClient.enterLocalPassiveMode();

	        int replyCode = ftpClient.getReplyCode();
	        if (!FTPReply.isPositiveCompletion(replyCode)) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity("FTP login failed, reply code: " + replyCode).build();
	        }

	        String folderName = "CGHS_PROFILE_PICS";
	        String sourceFilePath = "/FTP/" + folderName + "/" + sourceFolder + "/" + fileName;
	        String backupFileName = fileName.substring(0, fileName.lastIndexOf('.')) + "_t" + fileName.substring(fileName.lastIndexOf('.'));
	        String backupFilePath = "/FTP/" + folderName + "/" + sourceFolder + "/" + backupFileName;
	        String destFolderPath = "/FTP/" + folderName + "/" + destinationFolder;
	        String destFilePath = destFolderPath + "/" + fileName;

	        // Step 1: Download original file into memory (simulate copy)
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        boolean downloaded = ftpClient.retrieveFile(sourceFilePath, outputStream);
	        if (!downloaded) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity("Failed to download source file: " + sourceFilePath).build();
	        }

	        // Step 2: Upload it back to source folder with backup name
	        ByteArrayInputStream inputStreamForBackup = new ByteArrayInputStream(outputStream.toByteArray());
	        boolean backupUploaded = ftpClient.storeFile(backupFilePath, inputStreamForBackup);
	        inputStreamForBackup.close();
	        if (!backupUploaded) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity("Failed to upload backup file: " + backupFilePath).build();
	        }

	        // Ensure destination folder exists or create it
	        if (!ftpClient.changeWorkingDirectory(destFolderPath)) {
	            boolean folderCreated = ftpClient.makeDirectory(destFolderPath);
	            if (!folderCreated) {
	                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                        .entity("Failed to create destination folder: " + destFolderPath).build();
	            }
	        }

	        // Step 3: Rename (move) original file to destination folder
	        boolean moved = ftpClient.rename(sourceFilePath, destFilePath);

	        if (moved) {
	            // Call backend to update filename in DB
	            JSONObject objFilterJson = new JSONObject();
	            objFilterJson.put("fileName", fileName);
	            objFilterJson.put("benId", benId);
	            objFilterJson.put("processName", "/parliament/v1/BenDetails/updatephotofilename");

	            String strServiceName = "service/updatephotofilename";
	            Usefulmethods objUsefulmethods = new Usefulmethods();
	            JSONObject objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);

	            String responseMessage = (objResponse != null && objResponse.has("message"))
	                    ? objResponse.getString("message")
	                    : "Name updated, but no response message";

	            result.put("timeStamp", currentTimestamp);
	            result.put("statusCode", "S");
	            result.put("result", responseMessage);
	        } else {
	            result.put("statusCode", "F");
	            result.put("result", "Failed to move file on FTP server.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error moving file on FTP").build();
	    } finally {
	        try {
	            if (ftpClient.isConnected()) {
	                ftpClient.logout();
	                ftpClient.disconnect();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    return Response.ok(result.toString()).build();
	}
}
