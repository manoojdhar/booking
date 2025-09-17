package com.booking.com.demo_booking.Controllers;

import com.booking.com.demo_booking.DTO.OfferDTO;
import com.booking.com.demo_booking.Entity.Offer;
import com.booking.com.demo_booking.Mapper.OfferMapper;
import com.booking.com.demo_booking.Services.OfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {

    @Autowired
    OfferService offerService;

    @GetMapping
    public ResponseEntity<List<Offer>> getOffers() {
        return ResponseEntity.ok(offerService.listAllOffers());
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@Valid @RequestBody OfferDTO offerDTO) {
        offerDTO.setId(null);
        Offer offer = OfferMapper.toEntity(offerDTO);
        return ResponseEntity.ok(offerService.addOffer(offer));
    }

    @PutMapping
    public ResponseEntity<Offer> updateOffer(@Valid @RequestBody OfferDTO offerDTO) {
        System.out.println("Welcome");
        Offer offer = OfferMapper.toEntity(offerDTO);
        return ResponseEntity.ok(offerService.updateOffer(offer));
    }
}
