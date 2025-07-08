package formFlowX.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import formFlowX.fb.FormFlowXCommonFB;
import formFlowX.vo.FormFlowXUserVO;
import hisglobal.utility.ControllerUTIL;
import hisglobal.utility.HisUtil;
import hisglobal.utility.Usefulmethods;
import hisglobal.vo.UserVO;


public class FormFlowXCommonUTIL {

	private static final int BUFFER_SIZE = 4096;
	private static final String configFileName="config.Configuration";
	
	

	public static void CallService(FormFlowXCommonFB fb, HttpServletRequest request, HttpServletResponse response) {

		JSONObject objDataJson = new JSONObject();

		
		FormFlowXUserVO objuser =FormFlowXCommonUTIL.getUserVO(request,fb);
		
		if(objuser==null) {
			objDataJson.put("message", "ERROR: Session Expired. Please Login Again!");
			Usefulmethods.writeInResponse(response, objDataJson.toString(), true);
			return;
		}

		try {
				
				JSONObject filtervo= null;
				if(fb.getInputData()!=null )
					filtervo= new JSONObject(fb.getInputData());
				else
					filtervo= new JSONObject();
				filtervo.put("seatId", objuser.getSeatId());
				filtervo.put("hospitalCode", objuser.getHospitalCode());			
				filtervo.put("modeFordata", fb.getInitMode());
				filtervo.put("processName", fb.getProcessName());
				if(fb.getServiceName().contains("/getData/")) {
					if(fb.getPrimaryKeys()!=null && fb.getPrimaryKeys().length>0) {
						for(int i=0;i<fb.getPrimaryKeys().length;i++) {
							filtervo.put("pk"+i, fb.getPrimaryKeys()[i]);
						}
						
					}
				}
				else {
					String ids="";
					if(fb.getPrimaryKeys()!=null && fb.getPrimaryKeys().length>0) {
						for(int i=0;i<fb.getPrimaryKeys().length;i++) {
							ids+= fb.getPrimaryKeys()[i]+ ",";							
						}
						ids=ids.substring(0, ids.length()-1);
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

	
	
	public static void fileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// reads input file from an absolute path
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date now = new Date();
		FileInputStream inStream=null;
		String time = dateFormat.format(now);
		
		String filename =request.getParameter("fileName");
				 
		System.out.println("filename>>>>.."+filename);
		 String filePath = "C:/IMCS/EMMS_DOC/"+time+"/"+filename;
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
	
		
	
	
	
public static void downloadFileFromDrivePath(HttpServletRequest request, HttpServletResponse response_p) throws IOException {

	File resourceFile=null;
	FileInputStream io=null;
	try {
		String strFileName=request.getParameter("fileName");
		
		String osType = System.getProperties().getProperty("os.name");
		String filePath="";
		if (osType.startsWith("Win")) {

			filePath =  Usefulmethods.getQuery(configFileName, "UPLOAD_URL_WINDOWS");
		} else {
			filePath = Usefulmethods.getQuery(configFileName, "UPLOAD_URL_LINUX");

		}
		
		
		 resourceFile = new File(filePath+ "/"+strFileName);
		 io= new FileInputStream(resourceFile);
		

		response_p.setHeader("Content-Disposition", "attachment;filename=" + strFileName);
		byte[] buf = new byte[4096];
		int read = 0;
		while ((read = io.read(buf)) > 0)
			response_p.getOutputStream().write(buf, 0, read);

	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
		if(io != null) {
			io.close();
			io = null;			
		}
		if(resourceFile!=null)
			resourceFile=null;
		
	}

}
	
	
	public static void downloadFileFromFTP(HttpServletRequest request, HttpServletResponse response_p)
			throws Exception {
		
		InputStream io = null;
		URL urlftp = null;
		URLConnection urlc = null;
		try {
			String isFileUploadOnFTP = Usefulmethods.getQuery(configFileName, "IsFileUploadOnFTP");
			
			if(!isFileUploadOnFTP.equalsIgnoreCase("YES")) { 
				downloadFileFromDrivePath(request, response_p);
				return; 
			}
			
			String strFileName=request.getParameter("fileName");
			//String ftpUrl = Usefulmethods.getQuery(configFileName, "FTPURL");
			
			String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
			
			String ftpFinalDir = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FINAL_DIR");

			
			

			 urlftp = new URL(ftpUrl+"/"+ftpFinalDir+ "/" + strFileName);
			 urlc = urlftp.openConnection();
			io = urlc.getInputStream();

			response_p.setHeader("Content-Disposition", "attachment;filename=" + strFileName);
			byte[] buf = new byte[4096];
			int read = 0;
			while ((read = io.read(buf)) > 0)
				response_p.getOutputStream().write(buf, 0, read);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(io != null) {
				
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
		URL urlftp =null;
		URLConnection urlc = null;
		try {
			String isFileUploadOnFTP = Usefulmethods.getQuery(configFileName, "IsFileUploadOnFTP");
			
			if(!isFileUploadOnFTP.equalsIgnoreCase("YES")) { 
				downloadFileFromDrivePath(request, response_p);
				return; 
			}
			
			String strFileName=request.getParameter("fileName");
			//String ftpUrl = Usefulmethods.getQuery(configFileName, "FTPURL");
			
			String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
			
			
			String ftpFinalDir="";
			String mode= (String) request.getParameter("mode");
			if(mode!=null) {
				try {
					ftpFinalDir = Usefulmethods.getQuery(configFileName, "mode_"+mode);
					}
					catch(Exception e) {
						ftpFinalDir="";
						System.out.println("mode_"+mode + " not found in config file");
					}
			}

			
			

			 urlftp = new URL(ftpUrl+ftpFinalDir+  "/FTPTEMP_"+strFileName);
			 urlc = urlftp.openConnection();
			io = urlc.getInputStream();

			response_p.setHeader("Content-Disposition", "attachment;filename=" + strFileName);
			byte[] buf = new byte[4096];
			int read = 0;
			while ((read = io.read(buf)) > 0)
				response_p.getOutputStream().write(buf, 0, read);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(io != null) {
				
				io.close();
				io = null;
				
			}
			 urlftp =null;
			 urlc = null;
			
		}

	}
	
	
	
	
	
	
	
	public static boolean validateFileExtention(String strFileExt) {

		if (!("JPEG".equalsIgnoreCase(strFileExt)
			|| "JPG".equalsIgnoreCase(strFileExt)
			|| "PNG".equalsIgnoreCase(strFileExt)
		//	|| "DOC".equalsIgnoreCase(strFileExt)
		//	|| "DOCX".equalsIgnoreCase(strFileExt) 
			|| "PDF".equalsIgnoreCase(strFileExt))
		   ) {

			return false;

		}

		return true;
	}
	
	
	
	public static boolean validateFileName(String strFileName) {

		Pattern fileExtnPtrn = Pattern
				.compile("^[A-Za-z0-9-_,\\s]+[.]{1}[A-Za-z]{3,4}$");

		Matcher mtch = fileExtnPtrn.matcher(strFileName);
		if (!mtch.matches()) {
			return false;
		}

		return true;
	}
	
	

	public static FormFlowXUserVO getUserVO(HttpServletRequest request, FormFlowXCommonFB fb) {
		FormFlowXUserVO objuser =(FormFlowXUserVO) request.getSession().getAttribute("OBJUSER");
		
		if(objuser==null) {
			if(fb==null) {
				fb= new FormFlowXCommonFB();
				fb.setIsGlobal("0");
			}
			if(fb.getIsGlobal()==null)
				fb.setIsGlobal("0");
			
			if(fb.getIsGlobal().equals("0")){
				fb.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
				fb.setSeatId(request.getSession().getAttribute("SEATID").toString());		

				//fb.setHospitalCode("2010001");	
				//fb.setSeatId("21210005");
				if(fb.getSeatId()!=null  ) {
					objuser = new FormFlowXUserVO(fb.getHospitalCode(), fb.getSeatId(), null, null,  null, null);
					request.getSession().setAttribute("OBJUSER", objuser);
				}
				else {
					objuser=null;
				}
			}
			else if(fb.getIsGlobal().equals("1")){
				if(fb.getHospitalCode()==null) {
					fb.setHospitalCode("998");	
					fb.setSeatId("10001");	
				}
				else if(fb.getSeatId()==null) {
					fb.setSeatId("10001");
					
				}
				
				if(fb.getSeatId()!=null) {
					objuser = new FormFlowXUserVO(fb.getHospitalCode(), fb.getSeatId(), null, null,  null, null);
					request.getSession().setAttribute("OBJUSER", objuser);				
				}
				else {
					objuser=null;
				}
			
			}
		}
			return objuser;
		
	}

	
	

	
	

}
