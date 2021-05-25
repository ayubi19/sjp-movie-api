package id.sjp.movie.api.converter.response;

import id.sjp.movie.api.dto.response.ResponseReviewerDTO;
import id.sjp.movie.api.entity.Reviewer;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;


@Component
public class ReviewerResponseConverter extends ADATAConverter<Reviewer, ResponseReviewerDTO> {

    @Override
    public ResponseReviewerDTO convert(Reviewer reviewer) {
        return ResponseReviewerDTO.builder()
                .reviewerId(reviewer.getId())
                .name(reviewer.getName())
                .age(reviewer.getAge())
                .build();
    }
}
