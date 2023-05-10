package mirea.touristagency.Entities.TourParameters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import mirea.touristagency.Entities.Tour;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Indexed
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String name;

    @JsonIgnore
    @OneToMany(/*fetch = FetchType.LAZY, */mappedBy = "departureCity")
    private List<Tour> tours;

}
