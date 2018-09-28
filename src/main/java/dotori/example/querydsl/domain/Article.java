package dotori.example.querydsl.domain;

import lombok.Getter;
import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "ARTICLE")
public class Article {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "user_idx")
    private Long userIdx;

    @Column(name = "content")
    private String content;

    @Column(name = "category")
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", insertable = false, updatable = false)
    private User user;
}