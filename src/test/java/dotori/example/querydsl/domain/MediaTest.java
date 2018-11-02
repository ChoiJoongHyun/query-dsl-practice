package dotori.example.querydsl.domain;

import dotori.example.querydsl.repository.MediaRepository;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MediaTest {

    @Autowired
    private MediaRepository mediaRepository;

    @Test
    public void insert_test() {
        Media media = Media.builder()
                .name("mediaName")
                .url("http://zum.com")
                .build();

        //insert 되기 전(persist 되기전) likeCount 값이 null 이면 0 이 되기 떄문에 resultMedia 의 likeCount 값도 0이된다.
        Media resultMedia = mediaRepository.save(media);
        assertThat(resultMedia.getLikeCount(), Is.is(0));
    }
}