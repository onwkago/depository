package lt.bite.commerce.domain.service.impl;

import lt.bite.commerce.controller.orders.AccountController;
import lt.bite.commerce.controller.orders.AddressController;
import lt.bite.commerce.controller.orders.MsisdnController;
import lt.bite.commerce.domain.model.AccountDto;
import lt.bite.commerce.domain.service.AccountService;
import lt.bite.commerce.repository.AccountRepository;
import lt.bite.commerce.repository.CustomerRepository;
import lt.bite.commerce.repository.entity.Account;
import lt.bite.commerce.repository.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static lt.bite.commerce.util.Constants.ACCOUNTS;
import static lt.bite.commerce.util.Constants.ADDRESSES;
import static lt.bite.commerce.util.Constants.MSISDNS;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  CustomerRepository customerRepository;

  ModelMapper mapper = new ModelMapper();

  @Override
  public ResponseEntity<AccountDto> getAccountById(final Long accountId) {
    AccountDto account = mapper.map(accountRepository.findById(accountId).get(), AccountDto.class);

    account.add(linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel());
    account.add(account.getAddresses()
            .stream()
            .map(a -> linkTo(methodOn(AddressController.class).getAddress(a.getId())).withRel(ADDRESSES))
            .collect(Collectors.toList())
    );
    account.add(account.getMsisdnList()
            .stream()
            .map(m -> linkTo(methodOn(MsisdnController.class).getPhoneNo(m.getId())).withRel(MSISDNS))
            .collect(Collectors.toList())
    );
    return new ResponseEntity<>(account, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> updateAccount(final AccountDto accountToUpdate) {
    accountRepository.save(mapper.map(accountToUpdate, Account.class));
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<?> removeAccount(final AccountDto accountToRemove) {
    accountRepository.delete(mapper.map(accountToRemove, Account.class));
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  public ResponseEntity<List<AccountDto>> getCustomerAccounts(final Long customerId) {
    Optional<Customer> customer = customerRepository.findById(customerId);
    List<AccountDto> accounts = customer
            .get()
            .getAccounts()
            .stream()
            .map(a -> mapper.map(a, AccountDto.class)
                    .add(linkTo(methodOn(AccountController.class).getAccount(a.getId())).withRel(ACCOUNTS)))
            .collect(Collectors.toList());

    return new ResponseEntity<>(accounts, HttpStatus.OK);
  }
}
