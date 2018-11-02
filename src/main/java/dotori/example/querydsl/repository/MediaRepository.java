package dotori.example.querydsl.repository;

import dotori.example.querydsl.domain.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {

}