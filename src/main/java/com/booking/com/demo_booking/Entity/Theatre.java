package com.booking.com.demo_booking.Entity;

// Theatre is an entity class that represents the theatres table in the database
// It is annotated with @Entity to indicate that it is an entity class

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theatres", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "city"}))
@Getter
@Setter
@ToString(exclude = {"audis"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String city;
    private String state;
    private String pincode;
    private String phone;
    private String email;
    private String website;
    private String image;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @Builder.Default
    private List<Audi> audis = new ArrayList<>();

    // shows is the shows of the movie
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Show> shows;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void addAudi(Audi audi) {
        audis.add(audi);
        audi.setTheatre(this);
    }

    public void removeAudi(Audi audi) {
        audis.remove(audi);
        audi.setTheatre(null);
    }
}
