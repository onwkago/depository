package lt.bite.commerce.domain.service;

import lt.bite.commerce.domain.model.ServiceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicesService {

  ResponseEntity<List<ServiceDto>> getAllServices();

  ResponseEntity<ServiceDto> getServiceById(Long id);
}
