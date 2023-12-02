package requestsmanagement;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import userinterface.PrintUtils;

import java.util.Properties;

public class EmailSender {
	
	      private EmailSender() {
	    	  
	      }
	        public static void sendEmail(String to, String subject, String body) {
	        final String username = "gameboxjsd2023@gmail.com"; // replace with your email
	        final String password = "pidj svlq nxel nohb"; // replace with your email password

	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com"); // replace with your SMTP server
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	                new Authenticator() {
	                    @Override
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	            message.setSubject(subject);
	            message.setText(body);

	            Transport.send(message);

	            PrintUtils.println("Email confirmation sent successfully!");

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }
	}



