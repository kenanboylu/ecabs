package com.ecabs.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;

@SpringBootApplication
@EnableScheduling
public class BookingApplication{

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}
}
