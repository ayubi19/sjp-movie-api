package id.sjp.movie.api.utils.dto.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ResponseData extends AResponseDTO implements Serializable {

    private static final long serialVersionUID = 680478871835271507L;

    public ResponseData(String responseCode, String responseMessage) {
        this.setResponseCode(Integer.parseInt(responseCode));
        this.setResponseMsg(responseMessage);
    }

    public ResponseData(int responseCode, String responseMessage) {
        this.setResponseCode(responseCode);
        this.setResponseMsg(responseMessage);
    }
}
