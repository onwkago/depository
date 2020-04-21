package lt.bite.commerce.domain.model;

import lombok.Data;
import lt.bite.commerce.repository.entity.Address;
import lt.bite.commerce.repository.entity.Msisdn;
import org.springframework.hateoas.RepresentationModel;
import java.util.List;

@Data
public class AccountDto extends RepresentationModel<AccountDto> {

  private long id;

  private String name;

  private List<Address> addresses;

  private List<Msisdn> msisdnList;
}
