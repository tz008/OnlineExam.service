package com.onlineExam.web.service;

import com.onlineExam.web.entity.Score;

import java.util.List;

public interface ScoreService {

    List<Score> selectAll();

    Score selectByPointId(int pointId);

    Score selectByExamAnswer(int examAnswerNumber);

    List<Score> selectByStudent(int studentNumber);

    void insert(Score score);

    void update(Score score);

    void delete(int pointId);
}
