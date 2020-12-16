package com.onlineExam.web.service.serviceImp;

import com.onlineExam.web.dao.ExamSetMapper;
import com.onlineExam.web.entity.ExamSet;
import com.onlineExam.web.service.ExamSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamSetServiceImp implements ExamSetService {

    @Autowired(required = false)
    ExamSetMapper examSetMapper;

    @Override
    public List<ExamSet> selectAll() {
        return examSetMapper.selectAll();
    }

    @Override
    public ExamSet selectByExamSetNumber(int examSetNumber) {
        return examSetMapper.selectByExamSetNumber(examSetNumber);
    }

    @Override
    public List<ExamSet> selectByTeacher(int teacherNumber) {
        return examSetMapper.selectByTeacher(teacherNumber);
    }

    @Override
    public ExamSet selectByExamPaper(int examPaperNumber) {
        return examSetMapper.selectByExamPaper(examPaperNumber);
    }

    @Override
    public void updateExamSet(ExamSet examSet) {
        examSetMapper.updateExamSet(examSet);
    }

    @Override
    public void insertExamSet(ExamSet examSet) {
        examSetMapper.insertExamSet(examSet);
    }

    @Override
    public void deleteExamSet(int examSetNumber) {
        examSetMapper.deleteExamSet(examSetNumber);
    }
}
