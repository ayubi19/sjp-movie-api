package id.sjp.movie.api.converter.response;

import id.sjp.movie.api.dto.response.ResponseActorDTO;
import id.sjp.movie.api.entity.Actor;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;


@Component
public class ActorResponseConverter extends ADATAConverter<Actor, ResponseActorDTO> {

    @Override
    public ResponseActorDTO convert(Actor actor) {
        return ResponseActorDTO.builder()
                .actorId(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .fullName(actor.getFullName())
                .gender(actor.getGender())
                .build();
    }
}
