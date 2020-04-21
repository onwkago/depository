package lt.bite.commerce.domain.service;

import lt.bite.commerce.domain.model.OrderedServiceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

  ResponseEntity<OrderedServiceDto> orderService(final OrderedServiceDto serviceToOrder);

  ResponseEntity<OrderedServiceDto> cancelOrderedService(final OrderedServiceDto customer);

  ResponseEntity<List<OrderedServiceDto>> getActiveOrders(final Long accountId);

  ResponseEntity<OrderedServiceDto> getOrder(final Long orderId);
}
