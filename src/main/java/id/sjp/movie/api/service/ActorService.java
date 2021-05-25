package id.sjp.movie.api.service;

import id.sjp.movie.api.dto.request.RequestActorDTO;
import id.sjp.movie.api.dto.response.ResponseActorDTO;
import id.sjp.movie.api.utils.dto.IResultDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ActorService {

    IResultDTO<String> create(RequestActorDTO requestActorDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> update(Long id, RequestActorDTO requestActorDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseActorDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseActorDTO>> searchActor(String keyword, HttpServletRequest httpServletRequest);
}
