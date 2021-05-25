package id.sjp.movie.api.converter.request;

import id.sjp.movie.api.dto.request.RequestMovieDirectionDTO;
import id.sjp.movie.api.entity.Director;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieDirection;
import id.sjp.movie.api.repository.DirectorRepository;
import id.sjp.movie.api.repository.MovieRepository;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieDirectionRequestConverter extends ADATAConverter<RequestMovieDirectionDTO, MovieDirection> {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public MovieDirection convert(RequestMovieDirectionDTO requestMovieDirectionDTO) {
        Optional<Movie> responseMovie = movieRepository.findById(Long.valueOf(requestMovieDirectionDTO.getMovieId()));
        Optional<Director> responseDirector = directorRepository.findById(Long.valueOf(requestMovieDirectionDTO.getDirectorId()));
        MovieDirection movieDirection = new MovieDirection();
        movieDirection.setDirector(responseDirector.get());
        movieDirection.setMovie(responseMovie.get());
        return movieDirection;
    }
}