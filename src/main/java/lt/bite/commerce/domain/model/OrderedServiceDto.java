package lt.bite.commerce.domain.model;

import lombok.Data;
import lt.bite.commerce.repository.entity.Msisdn;
import lt.bite.commerce.repository.entity.Service;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class OrderedServiceDto extends RepresentationModel<OrderedServiceDto> {

  @NotNull(message = "Please provide id")
  private long id;

  private Service service;

  private LocalDateTime activeFrom;

  private LocalDateTime activeTo;
}
