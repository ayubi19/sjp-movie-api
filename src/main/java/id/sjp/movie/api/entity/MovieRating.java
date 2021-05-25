package id.sjp.movie.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Entity
@Table(schema = "public", name = "movie_rating")
@Where(clause = "is_deleted = false")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRating extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "reviewer_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Reviewer reviewer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Movie movie;

    @Column(name = "score")
    private float score;

}
