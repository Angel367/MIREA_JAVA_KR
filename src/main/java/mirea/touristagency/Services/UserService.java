package mirea.touristagency.Services;

import mirea.touristagency.Entities.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import mirea.touristagency.Controllers.dto.UserRegistrationDTO;
import mirea.touristagency.Entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDTO UserRegistrationDTO);
    User save(User user);
    List<User> getUsers();
}
