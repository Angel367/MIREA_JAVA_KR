package mirea.touristagency.Controllers.dto;

import lombok.Data;
import mirea.touristagency.Entities.Role;

@Data
public class UserRegistrationDTO {

    private String firstName;

    private String lastName;

    private String middleName;

    private String username;

    private String number;

    private String password;



    public UserRegistrationDTO(){}

    public UserRegistrationDTO(String firstName, String lastName, String middleName, String username, String number) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.username = username;
        this.number = number;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getUsername() {
        return username;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }
}
