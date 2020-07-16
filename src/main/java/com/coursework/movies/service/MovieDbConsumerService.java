package com.coursework.movies.service;

import com.coursework.movies.domain.movie.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Collections;


@Service
public class MovieDbConsumerService {

    @Autowired
    private MovieApiProperties properties;

    private RestTemplate restTemplate;

    @Autowired
    public MovieDbConsumerService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String API_URI = "http://www.omdbapi.com/?apikey={apiKey}&t={title}";

    public MovieDTO getMovieByTitle(String title) {

        URI uri = new UriTemplate(API_URI).expand(properties.getApiKey(), title);


        return restTemplate.getForObject(uri, MovieDTO.class);

    }


}
