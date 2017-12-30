package dotori.example.querydsl.repository;

import dotori.example.querydsl.domain.User;

/**
 * Created by joonghyun on 2017. 12. 30..
 */
public interface UserRepositoryCustom {
    User findByIdx(Long idx);
}
