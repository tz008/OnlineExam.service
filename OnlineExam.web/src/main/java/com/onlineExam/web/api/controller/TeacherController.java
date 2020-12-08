package com.onlineExam.web.api.controller;



import com.OnlineExam.JsonResult;
import com.OnlineExam.ResultCode;
import com.onlineExam.web.entity.Teacher;
import com.onlineExam.web.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "teacher接口")
@RequestMapping("/TeacherController")
@CrossOrigin
@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @ApiOperation("查找全部老师")
    @GetMapping("/getAllTeacher")
    public JsonResult<List<Teacher>> selectAll(){
       return new JsonResult<>(teacherService.selectAll());
    }

    @ApiOperation("根据学号查找老师")
    @PostMapping("/selectByTeacherNumber")
    public JsonResult selectByTeacherNumber(@RequestBody int teacherNumber){
        Teacher teacher = teacherService.selectByTeacherNumber(teacherNumber);
        JsonResult jsonResult = new JsonResult();
        if(teacher!=null){
            jsonResult.setData(teacher);
        }else {
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此老师");
        }
        return jsonResult;
    }

    @ApiOperation("根据账号找密码")
    @PostMapping("/getPassword")
    public JsonResult getPassword(@RequestBody int teacherNumber){
        String password = teacherService.getPassword(teacherNumber);
        JsonResult jsonResult = new JsonResult();
        if(password!=null){
            jsonResult.setData(password);
        }else {
            jsonResult.setCode(1001);
            jsonResult.setMsg("账号不存在");
        }
        return jsonResult;
    }

    @ApiOperation("增加老师")
    @PostMapping("/insertTeacher")
    public JsonResult insertTeacher(@RequestBody Teacher teacher){
        JsonResult jsonResult = new JsonResult();
        Teacher selectTeacher = teacherService.selectByTeacherNumber(teacher.getTeacherNumber());
        if(selectTeacher != null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此老师已存在");
        }else {
            teacherService.insertTeacher(teacher);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.INSERT.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("修改老师")
    @PostMapping("/updateTeacher")
    public JsonResult updateTeacher(@RequestBody Teacher teacher){
        JsonResult jsonResult = new JsonResult();
        Teacher selectTeacher = teacherService.selectByTeacherNumber(teacher.getTeacherNumber());
        if(selectTeacher == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此老师不存在");
        }else {
            teacherService.updateTeacher(teacher);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("删除老师")
    @PostMapping("/deleteTeacher")
    public JsonResult deleteTeacher(@RequestBody int teacherNumber){
        JsonResult jsonResult = new JsonResult();
        Teacher selectTeacher = teacherService.selectByTeacherNumber(teacherNumber);
        if(selectTeacher == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此老师不存在");
        }else {
            teacherService.deleteTeacher(teacherNumber);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.DELETE.SUCCESS");
        }
        return jsonResult;
    }


}
