package mirea.touristagency.Controllers;

import mirea.touristagency.Entities.Tour;
import mirea.touristagency.Entities.User;
import mirea.touristagency.Services.UserService;
import mirea.touristagency.Repositories.TourRepository;
import mirea.touristagency.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/all")
public class AllController {

    @Autowired
    TourRepository tourRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    private Authentication authentication;

    @GetMapping()
    public String userRecords(Model model) {

        List<Tour> list = tourRepository.findAll();

        model.addAttribute("records", list);

        return "all";
    }

    @ModelAttribute
    @GetMapping("/{id}")
    public ModelAndView buyNewTourPost(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName());
        Tour tour = tourRepository.findById(Long.parseLong(id));
        tour.setUser(user);
        tourRepository.save(tour);

        return new ModelAndView(new RedirectView("/lk"));
    }
}
