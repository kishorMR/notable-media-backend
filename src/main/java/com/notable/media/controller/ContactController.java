package com.notable.media.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notable.media.dto.ContactRequest;
import com.notable.media.service.EmailService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "https://notable-media-frontend.onrender.com")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String submitForm(
            @RequestBody ContactRequest request) {

        emailService.sendContactMail(
                request.getName(),
                request.getEmail(),
                request.getMessage());

        return "Message Sent Successfully";
    }
}