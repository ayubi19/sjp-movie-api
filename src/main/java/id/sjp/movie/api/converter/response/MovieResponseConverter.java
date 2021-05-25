package id.sjp.movie.api.converter.response;

import id.sjp.movie.api.dto.response.ResponseMovieDTO;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;


@Component
public class MovieResponseConverter extends ADATAConverter<Movie, ResponseMovieDTO> {

    @Override
    public ResponseMovieDTO convert(Movie movie) {
        return ResponseMovieDTO.builder()
                .movieId(movie.getId())
                .title(movie.getTitle())
                .year(movie.getYear())
                .duration(movie.getDuration())
                .language(movie.getLanguage())
                .releaseDate(movie.getReleaseDate())
                .urlImagePoster(movie.getUrlImagePoster())
                .urlTrialMovie(movie.getUrlTrialMovie())
                .urlFullMovie(movie.getUrlFullMovie())
                .country(movie.getCountry())
                .build();
    }
}
