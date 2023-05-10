package mirea.touristagency.Controllers.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import mirea.touristagency.Entities.TourParameters.*;

@Data
public class TourDTO {

    long id;

    String name;

    int price;

    SimpleDateFormat departureDate;

    City departureCity;

    TourOperator tourOperator;

    int peopleAmount;

    int daysAmount;

    Country country;

    ArrivalCity arrivalCity;

    Hotel hotel;

    public TourDTO() {

    }

    public TourDTO(long id, String name, int price, SimpleDateFormat departureDate, City departureCity,
                   TourOperator tourOperator, int peopleAmount, int daysAmount, Country country,
                   ArrivalCity arrivalCity, Hotel hotel) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.departureDate = departureDate;
        this.departureCity = departureCity;
        this.tourOperator = tourOperator;
        this.peopleAmount = peopleAmount;
        this.daysAmount = daysAmount;
        this.country = country;
        this.arrivalCity = arrivalCity;
        this.hotel = hotel;
    }
}
