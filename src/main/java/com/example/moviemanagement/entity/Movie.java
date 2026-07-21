package com.example.moviemanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false,length = 500)
    String description;

    private Integer releaseYear;

    private Double rating;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
