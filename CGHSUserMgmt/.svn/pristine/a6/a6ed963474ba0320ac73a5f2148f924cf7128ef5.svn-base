package SmsAndMail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.JSONArray;
import org.json.JSONObject;

import formFlowX.fb.FormFlowXCommonFB;
import hisglobal.utility.Usefulmethods;

public class sendmessage {

	public static String fileName = "config.Configuration";

	static List<SmsAndMailVO> smsandemaillist = new ArrayList<SmsAndMailVO>();
	public static String isServerStatered = null;
	static String json = "";
	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;
	public static String flagIsMailsend ="0";

	public void ScheduleSMSandMail() throws Exception
	// public static void main(String []args) throws Exception
	{
		String recipent = "";

		String flagIsSMSsend = "0";
		 flagIsMailsend = "0";
		int noOfAttempt = 1;
		JSONObject objDataJson = new JSONObject();

		sendmessage sm = new sendmessage();
		if (isServerStatered == null) {
			FormFlowXCommonFB fb = new FormFlowXCommonFB();
			fb.setServiceName("/getData/getmaillist");
			String json = "";

			JSONObject filtervo = null;

			try {
				filtervo = new JSONObject();
				filtervo.put("seatId", "10001");
				filtervo.put("hospitalCode", "3726001");
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
				//System.out.println("CallService " + e.getMessage());
			} finally {
				// Usefulmethods.writeInResponse(response, json, true);
			}

			JSONArray jsonArray = objDataJson.getJSONArray("data");

			for (int i = 0; i < jsonArray.length(); i++) {

				// store each object in JSONObject
				JSONObject explrObject = jsonArray.getJSONObject(i);

				// get field value from JSONObject using get() method

				SmsAndMailVO objSmsAndMailVO = new SmsAndMailVO();
				objSmsAndMailVO.setMailRecipient(String.valueOf(explrObject.get("recepient")));
				objSmsAndMailVO.setMailText(String.valueOf(explrObject.get("emailtext")));
				objSmsAndMailVO.setSno(String.valueOf(explrObject.get("emailSlno")));
				objSmsAndMailVO.setEmailSubject(String.valueOf(explrObject.get("emailsubject")));
				objSmsAndMailVO.setFlagIsMailsend("0");
				smsandemaillist.add(objSmsAndMailVO);

			}

		}

		if (smsandemaillist.size() != 0) {

			for (SmsAndMailVO objSmsAndMailVO : smsandemaillist) {

				flagIsMailsend = objSmsAndMailVO.getFlagIsMailsend();
				try {
					if (objSmsAndMailVO.getMailRecipient() != null && !objSmsAndMailVO.getMailRecipient().equals("")
							&& flagIsMailsend.equals("0"))
						flagIsMailsend = "1";
						sm.popupateDataAndSendMail(objSmsAndMailVO.getMailRecipient(), null,
								objSmsAndMailVO.getEmailName(), objSmsAndMailVO.getEmailSubject(),
								objSmsAndMailVO.getMailText(), objSmsAndMailVO.getSno());
					

				} catch (Exception e) {
					flagIsMailsend = "2";
					System.out.println("Problem while sending mail to " + objSmsAndMailVO.getMailRecipient());
					System.out.println(e.getMessage());
				}
				// noOfAttempt++;
				setLog(objSmsAndMailVO.getSno(), flagIsSMSsend, flagIsMailsend, noOfAttempt);
			}
		}
		smsandemaillist.clear();

	}

	public static void sendMsg(String username, String password, String recipent, String message, String sid,
			String entityid, String sno, String templateId) {
		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		
		// Send SMS API
		String mainUrl = "http://www.smsintegra.com/api/smsapi.aspx?uid=" + username + "&pwd=" + password + "&mobile="
				+ recipent + "&msg=" + message + "&sid=" + sid + "&dt=17042017&entityid=" + entityid + "&tempid="
				+ templateId;
		System.out.println(mainUrl);
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
				// print response
				System.out.println(response);
			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// setLog(sno);

	}

	public void popupateDataAndSendMail(String toEmails, String ccEmails, String toEmailNames, String emailSubject,
			String message, String sno) {

		String emailBody = mailText(toEmailNames, message);
		setMailServerProperties();
		try {
			createEmailMessage(toEmails, ccEmails, toEmailNames, emailSubject, emailBody);
			sendEmail();
			// setLog(sno);
		} catch (MessagingException e) {
			// System.out.println("Mail cannot be send");
			flagIsMailsend = "2";
			e.printStackTrace();
		}
	}

	public void setMailServerProperties() {

		// String emailPort = "465";//gmail's smtp port
		String emailPort = Usefulmethods.getQuery(fileName, "emailPort").trim();
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		//emailProperties.put("mail.smtp.ssl.enable", "true");
		emailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");

	}

	public void createEmailMessage(String toEmails, String ccEmails, String Names, String emailSubject,
			String emailBody) throws AddressException, MessagingException {

		mailSession = Session.getDefaultInstance(emailProperties, null);
		mailSession.setDebug(false);
		emailMessage = new MimeMessage(mailSession);
		//System.out.println("toEmails---" + toEmails);
		emailMessage.setFrom(Usefulmethods.getQuery(fileName, "emailId").trim());
		emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails));

		emailMessage.setSubject(emailSubject);

		emailMessage.setText(emailBody);// for a text email

	}

	public void sendEmail() throws AddressException, MessagingException {

		// String fileName="dashboard.Configuration";
		// String emailHost = "smtp.gmail.com";
		// String emailHost = "mail.tn.gov.in";
		String emailHost = Usefulmethods.getQuery(fileName, "emailHost").trim();

		String fromUser = Usefulmethods.getQuery(fileName, "emailId").trim();
		String fromUserEmailPassword = Usefulmethods.getQuery(fileName, "password").trim();
		//System.out.println("fromUser--" + fromUser + " fromUserEmailPassword==" + fromUserEmailPassword);
		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}

	public static String mailText(String toEmailNames, String customText) {
		
		String mailText = "";
		mailText += customText + "\n";
		return mailText;
	}

	// Function to convert ArrayList<String> to String[]
	public static String[] GetStringArray(ArrayList<String> arr) {

		// declaration and initialise String Array
		String str[] = new String[arr.size()];

		// ArrayList to Array Conversion
		for (int i = 0; i < arr.size(); i++) {

			// Assign each value to String array
			str[i] = arr.get(i);
		}

		return str;
	}

	public static void setLog(String sno, String flagIsSMSsend, String flagIsMailsend, int noOfAttempt) {
		String json = "";
		JSONObject objDataJson = new JSONObject();

		JSONObject filtervo = null;
		FormFlowXCommonFB fb = new FormFlowXCommonFB();
		fb.setServiceName("/DMLSAVE/updatemailstatus");
		try {
			filtervo = new JSONObject();
			
			//JSONObject jsonObj = new JSONObject();

			filtervo.put("primaryKeys", sno);

			filtervo.put("flagIsMailsend", flagIsMailsend);
			//filtervo.put("", jsonObj);

			Usefulmethods objUsefulmethods = new Usefulmethods();
			objDataJson = objUsefulmethods.callService(filtervo, fb.getServiceName());

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("CallService " + e.getMessage());
		} finally {
			// Usefulmethods.writeInResponse(response, json, true);
		}

	}

}
