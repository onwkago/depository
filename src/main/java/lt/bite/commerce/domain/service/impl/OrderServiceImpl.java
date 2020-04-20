package lt.bite.commerce.domain.service.impl;

import lt.bite.commerce.domain.model.OrderedServiceDto;
import lt.bite.commerce.domain.service.AccountService;
import lt.bite.commerce.domain.service.OrderService;
import lt.bite.commerce.repository.AccountRepository;
import lt.bite.commerce.repository.CustomerRepository;
import lt.bite.commerce.repository.MsisdnRepository;
import lt.bite.commerce.repository.OrderedServiceRepository;
import lt.bite.commerce.repository.entity.Account;
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

@Service
public class OrderServiceImpl implements OrderService {

  ModelMapper mapper = new ModelMapper();
  @Autowired
  MsisdnRepository msisdnRepository;

  @Autowired
  OrderedServiceRepository orderedServiceRepository;

  @Autowired
  CustomerRepository customerRepository;

  public ResponseEntity<OrderedServiceDto> orderService(OrderedServiceDto serviceToOrder) {

    OrderedService service = mapper.map(serviceToOrder,OrderedService.class);

    orderedServiceRepository.save(service);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<OrderedServiceDto> cancelOrderedService(OrderedServiceDto service) {
    service.setActiveTo(LocalDateTime.now());
    OrderedService serviceToCancel = mapper.map(service,OrderedService.class);
    orderedServiceRepository.save(serviceToCancel);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<List<OrderedServiceDto>> getActiveOrders(Long msisdnId) {
    Optional<Msisdn> account = msisdnRepository.findById(msisdnId);
    List<OrderedServiceDto> activeServices = msisdnRepository.findById(msisdnId)
            .get()
            .getOrderedServices()
            .stream()
            .filter(m -> m.getActiveTo() != null)
            .filter(m -> m.getActiveTo().isBefore(LocalDateTime.now()))
            .map(m -> mapper.map(m,OrderedServiceDto.class))
            .collect(Collectors.toList());

    return new ResponseEntity<>(activeServices,HttpStatus.OK);
  }
}
