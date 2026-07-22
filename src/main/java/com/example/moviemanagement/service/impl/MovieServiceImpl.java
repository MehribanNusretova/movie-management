package com.example.moviemanagement.service.impl;

import com.example.moviemanagement.dto.MovieRequestDto;
import com.example.moviemanagement.dto.MovieResponseDto;
import com.example.moviemanagement.entity.Director;
import com.example.moviemanagement.entity.Genre;
import com.example.moviemanagement.entity.Movie;
import com.example.moviemanagement.mapper.MovieMapper;
import com.example.moviemanagement.repesitory.DirectorRepository;
import com.example.moviemanagement.repesitory.GenreRepository;
import com.example.moviemanagement.repesitory.MovieRepository;
import com.example.moviemanagement.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final GenreRepository genreRepository;
    private final MovieMapper movieMapper;

    public MovieServiceImpl(MovieRepository movieRepository,
                            DirectorRepository directorRepository,
                            GenreRepository genreRepository,
                            MovieMapper movieMapper) {

        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
        this.movieMapper = movieMapper;
    }
    @Override
    public MovieResponseDto createMovie(MovieRequestDto movieRequestDto) {
        Director director = directorRepository.findById(requestDto.getDirectorId())
                .orElseThrow(() -> new RuntimeException("Director not found"));

        Genre genre = genreRepository.findById(requestDto.getGenreId())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        Movie movie = movieMapper.toEntity(requestDto);

        movie.setDirector(director);
        movie.setGenre(genre);

        Movie savedMovie = movieRepository.save(movie);

        return movieMapper.toResponseDto(savedMovie);
    }


    @Override
    public List<MovieResponseDto> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movieMapper::toResponseDto)
                .toList();
    }

    @Override
    public MovieResponseDto getMovieById(Long id) {
        Movie movie=movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return movieMapper.toResponseDto(movie);
    }

    @Override
    public MovieResponseDto updateMovie(Long id, MovieRequestDto movieRequestDto) {
       Movie movie=movieRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Movie not found"));
       Director director=directorRepository.findById(requestDto.getDirectorId())
               .orElseThrow(() -> new RuntimeException("Director not found"));
       Genre genre = genreRepository.findById(requestDto.getGenreId())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        movie.setTitle(requestDto.getTitle());
        movie.setDescription(requestDto.getDescription());
        movie.setReleaseYear(requestDto.getReleaseYear());
        movie.setRating(requestDto.getRating());

        movie.setDirector(director);
        movie.setGenre(genre);

        Movie updatedMovie = movieRepository.save(movie);

        return movieMapper.toResponseDto(updatedMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movie=movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found"));
        movieRepository.delete(movie);

    }
}
