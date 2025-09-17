package com.booking.com.demo_booking.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AudiDTO {

    private Long id;

    private String name;

    private String image;

    private Integer capacity;

    private Long theatreId; // Reference to Theatre (not entire object)

    private int seatsPerRow;

    private int rows;

    private boolean status;

    private List<SeatDTO> seats;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
