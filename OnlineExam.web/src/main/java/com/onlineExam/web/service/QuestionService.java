package com.onlineExam.web.service;

import com.onlineExam.web.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> selectAll();

    Question selectByQuestionNumber(int questionNumber);

    List<Question> selectByDifficulty(int questionDifficulty);

    List<Question> selectByKnowledge(String questionKnowledge);

    void insertQuestion(Question question);

    void updateQuestion(Question question);

    void deleteQuestion(int questionNumber);

    Question selectByExamPaper(int id);

}
