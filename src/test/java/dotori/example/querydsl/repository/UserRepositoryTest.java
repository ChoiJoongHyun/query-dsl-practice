package dotori.example.querydsl.repository;


import dotori.example.querydsl.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void user_단일조회_article_포함() throws Exception {
        User user = userRepository.findWithArticleByIdx(1L);
        Assert.assertNotNull(user.getArticles());
    }

    @Test
    public void user_모두조회_article_포함() throws Exception {
        List<User> users = userRepository.findWithArticle();
        Assert.assertEquals(users.size(), 3);
    }
}