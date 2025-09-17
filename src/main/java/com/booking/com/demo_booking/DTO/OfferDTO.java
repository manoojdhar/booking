package com.booking.com.demo_booking.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class OfferDTO {

    private Long id;
    private String name;
    private String description;
    private String discount;
    private String image;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}