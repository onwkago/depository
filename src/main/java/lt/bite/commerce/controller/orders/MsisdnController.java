package lt.bite.commerce.controller.orders;

import lt.bite.commerce.controller.ApiUrls;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces= "application/json")
public class MsisdnController {

  public final static class Urls{
    private final static String ROOT_URL = ApiUrls.API_URL + "/sim";
    private final static String ADDITIONAL_PHONE_NO = ROOT_URL + "/addphoneno";
    private final static String CHANGE_PHONE_NO = ROOT_URL + "/changephoneno";
    private final static String REMOVE_PHONE_NO = ROOT_URL + "/removephoneno";
    private final static String GET_ALL_PHONE_NUMBERS = ROOT_URL + "/getallphonenumbers";
  }
}
