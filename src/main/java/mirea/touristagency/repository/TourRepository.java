package mirea.touristagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mirea.touristagency.Entities.Tour;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    //Tour findByEmail(String email);
    Tour findById(long id);
    List<Tour> findAllByUserId(long id);
}
