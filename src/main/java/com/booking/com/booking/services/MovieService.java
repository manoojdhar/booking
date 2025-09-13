package com.booking.com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.booking.Entity.Movie;
import com.booking.com.booking.repositories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        movieRepository.deleteById(id); 
        return movie;
    }

    public Movie updateMovie(Long id, Movie movie) {
        Movie movie1 = movieRepository.findById(id).orElse(null);
        movieRepository.save(movie);
        return movie1;  
    }


}
