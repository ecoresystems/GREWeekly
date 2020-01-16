package com.ecoresystems.greweekly.registration;

import com.ecoresystems.greweekly.data.entity.Users;
import com.ecoresystems.greweekly.data.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
public class RegistrationController {

    private final UsersRepository usersRepository;

    public RegistrationController(UsersRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    @PostMapping(value = "/registration_api")
    public ResponseEntity registration(@Valid @RequestBody UserModel userModel, BindingResult bindingResult, WebRequest request, Errors errors) throws UnsupportedEncodingException {
        try {
            UserModel currentUser = userModel;
            // Manual validation in controller, change to custom validator later
            InfoValidator infoValidator = new InfoValidator();
            System.out.println(infoValidator.EmailValidator(userModel.getMail()));
            System.out.println("User E-Mail: " + currentUser.getMail());
            System.out.println("User Name:" + currentUser.getUserName());
            System.out.println("User Country: " + currentUser.getCountry());
            System.out.println("User Nationality: " + currentUser.getNationality());
            System.out.println("User age: " + Integer.toString(currentUser.getAge()));
            System.out.println("User Password: " + currentUser.getPassword());
            this.usersRepository.save(userModel.translateModelToUser());
            String temp_mail = userModel.getMail();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Successfully created user: " + currentUser.getMail());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e);
        }

    }
}
