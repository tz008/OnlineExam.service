package com.onlineExam.web.dao;


import com.onlineExam.web.entity.ExamPaperQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamPaperQuestionMapper {

    List<ExamPaperQuestion> selectAll();

    ExamPaperQuestion selectByExamPaperQuestionId(int examPaperQuestionId);

    List<ExamPaperQuestion> selectByExamQuestionNumber(int examQuestionNumber);

    List<ExamPaperQuestion> selectByExamPaperNumber(int examPaperNumber);

    void updateExamPaperQuestion(ExamPaperQuestion examPaperQuestion);

    void insertExamPaperQuestion(ExamPaperQuestion examPaperQuestion);
}
