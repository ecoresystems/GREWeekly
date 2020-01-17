package com.ecoresystems.greweekly.registration;

import com.ecoresystems.greweekly.auth.AuthGroup;
import com.ecoresystems.greweekly.auth.AuthGroupRepository;
import com.ecoresystems.greweekly.data.entity.Users;
import com.ecoresystems.greweekly.data.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
public class RegistrationAPIController {

    private final UsersRepository usersRepository;
    private final InfoValidator infoValidator;
    private final AuthGroupRepository authGroupRepository;

    public RegistrationAPIController(UsersRepository usersRepository, InfoValidator infoValidator, AuthGroupRepository authGroupRepository) {
        super();
        this.usersRepository = usersRepository;
        this.authGroupRepository = authGroupRepository;
        this.infoValidator = infoValidator;
    }

    @PostMapping(value = "/registration_api")
    public ResponseEntity registration(@Valid @RequestBody UserModel userModel, BindingResult bindingResult, WebRequest request, Errors errors) throws UnsupportedEncodingException {
        try {
            // Manual validation in controller, change to custom validator later
            if (!infoValidator.EmailValidator(userModel.getMail()).equals("passed")){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(infoValidator.EmailValidator(userModel.getMail()));
            }
            System.out.println("User E-Mail: " + userModel.getMail()+" validation successful");
            System.out.println("User Name:" + userModel.getUserName());
            System.out.println("User Country: " + userModel.getCountry());
            System.out.println("User Nationality: " + userModel.getNationality());
            System.out.println("User age: " + Integer.toString(userModel.getAge()));
            if (!infoValidator.PasswordValidator(userModel.getPassword(),userModel.getPasswordConfirmation()).equals("passed")){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(infoValidator.PasswordValidator(userModel.getPassword(),userModel.getPasswordConfirmation()));
            }
            System.out.println("User Password: " + userModel.getPassword()+ " validation passed");
            this.usersRepository.save(userModel.translateModelToUser());
            this.authGroupRepository.save(userModel.translateModelToAuthGroup());
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Successfully created user: " + userModel.getMail());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e);
        }

    }
}
