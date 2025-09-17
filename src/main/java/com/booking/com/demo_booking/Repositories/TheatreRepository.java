package com.booking.com.demo_booking.Repositories;

import com.booking.com.demo_booking.Entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    Optional<Theatre> findByName(String name);
    Optional<Theatre> findByLocation(String location);
    Optional<Theatre> findByNameAndCity(String name, String city);
}
