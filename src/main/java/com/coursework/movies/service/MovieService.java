package com.coursework.movies.service;

import com.coursework.movies.domain.MovieEntity;
import com.coursework.movies.domain.movie.MovieDTO;
import com.coursework.movies.mapper.MovieMapper;
import com.coursework.movies.repository.MovieRepository;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper mapper;

    public MovieEntity saveMovie(MovieDTO movieDTO) {

        MovieEntity entity = mapper.map(movieDTO,MovieEntity.class);

        return movieRepository.save(entity);
    }
}
