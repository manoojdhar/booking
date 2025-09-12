package com.booking.com.booking.controllers;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
       Theatre theatre1 = theatreService.addTheatre(theatre);
       if(theatre1.getId() != null) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(theatre1.getId())
        .toUri();
        return ResponseEntity.created(location).body("Theatre added successfully");   
       }       
        // System.out.println(theatre.toString());
       return ResponseEntity.badRequest().body("Theatre not added");
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
