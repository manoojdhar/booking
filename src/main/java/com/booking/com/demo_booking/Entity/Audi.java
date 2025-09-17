package com.booking.com.demo_booking.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "audi", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "theatre_id"}))
@Getter
@Setter
@ToString(exclude = {"theatre"})
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Audi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private Integer capacity;

    @Column(nullable = false)
    private int seatsPerRow;

    @Column(nullable = false)
    private int rows;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", nullable = false)
    @JsonBackReference
    private Theatre theatre;

    @OneToMany(mappedBy = "audi", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    private List<Show> shows = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "audi", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonManagedReference
    private List<Seat> seats = new ArrayList<>();

    private boolean status;

    public void addSeat(Seat seat) {
        seats.add(seat);
        seat.setAudi(this); // set the back-reference
    }

    public void removeSeat(Seat seat) {
        seats.remove(seat);
        seat.setAudi(null);
    }
}