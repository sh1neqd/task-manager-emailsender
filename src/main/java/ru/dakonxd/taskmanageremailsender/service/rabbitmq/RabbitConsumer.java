package ru.dakonxd.taskmanageremailsender.service.rabbitmq;

import com.rabbitmq.client.AMQP;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.dakonxd.taskmanageremailsender.model.dto.EmailDto;
import ru.dakonxd.taskmanageremailsender.service.ConsumerHandler;

@EnableRabbit
@Component
@RequiredArgsConstructor
public class RabbitConsumer {
    private Logger logger = LoggerFactory.getLogger(RabbitConsumer.class);
    private final ConsumerHandler consumerHandler;

    @RabbitListener(queues = "${rabbit.queue}")
    public void consume(String message) {
        consumerHandler.handle(message);
        logger.info(message);
    }

}
