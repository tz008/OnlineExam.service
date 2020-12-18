package com.onlineExam.web.entity;

public class ExamPaperAnswer {
    private Integer examPaperAnswerId;

    private Integer examAnswerNumber;

    private Integer examPaperQuestionId;

    private String examPaperAnswer;

    private Integer point;

    public Integer getExamPaperAnswerId() {
        return examPaperAnswerId;
    }

    public void setExamPaperAnswerId(Integer examPaperAnswerId) {
        this.examPaperAnswerId = examPaperAnswerId;
    }

    public Integer getExamPaperQuestionId() {
        return examPaperQuestionId;
    }

    public void setExamPaperQuestionId(Integer examPaperQuestionId) {
        this.examPaperQuestionId = examPaperQuestionId;
    }

    public String getExamPaperAnswer() {
        return examPaperAnswer;
    }

    public void setExamPaperAnswer(String examPaperAnswer) {
        this.examPaperAnswer = examPaperAnswer == null ? null : examPaperAnswer.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getExamAnswerNumber() {
        return examAnswerNumber;
    }

    public void setExamAnswerNumber(Integer examAnswerNumber) {
        this.examAnswerNumber = examAnswerNumber;
    }
}