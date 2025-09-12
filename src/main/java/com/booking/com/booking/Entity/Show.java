package com.booking.com.booking.Entity;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToMany;

@Entity(name = "show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String image;
    
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;
    
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Audi> audis;
    
    @ManyToMany(mappedBy = "shows", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movie> movies;
    
    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Offers offers;
    private String startTime;
    private String endTime; 
    private String date;
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

    public Show(Long id, String name, String description, String image, List<Booking> bookings, List<Audi> audis,
            List<Movie> movies, Offers offers, String startTime, String endTime,
            String date, String language, String type, String ticketPrice, String status, String createdAt,
            String updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.bookings = bookings;
        this.audis = audis;
        this.movies = movies;
        this.offers = offers;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.language = language;
        this.type = type;
        this.ticketPrice = ticketPrice;
        this.status = status;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Audi> getAudis() {
        return audis;
    }

    public void setAudis(List<Audi> audis) {
        this.audis = audis;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
