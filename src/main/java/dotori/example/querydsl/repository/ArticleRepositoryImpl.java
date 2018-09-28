package dotori.example.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dotori.example.querydsl.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static dotori.example.querydsl.domain.QArticle.article;
import static dotori.example.querydsl.domain.QUser.user;

public class ArticleRepositoryImpl implements ArticleRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public ArticleRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Article> findWithArticleByIdx(final Long idx) {
        return Optional.ofNullable(
                this.queryFactory.selectFrom(article)
                    .innerJoin(article.user, user)
                    .fetchJoin()
                    .where(article.idx.eq(idx))
                    .fetchOne()
        );
    }
}