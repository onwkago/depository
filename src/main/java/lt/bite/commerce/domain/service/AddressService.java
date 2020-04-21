package lt.bite.commerce.domain.service;

import lt.bite.commerce.domain.model.AddressDto;
import lt.bite.commerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

  ResponseEntity<?> additionalAddress(final AddressDto newAddress);

  ResponseEntity<?> removeAddress(final AddressDto addressToRemove);

  ResponseEntity<?> changeAddress(final AddressDto addressToChange);

  ResponseEntity<?> getAddressById(final Long id);
}
