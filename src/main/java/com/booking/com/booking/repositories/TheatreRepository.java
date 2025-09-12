package com.booking.com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.com.booking.dto.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    
}
