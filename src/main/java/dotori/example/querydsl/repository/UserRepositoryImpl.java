package dotori.example.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dotori.example.querydsl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import static dotori.example.querydsl.domain.QUser.user;
import static dotori.example.querydsl.domain.QArticle.article;
/**
 * Created by joonghyun on 2017. 12. 30..
 */
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

    private JPAQueryFactory queryFactory;

    @Autowired
    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public User findByIdx(Long idx) {
        return from(user).where(user.idx.eq(idx)).fetchOne();
    }

    @Override
    public User findByIdxQueryFactory(Long idx) {
        return this.queryFactory.selectFrom(user)
                .innerJoin(user.articles, article)
                .fetchJoin()
                .where(user.idx.eq(idx))
                .fetchOne();
    }

    @Override
    public User findWithArticleByIdxAndCategoryQueryFactory(Long idx, String category) {

        //return from(user).select(user.idx).distinct().fetch();
        //return this.queryFactory.select()
        return this.queryFactory.selectFrom(user)
                .innerJoin(user.articles, article)
                .fetchJoin()
                .where(user.idx.eq(idx)
                        .and(article.category.eq(category)))
                .fetchOne();
    }

    /*@Override
    public User findByIdx(Long idx) {
        return from(user)
                .where(user.idx.eq(idx))
                .fetchOne();
    }


















    @Override
    public List<User> findListWithArticleByIdx(Long idx) {
        return from(user)
                .leftJoin(user.articles, article)
                .fetchJoin()
                .where(user.idx.eq(idx))
                .fetch();
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

    @Override
    public List<User> findWithArticleByIdxIn(List<Long> idxList) {
        return from(user)
                .distinct()
                .leftJoin(user.articles, article)
                .fetchJoin()
                .where(user.idx.in(idxList))
                .fetch();
    }*/
}
