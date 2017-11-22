package com.bridgeit.utility;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Email {

	@Async
	public Boolean registrationEmail(String to,String jwToken) {
		Boolean status;
		String url="http://localhost:8080/SpringHibernateExample/activate/"+jwToken;
		final String from = "strangedoctor786@gmail.com";// change accordingly
		final String password = "deadpool";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587"); // TLS Port
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, password);
			}
		};
		Session session = Session.getDefaultInstance(properties, authenticator);
		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Registration Confirmation");
			message.setSentDate(new Date());
			
			message.setText("Hello, Click on given link for complete your registration "+url);

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");
			status=true;

		} catch (MessagingException mex) {
			mex.printStackTrace();
			status=false;
		}
		return status;
	}

	@Async
	public Boolean forgetEmail(String to,String userPassword) {
		Boolean status;
		final String from = "strangedoctor786@gmail.com";// change accordingly
		final String password = "deadpool";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587"); // TLS Port
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, password);
			}
		};
		Session session = Session.getDefaultInstance(properties, authenticator);
		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Password");
			message.setSentDate(new Date());
			
			message.setText("Hello, your Password is :"+userPassword);

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");
			status=true;

		} catch (MessagingException mex) {
			mex.printStackTrace();
			status=false;
		}
		return status;
	}

}
