package lt.bite.commerce.domain.service;

import lt.bite.commerce.domain.model.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

  ResponseEntity<CustomerDto> getCustomerById(final CustomerDto customer);
}
