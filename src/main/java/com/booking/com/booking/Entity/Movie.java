package com.booking.com.booking.Entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private String poster;
    private String trailer;

    @ElementCollection
    @CollectionTable(name = "movie_directors", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "director")
    private List<String> director;

    @ElementCollection
    @CollectionTable(name = "movie_cast", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "movie_cast") // Avoid using reserved word "cast"
    private List<String> cast;

    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "genre")
    private List<String> genre;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    
    private String rating;
    private int durationMinutes;
    private String language;
    private String status;
    private boolean offerEligible;
    private Long userId;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows;

    @CreationTimestamp
    private String createdAt;

    @UpdateTimestamp
    private String updatedAt;

    // Constructors
    public Movie() {}

    public Movie(Long id, String title, String description, String poster, String trailer, List<String> genre,
                 LocalDate releaseDate, String rating, int durationMinutes, String language, String status,
                 boolean offerEligible, Long userId, String createdAt, String updatedAt,
                 List<String> director, List<String> castMembers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.poster = poster;
        this.trailer = trailer;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.durationMinutes = durationMinutes;
        this.language = language;
        this.status = status;
        this.offerEligible = offerEligible;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.director = director;
        this.cast = castMembers;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public List<String> getDirector() {
        return director;
    }

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> castMembers) {
        this.cast = castMembers;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}