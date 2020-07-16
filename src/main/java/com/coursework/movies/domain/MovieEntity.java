package com.coursework.movies.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Clob;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String title;

    private String poster;

    private String releaseDate;

    private String year;

    private String actors;

    private String director;

    private String runTime;

    private String production;

    private String writer;

    private String plot;


}
