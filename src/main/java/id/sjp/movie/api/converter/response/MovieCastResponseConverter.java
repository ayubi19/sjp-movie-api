package id.sjp.movie.api.converter.response;

import id.sjp.movie.api.dto.response.ResponseActorDTO;
import id.sjp.movie.api.dto.response.ResponseMovieCastDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDTO;
import id.sjp.movie.api.entity.MovieCast;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieCastResponseConverter extends ADATAConverter<MovieCast, ResponseMovieCastDTO> {

    private final ActorResponseConverter actorResponseConverter;
    private final MovieResponseConverter movieResponseConverter;

    @Override
    public ResponseMovieCastDTO convert(MovieCast movieCast) {
        ResponseMovieDTO responseMovie = movieResponseConverter.convert(movieCast.getMovie());
        ResponseActorDTO responseActorDTO = actorResponseConverter.convert(movieCast.getActor());
        return ResponseMovieCastDTO.builder()
                .movieCastId(movieCast.getId())
                .movie(responseMovie)
                .actor(responseActorDTO)
                .role(movieCast.getRole())
                .build();
    }
}
