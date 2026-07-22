package com.example.moviemanagement.service;

import com.example.moviemanagement.dto.MovieRequestDto;
import com.example.moviemanagement.dto.MovieResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    MovieResponseDto createMovie(MovieRequestDto movieRequestDto);
    List<MovieResponseDto> getAllMovies();
    MovieResponseDto getMovieById(Long id);
    MovieResponseDto updateMovie(Long id, MovieRequestDto movieRequestDto);
    void deleteMovie(Long id);
}
