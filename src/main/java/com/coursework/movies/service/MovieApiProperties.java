package com.coursework.movies.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "movieapi")
@Data
public class MovieApiProperties {
    private String apiKey;
}
