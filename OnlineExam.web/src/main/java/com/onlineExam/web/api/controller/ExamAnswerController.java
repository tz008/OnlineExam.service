package com.onlineExam.web.api.controller;


import com.OnlineExam.JsonResult;
import com.onlineExam.web.entity.ExamAnswer;
import com.onlineExam.web.service.ExamAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "examAnswer接口")
@RequestMapping("/ExamAnswerController")
@CrossOrigin
@RestController
public class ExamAnswerController {

    @Autowired
    ExamAnswerService examAnswerService;

    @ApiOperation("得到全部答卷")
    @GetMapping("/getAll")
    public JsonResult<List<ExamAnswer>> selectAll(){
        return new JsonResult<>(examAnswerService.selectAll());
    }

    @ApiOperation("根据考试得到答卷")
    @PostMapping("/selectByExam")
    public JsonResult selectByExam(@RequestBody int examNumber){
        JsonResult jsonResult = new JsonResult();
        List<ExamAnswer> examAnswerList = examAnswerService.selectByExam(examNumber);
        if(examAnswerList.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此考试的答卷");
        }else {
            jsonResult.setData(examAnswerList);
        }
        return jsonResult;
    }

    @ApiOperation("根据考生得到答卷")
    @PostMapping("/selectByStudent")
    public JsonResult selectByStudent(@RequestBody int studentNumber){
        JsonResult jsonResult = new JsonResult();
        List<ExamAnswer> examAnswerList = examAnswerService.selectByStudent(studentNumber);
        if(examAnswerList.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此考生的答卷");
        }else {
            jsonResult.setData(examAnswerList);
        }
        return jsonResult;
    }

    //    主键带自增的INSERT
    @ApiOperation("增加答卷")
    @PostMapping("/insertExamAnswer")
    public JsonResult insertExamAnswer(@RequestBody ExamAnswer examAnswer){
        JsonResult jsonResult = new JsonResult();
//        ExamAnswer selectExamAnswer = examAnswerService.selectByExamAnswer(examAnswer.getExamAnswerNumber());
//        if(selectExamAnswer != null){
//            jsonResult.setCode(1001);
//            jsonResult.setMsg("此答卷已存在");
//        }else {
//            examAnswerService.insertExamAnswer(examAnswer);
//            jsonResult.setCode(1000);
//            jsonResult.setMsg("DB.INSERT.SUCCESS");
//        }
        examAnswerService.insertExamAnswer(examAnswer);
        jsonResult.setCode(1000);
        jsonResult.setMsg("DB.INSERT.SUCCESS");
        return jsonResult;
    }

    @ApiOperation("修改答卷")
    @PostMapping("/updateExamAnswer")
    public JsonResult updateExamAnswer(@RequestBody ExamAnswer examAnswer){
        JsonResult jsonResult = new JsonResult();
        ExamAnswer selectExamAnswer = examAnswerService.selectByExamAnswer(examAnswer.getExamAnswerNumber());
        if(selectExamAnswer == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此答卷不存在");
        }else {
            examAnswerService.updateExamAnswer(examAnswer);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("删除答卷")
    @GetMapping("/deleteExamAnswer")
    public JsonResult deleteExamAnswer( String examAnswerNumber){
        JsonResult jsonResult = new JsonResult();
        ExamAnswer selectExamAnswer = examAnswerService.selectByExamAnswer(Integer.parseInt(examAnswerNumber));
        if(selectExamAnswer == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此答卷不存在");
        }else {
            examAnswerService.deleteExamAnswer(Integer.parseInt(examAnswerNumber));
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.DELETE.SUCCESS");
        }
        return jsonResult;
    }


}
