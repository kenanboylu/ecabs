package com.ecabs.booking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecabs.booking.model.Booking;
import com.ecabs.booking.repository.BookingRepository;

@Component
public class BookingConsumerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingConsumerService.class);
	

	@Autowired
	BookingRepository repository;
	
	
	@RabbitListener(queues = {"BookingAddQueue"})
	public void addBookConsumer(Booking booking) {
		LOGGER.info("Received message from BookingAddQueue: " + booking.toString());
		repository.save(booking);
	}
	
	@RabbitListener(queues = {"BookingEditQueue"})
	public void editBookConsumer(Booking booking) {
		LOGGER.info("Received message from BookingEditQueue: " + booking.toString());
		repository.save(booking);
	}
	
	@RabbitListener(queues = {"BookingDeleteQueue"})
	public void deleteBookConsumer(Booking booking) {
		LOGGER.info("Received message from BookingDeleteQueue: " + booking.toString());
		repository.delete(booking);
	}
	
	@RabbitListener(queues = {"MessageAuditQueue"})
	public void auditLogConsumer(Booking booking) {
		LOGGER.info("Received message from MessageAuditQueue: " + booking.toString());
	}
}
