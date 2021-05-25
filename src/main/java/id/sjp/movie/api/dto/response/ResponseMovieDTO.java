package id.sjp.movie.api.dto.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@ToString
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMovieDTO implements Serializable {

    private static final long serialVersionUID = -3538112317365876601L;

    private Long movieId;
    private String title;
    private Integer year;
    private float duration;
    private String language;
    private LocalDate releaseDate;
    private String urlImagePoster;
    private String urlTrialMovie;
    private String urlFullMovie;
    private String country;
}
