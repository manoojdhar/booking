package com.booking.com.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.com.booking.Entity.Audi;

public interface AudiRepository extends JpaRepository<Audi, Long> {   
    List<Audi> findByTheatreId(Long theatreId);
    
}
