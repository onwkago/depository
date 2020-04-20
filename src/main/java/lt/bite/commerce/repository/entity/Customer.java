package lt.bite.commerce.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lt.bite.commerce.domain.model.CustomerDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customer",schema="ORDERS")
public class Customer {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Generated
  private long id;

  private String name;

  private String surname;

  private String companyName;

  private Integer companyCode;

  private Integer personalCode;

  @OneToMany(mappedBy = "id", fetch=FetchType.LAZY)
  private List<Account> accounts;





}
