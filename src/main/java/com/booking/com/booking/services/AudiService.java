package com.booking.com.booking.services;

import com.booking.com.booking.Entity.Audi;
import com.booking.com.booking.repositories.AudiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudiService {

    @Autowired
    private AudiRepository audiRepository;

    public Audi addAudi(Audi audi) {
        return audiRepository.save(audi);
    }

    public List<Audi> getAudis() {
        return audiRepository.findAll();
    }

    public Audi getAudiById(Long id) {
        return audiRepository.findById(id).orElse(null);
    }

    public boolean deleteAudi(Long id) {
        if (audiRepository.existsById(id)) {
            audiRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Audi updateAudi(Long id, Audi updatedAudi) {
        return audiRepository.findById(id).map(existing -> {
            existing.setName(updatedAudi.getName());
            existing.setCapacity(updatedAudi.getCapacity());
            existing.setImage(updatedAudi.getImage());
            // Do not update `theatre` directly unless you want to reassign
            return audiRepository.save(existing);
        }).orElse(null);
    }
}
