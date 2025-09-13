package com.booking.com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.Offers;

@Repository 
public interface OfferRepository extends JpaRepository<Offers, Long> {
    
}
