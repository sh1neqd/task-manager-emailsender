package ru.dakonxd.taskmanageremailsender.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.dakonxd.taskmanageremailsender.model.dto.EmailDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumerHandler {
    private Logger logger = LoggerFactory.getLogger(ConsumerHandler.class);
    private final MailerImpl mailer;

    public void handle(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<EmailDto> emailMessages;
        try {
            emailMessages = objectMapper.readValue(message, new TypeReference<List<EmailDto>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        for(EmailDto emailMessage:emailMessages) {
            String emailAddress = emailMessage.getRecipientAddress();
            try {
                mailer.send(emailAddress, emailMessage.getTitle(), emailMessage.getText());
                logger.info("Email has been sent to address: ${emailMessage.recipientAddress}");
            } catch (Exception e) {
                logger.error("Email sending to address " + emailAddress + "failed. " + e.getMessage());
            }
        }

    }
}
