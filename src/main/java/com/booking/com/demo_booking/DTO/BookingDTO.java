package com.booking.com.demo_booking.DTO;

import com.booking.com.demo_booking.Entity.BookingMode;
import com.booking.com.demo_booking.Entity.BookingStatus;
import com.booking.com.demo_booking.Entity.BookingType;
import com.booking.com.demo_booking.Entity.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookingDTO {
    private String movieName;
    private String theatreName;
    private String showTime;
    private List<String> seats;
    private String offerCode;
    private BookingType bookingType;
    private BookingMode bookingMode;
    private String transactionId;
    private String customerName;
    private String companyName;
    private String contactEmail;
    private String contactNumber;
    private int numberOfSeats;
    private Long showId;
    private Long userId;
    private String paymentMethod;
    private PaymentStatus paymentStatus;
    private BookingStatus bookingStatus;
    private Long movieId;
    private Long theatreId;
    private Long audiId;
    private Long offerId;
}
