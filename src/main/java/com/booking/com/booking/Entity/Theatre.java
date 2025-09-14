package com.booking.com.booking.Entity;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.CascadeType;

// Theatre is an entity class that represents the theatres table in the database
// It is annotated with @Entity to indicate that it is an entity class
@Entity
@Table( name = "theatres", uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "city"}) } )
public class Theatre {

    // id is the primary key of the theatres table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // name is the name of the theatre
    private String name;

    // location is the location of the theatre
    private String location;

    // city is the city of the theatre
    private String city;

    // state is the state of the theatre
    private String state;
    
    // pincode is the pincode of the theatre
    private String pincode;

    // phone is the phone number of the theatre
    private String phone;

    // email is the email of the theatre
    private String email;   

    // website is the website of the theatre
    private String website;

    // image is the image of the theatre
    private String image;
    
    // audis is the list of audis of the theatre
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference   
    private List<Audi> audis;
    
    // createdAt is the timestamp when the theatre was created
    @CreationTimestamp
    private String createdAt;
    
    // updatedAt is the timestamp when the theatre was updated
    @UpdateTimestamp
    private String updatedAt;   

    // Constructors
    public Theatre() {
    }

    // Parameterized constructor
    public Theatre(Long id, String name, String location, String city, String state, String pincode, String phone,
            String email, String website, String image, List<Audi> audis, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.image = image;
        this.audis = audis;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public void addAudi(Audi audi) {
        audis.add(audi);
        audi.setTheatre(this);
    }

    public Audi getAudiById(Long id) {
        return audis.stream().filter(audi -> audi.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Audi> getAudis() {
        return audis;
    }

    public void setAudis(List<Audi> audis) {
        this.audis = audis;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theatre)) return false;
        Theatre theatre = (Theatre) o;
        return id != null && id.equals(theatre.id);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // toString method
    @Override
    public String toString() {
        return "Theatre [id=" + id + ", name=" + name + ", location=" + location + ", city=" + city + ", state=" + state
                + ", pincode=" + pincode + ", phone=" + phone + ", email=" + email + ", website=" + website
                + ", image=" + image + ", audis=" + audis + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + "]";
    }

}
