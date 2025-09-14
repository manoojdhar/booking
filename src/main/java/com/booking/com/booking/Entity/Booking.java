package com.booking.com.booking.Entity;
    
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Booking is an entity class that represents the bookings table in the database
// It is annotated with @Entity to indicate that it is an entity class
@Entity
@Table(name = "booking")
public class Booking {

    public enum BookingType {
        INDIVIDUAL,
        CORPORATE,
    }

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
    private Offers offer;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Seat> seats;

    public Booking() {}

    public Booking(Long id, String movieName, String theatreName, String showTime, List<String> seatNumbers,
                   String offerCode, BookingType bookingType, String customerName, String companyName,
                   String contactEmail, String contactNumber, int numberOfSeats,
                   Show show, Movie movie, Theatre theatre, Audi audi, Offers offer,
                   String createdAt, String updatedAt) {
        this.id = id;
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.showTime = showTime;
        this.seatNumbers = seatNumbers;
        this.offerCode = offerCode;
        this.bookingType = bookingType;
        this.customerName = customerName;
        this.companyName = companyName;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
        this.numberOfSeats = numberOfSeats;
        this.show = show;
        this.movie = movie;
        this.theatre = theatre;
        this.audi = audi;
        this.offer = offer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    } 

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Audi getAudi() {
        return audi;
    }

    public void setAudi(Audi audi) {
        this.audi = audi;
    }

    public Offers getOffer() {
        return offer;
    }

    public void setOffer(Offers offer) {
        this.offer = offer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Booking [id=" + id + ", movieName=" + movieName + ", theatreName=" + theatreName + ", showTime="
                + showTime + ", seatNumbers=" + seatNumbers + ", offerCode=" + offerCode + ", bookingType="
                + bookingType + ", customerName=" + customerName + ", companyName=" + companyName
                + ", contactEmail=" + contactEmail + ", contactNumber=" + contactNumber + ", numberOfSeats="
                + numberOfSeats + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
