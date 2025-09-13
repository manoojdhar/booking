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

import com.booking.com.booking.Entity.Show;
import com.booking.com.booking.services.ShowService;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowsController {
    
    @Autowired
    private ShowService showService;

    @PostMapping
    public ResponseEntity<String> addShow(@RequestBody Show show) {
        Show show1 = showService.addShow(show);
        if(show1.getId() != null) {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(show1.getId())
            .toUri();
            return ResponseEntity.created(location).body("Show added successfully");   
        }       
            // System.out.println(show.toString());
        return ResponseEntity.badRequest().body("Show not added");
    }

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows() {
        return ResponseEntity.ok(showService.getShows());   
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Show show = showService.getShowById(id);
        if(show != null) {
            return ResponseEntity.ok(show);
        }
        return ResponseEntity.notFound().build();
    }   

    @PutMapping("/{id}")
    public ResponseEntity<String> updateShow(@PathVariable Long id, @RequestBody Show show) {
        showService.updateShow(id, show);
        return ResponseEntity.ok("Show updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return ResponseEntity.ok("Show deleted successfully");
    }   
}
