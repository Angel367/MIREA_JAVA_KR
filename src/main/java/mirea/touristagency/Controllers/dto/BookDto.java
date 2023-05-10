package mirea.touristagency.Controllers.dto;

import lombok.Data;

@Data
public class BookDto {

    private String date;

    private String time;

    private String barber;

    private String service;

    public BookDto() {
    }

    public BookDto(String date, String time, String barber, String service) {
        super();
        this.date = date;
        this.time = time;
        this.barber = barber;
        this.service = service;
    }
}
