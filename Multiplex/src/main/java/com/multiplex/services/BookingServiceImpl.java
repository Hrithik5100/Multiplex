package com.multiplex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.BookingDTO;
import com.multiplex.entities.Booking;
import com.multiplex.exception.BookingNotFoundException;
import com.multiplex.repository.BookingRepository;
@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<BookingDTO> getAllBookings() throws BookingNotFoundException{
		Iterable<Booking> bookings = bookingRepository.findAll();
		List<BookingDTO> booking1 = new ArrayList<>();
		bookings.forEach(booking->{
			BookingDTO booking2 = new BookingDTO();
			booking2.setBookId(booking.getBookId());
			booking2.setUser(booking.getUser());
			booking2.setShow(booking.getShow());
			booking2.setDate(booking.getDate());
			booking2.setTime(booking.getTime());
			booking1.add(booking2);
		});
		if(booking1.isEmpty()) {
			throw new BookingNotFoundException();
		}
		return booking1;
	}

	@Override
	public Booking addBooking(BookingDTO bookingDTO) {
		Booking bookingEntity = new Booking();
		bookingEntity.setBookId(bookingDTO.getBookId());
		bookingEntity.setUser(bookingDTO.getUser());
		bookingEntity.setShow(bookingDTO.getShow());
		bookingEntity.setDate(bookingDTO.getDate());
		bookingEntity.setTime(bookingDTO.getTime());
		Booking booking = bookingRepository.save(bookingEntity);
		return booking;
	}

	@Override
	public BookingDTO getBookingById(Integer bookId) throws BookingNotFoundException{
		Optional<Booking> optional=bookingRepository.findById(bookId);
		Booking booking=optional.orElseThrow(() -> new BookingNotFoundException());
		BookingDTO booking1 = new BookingDTO();
		booking1.setBookId(booking.getBookId());
		booking1.setUser(booking.getUser());
		booking1.setShow(booking.getShow());
		booking1.setTime(booking.getTime());
		return booking1;
	}

	@Override
	public void deleteBookingById(Integer bookId) throws BookingNotFoundException{
		Optional<Booking> optional=bookingRepository.findById(bookId);
		Booking booking=optional.orElseThrow(() -> new BookingNotFoundException());
		BookingDTO booking1 = new BookingDTO();
		booking1.setBookId(booking.getBookId());
		booking1.setUser(booking.getUser());
		booking1.setShow(booking.getShow());
		booking1.setTime(booking.getTime());
		bookingRepository.deleteById(bookId);
	}
}
