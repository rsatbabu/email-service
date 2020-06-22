package com.ppe.emailservice.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppe.emailservice.orderevent.entity.OrderEventEntity;
import com.ppe.emailservice.orderevent.repository.OrderEventRepository;

@RestController
public class EmailController {

	@Autowired
	private OrderEventRepository orderEventRepository;

	/**
	 * This function simulates a kafka consumer reading from a message queue
	 * and sending an email confirmation to the customers.
	 * 
	 */
	//@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping("/processOrderEventsForEmail")
	public void processOrderEventsForEmail() {
		System.out.println("called");
		// Simulate a Consumer reading from MQ
		List<OrderEventEntity> orderEventEntities = orderEventRepository.findByEmailconsumedFalse();

		// Send an email to customer after reading the message from the Queue
		orderEventEntities.stream().forEach(orderEventEntity -> {
			
			orderEventEntity.setEmailconsumed(true);

		});
		System.out.println("Email sent!!!");
		// -- Simulate a consumer committing the record in MQ
		orderEventRepository.saveAll(orderEventEntities);
	}



}
