package id.sjp.movie.api.repository;

import id.sjp.movie.api.entity.Genres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenresRepository extends JpaRepository<Genres, Long> {

    @Query("select g from Genres g where lower(g.genre) like %:keyword% ")
    Page<Genres> findAllByKeyword(String keyword, Pageable pageable);
}
