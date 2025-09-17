package com.booking.com.demo_booking.DTO;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class AudiLayoutDTO {

    private Long audiId;
    private Long theatreId;
    private int rows;
    private boolean status;
    private int columns;
    private  int seatsPerRow;
    private String defaultSeatType; // fallback
    private Map<String, String> seatTypeByRow; // optional
    private List<SeatDTO> seats;
}
