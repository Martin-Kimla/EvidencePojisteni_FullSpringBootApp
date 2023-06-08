package pojisteni.app.models.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import pojisteni.app.models.dto.UserDTO;

public interface UserService extends UserDetailsService {

    void create(UserDTO user, boolean isAdmin);

}
