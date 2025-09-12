package com.booking.com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.com.booking.dto.Booking;
import com.booking.com.booking.services.BookingService;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> bookTicket(@RequestBody Booking booking) {
        bookingService.bookTicket(booking);
        return ResponseEntity.ok("Ticket booked successfully");
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getMovies());
    }

    @GetMapping("/health")
    public ResponseEntity<String> getBookingById() {
        return ResponseEntity.ok("Booking service is up and running");
    }
}
