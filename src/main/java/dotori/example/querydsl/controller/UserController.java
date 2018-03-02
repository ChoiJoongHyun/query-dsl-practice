package dotori.example.querydsl.controller;

import dotori.example.querydsl.domain.User;
import dotori.example.querydsl.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{idx}")
    public UserResponse updateUser(final @PathVariable Long idx) {
        return UserResponse.builder()
                .idx(100L)
                .name("test")
                .build();
    }
}