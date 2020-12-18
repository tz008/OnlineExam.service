package com.onlineExam.web.entity;

public class Score {
    private Integer pointId;

    private Integer examAnswerNumber;

    private Integer point;

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Integer getExamAnswerNumber() {
        return examAnswerNumber;
    }

    public void setExamAnswerNumber(Integer examAnswerNumber) {
        this.examAnswerNumber = examAnswerNumber;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}