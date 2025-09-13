package com.booking.com.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieId(Long movieId);
    List<Show> findByAudiId(Long audiId);
    List<Show> findByOfferId(Long offerId);
    List<Show> findByTheatreId(Long theatreId);
}
