package com.ecabs.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecabs.booking.model.Booking;
import com.ecabs.booking.repository.BookingRepository;

@Component
public class BookingProducerService {
	

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	MessageConverter converter;
	
	@Autowired
	MessageConverter messageConverter;
	
	@Autowired
	BookingRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingProducerService.class);
	private static final String EXCHANGE = "message-exchange";
	
	
	
	public String sendMessage(String routingKey, Booking booking) {
		this.rabbitTemplate.setMessageConverter(converter);
		rabbitTemplate.convertAndSend(EXCHANGE, routingKey, booking);
		return "message is sent!";
	}
	
	public List<Booking> getAllBook() {
		List<Booking> list = repository.findAll();
		return list;
	}

}
