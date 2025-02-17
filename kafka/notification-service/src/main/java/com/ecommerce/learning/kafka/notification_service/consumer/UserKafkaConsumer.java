package com.ecommerce.learning.kafka.notification_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ecommerce.learning.kafka.notification_service.event.UserCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserKafkaConsumer {

	@KafkaListener(topics = "user-created-topic")
	public void handleUserCreated(UserCreatedEvent userCreatedEvent) {
		log.info("handleUserCreated: {}", userCreatedEvent);
	}

	@KafkaListener(topics = "user-random-topic")
	public void handleUserRandomTopic1(String message) {

		log.info("handleUserRandomTopic1:  {}", message);
	}

	@KafkaListener(topics = "user-random-topic")
	public void handleUserRandomTopic2(String message) {

		log.info("handleUserRandomTopic2: {}", message);
	}

	@KafkaListener(topics = "user-random-topic")
	public void handleUserRandomTopic3(String message) {

		log.info("handleUserRandomTopic3: {}", message);
	}

}
