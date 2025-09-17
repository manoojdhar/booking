package com.booking.com.demo_booking.Controllers;

import com.booking.com.demo_booking.DTO.TheatreDTO;
import com.booking.com.demo_booking.Entity.Theatre;
import com.booking.com.demo_booking.Services.TheatreService;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        return ResponseEntity.ok(theatreService.listTheatres());
    }

    @PostMapping
    public ResponseEntity<Theatre> addTheatre(@Valid @RequestBody Theatre theatre) {
//        Theatre theatre = theatreService.theatreDTOToEntity(theatreDTO);
        System.out.println(theatre.toString());

        return ResponseEntity.ok(theatreService.addTheatre(theatre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theatre> editTheatre(@PathVariable Long id, @RequestBody TheatreDTO theatreDTO) {
        Theatre theatre = theatreService.theatreDTOToEntity(theatreDTO);
//        System.out.println(theatreDTO.getAudis().toString());
        return  ResponseEntity.ok(theatreService.updateTheatre(id, theatre));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Theatre>> getTheTheatre(@PathVariable Long id) {
        return ResponseEntity.ok((theatreService.getTheatreById(id)));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Theatre> DeleteATheatre(@PathVariable Long id) {
        return  ResponseEntity.ok(theatreService.deleteTheatre(id));
    }

    @DeleteMapping
    public ResponseEntity<String> DeleteTheatres() {
        try {
            theatreService.deleteAllTheatres();
            return ResponseEntity.ok("Deleted all Theatres successfully");
        } catch (Exception e) {
            // Log the error if needed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error encountered while deleting Theatres: " + e.getMessage());
        }
    }
}
