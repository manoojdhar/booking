package com.booking.com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
        
}
