package dotori.example.querydsl.repository;

import dotori.example.querydsl.domain.Article;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void article_user_not_fetch_join() {
        Article article = this.articleRepository.findByIdx(1L)
                .orElseThrow(NullPointerException::new);

        assertFalse(Hibernate.isInitialized(article.getUser())); //lazy loading 확인
    }

    @Test
    public void article_user_fetch_join() {
        Article article = this.articleRepository.findWithArticleByIdx(1L)
                .orElseThrow(NullPointerException::new);

        assertTrue(Hibernate.isInitialized(article.getUser())); //user fetch 확인
    }
}