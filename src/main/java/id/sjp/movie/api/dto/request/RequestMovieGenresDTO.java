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
public class RequestMovieGenresDTO {

    private static final long serialVersionUID = -2827494157738089125L;

    @NotNull
    private Integer genresId;

    @NotNull
    private Integer movieId;
}
