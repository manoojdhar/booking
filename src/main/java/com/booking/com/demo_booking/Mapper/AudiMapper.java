package com.booking.com.demo_booking.Mapper;

import com.booking.com.demo_booking.DTO.AudiDTO;
import com.booking.com.demo_booking.Entity.Audi;
import com.booking.com.demo_booking.Entity.Theatre;

public class AudiMapper {
    // Convert Audi entity to AudiDTO
    public static AudiDTO toDTO(Audi audi) {
        if (audi == null) {
            return null;
        }

        AudiDTO dto = new AudiDTO();
        dto.setId(audi.getId());
        dto.setName(audi.getName());
        dto.setImage(audi.getImage());
        dto.setCapacity(audi.getCapacity());
        dto.setTheatreId(audi.getTheatre() != null ? audi.getTheatre().getId() : null);
        dto.setStatus(audi.isStatus());
        dto.setCreatedAt(audi.getCreatedAt());
        dto.setUpdatedAt(audi.getUpdatedAt());
        return dto;
    }

    // Convert AudiDTO to Audi entity
    public static Audi toEntity(AudiDTO dto, Theatre theatre) {
        if (dto == null) {
            return null;
        }

        Audi audi = new Audi();
        audi.setId(dto.getId());
        audi.setRows(dto.getRows());
        audi.setSeatsPerRow(dto.getSeatsPerRow());
        audi.setName(dto.getName());
        audi.setImage(dto.getImage());
        audi.setCapacity(dto.getCapacity());
        audi.setTheatre(theatre); // theatre must be fetched beforehand
        audi.setStatus(dto.isStatus());
        // createdAt and updatedAt are usually auto-managed by JPA, so we might skip setting them manually
        return audi;
    }
}
