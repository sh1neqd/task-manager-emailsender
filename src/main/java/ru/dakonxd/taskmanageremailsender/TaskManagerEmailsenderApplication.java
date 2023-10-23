package ru.dakonxd.taskmanageremailsender;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.dakonxd.taskmanageremailsender.service.rabbitmq.RabbitConsumer;

@SpringBootApplication
public class TaskManagerEmailsenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerEmailsenderApplication.class, args);
	}

}
