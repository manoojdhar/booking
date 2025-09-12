package com.booking.com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.com.booking.dto.Theatre;
import com.booking.com.booking.repositories.TheatreRepository;

@Service    
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    public void addTheatre(Theatre theatre) {
        System.out.println("TheatreService.addTheatre() called");
        theatreRepository.save(theatre);
    }
    
    public List<Theatre> getTheatres() {
        return theatreRepository.findAll();
    }
    
    public Theatre getTheatreById(Long id) {
        return theatreRepository.findById(id).orElse(null);
    }
    
    public void deleteTheatre(Long id) {
        theatreRepository.deleteById(id);
    }

    public void updateTheatre(Long id, Theatre theatre) {
        Theatre theatre1 = theatreRepository.findById(id).orElse(null);
        if (theatre1 != null) {
            theatre1.setName(theatre.getName());
            theatre1.setLocation(theatre.getLocation());
            theatre1.setCity(theatre.getCity());
            theatre1.setState(theatre.getState());
            theatre1.setPincode(theatre.getPincode());
            theatre1.setPhone(theatre.getPhone());
            theatre1.setEmail(theatre.getEmail());
            theatre1.setWebsite(theatre.getWebsite());
            theatre1.setImage(theatre.getImage());
            theatreRepository.save(theatre1);
        }
    }
}
    