package com.ecabs.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecabs.booking.model.Booking;
import com.ecabs.booking.repository.BookingRepository;
import com.ecabs.booking.service.BookingProducerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


@RestController
@RequestMapping("/")
@Api(value = "Booking Rest Api")
public class BookingController {
	
	@Autowired
	BookingProducerService producerService;
	
	@Autowired
	BookingRepository repository;
	
	private static final String ROUTING_KEY_ADD = "add";
	private static final String ROUTING_KEY_EDIT= "edit";
	private static final String ROUTING_KEY_DELETE = "delete";
	
	@RequestMapping(value = "/Booking/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "create new booking")
	public ResponseEntity<?> createBooking(@Valid @RequestBody Booking booking) {
		if(booking != null) {
			booking.setCreatedOn(new Date());
			booking.setModifiedOn(new Date());
		}
		String response = producerService.sendMessage(ROUTING_KEY_ADD, booking);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Booking/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "edit booking")
	public ResponseEntity<?> updateBooking(@Valid @PathVariable Long id, @RequestBody Booking booking) {
		Optional<Booking> bookingOld = repository.findById(id);
		
		if(!bookingOld.isPresent())
			return new ResponseEntity<>("Record Not Found", HttpStatus.NOT_FOUND);
		
		Booking bookingEdited = bookingOld.get();
		bookingEdited.setPassengerName(booking.getPassengerName());
		bookingEdited.setAsap(booking.getAsap());
		bookingEdited.setContractNumber(booking.getContractNumber());
		bookingEdited.setNumberOfPassengers(booking.getNumberOfPassengers());
		bookingEdited.setPickupTime(booking.getPickupTime());
		bookingEdited.setPrice(booking.getPrice());
		bookingEdited.setWaittingTime(booking.getWaittingTime());
		bookingEdited.setModifiedOn(new Date());
		String response = producerService.sendMessage(ROUTING_KEY_EDIT, bookingEdited);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Booking/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete booking")
	public ResponseEntity<?> deleteBooking(@Valid @PathVariable Long id) {
		Optional<Booking> booking = repository.findById(id);
		if(!booking.isPresent())
			return new ResponseEntity<>("Record Not Found", HttpStatus.NOT_FOUND);
		String response = producerService.sendMessage(ROUTING_KEY_DELETE, booking.get());
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	
	@RequestMapping(value = "/Booking/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "list bookings")
	public ResponseEntity<?> getAllBooking(@Valid @PathVariable Long id) {
		List<Booking> response = producerService.getAllBook();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
