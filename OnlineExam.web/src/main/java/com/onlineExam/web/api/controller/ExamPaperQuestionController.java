package com.onlineExam.web.api.controller;


import com.OnlineExam.JsonResult;
import com.onlineExam.web.entity.ExamPaperQuestion;
import com.onlineExam.web.service.ExamPaperQuestionService;
import com.onlineExam.web.service.ExamPaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "examPaperQuestion接口")
@RequestMapping("/ExamPaperQuestionController")
@CrossOrigin
@RestController
public class ExamPaperQuestionController {

    @Autowired
    ExamPaperQuestionService examPaperQuestionService;

    @Autowired
    ExamPaperService examPaperService;

    @ApiOperation("得到全部试卷题目关系")
    @GetMapping("/getAll")
    public JsonResult<List<ExamPaperQuestion>> selectAll(){

        return new JsonResult<>(examPaperQuestionService.selectAll());
    }

    @ApiOperation("根据试卷题目号得到试卷题目对应关系")
    @PostMapping("/selectByExamPaperQuestionId")
    public JsonResult selectByExamPaperQuestionId(@RequestBody int examPaperQuestionId){
        JsonResult jsonResult = new JsonResult();
        ExamPaperQuestion examPaperQuestion = examPaperQuestionService.selectByExamPaperQuestionId(examPaperQuestionId);
        if(examPaperQuestion == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此关系");
        }else {
            jsonResult.setData(examPaperQuestion);
        }
        return jsonResult;
    }

    @ApiOperation("根据题目号得到试卷题目对应关系")
    @PostMapping("/selectByExamQuestionNumber")
    public JsonResult selectByExamQuestionNumber(@RequestBody int examQuestionNumber){
        JsonResult jsonResult = new JsonResult();
        List<ExamPaperQuestion> examPaperQuestion = examPaperQuestionService.selectByExamQuestionNumber(examQuestionNumber);
        if(examPaperQuestion.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此关系");
        }else {
            jsonResult.setData(examPaperQuestion);
        }
        return jsonResult;
    }

    @ApiOperation("根据试卷题目号得到试卷题目对应关系")
    @PostMapping("/selectByExamPaperNumber")
    public JsonResult selectByExamPaperNumber(@RequestBody int examPaperNumber){
        JsonResult jsonResult = new JsonResult();
        List<ExamPaperQuestion> examPaperQuestion = examPaperQuestionService.selectByExamPaperNumber(examPaperNumber);
        if(examPaperQuestion.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此关系");
        }else {
            jsonResult.setData(examPaperQuestion);
        }
        return jsonResult;
    }

    @ApiOperation("增加试卷题目关系")
    @PostMapping("/insertExamPaperQuestion")
    public JsonResult insertExamPaperQuestion(@RequestBody ExamPaperQuestion examPaperQuestion){
        JsonResult jsonResult = new JsonResult();
        ExamPaperQuestion selectExamPaperQuestion = examPaperQuestionService.selectByExamPaperQuestionId(examPaperQuestion.getExamPaperQuestionId());
        if(selectExamPaperQuestion != null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("关系已存在");
        }else {
            examPaperQuestionService.insertExamPaperQuestion(examPaperQuestion);
//            更新对应试卷的难度和分值
            examPaperService.updateByExamPaper(examPaperQuestion.getExamPaperNumber());
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.INSERT.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("修改试卷题目关系")
    @PostMapping("/updateExamPaperQuestion")
    public JsonResult updateExamPaperQuestion(@RequestBody ExamPaperQuestion examPaperQuestion){
        JsonResult jsonResult = new JsonResult();
        ExamPaperQuestion selectExamPaperQuestion = examPaperQuestionService.selectByExamPaperQuestionId(examPaperQuestion.getExamPaperQuestionId());
        if(selectExamPaperQuestion == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("关系不存在");
        }else {
            examPaperQuestionService.updateExamPaperQuestion(examPaperQuestion);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }
}
