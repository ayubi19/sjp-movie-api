package id.sjp.movie.api.converter.response;

import id.sjp.movie.api.dto.response.ResponseGenresDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDTO;
import id.sjp.movie.api.dto.response.ResponseMovieGenresDTO;
import id.sjp.movie.api.entity.MovieGenres;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieGenresResponseConverter extends ADATAConverter<MovieGenres, ResponseMovieGenresDTO> {

    private final GenresResponseConverter genresResponseConverter;
    private final MovieResponseConverter movieResponseConverter;

    @Override
    public ResponseMovieGenresDTO convert(MovieGenres movieGenres) {
        ResponseMovieDTO responseMovie = movieResponseConverter.convert(movieGenres.getMovie());
        ResponseGenresDTO responseGenres = genresResponseConverter.convert(movieGenres.getGenres());
        return ResponseMovieGenresDTO.builder()
                .movieGenresId(movieGenres.getId())
                .movie(responseMovie)
                .genres(responseGenres)
                .build();
    }
}
