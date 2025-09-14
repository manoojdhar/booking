package com.booking.com.booking.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;  
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

// Offers is an entity class that represents the offers table in the database
// It is annotated with @Entity to indicate that it is an entity class
@Entity
@Table(name = "offers", uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "isActive"}) } )
public class Offers {
    
    // id is the primary key of the offers table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // name is the name of the offer
    private String name;
    
    // description is the description of the offer
    private String description;
    
    // discount is the discount of the offer
    private String discount;
    
    // shows is the shows of the offer
    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private List<Show> shows;

     
    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", name = "updated_at")
    private LocalDateTime updatedAt;
    
    // startDate is the start date of the offer
    private LocalDateTime startDate;
    
    // endDate is the end date of the offer
    private LocalDateTime endDate;  

    private String image;
    
    // isActive is the active status of the offer
    private boolean isActive;

    // No-args constructor
    public Offers() {
    }

    // Parameterized constructor
    public Offers(Long id, String name, String description, String discount, LocalDateTime startDate, LocalDateTime endDate,
            String image, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.startDate = startDate; 
        this.endDate = endDate;
        this.image = image;
        this.isActive = isActive;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public LocalDateTime getStartDate() {
        return startDate; 
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }   

    // toString method
    @Override
    public String toString() {  
        return "Offer [id=" + id + ", name=" + name + ", description=" + description + ", discount=" + discount
                + ", startDate=" + startDate + ", endDate=" + endDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", image=" + image + ", isActive=" + isActive + "]";
    }
}
