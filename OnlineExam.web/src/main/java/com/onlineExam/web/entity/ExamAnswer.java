package com.onlineExam.web.entity;

public class ExamAnswer {
    private Integer examAnswerNumber;

    private Integer examObjectivePoint;

    private Integer examSubjectivePoint;

    private Integer examStudentNumber;

    private Integer examNumber;

    public Integer getExamAnswerNumber() {
        return examAnswerNumber;
    }

    public void setExamAnswerNumber(Integer examAnswerNumber) {
        this.examAnswerNumber = examAnswerNumber;
    }

    public Integer getExamObjectivePoint() {
        return examObjectivePoint;
    }

    public void setExamObjectivePoint(Integer examObjectivePoint) {
        this.examObjectivePoint = examObjectivePoint;
    }

    public Integer getExamSubjectivePoint() {
        return examSubjectivePoint;
    }

    public void setExamSubjectivePoint(Integer examSubjectivePoint) {
        this.examSubjectivePoint = examSubjectivePoint;
    }

    public Integer getExamStudentNumber() {
        return examStudentNumber;
    }

    public void setExamStudentNumber(Integer examStudentNumber) {
        this.examStudentNumber = examStudentNumber;
    }

    public Integer getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(Integer examNumber) {
        this.examNumber = examNumber;
    }
}