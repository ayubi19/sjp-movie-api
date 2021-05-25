package id.sjp.movie.api.utils.dto;

import id.sjp.movie.api.utils.dto.impl.AResponseDTO;

import java.util.Map;

public interface IResultDTO<T> {
    T getResult();

    AResponseDTO getResponseData();

    Map<String, String> getMetaData();
}
