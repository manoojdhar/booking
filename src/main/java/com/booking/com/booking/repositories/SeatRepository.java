package com.booking.com.booking.repositories;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.booking.com.booking.Entity.Seat;
import jakarta.persistence.LockModeType;

public interface SeatRepository {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM Seat s WHERE s.show.id = :showId AND s.audi.id = :audiId AND s.seatNumber IN :seatNumbers AND s.status = 'AVAILABLE'")
    List<Seat> findAvailableSeatsWithLock(@Param("showId") Long showId,
                                          @Param("audiId") Long audiId,
                                          @Param("seatNumbers") List<String> seatNumbers);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM Seat s WHERE s.audi.id = :audiId AND s.seatNumber IN :seatNumbers AND s.status = 'AVAILABLE'")
    List<Seat> findAvailableSeatsWithLock(@Param("audiId") Long audiId,
                                          @Param("seatNumbers") List<String> seatNumbers);

    void saveAll(List<Seat> seats);
}
