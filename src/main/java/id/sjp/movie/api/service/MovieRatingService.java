package id.sjp.movie.api.service;

import id.sjp.movie.api.dto.request.RequestMovieRatingDTO;
import id.sjp.movie.api.dto.response.ResponseMovieRatingDTO;
import id.sjp.movie.api.utils.dto.IResultDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MovieRatingService {

    IResultDTO<String> create(RequestMovieRatingDTO requestMovieRatingDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> update(Long id, RequestMovieRatingDTO requestMovieRatingDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieRatingDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieRatingDTO>> searchMovieRating(String keyword, HttpServletRequest httpServletRequest);
}
