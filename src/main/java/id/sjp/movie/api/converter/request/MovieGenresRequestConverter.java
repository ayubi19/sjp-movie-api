package id.sjp.movie.api.converter.request;


import id.sjp.movie.api.dto.request.RequestMovieGenresDTO;
import id.sjp.movie.api.entity.Genres;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieGenres;
import id.sjp.movie.api.repository.GenresRepository;
import id.sjp.movie.api.repository.MovieRepository;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieGenresRequestConverter extends ADATAConverter<RequestMovieGenresDTO, MovieGenres> {

    private final MovieRepository movieRepository;
    private final GenresRepository genresRepository;

    public MovieGenres convert(RequestMovieGenresDTO requestMovieGenresDTO) {
        Optional<Movie> responseMovie = movieRepository.findById(Long.valueOf(requestMovieGenresDTO.getMovieId()));
        Optional<Genres> responseGenres = genresRepository.findById(Long.valueOf(requestMovieGenresDTO.getGenresId()));
        MovieGenres movieGenres = new MovieGenres();
        movieGenres.setGenres(responseGenres.get());
        movieGenres.setMovie(responseMovie.get());
        return movieGenres;
    }
}