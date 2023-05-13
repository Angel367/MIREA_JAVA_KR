package mirea.touristagency.tests;
import mirea.touristagency.Services.Implementations.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import mirea.touristagency.Entities.Role;
import mirea.touristagency.Entities.User;
import mirea.touristagency.Repositories.UserRepository;
import mirea.touristagency.Services.UserService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder encoder;
    @Captor
    private ArgumentCaptor<User> captor;
    @Test
    public void getUsers() {
        User user1 = new User("firstName", "lastName", "email", "number",
                "password", Role.USER);
        UserService userService = new UserServiceImpl(userRepository);
        userService.save(user1);
        Mockito.when(userRepository.findAll()).thenReturn(List.of(user1));
        Assertions.assertEquals("email", userService.getUsers().get(0).getEmail());
        Assertions.assertEquals(1, userService.getUsers().size());
    }
}