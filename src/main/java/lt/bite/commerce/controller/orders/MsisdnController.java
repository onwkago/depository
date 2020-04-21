package lt.bite.commerce.controller.orders;

import lt.bite.commerce.controller.ApiUrls;
import lt.bite.commerce.domain.model.MsisdnDto;
import lt.bite.commerce.domain.service.MsisdnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(produces= "application/json")
public class MsisdnController {

  @Autowired
  MsisdnService msisdnService;

  @GetMapping(path = Urls.GET_PHONE_NO)
  public HttpEntity<MsisdnDto> getPhoneNo(@RequestParam(name="phoneidno") Long id) {
    return msisdnService.getPhoneNo(id);
  }

  @PostMapping(path = Urls.CHANGE_PHONE_NO)
  public HttpEntity<?> changePhoneNo(@Valid @RequestBody MsisdnDto phoneNoToChange) {
    return msisdnService.changePhoneNo(phoneNoToChange);
  }

  @PutMapping(path = Urls.ADDITIONAL_PHONE_NO)
  public HttpEntity<?> additionalPhoneNo(@Valid @RequestBody MsisdnDto additionalPhoneNo) {
    return msisdnService.additionalPhoneNo(additionalPhoneNo);
  }

  @DeleteMapping(path = Urls.REMOVE_PHONE_NO)
  public HttpEntity<?> removePhoneNo(@Valid @RequestBody MsisdnDto phoneNoToRemove) {
    return msisdnService.removePhoneNo(phoneNoToRemove);
  }

  public final static class Urls{
    private final static String ROOT_URL = ApiUrls.API_URL + "/sim";
    private final static String ADDITIONAL_PHONE_NO = ROOT_URL + "/addphoneno";
    private final static String CHANGE_PHONE_NO = ROOT_URL + "/changephoneno";
    private final static String REMOVE_PHONE_NO = ROOT_URL + "/removephoneno";
    private final static String GET_PHONE_NO = ROOT_URL + "/getphoneno";
    private final static String GET_ALL_PHONE_NUMBERS = ROOT_URL + "/getallphonenumbers";
  }
}
