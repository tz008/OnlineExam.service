package com.onlineExam.web.service.serviceImp;


import com.onlineExam.web.dao.ScoreMapper;
import com.onlineExam.web.entity.Score;
import com.onlineExam.web.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImp implements ScoreService {

    @Autowired(required = false)
    ScoreMapper scoreMapper;

    @Override
    public List<Score> selectAll() {
        return scoreMapper.selectAll();
    }

    @Override
    public Score selectByPointId(int pointId) {
        return scoreMapper.selectByPointId(pointId);
    }

    @Override
    public Score selectByExamAnswer(int examAnswerNumber) {
        return scoreMapper.selectByExamAnswer(examAnswerNumber);
    }

    @Override
    public List<Score> selectByStudent(int studentNumber) {
        return scoreMapper.selectByStudent(studentNumber);
    }

    @Override
    public void insert(Score score) {
        scoreMapper.insert(score);
    }

    @Override
    public void update(Score score) {
        scoreMapper.update(score);
    }

    @Override
    public void delete(int pointId) {
        scoreMapper.delete(pointId);
    }
}
