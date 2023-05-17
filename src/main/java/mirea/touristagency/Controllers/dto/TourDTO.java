package mirea.touristagency.Controllers.dto;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mirea.touristagency.Entities.TourParameters.*;

@Data
public class TourDTO {

    long id;

    String name;

    int price;

    String departureDate;
    SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");


    City departureCity;

    TourOperator tourOperator;

    int peopleAmount;

    int daysAmount;

    Country country;

    ArrivalCity arrivalCity;

    Hotel hotel;

    public TourDTO() {

    }

    public Date getDepartureDate() {
        try {
        return stf.parse(departureDate);
        } catch (Exception e) {
            return new Date();
        }
    }

    public TourDTO(long id, String name, int price, String departureDate, City departureCity,
                   TourOperator tourOperator, int peopleAmount, int daysAmount, Country country,
                   ArrivalCity arrivalCity, Hot el hotel) {
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
