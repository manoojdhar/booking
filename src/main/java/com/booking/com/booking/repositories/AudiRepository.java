package com.booking.com.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.Audi;

@Repository
public interface AudiRepository extends JpaRepository<Audi, Long> {   
    List<Audi> findByTheatreId(Long theatreId);
}