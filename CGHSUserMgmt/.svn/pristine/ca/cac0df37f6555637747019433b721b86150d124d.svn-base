/**********************************************************
 Project:	   DWH_DMER	
 File:         HisException.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package hisglobal.exceptions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

// TODO: Auto-generated Javadoc
/**
 * <pre>
 * Purpose --> This HisException class logs the error/DAO status into log file. 
 * 	
 * 	Path for Property File have been defined in hisPath.properties file that has been kept into
 * 	WEB-INF\classes\ folder.
 * 	
 * 	Path for log file has been defined in property file
 * 	
 * 	Recommendations --> put configuration file into WEB-INF/hisConfig folder. sothat while making war file
 * 	these files automatically include in the WAR
 * </pre>
 * 
 * @author Ajay Kumar Gupta <br>
 *         Copyright �C-DAC Noida
 * 
 */

public class HisException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The log. */
	private static Logger log = null;
	// private static final String pathFileName = "hisglobal.hisconfig.hisPath";
	// // containing into class folder

	/** The err config path. */
	private static String errConfigPath = "";

	/** The DAO config path. */
	private static String DAOConfigPath = "";

	/** The err id. */
	private String errID = "";

	/**
	 * Instantiates a new his exception.
	 */
	public HisException() {
		super("HiS Exception");
	}

	/**
	 * Instantiates a new his exception.
	 * 
	 * @param _msg
	 *            the _msg
	 */
	public HisException(String _msg) {
		super(_msg);
	}

	/**
	 * Parameterized Constructor for HisException. This is used to Log the
	 * Exceptions in a Log file. Developer will throw HisException rather than
	 * Exception <code>
	 * e.g. throw new HisException("Store","Indent Register.getIndentNo()","Null Pointer Exception");
		</code>
	 * 
	 * @param moduleName
	 *            - The Current Working Module.
	 * @param fileName
	 *            - The Current Working Java File.
	 * @param msgtest
	 *            - The Exception Message thrown by the try block.
	 */
	public HisException(String moduleName, String fileName, String msgtest) {

		// internal function to set config path
		/*
		 * setConfigPath();
		 * 
		 * if (log == null) log = Logger.getLogger("");
		 * 
		 * // put message PropertyConfigurator.configure(errConfigPath);
		 * 
		 * errID = getErrID(); // get error id
		 */
		
		if(fileName == null || (fileName != null && fileName.trim().length() == 0))
			fileName = "0";

		String strMsg1 = "0";
		String strMsg2 = "0";
		String strMsg3 = "0";
		String strTemp = "";
		String strSeatId = "0";

		int intLen = 0;

		String strProcName = "{call pharmacy_final.pkg_mms_dml.dml_application_error_log_dtl(?,?,?,?,?,?,?,?,?,?,?)}";// 12
																										// Varibale's
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {
			intLen = msgtest.length();
			if (intLen > 4000) {
				strMsg1 = msgtest.substring(0, 4000);
				strTemp = msgtest.substring(4000);

				intLen = strTemp.length();
				if (intLen > 4000) {
					strMsg2 = strTemp.substring(0, 4000);
					strMsg3 = strTemp.substring(4000, 4000);
				} else
					strMsg2 = strTemp;
			} else
				strMsg1 = msgtest;

			 		
			
			daoObj = new HisDAO("HisException", "HisException");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "1" ,1 ); // 1
			daoObj.setProcInValue(nProcIndex, "p_gstr_error_msg1",
					strMsg1.trim(),2); // 2
			daoObj.setProcInValue(nProcIndex, "p_gstr_error_msg2",
					strMsg2.trim(),3); // 3
			daoObj.setProcInValue(nProcIndex, "p_gstr_error_msg3",
					strMsg3.trim(),4); // 4
			daoObj.setProcInValue(nProcIndex, "p_gstr_module_name", moduleName,5); // 5
			daoObj.setProcInValue(nProcIndex, "p_gstr_file_name", fileName,6); // 6
			daoObj.setProcInValue(nProcIndex, "p_gnum_seat_id", strSeatId,7); // 7
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", "998",8); // 8

			daoObj.setProcInValue(nProcIndex, "p_gstr_menu_name", "0",9); // 8
			
			
			daoObj.setProcOutValue(nProcIndex, "p_error_id", 1,10); // 9
			daoObj.setProcOutValue(nProcIndex, "err", 1,11); // 10
			daoObj.executeProcedureByPositionForException(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			errID = daoObj.getString(nProcIndex, "p_error_id");
		} catch (Exception e) {
			// do nothing here
			e.printStackTrace();
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * Instantiates a new his exception.
	 * 
	 * @param moduleName
	 *            the module name
	 * @param fileName
	 *            the file name
	 * @param msgtest
	 *            the msgtest
	 * @param requestObj
	 *            the request obj
	 */
	public HisException(String moduleName, String fileName, String msgtest,
			HttpServletRequest requestObj) {

		// internal function to set config path
		/*
		 * setConfigPath();
		 * 
		 * if (log == null) log = Logger.getLogger("");
		 * 
		 * // put message PropertyConfigurator.configure(errConfigPath);
		 * 
		 * errID = getErrID(); // get error id
		 */

		String strMsg1 = "0";
		String strMsg2 = "0";
		String strMsg3 = "0";
		String strTemp = "";
		String strSeatId = "0";

		int intLen = 0;

		String strProcName = "{call PKG_MMS_DML.dml_application_error_log_dtl(?,?,?,?,?,?,?,?,?,?)}";// 12
																										// Varibale's
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {
			intLen = msgtest.length();
			if (intLen > 4000) {
				strMsg1 = msgtest.substring(0, 4000);
				strTemp = msgtest.substring(4000);

				intLen = strTemp.length();
				if (intLen > 4000) {
					strMsg2 = strTemp.substring(0, 4000);
					strMsg3 = strTemp.substring(4000, 4000);
				} else
					strMsg2 = strTemp;
			} else
				strMsg1 = msgtest;

			daoObj = new HisDAO("HisException", "HisException");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (requestObj != null
					&& requestObj.getSession().getAttribute("SEATID") != null) {
				strSeatId = requestObj.getSession().getAttribute("SEATID")
						.toString();
			}

			daoObj.setProcInValue(nProcIndex, "p_mode", "1"); // 1
			daoObj.setProcInValue(nProcIndex, "p_GSTR_ERROR_MSG1",
					strMsg1.trim()); // 2
			daoObj.setProcInValue(nProcIndex, "p_GSTR_ERROR_MSG2",
					strMsg2.trim()); // 3
			daoObj.setProcInValue(nProcIndex, "p_GSTR_ERROR_MSG3",
					strMsg3.trim()); // 4
			daoObj.setProcInValue(nProcIndex, "p_GSTR_MODULE_NAME", moduleName); // 5
			daoObj.setProcInValue(nProcIndex, "p_GSTR_FILE_NAME", fileName); // 6
			daoObj.setProcInValue(nProcIndex, "p_GNUM_SEAT_ID", strSeatId); // 7
			daoObj.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", "998"); // 8

			daoObj.setProcOutValue(nProcIndex, "p_ERROR_ID", 1); // 9
			daoObj.setProcOutValue(nProcIndex, "err", 1); // 10
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			errID = daoObj.getString(nProcIndex, "p_ERROR_ID");
		} catch (Exception e) {
			// do nothing here
			e.printStackTrace();
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * Parameterized Constructor for HisException. This is used to Log the Exceptions in a Log file. Developer will throw HisException rather than
	 * Exception <code> e.g. throw new HisException("Store","Indent Register.getIndentNo()","Null Pointer Exception"); </code>
	 * 
	 * @param moduleName - The Current Working Module.
	 * @param fileName - The Current Working Java File.
	 * @param msgtest - The Exception Message thrown by the try block.
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public HisException(final String moduleName, final String fileName, final String msgtest, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException, ServletException {

		// internal function to set config path
		/*
		 * setConfigPath(); if (log == null) log = Logger.getLogger(""); // put message PropertyConfigurator.configure(errConfigPath); errID =
		 * getErrID(); // get error id
		 */

		String strMsg1 = "";
		String strMsg2 = "";
		String strMsg3 = "";
		String strTemp = "";
		String strSeatId = "0", menuName = "";
		int intLen = 0;
		String strProcName = "{call PKG_MMS_DML.dml_application_error_log_dtl(?,?,?,?,?,?,?,?,?,?,?)}"; // 13 Varibale's
		HisDAO daoObj = null;
		int nProcIndex = 0;
		try {
			menuName = (String) request.getSession().getAttribute("MENUNAME");
			intLen = msgtest.length();
			if (intLen > 4000) {
				strMsg1 = msgtest.substring(0, 4000);
				strTemp = msgtest.substring(4000);

				intLen = strTemp.length();
				if (intLen > 4000) {
					strMsg2 = strTemp.substring(0, 4000);
					strMsg3 = strTemp.substring(4000, 4000);
				} else {
					strMsg2 = strTemp;
				}
			} else {
				strMsg1 = msgtest;
			}

			daoObj = new HisDAO("HisException", "HisException");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "1"); // 1
			daoObj.setProcInValue(nProcIndex, "p_GSTR_ERROR_MSG1", strMsg1.trim()); // 2		
			daoObj.setProcInValue(nProcIndex, "p_GSTR_ERROR_MSG2", strMsg2.trim()==null || strMsg2.trim().equals("") ? "0" : strMsg2.trim()); //3
			daoObj.setProcInValue(nProcIndex, "p_GSTR_ERROR_MSG3", strMsg3.trim()==null || strMsg3.trim().equals("") ? "0" : strMsg3.trim()); // 4
			daoObj.setProcInValue(nProcIndex, "p_GSTR_MODULE_NAME", moduleName); // 5
			daoObj.setProcInValue(nProcIndex, "p_GSTR_FILE_NAME", fileName); // 6
			daoObj.setProcInValue(nProcIndex, "p_GNUM_SEAT_ID", strSeatId); // 7
			daoObj.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", "998"); // 8
			daoObj.setProcInValue(nProcIndex, "p_GSTR_MENU_NAME", menuName); // 9
			daoObj.setProcOutValue(nProcIndex, "p_ERROR_ID", 1); // 10
			daoObj.setProcOutValue(nProcIndex, "err", 1); // 11
			daoObj.executeProcedure(nProcIndex);

			daoObj.getString(nProcIndex, "err");
			errID = daoObj.getString(nProcIndex, "p_ERROR_ID");
		} catch (Exception e) {
			// do nothing here
			e.printStackTrace();
		} finally {

			String message = "Application Error [ERROR ID : " + errID + "],Contact System Administrator! ";
			System.out.println("msgtest Start: " + msgtest + "msgtest End");

			String[] msgArray = msgtest.split("##");

			if (msgtest.contains("##") && (msgArray[2].equals("998")||msgArray[1].equals("998") || msgArray[2].split("\\$$")[0].equals("998") || msgArray[2].equals("103"))) {
				if(msgArray[2].equals("998"))
				{
				    message = msgtest.split("##")[1];
				}
				else
				{
					message = msgtest.split("##")[2];
				}
			}

			request.setAttribute("message", message); // This will be available as ${message}
			request.setAttribute("menuName", menuName); // This will be available as ${message}
			request.getRequestDispatcher("/startup/index_exeption.jsp").forward(request, response);

			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	/**
	 * 
	 This function is being called through HisDAO.java file. This function
	 * will record status of HisDAO usage
	 * 
	 * @param moduleName
	 *            - The Current Working Module.
	 * @param fileName
	 *            - The Current Working Java File.
	 * @param sts
	 *            - 0 is "hisDAO OPEN" and 1 is "hisDAO CLOSE"
	 */
	public static void putHisDAOStatus(String moduleName, String fileName,
			int sts) {

		// closed due to performance by ajay on 11/May/12, opened when
		// performance nedds to check
		/*
		 * String msg = "hisDAO OPEN"; if (sts == 1) msg = "hisDAO CLOSE";
		 * 
		 * setConfigPath();
		 * 
		 * if (log == null) log = Logger.getLogger("");
		 * 
		 * // put message PropertyConfigurator.configure(DAOConfigPath);
		 * log.info("[" + moduleName + " --> " + fileName + "] [" + msg + "]");
		 */

		String strTemp = "1";
	}

	/**
	 * This function sets the config path.
	 */
	private static void setConfigPath() {

		// System.out.println(" inside setConfigPath ");

		if (DAOConfigPath.equals("") || errConfigPath.equals("")) {

			// System.out.println(" inside if setConfigPath ");

			errConfigPath = HisUtil.getParameterFromHisPathXML("ERROR_CONFIG");
			DAOConfigPath = HisUtil.getParameterFromHisPathXML("DAO_CONFIG");

			// System.out.println(" inside if end setConfigPath ");

		}
	}// end setConfigPath() function

    

}
