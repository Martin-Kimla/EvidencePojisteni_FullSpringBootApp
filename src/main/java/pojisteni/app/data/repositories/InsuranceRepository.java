package pojisteni.app.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pojisteni.app.data.entities.InsuranceEntity;

public interface InsuranceRepository extends CrudRepository<InsuranceEntity, Long> {

}
