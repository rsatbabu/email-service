package com.ppe.emailservice.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.orderevent.repository.OrderEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppe.emailservice.orderevent.entity.OrderEventEntity;

@RestController
public class EmailController {

	@Autowired
	private OrderEventRepository orderEventRepository;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/processOrderEventsForEmail")
	public void processOrderEventsForEmail() {
		System.out.println("called");
		// Simulate a Consumer reading from MQ
		List<OrderEventEntity> orderEventEntities = orderEventRepository.findByEmailconsumedFalse();

		// Send an email to customer
		orderEventEntities.stream().forEach(orderEventEntity -> {
			
			orderEventEntity.setEmailconsumed(true);

		});
		System.out.println("Email sent!!!");
		// -- Simulate a consumer committing the record in MQ
		orderEventRepository.saveAll(orderEventEntities);
	}



}
