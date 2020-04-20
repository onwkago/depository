package lt.bite.commerce.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Account",schema="ORDERS")
public class Account {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Generated
  private long id;

  private String name;

  @OneToMany(mappedBy = "id", fetch=FetchType.LAZY)
  private List<Address> addresses;

  @OneToMany(mappedBy = "id")
  private List<Msisdn> msisdnList;

}
