package com.onlineExam.web.dao;


import com.onlineExam.web.entity.ExamAnswer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamAnswerMapper {

    List<ExamAnswer> selectAll();

    List<ExamAnswer> selectByExam(int examNumber);

    List<ExamAnswer> selectByStudent(int studentNumber);

    ExamAnswer selectByExamAnswer(int examAnswerNumber);

    void insertExamAnswer(ExamAnswer examAnswer);

    void updateExamAnswer(ExamAnswer examAnswer);

    void deleteExamAnswer(int examAnswerNumber);

}
