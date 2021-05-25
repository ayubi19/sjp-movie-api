package id.sjp.movie.api.converter.request;

import id.sjp.movie.api.dto.request.RequestActorDTO;
import id.sjp.movie.api.entity.Actor;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;

@Component
public class ActorRequestConverter extends ADATAConverter<RequestActorDTO, Actor> {

    public Actor convert(RequestActorDTO requestActorDTO) {
        Actor actor = new Actor();
        actor.setFirstName(requestActorDTO.getFirstName());
        actor.setLastName(requestActorDTO.getLastName());
        actor.setFullName(requestActorDTO.getFirstName() + " " + requestActorDTO.getLastName());
        actor.setGender(requestActorDTO.getGender().getName().charAt(0));
        return actor;
    }
}