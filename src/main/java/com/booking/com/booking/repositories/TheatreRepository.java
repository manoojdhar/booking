package com.booking.com.booking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.com.booking.Entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    Optional<Theatre> findByName(String name);
    Optional<Theatre> findByLocation(String location);
    Optional<Theatre> findByNameAndCity(String name, String city);

    
}
