package lt.bite.commerce.domain.service.impl;

import lt.bite.commerce.domain.model.AccountDto;
import lt.bite.commerce.domain.model.OrderedServiceDto;
import lt.bite.commerce.domain.service.AccountService;
import lt.bite.commerce.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AccountServiceImpl implements AccountService {

  @Autowired
  AccountRepository accountRepository;

  ModelMapper mapper = new ModelMapper();
  @Override
  public ResponseEntity<AccountDto> getAccountById(Long accountId) {
    return null;
  }
}
