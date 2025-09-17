package com.booking.com.demo_booking.Services;

import com.booking.com.demo_booking.DTO.AudiLayoutDTO;
import com.booking.com.demo_booking.Entity.Audi;

import java.util.List;
import java.util.Optional;

public interface AudiService {
    List<Audi> listAllAudi(Long id);
    Optional<Audi> findAudiByTheatreId(Long audiId, Long theatreId);
    void createAudiLayout(AudiLayoutDTO audiRequest);
}
