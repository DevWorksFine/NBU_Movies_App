package com.coursework.movies.repository;

import com.coursework.movies.domain.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity,Long> {



}

