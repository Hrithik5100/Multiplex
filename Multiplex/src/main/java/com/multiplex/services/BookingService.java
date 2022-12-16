package com.multiplex.services;

import java.util.List;

import com.multiplex.dto.BookingDTO;
import com.multiplex.entities.Booking;
import com.multiplex.exception.BookingNotFoundException;

public interface BookingService {
	public List<BookingDTO> getAllBookings() throws BookingNotFoundException;
	public Booking addBooking(BookingDTO bookingDTO);
	public BookingDTO getBookingById(Integer bookId) throws BookingNotFoundException;
	public void deleteBookingById(Integer bookId) throws BookingNotFoundException;

}
