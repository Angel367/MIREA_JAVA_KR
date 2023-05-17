package mirea.touristagency.Controllers;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import mirea.touristagency.Controllers.dto.UserRegistrationDTO;

import mirea.touristagency.Services.UserService;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrarionDto() {
        return new UserRegistrationDTO();
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userRegistrationDTO) {
        userService.save(userRegistrationDTO);
        return "redirect:/registration?success";
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

}
