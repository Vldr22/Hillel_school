package org.example.hillel_school.service;

import org.example.news.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomNewsService {

    private final NewsService newsService;

    public CustomNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public List<String> getTopHeadLines(String category, String sources, String q,
                                        String country, String language) throws Exception {
        List<String> topHeadLines = newsService.getNews(category,
                sources, q, country,language);
        topHeadLines.replaceAll(string -> string + " Glory to Ukraine");
        return topHeadLines;
    }
}
