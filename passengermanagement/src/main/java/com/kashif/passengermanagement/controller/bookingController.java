package com.kashif.passengermanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kashif.passengermanagement.dto.BookingRequest;
import com.kashif.passengermanagement.dto.BookingResponse;
import com.kashif.passengermanagement.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/booking")
@AllArgsConstructor

public class bookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createBooking(@RequestBody BookingRequest bookingRequest) {
        bookingService.createBooking(bookingRequest);
        return "Booking created successfully";
    }

    @GetMapping("/list/{rideid}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookingResponse> getAllBookings(@PathVariable("rideid") int id) {
        return bookingService.getAllBookings(id);
    }

    @GetMapping("/show/{bookingid}")
    @ResponseStatus(HttpStatus.OK)
    private BookingResponse getBooking(@PathVariable("bookingid") int id) {
        return bookingService.getBooking(id);
    }

}
