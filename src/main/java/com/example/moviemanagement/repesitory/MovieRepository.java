package com.example.moviemanagement.repesitory;

import com.example.moviemanagement.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
