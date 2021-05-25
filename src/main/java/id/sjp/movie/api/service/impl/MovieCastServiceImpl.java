package id.sjp.movie.api.service.impl;


import id.sjp.movie.api.converter.request.MovieCastRequestConverter;
import id.sjp.movie.api.converter.response.MovieCastResponseConverter;
import id.sjp.movie.api.dto.request.RequestMovieCastDTO;
import id.sjp.movie.api.dto.response.ResponseMovieCastDTO;
import id.sjp.movie.api.entity.Actor;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieCast;
import id.sjp.movie.api.repository.ActorRepository;
import id.sjp.movie.api.repository.MovieCastRepository;
import id.sjp.movie.api.repository.MovieRepository;
import id.sjp.movie.api.service.MovieCastService;
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
public class MovieCastServiceImpl implements MovieCastService {

    private final MovieCastRepository movieCastRepository;
    private final MovieCastRequestConverter movieCastRequestConverter;
    private final MovieCastResponseConverter movieCastResponseConverter;
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> create(RequestMovieCastDTO requestMovieCastDTO, HttpServletRequest httpServletRequest) {
        try {
            saveMovieCast(movieCastRequestConverter.convert(requestMovieCastDTO));
            return APIResponseBuilder.ok("Movie Cast successfully created");
        } catch (ServiceException e) {
            log.error("Error Service Exception" + e);
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private void saveMovieCast(MovieCast movieCast) {
        movieCastRepository.save(movieCast);
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> update(Long id, RequestMovieCastDTO requestMovieCastDTO, HttpServletRequest httpServletRequest) {
        try {
            MovieCast movieCast = findByid(id);
            Optional<Movie> responseMovie = movieRepository.findById(Long.valueOf(requestMovieCastDTO.getMovieId()));
            Optional<Actor> responseActor = actorRepository.findById(Long.valueOf(requestMovieCastDTO.getActorId()));
            movieCast.setMovie(responseMovie.get());
            movieCast.setActor(responseActor.get());
            saveMovieCast(movieCast);
            return APIResponseBuilder.ok(String.format("Movie Cast successfully updated with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private MovieCast findByid(Long id) throws NoContentException {
        Optional<MovieCast> movieCast = movieCastRepository.findById(id);

        if (!movieCast.isPresent()) {
            throw new NoContentException(String.format("Movie Cast not found with id %d", id));
        }

        return movieCast.get();
    }

    @Override
    public IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest) {
        try {
            MovieCast movieCast = findByid(id);
            movieCast.setDeleted(true);
            saveMovieCast(movieCast);
            return APIResponseBuilder.ok(String.format("Movie Cast successfully deleted with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieCastDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest) {
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<MovieCast> response = movieCastRepository.findAll(pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieCastResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error get list movie genres", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieCastDTO>> searchMovieCast(String keyword, HttpServletRequest httpServletRequest) {
        int page = 1;
        int size = 20;
        String sortKey = CommonConstant.DEFAULT_SORT_KEY;
        String sortOrder = CommonConstant.DEFAULT_SORT_ORDER;
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<MovieCast> response = movieCastRepository.findAllByKeyword(keyword.toLowerCase(), pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieCastResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error search movie cast with keyword", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }
}
