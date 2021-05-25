package id.sjp.microservice.accountservice.service.impl;

import id.sjp.microservice.accountservice.dto.request.RequestRegisterCheckDTO;
import id.sjp.microservice.accountservice.entity.database.Account;
import id.sjp.microservice.accountservice.entity.redis.TempAccount;
import id.sjp.microservice.accountservice.repository.database.AccountRepository;
import id.sjp.microservice.accountservice.repository.redis.TempAccountRepository;
import id.sjp.microservice.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TempAccountRepository tempAccountRepository;

    @Override
    public ResponseEntity<?> registerCheck(RequestRegisterCheckDTO request) {
        //check data postgres
        Account accountDb = accountRepository.findByEmail(request.getEmail());
        if(accountDb != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        //chcek data redis
        TempAccount accountRedis = tempAccountRepository.findByEmail(request.getEmail());
        if(accountRedis != null) {
            return ResponseEntity.ok().build();
        }

        //save temp redis
        accountRedis = new TempAccount();
        accountRedis.setEmail(request.getEmail());
        accountRedis.setValid(false);
        tempAccountRepository.save(accountRedis);

        //request otp
        /*try {
            otpClient.requestOTP(request);
        }catch (FeignException.FeignClientException e){
            return ResponseEntity.status(e.status()).body(e.contentUTF8());
        }*/

        return ResponseEntity.ok().build();
    }

}
