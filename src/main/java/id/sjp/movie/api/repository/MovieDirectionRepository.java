package id.sjp.movie.api.repository;

import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieDirectionRepository extends JpaRepository<MovieDirection, Long> {

    @Query("select mc from MovieDirection mc where lower(mc.director.fullName) like %:keyword% ")
    Page<MovieDirection> findAllByKeyword(String keyword, Pageable pageable);

    MovieDirection findByMovie(Movie movie);
}
