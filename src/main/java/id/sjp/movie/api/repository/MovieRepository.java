package id.sjp.movie.api.repository;

import id.sjp.movie.api.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m where lower(m.title) like %:keyword% ")
    Page<Movie> findAllByKeyword(String keyword, Pageable pageable);
}
