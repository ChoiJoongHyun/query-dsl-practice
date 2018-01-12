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
 *   joonghyun                2018-01-02
 */
package dotori.example.querydsl.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "ARTICLE_LIKE_COUNT")
public class ArticleLikeCount {

    @Id
    @Column(name = "article_idx")
    private Long idx;

    @Column(name = "count")
    private Long count;
}