package com.ecoresystems.greweekly.registration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }
}
