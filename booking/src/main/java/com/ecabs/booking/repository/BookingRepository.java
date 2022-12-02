package com.ecabs.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecabs.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
