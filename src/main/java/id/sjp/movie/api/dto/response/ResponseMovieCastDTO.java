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
public class ResponseMovieCastDTO implements Serializable {

    private static final long serialVersionUID = -999081483741741230L;

    private Long movieCastId;
    private ResponseActorDTO actor;
    private ResponseMovieDTO movie;
    private String role;
}
