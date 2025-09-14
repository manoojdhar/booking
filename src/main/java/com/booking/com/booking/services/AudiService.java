package com.booking.com.booking.services;

import com.booking.com.booking.Entity.Audi;
import com.booking.com.booking.Entity.AudiSeats;
import com.booking.com.booking.Entity.AudiSeats.SeatType;
import com.booking.com.booking.repositories.AudiRepository;
import com.booking.com.booking.repositories.AudiSeatsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// AudiService is a service class that handles the audis and provides methods to perform CRUD operations on the audis
// It is annotated with @Service to indicate that it is a service class
@Service
public class AudiService {

    @Autowired
    private AudiRepository audiRepository;

    @Autowired
    private AudiSeatsRepository audiSeatsRepository;
    
    // addAudi is a method that adds an audi
    /**
     * @param audi
     * @return Audi
     */ 
    public Audi addAudi(Audi audi) {
        return audiRepository.save(audi);
    }

    // getAudis is a method that returns all the audis
    /**
     * @return List<Audi>
     */ 
    public List<Audi> getAudis() {
        return audiRepository.findAll();
    }

    // getAudiById is a method that returns an audi by id
    /**
     * @param id
     * @return Audi
     */ 
    public Audi getAudiById(Long id) {
        return audiRepository.findById(id).orElse(null);
    }

    // deleteAudi is a method that deletes an audi by id
    /**
     * @param id
     * @return boolean
     */ 
    public boolean deleteAudi(Long id) {
        if (audiRepository.existsById(id)) {
            audiRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // updateAudi is a method that updates an audi by id
    /**
     * @param id
     * @param updatedAudi
     * @return Audi
     */ 
    public Audi updateAudi(Long id, Audi updatedAudi) {
        return audiRepository.findById(id).map(existing -> {
            existing.setName(updatedAudi.getName());
            existing.setCapacity(updatedAudi.getCapacity());
            existing.setImage(updatedAudi.getImage());
            return audiRepository.save(existing);
        }).orElse(null);
    }

    public List<AudiSeats> getSeatsByAudiId(Long audiId) {
        return audiRepository.findSeatsByAudiId(audiId);
    }

    // addSeats is a method that adds seats to an audi
    /**
     * @param seats
     * @return AudiSeats
     */ 
    public AudiSeats addSeats(AudiSeats seats) {
        return audiSeatsRepository.save(seats);
    }

    // getSeatsById is a method that returns a seat by id
    /**
     * @param id
     * @return AudiSeats
     */ 
    public AudiSeats getSeatsById(Long id) {
        return audiSeatsRepository.findById(id).orElse(null);
    }

    // deleteSeats is a method that deletes a seat by id
    /**
     * @param id
     * @return boolean
     */ 
    public boolean deleteSeats(Long id) {
        if (audiSeatsRepository.existsById(id)) {
            audiSeatsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // existsById is a method that checks if a seat exists by id
    /**
     * @param id
     * @return boolean
     */ 
    public boolean existsById(Long id) {
        return audiSeatsRepository.existsById(id);
    }
    
    // updateSeats is a method that updates a seat by id
    /**
     * @param id
     * @param updatedSeats
     * @return AudiSeats
     */
    public AudiSeats updateSeats(Long id, AudiSeats updatedSeats) {
        return audiSeatsRepository.findById(id).map(existing -> {   
            existing.setSeatNumber(updatedSeats.getSeatNumber());
            existing.setStatus(updatedSeats.getStatus());
            existing.setRowNumber(updatedSeats.getRowNumber());
            existing.setColumnNumber(updatedSeats.getColumnNumber());
            existing.setPrice(updatedSeats.getPrice());
            return audiSeatsRepository.save(existing);
        }).orElse(null);
    }

    // generateSeatsForAudi is a method that generates seats for an audi
    /**
     * @param audiId
     * @param numRows
     * @param seatsPerRow
     */ 
    public void generateSeatsForAudi(Long audiId, int numRows, int seatsPerRow) {
        Audi audi = audiRepository.findById(audiId)
                .orElseThrow(() -> new RuntimeException("Audi not found"));

        List<AudiSeats> seatList = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            char rowChar = (char) ('A' + row);
            SeatType seatType = determineSeatType(row); // e.g. A–C: VIP, D–F: Premium, G–J: Regular

            for (int col = 1; col <= seatsPerRow; col++) {
                String seatNumber = rowChar + String.valueOf(col);

                AudiSeats seat = new AudiSeats(seatNumber,
                        "AVAILABLE",
                        row + 1,
                        col,
                        getPriceBySeatType(seatType),
                        audi,
                        seatType);
                seatList.add(seat);
            }
        }

        audiSeatsRepository.saveAll(seatList);
    }

    // determineSeatType is a method that determines the seat type based on the row index
    /**
     * @param rowIndex
     * @return SeatType
     */
    private SeatType determineSeatType(int rowIndex) {
        if (rowIndex < 3) return SeatType.VIP;        // A–C
        else if (rowIndex < 6) return SeatType.PREMIUM; // D–F
        else return SeatType.REGULAR;                 // G–J
    }

    // getPriceBySeatType is a method that returns the price of a seat based on the seat type
    /**
     * @param type
     * @return int price for the seat type 
     */
    private int getPriceBySeatType(SeatType type) {
        return switch (type) {
            case VIP -> 500;
            case PREMIUM -> 350;
            case REGULAR -> 200;
        };
    }

    // Count available seats of a given type in an audi
    public int countAvailableSeats(Long audiId, AudiSeats.SeatType seatType) {
        return audiSeatsRepository.countByAudiIdAndSeatTypeAndStatus(
                audiId, seatType, "AVAILABLE");
    }

    // Fetch price of seat type (could also come from Audi or Pricing config)
    public int getSeatPrice(Long audiId, AudiSeats.SeatType seatType) {
        return audiSeatsRepository.findAnyByAudiIdAndSeatType(audiId, seatType)
                .map(seat -> seat.getPrice())
                .orElseThrow(() -> new IllegalStateException("Seat pricing not found"));
    }
    
}
