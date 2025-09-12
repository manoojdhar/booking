package com.booking.com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.booking.Entity.Booking;
import com.booking.com.booking.repositories.BookingRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public void bookTicket(Booking booking) {
        System.out.println("BookingService.bookTicket() called");
        bookingRepository.save(booking);
    }

    public List<Booking> getMovies() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
    public void updateBooking(Long id, Booking booking) {
        Booking booking1 = bookingRepository.findById(id).orElse(null);
        if (booking1 != null) {
            booking1.setMovieName(booking.getMovieName());
            booking1.setTheatreName(booking.getTheatreName());
            booking1.setShowTime(booking.getShowTime());
            booking1.setSeatNumber(booking.getSeatNumber());
            booking1.setOfferCode(booking.getOfferCode());
            bookingRepository.save(booking1);
        }
    }
}
