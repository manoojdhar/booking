package com.booking.com.demo_booking.Mapper;

import com.booking.com.demo_booking.DTO.SeatDTO;
import com.booking.com.demo_booking.Entity.Audi;
import com.booking.com.demo_booking.Entity.Seat;

public class SeatMapper {
    // Convert Seat entity to SeatDTO
    public static SeatDTO toDTO(Seat seat) {
        if (seat == null) {
            return null;
        }

        SeatDTO dto = new SeatDTO();
        dto.setId(seat.getId());
        dto.setRow(seat.getRow());

        // Convert seatNumber (String) -> int
        try {
            dto.setSeatNumber(Integer.parseInt(seat.getSeatNumber()));
        } catch (NumberFormatException e) {
            // Fallback or default if conversion fails
            dto.setSeatNumber(-1); // Or throw exception if necessary
        }

        dto.setCategory(seat.getCategory());
        dto.setStatus(seat.getStatus());
        return dto;
    }

    // Convert SeatDTO to Seat entity
    public static Seat toEntity(SeatDTO dto, Audi audi) {
        if (dto == null) {
            return null;
        }

        Seat seat = new Seat();
        seat.setId(dto.getId());
        seat.setRow(dto.getRow());
        seat.setSeatNumber(String.valueOf(dto.getSeatNumber())); // Convert int -> String
        seat.setCategory(dto.getCategory());
        seat.setStatus(dto.getStatus());
        seat.setAudi(audi); // Audi must be provided
        return seat;
    }
}
