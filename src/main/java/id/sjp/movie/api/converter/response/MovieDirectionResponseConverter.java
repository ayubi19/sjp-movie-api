package id.sjp.movie.api.converter.response;

import id.sjp.movie.api.dto.response.ResponseDirectorDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDirectionDTO;
import id.sjp.movie.api.entity.MovieDirection;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieDirectionResponseConverter extends ADATAConverter<MovieDirection, ResponseMovieDirectionDTO> {

    private final DirectorResponseConverter directorResponseConverter;
    private final MovieResponseConverter movieResponseConverter;

    @Override
    public ResponseMovieDirectionDTO convert(MovieDirection movieDirection) {
        ResponseMovieDTO responseMovie = movieResponseConverter.convert(movieDirection.getMovie());
        ResponseDirectorDTO responseDirector = directorResponseConverter.convert(movieDirection.getDirector());
        return ResponseMovieDirectionDTO.builder()
                .movieDirectionId(movieDirection.getId())
                .movie(responseMovie)
                .director(responseDirector)
                .build();
    }
}
