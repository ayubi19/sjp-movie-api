package id.sjp.movie.api.controller;

import id.sjp.movie.api.dto.request.RequestMovieDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDTO;
import id.sjp.movie.api.dto.response.ResponseMovieDetailDTO;
import id.sjp.movie.api.service.MovieService;
import id.sjp.movie.api.staticvalues.CommonConstant;
import id.sjp.movie.api.staticvalues.ContextPathConstant;
import id.sjp.movie.api.staticvalues.PathConstant;
import id.sjp.movie.api.utils.dto.IResultDTO;
import id.sjp.movie.api.utils.exception.NoContentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = ContextPathConstant.VERSION_V1 + ContextPathConstant.MOVIE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class MovieController {

    private final MovieService movieService;

    @PostMapping(PathConstant.CREATE)
    public IResultDTO<String> createMovie(@RequestBody RequestMovieDTO requestMovieDTO, HttpServletRequest httpServletRequest) {
        return movieService.create(requestMovieDTO, httpServletRequest);
    }

    @PutMapping(PathConstant.UPDATE)
    public IResultDTO<String> updateMovie(@PathVariable Long id, @RequestBody RequestMovieDTO requestMovieDTO, HttpServletRequest httpServletRequest) {
        return movieService.update(id, requestMovieDTO, httpServletRequest);
    }

    @DeleteMapping(PathConstant.DELETE)
    public IResultDTO<String> deleteMovie(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return movieService.delete(id, httpServletRequest);
    }

    @GetMapping(PathConstant.MOVIE_LIST)
    public IResultDTO<List<ResponseMovieDTO>> findAllMovie(@PathVariable(name = "page") int page,
                                                           @PathVariable(name = "size") int size,
                                                           @RequestParam(name = "sort", defaultValue = CommonConstant.DEFAULT_SORT_KEY) String sortKey,
                                                           @RequestParam(name = "sort-order", defaultValue = CommonConstant.DEFAULT_SORT_ORDER) String sortOrder,
                                                           HttpServletRequest httpServletRequest) {
        return movieService.findAll(page, size, sortKey, sortOrder, httpServletRequest);
    }

    @GetMapping(PathConstant.SEARCH_MOVIE)
    public IResultDTO<List<ResponseMovieDTO>> searchMovie(@RequestParam("keyword") String keyword, HttpServletRequest httpServletRequest) {
        return movieService.searchMovie(keyword, httpServletRequest);
    }

    @GetMapping(PathConstant.MOVIE_LIST_DETAIL)
    public IResultDTO<ResponseMovieDetailDTO> findDetailMovie(@PathVariable(name = "id") int id,
                                                              HttpServletRequest httpServletRequest) throws NoContentException {
        return movieService.findMovieDetail(id, httpServletRequest);
    }


}
