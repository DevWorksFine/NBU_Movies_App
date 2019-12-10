package com.coursework.movies.service;

import com.coursework.movies.domain.movie.MovieDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;


@Service
public class MovieDbConsumerService {

    private static final String API_KEY = "4ee0c1d8";
    private static final String API_URI = "http://www.omdbapi.com/?apikey={apiKey}&t={title}";


    public MovieDTO getMovieByTitle(String title) {

        URI uri = new UriTemplate(API_URI).expand(API_KEY, title);
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(uri, MovieDTO.class);

    }


}
