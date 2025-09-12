package com.booking.com.booking.Entity;
    
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieName;
    private String theatreName;
    private String showTime;
    private String seatNumber;
    private String offerCode;

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

    public Booking() {
    }

    public Booking(Long id, String movieName, String theatreName, String showTime, String seatNumber,
            String offerCode, Show show, Movie movie, Theatre theatre, Audi audi, Offers offer, String createdAt,
            String updatedAt) {
        this.id = id;
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.showTime = showTime;
        this.seatNumber = seatNumber;
        this.offerCode = offerCode;
        this.show = show;
        this.movie = movie;
        this.theatre = theatre;
        this.audi = audi;
        this.offer = offer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
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

}
