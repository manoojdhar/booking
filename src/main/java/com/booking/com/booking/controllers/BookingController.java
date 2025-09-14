package com.booking.com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.com.booking.Entity.Booking;
import com.booking.com.booking.services.BookingService;

// BookingController is a controller class that handles the bookings and provides methods to perform CRUD operations on the bookings
// It is annotated with @RestController to indicate that it is a controller class.
// It is annotated with @RequestMapping to indicate the base URL for all the requests.
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    
    // Autowired BookingService to perform CRUD operations on the bookings
    @Autowired
    private BookingService bookingService;

    // bookTicket is a method that books a ticket for a movie
    @PostMapping
    public ResponseEntity<String> bookTicket(@RequestBody Booking booking) {
        bookingService.bookTicket(booking);
        return ResponseEntity.ok("Ticket booked successfully");
    }

    // getAllBookings is a method that returns all the bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getBookings()); 
    }

    // getBookingById is a method that returns a booking by id
    @GetMapping("/{id}")
    public ResponseEntity<String> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok("Booking service is up and running");
    }

    // updateBooking is a method that updates a booking by id
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return ResponseEntity.ok("Booking service is up and running");
    }

    // deleteBooking is a method that deletes a booking by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        return ResponseEntity.ok("Booking service is up and running");
    }
}
