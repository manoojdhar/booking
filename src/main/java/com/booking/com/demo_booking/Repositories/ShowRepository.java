package com.booking.com.demo_booking.Repositories;

import com.booking.com.demo_booking.Entity.Show;
import com.booking.com.demo_booking.Entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

//    @Query("SELECT count s.* FROM Show s WHERE s.audi.id = :audiId AND " +
//            "s.theatre.id = :theatreId AND" +
//            "((s.startDateTime BETWEEN :start AND :end) OR " +
//            " (s.endDateTime BETWEEN :start AND :end) OR " +
//            " (s.startDateTime <= :start AND s.endDateTime >= :end))")
//    int findConflictingShows(@Param("theatreId") Long theatreId,
//                                    @Param("audiId") Long audiId,
//                                    @Param("start") LocalDateTime start,
//                                    @Param("end") LocalDateTime end);

//    @Query("SELECT COUNT(s) FROM Show s WHERE s.audi.id = :audiId AND s.theatre.id = :theatreId AND " +
//            "((s.startTime BETWEEN :start AND :end) OR " +
//            " (s.endTime BETWEEN :start AND :end) OR " +
//            " (s.startTime <= :start AND s.endTime >= :end))")
    @Query("""
            SELECT COUNT(s) > 0 FROM Show s WHERE s.audi.id = :audiId AND s.startTime < :end AND s.endTime > :start
          """)
    boolean findConflictingShows(@Param("theatreId") Long theatreId,
                             @Param("audiId") Long audiId,
                             @Param("start") LocalDateTime start,
                             @Param("end") LocalDateTime end);


//    @Query("""
//    SELECT ss FROM ShowSeat ss
//    WHERE ss.show.id = :showId
//      AND ss.seatNumber IN :seatNumbers
//      AND ss.status = 'AVAILABLE'
//""")
//    List<ShowSeat> findAvailableRequestedSeatsByShowId(
//            @Param("showId") Long showId,
//            @Param("seatNumbers") List<String> seatNumbers
//    );


    @Query("""
            SELECT ss FROM ShowSeat ss
                WHERE ss.show.id = :showId AND ss.status = 'AVAILABLE'
        """)
    List<ShowSeat> findAvailableSeatsByShowId(@Param("showId") Long showId);

    //    Optional<Show> findByShowId(@Param("showId") Long showId);

//    @Query("SELECT count(a) from shows s WHERE a.audi.id = :audiId AND TO_CHAR(s.startTime, 'HH24:MI') = :startTime")
//    boolean findAudiByStartTime(@Param("audiId") Long audiId, @Param("startTime") LocalDateTime startTime);
}
