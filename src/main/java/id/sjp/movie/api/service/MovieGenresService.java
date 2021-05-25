package id.sjp.movie.api.service;

import id.sjp.movie.api.dto.request.RequestMovieGenresDTO;
import id.sjp.movie.api.dto.response.ResponseMovieGenresDTO;
import id.sjp.movie.api.utils.dto.IResultDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MovieGenresService {

    IResultDTO<String> create(RequestMovieGenresDTO requestMovieGenresDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> update(Long id, RequestMovieGenresDTO requestMovieGenresDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieGenresDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieGenresDTO>> searchMovieGenres(String keyword, HttpServletRequest httpServletRequest);
}
