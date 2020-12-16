package com.onlineExam.web.entity;

public class ExamSet {
    private Integer examSetNumber;

    private Integer examLatestTime;

    private Integer examEarlistTime;

    private Integer examPaperNumber;

    private Integer examTeacherNumber;

    private String examStudentNumber;

    public Integer getExamSetNumber() {
        return examSetNumber;
    }

    public void setExamSetNumber(Integer examSetNumber) {
        this.examSetNumber = examSetNumber;
    }

    public Integer getExamLatestTime() {
        return examLatestTime;
    }

    public void setExamLatestTime(Integer examLatestTime) {
        this.examLatestTime = examLatestTime;
    }

    public Integer getExamEarlistTime() {
        return examEarlistTime;
    }

    public void setExamEarlistTime(Integer examEarlistTime) {
        this.examEarlistTime = examEarlistTime;
    }

    public Integer getExamPaperNumber() {
        return examPaperNumber;
    }

    public void setExamPaperNumber(Integer examPaperNumber) {
        this.examPaperNumber = examPaperNumber;
    }

    public Integer getExamTeacherNumber() {
        return examTeacherNumber;
    }

    public void setExamTeacherNumber(Integer examTeacherNumber) {
        this.examTeacherNumber = examTeacherNumber;
    }

    public String getExamStudentNumber() {
        return examStudentNumber;
    }

    public void setExamStudentNumber(String examStudentNumber) {
        this.examStudentNumber = examStudentNumber == null ? null : examStudentNumber.trim();
    }
}