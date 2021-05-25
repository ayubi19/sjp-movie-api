package id.sjp.movie.api.controller;

import id.sjp.movie.api.dto.request.RequestActorDTO;
import id.sjp.movie.api.dto.response.ResponseActorDTO;
import id.sjp.movie.api.service.ActorService;
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
@RequestMapping(value = ContextPathConstant.VERSION_V1 + ContextPathConstant.ACTOR)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class ActorController {

    private final ActorService actorService;

    @PostMapping(PathConstant.CREATE)
    public IResultDTO<String> createActor(@RequestBody RequestActorDTO requestActorDTO, HttpServletRequest httpServletRequest) {
        return actorService.create(requestActorDTO, httpServletRequest);
    }

    @PutMapping(PathConstant.UPDATE)
    public IResultDTO<String> updateActor(@PathVariable Long id, @RequestBody RequestActorDTO requestActorDTO, HttpServletRequest httpServletRequest) {
        return actorService.update(id, requestActorDTO, httpServletRequest);
    }

    @DeleteMapping(PathConstant.DELETE)
    public IResultDTO<String> deleteActor(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        return actorService.delete(id, httpServletRequest);
    }

    @GetMapping(PathConstant.ACTOR_LIST)
    public IResultDTO<List<ResponseActorDTO>> findAllActor(@PathVariable(name = "page") int page,
                                                           @PathVariable(name = "size") int size,
                                                           @RequestParam(name = "sort", defaultValue = CommonConstant.DEFAULT_SORT_KEY) String sortKey,
                                                           @RequestParam(name = "sort-order", defaultValue = CommonConstant.DEFAULT_SORT_ORDER) String sortOrder,
                                                           HttpServletRequest httpServletRequest) {
        return actorService.findAll(page, size, sortKey, sortOrder, httpServletRequest);
    }

    @GetMapping(PathConstant.SEARCH_ACTOR)
    public IResultDTO<List<ResponseActorDTO>> searchActor(@RequestParam("keyword") String keyword, HttpServletRequest httpServletRequest) {
        return actorService.searchActor(keyword, httpServletRequest);
    }

}
