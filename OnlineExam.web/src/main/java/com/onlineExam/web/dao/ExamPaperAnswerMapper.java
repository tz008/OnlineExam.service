package com.onlineExam.web.dao;


import com.onlineExam.web.entity.ExamPaperAnswer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamPaperAnswerMapper {

    List<ExamPaperAnswer> selectAll();

    ExamPaperAnswer selectByExamPaperAnswerId(int examPaperAnswerId);

    List<ExamPaperAnswer> selectByExam(int examPaperQuestionId);

    void deleteByPrimaryKey(int examPaperAnswerId);

    void insert(ExamPaperAnswer examPaperAnswer);

    void update(ExamPaperAnswer examPaperAnswer);

}