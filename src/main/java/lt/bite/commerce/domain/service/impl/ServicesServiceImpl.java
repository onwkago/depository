package lt.bite.commerce.domain.service.impl;

import lt.bite.commerce.controller.orders.ServicesController;
import lt.bite.commerce.domain.model.ServiceDto;
import lt.bite.commerce.domain.service.ServicesService;
import lt.bite.commerce.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static lt.bite.commerce.util.Constants.SERVICES;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ServicesServiceImpl implements ServicesService {

  @Autowired
  ServiceRepository servicesRepository;

  private ModelMapper mapper = new ModelMapper();

  @Override
  public ResponseEntity<ServiceDto> getServiceById(Long id) {
    ServiceDto service = mapper.map(servicesRepository.findById(id).get(), ServiceDto.class);
    service.add(linkTo(methodOn(ServicesController.class).getService(id)).withSelfRel());
    return new ResponseEntity<>(service, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<ServiceDto>> getAllServices() {
    List<ServiceDto> services = StreamSupport.stream(servicesRepository.findAll().spliterator(), false)
            .map(a -> mapper.map(a, ServiceDto.class)
                    .add(linkTo(methodOn(ServicesController.class).getService(a.getId())).withRel(SERVICES)))
            .collect(Collectors.toList());

    return new ResponseEntity<>(services, HttpStatus.OK);
  }


}
