package com.onlineExam.web.dao;


import com.onlineExam.web.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {

    List<Score> selectAll();

    Score selectByPointId(int pointId);

    Score selectByExamAnswer(int examAnswerNumber);

    void insert(Score score);

    void update(Score score);

    void delete(int pointId);


}