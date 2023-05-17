package mirea.touristagency.Services.Implementations;

import mirea.touristagency.Entities.Role;
import mirea.touristagency.Entities.Tour;
import mirea.touristagency.Entities.User;
import mirea.touristagency.Services.TourService;
import mirea.touristagency.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;
    @Override
    public void save(Tour tour) {
        tourRepository.save(tour);
    }

//    @PostConstruct
//    public void addTour() throws ParseException {
//        Tour tour = new Tour();
//        tour.setName("Горящий тур");
//        tour.setPrice(115000);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        tour.setDepartureDate(simpleDateFormat.parse(""));
//        admin.setEmail("admin@gmail.com");
//        admin.setPassword(passwordEncoder.encode("admin"));
//        admin.setRole(Role.ADMIN);
//        userRepository.save(admin);
//        log.info(admin.toString());
//    }
}
