package lt.bite.commerce.domain.service;

import lt.bite.commerce.domain.model.OrderedServiceDto;
import lt.bite.commerce.repository.entity.OrderedService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

  ResponseEntity<OrderedServiceDto> orderService(OrderedServiceDto serviceToOrder);

  ResponseEntity<OrderedServiceDto>  cancelOrderedService(OrderedServiceDto customer);

  ResponseEntity<List<OrderedServiceDto>> getActiveOrders(Long accountId);

  ResponseEntity<OrderedServiceDto> getOrder(Long orderId);
}
