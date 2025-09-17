package com.booking.com.demo_booking.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MovieDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private String poster;

    private String trailer;

    @NotEmpty(message = "At least one director is required")
    private List<@NotBlank(message = "Director name cannot be blank") String> director;

    @NotEmpty(message = "Cast list cannot be empty")
    private List<@NotBlank(message = "Cast name cannot be blank") String> cast;

    @NotEmpty(message = "At least one genre is required")
    private List<@NotBlank(message = "Genre cannot be blank") String> genre;

    @NotNull(message = "Release date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private String rating;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    private int durationMinutes;

    @NotBlank(message = "Language is required")
    private String language;

    private String status;

    private boolean offerEligible;

    private Long userId;
}
