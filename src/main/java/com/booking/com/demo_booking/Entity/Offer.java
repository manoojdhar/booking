package com.booking.com.demo_booking.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "offer")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offer {

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

}


