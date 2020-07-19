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
                .field("id","id")
                .field("title","title")
                .field("released","releaseDate")
                .field("poster","poster")
                .field("year","year")
                .field("actors","actors")
                .field("director","director")
                .field("runTime","runTime")
                .field("production","production")
                .field("writer","writer")
                .field("plot","plot")
                .field("genre","genre")
                .field("imdbRating","imdbRating")
                .field("boxOffice","boxOffice")
                .register();
    }

}
