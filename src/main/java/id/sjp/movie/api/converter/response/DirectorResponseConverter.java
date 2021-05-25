package id.sjp.movie.api.converter.response;

import id.sjp.movie.api.dto.response.ResponseDirectorDTO;
import id.sjp.movie.api.entity.Director;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;


@Component
public class DirectorResponseConverter extends ADATAConverter<Director, ResponseDirectorDTO> {

    @Override
    public ResponseDirectorDTO convert(Director director) {
        return ResponseDirectorDTO.builder()
                .directorId(director.getId())
                .firstName(director.getFirstName())
                .lastName(director.getLastName())
                .fullName(director.getFullName())
                .gender(director.getGender())
                .build();
    }
}
