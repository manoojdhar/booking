package com.booking.com.booking.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "audi_seats")
public class AudiSeats {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String seatNumber;

    @NonNull
    @Column(nullable = false)
    private String status;

    private int rowNumber;
    private int columnNumber;
    private int price;

    @ManyToOne
    @JoinColumn(name = "audi_id", nullable = false)
    @NonNull
    private Audi audi;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    @NonNull
    private SeatType seatType;

    public enum SeatType {
        REGULAR,
        PREMIUM,
        VIP
    }

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Default constructor
    // public AudiSeats() {}

    // Constructor with required fields 
    public AudiSeats(String seatNumber,
                     String status,
                     int rowNumber,
                     int columnNumber,
                     int price,
                     Audi audi,
                     SeatType seatType) {
        this.seatNumber = seatNumber;
        this.status = status;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.price = price;
        this.audi = audi;
        this.seatType = seatType;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Audi getAudi() {
        return audi;
    }

    public void setAudi(Audi audi) {
        this.audi = audi;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "AudiSeats [id=" + id + ", seatNumber=" + seatNumber + ", status=" + status +
                ", rowNumber=" + rowNumber + ", columnNumber=" + columnNumber +
                ", price=" + price + ", seatType=" + seatType + "]";
    }
}
