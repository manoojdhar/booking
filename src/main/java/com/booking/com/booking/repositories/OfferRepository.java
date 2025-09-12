package com.booking.com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.com.booking.dto.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    
}
