package com.coursework.movies.service.movie;

import com.coursework.movies.domain.MovieEntity;
import com.coursework.movies.domain.movie.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieEntity saveMovie(MovieDTO movieDTO);
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieByTitle(String title);
}
