package com.booking.com.booking.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.com.booking.Entity.AudiSeats;
import com.booking.com.booking.Entity.AudiSeats.SeatType;
import org.springframework.lang.NonNull;


@Repository
public interface AudiSeatsRepository extends JpaRepository<AudiSeats, Long> {

    boolean existsById(@NonNull Long id);

    @Override
    @NonNull
    Optional<AudiSeats> findById(@NonNull Long id);  
    int countByAudiIdAndSeatTypeAndStatus(Long audiId, SeatType seatType, String string);
    Optional<AudiSeats> findAnyByAudiIdAndSeatType(Long audiId, SeatType seatType);

}
