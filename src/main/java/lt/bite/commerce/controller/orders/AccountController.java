package lt.bite.commerce.controller.orders;

import lt.bite.commerce.controller.ApiUrls;
import lt.bite.commerce.domain.model.AccountDto;
import lt.bite.commerce.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(produces= "application/json")
public class AccountController {

  @Autowired
  AccountService accountService;


  @GetMapping(path= Urls.GET_ACCOUNT)
  public HttpEntity<AccountDto> getAccount(@RequestParam(name="accountid") Long accountId) {
    return accountService.getAccountById(accountId);
  }

  @GetMapping(path = Urls.GET_CUSTOMER_ACCOUNTS)
  public HttpEntity<List<AccountDto>> getAccounts(@RequestParam(name="customerid")Long customerId){
    return accountService.getCustomerAccounts(customerId);
  }

  @PutMapping(path= Urls.UPDATE_ACCOUNT,consumes= MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<?> updateAccount(@Valid @RequestBody AccountDto accountToUpdate) {
    return accountService.updateAccount(accountToUpdate);
  }

  @DeleteMapping(path= Urls.REMOVE_ACCOUNT,consumes= MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<?> removeAccount(@Valid @RequestBody AccountDto accountToRemove) {
    return accountService.removeAccount(accountToRemove);
  }

  public final static class Urls{
    private final static String ROOT_URL = ApiUrls.API_URL + "/account";
    private final static String GET_ACCOUNT = ROOT_URL + "/getaccount";
    private final static String GET_CUSTOMER_ACCOUNTS = ROOT_URL + "/getallaccounts";
    private final static String UPDATE_ACCOUNT = ROOT_URL + "/updateaccount";
    private final static String REMOVE_ACCOUNT = ROOT_URL + "/removeaccount";

  }
}
