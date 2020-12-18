package com.onlineExam.web.api.controller;


import com.OnlineExam.JsonResult;
import com.onlineExam.web.entity.ExamAnswer;
import com.onlineExam.web.entity.ExamPaperAnswer;
import com.onlineExam.web.entity.Question;
import com.onlineExam.web.service.ExamAnswerService;
import com.onlineExam.web.service.ExamPaperAnswerService;
import com.onlineExam.web.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "examPaperAnswer接口")
@RequestMapping("/ExamPaperAnswerController")
@CrossOrigin
@RestController
public class ExamPaperAnswerController {

    @Autowired
    ExamPaperAnswerService examPaperAnswerService;

    @Autowired
    QuestionService questionService;

    @Autowired
    ExamAnswerService examAnswerService;

    @ApiOperation("得到考生答案")
    @GetMapping("/getAll")
    public JsonResult<List<ExamPaperAnswer>> selectAll(){
        return new JsonResult<>(examPaperAnswerService.selectAll());
    }

    @ApiOperation("根据答卷号查找答案")
    @PostMapping("/selectByExamAnswer")
    public JsonResult selectByExamAnswer(@RequestBody int examPaperAnswerId){
        JsonResult jsonResult = new JsonResult();
        ExamPaperAnswer examPaperAnswer = examPaperAnswerService.selectByExamPaperAnswerId(examPaperAnswerId);
        if(examPaperAnswer == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此考生的答案");
        }else {
            jsonResult.setData(examPaperAnswer);
        }
        return jsonResult;
    }

    @ApiOperation("根据试卷题目号查找答案")
    @PostMapping("/selectByExam")
    public JsonResult selectByExam(@RequestBody int examPaperQuestionId){
        JsonResult jsonResult = new JsonResult();
        List<ExamPaperAnswer> examPaperAnswer = examPaperAnswerService.selectByExam(examPaperQuestionId);
        if(examPaperAnswer.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此考考试的答案");
        }else {
            jsonResult.setData(examPaperAnswer);
        }
        return jsonResult;
    }


    @ApiOperation("增加答案")
    @PostMapping("/insert")
    public JsonResult insert(@RequestBody ExamPaperAnswer examPaperAnswer){
        JsonResult jsonResult = new JsonResult();
//        ExamPaperAnswer selectExamPaperAnswer = examPaperAnswerService.selectByExamPaperAnswerId(examPaperAnswer.getExamPaperAnswerId());
//        if(selectExamPaperAnswer != null){
//            jsonResult.setCode(1001);
//            jsonResult.setMsg("此答案已存在");
//        }else {
//            examPaperAnswerService.insert(examPaperAnswer);
//            jsonResult.setCode(1000);
//            jsonResult.setMsg("DB.INSERT.SUCCESS");
//        }
        examPaperAnswerService.insert(examPaperAnswer);
        jsonResult.setCode(1000);
        jsonResult.setMsg("DB.INSERT.SUCCESS");
        return jsonResult;
    }

    @ApiOperation("修改答案/批改主观题")
    @PostMapping("/update")
    public JsonResult update(@RequestBody ExamPaperAnswer examPaperAnswer){
        JsonResult jsonResult = new JsonResult();
        ExamPaperAnswer selectExamPaperAnswer = examPaperAnswerService.selectByExamPaperAnswerId(examPaperAnswer.getExamPaperAnswerId());
        if(selectExamPaperAnswer == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此答案不存在");
        }else {
            examPaperAnswerService.update(examPaperAnswer);
            //                修改该考生主观题总分
            ExamAnswer examAnswer = new ExamAnswer();
            examAnswer.setExamAnswerNumber(examPaperAnswer.getExamAnswerNumber());
            examAnswer.setExamObjectivePoint(0);
            examAnswer.setExamSubjectivePoint(examPaperAnswer.getPoint());
            examAnswerService.updatePoint(examAnswer);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("删除答案")
    @PostMapping("/delete")
    public JsonResult delete(@RequestBody int examPaperAnswerId){
        JsonResult jsonResult = new JsonResult();
        ExamPaperAnswer selectExamPaperAnswer = examPaperAnswerService.selectByExamPaperAnswerId(examPaperAnswerId);
        if(selectExamPaperAnswer == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此答案不存在");
        }else {
            examPaperAnswerService.deleteByPrimaryKey(examPaperAnswerId);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.DELETE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("客观题自动批改")
    @GetMapping("/updatePoint")
    public JsonResult updatePoint(){
        JsonResult jsonResult = new JsonResult();
        List<ExamPaperAnswer> examPaperAnswerList = examPaperAnswerService.selectAll();
        for(int i = 0; i<examPaperAnswerList.size(); i++){
            ExamPaperAnswer examPaperAnswer = examPaperAnswerList.get(i);
            int id = examPaperAnswer.getExamPaperQuestionId();
            Question question = questionService.selectByExamPaper(id);
            String type = question.getQuestionType();
//            判断是否为客观题
            if(!type.equals("问答题")){
                String answer = question.getQuestionAnswer();
//                与标准答案做比较
                if(examPaperAnswer.getExamPaperAnswer().equals(answer)){
                    examPaperAnswer.setPoint(question.getQuestionPoint());
                }else {
                    examPaperAnswer.setPoint(0);
                }
                examPaperAnswerService.update(examPaperAnswer);
//                修改该考生客观题总分
                ExamAnswer examAnswer = new ExamAnswer();
                examAnswer.setExamAnswerNumber(examPaperAnswer.getExamAnswerNumber());
                examAnswer.setExamObjectivePoint(examPaperAnswer.getPoint());
                examAnswer.setExamSubjectivePoint(0);
                examAnswerService.updatePoint(examAnswer);
            }

        }
        return jsonResult;
    }

}
