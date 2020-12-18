package com.onlineExam.web.api.controller;


import com.OnlineExam.JsonResult;
import com.onlineExam.web.entity.ExamAnswer;
import com.onlineExam.web.entity.ExamSet;
import com.onlineExam.web.service.ExamAnswerService;
import com.onlineExam.web.service.ExamPaperService;
import com.onlineExam.web.service.ExamSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "examSet接口")
@RequestMapping("/ExamSetController")
@CrossOrigin
@RestController
public class ExamSetController {

    @Autowired
    ExamSetService examSetService;

    @Autowired
    ExamPaperService examPaperService;

    @Autowired
    ExamAnswerService examAnswerService;

    @ApiOperation("得到全部管理员")
    @GetMapping("/getAll")
    public JsonResult<List<ExamSet>> selectAll(){
        return new JsonResult<>(examSetService.selectAll());
    }

    @ApiOperation("根据考试编号查找考试")
    @PostMapping("/selectByExamSetNumber")
    public JsonResult selectByExamSetNumber(@RequestBody int examSetNumber){
        JsonResult jsonResult = new JsonResult();
        ExamSet examSet = examSetService.selectByExamSetNumber(examSetNumber);
        if(examSet == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此考试");
        }else {
            jsonResult.setData(examSet);
        }
        return jsonResult;
    }

//    @ApiOperation("根据试卷查找考试")
//    @PostMapping("/selectByExamSetNumber")
//    public JsonResult selectByExamPaper(@RequestBody int examPaperNumber){
//        JsonResult jsonResult = new JsonResult();
//        ExamSet examSet = examSetService.selectByExamPaper(examPaperNumber);
//        if(examSet == null){
//            jsonResult.setCode(1001);
//            jsonResult.setMsg("没有此考试");
//        }else {
//            jsonResult.setData(examSet);
//        }
//        return jsonResult;
//    }

    @ApiOperation("根据老师查找考试")
    @PostMapping("/selectByTeacher")
    public JsonResult selectByTeacher(@RequestBody int teacherNumber){
        JsonResult jsonResult = new JsonResult();
        List<ExamSet> examSet = examSetService.selectByTeacher(teacherNumber);
        if(examSet.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此考试");
        }else {
            jsonResult.setData(examSet);
        }
        return jsonResult;
    }

    @ApiOperation("创建考试")
    @PostMapping("/insertExam")
    public JsonResult insertExam(@RequestBody ExamSet examSet){
        JsonResult jsonResult = new JsonResult();
        ExamSet selectExam = examSetService.selectByExamSetNumber(examSet.getExamSetNumber());
        if(selectExam != null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此考试已存在");
        }else {
            examSetService.insertExamSet(examSet);
//            为每个考生生成答题卡
            String[]  students = examSet.getExamStudentNumber().split(",");
            for(int i=0; i<students.length; i++){
                ExamAnswer examAnswer = new ExamAnswer();
                examAnswer.setExamNumber(examSet.getExamSetNumber());
                examAnswer.setExamStudentNumber(Integer.parseInt(students[i]));
                examAnswerService.insertExamAnswer(examAnswer);
            }
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.INSERT.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("修改考试")
    @PostMapping("/updateExam")
    public JsonResult updateExam(@RequestBody ExamSet examSet){
        JsonResult jsonResult = new JsonResult();
        ExamSet selectExam = examSetService.selectByExamSetNumber(examSet.getExamSetNumber());
        if(selectExam == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此考试不存在");
        }else {
            examSetService.updateExamSet(examSet);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("删除考试")
    @PostMapping("/deleteExam")
    public JsonResult deleteExam(@RequestBody int examSetNumber){
        JsonResult jsonResult = new JsonResult();
        ExamSet selectExam = examSetService.selectByExamSetNumber(examSetNumber);
        if(selectExam == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此考试不存在");
        }else {
            examSetService.deleteExamSet(examSetNumber);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.DELETE.SUCCESS");
        }
        return jsonResult;
    }

}