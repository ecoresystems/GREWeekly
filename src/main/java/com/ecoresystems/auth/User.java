package com.ecoresystems.auth;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class User {
    @Id
    @Column(name="USER_ID")
    private long id;
    @Column(name="MAIL",nullable = false, unique = true)
    private String mail;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
