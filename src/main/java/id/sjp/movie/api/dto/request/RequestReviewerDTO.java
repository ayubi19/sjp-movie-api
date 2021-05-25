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
public class RequestReviewerDTO {

    private static final long serialVersionUID = -1874357718486686071L;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

}
