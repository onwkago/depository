package lt.bite.commerce.domain.service;

import lt.bite.commerce.domain.model.CustomerDto;
import lt.bite.commerce.domain.model.OrderedServiceDto;
import lt.bite.commerce.repository.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {

  ResponseEntity<CustomerDto> getCustomerById(CustomerDto customer);


}
