package id.sjp.movie.api.utils.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDATAConverter<SOURCE, TARGET> extends Converter<SOURCE, TARGET> {
    List<TARGET> mapEntitiesIntoDTOs(Iterable<SOURCE> entities);

    Page<TARGET> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<SOURCE> source);

    SOURCE convertReverse(TARGET p_TARGET);

    ConvertResponseEntityDTO convertWithResponseEntity(SOURCE source);
}
