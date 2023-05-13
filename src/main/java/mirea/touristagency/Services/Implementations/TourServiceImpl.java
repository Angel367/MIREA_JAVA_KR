package mirea.touristagency.Services.Implementations;

import mirea.touristagency.Entities.Tour;
import mirea.touristagency.Services.TourService;
import mirea.touristagency.Repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;
    @Override
    public void save(Tour tour) {
        tourRepository.save(tour);
    }
}
