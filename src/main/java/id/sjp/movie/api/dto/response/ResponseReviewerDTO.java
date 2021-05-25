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
public class ResponseReviewerDTO implements Serializable {

    private static final long serialVersionUID = 3340162951362696715L;

    private Long reviewerId;
    private String name;
    private Integer age;
}
