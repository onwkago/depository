package lt.bite.commerce;

import lt.bite.commerce.domain.service.CustomerService;
import lt.bite.commerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@SpringBootApplication
@ComponentScan
public class CommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceApplication.class, args);
	}

}
