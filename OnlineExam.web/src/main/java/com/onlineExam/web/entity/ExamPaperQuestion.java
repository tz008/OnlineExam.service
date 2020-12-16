package com.onlineExam.web.entity;

//试卷中的题目
public class ExamPaperQuestion {
    private Integer examPaperQuestionId;

    private Integer examQuestionNumber;

    private Integer examPaperNumber;

    public Integer getExamPaperQuestionId() {
        return examPaperQuestionId;
    }

    public void setExamPaperQuestionId(Integer examPaperQuestionId) {
        this.examPaperQuestionId = examPaperQuestionId;
    }

    public Integer getExamQuestionNumber() {
        return examQuestionNumber;
    }

    public void setExamQuestionNumber(Integer examQuestionNumber) {
        this.examQuestionNumber = examQuestionNumber;
    }

    public Integer getExamPaperNumber() {
        return examPaperNumber;
    }

    public void setExamPaperNumber(Integer examPaperNumber) {
        this.examPaperNumber = examPaperNumber;
    }
}