package id.sjp.movie.api.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMovieDTO {

    private static final long serialVersionUID = 205379892175682977L;

    @NotNull
    private String title;

    @NotNull
    private Integer year;

    @NotNull
    private float duration;

    @NotNull
    private String language;

    @NotNull
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotNull
    private String urlImagePoster;

    @NotNull
    private String urlTrialMovie;

    @NotNull
    private String urlFullMovie;

    @NotNull
    private String country;

}
