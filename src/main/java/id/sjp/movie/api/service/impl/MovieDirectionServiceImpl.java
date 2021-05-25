package id.sjp.movie.api.service.impl;


import id.sjp.movie.api.converter.request.MovieDirectionRequestConverter;
import id.sjp.movie.api.converter.response.MovieDirectionResponseConverter;
import id.sjp.movie.api.dto.request.RequestMovieDirectionDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDirectionDTO;
import id.sjp.movie.api.entity.Director;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieDirection;
import id.sjp.movie.api.repository.DirectorRepository;
import id.sjp.movie.api.repository.MovieDirectionRepository;
import id.sjp.movie.api.repository.MovieRepository;
import id.sjp.movie.api.service.MovieDirectionService;
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
public class MovieDirectionServiceImpl implements MovieDirectionService {

    private final MovieDirectionRepository movieDirectionRepository;
    private final MovieDirectionRequestConverter movieDirectionRequestConverter;
    private final MovieDirectionResponseConverter movieDirectionResponseConverter;
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> create(RequestMovieDirectionDTO requestMovieDirectionDTO, HttpServletRequest httpServletRequest) {
        try {
            saveMovieDirection(movieDirectionRequestConverter.convert(requestMovieDirectionDTO));
            return APIResponseBuilder.ok("Movie Direction successfully created");
        } catch (ServiceException e) {
            log.error("Error Service Exception" + e);
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private void saveMovieDirection(MovieDirection movieDirection) {
        movieDirectionRepository.save(movieDirection);
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> update(Long id, RequestMovieDirectionDTO requestMovieDirectionDTO, HttpServletRequest httpServletRequest) {
        try {
            MovieDirection movieDirection = findByid(id);
            Optional<Movie> responseMovie = movieRepository.findById(Long.valueOf(requestMovieDirectionDTO.getMovieId()));
            Optional<Director> responseDirector = directorRepository.findById(Long.valueOf(requestMovieDirectionDTO.getDirectorId()));
            movieDirection.setMovie(responseMovie.get());
            movieDirection.setDirector(responseDirector.get());
            saveMovieDirection(movieDirection);
            return APIResponseBuilder.ok(String.format("Movie Direction successfully updated with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private MovieDirection findByid(Long id) throws NoContentException {
        Optional<MovieDirection> movieDirection = movieDirectionRepository.findById(id);

        if (!movieDirection.isPresent()) {
            throw new NoContentException(String.format("Movie Direction not found with id %d", id));
        }

        return movieDirection.get();
    }

    @Override
    public IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest) {
        try {
            MovieDirection movieDirection = findByid(id);
            movieDirection.setDeleted(true);
            saveMovieDirection(movieDirection);
            return APIResponseBuilder.ok(String.format("Movie Direction successfully deleted with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieDirectionDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest) {
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<MovieDirection> response = movieDirectionRepository.findAll(pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieDirectionResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error get list movie direction", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieDirectionDTO>> searchMovieDirection(String keyword, HttpServletRequest httpServletRequest) {
        int page = 1;
        int size = 20;
        String sortKey = CommonConstant.DEFAULT_SORT_KEY;
        String sortOrder = CommonConstant.DEFAULT_SORT_ORDER;
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<MovieDirection> response = movieDirectionRepository.findAllByKeyword(keyword.toLowerCase(), pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieDirectionResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error search movie direction with keyword", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }
}
