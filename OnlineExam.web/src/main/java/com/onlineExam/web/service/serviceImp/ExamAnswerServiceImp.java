package com.onlineExam.web.service.serviceImp;

import com.onlineExam.web.dao.ExamAnswerMapper;
import com.onlineExam.web.entity.ExamAnswer;
import com.onlineExam.web.service.ExamAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamAnswerServiceImp implements ExamAnswerService {

    @Autowired(required = false)
    ExamAnswerMapper examAnswerMapper;

    @Override
    public List<ExamAnswer> selectAll() {
        return examAnswerMapper.selectAll();
    }

    @Override
    public List<ExamAnswer> selectByExam(int examNumber) {
        return examAnswerMapper.selectByExam(examNumber);
    }

    @Override
    public List<ExamAnswer> selectByStudent(int studentNumber) {
        return examAnswerMapper.selectByStudent(studentNumber);
    }

    @Override
    public ExamAnswer selectByExamAnswer(int examAnswerNumber) {
        return examAnswerMapper.selectByExamAnswer(examAnswerNumber);
    }

    @Override
    public void insertExamAnswer(ExamAnswer examAnswer) {
        examAnswerMapper.insertExamAnswer(examAnswer);
    }

    @Override
    public void updateExamAnswer(ExamAnswer examAnswer) {
        examAnswerMapper.updateExamAnswer(examAnswer);
    }

    @Override
    public void deleteExamAnswer(int examAnswerNumber) {
        examAnswerMapper.deleteExamAnswer(examAnswerNumber);
    }
}
