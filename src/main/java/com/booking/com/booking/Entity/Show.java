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

// Show is an entity class that represents the shows table in the database
// It is annotated with @Entity to indicate that it is an entity class
// this class will be used to create shows in the database
// a show is a combination of movie, audi, theatre, offer, startTime, endTime, language, type, ticketPrice, status
@Entity(name = "show")
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

    // startTime is the start time of the show (HH:MM)
    private LocalDateTime startTime;

    // endTime is the end time of the show (HH:MM)
    private LocalDateTime endTime;

    // language is the language of the show (Hindi, English, Tamil, Telugu, Kannada, Malayalam)
    private String language;

    // type is the type of the show (2D, 3D, 4D)    
    private String type;

    // ticketPrice is the ticket price of the show (in INR)
    private String ticketPrice;

    // status is the status of the show (Active, Inactive)
    private String status;

    // createdAt is the timestamp when the show was created (HH:MM:SS)
    @CreationTimestamp
    private String createdAt;
    
    // updatedAt is the timestamp when the show was updated (HH:MM:SS)
    @UpdateTimestamp
    private String updatedAt;

    // No-args Constructors
    public Show() {
    }

    // Parameterized Constructors 
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
