package id.sjp.movie.api.repository;

import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieRating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {

    @Query("select mr from MovieRating mr where lower(mr.movie.title) like %:keyword% ")
    Page<MovieRating> findAllByKeyword(String keyword, Pageable pageable);

    List<MovieRating> findByMovie(Movie movie);
}
