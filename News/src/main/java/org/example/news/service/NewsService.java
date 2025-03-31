package org.example.news.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class NewsService {

    @Value("${api_key}")
    private String apiKey;

    private NewsApiClient newsApiClient;

    public NewsService() {
    }

    @PostConstruct
    public void setApiKey() {
        this.newsApiClient = new NewsApiClient(apiKey);
    }

    public List<String> getNews(String category, String sources, String q,
                                String country, String language) throws Exception {

        List<String> headers = new ArrayList<>();
        CompletableFuture<List<String>> future = new CompletableFuture<>();

        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .category(category)
                        .sources(sources)
                        .q(q)
                        .country(country)
                        .language(language)
                        .build()
                ,
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        headers.addAll(
                                response.getArticles()
                                        .stream()
                                        .map(a -> a.getTitle().concat(". МОЕ СООБЩЕНИЕ!"))
                                        .toList()
                        );
                        future.complete(headers);
                    }

                    @Override
                    public void onFailure(Throwable ex) {
                        System.out.println(ex.getMessage());
                    }
                }
        );

        return future.get();
    }
}







