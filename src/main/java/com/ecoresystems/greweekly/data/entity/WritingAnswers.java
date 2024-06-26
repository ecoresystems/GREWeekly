package com.ecoresystems.greweekly.data.entity;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "WRITING_ANSWERS")
public class WritingAnswers {
    @Id
    @Column(name = "ANSWER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "ANSWER_BODY")
    private String body;
    @Column(name = "QUESTION_ID")
    private int questionId;
    @Column(name = "QUESTION_TYPE")
    private short questionType;
    @Column(name = "ANSWER_TIME")
    private Timestamp answerTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Timestamp getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Timestamp answerTime) {
        this.answerTime = answerTime;
    }

    public short getQuestionType() {
        return questionType;
    }

    public void setQuestionType(short questionType) {
        this.questionType = questionType;
    }
}
