package com.booking.com.demo_booking.Services;

import com.booking.com.demo_booking.Entity.ShowSeat;

import java.util.List;

public interface ShowSeatService {
    // Find if seats requested are available
    List<ShowSeat> checkRequestedSeatsAvailablity(Long showId, List<String> requestedSeats);

    // Lock the seats requested for booking - NOTE: USER is not integrated
    boolean lockSeats(Long showId, List<String> seatNumbers, Long userId);

    void updateLockedSeats(Long showId, List<String> requestedSeats);
}
