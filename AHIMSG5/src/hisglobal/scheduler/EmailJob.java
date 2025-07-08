package hisglobal.scheduler;

import java.util.Base64;
import java.util.List;

import hisglobal.utility.JdbcConnection;
import hisglobal.utility.MailWithAttachmentService;

public class EmailJob {

	public static void startEmailJob() {

		
		String selectEmailstoSend = "SELECT ced.gnum_client_code, ced.gnum_email_sent_id,  "
				+ "	 ced.gstr_to_address, ced.gstr_subject, ced.gstr_body, ced.gstr_attachment_paths, "
				+ "	ced.gdt_schedule_time , ces.gstr_smtp_user, ces.gstr_smtp_pwd , ces.gstr_smtp_server,"
				+ "	 ces.gstr_smtp_port, ces.gstr_smtp_security, ces.gstr_smtp_auth"
				+ " FROM usm.gblt_client_email_details ced , usm.gblt_client_email_setup ces "
				+ " where ced.gnum_isvalid = 1 "  
				//+ " and ced.gnum_client_code = ces.gnum_client_code" 
				+ " and ced.gnum_isvalid = ces.gnum_isvalid "
				+ " and ced.gdt_schedule_time <= now() limit 10 ";

		 System.out.println(selectEmailstoSend);
		
		String insertLog = "INSERT INTO usm.gblt_client_email_details_log("
				+ "	gnum_client_code, gnum_email_sent_id, gstr_from_address, gstr_to_address, "
				+ "	gstr_subject, gstr_body, gstr_attachment_paths, gdt_schedule_time, gdt_send_time ,"
				+ "	gdt_entrydate, gnum_isvalid, gnum_seatid)"
				+ "	SELECT gnum_client_code, gnum_email_sent_id, gstr_from_address, gstr_to_address, gstr_subject, "
				+ "	gstr_body, gstr_attachment_paths, gdt_schedule_time, now()  , now(), gnum_isvalid, gnum_seatid"
				+ "	FROM usm.gblt_client_email_details where   gnum_email_sent_id in (?) ";

		String deleteQry = " delete FROM usm.gblt_client_email_details where  gnum_email_sent_id in (?) ";

		List<Object[]> rs = null;

		String mailSendIdList = "0";
		String[] attachments = null;
		try {

			rs = JdbcConnection.getQryResultList(selectEmailstoSend, null);

			if (rs != null) {

				for (Object[] objects : rs) {

				//	System.out.println("inside query");
					
					// String clientCode = rs.getString(1);
					String mailSentId = (String) objects[1];
					String toAddress = (String) objects[2];
					String subject = (String) objects[3];
					String body = (String) objects[4];
					String attachPaths = (String) objects[5];

					String fromAddress = (String) objects[7];
					String password = (String) objects[8];
					String server = (String) objects[9];
					String port = (String) objects[10];

					// String security = rs.getString(12);
					// String auth = rs.getString(13);

					mailSendIdList = mailSendIdList + "," + mailSentId;

					MailWithAttachmentService mailService = new MailWithAttachmentService(fromAddress,
							new String(Base64.getDecoder().decode(password)), server, Integer.parseInt(port));

					if(attachPaths != null && attachPaths.trim().length() > 0) {
						
						attachments =  attachPaths.split(",");
						
					}
					
					

					mailService.sendMail(mailService.getSession(), fromAddress, toAddress, subject+" - UAT", body, attachments);

				}

				if (mailSendIdList.length() > 1) {

					JdbcConnection.executeUpdate(insertLog.replace("?", mailSendIdList));

					JdbcConnection.executeUpdate(deleteQry.replace("?", mailSendIdList));

				}

			}

		} catch (Exception e) {

			System.err.println(e);

		}

	}
}
