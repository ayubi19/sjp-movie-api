package id.sjp.movie.api.service;

import id.sjp.movie.api.dto.request.RequestReviewerDTO;
import id.sjp.movie.api.dto.response.ResponseReviewerDTO;
import id.sjp.movie.api.utils.dto.IResultDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ReviewerService {

    IResultDTO<String> create(RequestReviewerDTO requestReviewerDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> update(Long id, RequestReviewerDTO requestReviewerDTO, HttpServletRequest httpServletRequest);

    IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseReviewerDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest);

    IResultDTO<List<ResponseReviewerDTO>> searchReviewer(String keyword, HttpServletRequest httpServletRequest);
}
