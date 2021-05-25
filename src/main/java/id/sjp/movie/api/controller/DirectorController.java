package id.sjp.movie.api.controller;

import id.sjp.movie.api.dto.request.RequestDirectorDTO;
import id.sjp.movie.api.dto.response.ResponseDirectorDTO;
import id.sjp.movie.api.service.DirectorService;
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
@RequestMapping(value = ContextPathConstant.VERSION_V1 + ContextPathConstant.DIRECTOR)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class DirectorController {

    private final DirectorService directorService;

    @PostMapping(PathConstant.CREATE)
    public IResultDTO<String> createDirector(@RequestBody RequestDirectorDTO requestDirectorDTO, HttpServletRequest httpServletRequest) {
        return directorService.create(requestDirectorDTO, httpServletRequest);
    }

    @PutMapping(PathConstant.UPDATE)
    public IResultDTO<String> updateDirector(@PathVariable Long id, @RequestBody RequestDirectorDTO requestDirectorDTO, HttpServletRequest httpServletRequest) {
        return directorService.update(id, requestDirectorDTO, httpServletRequest);
    }

    @DeleteMapping(PathConstant.DELETE)
    public IResultDTO<String> deleteDirector(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return directorService.delete(id, httpServletRequest);
    }

    @GetMapping(PathConstant.DIRECTOR_LIST)
    public IResultDTO<List<ResponseDirectorDTO>> findAllDirector(@PathVariable(name = "page") int page,
                                                                 @PathVariable(name = "size") int size,
                                                                 @RequestParam(name = "sort", defaultValue = CommonConstant.DEFAULT_SORT_KEY) String sortKey,
                                                                 @RequestParam(name = "sort-order", defaultValue = CommonConstant.DEFAULT_SORT_ORDER) String sortOrder,
                                                                 HttpServletRequest httpServletRequest) {
        return directorService.findAll(page, size, sortKey, sortOrder, httpServletRequest);
    }

    @GetMapping(PathConstant.SEARCH_DIRECTOR)
    public IResultDTO<List<ResponseDirectorDTO>> searchDirector(@RequestParam("keyword") String keyword, HttpServletRequest httpServletRequest) {
        return directorService.searchDirector(keyword, httpServletRequest);
    }

}
