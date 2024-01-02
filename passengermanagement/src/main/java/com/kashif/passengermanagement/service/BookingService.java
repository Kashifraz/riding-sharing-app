package com.kashif.passengermanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.kashif.passengermanagement.dto.BookingRequest;
import com.kashif.passengermanagement.dto.BookingResponse;
import com.kashif.passengermanagement.model.Booking;
import com.kashif.passengermanagement.repository.BookingRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class BookingService {
    private final BookingRepository bookingRepository;

    public void createBooking(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setRideId(bookingRequest.getRide_id());
        booking.setSeats(bookingRequest.getSeats());
        booking.setUserName(bookingRequest.getUser_name());
        booking.setUserPhone(bookingRequest.getUser_phone());

        bookingRepository.save(booking);
    }

    public List<BookingResponse> getAllBookings(int id) {
        List<Booking> Bookings = bookingRepository.findByRideId(id);

        return Bookings.stream().map(Booking -> mapToBookingResponse(Booking)).toList();
    }

    private BookingResponse mapToBookingResponse(Booking booking) {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setId(booking.getId());
        bookingResponse.setRide_id(booking.getRideId());
        bookingResponse.setSeats(booking.getSeats());
        bookingResponse.setUser_name(booking.getUserName());
        bookingResponse.setUser_phone(booking.getUserPhone());
        return bookingResponse;
    }

    public BookingResponse getBooking(long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            BookingResponse bookingResponse = mapToBookingResponse(booking);
            return bookingResponse;
        }

        return null;
    }
}
