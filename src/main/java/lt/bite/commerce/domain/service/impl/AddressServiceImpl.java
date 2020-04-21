package lt.bite.commerce.domain.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import lt.bite.commerce.controller.orders.AddressController;
import lt.bite.commerce.domain.model.AddressDto;
import lt.bite.commerce.domain.service.AddressService;
import lt.bite.commerce.repository.AddressRepository;
import lt.bite.commerce.repository.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static lt.bite.commerce.util.Constants.ADDRESS_TYPE_PRIMARY;
import static lt.bite.commerce.util.Constants.ADDRESS_TYPE_SECONDARY;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  AddressRepository addressRepository;

  private final ModelMapper mapper = new ModelMapper();

  @Override
  public ResponseEntity<AddressDto> additionalAddress(final AddressDto newAddress) {
    newAddress.setAddressType(ADDRESS_TYPE_SECONDARY);
    Address address = mapper.map(newAddress, Address.class);

    AddressDto addedAddress = mapper.map(addressRepository.save(address),AddressDto.class);
    addedAddress.add(linkTo(methodOn(AddressController.class)
            .getAddress(addedAddress.getId())).withSelfRel());

    return new ResponseEntity<>(addedAddress, HttpStatus.CREATED);
  }

  public ResponseEntity<?> removeAddress(final AddressDto addressToRemove) {
    if (ADDRESS_TYPE_PRIMARY.equals(addressToRemove.getAddressType())) {
      throw new DataIntegrityViolationException("Primary address cannot be removed");
    }
    Address address = mapper.map(addressToRemove, Address.class);
    addressRepository.delete(address);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<?> changeAddress(final AddressDto addressToChange) {
    Address address = mapper.map(addressToChange, Address.class);

    AddressDto changedAddress = mapper.map(addressRepository.save(address), AddressDto.class);

    changedAddress.add(linkTo(methodOn(AddressController.class)
            .getAddress(changedAddress.getId())).withSelfRel());

    return new ResponseEntity<>(changedAddress, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<AddressDto> getAddressById(final Long id) {
    AddressDto address = mapper.map(addressRepository.findById(id).get(), AddressDto.class)
            .add(linkTo(methodOn(AddressController.class).getAddress(id)).withSelfRel());
    log.debug(address.toString());
    return new ResponseEntity<>(address, HttpStatus.OK);
  }
}
