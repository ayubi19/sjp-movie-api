package id.sjp.movie.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(schema = "public", name = "movie")
@Where(clause = "is_deleted = false")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "duration")
    private float duration;

    @Column(name = "language")
    private String language;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "url_image_poster")
    private String urlImagePoster;

    @Column(name = "url_trial_movie")
    private String urlTrialMovie;

    @Column(name = "url_full_movie")
    private String urlFullMovie;

    @Column(name = "country")
    private String country;
}
