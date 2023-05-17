package mirea.touristagency.Controllers;

import mirea.touristagency.Entities.Tour;
import mirea.touristagency.Entities.User;
import mirea.touristagency.repository.TourRepository;
import mirea.touristagency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/lk")
public class LKController {

    private Authentication authentication;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TourRepository tourRepository;


    @GetMapping()
    public String LKuserRecords(Model model) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName());
        List<Tour> list = tourRepository.findAllByUserId(user.getId());

        model.addAttribute("records", list);

        return "lk";
    }

    @ModelAttribute
    @GetMapping("/{id}")
    public ModelAndView unsubscribeFromTour(@PathVariable String id) {
        Tour tour = tourRepository.findById(Long.parseLong(id));
        tour.setUser(null);
        tourRepository.save(tour);

        return new ModelAndView(new RedirectView("/lk"));
    }
}
