package com.onlineExam.web.service.serviceImp;

import com.onlineExam.web.dao.ExamPaperAnswerMapper;
import com.onlineExam.web.entity.ExamPaperAnswer;
import com.onlineExam.web.service.ExamPaperAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamPaperAnswerServiceImp implements ExamPaperAnswerService {

    @Autowired(required = false)
    ExamPaperAnswerMapper examPaperAnswerMapper;

    @Override
    public List<ExamPaperAnswer> selectAll() {
        return examPaperAnswerMapper.selectAll();
    }

    @Override
    public ExamPaperAnswer selectByExamPaperAnswerId(int examPaperAnswerId) {
        return examPaperAnswerMapper.selectByExamPaperAnswerId(examPaperAnswerId);
    }

    @Override
    public List<ExamPaperAnswer> selectByExam(int examPaperQuestionId) {
        return examPaperAnswerMapper.selectByExam(examPaperQuestionId);
    }

    @Override
    public void deleteByPrimaryKey(int examPaperAnswerId) {
        examPaperAnswerMapper.deleteByPrimaryKey(examPaperAnswerId);
    }

    @Override
    public void insert(ExamPaperAnswer examPaperAnswer) {
        examPaperAnswerMapper.insert(examPaperAnswer);
    }

    @Override
    public void update(ExamPaperAnswer examPaperAnswer) {
        examPaperAnswerMapper.update(examPaperAnswer);
    }
}
