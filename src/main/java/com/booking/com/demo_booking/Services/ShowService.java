package com.booking.com.demo_booking.Services;

import com.booking.com.demo_booking.DTO.ShowDTO;
import com.booking.com.demo_booking.Entity.Show;

import java.util.List;

public interface ShowService {


    List<Show> listShows();

    boolean findAvailableShowTime(ShowDTO showDTO);

    Show saveShowAndSeats(ShowDTO showDTO);

    void getShowDetails(Long showId);
}
