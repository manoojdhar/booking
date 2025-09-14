package com.booking.com.booking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

// Seat is an entity class that represents the seats table in the database
// It is annotated with @Entity to indicate that it is an entity class
@Entity
@Table(name = "seats", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"seat_number", "show_id", "audi_id"})
})
public class Seat {

    // Enum for seat status
    public enum SeatStatus {
        AVAILABLE, BOOKED, HELD
    }

    // id is the primary key of the seat table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // seatNumber is the seat number of the seat
    private String seatNumber;

    // status is the status of the seat
    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    // show is the show to which the seat belongs
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    // audi is the audi to which the seat belongs
    @ManyToOne
    @JoinColumn(name = "audi_id")
    private Audi audi;

    // booking is the booking to which the seat belongs
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    
    // setting up default no argument constructor
    public Seat() {}
    
    // setting up parameterized constructor
    public Seat(Long id, String seatNumber, SeatStatus status, Show show, Audi audi, Booking booking) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.status = status;
        this.show = show;
        this.audi = audi;
        this.booking = booking;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Audi getAudi() {
        return audi;
    }

    public void setAudi(Audi audi) {
        this.audi = audi;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
