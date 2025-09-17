package com.booking.com.demo_booking.Services;

import com.booking.com.demo_booking.Entity.Offer;

import java.util.List;

public interface OfferService {

    public List<Offer> listAllOffers();
    public Offer addOffer(Offer offer);
    public Offer updateOffer(Offer offer);

}
