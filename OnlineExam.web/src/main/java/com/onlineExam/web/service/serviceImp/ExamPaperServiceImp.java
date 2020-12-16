package com.onlineExam.web.service.serviceImp;

import com.onlineExam.web.dao.ExamPaperMapper;
import com.onlineExam.web.entity.ExamPaper;
import com.onlineExam.web.service.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExamPaperServiceImp implements ExamPaperService {

    @Autowired(required = false)
    ExamPaperMapper examPaperMapper;

    @Override
    public List<ExamPaper> selectAll() {
        return examPaperMapper.selectAll();
    }

    @Override
    public ExamPaper selectByExamPaperNumber(int examPaperNumber) {
        return examPaperMapper.selectByExamPaperNumber(examPaperNumber);
    }

    @Override
    public List<ExamPaper> selectByDifficulty(int examPaperDifficulty) {
        return examPaperMapper.selectByDifficulty(examPaperDifficulty);
    }

    @Override
    public void insertExamPaper(ExamPaper examPaper) {
        examPaperMapper.insertExamPaper(examPaper);
    }

    @Override
    public void updateExamPaper(ExamPaper examPaper) {
        examPaperMapper.updateExamPaper(examPaper);
    }

    @Override
    public void updateByExamPaper(int examPaperNumber) {
        examPaperMapper.updateByExamPaper(examPaperNumber);
    }

    @Override
    public void deleteExamPaper(int examPaperNumber) {
        examPaperMapper.deleteExamPaper(examPaperNumber);
    }
}
