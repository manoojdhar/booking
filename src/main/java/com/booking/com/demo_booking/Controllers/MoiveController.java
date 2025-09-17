package com.booking.com.demo_booking.Controllers;

import com.booking.com.demo_booking.DTO.MovieDTO;
import com.booking.com.demo_booking.Entity.Movie;
import com.booking.com.demo_booking.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoiveController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.listMovies());
    }

    @PostMapping
    public ResponseEntity<Movie> addAMovie(@RequestBody MovieDTO movieDTO) {
        Movie movie = dtoToEntity(movieDTO);
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping
    public ResponseEntity<Movie> updateMovieDetails(@RequestBody MovieDTO movieDTO) {
        Movie movie = dtoToEntity(movieDTO);
        return ResponseEntity.ok(movieService.updateMovieDtl(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.deleteMovie(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Movie>> searchMovieByName(String name) {
        return ResponseEntity.ok(movieService.findByName(name));
    }

//    DTO to Entity Mapping
    public Movie dtoToEntity(MovieDTO dto) {
        return Movie.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .poster(dto.getPoster())
                .trailer(dto.getTrailer())
                .director(dto.getDirector())
                .cast(dto.getCast())
                .genre(dto.getGenre())
                .releaseDate(dto.getReleaseDate())
                .rating(dto.getRating())
                .durationMinutes(dto.getDurationMinutes())
                .language(dto.getLanguage())
                .status(dto.getStatus())
                .offerEligible(dto.isOfferEligible())
                .userId(dto.getUserId())
                .build();
    }
}
