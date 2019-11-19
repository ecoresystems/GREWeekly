package com.ecoresystems.greweekly.analyticalwriting.domain;

public class WritingAnswer {
    private short questionType;
    private long userId;
    private String answerBody;

    public short getQuestionType() {
        return questionType;
    }

    public void setQuestionType(short questionType) {
        this.questionType = questionType;
    }
}
