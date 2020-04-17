package lt.bite.commerce.domain.model;

import lombok.Getter;
import lombok.Setter;
import lt.bite.commerce.repository.entity.Account;
import lt.bite.commerce.repository.entity.Customer;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
@Getter
@Setter
public class CustomerDto extends RepresentationModel<CustomerDto> {

  public CustomerDto(Customer customerEntity) {
    this.id = customerEntity.getId();
    this.accounts = customerEntity.getAccounts();
    this.companyCode = customerEntity.getCompanyCode();
    this.companyName = customerEntity.getCompanyName();
    this.name = customerEntity.getName();
    this.surname = customerEntity.getSurname();
  }

  private long id;

  private String name;

  private String surname;

  private String companyName;

  private Integer companyCode;

  private Integer personalCode;

  private List<Account> accounts;

}
