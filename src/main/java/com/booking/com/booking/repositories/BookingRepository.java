package com.booking.com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.com.booking.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
