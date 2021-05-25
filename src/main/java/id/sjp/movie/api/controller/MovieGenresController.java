package id.sjp.movie.api.controller;

import id.sjp.movie.api.dto.request.RequestMovieGenresDTO;
import id.sjp.movie.api.dto.response.ResponseMovieGenresDTO;
import id.sjp.movie.api.service.MovieGenresService;
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
@RequestMapping(value = ContextPathConstant.VERSION_V1 + ContextPathConstant.MOVIE_GENRES)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class MovieGenresController {

    private final MovieGenresService movieGenresService;

    @PostMapping(PathConstant.CREATE)
    public IResultDTO<String> createMovieGenres(@RequestBody RequestMovieGenresDTO requestMovieGenresDTO, HttpServletRequest httpServletRequest) {
        return movieGenresService.create(requestMovieGenresDTO, httpServletRequest);
    }

    @PutMapping(PathConstant.UPDATE)
    public IResultDTO<String> updateMovieGenres(@PathVariable Long id, @RequestBody RequestMovieGenresDTO requestMovieGenresDTO, HttpServletRequest httpServletRequest) {
        return movieGenresService.update(id, requestMovieGenresDTO, httpServletRequest);
    }

    @DeleteMapping(PathConstant.DELETE)
    public IResultDTO<String> deleteMovieGenres(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return movieGenresService.delete(id, httpServletRequest);
    }

    @GetMapping(PathConstant.MOVIE_GENRES_LIST)
    public IResultDTO<List<ResponseMovieGenresDTO>> findAllMovieGenres(@PathVariable(name = "page") int page,
                                                                       @PathVariable(name = "size") int size,
                                                                       @RequestParam(name = "sort", defaultValue = CommonConstant.DEFAULT_SORT_KEY) String sortKey,
                                                                       @RequestParam(name = "sort-order", defaultValue = CommonConstant.DEFAULT_SORT_ORDER) String sortOrder,
                                                                       HttpServletRequest httpServletRequest) {
        return movieGenresService.findAll(page, size, sortKey, sortOrder, httpServletRequest);
    }

    @GetMapping(PathConstant.SEARCH_MOVIE_GENRES)
    public IResultDTO<List<ResponseMovieGenresDTO>> searchMovieGenres(@RequestParam("keyword") String keyword, HttpServletRequest httpServletRequest) {
        return movieGenresService.searchMovieGenres(keyword, httpServletRequest);
    }

}
