package id.sjp.movie.api.controller;

import id.sjp.movie.api.dto.request.RequestReviewerDTO;
import id.sjp.movie.api.dto.response.ResponseReviewerDTO;
import id.sjp.movie.api.service.ReviewerService;
import id.sjp.movie.api.staticvalues.CommonConstant;
import id.sjp.movie.api.staticvalues.ContextPathConstant;
import id.sjp.movie.api.staticvalues.PathConstant;
import id.sjp.movie.api.utils.dto.IResultDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = ContextPathConstant.VERSION_V1 + ContextPathConstant.REVIEWER)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class ReviewerController {

    private final ReviewerService reviewerService;

    @PostMapping(PathConstant.CREATE)
    public IResultDTO<String> createReviewer(@RequestBody RequestReviewerDTO requestReviewerDTO, HttpServletRequest httpServletRequest) {
        return reviewerService.create(requestReviewerDTO, httpServletRequest);
    }

    @PutMapping(PathConstant.UPDATE)
    public IResultDTO<String> updateReviewer(@PathVariable Long id, @RequestBody RequestReviewerDTO requestReviewerDTO, HttpServletRequest httpServletRequest) {
        return reviewerService.update(id, requestReviewerDTO, httpServletRequest);
    }

    @DeleteMapping(PathConstant.DELETE)
    public IResultDTO<String> deleteReviewer(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return reviewerService.delete(id, httpServletRequest);
    }

    @GetMapping(PathConstant.REVIEWER_LIST)
    public IResultDTO<List<ResponseReviewerDTO>> findAllReviewer(@PathVariable(name = "page") int page,
                                                                 @PathVariable(name = "size") int size,
                                                                 @RequestParam(name = "sort", defaultValue = CommonConstant.DEFAULT_SORT_KEY) String sortKey,
                                                                 @RequestParam(name = "sort-order", defaultValue = CommonConstant.DEFAULT_SORT_ORDER) String sortOrder,
                                                                 HttpServletRequest httpServletRequest) {
        return reviewerService.findAll(page, size, sortKey, sortOrder, httpServletRequest);
    }

    @GetMapping(PathConstant.SEARCH_REVIEWER)
    public IResultDTO<List<ResponseReviewerDTO>> searchReviewer(@RequestParam("keyword") String keyword, HttpServletRequest httpServletRequest) {
        return reviewerService.searchReviewer(keyword, httpServletRequest);
    }

}
