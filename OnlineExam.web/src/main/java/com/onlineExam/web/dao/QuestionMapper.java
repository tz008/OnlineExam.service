package com.onlineExam.web.dao;


import com.onlineExam.web.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    List<Question> selectAll();

    Question selectByQuestionNumber(int questionNumber);

    List<Question> selectByDifficulty(int questionDifficulty);

    List<Question> selectByKnowledge(String questionKnowledge);

    void insertQuestion(Question question);

    void updateQuestion(Question question);

    void deleteQuestion(int questionNumber);

    Question selectByExamPaper(int id);

}