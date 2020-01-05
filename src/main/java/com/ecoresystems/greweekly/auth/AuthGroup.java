package com.ecoresystems.greweekly.auth;


import javax.persistence.*;

@Entity
@Table(name="AUTH_USER_GROUP")
public class AuthGroup {
    @Id
    @Column(name="AUTH_USER_GROUP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="USER_MAIL")
    private String mail;
    @Column(name="AUTH_GROUP")
    private String authGroup;

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

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup;
    }
}
