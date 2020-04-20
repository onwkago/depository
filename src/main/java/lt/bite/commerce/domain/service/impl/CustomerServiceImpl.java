package lt.bite.commerce.domain.service.impl;

import lt.bite.commerce.controller.orders.OrderController;

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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  OrderedServiceRepository orderedServiceRepository;

  @Autowired
  MsisdnRepository msisdnRepository;

  private ModelMapper mapper = new ModelMapper();

  @Override
  public ResponseEntity<CustomerDto> getCustomerById(final CustomerDto customer) {
    CustomerDto cust = mapper.map(customerRepository.findById(customer.getId()).get(),CustomerDto.class);
      cust.add(linkTo(methodOn(OrderController.class).getCustomer(customer)).withSelfRel());

    return new ResponseEntity<>(cust, HttpStatus.OK);
  }




//  public ResponseEntity<OrderedServiceDto> cancelOrder(final AccountDto account) {
//
//    return new ResponseEntity<>(account,HttpStatus.ACCEPTED);
//  }




}
