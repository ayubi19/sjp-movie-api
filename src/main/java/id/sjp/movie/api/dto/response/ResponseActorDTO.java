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
public class ResponseActorDTO implements Serializable {

    private static final long serialVersionUID = -2826803698498675477L;

    private Long actorId;
    private String firstName;
    private String lastName;
    private String fullName;
    private Character gender;
}
