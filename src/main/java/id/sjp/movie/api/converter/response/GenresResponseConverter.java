package id.sjp.movie.api.converter.response;

import id.sjp.movie.api.dto.response.ResponseGenresDTO;
import id.sjp.movie.api.entity.Genres;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;


@Component
public class GenresResponseConverter extends ADATAConverter<Genres, ResponseGenresDTO> {

    @Override
    public ResponseGenresDTO convert(Genres genres) {
        return ResponseGenresDTO.builder()
                .genresId(genres.getId())
                .genre(genres.getGenre())
                .description(genres.getDescription())
                .build();
    }
}
