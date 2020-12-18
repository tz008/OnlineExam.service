package com.onlineExam.web.service.serviceImp;


import com.onlineExam.web.dao.QuestionMapper;
import com.onlineExam.web.entity.Question;
import com.onlineExam.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    @Autowired(required = false)
    QuestionMapper questionMapper;


    @Override
    public List<Question> selectAll() {
        return questionMapper.selectAll();
    }

    @Override
    public Question selectByQuestionNumber(int questionNumber) {
        return questionMapper.selectByQuestionNumber(questionNumber);
    }

    @Override
    public List<Question> selectByDifficulty(int questionDifficulty) {
        return questionMapper.selectByDifficulty(questionDifficulty);
    }

    @Override
    public List<Question> selectByKnowledge(String questionKnowledge) {
        return questionMapper.selectByKnowledge(questionKnowledge);
    }

    @Override
    public void insertQuestion(Question question) {
        questionMapper.insertQuestion(question);
    }

    @Override
    public void updateQuestion(Question question) {
        questionMapper.updateQuestion(question);
    }

    @Override
    public void deleteQuestion(int questionNumber) {
        questionMapper.deleteQuestion(questionNumber);
    }

    @Override
    public Question selectByExamPaper(int id) {
        return questionMapper.selectByExamPaper(id);
    }

}
