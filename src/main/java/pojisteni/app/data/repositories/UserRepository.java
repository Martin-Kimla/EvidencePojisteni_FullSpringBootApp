package pojisteni.app.data.repositories;


import org.springframework.data.repository.CrudRepository;
import pojisteni.app.data.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
