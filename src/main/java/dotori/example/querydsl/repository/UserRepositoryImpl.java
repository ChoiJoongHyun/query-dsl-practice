package dotori.example.querydsl.repository;


import dotori.example.querydsl.domain.User;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

import static dotori.example.querydsl.domain.QUser.user;
import static dotori.example.querydsl.domain.QArticle.article;
/**
 * Created by joonghyun on 2017. 12. 30..
 */
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryImpl() {
        super(User.class);
    }


    @Override
    public User findByIdx(Long idx) {
        return from(user)
                .where(user.idx.eq(idx))
                .fetchOne();
    }

    @Override
    public User findWithArticleByIdx(Long idx) {
        return from(user)
                .leftJoin(user.articles, article)
                .fetchJoin()
                .where(user.idx.eq(idx))
                .fetchOne();
    }

    @Override
    public List<User> findWithArticle() {
        return from(user)
                .distinct() //중복제거를 하지 않으면 user 리스트는 9가 되는구나. api 확인해보자 (특정 user 를 검색하면 distinct 안해도된다)
                .leftJoin(user.articles, article)
                .fetchJoin()
                .fetch();
    }
}
