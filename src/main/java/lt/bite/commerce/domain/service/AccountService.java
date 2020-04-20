package lt.bite.commerce.domain.service;

import lt.bite.commerce.domain.model.AccountDto;
import lt.bite.commerce.domain.model.OrderedServiceDto;
import lt.bite.commerce.repository.entity.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {

  ResponseEntity<AccountDto> getAccountById(Long accountId);

}
