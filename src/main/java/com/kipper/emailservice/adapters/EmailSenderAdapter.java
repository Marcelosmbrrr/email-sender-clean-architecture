package com.kipper.emailservice.adapters;

// Contract for ALL infra classes

public interface EmailSenderAdapter {
    void sendEmail(String toEmail, String subject, String body);
}
