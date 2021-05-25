package id.sjp.movie.api.utils.dto.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import id.sjp.movie.api.utils.dto.IResultDTO;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Setter
public class BaseResultDTO<T, U extends AResponseDTO> implements Serializable, IResultDTO {

    private static final long serialVersionUID = 5514730731941830112L;

    @JsonProperty("result")
    private T result;

    @JsonProperty("responseData")
    private U responseData;

    @JsonProperty("metaData")
    private Map<String, String> metaData;

    @Override
    public T getResult() {
        return result;
    }

    @Override
    public U getResponseData() {
        return responseData;
    }

    @Override
    public Map<String, String> getMetaData() {
        if (Objects.nonNull(metaData)) return metaData;
        return null;
    }

}
