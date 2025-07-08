package SmsAndMail;

public class SmsAndMailVO {

		private String smsRecipient;
		
		private String smsText;
		
		private String mailRecipient;
		
		private String mailText;
		
		private String emailSubject;
		
		private String emailName;
		
		private String responseStatus;
		
		private String sno;
		
		private String flagIsSMSsend;
		private String flagIsMailsend;
		private String numberOfAttempt;
		
		private String entityId;
		
		private String templateId;
		

		public String getEmailSubject() {
			return emailSubject;
		}

		public void setEmailSubject(String emailSubject) {
			this.emailSubject = emailSubject;
		}

		public String getEmailName() {
			return emailName;
		}

		public void setEmailName(String emailName) {
			this.emailName = emailName;
		}

		public String getSno() {
			return sno;
		}

		public void setSno(String sno) {
			this.sno = sno;
		}

		public String getSmsRecipient() {
			return smsRecipient;
		}

		public void setSmsRecipient(String smsRecipient) {
			this.smsRecipient = smsRecipient;
		}

		public String getSmsText() {
			return smsText;
		}

		public void setSmsText(String smsText) {
			this.smsText = smsText;
		}

		public String getMailRecipient() {
			return mailRecipient;
		}

		public void setMailRecipient(String mailRecipient) {
			this.mailRecipient = mailRecipient;
		}

		public String getMailText() {
			return mailText;
		}

		public void setMailText(String mailText) {
			this.mailText = mailText;
		}

		public String getResponseStatus() {
			return responseStatus;
		}

		public void setResponseStatus(String responseStatus) {
			this.responseStatus = responseStatus;
		}

		public String getFlagIsSMSsend() {
			return flagIsSMSsend;
		}

		public void setFlagIsSMSsend(String flagIsSMSsend) {
			this.flagIsSMSsend = flagIsSMSsend;
		}

		public String getFlagIsMailsend() {
			return flagIsMailsend;
		}

		public void setFlagIsMailsend(String flagIsMailsend) {
			this.flagIsMailsend = flagIsMailsend;
		}

		public String getNumberOfAttempt() {
			return numberOfAttempt;
		}

		public void setNumberOfAttempt(String numberOfAttempt) {
			this.numberOfAttempt = numberOfAttempt;
		}

		public String getEntityId() {
			return entityId;
		}

		public void setEntityId(String entityId) {
			this.entityId = entityId;
		}

		public String getTemplateId() {
			return templateId;
		}

		public void setTemplateId(String templateId) {
			this.templateId = templateId;
		}
		
		
		
		
		
	
}
