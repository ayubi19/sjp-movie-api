package id.sjp.movie.api.service;

import id.sjp.movie.api.dto.request.RequestMovieDirectionDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDirectionDTO;
import id.sjp.movie.api.utils.dto.IResultDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MovieDirectionService {

    IResultDTO<String> create(RequestMovieDirectionDTO requestMovieDirectionDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> update(Long id, RequestMovieDirectionDTO requestMovieDirectionDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieDirectionDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieDirectionDTO>> searchMovieDirection(String keyword, HttpServletRequest httpServletRequest);
}
