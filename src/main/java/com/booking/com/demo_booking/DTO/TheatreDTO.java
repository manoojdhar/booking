package com.booking.com.demo_booking.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;


@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Pincode is mandatory")
    @Pattern(regexp = "\\d{5,6}", message = "Invalid pincode format")
    private String pincode;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "\\+?\\d{10,15}", message = "Invalid phone number format")
    private String phone;

    @Email(message = "Invalid email format")
    private String email;

    private String website;

    private String image;

    private List<AudiDTO> audis;
}
