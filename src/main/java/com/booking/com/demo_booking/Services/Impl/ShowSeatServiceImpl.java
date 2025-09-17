package com.booking.com.demo_booking.Services.Impl;

import com.booking.com.demo_booking.Entity.SeatStatus;
import com.booking.com.demo_booking.Entity.ShowSeat;
import com.booking.com.demo_booking.Repositories.ShowSeatRepository;
import com.booking.com.demo_booking.Services.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {

    @Autowired
    ShowSeatRepository showSeatRepository;

    // Find if seats requested are available
    @Override
    public List<ShowSeat> checkRequestedSeatsAvailablity(Long showId, List<String> requestedSeats) {
        return showSeatRepository.findAvailableRequestedSeatsByShowId(
                showId, requestedSeats);
    }

    // Lock the seats requested for booking - NOTE: USER is not integrated
    @Override
    public boolean lockSeats(Long showId, List<String> seatNumbers, Long userId) {
        List<ShowSeat> seats = showSeatRepository.findAvailableRequestedSeatsByShowId(showId, seatNumbers);

        for (ShowSeat seat : seats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new RuntimeException("Seat " + seat.getSeatNumber() + " is already taken or locked.");
            }
        }

        for (ShowSeat seat : seats) {
            seat.setStatus(SeatStatus.LOCKED);
            seat.setLockedAt(LocalDateTime.now());
        }

        showSeatRepository.saveAll(seats);
        return true;
    }

    @Override
    public void updateLockedSeats(Long showId, List<String> requestedSeats) {
        System.out.println("Going to update the LOCKED seats to BOOKED");
        List<ShowSeat> seats = showSeatRepository.findLockedRequestedSeatsByShowId(showId, requestedSeats);
        for (ShowSeat seat : seats) {
            seat.setStatus(SeatStatus.BOOKED);
            seat.setLockedAt(LocalDateTime.now());
        }
        showSeatRepository.saveAll(seats);
        System.out.println("COMPLETED THE update : LOCKED seats to BOOKED");
    }
}
