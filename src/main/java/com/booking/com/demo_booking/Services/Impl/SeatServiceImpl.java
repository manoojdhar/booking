package com.booking.com.demo_booking.Services.Impl;

import com.booking.com.demo_booking.Entity.Audi;
import com.booking.com.demo_booking.Entity.Seat;
import com.booking.com.demo_booking.Entity.SeatCategory;
import com.booking.com.demo_booking.Entity.SeatStatus;
import com.booking.com.demo_booking.Repositories.SeatRepository;
import com.booking.com.demo_booking.Services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public void saveAllSeats(List<Seat> seats) {
        seatRepository.saveAll(seats);
    }

    @Override
    public List<Seat> getAvailableSeats(Audi audi) {
        return seatRepository.findByAudiAndStatus(audi, SeatStatus.AVAILABLE);
    }

    @Override
    public void bookSeats(List<Long> seatIds) {
        List<Seat> seats = seatRepository.findAllById(seatIds);
        for (Seat seat : seats) {
            if (seat.getStatus() == SeatStatus.AVAILABLE) {
                seat.setStatus(SeatStatus.BOOKED);
            } else {
                throw new IllegalStateException("Seat already booked or held: " + seat.getId());
            }
        }
        seatRepository.saveAll(seats);
    }

    private SeatCategory determineCategory(char row, int seatNumber) {
        if (row >= 'A' && row <= 'C') {
            return SeatCategory.VIP;
        } else if (row >= 'D' && row <= 'F') {
            return SeatCategory.PREMIUM;
        } else {
            return SeatCategory.REGULAR;
        }
    }

    @Override
    public List<Seat> findSeatByAudiId(Long audiId) {
        return seatRepository.findByAudiId(audiId);
    }

}
