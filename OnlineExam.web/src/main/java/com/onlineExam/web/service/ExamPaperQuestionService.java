package com.onlineExam.web.service;

import com.onlineExam.web.entity.ExamPaperQuestion;

import java.util.List;

public interface ExamPaperQuestionService {

    List<ExamPaperQuestion> selectAll();

    ExamPaperQuestion selectByExamPaperQuestionId(int examPaperQuestionId);

    List<ExamPaperQuestion> selectByExamQuestionNumber(int examQuestionNumber);

    List<ExamPaperQuestion> selectByExamPaperNumber(int examPaperNumber);

    void updateExamPaperQuestion(ExamPaperQuestion examPaperQuestion);

    void insertExamPaperQuestion(ExamPaperQuestion examPaperQuestion);
}
