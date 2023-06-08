package pojisteni.app.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pojisteni.app.data.entities.ConnectionEntity;
import pojisteni.app.data.entities.InsuredEntity;

public interface ConnectionRepository extends CrudRepository<ConnectionEntity, Long> {
}
