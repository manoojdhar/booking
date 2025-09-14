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
import jakarta.persistence.UniqueConstraint;

// Movie is an entity class that represents the movies table in the database
@Entity
@Table(name = "movies" , uniqueConstraints = { @UniqueConstraint(columnNames = {"title", "isActive", "director", "cast", "genre"})})
public class Movie {

    // id is the primary key of the movies table
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // title is the title of the movie
    private String title;
    
    // description is the description of the movie
    private String description;
    
    // poster is the poster of the movie
    private String poster;
    
    // trailer is the trailer of the movie
    private String trailer;

    // director is the director of the movie
    @ElementCollection
    @CollectionTable(name = "movie_directors", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "director")
    private List<String> director;

    // cast is the cast of the movie
    @ElementCollection
    @CollectionTable(name = "movie_cast", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "movie_cast") // Avoid using reserved word "cast"
    private List<String> cast;

    // genre is the genre of the movie
    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "genre")
    private List<String> genre;

    // releaseDate is the release date of the movie
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    
    // rating is the rating of the movie
    private String rating;
    
    // durationMinutes is the duration of the movie in minutes
    private int durationMinutes;
    
    // language is the language of the movie
    private String language;
    
    // status is the status of the movie
    private String status;
    
    // offerEligible is the offer eligible status of the movie
    private boolean offerEligible;
    
    // userId is the user id of the movie
    private Long userId;

    // shows is the shows of the movie
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows;

    // createdAt is the timestamp when the movie was created
    @CreationTimestamp
    private String createdAt;

    // updatedAt is the timestamp when the movie was updated
    @UpdateTimestamp
    private String updatedAt;

    // Constructors
    public Movie() {}

    // Parameterized constructor
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