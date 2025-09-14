package com.booking.com.booking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.Movie;

// MovieRepository is a repository interface that extends JpaRepository and provides methods to perform database operations on the movies
// It is annotated with @Repository to indicate that it is a repository interface
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByOfferEligibleTrue();
}
