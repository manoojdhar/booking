package com.booking.com.demo_booking.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shows", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"audi_id", "start_time", "end_time"})
})
@Getter
@Setter
//@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Show {

    // id is the primary key of the shows table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // name is the name of the show
    private String name;

    // description is the description of the show
    private String description;

    // image is the image of the show
    private String image;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "audi_id", nullable = false)
    private Audi audi;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = true)
    private Offer offer;

    @Column(name = "start_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;

    @Column(name = "end_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime endTime;

    // language is the language of the show (Hindi, English, Tamil, Telugu, Kannada, Malayalam)
    private String language;

    // type is the type of the show (2D, 3D, 4D)
    private String type;

    // ticketPrice is the ticket price of the show (in INR)
    private BigDecimal ticketPrice;

    // status is the status of the show (Active, Inactive)
    private String status;

    // createdAt is the timestamp when the show was created (HH:MM:SS)
    @CreationTimestamp
    private LocalDateTime createdAt;

    // updatedAt is the timestamp when the show was updated (HH:MM:SS)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ShowSeat> showSeats = new ArrayList<>();



}
