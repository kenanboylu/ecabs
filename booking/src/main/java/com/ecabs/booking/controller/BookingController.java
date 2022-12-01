package com.ecabs.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecabs.booking.model.Booking;
import com.ecabs.booking.service.BookingProducerService;

import javax.validation.Valid;


@RestController
@RequestMapping("/")
public class BookingController {
	
	@Autowired
	BookingProducerService service;
	
	@RequestMapping(value = "/Booking/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createBook(@Valid @RequestBody Booking booking) {
		String response = service.createBook(booking);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Booking/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateBook(@Valid @PathVariable Long id, @RequestBody Booking booking) {
		String response = service.updateBook(booking);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Booking/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteBook(@Valid @PathVariable Long id,  @RequestBody Booking booking) {
		String response = service.deleteBook(booking);
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 

}
