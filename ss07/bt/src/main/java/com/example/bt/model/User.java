package com.example.bt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Column(columnDefinition = "DATE")
    private String dob;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user= (User) target;
        if (!user.firstName.matches("^[A-Z]\\w{4,44}$")){
            errors.rejectValue("firstName",null,"First name in wrong format(5,45) ");
        }
        if (!user.lastName.matches("^[A-Z]\\w{4,44}$")){
            errors.rejectValue("lastName",null,"Last name in wrong format(5,45) ");
        }
        if (!user.phoneNumber.matches("^0[3|7|8|9]\\d{8}$")){
            errors.rejectValue("phoneNumber",null,"Phone number in wrong format(03|07|08|09 + (8 number) ");
        }
        if (LocalDate.parse(user.dob).plusYears(18).isAfter(LocalDate.now())){
            errors.rejectValue("dob",null,"Day of birth greater than 18");
        }
        if (!user.email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")){
            errors.rejectValue("email",null,"Email in wrong format(dinhnam123@gmail.com)");
        }
    }
}
