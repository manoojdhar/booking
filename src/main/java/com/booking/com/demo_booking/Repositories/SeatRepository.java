package com.booking.com.demo_booking.Repositories;

import com.booking.com.demo_booking.Entity.Audi;
import com.booking.com.demo_booking.Entity.Seat;
import com.booking.com.demo_booking.Entity.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query("SELECT s FROM Seat s WHERE s.audi.id = :audiId")
    List<Seat> findByAudiId(@Param("audiId") Long audiId);
    List<Seat> findByAudiAndStatus(Audi audi, SeatStatus status);
}
