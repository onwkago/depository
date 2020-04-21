package lt.bite.commerce.controller.orders;

import lt.bite.commerce.controller.ApiUrls;
import lt.bite.commerce.domain.model.ServiceDto;
import lt.bite.commerce.domain.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces= "application/json")
public class ServicesController {

  @Autowired
  ServicesService servicesService;

  @GetMapping(path= Urls.GET_SERVICE)
  public HttpEntity<ServiceDto> getService(@RequestParam(name="serviceid") Long id) {
    return servicesService.getServiceById(id);
  }

  @GetMapping(path= Urls.GET_ALL_SERVICES)
  public HttpEntity<List<ServiceDto>> getAllServices() {
    return servicesService.getAllServices();
  }

  public final static class Urls{
    private final static String ROOT_URL = ApiUrls.API_URL + "/services";
    private final static String GET_SERVICE = ROOT_URL + "/getservice";
    private final static String GET_ALL_SERVICES = ROOT_URL + "/getallservices";

  }
}
