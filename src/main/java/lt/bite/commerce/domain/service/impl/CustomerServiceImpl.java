package lt.bite.commerce.domain.service.impl;

import lt.bite.commerce.controller.orders.AccountController;
import lt.bite.commerce.controller.orders.CustomerController;
import lt.bite.commerce.domain.model.CustomerDto;
import lt.bite.commerce.domain.service.CustomerService;
import lt.bite.commerce.repository.CustomerRepository;
import lt.bite.commerce.repository.MsisdnRepository;
import lt.bite.commerce.repository.OrderedServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static lt.bite.commerce.util.Constants.ACCOUNTS;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  private ModelMapper mapper = new ModelMapper();

  @Override
  public ResponseEntity<CustomerDto> getCustomerById(final CustomerDto customer) {
    CustomerDto cust = mapper.map(customerRepository.findById(customer.getId()).get(), CustomerDto.class);
    cust.add(linkTo(methodOn(CustomerController.class).getCustomer(customer)).withSelfRel());

    cust.add(cust.getAccounts()
            .stream()
            .map(a -> linkTo(methodOn(AccountController.class).getAccount(a.getId())).withRel(ACCOUNTS))
            .collect(Collectors.toList())
    );

    return new ResponseEntity<>(cust, HttpStatus.OK);
  }

}
