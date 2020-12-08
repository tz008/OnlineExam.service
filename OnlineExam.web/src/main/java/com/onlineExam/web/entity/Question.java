package com.onlineExam.web.entity;

public class Question {
    private Integer questionNumber;

    private String questionType;

    private Integer questionDifficulty;

    private String questionKnowledge;

    private Integer questionPoint;

    private Integer questionTime;

    private String questionStem;

    private String questionAnswer;

    private String questionImg;

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    public Integer getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(Integer questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    public String getQuestionKnowledge() {
        return questionKnowledge;
    }

    public void setQuestionKnowledge(String questionKnowledge) {
        this.questionKnowledge = questionKnowledge == null ? null : questionKnowledge.trim();
    }

    public Integer getQuestionPoint() {
        return questionPoint;
    }

    public void setQuestionPoint(Integer questionPoint) {
        this.questionPoint = questionPoint;
    }

    public Integer getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Integer questionTime) {
        this.questionTime = questionTime;
    }

    public String getQuestionStem() {
        return questionStem;
    }

    public void setQuestionStem(String questionStem) {
        this.questionStem = questionStem == null ? null : questionStem.trim();
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer == null ? null : questionAnswer.trim();
    }

    public String getQuestionImg() {
        return questionImg;
    }

    public void setQuestionImg(String questionImg) {
        this.questionImg = questionImg == null ? null : questionImg.trim();
    }
}