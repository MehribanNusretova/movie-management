package com.example.moviemanagement.repesitory;

import com.example.moviemanagement.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
}
