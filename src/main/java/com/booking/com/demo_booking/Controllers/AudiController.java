package com.booking.com.demo_booking.Controllers;

import com.booking.com.demo_booking.DTO.AudiLayoutDTO;
import com.booking.com.demo_booking.Entity.Audi;
import com.booking.com.demo_booking.Entity.Seat;
import com.booking.com.demo_booking.Repositories.AudiRepository;
import com.booking.com.demo_booking.Services.AudiService;
import com.booking.com.demo_booking.Services.SeatService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audi")
public class AudiController {

    @Autowired
    AudiService audiService;

    @Autowired
    SeatService seatService;

    @Autowired
    AudiRepository audiRepository;

    @GetMapping("/{theatreId}")
    public ResponseEntity<List<Audi>> getAllAudi(@NotNull @PathVariable Long theatreId) {
    // Get the Audi's for the given theatre.
        return ResponseEntity.ok(audiService.listAllAudi(theatreId));
    }

    @PostMapping
    public ResponseEntity<String> generateSeats(@RequestBody AudiLayoutDTO request) {
        System.out.println("Let build the Audi Seat Layout");
        audiService.createAudiLayout(request);
        return ResponseEntity.ok("Seats generated successfully");
    }

    @GetMapping("/{audiId}/seats")
    public ResponseEntity<List<Seat>> getSeatLayout(@PathVariable Long audiId) {
        Audi audi = audiRepository.findById(audiId)
                .orElseThrow(() -> new EntityNotFoundException("Audi not found"));
        return ResponseEntity.ok(seatService.findSeatByAudiId(audiId));
    }



}
