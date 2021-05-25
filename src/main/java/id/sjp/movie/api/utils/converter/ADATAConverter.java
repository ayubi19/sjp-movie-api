package id.sjp.movie.api.utils.converter;

import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public abstract class ADATAConverter<SOURCE, TARGET> implements IDATAConverter<SOURCE, TARGET> {
    @Getter
    private boolean isBatch = false;

    protected void prepareData(List<SOURCE> sources) {
    }

    @Override
    public List<TARGET> mapEntitiesIntoDTOs(Iterable<SOURCE> entities) {
        List<SOURCE> sources = new ArrayList<>();
        entities.forEach(sources::add);
        prepareData(sources);
        this.isBatch = true;
        List<TARGET> listTarget = new ArrayList<>();
        for (SOURCE source : entities) {
            listTarget.add(convert(source));
        }
        this.isBatch = false;
        return listTarget;
    }

    @Override
    public Page<TARGET> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<SOURCE> source) {
        List<TARGET> targetList = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(targetList, pageRequest, source.getTotalElements());
    }

    @Override
    public SOURCE convertReverse(TARGET p_TARGET) {
        return null;
    }

    @Override
    public ConvertResponseEntityDTO convertWithResponseEntity(SOURCE source) {
        return null;
    }

    @Override
    public TARGET convert(SOURCE source) {
        return null;
    }
}
