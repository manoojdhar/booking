package com.booking.com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.com.booking.Entity.Movie;
import com.booking.com.booking.services.MovieService;

// MovieController will handle all the movie related requests
// default mapping is /api/v1/movies
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    
    // Autowired MovieService which is responsible for business logic and data access and transaction management
    @Autowired
    public MovieService movieService;

    // Get all movies
    @GetMapping 
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    // Add movie
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    // Get movie by id
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    // Delete movie
    @DeleteMapping("/{id}")
    public Movie deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }

    // Update movie
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }
}