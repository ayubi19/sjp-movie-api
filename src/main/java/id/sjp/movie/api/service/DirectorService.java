package id.sjp.movie.api.service;

import id.sjp.movie.api.dto.request.RequestDirectorDTO;
import id.sjp.movie.api.dto.response.ResponseDirectorDTO;
import id.sjp.movie.api.utils.dto.IResultDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface DirectorService {

    IResultDTO<String> create(RequestDirectorDTO requestDirectorDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> update(Long id, RequestDirectorDTO requestDirectorDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseDirectorDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseDirectorDTO>> searchDirector(String keyword, HttpServletRequest httpServletRequest);
}
