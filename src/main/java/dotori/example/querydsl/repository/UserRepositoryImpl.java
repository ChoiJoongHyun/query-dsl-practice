package dotori.example.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dotori.example.querydsl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

import static dotori.example.querydsl.domain.QArticle.article;
import static dotori.example.querydsl.domain.QUser.user;
/**
 * Created by joonghyun on 2017. 12. 30..
 */
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;
    }

    /**
     * user left join article
     * */
    @Override
    public List<User> findWithArticle() {
        return this.queryFactory.select(user)
                .from(user)
                .leftJoin(user.articles, article)
                .fetch();
    }

    /**
     * user left join article
     * stream 으로 중복제거
     * */
    @Override
    public List<User> findWithArticle_streamDistinct() {
        return this.queryFactory.select(user)
                .from(user)
                .leftJoin(user.articles, article)
                .fetch().stream().distinct().collect(Collectors.toList());
    }

    /**
     * user left join article
     * selectDistinct 으로 중복제거
     * */
    @Override
    public List<User> findWithArticle_selectDistinct() {
        return this.queryFactory.selectDistinct(user)
                .from(user)
                .leftJoin(user.articles, article)
                .fetch();
    }


    @Override
    public List<User> findWithArticle_fetch_join() {
        return this.queryFactory.selectFrom(user)
                .leftJoin(user.articles, article)
                .fetchJoin()
                .limit(2)
                .fetch();
    }

    @Override
    public List<User> findWithArticle_not_fetch_join() {
        return this.queryFactory.selectFrom(user)
                .leftJoin(user.articles, article)
                .limit(2)
                .fetch();
    }
}
