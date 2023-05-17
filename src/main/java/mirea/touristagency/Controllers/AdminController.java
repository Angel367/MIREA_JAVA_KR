package mirea.touristagency.Controllers;

import mirea.touristagency.Entities.Tour;
import mirea.touristagency.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    TourRepository tourRepository;


    @GetMapping()
    public String allRecords(Model model) {

        List<Tour> list = tourRepository.findAll();

        model.addAttribute("records", list);

        return "admin";
    }

    @GetMapping("/{id}")
    public String deleteTour(@PathVariable Long id) {
        tourRepository.deleteById(id);
        return "redirect:/admin";
    }
}
