package lt.bite.commerce.domain.service;

import lt.bite.commerce.domain.model.MsisdnDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MsisdnService {

  ResponseEntity<MsisdnDto> getPhoneNo(Long id);

  ResponseEntity<?> changePhoneNo(MsisdnDto phoneToChange);

  ResponseEntity<?> additionalPhoneNo(MsisdnDto phoneToAdd);

  ResponseEntity<?> removePhoneNo(MsisdnDto phoneToRemmove);



}
