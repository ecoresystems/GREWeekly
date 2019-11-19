package com.ecoresystems.greweekly.data.entity;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class Users {
    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="MAIL")
    private String mail;
    @Column(name="GENDER")
    private short gender;
    @Column(name="BIRTHDAY")
    private String birthday;
    @Column(name="COUNTRY")
    private String country;
    @Column(name="NATIONALITY")
    private String nationality;
    @Column(name="PASSWORD")
    private String password;

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

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
