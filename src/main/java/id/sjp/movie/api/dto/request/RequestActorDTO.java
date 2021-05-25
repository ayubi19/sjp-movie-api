package id.sjp.movie.api.dto.request;

import com.sun.istack.NotNull;
import id.sjp.movie.api.staticvalues.enumeration.EGenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestActorDTO {

    private static final long serialVersionUID = 5651341504199998340L;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private EGenderType gender;

}
