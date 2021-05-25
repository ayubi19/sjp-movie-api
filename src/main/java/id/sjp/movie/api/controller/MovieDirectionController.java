package id.sjp.movie.api.controller;

import id.sjp.movie.api.dto.request.RequestMovieDirectionDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDirectionDTO;
import id.sjp.movie.api.service.MovieDirectionService;
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
@RequestMapping(value = ContextPathConstant.VERSION_V1 + ContextPathConstant.MOVIE_DIRECTION)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class MovieDirectionController {

    private final MovieDirectionService movieDirectionService;

    @PostMapping(PathConstant.CREATE)
    public IResultDTO<String> createMovieDirection(@RequestBody RequestMovieDirectionDTO requestMovieDirectionDTO, HttpServletRequest httpServletRequest) {
        return movieDirectionService.create(requestMovieDirectionDTO, httpServletRequest);
    }

    @PutMapping(PathConstant.UPDATE)
    public IResultDTO<String> updateMovieDirection(@PathVariable Long id, @RequestBody RequestMovieDirectionDTO requestMovieDirectionDTO, HttpServletRequest httpServletRequest) {
        return movieDirectionService.update(id, requestMovieDirectionDTO, httpServletRequest);
    }

    @DeleteMapping(PathConstant.DELETE)
    public IResultDTO<String> deleteMovieDirection(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return movieDirectionService.delete(id, httpServletRequest);
    }

    @GetMapping(PathConstant.MOVIE_DIRECTION_LIST)
    public IResultDTO<List<ResponseMovieDirectionDTO>> findAllMovieDirection(@PathVariable(name = "page") int page,
                                                                             @PathVariable(name = "size") int size,
                                                                             @RequestParam(name = "sort", defaultValue = CommonConstant.DEFAULT_SORT_KEY) String sortKey,
                                                                             @RequestParam(name = "sort-order", defaultValue = CommonConstant.DEFAULT_SORT_ORDER) String sortOrder,
                                                                             HttpServletRequest httpServletRequest) {
        return movieDirectionService.findAll(page, size, sortKey, sortOrder, httpServletRequest);
    }

    @GetMapping(PathConstant.SEARCH_MOVIE_DIRECTION)
    public IResultDTO<List<ResponseMovieDirectionDTO>> searchMovieCast(@RequestParam("keyword") String keyword, HttpServletRequest httpServletRequest) {
        return movieDirectionService.searchMovieDirection(keyword, httpServletRequest);
    }

}
