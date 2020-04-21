package lt.bite.commerce.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.bite.commerce.repository.entity.OrderedService;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MsisdnDto extends RepresentationModel<MsisdnDto> {
  @NotNull(message = "Please provide id")
  private long id;

  private int number;

  private LocalDateTime activeFrom;

  private LocalDateTime activeTo;

  private List<OrderedService> orderedServices;

}
