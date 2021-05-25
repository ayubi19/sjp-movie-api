package id.sjp.movie.api.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestGenresDTO {

    private static final long serialVersionUID = 1236668519519580441L;

    @NotNull
    private String genres;

    @NotNull
    private String description;

}
