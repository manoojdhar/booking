package com.booking.com.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.Audi;
import com.booking.com.booking.Entity.AudiSeats;

// AudiRepository is a repository interface that extends JpaRepository and provides methods to perform database operations on the audis
// It is annotated with @Repository to indicate that it is a repository interface
@Repository
public interface AudiRepository extends JpaRepository<Audi, Long> {   
    List<Audi> findByTheatreId(Long theatreId);
    List<AudiSeats> findSeatsByAudiId(Long audiId);
}