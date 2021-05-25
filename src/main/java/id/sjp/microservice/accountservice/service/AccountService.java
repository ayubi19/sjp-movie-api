package id.sjp.microservice.accountservice.service;

import id.sjp.microservice.accountservice.dto.request.RequestRegisterCheckDTO;
import org.springframework.http.ResponseEntity;

public interface AccountService {

    public ResponseEntity<?> registerCheck(RequestRegisterCheckDTO request);


}
