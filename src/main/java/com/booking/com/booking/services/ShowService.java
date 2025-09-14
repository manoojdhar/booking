package com.booking.com.booking.services;

import java.util.List;

import com.booking.com.booking.Entity.Show;
import com.booking.com.booking.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ShowService is a service class that handles the shows and provides methods to perform CRUD operations on the shows
// It is annotated with @Service to indicate that it is a service class
@Service
public class ShowService {
    
    // showRepository is a repository object that is used to perform database operations
    @Autowired
    private ShowRepository showRepository;
    
    // addShow is a method that adds a show
    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    // getShows is a method that returns all the shows
    public List<Show> getShows() {
        return showRepository.findAll();
    }

    // getShowById is a method that returns a show by id
    public Show getShowById(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    // updateShow is a method that updates a show by id
    public Show updateShow(Long id, Show show) {
        Show show1 = showRepository.findById(id).orElse(null);
        showRepository.save(show1);
        return show1;
    }

    // deleteShow is a method that deletes a show by id
    public Show deleteShow(Long id) {
        Show show = showRepository.findById(id).orElse(null);
        showRepository.delete(show);
        return show;
    }
}
