package com.booking.com.demo_booking.Services.Impl;

import com.booking.com.demo_booking.Entity.Movie;
import com.booking.com.demo_booking.Repositories.MovieRepository;
import com.booking.com.demo_booking.Services.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie addMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @Override
    public Movie updateMovieDtl(Movie updatedMovie) {
        movieRepository.findById(updatedMovie.getId())
                .orElseThrow(() -> new EntityNotFoundException("We couldn't find a movie with details provided to be updated."));
        return movieRepository.save(updatedMovie);
    }

    @Override
    public Movie deleteMovie(Long id) {
        Movie movieToDelete = movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sorry incorrect details"));
        movieRepository.deleteById(id);
        return  movieToDelete;
    }

    @Override
    public List<Movie> findByName(String name) {
        return movieRepository.findByTitle(name);
    }

    @Override
    public Optional<Movie> findById(Long movieId) {
        return movieRepository.findById(movieId);
    }
}
