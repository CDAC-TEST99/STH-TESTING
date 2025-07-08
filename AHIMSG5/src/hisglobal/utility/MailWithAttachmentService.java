package hisglobal.utility;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailWithAttachmentService {

	
    private final String username;
    private final String password;
    private final String host;
    private final int port;

   public MailWithAttachmentService(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
     //   props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", this.port);

        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public void sendMail(Session session , String fromAddress, String toAddresses, String subject , String body , String[] attachmentPaths) throws MessagingException, IOException {
       
    	
    	String[] receipents = toAddresses.split(",");
    	
    	InternetAddress[] addressestoSend = new InternetAddress[receipents.length];
     	
    	int i= 0;
    	for (String receipent : receipents) {
    		addressestoSend[i++] = new InternetAddress(receipent);
		}
    	
    	Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromAddress));
        message.setRecipients(Message.RecipientType.TO, addressestoSend);
        message.setSubject(subject);

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(body, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        
        if(attachmentPaths != null && attachmentPaths.length > 0 && attachmentPaths[0].trim().length() > 0)
        for (String attachmentPath : attachmentPaths) {
			
        	 MimeBodyPart attachmentPart = new MimeBodyPart();
             attachmentPart.attachFile(getFile(attachmentPath));
             multipart.addBodyPart(attachmentPart);
        	
		}
        
        

        message.setContent(multipart);
        Transport.send(message);
    }

    private File getFile(String filename) {
        try {
            
            return new File(filename);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to find file from resources: " + filename);
        }
    }

}