package com.booking.com.demo_booking.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "show_seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

//    @Column(n)
    private LocalDateTime lockedAt;

    @Enumerated(EnumType.STRING)
    private SeatStatus status; // AVAILABLE, BOOKED, etc.

    @Enumerated(EnumType.STRING)
    private SeatCategory seatCategory;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private BigDecimal price;

    private String row;
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;
}
