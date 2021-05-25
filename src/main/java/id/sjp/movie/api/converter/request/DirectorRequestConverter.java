package id.sjp.movie.api.converter.request;

import id.sjp.movie.api.dto.request.RequestDirectorDTO;
import id.sjp.movie.api.entity.Director;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;

@Component
public class DirectorRequestConverter extends ADATAConverter<RequestDirectorDTO, Director> {

    public Director convert(RequestDirectorDTO requestDirectorDTO) {
        Director director = new Director();
        director.setFirstName(requestDirectorDTO.getFirstName());
        director.setLastName(requestDirectorDTO.getLastName());
        director.setFullName(requestDirectorDTO.getFirstName() + " " + requestDirectorDTO.getLastName());
        director.setGender(requestDirectorDTO.getGender().getName().charAt(0));
        return director;
    }
}