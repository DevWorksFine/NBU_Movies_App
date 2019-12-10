package com.coursework.movies.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingEntity {


    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Integer rating;

}
