package com.booking.com.demo_booking.Repositories;

import com.booking.com.demo_booking.Entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Query("""
            SELECT ss FROM ShowSeat ss
                WHERE ss.show.id = :showId AND ss.status = 'AVAILABLE' AND ss.seatNumber IN :seats
        """)
    List<ShowSeat> findAvailableRequestedSeatsByShowId(@Param("showId") Long showId, @Param("seats") List<String> seats);

    @Query("""
            SELECT ss FROM ShowSeat ss
                WHERE ss.show.id = :showId AND ss.status = 'LOCKED' AND ss.seatNumber IN :seats
        """)
    List<ShowSeat> findLockedRequestedSeatsByShowId(@Param("showId") Long showId, @Param("seats") List<String> seats);

    ShowSeat findByShowId(Long showId);
}
