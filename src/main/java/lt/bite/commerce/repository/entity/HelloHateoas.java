package lt.bite.commerce.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HelloHateoas",schema="ORDERS")
public class HelloHateoas extends RepresentationModel<HelloHateoas> {
  @Id
  @GeneratedValue
  @Generated
  private long id;
  @JsonProperty("content")
  private String hello;

}
