package com.pickndrive.services;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sendMail;
	
	public void sendSimpleEmail(String toEmail,
            String body,
            String subject) throws MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
		
		//message.setFrom("jagu0506@gmail.com");
		message.setFrom("pickndrivecdac@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		System.out.println(toEmail);
		System.out.println(body);
		System.out.println(subject);
		
		//Another Way
		
		//MimeMessage message=sendMail.createMimeMessage();
		//MimeMessageHelper helper=new MimeMessageHelper(message);
		//helper.setFrom("jagu0506@gmail.com");
		//helper.setTo(toEmail);
		//helper.setText(body);
		//helper.setSubject(subject);
		
		sendMail.send(message);
		
		System.out.println("Mail Send...");
}
}
