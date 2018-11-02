package dotori.example.querydsl.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "MEDIA")
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "like_count")
    private Integer likeCount = 0;

    @Builder
    public Media(String name, String url, Integer likeCount) {
        this.name = name;
        this.url = url;
        this.likeCount = likeCount;
    }

    /**
     * insert 되기전 (persist 되기전) 실행된다.
     * */
    @PrePersist
    public void prePersist() {
        this.likeCount = this.likeCount == null ? 0 : this.likeCount;
    }
}