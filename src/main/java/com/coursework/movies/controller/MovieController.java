package com.coursework.movies.controller;



import com.coursework.movies.domain.movie.MovieDTO;
import com.coursework.movies.service.movie.MovieService;
import com.coursework.movies.service.movie.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController extends AbstractController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/get", produces = "application/json")
    public ResponseEntity<MovieDTO> getMovieByTitle(@RequestParam(value = "title") String title) {

        MovieDTO movie = movieService.getMovieByTitle(title);
        movieService.saveMovie(movie);

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {

        List<MovieDTO> movies = movieService.getAllMovies();

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


}
