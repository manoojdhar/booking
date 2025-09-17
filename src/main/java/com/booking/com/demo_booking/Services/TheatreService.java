package com.booking.com.demo_booking.Services;

import com.booking.com.demo_booking.DTO.TheatreDTO;
import com.booking.com.demo_booking.Entity.Theatre;
import jakarta.validation.constraints.NotNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TheatreService {

    @Transactional
    // Add Theatre with Audis and Shows
    Theatre addTheatre(Theatre theatre);

    // Get All Theatres
    List<Theatre> listTheatres();

    // Get Theatre by ID
    Optional<Theatre> getTheatreById(Long id);

    // Delete Theatre with Audis and Shows
    Theatre deleteTheatre(Long id);

    // Update Theatre with Audis and Shows
    Theatre updateTheatre(Long id, Theatre updateRequest);

    // Delete All Theatres from the system
    public void deleteAllTheatres();

    // 1. Create the theatre first
    @NotNull
    public Theatre theatreDTOToEntity(TheatreDTO dto);

}
