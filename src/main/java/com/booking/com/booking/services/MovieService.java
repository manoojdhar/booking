package com.booking.com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.booking.Entity.Movie;
import com.booking.com.booking.repositories.MovieRepository;

// MovieService is a service class that handles the movies and provides methods to perform CRUD operations on the movies
// It is annotated with @Service to indicate that it is a service class
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // getMovies is a method that returns all the movies
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    // addMovie is a method that adds a movie
    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    // getMovieById is a method that returns a movie by id
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    // deleteMovie is a method that deletes a movie by id
    public Movie deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        movieRepository.deleteById(id); 
        return movie;
    }

    // updateMovie is a method that updates a movie by id
    public Movie updateMovie(Long id, Movie movie) {
        Movie movie1 = movieRepository.findById(id).orElse(null);
        movieRepository.save(movie);
        return movie1;  
    }
}
