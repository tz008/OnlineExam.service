package com.onlineExam.web.api.controller;


import com.OnlineExam.JsonResult;
import com.onlineExam.web.entity.ExamPaper;
import com.onlineExam.web.entity.ExamPaperQuestion;
import com.onlineExam.web.entity.Question;
import com.onlineExam.web.service.ExamPaperQuestionService;
import com.onlineExam.web.service.ExamPaperService;
import com.onlineExam.web.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Random;

@Api(tags = "examPaper接口")
@RequestMapping("/ExamPaperController")
@CrossOrigin
@RestController
public class ExamPaperController {

    @Autowired
    ExamPaperService examPaperService;

    @Autowired
    ExamPaperQuestionService examPaperQuestionService;

    @Autowired
    QuestionService questionService;

    @ApiOperation("得到全部试卷")
    @GetMapping("/getAllExamPaper")
    public JsonResult<List<ExamPaper>> selectAll(){
        return new JsonResult<>(examPaperService.selectAll());
    }

    @ApiOperation("根据试卷号得到试卷")
    @PostMapping("/selectByExamPaperNumber")
    public JsonResult selectByExamPaperNumber(@RequestBody int examPaperNumber){
        JsonResult jsonResult = new JsonResult();
        ExamPaper examPaper = examPaperService.selectByExamPaperNumber(examPaperNumber);
        if(examPaper != null){
            jsonResult.setData(examPaper);
        }else {
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此试卷");
        }
        return jsonResult;
    }

    @ApiOperation("根据试卷难度得到试卷")
    @PostMapping("/selectByDifficulty")
    public JsonResult selectByDifficulty(@RequestBody int examPaperDifficulty){
        JsonResult jsonResult = new JsonResult();
        List<ExamPaper> examPaperList = examPaperService.selectByDifficulty(examPaperDifficulty);
        if(examPaperList.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此难度的试卷");
        }else {
            jsonResult.setData(examPaperList);
        }
        return jsonResult;
    }

    @ApiOperation("增加试卷")
    @PostMapping("/insertExamPaper")
    public JsonResult insertExamPaper(@RequestBody ExamPaper examPaper){
        JsonResult jsonResult = new JsonResult();
//        ExamPaper selectExamPaper = examPaperService.selectByExamPaperNumber(examPaper.getExamPaperNumber());
//        if(selectExamPaper != null){
//            jsonResult.setCode(1001);
//            jsonResult.setMsg("此试卷已存在");
//        }else {
//
//        }
        examPaperService.insertExamPaper(examPaper);

//        新试卷添加试题
        List<ExamPaper> examPaperList = examPaperService.selectAll();
        List<Question> questionList = questionService.selectAll();
        int examPaperNumber = examPaperList.get(examPaperList.size()-1).getExamPaperNumber();
        List<ExamPaperQuestion> examPaperQuestionList = examPaperQuestionService.selectByExamPaperNumber(examPaperNumber);
        Random r = new Random();
//        保证试卷有5道题
        while (examPaperQuestionList.size() < 5){
            int number = r.nextInt(questionList.size()-1);
            int questionNumber = questionList.get(number).getQuestionNumber();
//            不能有相同的题目加入
            ExamPaperQuestion examPaperQuestion = new ExamPaperQuestion(questionNumber,examPaperNumber);
            examPaperQuestionService.insertExamPaperQuestion(examPaperQuestion);
//            更新该试卷的题目
            examPaperQuestionList = examPaperQuestionService.selectByExamPaperNumber(examPaperNumber);
        }

        jsonResult.setCode(1000);
        jsonResult.setMsg("DB.INSERT.SUCCESS");
        return jsonResult;
    }

    @ApiOperation("修改试卷")
    @PostMapping("/updateExamPaper")
    public JsonResult updateExamPaper(@RequestBody ExamPaper examPaper){
        JsonResult jsonResult = new JsonResult();
        ExamPaper selectExamPaper = examPaperService.selectByExamPaperNumber(examPaper.getExamPaperNumber());
        if(selectExamPaper == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此试卷");
        }else {
            examPaperService.updateExamPaper(examPaper);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("删除试卷")
    @GetMapping("/deleteExamPaper")
    public JsonResult deleteExamPaper( String examPaperNumber){
        JsonResult jsonResult = new JsonResult();
        ExamPaper selectExamPaper = examPaperService.selectByExamPaperNumber(Integer.parseInt(examPaperNumber));
        if(selectExamPaper == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此试卷");
        }else {
            examPaperService.deleteExamPaper(Integer.parseInt(examPaperNumber));
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.DELETE.SUCCESS");
        }
        return jsonResult;
    }


}
