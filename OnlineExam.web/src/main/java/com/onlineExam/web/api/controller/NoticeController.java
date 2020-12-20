package com.onlineExam.web.api.controller;


import com.OnlineExam.JsonResult;
import com.onlineExam.web.entity.Notice;
import com.onlineExam.web.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "notice接口")
@RequestMapping("/NoticeController")
@CrossOrigin
@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @ApiOperation("得到全部公告")
    @GetMapping("/getAll")
    public JsonResult<List<Notice>> selectAll(){
        return new JsonResult<>(noticeService.selectAll());
    }

    @ApiOperation("根据公告内容查找公告")
    @PostMapping("/selectByContent")
    public JsonResult selectByContent(@RequestBody String content){
        JsonResult jsonResult = new JsonResult();
        List<Notice> notice = noticeService.selectByContent(content);
        if(notice.isEmpty()){
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有找到相应公告");
        }else {
            jsonResult.setData(notice);
        }
        return jsonResult;
    }

    @ApiOperation("增加公告")
    @PostMapping("/insertNotice")
    public JsonResult insertNotice(@RequestBody Notice notice){
        JsonResult jsonResult = new JsonResult();
        Notice selectNotice = noticeService.selectByid(notice.getId());
        if(selectNotice != null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此公告已存在");
        }else {
            noticeService.insertNotice(notice);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.INSERT.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("修改公告")
    @PostMapping("/updateNotice")
    public JsonResult updateNotice(@RequestBody Notice notice){
        JsonResult jsonResult = new JsonResult();
        Notice selectNotice = noticeService.selectByid(notice.getId());
        if(selectNotice == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此公告不存在");
        }else {
            noticeService.updateNotice(notice);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("删除公告")
    @GetMapping("/deleteNotice")
    public JsonResult deleteNotice( String id){
        JsonResult jsonResult = new JsonResult();
        Notice selectNotice = noticeService.selectByid(Integer.parseInt(id));
        if(selectNotice == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此公告不存在");
        }else {
            noticeService.deleteNotice(Integer.parseInt(id));
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.DELETE.SUCCESS");
        }
        return jsonResult;
    }
}
