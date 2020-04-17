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
@Table(name="Service",schema="ORDERS")
public class Service {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Generated
  private long id;

  private String name;

  private String description;

  private String type;
}
