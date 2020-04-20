package lt.bite.commerce.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

 @Bean
  public ModelMapper modelMapper(){
   return new ModelMapper();
 }
}
