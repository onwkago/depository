package lt.bite.commerce.domain.service;

import lt.bite.commerce.controller.orders.OrderController;
import lt.bite.commerce.domain.model.CustomerDto;
import lt.bite.commerce.repository.CustomerRepository;
import lt.bite.commerce.repository.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CustomerServiceImpl implements CustomerService{

  @Autowired
  CustomerRepository customerRepository;

  public ResponseEntity<CustomerDto> getCustomerById(final Long id) {
    CustomerDto cust = new CustomerDto(customerRepository.findById(id).get());
    cust.add(linkTo(methodOn(OrderController.class).getCustomer(id)).withSelfRel());
    return new ResponseEntity<>(cust, HttpStatus.OK);
  }




}
