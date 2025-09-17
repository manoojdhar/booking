package com.booking.com.demo_booking.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "booking", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "theatre_id"}))
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieName;
    private String theatreName;
    private String showTime;

    // For individual bookings, this can hold one seat number.
    // For bulk bookings, store comma-separated values or use another table for normalization.
    @ElementCollection
    @CollectionTable(name = "booking_seats", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "seat_number")
    private List<String> seatNumbers;

    private String offerCode;

    @Enumerated(EnumType.STRING)
    private BookingType bookingType;

    @Column(name = "booking_mode")
    @Enumerated(EnumType.STRING)
    private BookingMode bookingMode;

    @Column(name = "transaction_id")
    private String transactionId;

    // For individuals or company representatives
    private String customerName;

    // Optional for corporate required for corporate booking
    private String companyName;
    private String contactEmail;
    private String contactNumber;

    private int numberOfSeats;

    @CreationTimestamp
    private String createdAt;

    @UpdateTimestamp
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

//    @ManyToOne
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "audi_id")
    private Audi audi;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<ShowSeat> showSeats = new ArrayList<>();

    @UpdateTimestamp
    private LocalDateTime bookedAt;

}
