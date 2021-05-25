package id.sjp.movie.api.utils.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public abstract class AResponseDTO {

    private Integer responseCode;
    private String responseMsg;

    public void setResponseCode(Integer value) {
        this.responseCode = value;
    }

    public void setResponseCode(HttpStatus value) {
        this.responseCode = value.value();
    }

    public void setResponseCode(String value) {
        this.responseCode = Integer.valueOf(value);
    }

    public boolean equals(HttpStatus o) {
        return responseCode.equals(o.value());
    }

}
