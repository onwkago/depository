package lt.bite.commerce.domain.model;

import lombok.Data;
import lt.bite.commerce.repository.entity.Msisdn;
import lt.bite.commerce.repository.entity.Service;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
@Data
public class OrderedServiceDto extends RepresentationModel<OrderedServiceDto> {
  private long id;

  private Service service;

  private Msisdn msisdn;

  private LocalDateTime activeFrom;

  private LocalDateTime activeTo;
}
