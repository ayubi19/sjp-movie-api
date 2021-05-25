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
public class ResponseMovieDirectionDTO implements Serializable {

    private static final long serialVersionUID = -8103822167814185926L;

    private Long movieDirectionId;
    private ResponseDirectorDTO director;
    private ResponseMovieDTO movie;
}
