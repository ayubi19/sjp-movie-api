package id.sjp.movie.api.dto.response;

import lombok.*;

import java.io.Serializable;

@ToString
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGenresDTO implements Serializable {

    private static final long serialVersionUID = 3585894367245870145L;

    private Long genresId;
    private String genre;
    private String description;
}
