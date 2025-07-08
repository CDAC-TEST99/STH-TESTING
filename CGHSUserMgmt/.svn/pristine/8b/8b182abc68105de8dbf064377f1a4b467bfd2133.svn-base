package application.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import hisglobal.config.HISConfig;
import hisglobal.utility.HisUtil;
import hisglobal.utility.Usefulmethods;

public class HISApplicationConfig extends HISConfig
{
	private static Map<String, Object> mapURLWiseAllowedActionURIs;
	
	public boolean setApplictaionInitials(ServletContext objContext)
	{
		boolean flg = true;
		try
		{
			//System.out.println("Initializing Applictaion Context --> " + objContext.getContextPath());
			
			/* Setting Configuration Static Fields */
			APPLICATION_CONTEXT = objContext.getContextPath();
			APPLICATION_TYPE = APP_TYPE.MODULE;
			APPLICATION_DESCRIPTION = "Module Registration";
			APPLICATION_SERVER_INFO = objContext.getServerInfo();
			// APPLICATION_SERVER_OS = ""
			APPLICATION_URL = "/HISRegistration";
			APPLICATION_SERVER_URL = "";

			// Setting Application Server IP and Port
			String strApplicationServerIP = HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_IP");
			String strApplicationServerPort = HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_APPPORT");
			HISConfig.HIS_SERVICES_SERVER_URL = "http://"+strApplicationServerIP+":"+strApplicationServerPort;
			
			HISApplicationConfig.HIS_WEB_MODULE_LOGIN ="/"+Usefulmethods.getQuery("config.Configuration", "HIS_WEB_MODULE_LOGIN");
			//System.out.println("Applictaion Server URL --> " + HISConfig.HIS_SERVICES_SERVER_URL);

			// Setting FTP Server URL, User Name and Password
			String strFTPServerURL = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
			String strFTPServerUsername = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME");
			String strFTPServerPassword = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD");
			/*FTPStaticConfigurator.HIS_FTP_SERVER_ADDRESS_COMPLETE = strFTPServerURL;
			FTPStaticConfigurator.HIS_FTP_SERVER_USERNAME = strFTPServerUsername;
			FTPStaticConfigurator.HIS_FTP_SERVER_PASSWORD = strFTPServerPassword;
			//System.out.println("FTP Server URL, UserName, Password --> " + FTPStaticConfigurator.HIS_FTP_SERVER_ADDRESS_COMPLETE +", "+FTPStaticConfigurator.HIS_FTP_SERVER_USERNAME +", "+FTPStaticConfigurator.HIS_FTP_SERVER_PASSWORD);
*/
			// Setting SNOIMED CT Server URL
			String strSNOMEDServerIPPort = HisUtil.getParameterFromHisPathXML("HIS_SNOMEDSERVER_IPPORT");
			HISConfig.HIS_SNOMEDCT_SERVER_URL = "http://"+strSNOMEDServerIPPort;
			//System.out.println("SNOMED CT Browser Server URL --> " + HISConfig.HIS_SNOMEDCT_SERVER_URL);
			
			try{
				String strMongoServerIP = HisUtil.getParameterFromHisPathXML("HIS_MONGOSERVER_IP");
				//System.out.println("strMongoServerIP--" + strMongoServerIP);
				HISConfig.HIS_MONGODB_SERVER_URL = strMongoServerIP;
				}
				catch(Exception e){
					//System.out.println("HIS_MONGODB_SERVER_URL not found in hispath.xml"  );
					e.printStackTrace(); 
				}
			
			// Initial Parameters
			//System.out.println(objContext.getInitParameterNames());

			// Setting Application Initial Attributes
			setApplictaionMapofAllowedURLs();
		}
		catch (Exception e)
		{
			flg = false;
			// e.printStackTrace();
		}
		return flg;
	}
	
	private void setApplictaionMapofAllowedURLs()//----- Not In Use Right Now 
	{
		mapURLWiseAllowedActionURIs = new HashMap<String, Object>(); 
	}

}
