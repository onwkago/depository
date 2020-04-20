package lt.bite.commerce.controller.orders;

import lt.bite.commerce.controller.ApiUrls;
import lt.bite.commerce.domain.model.AddressDto;
import lt.bite.commerce.domain.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(produces= "application/json")
public class AddressController {

  @Autowired
  AddressService addressService;

  @PostMapping(path = Urls.ADDITIONAL_ADDRESS, consumes = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<?> additionalAddress(@Valid @RequestBody AddressDto newAddress) {
    return addressService.additionalAddress(newAddress);
  }

  @PostMapping(path = Urls.CHANGE_ADDRESS, consumes = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<?> changeAddress(@Valid @RequestBody AddressDto addressToChange) {
    return addressService.changeAddress(addressToChange);
  }

  @PostMapping(path = Urls.REMOVE_ADDRESS, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> removeAddress(@Valid @RequestBody AddressDto addressToRemove) {
    return addressService.removeAddress(addressToRemove);
    }

  @GetMapping(path = Urls.GET_ADDRESS)
  public HttpEntity<?> getAddress(@RequestParam(name="id") Long id) {
    return addressService.getAddressById(id);
  }


  public final static class Urls{
    private final static String ROOT_URL = ApiUrls.API_URL + "/address";
    private final static String GET_ADDRESS = ApiUrls.API_URL + "/getaddress";
    private final static String ADDITIONAL_ADDRESS = ROOT_URL + "/additionalAddress";
    private final static String CHANGE_ADDRESS = ROOT_URL + "/changeAddress";
    private final static String REMOVE_ADDRESS = ROOT_URL + "/removeaddress";
  }
}
