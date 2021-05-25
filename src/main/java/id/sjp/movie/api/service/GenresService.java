package id.sjp.movie.api.service;

import id.sjp.movie.api.dto.request.RequestGenresDTO;
import id.sjp.movie.api.dto.response.ResponseGenresDTO;
import id.sjp.movie.api.utils.dto.IResultDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface GenresService {

    IResultDTO<String> create(RequestGenresDTO requestGenresDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> update(Long id, RequestGenresDTO requestGenresDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseGenresDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseGenresDTO>> searchGenres(String keyword, HttpServletRequest httpServletRequest);
}
