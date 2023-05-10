package mirea.touristagency.Services;

import org.springframework.security.core.userdetails.UserDetailsService;
import mirea.touristagency.Controllers.dto.UserRegistrationDTO;
import mirea.touristagency.Entities.User;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDTO UserRegistrationDTO);
}
