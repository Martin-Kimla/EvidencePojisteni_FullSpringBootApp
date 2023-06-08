package pojisteni.app.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pojisteni.app.data.entities.InsuredEntity;

public interface InsuredRepository extends CrudRepository<InsuredEntity, Long> {
}
