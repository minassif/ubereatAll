package ubereat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ubereat.model.Article;



public interface IArticle extends JpaRepository<Article, Long> {


}
