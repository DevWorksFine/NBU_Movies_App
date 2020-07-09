package com.coursework.movies.service;

import com.coursework.movies.domain.MovieEntity;
import com.coursework.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public MovieEntity saveMovie(MovieEntity movieEntity) {
        return movieRepository.save(movieEntity);
    }
}
