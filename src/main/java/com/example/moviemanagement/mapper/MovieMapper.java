package com.example.moviemanagement.mapper;

import com.example.moviemanagement.dto.MovieRequestDto;
import com.example.moviemanagement.dto.MovieResponseDto;
import com.example.moviemanagement.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie toEntity(MovieRequestDto requestDto) {

        Movie movie = new Movie();

        movie.setTitle(requestDto.getTitle());
        movie.setDescription(requestDto.getDescription());
        movie.setReleaseYear(requestDto.getReleaseYear());
        movie.setRating(requestDto.getRating());

        return movie;
    }
    public MovieResponseDto toResponseDto(Movie movie) {

        MovieResponseDto response = new MovieResponseDto();

        response.setId(movie.getId());
        response.setTitle(movie.getTitle());
        response.setDescription(movie.getDescription());
        response.setReleaseYear(movie.getReleaseYear());
        response.setRating(movie.getRating());

        response.setDirectorName(movie.getDirector().getName());

        response.setGenreName(movie.getGenre().getName());

        return response;
    }

}