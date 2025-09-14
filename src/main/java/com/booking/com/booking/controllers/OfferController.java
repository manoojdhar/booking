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

import com.booking.com.booking.Entity.Offers;
import com.booking.com.booking.services.OfferService;

// OfferController is a controller class that handles the offers
@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {
    
    @Autowired
    private OfferService offerService;
    
    // getAllOffers is a method that returns all the offers
    @GetMapping
    public ResponseEntity<List<Offers>> getAllOffers() {
        return ResponseEntity.ok(offerService.getOffers());
    }

    // postOffer is a method that adds an offer
    @PostMapping    
    public ResponseEntity<Offers> postOffer(@RequestBody Offers offer) {
        return ResponseEntity.ok(offerService.addOffer(offer));
    }

    // addOffer is a method that adds an offer
    public ResponseEntity<Offers> addOffer(@RequestBody Offers offer) {
        System.out.println("Welcome: "+ offer);
        offerService.addOffer(offer);
        return ResponseEntity.ok(offer);
    }

    // getOfferById is a method that returns an offer by id
    @GetMapping("/{id}")
    public ResponseEntity<Offers> getOfferById(@PathVariable Long id) {
        return ResponseEntity.ok(offerService.getOfferById(id));
    }

    // deleteOffer is a method that deletes an offer by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        return ResponseEntity.ok("Offer deleted successfully");
    }

    // updateOffer is a method that updates an offer by id
    @PutMapping("/{id}")
    public ResponseEntity<Offers> updateOffer(@PathVariable Long id, @RequestBody Offers offer) {
        Offers offer1 = offerService.updateOffer(id, offer);
        return ResponseEntity.ok(offer1);
    }

    // getOfferByName is a method that returns an offer by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Offers>> getOfferByName(@PathVariable String name) {
        return ResponseEntity.ok(offerService.getOfferByName(name));
    }
}
