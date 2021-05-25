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
public class ResponseMovieGenresDTO implements Serializable {

    private static final long serialVersionUID = 6015107704958589885L;

    private Long movieGenresId;
    private ResponseGenresDTO genres;
    private ResponseMovieDTO movie;
}
