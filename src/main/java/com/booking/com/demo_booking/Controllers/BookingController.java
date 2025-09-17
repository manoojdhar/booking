package com.booking.com.demo_booking.Controllers;

import com.booking.com.demo_booking.DTO.BookingDTO;
import com.booking.com.demo_booking.Entity.Booking;
import com.booking.com.demo_booking.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    // Autowired BookingService to perform CRUD operations on the bookings
    @Autowired
    private BookingService bookingService;

    // bookTicket is a method that books a ticket for a movie
    @PostMapping
    public ResponseEntity<String> bookShow(@RequestBody BookingDTO bookingDTO) {
        bookingService.bookShow(bookingDTO);
        return ResponseEntity.ok("Ticket booked successfully");
    }

    // getAllBookings is a method that returns all the bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        System.out.println("Booking List to be printed");
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
