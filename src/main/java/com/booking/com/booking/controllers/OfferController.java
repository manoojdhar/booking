package com.booking.com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.com.booking.Entity.Offer;
import com.booking.com.booking.services.OfferService;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {
    
    @Autowired
    private OfferService offerService;
    
    @GetMapping
    public ResponseEntity<List<Offer>> getAllOffers() {
        return ResponseEntity.ok(offerService.getOffers());
    }

    @PostMapping
    public ResponseEntity<String> addOffer(@RequestBody Offer offer) {
        offerService.addOffer(offer);
        return ResponseEntity.ok("Offer added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long id) {
        return ResponseEntity.ok(offerService.getOfferById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        return ResponseEntity.ok("Offer deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOffer(@PathVariable Long id, @RequestBody Offer offer) {
        offerService.updateOffer(id, offer);
        return ResponseEntity.ok("Offer updated successfully");
    }
}
