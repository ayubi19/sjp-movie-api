package id.sjp.movie.api.converter.request;

import id.sjp.movie.api.dto.request.RequestGenresDTO;
import id.sjp.movie.api.entity.Genres;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;

@Component
public class GenresRequestConverter extends ADATAConverter<RequestGenresDTO, Genres> {

    public Genres convert(RequestGenresDTO requestGenresDTO) {
        Genres genres = new Genres();
        genres.setGenre(requestGenresDTO.getGenres());
        genres.setDescription(requestGenresDTO.getDescription());
        return genres;
    }
}