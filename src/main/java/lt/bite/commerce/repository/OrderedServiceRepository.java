package lt.bite.commerce.repository;

import lt.bite.commerce.repository.entity.OrderedService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedServiceRepository extends CrudRepository<OrderedService, Long> {
  @Query("SELECT o FROM ORDERS.ORDERED_SERVICE o WHERE o.SERVICE_ID = ?1 o.ACTIVE_TO is null or o.ACTIVE_TO < CURRENT_TIMESTAMP()")
  List<OrderedService> getActiveOrders(Long msisdnId);

}
