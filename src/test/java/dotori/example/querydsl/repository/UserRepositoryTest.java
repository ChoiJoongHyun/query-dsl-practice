package dotori.example.querydsl.repository;


import dotori.example.querydsl.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void user_left_join_article() {
        List<User> users = userRepository.findWithArticle();
        Assert.assertEquals(8, users.size());
    }

    @Test
    public void select_distinct_stream_distinct_같은지확인(){
        int selectDistinctSize = userRepository.findWithArticle_selectDistinct().size();
        int streamDistinctSize = userRepository.findWithArticle_streamDistinct().size();
        Assert.assertEquals(selectDistinctSize, streamDistinctSize);
    }

    @Test
    public void oneToMany_관계시_fetch_join_사용후_limit_쿼리확인() {
        List<User> users_1 = userRepository.findWithArticle_fetch_join();
        List<User> users_2 = userRepository.findWithArticle_not_fetch_join();
        Assert.assertEquals(users_1.size(), users_2.size());
    }
}