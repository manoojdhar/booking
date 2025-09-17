package com.booking.com.demo_booking.Services;

import com.booking.com.demo_booking.Entity.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {
    List<Movie> listMovies();
    Movie addMovie(Movie newMovie);
    Movie updateMovieDtl(Movie updatedMovie);
    Movie deleteMovie(Long id);
    List<Movie> findByName(String name);
    Optional<Movie> findById(Long movieId);
}

