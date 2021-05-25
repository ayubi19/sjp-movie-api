package id.sjp.movie.api.repository;

import id.sjp.movie.api.entity.Reviewer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {

    @Query("select r from Reviewer r where lower(r.name) like %:keyword% ")
    Page<Reviewer> findAllByKeyword(String keyword, Pageable pageable);
}
