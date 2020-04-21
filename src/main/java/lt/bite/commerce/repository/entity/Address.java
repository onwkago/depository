package lt.bite.commerce.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Address",schema="ORDERS")
public class Address {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Generated
  private long id;

  private Integer houseNo;

  private String houseNoSuffix;

  private String street;

  private String city;

  private String country;

  private Integer postCode;

  private String addressType;

  @ManyToOne
  private Account account;

}
