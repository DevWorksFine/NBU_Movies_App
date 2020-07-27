package com.coursework.movies.controller;



import com.coursework.movies.domain.movie.MovieDTO;
import com.coursework.movies.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


@Controller
@RequestMapping("movie")
public class MovieController extends AbstractController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/get")
    public ModelAndView getMovieByTitle(@RequestParam(value = "title") String title) {

        MovieDTO movie = movieService.getMovieByTitle(title);
        movieService.saveMovie(movie);

        return this.redirect("/movie/all");
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ModelAndView getAllMovies(ModelAndView model) {

        model.addObject("movies",movieService.getAllMovies());

        return this.getView("index",model);
    }

    @GetMapping(value = "/get/{title}", produces = "application/json")
    public ModelAndView getMovieById(@PathVariable(value = "title") String title, ModelAndView model) {

        model.addObject("movie",movieService.getMovieByTitleFromDb(title));

        return this.getView("movie/movieDetails",model);
    }

    @GetMapping(value = "/add", produces = "application/json")
    public ModelAndView getMovieById( ModelAndView model) {

        return this.getView("movie/addMovie",model);
    }

}
