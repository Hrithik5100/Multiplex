package com.multiplex.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.BookingDTO;
import com.multiplex.entities.Booking;
import com.multiplex.exception.BookingNotFoundException;
import com.multiplex.services.BookingService;

@RestController
@ResponseBody
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@GetMapping(value="/booking")
	public ResponseEntity<List<BookingDTO>> getAllBookings() throws BookingNotFoundException {
		List<BookingDTO> bookingList=bookingService.getAllBookings();
		return new ResponseEntity<List<BookingDTO>>(bookingList,HttpStatus.OK);
	}
	
	@PostMapping(value="/booking")
	public ResponseEntity<String> addBooking(@RequestBody BookingDTO bookingDTO){
		Booking bookingId=bookingService.addBooking(bookingDTO);
		return new ResponseEntity<String>("API.INSERT_CREATED", HttpStatus.OK);
	}
	
	@GetMapping(value="/booking/{bookingId}")
	public ResponseEntity<BookingDTO> getBookingById(@PathVariable Integer bookingId) throws BookingNotFoundException{
		BookingDTO booking=bookingService.getBookingById(bookingId);
		return new ResponseEntity<BookingDTO>(booking, HttpStatus.OK);
	}
	@DeleteMapping(value="/booking/{bookingId}")
		public ResponseEntity deleteBookingById(@PathVariable Integer bookingId) throws BookingNotFoundException {
			bookingService.deleteBookingById(bookingId);
			return new ResponseEntity("API.DELETE_SUCCESS", HttpStatus.OK);
		}
	

}

