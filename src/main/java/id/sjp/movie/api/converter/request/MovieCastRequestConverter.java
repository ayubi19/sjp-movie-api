package id.sjp.movie.api.converter.request;

import id.sjp.movie.api.dto.request.RequestMovieCastDTO;
import id.sjp.movie.api.entity.Actor;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieCast;
import id.sjp.movie.api.repository.ActorRepository;
import id.sjp.movie.api.repository.MovieRepository;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieCastRequestConverter extends ADATAConverter<RequestMovieCastDTO, MovieCast> {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public MovieCast convert(RequestMovieCastDTO requestMovieCastDTO) {
        Optional<Movie> responseMovie = movieRepository.findById(Long.valueOf(requestMovieCastDTO.getMovieId()));
        Optional<Actor> responseActor = actorRepository.findById(Long.valueOf(requestMovieCastDTO.getActorId()));
        MovieCast movieCast = new MovieCast();
        movieCast.setActor(responseActor.get());
        movieCast.setMovie(responseMovie.get());
        movieCast.setRole(requestMovieCastDTO.getRole());
        return movieCast;
    }
}