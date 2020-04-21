package lt.bite.commerce.domain.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class AddressDto extends RepresentationModel<AddressDto> {

  private long id;

  private Integer houseNo;

  private String houseNoSuffix;

  private String street;

  private String city;

  private String country;

  private Integer postCode;

  private String addressType;

}

