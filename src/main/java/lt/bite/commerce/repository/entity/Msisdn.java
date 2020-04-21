package lt.bite.commerce.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Msisdn",schema="ORDERS")
public class Msisdn {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Generated
  private long id;

  private int number;

  private LocalDateTime activeFrom;

  private LocalDateTime activeTo;

  @OneToMany(mappedBy = "id")
  private List<OrderedService> orderedServices;

  @ManyToOne
  private Account account;
}
