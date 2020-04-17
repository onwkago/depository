package lt.bite.commerce.controller.orders;

import lt.bite.commerce.controller.ApiUrls;
import lt.bite.commerce.domain.model.CustomerDto;
import lt.bite.commerce.domain.service.CustomerService;
import lt.bite.commerce.repository.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces= "application/json")
public class OrderController {

  @Autowired
  CustomerService customerService;

  @GetMapping(Urls.GET_CUSTOMER)
  public HttpEntity<CustomerDto> getCustomer(@RequestParam(name = "id") Long id) {
    return customerService.getCustomerById(id);
  }

  public final static class Urls{
    private final static String ROOT_URL = ApiUrls.API_URL + "/service";
    private final static String GET_CUSTOMER = ROOT_URL + "/getcustomer";
    private final static String GET_ORDERS = ROOT_URL + "/getorders";
    private final static String NEW_ORDER = ROOT_URL + "/neworder";
  }
}
