package com.onlineExam.web.dao;


import com.onlineExam.web.entity.ExamPaper;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface ExamPaperMapper {

    List<ExamPaper> selectAll();

    ExamPaper selectByExamPaperNumber(int examPaperNumber);

    List<ExamPaper> selectByDifficulty(int examPaperDifficulty);

    //    设置试卷难度，总分，解题时间生成试卷
    void insertExamPaper(ExamPaper examPaper);

    void updateExamPaper(ExamPaper examPaper);

//    根据试卷号更新试卷的难度，分值
    void updateByExamPaper(int examPaperNumber);

    void deleteExamPaper(int examPaperNumber);

}