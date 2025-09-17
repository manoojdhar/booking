package com.booking.com.demo_booking.DTO;

import com.booking.com.demo_booking.Entity.SeatCategory;
import com.booking.com.demo_booking.Entity.SeatStatus;
import lombok.Data;

@Data
public class SeatDTO {
    private Long id;
    private String row;
    private int seatNumber;
    private SeatCategory category;

    private SeatStatus status;
}
