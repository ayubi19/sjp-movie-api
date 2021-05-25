package id.sjp.movie.api.repository;

import id.sjp.movie.api.entity.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("select a from Actor a where lower(a.fullName) like %:keyword% ")
    Page<Actor> findAllByKeyword(String keyword, Pageable pageable);
}
