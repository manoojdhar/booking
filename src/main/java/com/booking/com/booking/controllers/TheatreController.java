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

import com.booking.com.booking.Entity.Theatre;
import com.booking.com.booking.services.TheatreService;

@RestController 
@RequestMapping("/api/v1/theatres")
public class TheatreController {
    
    @Autowired
    private TheatreService theatreService;
    
    @GetMapping
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        return ResponseEntity.ok(theatreService.getTheatres());
    }

    @PostMapping
    public ResponseEntity<String> addTheatre(@RequestBody Theatre theatre) {
        theatreService.addTheatre(theatre);
        return ResponseEntity.ok("Theatre added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable Long id) {
        return ResponseEntity.ok(theatreService.getTheatreById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
        return ResponseEntity.ok("Theatre deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTheatre(@PathVariable Long id, @RequestBody Theatre theatre) {
        theatreService.updateTheatre(id, theatre);
        return ResponseEntity.ok("Theatre updated successfully");
    }
}
