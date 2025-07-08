package thirdpartyservices.bhavishya.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.imageio.ImageIO;

import org.json.JSONObject;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import hisglobal.utility.HisUtil;
import hisglobal.utility.Usefulmethods;
import thirdpartyservices.bhavishya.model.BhavishyaRelations;
import thirdpartyservices.bhavishya.model.BhavishyaResponse;

public class BhavishyaUtil {
	
	public static String validateBhavishyaData(BhavishyaResponse data) {
		StringBuilder response = new StringBuilder();
		
		if(data.getName() != null && data.getName().trim().length() == 0) {
			response.append("Pleave Provide Pensioner Name.\n");
		}
		if(data.getMobile() != null && data.getMobile().trim().length() != 10) {
			response.append("Please Provide Mobile Number.\n");
		}
		if(data.getAddress() != null && data.getAddress().trim().length() < 4) {
			response.append("Please Provide Valid Address.\n");
		}
		if(data.getPincode() != null && data.getPincode().trim().length() != 6) {
			response.append("Pleave Provide Valid Pincode.\n");
		}
		if(data.getCityDesc() != null && data.getCityDesc().trim().length() <= 0) {
			response.append("Pleave Provide City Description.\n");
		}
		if(data.getStateCode() != null && data.getStateCode().trim().length() <= 0) {
			response.append("Pleave Provide Valid State Code.\n");
		}
		if(data.getDistrictCode() != null && data.getDistrictCode().trim().length() <= 0) {
			response.append("Pleave Provide Valid Disctrict Code.\n");
		}
		if(data.getOrg_Type() != null && data.getOrg_Type().trim().length() <= 0) {
			response.append("Pleave Provide Valid Organization Type.\n");
		}
		if(data.getDdO_Code() == 0) {
			response.append("Pleave Provide Valid DDO Code.\n");
		}
		if(data.getGenderCode() != null && data.getGenderCode().trim().length() == 0) {
			response.append("Pleave Provide Gender Code.\n");
		}
		if(data.getDob() != null && data.getDob().trim().length() == 0) {
			response.append("Pleave Provide Date Of Birth.\n");
		}
		if(data.getPayScale() != null && data.getPayScale().trim().length() == 0) {
			response.append("Pleave Provide Payscale.\n");
		}
		if(data.getLastPay() != null && data.getLastPay().trim().length() == 0) {
			response.append("Pleave Provide Last Pay.\n");
		}
		if(data.getPayLevel() != null && data.getPayLevel().trim().length() == 0) {
			response.append("Pleave Provide Pay Level.\n");
		}
		if(data.getFmaCode() != null && data.getFmaCode().trim().length() == 0) {
			response.append("Pleave Provide FMA Code.\n");
		}
		
		List<BhavishyaRelations> relations = data.getRelations();
		for(BhavishyaRelations relationData : relations) {
			String name = relationData.getName();
			String dob = relationData.getDob();
			String genderCode = relationData.getGenderCode();
			String relation = relationData.getRelationWithPensioner();
			
			if(name != null && name.trim().length() <= 0) {
				response.append("Dependent Error - Please Provide Valid Name. \n");
			}
			if(dob != null && dob.trim().length() <= 0) {
				response.append("Dependent Error - Please Provide Valid Date Of Birth. \n");
			}
			if(genderCode != null && genderCode.trim().length() <= 0) {
				response.append("Dependent Error - Please Provide Gender Code. \n");
			}
			if(relation != null && relation.trim().length() <= 0) {
				response.append("Dependent Error - Please Provide Relation With Pensioner. \n");
			}
			
		}
		return response.toString();
	}
	

	public static String generateQRCodeBase64(String data, int width, int height) throws WriterException, IOException {
		// Set encoding parameters (error correction level and character encoding)
		Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // Low error correction level
		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // Character set

		// Generate the QR code as a BitMatrix
		BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height, hintMap);

		// Convert the BitMatrix to a BufferedImage

		BufferedImage image = toBufferedImage(bitMatrix);

		// Convert BufferedImage to Base64 string
		return imageToBase64(image);
	}
	
	private static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// Set pixels to black or white depending on BitMatrix values
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				image.setRGB(x, y, matrix.get(x, y) ? 0x000000 : 0xFFFFFF); // Black for true, White for false
			}
		}

		return image;
	}

	private static String imageToBase64(BufferedImage image) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "PNG", byteArrayOutputStream); // Write the image as PNG
		byte[] imageBytes = byteArrayOutputStream.toByteArray();
		return Base64.getEncoder().encodeToString(imageBytes); // Convert the byte array to Base64
	}
	
	public static String getImageAsBase64(String strFileName) {
		//System.out.println("strFileName>>>>>>>>>>" + strFileName);
		URL urlftp = null;
		URLConnection urlc = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		String base64Image = null;
		String folderName = "CGHS_PROFILE_PICS";
		String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
		InputStream inputStream = null;
		try {
			urlftp = new URL(ftpUrl + "/" + folderName + "/" + strFileName);
			urlc = urlftp.openConnection();
			inputStream = urlc.getInputStream();
			//System.out.println("inputStreaminputStreaminputStream" + inputStream);
			if (inputStream != null) {
				//System.out.println("inputStreamiiii");
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
	
	public static void insertBhavishyaLogs(String request, String response, String encodedRequest,
			String encodedResponse, String requestFor, String status, String message) {
		//System.out.println("Insert Bhavishya Logs into DB"); 
		
		JSONObject objRequest = new JSONObject();
		objRequest.put("STATUS", status);
		objRequest.put("REQUEST_FOR", requestFor);
		objRequest.put("MESSAGE", message);
		objRequest.put("REQUEST", request);
		objRequest.put("ENCRYPT_REQUEST", encodedRequest);
		objRequest.put("RESPONSE", response);
		objRequest.put("ENCRYPT_RESPONSE", encodedResponse);
		
		JSONObject objResponse = null;
		
		Usefulmethods objUsefulmethods = new Usefulmethods();
        String strServiceName = "service/saveBhavishyaLogs";
        
        // Call the service and get the response
         objResponse = objUsefulmethods.callService(objRequest, strServiceName);
        // System.out.println(objResponse.toString());
	
	}
	
}
