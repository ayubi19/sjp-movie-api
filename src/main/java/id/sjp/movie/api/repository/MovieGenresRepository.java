package id.sjp.movie.api.repository;

import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieGenres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieGenresRepository extends JpaRepository<MovieGenres, Long> {

    @Query("select mg from MovieGenres mg where lower(mg.genres.genre) like %:keyword% ")
    Page<MovieGenres> findAllByKeyword(String keyword, Pageable pageable);

    List<MovieGenres> findByMovie(Movie movie);
}
