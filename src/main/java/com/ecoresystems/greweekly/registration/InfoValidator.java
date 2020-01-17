package com.ecoresystems.greweekly.registration;

import com.ecoresystems.greweekly.auth.User;
import com.ecoresystems.greweekly.auth.UserRepository;
import com.ecoresystems.greweekly.data.repository.UsersRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
class InfoValidator {

    private final UsersRepository usersRepository;

    public InfoValidator(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    String EmailValidator(String mailAddress) {
        if (mailAddress == null) {
            return "Email address cannot be empty";
        }
        if (EmailValidator.getInstance().isValid(mailAddress)) {
            if (usersRepository.findByMail(mailAddress) != null) {
                return "Mail address " + mailAddress + " already exists";
            } else {
                return "passed";
            }
        } else {
            return "Invalid E-Mail address";
        }
    }

    String PasswordValidator(String password, String passwordConfirmation) {

        if (!password.equals(passwordConfirmation)) {
            return "Passwords don't match";
        } else if (password.length() < 8) {
            return "Password must more than 8";
        } else if (!digit(password)) {
            return "Password must contains digit";
        } else if (!symbol(password)) {
            return "Password must contains symbol";
        } else if (!uppcase(password)) {
            return "Password must contains Upper case";
        } else if (!lowerCase(password)) {
            return "Password must contains Lower case";
        }
        return "passed";
    }


    public static boolean validate(String password) {
        return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");
    }

    public static boolean symbol(String password) {
        return password.matches(".*[@#$%!^&*()_=-].*");
    }

    public static boolean uppcase(String password) {
        return password.matches(".*[A-Z].*");
    }

    public static boolean lowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    public static boolean digit(String password) {
        return password.matches(".*\\d.*");
    }

}
