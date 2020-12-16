package com.onlineExam.web.service;

import com.onlineExam.web.entity.ExamSet;

import java.util.List;

public interface ExamSetService {

    List<ExamSet> selectAll();

    ExamSet selectByExamSetNumber(int examSetNumber);

    List<ExamSet> selectByTeacher(int teacherNumber);

    ExamSet selectByExamPaper(int examPaperNumber);

    void updateExamSet(ExamSet examSet);

    void insertExamSet(ExamSet examSet);

    void deleteExamSet(int examSetNumber);
}
