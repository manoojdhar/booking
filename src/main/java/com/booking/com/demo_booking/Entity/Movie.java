package com.booking.com.demo_booking.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies" , uniqueConstraints = { @UniqueConstraint(columnNames = {"title", "isActive", "director", "cast", "genre"})})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @JsonIgnore
    private List<Show> shows;

    // createdAt is the timestamp when the movie was created
    @CreationTimestamp
    private String createdAt;

    // updatedAt is the timestamp when the movie was updated
    @UpdateTimestamp
    private String updatedAt;
}