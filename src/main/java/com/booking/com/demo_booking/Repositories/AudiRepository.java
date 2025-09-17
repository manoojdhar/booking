package com.booking.com.demo_booking.Repositories;

import com.booking.com.demo_booking.Entity.Audi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AudiRepository extends JpaRepository<Audi, Long> {
    @Query("SELECT a FROM Audi a WHERE a.theatre.id = :theatreId")
    List<Audi> findByTheatreId(@Param("theatreId") Long theatreId);

//    @Query("SELECT a from Audi a where a.id = :audiId and a.theatre.id = :theatreId")
    Optional<Audi> findByIdAndTheatreId(@Param("audiId") Long audiId, @Param("theatreId") Long theatreId);

}
