package com.booking.com.demo_booking.Services.Impl;

import com.booking.com.demo_booking.Entity.Offer;
import com.booking.com.demo_booking.Repositories.OfferRepository;
import com.booking.com.demo_booking.Services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    OfferRepository offerRepository;

    @Override
    public List<Offer> listAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer updateOffer(Offer offer) {
        System.out.println("Offer proposed: "+offer.toString());
        Offer existingOffer = offerRepository.findById(offer.getId()).orElseThrow(
                () -> new DataIntegrityViolationException("Invalid Request: Please check your request details"));

        existingOffer.setUpdatedAt(LocalDateTime.now());
        existingOffer.setImage(offer.getImage());
        existingOffer.setDescription(offer.getDescription());
        existingOffer.setName(offer.getName());
        existingOffer.setActive(offer.isActive());
        existingOffer.setDiscount(offer.getDiscount());
        existingOffer.setEndDate(offer.getEndDate());
        existingOffer.setStartDate(offer.getStartDate());

        return offerRepository.save(existingOffer);
    }
}
