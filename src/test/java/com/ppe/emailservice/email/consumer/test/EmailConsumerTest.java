package com.ppe.emailservice.email.consumer.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest()
public class EmailConsumerTest {
	private static final String TEMPLATE_TOPIC = "OrderEvent";

	@ClassRule
	public static EmbeddedKafkaRule embeddedKafka = new EmbeddedKafkaRule(1, true, TEMPLATE_TOPIC);
}
