package com.booking.com.booking.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.booking.Entity.Offers;
import com.booking.com.booking.repositories.OfferRepository;

// OfferService is a service class that handles the offers and provides methods to perform CRUD operations on the offers
// It is annotated with @Service to indicate that it is a service class
// It is used to perform database operations
@Service
public class OfferService {

    // offerRepository is a repository object that is used to perform database operations
    @Autowired
    private OfferRepository offerRepository;

    // getOffers is a method that returns all the offers
    public List<Offers> getOffers() {
        return offerRepository.findAll();
    }

    // addOffer is a method that adds an offer
    public Offers addOffer(Offers offer) {
        if(offer.getEndDate().isBefore(offer.getStartDate())) {
            throw new RuntimeException("End date should be after start date");
        }
        offerRepository.save(offer);
        return offer;
    }

    // getOfferById is a method that returns an offer by id
    public Offers getOfferById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

    // deleteOffer is a method that deletes an offer by id
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    // updateOffer is a method that updates an offer by id
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

    // getOfferByName is a method that returns an offer by name
    public List<Offers> getOfferByName(String name) {
        return offerRepository.getOfferByName(name);
    }


}

