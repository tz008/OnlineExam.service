package com.onlineExam.web.dao;


import com.onlineExam.web.entity.ExamSet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamSetMapper {

    List<ExamSet> selectAll();

    ExamSet selectByExamSetNumber(int examSetNumber);

    List<ExamSet> selectByTeacher(int teacherNumber);

    ExamSet selectByExamPaper(int examPaperNumber);

    void updateExamSet(ExamSet examSet);

    void insertExamSet(ExamSet examSet);

    void deleteExamSet(int examSetNumber);

}