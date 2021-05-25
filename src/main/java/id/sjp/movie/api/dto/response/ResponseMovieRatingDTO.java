package id.sjp.movie.api.dto.response;

import lombok.*;

import java.io.Serializable;

@ToString
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMovieRatingDTO implements Serializable {

    private static final long serialVersionUID = 8341773524879839908L;

    private Long movieRatingId;
    private ResponseReviewerDTO reviewer;
    private ResponseMovieDTO movie;
    private float score;
}
