package com.booking.com.booking.services;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booking.com.booking.Entity.Audi;
import com.booking.com.booking.Entity.Theatre;
import com.booking.com.booking.repositories.TheatreRepository;

// TheatreService is responsible for business logic and data access and transaction management
@Service
public class TheatreService {
    
    // Autowired TheatreRepository 
    @Autowired 
    private TheatreRepository theatreRepository;
    
    
    @Transactional
    // Add Theatre with Audis and Shows
    public Theatre addTheatre(Theatre theatre) {
        theatre.getAudis().forEach(audi -> audi.setTheatre(theatre));
        return theatreRepository.save(theatre);
    }
    
    // Get All Theatres
    public List<Theatre> getTheatres() {
        return theatreRepository.findAll();
    }
    
    // Get Theatre by ID
    public Theatre getTheatreById(Long id) {
        return theatreRepository.findById(id).orElse(null);
    }
    
    // Delete Theatre with Audis and Shows
    public Theatre deleteTheatre(Long id) {
        Theatre theatre = theatreRepository.findById(id).orElse(null);
        theatreRepository.deleteById(id);
        return theatre;
    }

    // Update Theatre with Audis and Shows 
    public Theatre updateTheatre(Long id, Theatre updatedTheatre) {
        Theatre existingTheatre = theatreRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Theatre not found"));
    
        // Update basic fields
        existingTheatre.setName(updatedTheatre.getName());
        existingTheatre.setLocation(updatedTheatre.getLocation());
        existingTheatre.setCity(updatedTheatre.getCity());
        existingTheatre.setState(updatedTheatre.getState());
        existingTheatre.setPincode(updatedTheatre.getPincode());
        existingTheatre.setPhone(updatedTheatre.getPhone());
        existingTheatre.setEmail(updatedTheatre.getEmail());
        existingTheatre.setWebsite(updatedTheatre.getWebsite());
        existingTheatre.setImage(updatedTheatre.getImage());
    
        // Prepare existing audis in map
        Map<Long, Audi> existingAudiMap = existingTheatre.getAudis().stream()
            .filter(audi -> audi.getId() != null)
            .collect(Collectors.toMap(Audi::getId, Function.identity()));
    
        // Now process incoming audis
        if (updatedTheatre.getAudis() != null) {
            for (Audi incoming : updatedTheatre.getAudis()) {
                if (incoming.getId() != null && existingAudiMap.containsKey(incoming.getId())) {
                    // Update existing
                    Audi existingAudi = existingAudiMap.get(incoming.getId());
                    existingAudi.setName(incoming.getName());
                    existingAudi.setCapacity(incoming.getCapacity());
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
    public void deleteAllTheatres() {
        theatreRepository.deleteAll();
    }
    

}
    