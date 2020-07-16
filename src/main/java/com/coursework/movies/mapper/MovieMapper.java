package com.coursework.movies.mapper;

import com.coursework.movies.domain.MovieEntity;
import com.coursework.movies.domain.movie.MovieDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper extends ConfigurableMapper {

    protected void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(MovieDTO.class, MovieEntity.class)
                .field("title","title")
                .field("released","releaseDate")
                .register();
    }
}
