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

import java.util.ArrayList;
import java.util.List;

@Api(tags = "question接口")
@RequestMapping("/QuestionController")
@CrossOrigin
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    ExamPaperService examPaperService;

    @Autowired
    ExamPaperQuestionService examPaperQuestionService;

    @ApiOperation("得到全部题")
    @GetMapping("/getAllQuestion")
    public JsonResult<List<Question>> selectAll(){
        return new JsonResult<>(questionService.selectAll());
    }

    @ApiOperation("/根据题号查找题")
    @PostMapping("selectByQuestionNumber")
    public JsonResult selectByQuestionNumber(@RequestBody int questionNumber){
        JsonResult jsonResult = new JsonResult();
        Question question = questionService.selectByQuestionNumber(questionNumber);
        if(question != null){
            jsonResult.setData(question);
        }else {
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此题");
        }
        return jsonResult;
    }

    @ApiOperation("根据试卷号查找对应题目")
    @PostMapping("/selectByExamPaper")
    public JsonResult selectByExamPaper(@RequestBody int examPaperNumber){
        JsonResult jsonResult = new JsonResult();
        ExamPaper examPaper = examPaperService.selectByExamPaperNumber(examPaperNumber);
        if(examPaper ==  null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此试卷");
        }
        List<ExamPaperQuestion> examPaperQuestionList = examPaperQuestionService.selectByExamPaperNumber(examPaperNumber);
        if(examPaperQuestionList.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此试卷对应的题目");
        }
        List<Question> questionList = new ArrayList<>();
        for(int i=0; i<examPaperQuestionList.size(); i++){
            Question question = questionService.selectByQuestionNumber(examPaperQuestionList.get(i).getExamQuestionNumber());
            questionList.add(question);
        }
        jsonResult.setData(questionList);
        return jsonResult;
    }

    @ApiOperation("根据难度查找题")
    @PostMapping("/selectByDifficulty")
    public JsonResult selectByDifficulty(@RequestBody int questionDifficulty){
        JsonResult jsonResult = new JsonResult();
        List<Question> question = questionService.selectByDifficulty(questionDifficulty);
        if(question.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此难度的题");
        }else {
            jsonResult.setData(question);
        }
        return jsonResult;
    }

    @ApiOperation("根据知识点查找题")
    @PostMapping("/selectByKnowledge")
    public JsonResult selectByKnowledge(@RequestBody String questionKnowledge){
        JsonResult jsonResult = new JsonResult();
        List<Question> question = questionService.selectByKnowledge(questionKnowledge);
        if(question.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有关于此知识点的题");
        }else {
            jsonResult.setData(question);
        }
        return jsonResult;
    }

    @ApiOperation("增加题")
    @PostMapping("/insertQuestion")
    public JsonResult insertQuestion(@RequestBody Question question){
        JsonResult jsonResult = new JsonResult();
        Question selectQuestion = questionService.selectByQuestionNumber(question.getQuestionNumber());
        if(selectQuestion != null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("该题已存在");
        }else {
            questionService.insertQuestion(question);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.INSERT.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("修改题目")
    @PostMapping("/updateQuestion")
    public JsonResult updateQuestion(@RequestBody Question question){
        JsonResult jsonResult = new JsonResult();
        Question selectQuestion = questionService.selectByQuestionNumber(question.getQuestionNumber());
        if(selectQuestion == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("该题不存在");
        }else {
            questionService.updateQuestion(question);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("删除题目")
    @GetMapping("/deleteQuestion")
    public JsonResult deleteQuestion( String questionNumber){
        JsonResult jsonResult = new JsonResult();
        Question selectQuestion = questionService.selectByQuestionNumber(Integer.parseInt(questionNumber));
        if(selectQuestion == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("该题不存在");
        }else {
            questionService.deleteQuestion(Integer.parseInt(questionNumber));
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.DELETE.SUCCESS");
        }
        return jsonResult;
    }
}
