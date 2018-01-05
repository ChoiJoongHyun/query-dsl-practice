package dotori.example.querydsl.repository;

import dotori.example.querydsl.domain.User;

import java.util.List;

/**
 * Created by joonghyun on 2017. 12. 30..
 */
public interface UserRepositoryCustom {
    User findByIdx(Long idx);
    User findByIdxQueryFactory(Long idx);

    User findWithArticleByIdxAndCategoryQueryFactory(Long idx, String category);
    /*User findByIdx(Long idx);


    User findWithArticleByIdx(Long idx);
    List<User> findListWithArticleByIdx(Long idx);



    List<User> findWithArticle();

    List<User> findWithArticleByIdxIn(List<Long> idxList);*/
}
