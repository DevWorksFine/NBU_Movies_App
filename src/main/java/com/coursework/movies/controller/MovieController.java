package com.coursework.movies.controller;


import com.coursework.movies.domain.movie.MovieDTO;
import com.coursework.movies.service.MovieDbConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private MovieDbConsumerService movieConsumerService;

    @Autowired
    public MovieController(MovieDbConsumerService movieConsumerService) {
        this.movieConsumerService = movieConsumerService;
    }

    @GetMapping(value = "/getmovie", produces = "application/json")
    public ResponseEntity<MovieDTO> getMovieByTitle(@RequestParam String title) {

        MovieDTO movie = movieConsumerService.getMovieByTitle(title);

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

}
