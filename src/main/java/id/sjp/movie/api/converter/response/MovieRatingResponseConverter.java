package id.sjp.movie.api.converter.response;

import id.sjp.movie.api.dto.response.ResponseMovieDTO;
import id.sjp.movie.api.dto.response.ResponseMovieRatingDTO;
import id.sjp.movie.api.dto.response.ResponseReviewerDTO;
import id.sjp.movie.api.entity.MovieRating;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieRatingResponseConverter extends ADATAConverter<MovieRating, ResponseMovieRatingDTO> {

    private final ReviewerResponseConverter reviewerResponseConverter;
    private final MovieResponseConverter movieResponseConverter;

    @Override
    public ResponseMovieRatingDTO convert(MovieRating movieRating) {
        ResponseMovieDTO responseMovie = movieResponseConverter.convert(movieRating.getMovie());
        ResponseReviewerDTO responseReviewer = reviewerResponseConverter.convert(movieRating.getReviewer());
        return ResponseMovieRatingDTO.builder()
                .movieRatingId(movieRating.getId())
                .movie(responseMovie)
                .reviewer(responseReviewer)
                .score(movieRating.getScore())
                .build();
    }
}
