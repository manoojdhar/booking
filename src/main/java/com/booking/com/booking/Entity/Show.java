package com.booking.com.booking.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;

@Entity(name = "show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String image;
    
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "audi_id")
    private Audi audi;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = true)
    private Offers offer;
    
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Offers offers;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // private String date;
    private String language;
    private String type;
    private String ticketPrice;
    private String status;

    @CreationTimestamp
    private String createdAt;
    
    @UpdateTimestamp
    private String updatedAt;

    public Show() {
    }

    public Show(Long id, String name, String description, String image, Movie movie, Audi audi,
            Offers offers, LocalDateTime startTime, LocalDateTime endTime,
            String language, String type, String ticketPrice, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.audi = audi;
        this.movie = movie;
        this.offers = offers;
        this.startTime = startTime;
        this.endTime = endTime;
        this.language = language;
        this.type = type;
        this.ticketPrice = ticketPrice;
        this.status = status;
        // this.createdAt = createdAt;
        // this.updatedAt = updatedAt;
    }   

    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Audi getAudis() {
        return this.audi;
    }

    public void setAudis(Audi audi) {
        this.audi = audi;
    }

    public Movie getMovies() {
        return this.movie;
    }

    public void setMovies(Movie movie) {
        this.movie = movie;
    }

    public Offers getOffers() {
        return this.offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
