package dotori.example.querydsl.repository;

import dotori.example.querydsl.domain.User;

import java.util.List;

/**
 * Created by joonghyun on 2017. 12. 30..
 */
public interface UserRepositoryCustom {
    List<User> findWithArticle();

    List<User> findWithArticle_streamDistinct();
    List<User> findWithArticle_selectDistinct();

    List<User> findWithArticle_fetch_join();
    List<User> findWithArticle_not_fetch_join();


}
