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
public class RequestMovieCastDTO {

    private static final long serialVersionUID = -884454640193361475L;

    @NotNull
    private Integer actorId;

    @NotNull
    private Integer movieId;

    @NotNull
    private String role;

}
