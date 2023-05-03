package com.vinciusvieira.server.domain.services;

import com.vinciusvieira.server.domain.models.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static jakarta.mail.Message.RecipientType.TO;

@RequiredArgsConstructor
@Service
public class EnviarEmailService {
    private final JavaMailSender mailSender;

    public void enviarEmailSimples(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());

        mailSender.send(message);
    }

    public void enviarEmailHtml(Email email) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(new InternetAddress(System.getenv("GMAIL")));
        message.setRecipients(TO, email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setContent(email.getBody(), "text/html; charset=utf-8");

        mailSender.send(message);
    }
}
