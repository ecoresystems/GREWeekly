package com.ecoresystems.greweekly.data.entity;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class Users {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "MAIL", nullable = false, unique = true)
    private String mail;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "AGE")
    private short age;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "NATIONALITY")
    private String nationality;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

}
