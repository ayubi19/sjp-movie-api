package id.sjp.movie.api.service.impl;


import id.sjp.movie.api.converter.request.MovieRatingRequestConverter;
import id.sjp.movie.api.converter.response.MovieRatingResponseConverter;
import id.sjp.movie.api.dto.request.RequestMovieRatingDTO;
import id.sjp.movie.api.dto.response.ResponseMovieRatingDTO;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieRating;
import id.sjp.movie.api.entity.Reviewer;
import id.sjp.movie.api.repository.MovieRatingRepository;
import id.sjp.movie.api.repository.MovieRepository;
import id.sjp.movie.api.repository.ReviewerRepository;
import id.sjp.movie.api.service.MovieRatingService;
import id.sjp.movie.api.staticvalues.CommonConstant;
import id.sjp.movie.api.utils.dto.IResultDTO;
import id.sjp.movie.api.utils.dto.impl.APIResponseBuilder;
import id.sjp.movie.api.utils.exception.NoContentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class MovieRatingServiceImpl implements MovieRatingService {

    private final MovieRatingRepository movieRatingRepository;
    private final MovieRatingRequestConverter movieRatingRequestConverter;
    private final MovieRatingResponseConverter movieRatingResponseConverter;
    private final MovieRepository movieRepository;
    private final ReviewerRepository reviewerRepository;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> create(RequestMovieRatingDTO requestMovieRatingDTO, HttpServletRequest httpServletRequest) {
        try {
            saveMovieRating(movieRatingRequestConverter.convert(requestMovieRatingDTO));
            return APIResponseBuilder.ok("Movie Rating successfully created");
        } catch (ServiceException e) {
            log.error("Error Service Exception" + e);
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private void saveMovieRating(MovieRating movieRating) {
        movieRatingRepository.save(movieRating);
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> update(Long id, RequestMovieRatingDTO requestMovieRatingDTO, HttpServletRequest httpServletRequest) {
        try {
            MovieRating movieRating = findByid(id);
            Optional<Movie> responseMovie = movieRepository.findById(Long.valueOf(requestMovieRatingDTO.getMovieId()));
            Optional<Reviewer> responseReviewer = reviewerRepository.findById(Long.valueOf(requestMovieRatingDTO.getReviewerId()));
            movieRating.setMovie(responseMovie.get());
            movieRating.setReviewer(responseReviewer.get());
            movieRating.setScore(requestMovieRatingDTO.getScore());
            saveMovieRating(movieRating);
            return APIResponseBuilder.ok(String.format("Movie Rating successfully updated with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private MovieRating findByid(Long id) throws NoContentException {
        Optional<MovieRating> movieRating = movieRatingRepository.findById(id);

        if (!movieRating.isPresent()) {
            throw new NoContentException(String.format("Movie Rating not found with id %d", id));
        }

        return movieRating.get();
    }

    @Override
    public IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest) {
        try {
            MovieRating movieRating = findByid(id);
            movieRating.setDeleted(true);
            saveMovieRating(movieRating);
            return APIResponseBuilder.ok(String.format("Movie Rating successfully deleted with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieRatingDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest) {
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<MovieRating> response = movieRatingRepository.findAll(pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieRatingResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error get list movie rating", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieRatingDTO>> searchMovieRating(String keyword, HttpServletRequest httpServletRequest) {
        int page = 1;
        int size = 20;
        String sortKey = CommonConstant.DEFAULT_SORT_KEY;
        String sortOrder = CommonConstant.DEFAULT_SORT_ORDER;
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<MovieRating> response = movieRatingRepository.findAllByKeyword(keyword.toLowerCase(), pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieRatingResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error search movie rating with keyword", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }
}
