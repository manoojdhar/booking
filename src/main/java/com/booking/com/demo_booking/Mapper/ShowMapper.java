package com.booking.com.demo_booking.Mapper;

import com.booking.com.demo_booking.DTO.ShowDTO;
import com.booking.com.demo_booking.Entity.Audi;
import com.booking.com.demo_booking.Entity.Movie;
import com.booking.com.demo_booking.Entity.Show;
import com.booking.com.demo_booking.Entity.Theatre;

public class ShowMapper {
    public ShowDTO toDTO(Show show) {
        return ShowDTO.builder()
                .id(show.getId())
                .name(show.getName())
                .description(show.getDescription())
                .image(show.getImage())
                .movieId(show.getMovie().getId())
                .audiId(show.getAudi().getId())
                .theatreId(show.getTheatre().getId())
                .startTime(show.getStartTime())
                .endTime(show.getEndTime())
                .language(show.getLanguage())
                .seatType(show.getType())
                .ticketPrice(show.getTicketPrice())
                .status(show.getStatus())
                .createdAt(show.getCreatedAt())
                .updatedAt(show.getUpdatedAt())
                .build();
    }

    public static Show toEntity(
            ShowDTO dto,
            Movie movie,
            Audi audi,
            Theatre theatre
    ) {
        return Show.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .movie(movie)
                .audi(audi)
                .theatre(theatre)
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .language(dto.getLanguage())
                .type(dto.getSeatType())
                .ticketPrice(dto.getTicketPrice())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
