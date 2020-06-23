package com.ppe.emailservice.email.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.ObjectMapper;
//@Service
public class EmailConsumer {
	   private final Logger logger = LoggerFactory.getLogger(EmailConsumer.class);
	    
		@Autowired
		private ObjectMapper objectMapper;

	    @KafkaListener(topics = "test1", groupId = "group_id_email_service")
	    public void consume(String message) throws IOException {
	        logger.info("#### -> Sent Email -> {}", message);

		
	    }
}
