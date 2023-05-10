package mirea.touristagency.Controllers;

import mirea.touristagency.Controllers.dto.TourDTO;
import mirea.touristagency.Entities.Tour;
import mirea.touristagency.Services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import mirea.touristagency.Entities.User;
import mirea.touristagency.repository.UserRepository;

@Controller
@RequestMapping("/addtour")
public class TourController {

    private Authentication authentication;

    @Autowired
    TourService tourService;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public String addTour(@ModelAttribute("tour") TourDTO tourDTO) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email);

        Tour tour = new Tour();
        tour.setName(tourDTO.getName());
        tour.setPrice(tourDTO.getPrice());
        tour.setDepartureDate(tourDTO.getDepartureDate());
        tour.setTourOperator(tourDTO.getTourOperator());
        tour.setPeopleAmount(tourDTO.getPeopleAmount());
        tour.setDaysAmount(tourDTO.getDaysAmount());
        tour.setDepartureCity(tourDTO.getDepartureCity());
        tour.setCountry(tourDTO.getCountry());
        tour.setArrivalCity(tourDTO.getArrivalCity());
        tour.setHotel(tourDTO.getHotel());

        tourService.save(tour);
        return "redirect:/addtour?success";
    }

    @GetMapping
    public String tour(Model m) {
        m.addAttribute("tour", new TourDTO());
        return "addtour";
    }
}
