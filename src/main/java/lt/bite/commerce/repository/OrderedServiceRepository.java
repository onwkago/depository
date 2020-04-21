package lt.bite.commerce.repository;

import lt.bite.commerce.repository.entity.OrderedService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedServiceRepository extends CrudRepository<OrderedService, Long> {

}
