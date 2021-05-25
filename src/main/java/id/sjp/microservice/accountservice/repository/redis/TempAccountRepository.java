package id.sjp.microservice.accountservice.repository.redis;

import id.sjp.microservice.accountservice.entity.redis.TempAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempAccountRepository extends CrudRepository<TempAccount, String> {

    TempAccount findByEmail(String email);

}
