package com.example.moviemanagement.controller;

import com.example.moviemanagement.dto.MovieRequestDto;
import com.example.moviemanagement.dto.MovieResponseDto;
import com.example.moviemanagement.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieResponseDto> createMovie(
            @RequestBody MovieRequestDto requestDto) {

        MovieResponseDto movie = movieService.createMovie(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movie);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {

        List<MovieResponseDto> movies = movieService.getAllMovies();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> getMovieById(
            @PathVariable Long id) {

        MovieResponseDto movie = movieService.getMovieById(id);

        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDto> updateMovie(
            @PathVariable Long id,
            @RequestBody MovieRequestDto requestDto) {

        MovieResponseDto movie = movieService.updateMovie(id, requestDto);

        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {

        movieService.deleteMovie(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<MovieResponseDto>> getAllMovies(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(movieService.getAllMovies(pageable));
    }
}