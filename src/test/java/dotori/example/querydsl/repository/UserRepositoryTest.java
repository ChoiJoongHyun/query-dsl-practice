package dotori.example.querydsl.repository;


import dotori.example.querydsl.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void user_단일조회_article_포함() throws Exception {
        List<User> users = userRepository.findListWithArticleByIdx(1L);
        User user = userRepository.findWithArticleByIdx(1L);
        System.out.println(users.size());
    }

    @Test
    public void user_모두조회_article_포함() throws Exception {
        List<User> users = userRepository.findWithArticle();
        Assert.assertEquals(users.size(), 3);
    }

    @Test
    public void user_여러조회_article_포함() throws Exception {
        List<Long> idxList = Arrays.asList(1L, 2L);
        List<User> users = userRepository.findWithArticleByIdxIn(idxList);
        Assert.assertEquals(users.size(), 2);
    }
}