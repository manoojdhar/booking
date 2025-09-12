package com.booking.com.booking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "audi")
public class Audi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Integer capacity;        

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)  
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    
    private String createdAt;
    private String updatedAt;
    
    
    public Audi() {
    }

    public Audi(Long id, String name, Theatre theatre, Integer capacity, String image, Show show) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.capacity = capacity;
        this.image = image;
        this.show = show;
    }

    // Getters and Setters
    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
        
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

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
