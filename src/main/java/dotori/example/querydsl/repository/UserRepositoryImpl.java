package dotori.example.querydsl.repository;


import dotori.example.querydsl.domain.User;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

import static dotori.example.querydsl.domain.QUser.user;
/**
 * Created by joonghyun on 2017. 12. 30..
 */
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryImpl() {
        super(User.class);
    }


    @Override
    public User findByIdx(Long idx) {
        return from(user).where(user.idx.eq(idx)).fetchOne();
    }
}
