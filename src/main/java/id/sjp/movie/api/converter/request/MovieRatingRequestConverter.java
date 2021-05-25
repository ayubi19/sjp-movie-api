package id.sjp.movie.api.converter.request;

import id.sjp.movie.api.dto.request.RequestMovieRatingDTO;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieRating;
import id.sjp.movie.api.entity.Reviewer;
import id.sjp.movie.api.repository.MovieRepository;
import id.sjp.movie.api.repository.ReviewerRepository;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieRatingRequestConverter extends ADATAConverter<RequestMovieRatingDTO, MovieRating> {

    private final MovieRepository movieRepository;
    private final ReviewerRepository reviewerRepository;

    public MovieRating convert(RequestMovieRatingDTO requestMovieRatingDTO) {
        Optional<Movie> responseMovie = movieRepository.findById(Long.valueOf(requestMovieRatingDTO.getMovieId()));
        Optional<Reviewer> responseReviewer = reviewerRepository.findById(Long.valueOf(requestMovieRatingDTO.getReviewerId()));
        MovieRating movieRating = new MovieRating();
        movieRating.setReviewer(responseReviewer.get());
        movieRating.setMovie(responseMovie.get());
        return movieRating;
    }
}