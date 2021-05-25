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
public class RequestUserAppDTO {

    private static final long serialVersionUID = 4430073140640199468L;

    @NotNull
    private String fullName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String userAppRole;

}
