package hisglobal.scheduler;

import java.util.List;

import hisglobal.utility.JdbcConnection;
import hisglobal.utility.SMSServices;

public class SMSJob {

	public static void startSmsJob() {
 

		String selectEmailstoSend = "SELECT ced.gnum_client_code, ced.gnum_sms_sent_id,  "
				+ "	 ced.gstr_to_mobileno, ced.gstr_sms, ced.gdt_schedule_time , "
				+ " ces.gstr_senderid, ces.gstr_user , ces.gstr_pwd, ces.gstr_url , ces.gstr_secure_key "
				+ " FROM usm.gblt_client_sms_details ced , usm.gblt_client_sms_setup ces "
				+ " where ced.gnum_isvalid = 1 "  
				//+ " and ced.gnum_client_code = ces.gnum_client_code" 
				+ " and ced.gnum_isvalid = ces.gnum_isvalid "
				+ " and ced.gdt_schedule_time <= now() limit 10 ";

		 System.out.println(selectEmailstoSend);
		
		String insertLog = "INSERT INTO usm.gblt_client_sms_details_log( " + 
				"	gnum_client_code, gnum_sms_sent_id, gstr_to_mobileno, gstr_sms, gstr_templateid, " + 
				"	gdt_schedule_time, gdt_entrydate, gnum_isvalid, gnum_seatid) " + 
				"SELECT gnum_client_code, gnum_sms_sent_id, gstr_to_mobileno, gstr_sms, gstr_templateid, " + 
				"gdt_schedule_time, now(), gnum_isvalid, gnum_seatid " + 
				"	FROM usm.gblt_client_sms_details where gnum_sms_sent_id in (?) ";

		String deleteQry = " delete FROM usm.gblt_client_sms_details where  gnum_sms_sent_id in (?) ";

		List<Object[]> rs = null;

		String smsSendList = "0";
	 
		try {

			rs = JdbcConnection.getQryResultList(selectEmailstoSend, null);

			if (rs != null) {

				for (Object[] objects : rs) {

				//	System.out.println("inside query");
					
					// String clientCode = rs.getString(1);
					String mailSentId = (String) objects[1];
					String toMobile = (String) objects[2];
					String message = (String) objects[3];
					
					String senderId = (String) objects[5];
					
					String username = (String) objects[6];
					String password = (String) objects[7];
					String url = (String) objects[8];
					String secureKey = (String) objects[9];

					// String security = rs.getString(12);
					// String auth = rs.getString(13);

					smsSendList = smsSendList + "," + mailSentId;

					SMSServices.sendBulkSMS(username, password, message, senderId, toMobile, secureKey , url);

				}

				if (smsSendList.length() > 1) {

					JdbcConnection.executeUpdate(insertLog.replace("?", smsSendList));

					JdbcConnection.executeUpdate(deleteQry.replace("?", smsSendList));

				}

			}

		} catch (Exception e) {

			System.err.println(e);

		}


	}
}
