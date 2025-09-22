package com.booking.com.demo_booking.Repositories;

import com.booking.com.demo_booking.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByBookingId(Long bookingId);
    Booking findByBookingIdAndMovieId(Long bookingId, Long movieId);
    Booking findByBookingIdAndMovieIdAndUserId(Long bookingId, Long movieId, Long userId);
    Booking findByBookingIdAndMovieIdAndUserIdAndShowId(Long bookingId, Long movieId, Long userId, Long showId);
    Booking findByBookingIdAndMovieIdAndUserIdAndShowIdAndSeatId(Long bookingId, Long movieId, Long userId, Long showId, Long seatId);
    Booking findByBookingIdAndMovieIdAndUserIdAndShowIdAndSeatIdAndScreenId(Long bookingId, Long movieId, Long userId, Long showId, Long seatId, Long screenId);
}
