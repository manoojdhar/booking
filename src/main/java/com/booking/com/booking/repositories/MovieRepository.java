package com.booking.com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.com.booking.Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
