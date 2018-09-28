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