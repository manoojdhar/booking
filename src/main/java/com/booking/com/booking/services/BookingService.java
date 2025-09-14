package com.booking.com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.booking.Entity.Booking;
import com.booking.com.booking.Entity.Seat;
import com.booking.com.booking.repositories.BookingRepository;
import com.booking.com.booking.repositories.SeatRepository;
import org.springframework.transaction.annotation.Transactional;

// BookingService is a service class that handles the bookings and provides methods to perform CRUD operations on the bookings
// It is annotated with @Service to indicate that it is a service class
@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    // bookTicket is a method that books a ticket
    @Transactional
    public Booking bookTicket(Booking booking) {
        // Fetch requested seats using pessimistic lock
        List<Seat> seats = seatRepository.findAvailableSeatsWithLock(
        booking.getShow().getId(),
        booking.getAudi().getId(),
        booking.getSeatNumbers()
        );

        // Validate: All requested seats must be AVAILABLE
        if (seats.size() < booking.getSeatNumbers().size()) {
            throw new RuntimeException("Some seats are already booked.");
        }

        // Mark seats as BOOKED
        for (Seat seat : seats) {
            seat.setStatus(Seat.SeatStatus.BOOKED);
        }

        // Create and save booking
        bookingRepository.save(booking);

        // Link seats to booking
        for (Seat seat : seats) {
            seat.setBooking(booking);
        }

        seatRepository.saveAll(seats);
        return booking;
    }
    
    @Autowired
    private SeatRepository seatRepository;

    // getMovies is a method that returns all the movies
    public List<Booking> getMovies() {
        return bookingRepository.findAll();
    }

    // deleteBooking is a method that deletes a booking by id
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    // getBookingById is a method that returns a booking by id
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    // updateBooking is a method that updates a booking by id
    public void updateBooking(Long id, Booking booking) {
        // find the booking by id to be updated
        Booking existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking != null) {
            // update the booking object with new values
            existingBooking.setMovieName(booking.getMovieName());
            existingBooking.setTheatreName(booking.getTheatreName());
            existingBooking.setShowTime(booking.getShowTime());
            existingBooking.setSeatNumbers(booking.getSeatNumbers());
            existingBooking.setOfferCode(booking.getOfferCode());
            bookingRepository.save(existingBooking);
        }
    }

    // getBookings is a method that returns all the bookings
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }
}
