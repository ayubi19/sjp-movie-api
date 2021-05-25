package id.sjp.microservice.accountservice.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@RequiredArgsConstructor
public class RequestRegisterCheckDTO {
    private String email;
}
