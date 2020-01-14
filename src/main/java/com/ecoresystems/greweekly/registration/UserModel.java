package com.ecoresystems.greweekly.registration;

import com.ecoresystems.greweekly.auth.User;
import com.ecoresystems.greweekly.data.entity.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;

public class UserModel extends Users {
    private String mail;
    private String password;
    private String userName;
    private short age;
    private String country;
    private String nationality;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void translateModelToUser(){
        User user = new User();
        user.setMail(this.mail);
        user.setPassword(new BCryptPasswordEncoder().encode(this.password));
        user.setUserName(this.userName);
        user.setCountry(this.country);
        user.setNationality(this.nationality);
        user.setAge(this.age);
    }
}
