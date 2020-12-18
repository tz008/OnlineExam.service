package com.onlineExam.web.service;

import com.onlineExam.web.entity.ExamAnswer;

import java.util.List;

public interface ExamAnswerService {

    List<ExamAnswer> selectAll();

    List<ExamAnswer> selectByExam(int examNumber);

    List<ExamAnswer> selectByStudent(int studentNumber);

    ExamAnswer selectByExamAnswer(int examAnswerNumber);

    void insertExamAnswer(ExamAnswer examAnswer);

    void updateExamAnswer(ExamAnswer examAnswer);

    void deleteExamAnswer(int examAnswerNumber);

    void updatePoint(ExamAnswer examAnswer);

}
