package com.lti.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lti.entity.Booking;
import com.lti.entity.Bus;
import com.lti.exception.BusNotFoundException;

public interface BookingService {
	
	List<Booking> getAllBookingDetails();
	public ResponseEntity<?> createBooking(Booking newBooking);

	public Booking updateBooking(Booking changedBooking);

	public String deleteBooking(int bookingId);

	public ResponseEntity<?> findBookingById(int bookingId);
	
	
	

}
