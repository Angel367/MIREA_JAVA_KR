package mirea.touristagency.Controllers;

import mirea.touristagency.Entities.Tour;
import mirea.touristagency.Entities.TourParameters.Country;
import mirea.touristagency.Entities.User;
import mirea.touristagency.Services.UserService;
import mirea.touristagency.repository.CountryRepository;
import mirea.touristagency.repository.TourRepository;
import mirea.touristagency.repository.UserRepository;
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

    @Autowired
    CountryRepository countryRepository;

    private Authentication authentication;

    @GetMapping()
    public String userRecords(Model model) {

        List<Tour> tourList = tourRepository.findAll();
        List<Country> countryList = countryRepository.findAll();

        model.addAttribute("tours", tourList);
        model.addAttribute("countries", countryList);


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
