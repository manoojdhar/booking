package com.booking.com.demo_booking.Services.Impl;

import com.booking.com.demo_booking.DTO.BookingDTO;
import com.booking.com.demo_booking.Entity.*;
import com.booking.com.demo_booking.Repositories.*;
import com.booking.com.demo_booking.Services.BookingService;
import com.booking.com.demo_booking.Services.ShowSeatService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ShowSeatService showSeatService;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    AudiRepository audiRepository;


    @Override
    public void bookShow(BookingDTO bookingDTO) {
        // Validate show
        Show show = showRepository.findById(bookingDTO.getShowId())
                .orElseThrow(() -> new EntityNotFoundException("Invalid show ID"));
        System.out.println("Received Booking Object: "+ bookingDTO);
        Long showId = show.getId();

        // Validate theatre
        Theatre theatre = theatreRepository.findById(bookingDTO.getTheatreId()).orElseThrow(
                () -> new EntityNotFoundException("Theatre not found"));
        Long theatreId = theatre.getId();

        // Validate Audi and its availability
        Audi audi = audiRepository.findByIdAndTheatreId(bookingDTO.getAudiId(), theatreId).orElseThrow(
                () -> new EntityNotFoundException("Please check Audi details")
        );
        Long audiId = audi.getId();

        // Get Movie Details
        Movie movie = movieRepository.findByTitleAndId(bookingDTO.getMovieName(), bookingDTO.getMovieId());
        System.out.println("Retrieved the movie Object from DB: "+ movie);

        // Verify show timings
//        boolean isShowTimeCorrect = showRepository.findAudiByIdAndStartTime(audiId, LocalDateTime.parse(bookingDTO.getShowTime()).toLocalTime());
//        System.out.println("Verify show time in Audi: "+isShowTimeCorrect);
        // Requested seats
        List<String> requestedSeats = bookingDTO.getSeats();

        // if Seats requests is not blank
        if(!requestedSeats.isEmpty()) {
            // Check seat availability
            List<ShowSeat> availableSeats = showSeatService.checkRequestedSeatsAvailablity(showId, requestedSeats);
            System.out.println("Availability data from DB:" + availableSeats.toString());
            // Convert to set of available seat numbers
            Set<String> availableSeatNumbers = availableSeats.stream()
                    .map(ShowSeat::getSeatNumber)
                    .collect(Collectors.toSet());

            // Identify unavailable seats
            List<String> unavailableSeats = requestedSeats.stream()
                    .filter(seat -> !availableSeatNumbers.contains(seat))
                    .toList();

            // Throw exception if any seats are unavailable
            if (!unavailableSeats.isEmpty()) {
                throw new IllegalStateException("Seats already booked: " + unavailableSeats);
            }

            System.out.println("All requested seats are available. Proceeding with booking...");
            // Lock the requested Seats first...
            // NOTE: We will have to replace showID with User ID when we integrate users
            boolean locked = showSeatService.lockSeats(showId, requestedSeats, bookingDTO.getShowId());
            System.out.println("Successfully returned form locking seats");
            // Payment Process not Integrated
            // 5. Create Booking
            if(locked)
            {
                System.out.println(requestedSeats+ " locked for "+ bookingDTO.getUserId());
                Booking booking = Booking.builder()
                        .show(show)
                        .userId(bookingDTO.getUserId())
                        .theatre(theatre)
                        .audi(audi)
                        .movieName(bookingDTO.getMovieName())
                        .showTime(bookingDTO.getShowTime())
                        .seatNumbers(requestedSeats)
                        .bookingMode(bookingDTO.getBookingMode())
                        .customerName(bookingDTO.getCustomerName())
                        .companyName(bookingDTO.getCompanyName())
                        .contactEmail(bookingDTO.getContactEmail())
                        .contactNumber(bookingDTO.getContactNumber())
                        .numberOfSeats(bookingDTO.getNumberOfSeats())
                        .createdAt(String.valueOf(LocalDateTime.now()))
                        .show(show)
                        .paymentMethod(bookingDTO.getPaymentMethod())
                        .transactionId(bookingDTO.getTransactionId())
                        .paymentStatus(PaymentStatus.SUCCESS) // mocked
                        .bookingStatus(BookingStatus.BOOKED)
                        .bookedAt(LocalDateTime.now())
                        .bookingType(bookingDTO.getBookingType())
                        .build();
                System.out.println("Booking object before saving to DB: "+ booking.toString());
                showSeatService.updateLockedSeats(showId, requestedSeats);
                System.out.println("Saving BOOKING OBJECT "+ booking.toString());
                bookingRepository.save(booking);
            } else {
                throw new IllegalStateException("Failed to block seats, try again!");
            }
        } else {
            throw new IllegalArgumentException("Seat Selection not provided");
        }
    }

    @Override
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }
}
