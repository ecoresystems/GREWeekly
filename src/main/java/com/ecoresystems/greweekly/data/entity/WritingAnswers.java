package com.ecoresystems.greweekly.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WRITING_ANSWERS")
public class WritingAnswers {
    @Id
    @Column(name = "ANSWER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "ANSWER_BODY")
    private String body;
    @Column(name = "QUESTION_ID")
    private int questionId;
    @Column(name = "ANSWER_TIME")
    private Date answerTime;

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

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }
}
