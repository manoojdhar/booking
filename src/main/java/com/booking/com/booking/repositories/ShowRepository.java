package com.booking.com.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.Show;

// ShowRepository is a repository interface that extends JpaRepository and provides methods to perform database operations on the shows
// It is annotated with @Repository to indicate that it is a repository interface
@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    
    // Custom search operations
    // getShowById is a method that returns a show by id
    List<Show> findByMovieId(Long movieId);
    // getShowByAudiId is a method that returns a show by audi id
    List<Show> findByAudiId(Long audiId);
    // getShowByOfferId is a method that returns a show by offer id
    List<Show> findByOfferId(Long offerId);
    // getShowByTheatreId is a method that returns a show by theatre id
    List<Show> findByTheatreId(Long theatreId);
}
