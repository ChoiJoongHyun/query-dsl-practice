package dotori.example.querydsl.domain;

import dotori.example.querydsl.repository.MediaRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/* Copyright (c) 2018 ZUM Internet, Inc.
 * All right reserved.
 * http://www.zum.com
 * This software is the confidential and proprietary information of ZUM
 * , Inc. You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with ZUM.
 *
 * Revision History
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 *   joonghyun                2018-11-02
 */

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