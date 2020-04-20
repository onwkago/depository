package lt.bite.commerce.domain.validation;

import lt.bite.commerce.domain.model.CustomerDto;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Component("beforeCreateValidate")
public class Validate implements Validator {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(NoSuchElementException.class)
  public Map<String, String> handleValidationExceptions(
          MethodArgumentNotValidException ex) {
    Map<String,String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName,errorMessage);
    });
    return errors;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return CustomerDto.class.equals(aClass);
  }

  @Override
  public void validate(Object o, Errors errors) {

  }
}
