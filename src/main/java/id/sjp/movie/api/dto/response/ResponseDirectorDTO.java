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
public class ResponseDirectorDTO implements Serializable {

    private static final long serialVersionUID = 5263524141573410339L;

    private Long directorId;
    private String firstName;
    private String lastName;
    private String fullName;
    private Character gender;
}
