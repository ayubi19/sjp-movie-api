package id.sjp.movie.api.utils.dto.impl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDTO<T> extends BaseResultDTO<T, ResponseData> {
    private static final long serialVersionUID = -8423091997058090048L;
}
