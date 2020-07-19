package com.coursework.movies.service.movie.impl;

import com.coursework.movies.domain.MovieEntity;
import com.coursework.movies.domain.movie.MovieDTO;
import com.coursework.movies.mapper.MovieMapper;
import com.coursework.movies.repository.MovieRepository;
import com.coursework.movies.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper mapper;

    @Autowired
    private MovieDbConsumerServiceImpl movieDbConsumerServiceImpl;


    public MovieEntity saveMovie(MovieDTO movieDTO) {

        MovieEntity entity = mapper.map(movieDTO,MovieEntity.class);

        return movieRepository.save(entity);
    }

    public List<MovieDTO> getAllMovies() {

        List<MovieEntity> movieEntityList = movieRepository.findAll();

        return movieEntityList
                .stream()
                .map(movieEntity ->  mapper.map(movieEntity,MovieDTO.class)).collect(Collectors.toList());
    }
    public MovieDTO getMovieByTitle(String title) {

        return movieDbConsumerServiceImpl.getMovieByTitle(title);
    }

    public MovieDTO getMovieByTitleFromDb(String title) {

        return mapper.map(movieRepository.findByTitle(title),MovieDTO.class);
    }

    public MovieDTO getMovieById(String id) {

        return mapper.map(movieRepository.findById(Long.parseLong(id)),MovieDTO.class);
    }

}
