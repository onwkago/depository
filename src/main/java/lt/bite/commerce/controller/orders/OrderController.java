package lt.bite.commerce.controller.orders;

import lt.bite.commerce.controller.ApiUrls;
import lt.bite.commerce.domain.model.CustomerDto;
import lt.bite.commerce.domain.model.OrderedServiceDto;
import lt.bite.commerce.domain.service.CustomerService;
import lt.bite.commerce.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(produces= "application/json")
public class OrderController {

  @Autowired
  CustomerService customerService;

  @Autowired
  OrderService orderService;


  @PostMapping(path =Urls.GET_CUSTOMER,consumes = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<CustomerDto> getCustomer(@Valid @RequestBody CustomerDto customer) {
    return customerService.getCustomerById(customer);
  }

  @PutMapping(path = Urls.CANCEL_ORDER, consumes = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<OrderedServiceDto> cancelOrder(@Valid @RequestBody OrderedServiceDto orderedService ) {
    return orderService.cancelOrderedService(orderedService);
  }

  @PostMapping(path = Urls.NEW_ORDER, consumes = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<OrderedServiceDto> createOrder(@Valid @RequestBody OrderedServiceDto serviceToOrder) {
    return orderService.orderService(serviceToOrder);
  }

  @GetMapping(path= Urls.GET_ACTIVE_ORDERS)
  public HttpEntity<List<OrderedServiceDto>> getActiveOrders(@RequestParam(name="accountId") Long accountId) {
    return orderService.getActiveOrders(accountId);
  }

  @GetMapping(path= Urls.GET_ORDER)
  public HttpEntity<OrderedServiceDto> getOrder(@RequestParam(name="orderId") Long orderId) {
    return orderService.getOrder(orderId);
  }


  public final static class Urls{
    private final static String ROOT_URL = ApiUrls.API_URL + "/service";
    private final static String GET_ORDER = ROOT_URL + "/order";
    private final static String GET_ACTIVE_ORDERS = ROOT_URL + "/activeOrders";
    private final static String GET_CUSTOMER = ROOT_URL + "/getcustomer";
    private final static String CANCEL_ORDER = ROOT_URL + "/cancelorder";
    private final static String NEW_ORDER = ROOT_URL + "/neworder";
  }
}
