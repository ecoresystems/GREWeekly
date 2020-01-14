package com.ecoresystems.greweekly.registration;

import com.ecoresystems.greweekly.auth.User;
import com.ecoresystems.greweekly.data.entity.Users;
import com.ecoresystems.greweekly.data.repository.UsersRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class RegistrationController {

    private final UsersRepository usersRepository;

    public RegistrationController(UsersRepository usersRepository){
        super();
        this.usersRepository = usersRepository;
    }

    @PostMapping(value="/registration_api")
    public String registration(@RequestBody UserModel userModel) throws UnsupportedEncodingException{
        usersRepository.save(userModel.translateModelToUser());
        return "Some Return Value";
    }
}
