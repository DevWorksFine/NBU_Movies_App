package com.coursework.movies.controller;



import com.coursework.movies.domain.movie.MovieDTO;
import com.coursework.movies.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
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
    public ModelAndView getAllMovies(ModelAndView model) {

        model.addObject("movies",movieService.getAllMovies());

        return this.getView("index",model);
    }

    @GetMapping(value = "/get/{title}", produces = "application/json")
    public ModelAndView getMovieById(@PathVariable(value = "title") String title, ModelAndView model) {

        model.addObject("movie",movieService.getMovieByTitleFromDb(title));

        return this.getView("movie/movieDetails",model);
    }


}
