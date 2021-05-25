package id.sjp.movie.api.service.impl;


import id.sjp.movie.api.converter.request.MovieRequestConverter;
import id.sjp.movie.api.converter.response.*;
import id.sjp.movie.api.dto.request.RequestMovieDTO;
import id.sjp.movie.api.dto.response.*;
import id.sjp.movie.api.entity.*;
import id.sjp.movie.api.repository.*;
import id.sjp.movie.api.service.MovieService;
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
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieRequestConverter movieRequestConverter;
    private final MovieResponseConverter movieResponseConverter;
    private final MovieCastRepository movieCastRepository;
    private final MovieDirectionRepository movieDirectionRepository;
    private final MovieGenresRepository movieGenresRepository;
    private final MovieRatingRepository movieRatingRepository;
    private final MovieCastResponseConverter movieCastResponseConverter;
    private final MovieDirectionResponseConverter movieDirectionResponseConverter;
    private final MovieGenresResponseConverter movieGenresResponseConverter;
    private final MovieRatingResponseConverter movieRatingResponseConverter;
    private final ActorResponseConverter actorResponseConverter;
    private final DirectorResponseConverter directorResponseConverter;
    private final GenresResponseConverter genresResponseConverter;


    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> create(RequestMovieDTO requestMovieDTO, HttpServletRequest httpServletRequest) {
        try {
            saveMovie(movieRequestConverter.convert(requestMovieDTO));
            return APIResponseBuilder.ok("Movie successfully created");
        } catch (ServiceException e) {
            log.error("Error Service Exception" + e);
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> update(Long id, RequestMovieDTO requestMovieDTO, HttpServletRequest httpServletRequest) {
        try {
            Movie movie = findByid(id);
            movie.setTitle(requestMovieDTO.getTitle());
            movie.setYear(requestMovieDTO.getYear());
            movie.setDuration(requestMovieDTO.getDuration());
            movie.setLanguage(requestMovieDTO.getLanguage());
            movie.setReleaseDate(requestMovieDTO.getReleaseDate());
            movie.setUrlImagePoster(requestMovieDTO.getUrlImagePoster());
            movie.setUrlTrialMovie(requestMovieDTO.getUrlTrialMovie());
            movie.setUrlFullMovie(requestMovieDTO.getUrlFullMovie());
            movie.setCountry(requestMovieDTO.getCountry());
            saveMovie(movie);
            return APIResponseBuilder.ok(String.format("Movie successfully updated with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private Movie findByid(Long id) throws NoContentException {
        Optional<Movie> movie = movieRepository.findById(id);

        if (!movie.isPresent()) {
            throw new NoContentException(String.format("Movie not found with id %d", id));
        }

        return movie.get();
    }

    @Override
    public IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest) {
        try {
            Movie movie = findByid(id);
            movie.setDeleted(true);
            saveMovie(movie);
            return APIResponseBuilder.ok(String.format("Movie successfully deleted with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest) {
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<Movie> response = movieRepository.findAll(pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error get list movie", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }

    @Override
    public IResultDTO<List<ResponseMovieDTO>> searchMovie(String keyword, HttpServletRequest httpServletRequest) {
        int page = 1;
        int size = 20;
        String sortKey = CommonConstant.DEFAULT_SORT_KEY;
        String sortOrder = CommonConstant.DEFAULT_SORT_ORDER;
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<Movie> response = movieRepository.findAllByKeyword(keyword.toLowerCase(), pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(movieResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error search movie with keyword", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }

    @Override
    public IResultDTO<ResponseMovieDetailDTO> findMovieDetail(int id, HttpServletRequest httpServletRequest) throws NoContentException {
        Movie movie = findByid(Long.valueOf(id));
        List<ResponseActorDTO> listActor = getMovieCastByMovie(movie);
        ResponseDirectorDTO movieDirection = getMoviDirectionByMovie(movie);
        List<String> listGenre = getMovieGenreByMovie(movie);
        List<ResponseMovieRatingDTO> listRating = getMovieRatingByMovie(movie);

        return APIResponseBuilder.ok(getDetails(movie, listActor, movieDirection, listGenre, listRating));

    }

    private ResponseMovieDetailDTO getDetails(Movie movie, List<ResponseActorDTO> movieCastsList, ResponseDirectorDTO movieDirection,
                                              List<String> movieGenresList, List<ResponseMovieRatingDTO> movieRatingList) {

        Double averageScore = 0D;
        Double finalScore = 0D;
        if (movieRatingList != null) {
            averageScore = movieRatingList.stream().mapToDouble(i -> i.getScore()).sum();
            finalScore = averageScore / Double.valueOf(movieRatingList.size());
        }

        ResponseMovieDetailDTO result = new ResponseMovieDetailDTO();
        result.setMovie(movieResponseConverter.convert(movie));
        result.setListActor(movieCastsList);
        result.setDirector(movieDirection);
        result.setGenre(movieGenresList);
        result.setAverageRating(finalScore);

        return result;
    }

    private List<ResponseActorDTO> getMovieCastByMovie(Movie movie) {
        List<MovieCast> result = new ArrayList<>();
        try {
            result = movieCastRepository.findByMovie(movie);
            if (result.size() == 0) {
                return null;
            }
        } catch (ServiceException e) {
            log.error("Error search movie cast with keyword", e);
        } catch (HttpClientErrorException e) {
            log.error("Error httpClient", e);
        }
        List<Actor> listActor = result.stream().map(MovieCast::getActor).collect(Collectors.toList());
        return actorResponseConverter.mapEntitiesIntoDTOs(listActor);
    }

    private ResponseDirectorDTO getMoviDirectionByMovie(Movie movie) {
        MovieDirection result = new MovieDirection();
        try {
            result = movieDirectionRepository.findByMovie(movie);
            if (result == null) {
                return null;
            }
        } catch (ServiceException e) {
            log.error("Error search movie direction with keyword", e);
        } catch (HttpClientErrorException e) {
            log.error("Error httpClient", e);
        }
        return directorResponseConverter.convert(result.getDirector());
    }

    private List<String> getMovieGenreByMovie(Movie movie) {
        List<MovieGenres> result = new ArrayList<>();
        try {
            result = movieGenresRepository.findByMovie(movie);
            if (result.size() == 0) {
                return null;
            }
        } catch (ServiceException e) {
            log.error("Error search movie genre with keyword", e);
        } catch (HttpClientErrorException e) {
            log.error("Error httpClient", e);
        }
        List<Genres> listGenres = result.stream().map(MovieGenres::getGenres).collect(Collectors.toList());
        return listGenres.stream().map(Genres::getGenre).collect(Collectors.toList());
    }

    private List<ResponseMovieRatingDTO> getMovieRatingByMovie(Movie movie) {
        List<MovieRating> result = new ArrayList<>();
        try {
            result = movieRatingRepository.findByMovie(movie);
            if (result.size() == 0) {
                return null;
            }
        } catch (ServiceException e) {
            log.error("Error search movie genre with keyword", e);
        } catch (HttpClientErrorException e) {
            log.error("Error httpClient", e);
        }
        return movieRatingResponseConverter.mapEntitiesIntoDTOs(result);
    }


}
