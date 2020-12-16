package com.onlineExam.web.entity;

//试卷
public class ExamPaper {
    private Integer examPaperNumber;

    private Integer examPaperDifficulty;

    private Integer examPaperPoint;

    private Integer examPaperTime;

    public Integer getExamPaperNumber() {
        return examPaperNumber;
    }

    public void setExamPaperNumber(Integer examPaperNumber) {
        this.examPaperNumber = examPaperNumber;
    }

    public Integer getExamPaperDifficulty() {
        return examPaperDifficulty;
    }

    public void setExamPaperDifficulty(Integer examPaperDifficulty) {
        this.examPaperDifficulty = examPaperDifficulty;
    }

    public Integer getExamPaperPoint() {
        return examPaperPoint;
    }

    public void setExamPaperPoint(Integer examPaperPoint) {
        this.examPaperPoint = examPaperPoint;
    }

    public Integer getExamPaperTime() {
        return examPaperTime;
    }

    public void setExamPaperTime(Integer examPaperTime) {
        this.examPaperTime = examPaperTime;
    }
}