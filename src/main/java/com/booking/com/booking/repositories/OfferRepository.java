package com.booking.com.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.Offers;

// OfferRepository is a repository interface that extends JpaRepository and provides methods to perform database operations on the offers
// It is annotated with @Repository to indicate that it is a repository interface
@Repository 
public interface OfferRepository extends JpaRepository<Offers, Long> {
    
    // getOfferByName is a method that returns an offer by name
    public List<Offers> getOfferByName(String name);
}
