package com.booking.com.demo_booking.Services.Impl;

import com.booking.com.demo_booking.DTO.AudiLayoutDTO;
import com.booking.com.demo_booking.Entity.*;
import com.booking.com.demo_booking.Repositories.AudiRepository;
import com.booking.com.demo_booking.Repositories.SeatRepository;
import com.booking.com.demo_booking.Services.AudiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AudiServiceImpl implements AudiService {

    @Autowired
    private final AudiRepository audiRepository;
    @Autowired
    private final SeatRepository seatRepository;

    @Override
    public List<Audi> listAllAudi(Long id) {
        return audiRepository.findByTheatreId(id);
    }

    @Override
    public Optional<Audi> findAudiByTheatreId(Long audiId, Long theatreId) {
        return audiRepository.findByIdAndTheatreId(audiId, theatreId);
    }

    @Override
    public void createAudiLayout(AudiLayoutDTO audiRequest) {
        Audi audi = audiRepository.findByIdAndTheatreId(audiRequest.getAudiId(), audiRequest.getTheatreId())
                .orElseThrow(() -> new RuntimeException("Audi not found"));
        List<Seat> existingSeats = seatRepository.findByAudiId(audi.getId());
        if (!existingSeats.isEmpty()) {
            throw new IllegalStateException("Layout already created.");
        }
        List<Seat> seats = new ArrayList<>();
        Long audi_ii = audi.getId();
        for(int rowIndex = 1; rowIndex <= audi.getRows(); rowIndex++) {
            char rowLetter = (char) ('A' + rowIndex); // e.g., 0 -> A, 1 -> B
            String row = String.valueOf(rowLetter);
            SeatType seatType = getSeatTypeByNumber(rowIndex);
            SeatCategory seatCategory = getSeatCategory(rowIndex);

            for (int col = 1; col <= audi.getSeatsPerRow(); col++) {
                String seatNumber = row + col; // e.g., "A1", "B3"
                Seat seat = Seat.builder()
                        .row(row)
                        .seatNumber(seatNumber)
                        .category(seatCategory)
                        .seatType(seatType)
                        .status(SeatStatus.AVAILABLE)
                        .audi(audi)
                        .build();

                System.out.println("SeatNum::"+ seatNumber + " :Row="+ row + " audi:" + audi_ii);
                seats.add(seat);
            }
        }
        seatRepository.saveAll(seats);
    }

    private SeatCategory getSeatCategory(int rowNum) {
        if (rowNum >= 1 && rowNum <= 4) {
            return SeatCategory.REGULAR;
        } else if (rowNum >= 5 && rowNum <= 8) {
            return SeatCategory.PREMIUM;
        } else if (rowNum >= 9 && rowNum <= 10) {
            return SeatCategory.VIP;
        } else {
            throw new IllegalArgumentException("Invalid seat number: " + rowNum);
        }
    }

    private SeatType getSeatTypeByNumber(int rowNum) {
        if (rowNum >= 1 && rowNum <= 4) {
            return SeatType.STANDARD;
        } else if (rowNum >= 5 && rowNum <= 8) {
            return SeatType.SOFA;
        } else if (rowNum >= 9 && rowNum <= 10) {
            return SeatType.MOTORIZED_RECLINER;
        } else {
            throw new IllegalArgumentException("Invalid seat number: " + rowNum);
        }
    }
}
