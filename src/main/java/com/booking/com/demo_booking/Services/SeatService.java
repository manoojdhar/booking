package com.booking.com.demo_booking.Services;

import com.booking.com.demo_booking.Entity.Audi;
import com.booking.com.demo_booking.Entity.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getAvailableSeats(Audi audi);
    void bookSeats(List<Long> seatIds);
    List<Seat> findSeatByAudiId(Long audiId);
    void saveAllSeats(List<Seat> seats);


    //    public void generateSeatsForAudi(Audi audi, int totalRows, int seatsPerRow) {
//        List<Seat> seats = new ArrayList<>();
//
//        for (int r = 0; r < totalRows; r++) {
//            char rowChar = (char) ('A' + r);
//            String row = String.valueOf(rowChar);
//            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
//                SeatCategory category = determineCategory(rowChar, seatNum);
//                String seatNumber = rowChar + String.valueOf(seatNum);
//                Seat seat = Seat.builder()
//                        .audi(audi)
//                        .row(row)
//                        .seatNumber(seatNumber)
//                        .category(category)
//                        .status(SeatStatus.AVAILABLE)
//                        .build();
//
//                seats.add(seat);
//            }
//        }
//
//        audi.setSeats(seats);

//        seatRepository.saveAll(seats); // persist
//    }
//
//    private SeatCategory determineCategory(char row, int seatNumber) {
//        if (row >= 'A' && row <= 'C') {
//            return SeatCategory.VIP;
//        } else if (row >= 'D' && row <= 'F') {
//            return SeatCategory.PREMIUM;
//        } else {
//            return SeatCategory.REGULAR;
//        }

//    }

}
