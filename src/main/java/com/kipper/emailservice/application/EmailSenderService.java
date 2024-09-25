package com.kipper.emailservice.application;

import com.kipper.emailservice.adapters.EmailSenderAdapter;
import com.kipper.emailservice.core.cases.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Use Case Implementation

@Service
public class EmailSenderService implements EmailSenderUseCase {

    // Spring injects the infra class that implements EmailSenderAdapter
    // SesEmailSender implements EmailSenderAdapter
    private final EmailSenderAdapter emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderAdapter emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        emailSenderGateway.sendEmail(toEmail, subject, body);
    }
}
