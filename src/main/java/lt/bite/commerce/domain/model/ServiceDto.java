package lt.bite.commerce.domain.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;

@Data
public class ServiceDto extends RepresentationModel<ServiceDto> {

  @NotNull(message = "Please provide id")
  private long id;

  private String name;

  private String description;

  private String type;
}
