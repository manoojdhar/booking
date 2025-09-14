package com.booking.com.booking.Entity;

import jakarta.persistence.*;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

// Audi is an entity class that represents the audis table in the database
@Entity
@Table(
    name = "audis",
    uniqueConstraints = @UniqueConstraint(columnNames = {"name", "theatre_id"})
)
public class Audi {

    // id is the primary key of the audi table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // name is the name of the audi
    private String name;
    
    // image is the image of the audi
    private String image;
    
    // capacity is the capacity of the audi
    private Integer capacity;

    // theatre is the theatre to which the audi belongs
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", nullable = false)
    @JsonBackReference
    private Theatre theatre;

    // show is the show to which the audi belongs
    @OneToMany(mappedBy = "audi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Show> show;

    // seats is the seats to which the audi belongs
    @OneToMany(mappedBy = "audi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AudiSeats> seats;

    // createdAt is the timestamp when the audi was created
    @CreationTimestamp
    private String createdAt;

    // updatedAt is the timestamp when the audi was updated
    @UpdateTimestamp
    private String updatedAt;

    // setting up default no argument constructor
    public Audi() {}

    // setting up parameterized constructor
    public Audi(Long id, String name, Theatre theatre, Integer capacity, String image, List<Show> show, List<AudiSeats> seats) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.capacity = capacity;
        this.image = image;
        this.show = show;
        this.seats = seats;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<Show> getShow() {
        return show;
    }

    public void setShow(List<Show> show) {
        this.show = show;
    }

    public String getCreatedAt() {   
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    // Equals and HashCode based on ID 
    // this method will be used to compare two objects where required
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Audi)) return false;
        Audi that = (Audi) o;
        return id != null && id.equals(that.getId());
    }

    // this method will be used to generate a hash code for the object
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // Optional: toString without `theatre` to avoid recursive logging
    @Override
    public String toString() {
        return "Audi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", image='" + image + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
