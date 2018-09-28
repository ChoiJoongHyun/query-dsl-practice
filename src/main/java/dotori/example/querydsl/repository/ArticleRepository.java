package dotori.example.querydsl.repository;

import dotori.example.querydsl.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleRepositoryCustom {

    Optional<Article> findByIdx(Long idx);
}
