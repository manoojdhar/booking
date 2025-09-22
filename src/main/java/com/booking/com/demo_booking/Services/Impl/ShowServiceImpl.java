package com.booking.com.demo_booking.Services.Impl;

import com.booking.com.demo_booking.DTO.ShowDTO;
import com.booking.com.demo_booking.Entity.*;
import com.booking.com.demo_booking.Mapper.ShowMapper;
import com.booking.com.demo_booking.Repositories.ShowRepository;
import com.booking.com.demo_booking.Repositories.ShowSeatRepository;
import com.booking.com.demo_booking.Services.AudiService;
import com.booking.com.demo_booking.Services.MovieService;
import com.booking.com.demo_booking.Services.ShowService;
import com.booking.com.demo_booking.Services.TheatreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieService movieService;

    @Autowired
    AudiService audiService;

    @Autowired
    TheatreService theatreService;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Override
    public List<Show> listShows() {
        System.out.println("Listing Movies");
        return showRepository.findAll();
    }

    @Override
    public boolean findAvailableShowTime(ShowDTO showDTO) {
        Movie movie = movieService.findById(showDTO.getMovieId())
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        Audi audi = audiService.findAudiByTheatreId(showDTO.getAudiId(), showDTO.getTheatreId())
                .orElseThrow(() -> new EntityNotFoundException("Audi not found"));

        Theatre theatre = theatreService.getTheatreById(showDTO.getTheatreId())
                .orElseThrow(() -> new EntityNotFoundException("Theatre not found"));

        Show show = ShowMapper.toEntity(showDTO, movie, audi, theatre);
        System.out.println("Show Entity: after transforming: " + show.toString());

        return showRepository.findConflictingShows(show.getTheatre().getId(), show.getAudi().getId(), show.getStartTime(), show.getEndTime());
    }

    @Override
    public Show saveShowAndSeats(ShowDTO showDTO) {
        Movie movie = movieService.findById(showDTO.getMovieId())
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        Audi audi = audiService.findAudiByTheatreId(showDTO.getAudiId(), showDTO.getTheatreId())
                .orElseThrow(() -> new EntityNotFoundException("Audi not found"));

        Theatre theatre = theatreService.getTheatreById(showDTO.getTheatreId())
                .orElseThrow(() -> new EntityNotFoundException("Theatre not found"));

        Show show = ShowMapper.toEntity(showDTO, movie, audi, theatre);

        // Populate show seats
        List<ShowSeat> showSeats = audi.getSeats().stream()
                .map(seat -> ShowSeat.builder()
                        .show(show)
                        .seat(seat)
                        .seatCategory(seat.getCategory())
                        .seatType(seat.getSeatType())
                        .seatNumber(seat.getSeatNumber())
                        .status(SeatStatus.AVAILABLE)
                        .price(show.getTicketPrice()) // or seat-based pricing
                        .row(seat.getRow())
                        .seatCategory(seat.getCategory())
                        .seatType(seat.getSeatType())
                        .seatNumber(seat.getSeatNumber())
                        .build())
                .collect(Collectors.toList());
        System.out.println("Seats count: " + showSeats.size());
        show.setShowSeats(showSeats);
        showRepository.save(show);
        return show;
    }

    @Override
    public void getShowDetails(Long showId) {
        System.out.println("Seats available in the show are:");
        System.out.println(showRepository.findAvailableSeatsByShowId(showId));
    }
}
