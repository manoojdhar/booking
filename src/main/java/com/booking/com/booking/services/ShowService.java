package com.booking.com.booking.services;

import java.util.List;

import com.booking.com.booking.Entity.Show;
import com.booking.com.booking.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
    
    @Autowired
    private ShowRepository showRepository;
    
    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    public List<Show> getShows() {
        return showRepository.findAll();
    }

    public Show getShowById(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    public Show updateShow(Long id, Show show) {
        Show show1 = showRepository.findById(id).orElse(null);
        showRepository.save(show1);
        return show1;
    }

    public Show deleteShow(Long id) {
        Show show = showRepository.findById(id).orElse(null);
        showRepository.delete(show);
        return show;
    }


}
