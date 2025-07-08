package formFlowX.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.tika.Tika;
import org.json.JSONObject;

import formFlowX.fb.FormFlowXCommonFB;
import formFlowX.service.WsHttpsClient;
import formFlowX.vo.FormFlowXUserVO;
import hisglobal.security.SecurityUtil;
import hisglobal.utility.Base64Utils;
import hisglobal.utility.ControllerUTIL;
import hisglobal.utility.HisUtil;
import hisglobal.utility.Usefulmethods;
import hisglobal.vo.UserVO;

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
					fb.setHospitalCode("3726001");
					fb.setSeatId("23710006");
				} else if (fb.getSeatId() == null) {
					fb.setSeatId("23710006");

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
		//String ftpTempDir = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_TEMP_DIR");
		List<FileItem> multiparts = null;
		HttpSession session = request.getSession();
		Map<String, String> params =(Map<String, String>) session.getAttribute("FileMap");
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
						url = new URL(ftpUrl + "/" + folderName + "/" + "FTPTEMP_" + name);
						// System.out.println("after getHost--" + url.getHost());
						// System.out.println("after url--" + url.getPath());
						conn = url.openConnection();
						//System.out.println("after URLConnection");
						bos = new BufferedOutputStream(conn.getOutputStream());

						//System.out.println(" uploaded file name  >>>>>>>>>> " + "FTPTEMP_" + name);

						int bytesRead = -1;
						io = item.getInputStream();
						while ((bytesRead = io.read(buffer)) != -1) {
							bos.write(buffer, 0, bytesRead);
						}

						bos.write(item.get());
						UPLOAD_DIRECTORY =folderName;
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
				System.out.println("hashcodeInternal=== " + hashcode);
				System.out.println("tknhcode=== " + tknhcode);
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

			//String ftpFinalDir = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FINAL_DIR");

			urlftp = new URL(ftpUrl + "/" + folderName + "/FTPTEMP_" + strFileName);
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
		//String ftpFinalDir = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FINAL_DIR");
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

					if (success) {
						System.out.println(oldFileName + " was successfully renamed to: " + newFileName);
					} else {
						System.out.println("Failed to rename: " + oldFileName);
					}
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

}
