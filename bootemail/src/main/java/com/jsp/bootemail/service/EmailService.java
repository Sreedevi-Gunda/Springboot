package com.jsp.bootemail.service;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.jsp.bootemail.dto.Email;
import com.jsp.bootemail.dto.Emails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	JavaMailSender mailSender;
	

	public void sendMsg(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());

		message.setText(email.getBody());
		message.setFrom("sreedevigunda80@gmail.com");
		mailSender.send(message);

	}
	
	public void sendMsgs(Emails email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());

		message.setText(email.getBody());
		message.setFrom("sreedevigunda80@gmail.com");
		mailSender.send(message);

	}
	
	public void sendHtmlEmail(Email email) throws MessagingException {
	    MimeMessage message = mailSender.createMimeMessage();

	    message.setFrom(new InternetAddress("sreedevigunda80@gmail.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, "sreedevigunda80@gmail.com");
	    message.setSubject("Test email from Spring");

	    String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
	                         "<p>It can contain <strong>HTML</strong> content.</p>";
	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    mailSender.send(message);
	}
	
	public void sendEmailWithAttachment(String to, String subject, String body) throws MessagingException, IOException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body);

		FileSystemResource file = new FileSystemResource(new File("C:\\Users\\Sree Devi\\Pictures\\whitelotus.jpg"));
		helper.addAttachment("image.jpg", file);

		mailSender.send(message);
		}
	
//file.getFilename() image default name
}
