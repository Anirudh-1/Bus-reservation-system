package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.BookingDao;
import com.lti.entity.Booking;
import com.lti.entity.Bus;
import com.lti.exception.BusNotFoundException;

@Service
public class BookingServiceImpl  implements BookingService{
	
	@Autowired
	BookingDao bookingdao;
 
	@Override
	public List<Booking> getAllBookingDetails() {
		// TODO Auto-generated method stub
		return bookingdao.findAll();
	}

	@Override
     public ResponseEntity<Booking> createBooking(Booking newBooking) {
	
			Optional<Booking> findBookingById = bookingdao.findById(newBooking.getBookingId());
			
				if (!findBookingById.isPresent()) {
					bookingdao.save(newBooking);
					
				} 
		return null;
	}
	
	@Override
	public Booking updateBooking(Booking changedBooking) {
		
	
		Optional<Booking> findBookingById = bookingdao.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			bookingdao.save(changedBooking);
		} 
		return changedBooking;
	}


	@Override

	public String deleteBooking(int bookingId) {
		Optional<Booking> findBookingById = bookingdao.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingdao.deleteById(bookingId);
		}
			return "Booking Deleted!!";
		
	}

	@Override
	public ResponseEntity<?> findBookingById(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}
	}

