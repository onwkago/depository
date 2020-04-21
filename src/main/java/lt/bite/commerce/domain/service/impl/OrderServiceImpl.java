package lt.bite.commerce.domain.service.impl;

import lt.bite.commerce.controller.orders.OrderController;
import lt.bite.commerce.domain.model.OrderedServiceDto;
import lt.bite.commerce.domain.service.OrderService;
import lt.bite.commerce.repository.CustomerRepository;
import lt.bite.commerce.repository.MsisdnRepository;
import lt.bite.commerce.repository.OrderedServiceRepository;
import lt.bite.commerce.repository.entity.Msisdn;
import lt.bite.commerce.repository.entity.OrderedService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class OrderServiceImpl implements OrderService {

  ModelMapper mapper = new ModelMapper();
  @Autowired
  MsisdnRepository msisdnRepository;

  @Autowired
  OrderedServiceRepository orderedServiceRepository;

  @Autowired
  CustomerRepository customerRepository;

  public ResponseEntity<OrderedServiceDto> orderService(final OrderedServiceDto serviceToOrder) {

    OrderedService service = mapper.map(serviceToOrder,OrderedService.class);

    orderedServiceRepository.save(service);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<OrderedServiceDto> cancelOrderedService(final OrderedServiceDto service) {
    service.setActiveTo(LocalDateTime.now());
    OrderedService serviceToCancel = mapper.map(service,OrderedService.class);
    orderedServiceRepository.save(serviceToCancel);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<List<OrderedServiceDto>> getActiveOrders(final Long msisdnId) {
    Optional<Msisdn> account = msisdnRepository.findById(msisdnId);
    List<OrderedServiceDto> activeServices = msisdnRepository.findById(msisdnId)
            .get()
            .getOrderedServices()
            .stream()
            .filter(m -> m.getActiveTo() != null)
            .filter(m -> m.getActiveTo().isBefore(LocalDateTime.now()))
            .map(m -> mapper.map(m,OrderedServiceDto.class)
                    .add(linkTo(methodOn(OrderController.class).getOrder(m.getId())).withSelfRel()))
            .collect(Collectors.toList());

    return new ResponseEntity<>(activeServices,HttpStatus.OK);
  }

  @Override
  public ResponseEntity<OrderedServiceDto> getOrder(final Long orderId) {
    OrderedServiceDto order = mapper.map(orderedServiceRepository.findById(orderId).get(),OrderedServiceDto.class);
    order.add(linkTo(methodOn(OrderController.class).getOrder(order.getId())).withSelfRel());
    return new ResponseEntity<>(order,HttpStatus.OK);
  }

}
