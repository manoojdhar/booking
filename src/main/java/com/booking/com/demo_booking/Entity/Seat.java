package com.booking.com.demo_booking.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"audi_id", "row", "seat_number"})
})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to Audi
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audi_id", nullable = false)
    @JsonBackReference
    private Audi audi;

    @Column(nullable = false)
    private String row;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatType seatType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "show_id", nullable = false)
//    @JsonBackReference
//    private Show show;
}