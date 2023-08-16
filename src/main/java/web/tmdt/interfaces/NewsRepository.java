package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.News;

public interface NewsRepository extends JpaRepository<News, Integer> {

}
