package org.example.hillel_school.config;

import org.example.hillel_school.service.CustomNewsService;
import org.example.news.service.NewsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomNewsConfig {

    @Bean
    public NewsService newsService() {
        return new NewsService();
    }

    @Bean
    CustomNewsService customNewsService(NewsService newsService) {
        return new CustomNewsService(newsService);
    }

}
