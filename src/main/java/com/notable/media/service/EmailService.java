package com.notable.media.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactMail(
            String name,
            String email,
            String message) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("kishorgowda435@gmail.com");
        mail.setSubject("New Contact Form Submission");

        mail.setText(
                "Name: " + name + "\n" +
                "Email: " + email + "\n\n" +
                "Message:\n" + message);

        mailSender.send(mail);
    }
}