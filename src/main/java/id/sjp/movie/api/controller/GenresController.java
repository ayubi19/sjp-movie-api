package id.sjp.movie.api.controller;

import id.sjp.movie.api.dto.request.RequestGenresDTO;
import id.sjp.movie.api.dto.response.ResponseGenresDTO;
import id.sjp.movie.api.service.GenresService;
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
@RequestMapping(value = ContextPathConstant.VERSION_V1 + ContextPathConstant.GENRES)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class GenresController {

    private final GenresService genresService;

    @PostMapping(PathConstant.CREATE)
    public IResultDTO<String> createGenres(@RequestBody RequestGenresDTO requestGenresDTO, HttpServletRequest httpServletRequest) {
        return genresService.create(requestGenresDTO, httpServletRequest);
    }

    @PutMapping(PathConstant.UPDATE)
    public IResultDTO<String> updateGenres(@PathVariable Long id, @RequestBody RequestGenresDTO requestGenresDTO, HttpServletRequest httpServletRequest) {
        return genresService.update(id, requestGenresDTO, httpServletRequest);
    }

    @DeleteMapping(PathConstant.DELETE)
    public IResultDTO<String> deleteGenres(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return genresService.delete(id, httpServletRequest);
    }

    @GetMapping(PathConstant.GENRES_LIST)
    public IResultDTO<List<ResponseGenresDTO>> findAllGenres(@PathVariable(name = "page") int page,
                                                             @PathVariable(name = "size") int size,
                                                             @RequestParam(name = "sort", defaultValue = CommonConstant.DEFAULT_SORT_KEY) String sortKey,
                                                             @RequestParam(name = "sort-order", defaultValue = CommonConstant.DEFAULT_SORT_ORDER) String sortOrder,
                                                             HttpServletRequest httpServletRequest) {
        return genresService.findAll(page, size, sortKey, sortOrder, httpServletRequest);
    }

    @GetMapping(PathConstant.SEARCH_GENRES)
    public IResultDTO<List<ResponseGenresDTO>> searchGenres(@RequestParam("keyword") String keyword, HttpServletRequest httpServletRequest) {
        return genresService.searchGenres(keyword, httpServletRequest);
    }

}
