package id.sjp.movie.api.repository;

import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieCast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieCastRepository extends JpaRepository<MovieCast, Long> {

    @Query("select mc from MovieCast mc where lower(mc.role) like %:keyword% ")
    Page<MovieCast> findAllByKeyword(String keyword, Pageable pageable);

    List<MovieCast> findByMovie(Movie movie);
}
