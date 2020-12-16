package com.onlineExam.web.service;

import com.onlineExam.web.entity.ExamPaper;

import java.util.List;

public interface ExamPaperService {

    List<ExamPaper> selectAll();

    ExamPaper selectByExamPaperNumber(int examPaperNumber);

    List<ExamPaper> selectByDifficulty(int examPaperDifficulty);

    //    设置试卷难度，总分，解题时间生成试卷
    void insertExamPaper(ExamPaper examPaper);

    void updateExamPaper(ExamPaper examPaper);

    void updateByExamPaper(int examPaperNumber);

    void deleteExamPaper(int examPaperNumber);
}
