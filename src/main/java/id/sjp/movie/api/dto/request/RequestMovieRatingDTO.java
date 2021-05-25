package id.sjp.movie.api.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMovieRatingDTO {

    private static final long serialVersionUID = -5532529279872652868L;

    @NotNull
    private Integer reviewerId;

    @NotNull
    private Integer movieId;

    @NotNull
    private float score;
}
