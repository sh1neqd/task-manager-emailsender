package ru.dakonxd.taskmanageremailsender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dakonxd.taskmanageremailsender.interfaces.Mailer;

@Service
@RequiredArgsConstructor
public class MailerImpl implements Mailer {

    private final EmailService emailService;

    @Override
    public void send(String recipientAdress, String title, String text) {
        emailService.sendSimpleMessage(recipientAdress, title, text);
    }
}
