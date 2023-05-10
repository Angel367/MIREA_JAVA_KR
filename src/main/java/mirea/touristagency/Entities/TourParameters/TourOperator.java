package mirea.touristagency.Entities.TourParameters;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Indexed
@Table(name = "tour_operators")
public class TourOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String name;
}
