package com.booking.com.demo_booking.Mapper;

import com.booking.com.demo_booking.DTO.OfferDTO;
import com.booking.com.demo_booking.Entity.Offer;

public class OfferMapper {

    // Entity -> DTO
    public static OfferDTO toDTO(Offer offer) {
        if (offer == null) {
            return null;
        }

        return OfferDTO.builder()
                .id(offer.getId())
                .name(offer.getName())
                .description(offer.getDescription())
                .discount(offer.getDiscount())
                .image(offer.getImage())
                .startDate(offer.getStartDate())
                .endDate(offer.getEndDate())
                .isActive(offer.isActive())
                .createdAt(offer.getCreatedAt())
                .updatedAt(offer.getUpdatedAt())
                .build();
    }

    // DTO -> Entity
    public static Offer toEntity(OfferDTO dto) {
        if (dto == null) {
            return null;
        }

        return Offer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .image(dto.getImage())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .isActive(dto.isActive())
                // createdAt and updatedAt are managed by JPA, usually not set manually
                .build();
    }
}
