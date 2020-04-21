package lt.bite.commerce.repository;

import lt.bite.commerce.repository.entity.Msisdn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsisdnRepository extends CrudRepository<Msisdn, Long> {
}
