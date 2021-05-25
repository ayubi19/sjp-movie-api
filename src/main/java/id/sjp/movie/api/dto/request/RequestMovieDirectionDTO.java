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
public class RequestMovieDirectionDTO {

    private static final long serialVersionUID = -6974128197158158487L;

    @NotNull
    private Integer directorId;

    @NotNull
    private Integer movieId;
}
