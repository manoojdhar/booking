package com.booking.com.demo_booking.Controllers;

import com.booking.com.demo_booking.DTO.ShowDTO;
import com.booking.com.demo_booking.Entity.Show;
import com.booking.com.demo_booking.Services.AudiService;
import com.booking.com.demo_booking.Services.MovieService;
import com.booking.com.demo_booking.Services.ShowService;
import com.booking.com.demo_booking.Services.TheatreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @Autowired
    MovieService movieService;

    @Autowired
    TheatreService theatreService;

    @Autowired
    AudiService audiService;

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows() {
        return ResponseEntity.ok(showService.listShows());
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@Valid @RequestBody ShowDTO showDTO) {
        /**
         * Steps to be performed
             * Find movie based on movieId in showDTO
             * find audi & theatre given in the payload showDTO
             * startTime and Endtime - (Check if Audi is free in the slot
        */
        boolean conflictingShows = showService.findAvailableShowTime(showDTO);

        System.out.println("Conflicting Check done Successfully");

        if(conflictingShows) {
            throw new IllegalStateException("Conflict detected: Audi is occupied during this slot.");
        }
        return ResponseEntity.ok(showService.saveShowAndSeats(showDTO));
    }

    @GetMapping("/{showId}")
    public void getShowDetails(@PathVariable Long showId) {
        showService.getShowDetails(showId);
    }
}
