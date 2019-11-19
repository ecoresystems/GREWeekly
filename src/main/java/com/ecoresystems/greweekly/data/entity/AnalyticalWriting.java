package com.ecoresystems.greweekly.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "ANALYTICAL_WRITING")
public class AnalyticalWriting {
    @Id
    @Column(name = "QUESTION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "QUESTION_TYPE")
    private short type;
    @Column(name = "QUESTION_BODY")
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
