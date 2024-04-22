package org.example.news.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

@Service
public class NewsService {

    private final NewsApiClient newsApiClient;

    public NewsService() {
        this.newsApiClient = new NewsApiClient("4fd62c0f103a46d7a24c0e3eadf7907b");
    }

/*  Думается мне что это "костыль" и так быть не должно, но в противном случае оно не успевает, а ставить sleep или wait не хочется так как данные
    потенциально могут быть разного объема... А соединять Сервисы через RestTemplate не получилось тоже, так как реализация логики класса NewsApiClient от Kwabenaberko
    не предполагает этого. Как надо было сделать?*/

    public List<String> getNews(TopHeadlinesRequest topHeadlinesRequest) {
        final List<String> articleTitles = new CopyOnWriteArrayList<>();
        CountDownLatch latch = new CountDownLatch(1);
        NewsApiClient.ArticlesResponseCallback articlesResponseCallback = new NewsApiClient.ArticlesResponseCallback() {
            @Override
            public void onSuccess(ArticleResponse response) {
                for (int i = 0; i < response.getArticles().size(); i++) {
                    String title = response.getArticles().get(i).getTitle();
                    articleTitles.add(title);
                }
                latch.countDown();
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
                latch.countDown();
            }
        };

        newsApiClient.getTopHeadlines(topHeadlinesRequest, articlesResponseCallback);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return articleTitles;
    }

    public List<String> getTopHeadlines(String category, String sources, String q,
                                        String country, String language) {
        TopHeadlinesRequest topHeadlinesRequest = new TopHeadlinesRequest.Builder()
                .category(category)
                .sources(sources)
                .q(q)
                .country(country)
                .language(language)
                .build();
        return getNews(topHeadlinesRequest);
    }


}







