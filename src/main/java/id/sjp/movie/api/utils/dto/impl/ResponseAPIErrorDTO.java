package id.sjp.movie.api.utils.dto.impl;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPIErrorDTO extends AResponseDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6545785544859722772L;
    private Date timestamp;

    @Deprecated
    private HttpStatus status;
    private String exception;

    @Deprecated
    private String message;
    private String path;
    private String error;

    @Override
    public Integer getResponseCode() {
        return getStatus().value();
    }

    @Override
    public String getResponseMsg() {
        return getMessage();
    }

}
