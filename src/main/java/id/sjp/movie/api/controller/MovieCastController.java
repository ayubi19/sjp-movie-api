package id.sjp.movie.api.controller;

import id.sjp.movie.api.dto.request.RequestMovieCastDTO;
import id.sjp.movie.api.dto.response.ResponseMovieCastDTO;
import id.sjp.movie.api.service.MovieCastService;
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
@RequestMapping(value = ContextPathConstant.VERSION_V1 + ContextPathConstant.MOVIE_CAST)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class MovieCastController {

    private final MovieCastService movieCastService;

    @PostMapping(PathConstant.CREATE)
    public IResultDTO<String> createMovieCast(@RequestBody RequestMovieCastDTO requestMovieCastDTO, HttpServletRequest httpServletRequest) {
        return movieCastService.create(requestMovieCastDTO, httpServletRequest);
    }

    @PutMapping(PathConstant.UPDATE)
    public IResultDTO<String> updateMovieCast(@PathVariable Long id, @RequestBody RequestMovieCastDTO requestMovieCastDTO, HttpServletRequest httpServletRequest) {
        return movieCastService.update(id, requestMovieCastDTO, httpServletRequest);
    }

    @DeleteMapping(PathConstant.DELETE)
    public IResultDTO<String> deleteMovieCast(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return movieCastService.delete(id, httpServletRequest);
    }

    @GetMapping(PathConstant.MOVIE_CAST_LIST)
    public IResultDTO<List<ResponseMovieCastDTO>> findAllMovieCast(@PathVariable(name = "page") int page,
                                                                   @PathVariable(name = "size") int size,
                                                                   @RequestParam(name = "sort", defaultValue = CommonConstant.DEFAULT_SORT_KEY) String sortKey,
                                                                   @RequestParam(name = "sort-order", defaultValue = CommonConstant.DEFAULT_SORT_ORDER) String sortOrder,
                                                                   HttpServletRequest httpServletRequest) {
        return movieCastService.findAll(page, size, sortKey, sortOrder, httpServletRequest);
    }

    @GetMapping(PathConstant.SEARCH_MOVIE_CAST)
    public IResultDTO<List<ResponseMovieCastDTO>> searchMovieCast(@RequestParam("keyword") String keyword, HttpServletRequest httpServletRequest) {
        return movieCastService.searchMovieCast(keyword, httpServletRequest);
    }

}
