package id.sjp.movie.api.converter.request;

import id.sjp.movie.api.dto.request.RequestMovieDTO;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;

@Component
public class MovieRequestConverter extends ADATAConverter<RequestMovieDTO, Movie> {

    public Movie convert(RequestMovieDTO requestMovieDTO) {
        Movie movie = new Movie();
        movie.setTitle(requestMovieDTO.getTitle());
        movie.setYear(requestMovieDTO.getYear());
        movie.setDuration(requestMovieDTO.getDuration());
        movie.setLanguage(requestMovieDTO.getLanguage());
        movie.setReleaseDate(requestMovieDTO.getReleaseDate());
        movie.setUrlImagePoster(requestMovieDTO.getUrlImagePoster());
        movie.setUrlTrialMovie(requestMovieDTO.getUrlTrialMovie());
        movie.setUrlFullMovie(requestMovieDTO.getUrlFullMovie());
        movie.setCountry(requestMovieDTO.getCountry());
        return movie;
    }
}