package mirea.touristagency.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/#command")
    public String command() {
        return "index#command";
    }

    @GetMapping("/#services")
    public String services() {
        return "index#services";
    }

    @GetMapping("/#contact")
    public String contact() {
        return "index#contact";
    }
}
