package web.tmdt.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.tmdt.models.News;
import web.tmdt.services.NewsService;

@CrossOrigin
@RestController
public class NewsAPI {
    @Autowired
    NewsService newsService;

    @GetMapping("/api/news/all")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
