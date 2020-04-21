package lt.bite.commerce.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="OrderedService",schema="ORDERS")
public class OrderedService {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Generated
  private long id;

  @ManyToOne
  private Service service;

  @ManyToOne
  private Msisdn msisdn;

  private LocalDateTime activeFrom;

  private LocalDateTime activeTo;

}
