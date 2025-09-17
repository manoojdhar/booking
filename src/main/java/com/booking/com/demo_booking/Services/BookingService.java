package com.booking.com.demo_booking.Services;

import com.booking.com.demo_booking.DTO.BookingDTO;
import com.booking.com.demo_booking.Entity.Booking;

import java.util.List;

public interface BookingService {

    void bookShow(BookingDTO bookingDTO);
    List<Booking> getBookings();
}
