package thirdpartyservices;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import hisglobal.utility.HisUtil;

public class FTPImageToBase64 {

	 public static String getImageAsBase64( String strFileName) {
		 	URL urlftp = null;
			URLConnection urlc = null;
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        String base64Image = null;
	        String folderName="CGHS_PROFILE_PICS";
	        String ftpUrl=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
	        InputStream inputStream=null;
	        try {
	        	urlftp = new URL(ftpUrl + "/" + folderName + "/" + strFileName);
				urlc = urlftp.openConnection();
				inputStream = urlc.getInputStream();

	            if (inputStream != null) {
	                byte[] buffer = new byte[1024];
	                int bytesRead;
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);
	                }

	                // Convert the image bytes to Base64
	                base64Image = Base64.getEncoder().encodeToString(outputStream.toByteArray());

	                inputStream.close();
	                
	            } else {
	                System.out.println("Failed to retrieve file: " + ftpUrl + "/" + folderName + "/" + strFileName);
	            }

	           
	           

	        } catch (Exception ex) {
	            ex.printStackTrace();
	            base64Image=null;
	        } finally {
	            try {
	            	if (inputStream != null) {

	            		inputStream.close();
	            		inputStream = null;

	    			}

	    			urlftp = null;
	    			urlc = null;
	                
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }

	        return base64Image;
	    }
}
