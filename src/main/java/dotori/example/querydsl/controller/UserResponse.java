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
 *   joonghyun                2018-01-05
 */
package dotori.example.querydsl.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UserResponse {
    private Long idx;
    private String userId;
    private String password;
    private String name;
    private String email;

    private List<Article> articles;

    @Builder
    @Getter
    public static class Article{
        private Long idx;
        private Long userIdx;
        private String content;
        private String category;
    }
}