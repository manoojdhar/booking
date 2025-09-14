package com.booking.com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.Booking;

// BookingRepository is a repository interface that extends JpaRepository and provides methods to perform database operations on the bookings
// It is annotated with @Repository to indicate that it is a repository interface
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
        
}
