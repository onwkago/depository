package lt.bite.commerce.controller.orders;

import lt.bite.commerce.controller.ApiUrls;
import lt.bite.commerce.domain.model.CustomerDto;
import lt.bite.commerce.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(produces = "application/json")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @PostMapping(path = Urls.GET_CUSTOMER, consumes = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<CustomerDto> getCustomer(@Valid @RequestBody CustomerDto customer) {
    return customerService.getCustomerById(customer);
  }

  public final static class Urls {
    private final static String ROOT_URL = ApiUrls.API_URL + "/customer";
    private final static String GET_CUSTOMER = ROOT_URL + "/getcustomer";

  }
}
