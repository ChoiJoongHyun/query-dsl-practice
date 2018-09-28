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