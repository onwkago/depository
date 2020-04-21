package lt.bite.commerce.domain.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class ServiceDto extends RepresentationModel<ServiceDto> {

  private long id;

  private String name;

  private String description;

  private String type;
}
