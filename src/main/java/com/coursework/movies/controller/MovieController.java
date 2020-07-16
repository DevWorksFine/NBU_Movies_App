package com.coursework.movies.controller;


import com.coursework.movies.domain.MovieEntity;
import com.coursework.movies.domain.movie.MovieDTO;
import com.coursework.movies.repository.MovieRepository;
import com.coursework.movies.service.MovieDbConsumerService;
import com.coursework.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController extends AbstractController {

    private MovieDbConsumerService movieConsumerService;

    @Autowired
    private MovieService movieService;

    @Autowired
    public MovieController(MovieDbConsumerService movieConsumerService) {
        this.movieConsumerService = movieConsumerService;
    }

    @GetMapping(value = "/getmovie", produces = "application/json")
    public ResponseEntity<MovieDTO> getMovieByTitle(@RequestParam(value = "title") String title) {

        MovieDTO movie = movieConsumerService.getMovieByTitle(title);
        movieService.saveMovie(movie);

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


}
