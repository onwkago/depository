package lt.bite.commerce.domain.model;

import lombok.Data;
import lt.bite.commerce.repository.entity.Address;
import lt.bite.commerce.repository.entity.Msisdn;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AccountDto extends RepresentationModel<AccountDto> {
  @NotNull(message = "Please provide id")
  private long id;

  private String name;

  private List<Address> addresses;

  private List<Msisdn> msisdnList;
}
