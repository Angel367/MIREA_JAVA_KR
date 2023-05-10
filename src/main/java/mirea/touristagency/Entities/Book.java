package mirea.touristagency.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="records")
@Data
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String barber;

    private String date;

    private String time;

    private String service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Book() {

    }

    public Book(String barber, String date, String time, String service, User user) {
        this.barber = barber;
        this.date = date;
        this.time = time;
        this.service = service;
        this.user = user;
    }
}
