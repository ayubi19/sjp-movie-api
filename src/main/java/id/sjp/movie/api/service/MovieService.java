package id.sjp.movie.api.service;

import id.sjp.movie.api.dto.request.RequestMovieDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDetailDTO;
import id.sjp.movie.api.utils.dto.IResultDTO;
import id.sjp.movie.api.utils.exception.NoContentException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MovieService {

    IResultDTO<String> create(RequestMovieDTO requestMovieDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> update(Long id, RequestMovieDTO requestMovieDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieDTO>> searchMovie(String keyword, HttpServletRequest httpServletRequest);

    IResultDTO<ResponseMovieDetailDTO> findMovieDetail(int id, HttpServletRequest httpServletRequest) throws NoContentException;
}
