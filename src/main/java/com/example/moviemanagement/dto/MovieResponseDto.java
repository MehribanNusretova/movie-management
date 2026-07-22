package com.example.moviemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto {
    private Long id;

    private String title;

    private String description;

    private Integer releaseYear;

    private Double rating;

    private String directorName;

    private String genreName;
}