package com.coursework.movies.service.movie;

import com.coursework.movies.domain.movie.MovieDTO;

public interface MovieDbConsumerService {
    MovieDTO getMovieByTitle(String title);
}
