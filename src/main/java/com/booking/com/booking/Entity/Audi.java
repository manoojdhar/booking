package com.booking.com.booking.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(
    name = "audis",
    uniqueConstraints = @UniqueConstraint(columnNames = {"name", "theatre_id"})
)
public class Audi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private Integer capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", nullable = false)
    @JsonBackReference
    private Theatre theatre;

    @OneToMany(mappedBy = "audi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Show> show;

    @CreationTimestamp
    private String createdAt;

    @UpdateTimestamp
    private String updatedAt;

    // Constructors
    public Audi() {}

    public Audi(Long id, String name, Theatre theatre, Integer capacity, String image, List<Show> show) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.capacity = capacity;
        this.image = image;
        this.show = show;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Audi)) return false;
        Audi that = (Audi) o;
        return id != null && id.equals(that.getId());
    }

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
