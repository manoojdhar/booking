package com.booking.com.booking.Entity;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "movie")
public class Movie {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private String trailer;
    private String genre;
    private String releaseDate;
    private String rating;

    @ManyToMany
    @JoinTable(
        name = "movie_show",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private List<Show> shows;   
    private String duration;
    private String language;
    private String status;
    private Long theatreId;
    private Long showTimeId;
    private boolean offerEligible;    
    private Long userId;

    @CreationTimestamp
    private String createdAt;
    
    @UpdateTimestamp
    private String updatedAt;

    public Movie() {
    }

    public Movie(Long id, String name, String description, String image, String trailer, String genre,
            String releaseDate, String rating, String duration, String language, String status, Long theatreId,
            Long showTimeId, boolean offerEligible, Long userId, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.trailer = trailer;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.duration = duration;
        this.language = language;
        this.status = status;
        this.offerEligible = offerEligible;
        this.userId = userId;
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

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public Long getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(Long showTimeId) {
        this.showTimeId = showTimeId;
    }

    public boolean isOfferEligible() {
        return offerEligible;
    }

    public void setOfferEligible(boolean offerEligible) {
        this.offerEligible = offerEligible;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
