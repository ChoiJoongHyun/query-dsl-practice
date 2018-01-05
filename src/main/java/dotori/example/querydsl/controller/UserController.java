package dotori.example.querydsl.controller;

import dotori.example.querydsl.domain.User;
import dotori.example.querydsl.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{idx}")
    public UserResponse getUser(final @PathVariable Long idx) {
        User user =  userRepository.findByIdx(idx);

        return UserResponse.builder()
                .idx(user.getIdx())
                .email(user.getEmail())
                .userId(user.getUserId())
                .name(user.getName())
                .password(user.getPassword())
                .build();

    }

    @GetMapping("/test/{idx}")
    public UserResponse getUserQueryFactory(final @PathVariable Long idx) {
        User user = userRepository.findByIdxQueryFactory(idx);

        return UserResponse.builder()
                .idx(user.getIdx())
                .email(user.getEmail())
                .userId(user.getUserId())
                .name(user.getName())
                .password(user.getPassword())
                .articles(user.getArticles().stream()
                        .map(article -> UserResponse.Article.builder()
                                .idx(article.getIdx())
                                .userIdx(article.getUserIdx())
                                .content(article.getContent())
                                .category(article.getCategory())
                                .build())
                        .collect(Collectors.toList())
                )
                .build();
    }

    @GetMapping("/test/{idx}/category/{category}")
    public UserResponse getUserQueryFactory(final @PathVariable Long idx, final @PathVariable String category) {
        User user = userRepository.findWithArticleByIdxAndCategoryQueryFactory(idx, category);

        return UserResponse.builder()
                .idx(user.getIdx())
                .email(user.getEmail())
                .userId(user.getUserId())
                .name(user.getName())
                .password(user.getPassword())
                .articles(user.getArticles().stream()
                        .map(article -> UserResponse.Article.builder()
                                .idx(article.getIdx())
                                .userIdx(article.getUserIdx())
                                .content(article.getContent())
                                .category(article.getCategory())
                                .build())
                        .collect(Collectors.toList())
                )
                .build();
    }
}