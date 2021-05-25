package id.sjp.movie.api.repository;

import id.sjp.movie.api.entity.Director;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DirectorRepository extends JpaRepository<Director, Long> {

    @Query("select d from Director d where lower(d.fullName) like %:keyword% ")
    Page<Director> findAllByKeyword(String keyword, Pageable pageable);
}
