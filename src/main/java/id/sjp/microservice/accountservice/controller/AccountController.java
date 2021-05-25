package id.sjp.microservice.accountservice.controller;

import id.sjp.microservice.accountservice.dto.request.RequestRegisterCheckDTO;
import id.sjp.microservice.accountservice.service.AccountService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
///@RequestMapping("/account-service/api")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/check")
    public ResponseEntity<?> registerCheck(@NonNull @RequestBody RequestRegisterCheckDTO request){
        //log.debug("masuk controller check dengan parameter {}", request);
        return accountService.registerCheck(request);
    }
}
