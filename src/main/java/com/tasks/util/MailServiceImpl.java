package com.tasks.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

    @Autowired
    JavaMailSender emailSender;
	  
	  
	public void  sendMails(String mails, String msg, String naslov) {
		
		String[] splited = mails.split(",");
		
		SimpleMailMessage message = new SimpleMailMessage(); 
    	message.setFrom("jakovsudar5@gmail.com");
    	message.setTo(splited);
    	message.setSubject(naslov);
    	message.setText(msg);
    	
    	emailSender.send(message);
	}
}
