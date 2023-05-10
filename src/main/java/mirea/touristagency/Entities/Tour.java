package mirea.touristagency.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mirea.touristagency.Entities.TourParameters.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Entity
@Getter
@Setter
@Indexed
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String name;

    int price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    SimpleDateFormat departureDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    City departureCity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    TourOperator tourOperator;

    int peopleAmount;

    int daysAmount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    Country country;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    ArrivalCity arrivalCity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    User user;



}
