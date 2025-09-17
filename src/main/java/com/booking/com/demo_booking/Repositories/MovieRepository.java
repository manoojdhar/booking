package com.booking.com.demo_booking.Repositories;

import com.booking.com.demo_booking.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String name);
//    Optional<Movie> findById(Long id);
   Movie findByTitleAndId(@Param("title") String title, @Param("movieId") Long movieId);
}
