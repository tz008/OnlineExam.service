package com.onlineExam.web.service;

import com.onlineExam.web.entity.ExamPaperAnswer;

import java.util.List;

public interface ExamPaperAnswerService {

    List<ExamPaperAnswer> selectAll();

    //    参加考试编号查找学生的回答答案
    ExamPaperAnswer selectByExamPaperAnswerId(int examPaperAnswerId);

    List<ExamPaperAnswer> selectByExam(int examPaperQuestionId);

    void deleteByPrimaryKey(int examPaperAnswerId);

    void insert(ExamPaperAnswer examPaperAnswer);

    void update(ExamPaperAnswer examPaperAnswer);
}
