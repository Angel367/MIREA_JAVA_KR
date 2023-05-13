package mirea.touristagency.Services.Implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import mirea.touristagency.Controllers.dto.UserRegistrationDTO;
import mirea.touristagency.Entities.Role;
import mirea.touristagency.Entities.User;
import mirea.touristagency.Services.UserService;
import mirea.touristagency.Repositories.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDTO userRegistrationDTO) {
        User user = new User(userRegistrationDTO.getFirstName(), userRegistrationDTO.getLastName(),
                userRegistrationDTO.getUsername(), userRegistrationDTO.getNumber(), passwordEncoder.encode(userRegistrationDTO.getPassword()),
                Role.USER);

        return userRepository.save(user);
    }
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepository.findByEmail(username) != null) {
            log.info(username);
            return userRepository.findByEmail(username);
        }
        else {
            log.info("ex: " + username);
            throw new UsernameNotFoundException("Not found the user");
        }
    }
    @PostConstruct
    public void addAdmin() {
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);
        log.info(admin.toString());
    }
}


