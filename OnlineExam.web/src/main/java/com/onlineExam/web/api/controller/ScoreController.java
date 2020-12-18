package com.onlineExam.web.api.controller;


import com.OnlineExam.JsonResult;
import com.onlineExam.web.entity.Score;
import com.onlineExam.web.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "score接口")
@RequestMapping("/ScoreController")
@CrossOrigin
@RestController
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @ApiOperation("得到分数")
    @GetMapping("/getAll")
    public JsonResult<List<Score>> selectAll(){
        return new JsonResult<>(scoreService.selectAll());
    }

    @ApiOperation("根据分数id得到分数")
    @PostMapping("/selectByPointId")
    public JsonResult selectByPointId(@RequestBody int pointId){
        JsonResult jsonResult = new JsonResult();
        Score score = scoreService.selectByPointId(pointId);
        if(score == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此分数");
        }else {
            jsonResult.setData(score);
        }
        return jsonResult;
    }

    @ApiOperation("根据答题卡号得到分数")
    @PostMapping("/selectByExamAnswerNumber")
    public JsonResult selectByExamAnswerNumber(@RequestBody int examAnswerNumber){
        JsonResult jsonResult = new JsonResult();
        Score score = scoreService.selectByExamAnswer(examAnswerNumber);
        if(score == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此分数");
        }else {
            jsonResult.setData(score);
        }
        return jsonResult;
    }

    @ApiOperation("增加分数记录")
    @PostMapping("/insert")
    public JsonResult insert(@RequestBody Score score){
        JsonResult jsonResult = new JsonResult();
        scoreService.insert(score);
        jsonResult.setCode(1000);
        jsonResult.setMsg("DB.INSERT.SUCCESS");
        return jsonResult;
    }

    @ApiOperation("修改分数记录")
    @PostMapping("/update")
    public JsonResult update(@RequestBody Score score){
        JsonResult jsonResult = new JsonResult();
        Score selectScore = scoreService.selectByExamAnswer(score.getPointId());
        if(selectScore == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此分数");
        }else {
            scoreService.update(score);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("删除分数记录")
    @PostMapping("/delete")
    public JsonResult delete(@RequestBody int pointId){
        JsonResult jsonResult = new JsonResult();
        Score selectScore = scoreService.selectByExamAnswer(pointId);
        if(selectScore == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此分数");
        }else {
            scoreService.delete(pointId);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.DELETE.SUCCESS");
        }
        return jsonResult;
    }
}
