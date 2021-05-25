package id.sjp.movie.api.converter.request;

import id.sjp.movie.api.dto.request.RequestReviewerDTO;
import id.sjp.movie.api.entity.Reviewer;
import id.sjp.movie.api.utils.converter.ADATAConverter;
import org.springframework.stereotype.Component;

@Component
public class ReviewerRequestConverter extends ADATAConverter<RequestReviewerDTO, Reviewer> {

    public Reviewer convert(RequestReviewerDTO requestReviewerDTO) {
        Reviewer reviewer = new Reviewer();
        reviewer.setName(requestReviewerDTO.getName());
        reviewer.setAge(requestReviewerDTO.getAge());
        return reviewer;
    }
}