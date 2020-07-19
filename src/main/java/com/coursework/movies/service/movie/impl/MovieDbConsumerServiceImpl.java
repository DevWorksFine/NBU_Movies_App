package com.coursework.movies.service.movie.impl;

import com.coursework.movies.domain.movie.MovieDTO;
import com.coursework.movies.service.movie.MovieDbConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;


@Service
public class MovieDbConsumerServiceImpl implements MovieDbConsumerService {

    @Autowired
    private MovieApiProperties properties;

    private RestTemplate restTemplate;

    @Autowired
    public MovieDbConsumerServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String API_URI = "http://www.omdbapi.com/?apikey={apiKey}&t={title}";

    public MovieDTO getMovieByTitle(String title) {

        URI uri = new UriTemplate(API_URI).expand(properties.getApiKey(), title);


        return restTemplate.getForObject(uri, MovieDTO.class);

    }


}
