package com.ecoresystems.greweekly.registration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


class InfoValidator {
    ResponseEntity EmailValidator(String mailAddress){
        if (mailAddress == null)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email address cannot be empty");
        }
        try{
        InternetAddress emailAddr = new InternetAddress(mailAddress);
        System.out.println(emailAddr);
        emailAddr.validate();
        }
        catch (AddressException ex){
            System.out.println(ex.toString());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Email Validation passed");
    }
}
