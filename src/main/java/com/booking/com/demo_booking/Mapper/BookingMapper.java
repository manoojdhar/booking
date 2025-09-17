package com.booking.com.demo_booking.Mapper;

import com.booking.com.demo_booking.DTO.BookingDTO;
import com.booking.com.demo_booking.Entity.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingMapper {

    public static Booking toEntity(BookingDTO dto, Show show, Offer offer, Movie movie, Theatre theatre, Audi audi) {
        return Booking.builder()
                .show(show)
                .offer(offer)
                .movie(movie)
                .theatre(theatre)
                .audi(audi)
                .seatNumbers(dto.getSeats())
                .transactionId(dto.getTransactionId())
                .bookingType(dto.getBookingType())
                .bookingMode(dto.getBookingMode())
                .customerName(dto.getCustomerName())
                .companyName(dto.getCompanyName())
                .contactEmail(dto.getContactEmail())
                .contactNumber(dto.getContactNumber())
                .numberOfSeats(dto.getNumberOfSeats())
                .movieName(movie != null ? movie.getTitle() : dto.getMovieName())
                .theatreName(theatre != null ? theatre.getName() : dto.getTheatreName())
                .showTime(show != null && show.getStartTime() != null ? show.getStartTime().toString() : dto.getShowTime())
                .paymentMethod(dto.getPaymentMethod())
                .paymentStatus(dto.getPaymentStatus())
                .bookingStatus(dto.getBookingStatus())
                .userId(dto.getUserId())
                .build();
    }

    public static BookingDTO toDTO(Booking booking) {
        if (booking == null) return null;

        BookingDTO dto = BookingDTO.builder()
                .movieName(booking.getMovieName())
                .theatreName(booking.getTheatreName())
                .showTime(booking.getShowTime())
                .seats(booking.getSeatNumbers())
                .offerCode(booking.getOfferCode())
                .bookingType(booking.getBookingType())
                .bookingMode(booking.getBookingMode())
                .transactionId(booking.getTransactionId())
                .customerName(booking.getCustomerName())
                .companyName(booking.getCompanyName())
                .contactEmail(booking.getContactEmail())
                .contactNumber(booking.getContactNumber())
                .numberOfSeats(booking.getNumberOfSeats())
                .showId(booking.getShow() != null ? booking.getShow().getId() : null)
                .userId(booking.getUserId())
                .paymentMethod(booking.getPaymentMethod())
                .paymentStatus(booking.getPaymentStatus())
                .bookingStatus(booking.getBookingStatus())
                .movieId(booking.getMovie() != null ? booking.getMovie().getId() : null)
                .theatreId(booking.getTheatre() != null ? booking.getTheatre().getId() : null)
                .audiId(booking.getAudi() != null ? booking.getAudi().getId() : null)
                .offerId(booking.getOffer() != null ? booking.getOffer().getId() : null)
                .build();

        return dto;
    }
}





    //    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
//
//        // DTO → Entity
//        @Mapping(source = "showId", target = "show.id")
//        @Mapping(source = "movieId", target = "movie.id")
//        @Mapping(source = "theatreId", target = "theatre.id")
//        @Mapping(source = "audiId", target = "audi.id")
//        @Mapping(source = "offerId", target = "offer.id")
//        Booking toEntity(BookingDTO dto);
//
//        // Entity → DTO
//        @Mapping(source = "show.id", target = "showId")
//        @Mapping(source = "movie.id", target = "movieId")
//        @Mapping(source = "theatre.id", target = "theatreId")
//        @Mapping(source = "audi.id", target = "audiId")
//        @Mapping(source = "offer.id", target = "offerId")
//        BookingDTO toDTO(Booking entity);
