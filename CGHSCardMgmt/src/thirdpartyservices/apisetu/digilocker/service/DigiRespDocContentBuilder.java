package thirdpartyservices.apisetu.digilocker.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import hisglobal.utility.HisUtil;
import hisglobal.utility.Usefulmethods;
import lombok.Builder;
import thirdpartyservices.cardapi.CghsCardApi;
import thirdpartyservices.digilocker.util.HtmlToPdfConvertor;

@Builder
public class DigiRespDocContentBuilder {

	public String fetchBase64BenCard(String benId) throws Exception {

		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject result = new JSONObject();
		String pdfbase64 = null;

		// getBenIdWiseDtl
		try {
			objFilterJson = new JSONObject();
			objFilterJson.put("benId", benId);
			
            String pk0 = (String) objFilterJson.get("benId");
            objFilterJson.put("pk0", pk0);
            objFilterJson.put("processName", "/cardapi/v1/BenDetails/getBeneficiaryCard");


			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName = "service/getmaincardholderdetails";

			// Call the service and get the response
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
			String filePath = "";
			String osType = System.getProperties().getProperty("os.name");

			if (osType.startsWith("Win")) {
				filePath = "C:/CGHS/FileHandling/CardManagement/";
			} else {
				filePath = "/opt/Arunachal_PHDM/FileHandling/prescriptions/";
			}

			// Check if objResponse is not null
			if (objResponse != null) {
				// Log the objResponse for debugging
				System.out.println("objResponse >>>>> " + objResponse);

				// Get the "data" array from objResponse
				JSONArray dataArray = objResponse.optJSONArray("data");

				// Check if dataArray is not null and has at least one element
				if (dataArray != null && dataArray.length() > 0) {
					// Create an array to hold the final beneficiary details

					// Loop through each item in the dataArray
					for (int i = 0; i < dataArray.length(); i++) {
						// Get the JSONObject at the current index 'i'
						JSONObject dataObject = dataArray.optJSONObject(i);

						// Check if the JSONObject is not null
						if (dataObject != null) {
							// Extract a variable from this specific object by its key
							// String BeneficiaryId = dataObject.optString("BenId"); // Example field
							// String cardno = dataObject.optString("cardno");
							String cardType = dataObject.optString("gstr_cardtype_name");

							String name = dataObject.optString("FirstName");
							String dob = dataObject.optString("DOB");
							String BenId = dataObject.optString("BenId");
							String gender = dataObject.optString("gender");
							String Entitlement = dataObject.optString("gnum_short_nm");
							String hindientitlement = dataObject.optString("gstr_entitlement_hindi");
							String validto = dataObject.optString("validto");
							String hindicardtype = dataObject.optString("gstr_card_hindi_name");
							String base64Imagefront = dataObject.optString("card_front_header_base64");
							String base64Imageback = dataObject.optString("card_back_base64");
							String relationname = dataObject.optString("gstr_relation_name");
							String cardvalidto = dataObject.optString("validupto");
							String Photonamedep = dataObject.optString("photo");
							String facility = dataObject.optString("gstr_fma_facility");
							String dispshortname = dataObject.optString("gstr_hosp_short_name");
							String directorimage = dataObject.optString("card_director_sign_base64");

							// String color="red";
							// String Photonamedep="10013585.jpg";
							System.out.println("PhotonamedepPhotonamedep>>>>>>>" + Photonamedep);
							String Photonamedepbase64 = CghsCardApi.getImageAsBase64withshortdispname(Photonamedep, dispshortname);
							System.out.println("Photonamedepbase64>>>>>>>" + Photonamedepbase64);
							System.out.println("dispshortname>>>>>>>" + dispshortname);
							// filePath = filePath + crNo.replace("/", "-") + "_"+episodeCode+"_"+visitNo+
							// ".pdf";
							filePath = filePath + BenId + ".pdf";
							// Initialize a StringBuilder to construct the HTML content

							// String imagebase64=dataObject.optString("photo");

							// String data = "BenId: " +2025+ BenId;

							// System.out.println("imagebase64>>>>>>"+imagebase64);

							String data = "BenId: " + BenId + ", Name: " + name + ", gender: " + gender;

							// Generate the QR code image and get the Base64 string
							String base64QRCode = generateQRCodeBase64(data, 350, 350);

							String base64QRCodefinal = "data:image/png;base64," + base64QRCode;

							// Create HTML string with Base64 QR code embedded inside a div
							/*
							 * String htmlContent = "<div id='qrCodeDiv'>" +
							 * "<img id='qrCodeImage' src='data:image/png;base64," + base64QRCode +
							 * "' alt='QR Code' />" + "</div>";
							 */

							// Print or return the HTML content
							System.out.println(base64QRCode);

							StringBuilder htmlContent = new StringBuilder();
							htmlContent.append(
									"<div class=\"card cghs-card\" id='cghsCard' style='background-repeat: no-repeat;  border-radius: 8px;  border: 1px solid #ddd;   margin: 20px auto;  height: 300px; width: 500px;; 	border: 1px solid #000;  background-image: url(\"data:image/png;base64,"
											+ base64Imagefront
											+ "\"); background-size: cover; background-position: center;'>")
									.append("<div class=\"card-body\">").append("<div class=\"card-content\">")
									.append("<div class=\"card-image\"  style=\"\">")

									.append("<img id=\"photo\" src=\"data:image/png;base64," + Photonamedepbase64
											+ "\" alt=\"Profile Photo\" style=\"border-radius: 10px; margin-right: 15px; margin-top: 100px; height: 100px; width: 80px; object-fit: cover; border:1px solid #ddd9d9 !important;\">")
									.append("</div>")
									.append("<div class=\"\" style=\"margin-top: -109px;margin-left: 127px;  flex-grow: 1;\">")
									.append("<table>").append("<tr>")
									.append("<td style='width:40%; font-size: small; padding:5px; color:#1F6780;font-weight: bold; text-transform: capitalize; letter-spacing: 0.040rem; white-space: nowrap;'>")
									.append("<p style='margin: 0; padding: 0; text-align:left;'>")
									.append("NAME: " + name).append("</p>")
									.append("<p style='margin: 0; padding: 0;'>DOB/GENDER: " + dob + "/" + gender
											+ "</p>")
									.append("<p class=\"card-text\" style='margin: 0; padding: 0;'>CATEGORY: "
											+ cardType + " / " + hindicardtype + "</p>")
									.append("<p style='margin: 0; padding: 0;'>RELATION: " + relationname + "</p>")
									.append("<p style='margin: 0; padding: 0;'>FACILITY: " + facility + "</p>")
									.append("<p style='margin: 0; padding: 0;'>ENTITLEMENT: " + Entitlement + "</p>")
									.append("<p style='margin: 0; padding: 0;'>VALID UPTO: " + cardvalidto + "</p>")
									.append("</td>")

									.append("<td style=\"width: 30%; text-align: right; padding-left: 15px;\" id=\"qrCode\"><img src='"
											+ base64QRCodefinal
											+ "' alt='QR Code' style='width: 100px; height: 100px;'/></td>")
									.append("</tr>").append("<tr>").append("<tr>")
									.append("<td colspan=\"2\" style=\"text-align: right; padding-right: 18px; padding-top: 6px; letter-spacing: 0.040rem; font-weight: bold;\">")
									// Right-aligned Director Image
									.append("<img src=\"data:image/jpeg;base64," + directorimage
											+ "\" alt=\"Director Photo\" style=\"height: 50px; width: 67px; border:1px solid #ddd9d9; margin-bottom: -2px;\"/>")
									.append("<div>&#x928;&#x93F;&#x930;&#x94D;&#x926;&#x947;&#x936;&#x915; /Director</div>")
									.append("</td>").append("</tr>")

									.append("</tr>").append("</table>")
									.append("<div style='margin-top: -27px;margin-left: -118px; font-size: 33x;color: #fff;font-weight: bold;font-size: 18px;font-style: italic;'>BEN ID : "
											+ BenId + " </div>")
									.append("</div>").append("</div>").append("</div>").append("</div>")
									.append("</div>")
									.append("<div class=\"card cghs-card\" id='cghsCardBack' style='background-repeat: no-repeat;  border-radius: 8px;  border: 1px solid #ddd;   margin: 20px auto;  height: 300px; width: 500px; 	border: 1px solid #000; background-image: url(\"data:image/png;base64,"
											+ base64Imageback
											+ "\"); background-size: cover; background-position: center;'>")
									.append("<div class=\"card-body\">").append("<div class=\"card-content\">")
									.append("<div class=\"card-details\" style=\"margin-top: 76px;\">")
									.append("<table>").append("<tr>")
									.append("<td style=\"width: 30%; text-align: right; padding-left: 15px;\" id=\"qrCodeBack\"></td>")
									.append("<td style='width:70%; padding:5px;color:#1F6780;font-weight: bold; text-transform: capitalize;letter-spacing: 0.040rem;'>")
									.append("</td>").append("</tr>").append("</table>")
									.append("<div style='margin-top: 168px;margin-left: 9px;font-size: 33x;color: #fff;font-weight: bold;font-size: 18px;font-style: italic;'>BEN ID : "
											+ BenId + " </div>")
									.append("</div>").append("</div>").append("</div>").append("</div>");
							htmlContent.append("</body>");
							htmlContent.append("</html>");

							System.out.println("before  convert?>>> ");
							HtmlToPdfConvertor.convert(htmlContent.toString(), filePath);
							System.out.println("after  convert?>>> ");
							pdfbase64 = HtmlToPdfConvertor.convertPDFToBase64(filePath);
							System.out.println("pdfbase64>>>" + pdfbase64);
							String finalHTML = htmlContent.toString();

							System.out.println(base64QRCode);

							System.out.println("Photonamedepbase64>>>>>>>" + Photonamedepbase64);
							System.out.println("base64Imageback>>>>>>>>>" + base64Imageback);
							System.out.println(finalHTML);

						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdfbase64;
	}

	private String generateQRCodeBase64(String data, int width, int height) throws WriterException, IOException {
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

	// Method to convert the BitMatrix to a BufferedImage
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
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

	// Method to convert BufferedImage to Base64 string
	private static String imageToBase64(BufferedImage image) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "PNG", byteArrayOutputStream); // Write the image as PNG
		byte[] imageBytes = byteArrayOutputStream.toByteArray();
		return Base64.getEncoder().encodeToString(imageBytes); // Convert the byte array to Base64
	}

	public static String getImageAsBase64(String strFileName) throws Exception {
		// System.out.println("strFileName>>>>>>>>>>" + strFileName);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		String base64Image = null;
		String folderName = "CGHS_PROFILE_PICS";
		String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
		URL urlftp = new URL(ftpUrl + "/" + folderName + "/" + strFileName);
		URLConnection urlc = urlftp.openConnection();
		try (InputStream inputStream = urlc.getInputStream()) {
			// System.out.println("inputStreaminputStreaminputStream" + inputStream);
			if (inputStream != null) {
				// System.out.println("inputStreamiiii");
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				// Convert the image bytes to Base64
				base64Image = Base64.getEncoder().encodeToString(outputStream.toByteArray());

				inputStream.close();

			} else {
				throw new Exception("Failed to retrieve file: " + ftpUrl + "/" + folderName + "/" + strFileName);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}

		return base64Image;
	}

}
