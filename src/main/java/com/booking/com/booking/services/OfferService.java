package com.booking.com.booking.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.booking.Entity.Offers;
import com.booking.com.booking.repositories.OfferRepository;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<Offers> getOffers() {
        return offerRepository.findAll();
    }

    public Offers addOffer(Offers offer) {
        if(offer.getEndDate().isBefore(offer.getStartDate())) {
            throw new RuntimeException("End date should be after start date");
        }
        offerRepository.save(offer);
        return offer;
    }

    public Offers getOfferById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    public Offers updateOffer(Long id, Offers offer) {
        Offers offer1 = offerRepository.findById(id).orElse(null);
        if(offer.getEndDate().isBefore(offer.getStartDate())) {
            throw new RuntimeException("End date should be after start date");
        } else if (offer1 != null) {
            offer1.setId(id);
            offer1.setName(offer.getName());
            offer1.setDescription(offer.getDescription());
            offer1.setDiscount(offer.getDiscount());
            // offer1.setStartDate(offer.getStartDate());
            offer1.setEndDate(offer.getEndDate());
            offer1.setIsActive(offer.getIsActive());
            // System.out.println(offer1);
            offerRepository.save(offer1);
        } else {
            throw new RuntimeException("Offer not found");
        }
        return offer1;
    }


}

