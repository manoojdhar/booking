package com.booking.com.demo_booking.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDTO {

    private Long id;

    private String name;

    private String description;

    private String image;

    private Long movieId;

    private Long audiId;

    private Long theatreId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String language;

    private String seatType;

    private String type;

    private BigDecimal ticketPrice;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
