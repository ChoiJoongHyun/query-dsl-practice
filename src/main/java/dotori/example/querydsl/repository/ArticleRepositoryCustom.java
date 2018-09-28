package dotori.example.querydsl.repository;

import dotori.example.querydsl.domain.Article;

import java.util.Optional;

public interface ArticleRepositoryCustom {

    Optional<Article> findWithArticleByIdx(Long idx);
}