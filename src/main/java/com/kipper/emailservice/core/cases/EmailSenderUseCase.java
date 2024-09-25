package com.kipper.emailservice.core.cases;

// Contract for EmailSender implementation that is EmailSenderService

public interface EmailSenderUseCase {
    void sendEmail(String toEmail, String subject, String body);
}
