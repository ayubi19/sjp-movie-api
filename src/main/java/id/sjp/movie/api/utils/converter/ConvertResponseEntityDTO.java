package id.sjp.movie.api.utils.converter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;


@Getter
@Setter
public class ConvertResponseEntityDTO<TARGET> {

    private TARGET target;
    private ResponseEntity responseEntity;
}
