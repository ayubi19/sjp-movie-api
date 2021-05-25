package id.sjp.movie.api.controller;

import id.sjp.movie.api.dto.request.RequestMovieRatingDTO;
import id.sjp.movie.api.dto.response.ResponseMovieRatingDTO;
import id.sjp.movie.api.service.MovieRatingService;
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
@RequestMapping(value = ContextPathConstant.VERSION_V1 + ContextPathConstant.MOVIE_RATING)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class MovieRatingController {

    private final MovieRatingService movieRatingsService;

    @PostMapping(PathConstant.CREATE)
    public IResultDTO<String> createMovieRating(@RequestBody RequestMovieRatingDTO requestMovieRatingDTO, HttpServletRequest httpServletRequest) {
        return movieRatingsService.create(requestMovieRatingDTO, httpServletRequest);
    }

    @PutMapping(PathConstant.UPDATE)
    public IResultDTO<String> updateMovieRating(@PathVariable Long id, @RequestBody RequestMovieRatingDTO requestMovieRatingDTO, HttpServletRequest httpServletRequest) {
        return movieRatingsService.update(id, requestMovieRatingDTO, httpServletRequest);
    }

    @DeleteMapping(PathConstant.DELETE)
    public IResultDTO<String> deleteMovieRating(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return movieRatingsService.delete(id, httpServletRequest);
    }

    @GetMapping(PathConstant.MOVIE_RATING_LIST)
    public IResultDTO<List<ResponseMovieRatingDTO>> findAllMovieRating(@PathVariable(name = "page") int page,
                                                                       @PathVariable(name = "size") int size,
                                                                       @RequestParam(name = "sort", defaultValue = CommonConstant.DEFAULT_SORT_KEY) String sortKey,
                                                                       @RequestParam(name = "sort-order", defaultValue = CommonConstant.DEFAULT_SORT_ORDER) String sortOrder,
                                                                       HttpServletRequest httpServletRequest) {
        return movieRatingsService.findAll(page, size, sortKey, sortOrder, httpServletRequest);
    }

    @GetMapping(PathConstant.SEARCH_MOVIE_RATING)
    public IResultDTO<List<ResponseMovieRatingDTO>> searchMovieRating(@RequestParam("keyword") String keyword, HttpServletRequest httpServletRequest) {
        return movieRatingsService.searchMovieRating(keyword, httpServletRequest);
    }

}
