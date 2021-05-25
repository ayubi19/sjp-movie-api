package id.sjp.movie.api.service;

import id.sjp.movie.api.dto.request.RequestMovieCastDTO;
import id.sjp.movie.api.dto.response.ResponseMovieCastDTO;
import id.sjp.movie.api.utils.dto.IResultDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MovieCastService {

    IResultDTO<String> create(RequestMovieCastDTO requestMovieCastDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> update(Long id, RequestMovieCastDTO requestMovieCastDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieCastDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseMovieCastDTO>> searchMovieCast(String keyword, HttpServletRequest httpServletRequest);
}
