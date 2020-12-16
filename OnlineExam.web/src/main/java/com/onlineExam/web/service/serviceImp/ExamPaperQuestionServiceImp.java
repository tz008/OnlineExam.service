package com.onlineExam.web.service.serviceImp;


import com.onlineExam.web.dao.ExamPaperQuestionMapper;
import com.onlineExam.web.entity.ExamPaperQuestion;
import com.onlineExam.web.service.ExamPaperQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamPaperQuestionServiceImp implements ExamPaperQuestionService {

    @Autowired(required = false)
    ExamPaperQuestionMapper examPaperQuestionMapper;

    @Override
    public List<ExamPaperQuestion> selectAll() {
        return examPaperQuestionMapper.selectAll();
    }

    @Override
    public ExamPaperQuestion selectByExamPaperQuestionId(int examPaperQuestionId) {
        return examPaperQuestionMapper.selectByExamPaperQuestionId(examPaperQuestionId);
    }

    @Override
    public List<ExamPaperQuestion> selectByExamQuestionNumber(int examQuestionNumber) {
        return examPaperQuestionMapper.selectByExamQuestionNumber(examQuestionNumber);
    }

    @Override
    public List<ExamPaperQuestion> selectByExamPaperNumber(int examPaperNumber) {
        return examPaperQuestionMapper.selectByExamPaperNumber(examPaperNumber);
    }

    @Override
    public void updateExamPaperQuestion(ExamPaperQuestion examPaperQuestion) {
        examPaperQuestionMapper.updateExamPaperQuestion(examPaperQuestion);
    }

    @Override
    public void insertExamPaperQuestion(ExamPaperQuestion examPaperQuestion) {
        examPaperQuestionMapper.insertExamPaperQuestion(examPaperQuestion);
    }
}
