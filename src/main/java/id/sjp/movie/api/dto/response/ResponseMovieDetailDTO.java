package id.sjp.movie.api.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@ToString
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMovieDetailDTO implements Serializable {

    private static final long serialVersionUID = 7773291770996357250L;

    private ResponseMovieDTO movie;
    private List<ResponseActorDTO> listActor;
    private ResponseDirectorDTO director;
    private List<String> genre;
    private Double averageRating;
}
