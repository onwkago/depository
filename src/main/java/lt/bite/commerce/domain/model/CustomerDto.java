package lt.bite.commerce.domain.model;

import lombok.Data;
import lt.bite.commerce.repository.entity.Account;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CustomerDto extends RepresentationModel<CustomerDto> {

  @NotNull(message = "Please provide id")
  private long id;

  protected String name;

  private String surname;

  private String companyName;

  private Integer companyCode;
  @NotNull(message = "personal code cannot be null")
  private Integer personalCode;

  private List<Account> accounts;

}
