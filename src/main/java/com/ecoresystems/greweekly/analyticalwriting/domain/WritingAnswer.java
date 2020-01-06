package com.ecoresystems.greweekly.analyticalwriting.domain;

import com.ecoresystems.greweekly.data.entity.WritingAnswers;
import java.util.Date;
import java.sql.Timestamp;

public class WritingAnswer {
    private short questionType;
    private long userId;
    private String userMail;
    private int questionId;
    private String answerBody;

    public Timestamp getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Timestamp answerTime) {
        this.answerTime = answerTime;
    }

    private Timestamp answerTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswerBody() {
        return answerBody;
    }

    public void setAnswerBody(String answerBody) {
        this.answerBody = answerBody;
    }

    public short getQuestionType() {
        return questionType;
    }

    public void setQuestionType(short questionType) {
        this.questionType = questionType;
    }

    public WritingAnswers translateModelToAnswer(){
        System.out.println("Receiving translate request");
        WritingAnswers writingAnswers = new WritingAnswers();
        Date date = new Date();
        writingAnswers.setUserId(this.userId);
        writingAnswers.setBody(this.answerBody);
        writingAnswers.setQuestionId(this.questionId);
        writingAnswers.setQuestionType(this.questionType);
        writingAnswers.setAnswerTime(new Timestamp(date.getTime()));
        return writingAnswers;
    }
}
