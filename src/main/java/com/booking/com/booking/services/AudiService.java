package com.booking.com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.booking.Entity.Audi;
import com.booking.com.booking.repositories.AudiRepository;

@Service    
public class AudiService {
    @Autowired
    private AudiRepository audiRepository;
    public void addAudi(Audi audi) {
        System.out.println("AudiService.addAudi() called");
        audiRepository.save(audi);
    }
    
    public List<Audi> getAudis() {
        return audiRepository.findAll();
    }
    
    public Audi getAudiById(Long id) {
        return audiRepository.findById(id).orElse(null);
    }
    
    public void deleteAudi(Long id) {
        audiRepository.deleteById(id);
    }

    public void updateAudi(Long id, Audi audi) {    
        Audi audi1 = audiRepository.findById(id).orElse(null);
        if (audi1 != null) {
            audi1.setName(audi.getName());
            audi1.setCapacity(audi.getCapacity());
            audi1.setTheatre(audi.getTheatre());
            audi1.setShow(audi.getShow());
            audi1.setCreatedAt(audi.getCreatedAt());
            audi1.setUpdatedAt(audi.getUpdatedAt());
            audiRepository.save(audi1);
        }
    }
}
