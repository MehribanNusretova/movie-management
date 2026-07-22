package com.example.moviemanagement.repesitory;

import com.example.moviemanagement.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director,Long> {
}
