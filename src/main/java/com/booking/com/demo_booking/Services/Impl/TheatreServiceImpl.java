package com.booking.com.demo_booking.Services.Impl;

import com.booking.com.demo_booking.DTO.AudiDTO;
import com.booking.com.demo_booking.DTO.TheatreDTO;
import com.booking.com.demo_booking.Entity.Audi;
import com.booking.com.demo_booking.Entity.Theatre;
import com.booking.com.demo_booking.Mapper.AudiMapper;
import com.booking.com.demo_booking.Repositories.TheatreRepository;
import com.booking.com.demo_booking.Services.TheatreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TheatreServiceImpl implements TheatreService {
    // Autowired TheatreRepository
    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    // Add Theatre with Audis and Shows
    public Theatre addTheatre(Theatre theatre) {
        System.out.println(theatre);
        theatre.getAudis().forEach(audi -> audi.setTheatre(theatre));
        return theatreRepository.save(theatre);
    }

    // Get All Theatres
    @Override
    public List<Theatre> listTheatres() {
        return theatreRepository.findAll();
    }

    // Get Theatre by ID
    @Override
    public Optional<Theatre> getTheatreById(Long id) {
        return theatreRepository.findById(id);
    }

    // Delete Theatre with Audis and Shows
    @Override
    public Theatre deleteTheatre(Long id) {
        Theatre theatre = theatreRepository.findById(id).orElse(null);
        theatreRepository.deleteById(id);
        return theatre;
    }

    // Update Theatre with Audis and Shows
    @Override
    public Theatre updateTheatre(Long id, Theatre updateRequest) {
        // 1. Fetch theatre by ID
        Theatre existingTheatre = theatreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Theatre with ID " + id + " not found"));

        // 2. Check if another theatre exists with the same name & city
        Optional<Theatre> conflicting = theatreRepository.findByNameAndCity(updateRequest.getName(), updateRequest.getCity());

        // Condition to check if it is a new theatre with existing details such as city and name;
        if (conflicting.isPresent() && !conflicting.get().getId().equals(id)) {
            throw new DataIntegrityViolationException("A theatre with the same name and city already exists.");
        }

        // Update basic fields
        existingTheatre.setName(updateRequest.getName());
        existingTheatre.setLocation(updateRequest.getLocation());
        existingTheatre.setCity(updateRequest.getCity());
        existingTheatre.setState(updateRequest.getState());
        existingTheatre.setPincode(updateRequest.getPincode());
        existingTheatre.setPhone(updateRequest.getPhone());
        existingTheatre.setEmail(updateRequest.getEmail());
        existingTheatre.setWebsite(updateRequest.getWebsite());
        existingTheatre.setImage(updateRequest.getImage());

        // Prepare existing audi's in map
        Map<Long, Audi> existingAudiMap = existingTheatre.getAudis().stream()
                .filter(audi -> audi.getId() != null)
                .collect(Collectors.toMap(Audi::getId, Function.identity()));

        // Now process incoming audi's
        if (updateRequest.getAudis() != null) {
            System.out.println("Print Audi Objects");
            System.out.println(updateRequest.getAudis().toString());
            for (Audi incoming : updateRequest.getAudis()) {
                if (incoming.getId() != null && existingAudiMap.containsKey(incoming.getId())) {
                    // Update existing
                    Audi existingAudi = existingAudiMap.get(incoming.getId());
                    existingAudi.setName(incoming.getName());
                    existingAudi.setRows(incoming.getRows());
//                    existingAudi.setSeats(incoming.getSeats().addAll());
                    existingAudi.setSeatsPerRow(incoming.getSeatsPerRow());
                    existingAudi.setCapacity(incoming.getCapacity());
                    existingAudi.setStatus(incoming.isStatus());
                    if(incoming.getUpdatedAt() != null)
                        existingAudi.setUpdatedAt(incoming.getUpdatedAt());
                    existingAudi.setImage(incoming.getImage());
                } else {
                    // New Audi
                    incoming.setTheatre(existingTheatre);
                    existingTheatre.getAudis().add(incoming);
                }
            }
        }
        return theatreRepository.save(existingTheatre);
    }

    // Delete All Theatres from the system
    @Override
    public void deleteAllTheatres() {
        theatreRepository.deleteAll();
    }

    // 1. Create the theatre first
    @Override
    public Theatre theatreDTOToEntity(TheatreDTO dto) {
        Theatre theatre = Theatre.builder().id(dto.getId())
                .name(dto.getName())
                .location(dto.getLocation())
                .city(dto.getCity())
                .state(dto.getState())
                .pincode(dto.getPincode())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .website(dto.getWebsite())
                .image(dto.getImage())
                .build();

        // 2. Initialize mapper
        AudiMapper audiMapper = new AudiMapper();

        if (dto.getAudis() != null && !dto.getAudis().isEmpty()) {
            for (AudiDTO audiDTO : dto.getAudis()) {
                System.out.println("The Audi DTO is here"+audiDTO.toString());
                Audi audi = audiMapper.toEntity(audiDTO, theatre);  // Only AudiDTO passed
                System.out.println("The Audi Entity is here"+audi.toString());
                theatre.addAudi(audi); // Sets theatre <-> audi both ways
            }
        }
        return theatre;
    }
}
