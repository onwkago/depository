package lt.bite.commerce.domain.service;

import lt.bite.commerce.domain.model.AccountDto;
import lt.bite.commerce.domain.model.OrderedServiceDto;
import lt.bite.commerce.repository.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {

  ResponseEntity<AccountDto> getAccountById(final Long accountId);

  ResponseEntity<?> updateAccount(final AccountDto accountToUpdate);

  ResponseEntity<?> removeAccount(final AccountDto accountToRemove);

  ResponseEntity<List<AccountDto>> getCustomerAccounts(final Long customerId);
}
