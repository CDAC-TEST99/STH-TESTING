/**********************************************************
 Project:	   DWH_JK	
 File:         SaveFileInFtpGlobal.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package hisglobal.config;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.jboss.security.Base64Encoder;

import hisglobal.utility.HisUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class SaveFileInFtpGlobal.
 */
public class SaveFileInFtpGlobal {

	public synchronized static String saveFileToFTPLocation(String strHospCode, String FileName,
			InputStream inputStream) throws Exception {
		BufferedOutputStream bos = null;

		String strFtpurl = "";

		String strReturnString = "";

		URL urlftp = null;
		URLConnection urlc = null;
		try {

			strFtpurl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
			urlftp = new URL(strFtpurl + "/" + FileName);
			urlc = urlftp.openConnection();
			bos = new BufferedOutputStream(urlc.getOutputStream());
			byte[] buf = new byte[1024];

			for (int readNum; (readNum = inputStream.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}

			strReturnString = "1";

		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {

			if (bos != null) {
				bos.close();
			}

			urlftp = null;
			urlc = null;
		}
		return strReturnString;
	}

	/**
	 * Read file from location.
	 * 
	 * @param Fileurl
	 *            the fileurl
	 * @param FileName
	 *            the file name
	 */
	public static void readFileFromLocation(String Fileurl, String FileName) {
		InputStream io = null;
		try {
			URL urlftp = new URL(Fileurl + "/" + FileName);
			URLConnection urlc = urlftp.openConnection();
			io = urlc.getInputStream();

			DataInputStream in = new DataInputStream(io);

			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				System.out.println(strLine);
			}
			// Close the input stream
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Read Image File from FTP Location & return base64 String of the image
	 * Added by Anjali- 26-11-2020
	 * */
	public static String readImageFromLocation(String FileName) {
		//Image image = null;
		InputStream io=null;
		BufferedImage image = null;
	    int width=70;
	    int height=68;
	    ByteArrayOutputStream bos = null;
		String Fileurl;
		String asB64="";
		try {
			Fileurl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
			
			URL urlftp = new URL(Fileurl + "/" + FileName);
			URLConnection urlc = urlftp.openConnection();
			io = urlc.getInputStream();
			  bos = new ByteArrayOutputStream();
              int length;
              byte[] buf = new byte[2048];
              while (-1 != (length = io.read(buf, 0, buf.length))) {
                 bos.write(buf, 0, length);
              }
              ByteArrayInputStream fis = new ByteArrayInputStream(bos.toByteArray());
              bos.flush();
              bos.close();
              byte[] buffer = new byte[fis.available()];
              int offset = 0;
              int numRead = 0;
              while (offset < buffer.length && (numRead = fis.read(buffer, offset, buffer.length - offset)) >= 0) {
                 offset += numRead;
              }
              asB64 = "data:image/jpg;base64,"+new Base64Encoder().encode(buffer);
            //  fileNames.add(asB64);
              long end = System.currentTimeMillis();
              System.out.println(end);
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		    image = ImageIO.read(io);
		    //  System.out.println("Reading complete-> "+image);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return asB64;
	}
	
	/**
	 * method downloads the file to temporary folder and returns the downloaded
	 * temporary file.
	 * 
	 * @param strHospCode
	 *            the str hosp code
	 * @param FileName
	 *            the file name
	 * @return File -
	 * @throws Exception
	 *             the exception
	 */
	public static File downloadFileFromLocation(String strHospCode, String FileName) throws Exception {

		File tempFile = null;

		InputStream io = null;
		FileOutputStream fs = null;

		String Fileurl;
		try {
			Fileurl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");

			// System.out.println("File path :: " + Fileurl + "/" + FileName);

			URL urlftp = new URL(Fileurl + "/" + FileName);
			URLConnection urlc = urlftp.openConnection();
			io = urlc.getInputStream();

			System.out.println("urlConnection : " + urlc+"\nurl= "+urlftp);

			String[] strFileDetails = FileName.replace(".", "#").split("#");

			String strDate = new SimpleDateFormat("dd-MMM-yyHH-mm-SS").format(new Date());

			String strTempFileName = "temp" + strFileDetails[0] + strDate;

			tempFile = File.createTempFile(strTempFileName, "." + strFileDetails[strFileDetails.length - 1]);

			fs = new FileOutputStream(tempFile);

			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = io.read(buffer)) != -1) {

				fs.write(buffer, 0, bytesRead);
			}

		} catch (Exception e) {

			e.printStackTrace();

			throw new Exception(e.getMessage());

		} finally {

			if (fs != null) {
				fs.close();
				fs = null;
			}

		}

		return tempFile;
	}

}
