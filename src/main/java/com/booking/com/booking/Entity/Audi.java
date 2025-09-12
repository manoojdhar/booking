package com.booking.com.booking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "audis") 
@Table(name = "audis", uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "theatre_id"}) } )    
public class Audi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Integer capacity;        

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", nullable = false)  
    private Theatre theatre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;
    
    @CreationTimestamp
    private String createdAt;
    
    @UpdateTimestamp
    private String updatedAt;
    
    
    public Audi() {
    }

    public Audi(Long id, String name, Theatre theatre, Integer capacity, String image, Show show, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.capacity = capacity;
        this.image = image;
        this.show = show;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    // @Override
    // public String toString() {
    //     return "Audi [id=" + id + ", name=" + name + ", theatre=" + theatre + ", capacity=" + capacity + ", image="
    //             + image + ", show=" + show + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    // }   

}
