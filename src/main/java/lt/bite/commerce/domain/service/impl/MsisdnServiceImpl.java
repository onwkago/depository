package lt.bite.commerce.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import lt.bite.commerce.controller.orders.MsisdnController;
import lt.bite.commerce.controller.orders.OrderController;
import lt.bite.commerce.domain.model.MsisdnDto;
import lt.bite.commerce.domain.service.MsisdnService;
import lt.bite.commerce.repository.MsisdnRepository;
import lt.bite.commerce.repository.entity.Msisdn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static lt.bite.commerce.util.Constants.ORDERED_SERVICES;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Slf4j
@Service
public class MsisdnServiceImpl implements MsisdnService {

  @Autowired
  MsisdnRepository msisdnRepository;

  private ModelMapper mapper = new ModelMapper();

  @Override
  public ResponseEntity<MsisdnDto> getPhoneNo(Long id) {
    MsisdnDto msisdn = mapper.map(msisdnRepository.findById(id).get(),MsisdnDto.class);
    msisdn.add(linkTo(methodOn(MsisdnController.class).getPhoneNo(id)).withSelfRel());

    msisdn.add(msisdn.getOrderedServices()
               .stream()
               .map(s -> linkTo(methodOn(OrderController.class).getOrder(s.getId())).withRel(ORDERED_SERVICES))
               .collect(Collectors.toList())
    );

    return new ResponseEntity<>(msisdn, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> changePhoneNo(MsisdnDto phoneToChange) {
    Msisdn phone = mapper.map(phoneToChange,Msisdn.class);
    msisdnRepository.save(phone);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<?> additionalPhoneNo(MsisdnDto phoneToAdd) {
    Msisdn phone = mapper.map(phoneToAdd,Msisdn.class);
    msisdnRepository.save(phone);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<?> removePhoneNo(MsisdnDto phoneToRemove) {
    Msisdn phone = mapper.map(phoneToRemove,Msisdn.class);
    msisdnRepository.delete(phone);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


}
