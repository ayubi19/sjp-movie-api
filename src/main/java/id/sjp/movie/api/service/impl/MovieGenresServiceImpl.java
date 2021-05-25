package id.sjp.movie.api.service.impl;


import id.sjp.movie.api.converter.request.MovieGenresRequestConverter;
import id.sjp.movie.api.converter.response.MovieGenresResponseConverter;
import id.sjp.movie.api.dto.request.RequestMovieGenresDTO;
import id.sjp.movie.api.dto.response.ResponseMovieGenresDTO;
import id.sjp.movie.api.entity.Genres;
import id.sjp.movie.api.entity.Movie;
import id.sjp.movie.api.entity.MovieGenres;
import id.sjp.movie.api.repository.GenresRepository;
import id.sjp.movie.api.repository.MovieGenresRepository;
import id.sjp.movie.api.repository.MovieRepository;
import id.sjp.movie.api.service.MovieGenresService;
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
public class MovieGenresServiceImpl implements MovieGenresService {

    private final MovieGenresRepository movieGenresRepository;
    private final MovieGenresRequestConverter movieGenresRequestConverter;
    private final MovieGenresResponseConverter movieGenresResponseConverter;
    private final MovieRepository movieRepository;
    private final GenresRepository genresRepository;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> create(RequestMovieGenresDTO requestMovieGenresDTO, HttpServletRequest httpServletRequest) {
        try {
            saveMovieGenres(movieGenresRequestConverter.convert(requestMovieGenresDTO));
            return APIResponseBuilder.ok("Movie Genres successfully created");
        } catch (ServiceException e) {
            log.error("Error Service Exception" + e);
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private void saveMovieGenres(MovieGenres movieGenres) {
        movieGenresRepository.save(movieGenres);
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> update(Long id, RequestMovieGenresDTO requestMovieGenresDTO, HttpServletRequest httpServletRequest) {
        try {
            MovieGenres movieGenres = findByid(id);
            Optional<Movie> responseMovie = movieRepository.findById(Long.valueOf(requestMovieGenresDTO.getMovieId()));
            Optional<Genres> responseGenres = genresRepository.findById(Long.valueOf(requestMovieGenresDTO.getGenresId()));
            movieGenres.setMovie(responseMovie.get());
            movieGenres.setGenres(responseGenres.get());
            saveMovieGenres(movieGenres);
            return APIResponseBuilder.ok(String.format("Movie Genres successfully updated with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private MovieGenres findByid(Long id) throws NoContentException {
        Optional<MovieGenres> movieGenres = movieGenresRepository.findById(id);

        if (!movieGenres.isPresent()) {
            throw new NoContentException(String.format("Movie Genrese not found with id %d", id));
        }

        return movieGenres.get();
    }

    @Override
    public IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest) {
        try {
            MovieGenres movieGenres = findByid(id);
            movieGenres.setDeleted(true);
            saveMovieGenres(movieGenres);
            return APIResponseBuilder.ok(String.format("Movie Genres successfully deleted with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieGenresDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest) {
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<MovieGenres> response = movieGenresRepository.findAll(pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieGenresResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error get list movie genres", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieGenresDTO>> searchMovieGenres(String keyword, HttpServletRequest httpServletRequest) {
        int page = 1;
        int size = 20;
        String sortKey = CommonConstant.DEFAULT_SORT_KEY;
        String sortOrder = CommonConstant.DEFAULT_SORT_ORDER;
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<MovieGenres> response = movieGenresRepository.findAllByKeyword(keyword.toLowerCase(), pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieGenresResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error search movie genres with keyword", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }
}
