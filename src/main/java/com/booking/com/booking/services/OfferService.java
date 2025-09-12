package com.booking.com.booking.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.booking.Entity.Offer;
import com.booking.com.booking.repositories.OfferRepository;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public void addOffer(Offer offer) {
        offerRepository.save(offer);
    }

    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    public void updateOffer(Long id, Offer offer) {
        offerRepository.save(offer);
    }


}

