package com.booking.com.booking.Entity;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.CascadeType;

@Entity
@Table( name = "theatres", uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "city"}) } )
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
    
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Audi> audis;
    
    @CreationTimestamp
    private String createdAt;
    
    @UpdateTimestamp
    private String updatedAt;   

    public Theatre() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theatre)) return false;
        Theatre theatre = (Theatre) o;
        return id != null && id.equals(theatre.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Theatre [id=" + id + ", name=" + name + ", location=" + location + ", city=" + city + ", state=" + state
                + ", pincode=" + pincode + ", phone=" + phone + ", email=" + email + ", website=" + website
                + ", image=" + image + ", audis=" + audis + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + "]";
    }

}
