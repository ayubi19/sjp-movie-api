package id.sjp.movie.api.service.impl;


import id.sjp.movie.api.converter.request.ActorRequestConverter;
import id.sjp.movie.api.converter.response.ActorResponseConverter;
import id.sjp.movie.api.dto.request.RequestActorDTO;
import id.sjp.movie.api.dto.response.ResponseActorDTO;
import id.sjp.movie.api.entity.Actor;
import id.sjp.movie.api.repository.ActorRepository;
import id.sjp.movie.api.service.ActorService;
import id.sjp.movie.api.staticvalues.CommonConstant;
import id.sjp.movie.api.utils.dto.IResultDTO;
import id.sjp.movie.api.utils.dto.impl.APIResponseBuilder;
import id.sjp.movie.api.utils.exception.NoContentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final ActorRequestConverter actorRequestConverter;
    private final ActorResponseConverter actorResponseConverter;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> create(RequestActorDTO requestActorDTO, HttpServletRequest httpServletRequest) {
        try {
            saveActor(actorRequestConverter.convert(requestActorDTO));
            return APIResponseBuilder.ok("Actor successfully created");
        } catch (ServiceException e) {
            log.error("Error Service Exception" + e);
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private void saveActor(Actor actor) {
        actorRepository.save(actor);
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public IResultDTO<String> update(Long id, RequestActorDTO requestActorDTO, HttpServletRequest httpServletRequest) {
        try {
            Actor actor = findByid(id);
            actor.setFirstName(requestActorDTO.getFirstName());
            actor.setLastName(requestActorDTO.getLastName());
            actor.setFullName(requestActorDTO.getFirstName() + " " + requestActorDTO.getLastName());
            actor.setGender(requestActorDTO.getGender().getName().charAt(0));
            saveActor(actor);
            return APIResponseBuilder.ok(String.format("Actor successfully updated with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        }
    }

    private Actor findByid(Long id) throws NoContentException {
        Optional<Actor> actor = actorRepository.findById(id);

        if (!actor.isPresent()) {
            throw new NoContentException(String.format("Actor not found with id %d", id));
        }

        return actor.get();
    }

    @Override
    public IResultDTO<String> delete(Long id, HttpServletRequest httpServletRequest) {
        try {
            Actor actor = findByid(id);
            actor.setDeleted(true);
            saveActor(actor);
            return APIResponseBuilder.ok(String.format("Actor successfully deleted with id %d", id));
        } catch (ServiceException e) {
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(null, e, e.getMessage(), httpServletRequest);
        } catch (NoContentException e) {
            return APIResponseBuilder.noContent(e.getMessage());
        }
    }

    @Override
    public IResultDTO<List<ResponseActorDTO>> findAll(int page, int size, String sortKey, String sortOrder, HttpServletRequest httpServletRequest) {
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<Actor> response = actorRepository.findAll(pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(actorResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error get list actor", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }

    @Override
    public IResultDTO<List<ResponseActorDTO>> searchActor(String keyword, HttpServletRequest httpServletRequest) {
        int page = 1;
        int size = 20;
        String sortKey = CommonConstant.DEFAULT_SORT_KEY;
        String sortOrder = CommonConstant.DEFAULT_SORT_ORDER;
        try {
            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortKey));
            Page<Actor> response = actorRepository.findAllByKeyword(keyword.toLowerCase(), pageable);

            if (response.getSize() == 0) {
                return APIResponseBuilder.noContent(new ArrayList<>());
            }

            return APIResponseBuilder.ok(actorResponseConverter.mapEntityPageIntoDTOPage(pageable, response));
        } catch (ServiceException e) {
            log.error("Error search actor with keyword", e);
            return APIResponseBuilder.internalServerError(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        } catch (HttpClientErrorException e) {
            return APIResponseBuilder.badRequest(new ArrayList<>(), e, e.getMessage(), httpServletRequest);
        }
    }
}
