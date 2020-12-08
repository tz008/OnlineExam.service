package com.onlineExam.web.api.controller;



import com.OnlineExam.JsonResult;
import com.onlineExam.web.entity.Admin;
import com.onlineExam.web.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "admin接口")
@RequestMapping("/AdminController")
@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @ApiOperation("得到全部管理员")
    @GetMapping("/getAllAdmin")
    public JsonResult<List<Admin>> selectAll(){
        return new JsonResult<>(adminService.selectAll());
    }

    @ApiOperation("根据账号查找管理员")
    @PostMapping("/selectByAccount")
    public JsonResult selectByAccount(@RequestBody int account){
       Admin admin = adminService.selectByAccount(account);
       JsonResult jsonResult = new JsonResult();
       if(admin != null){
           jsonResult.setData(admin);
       }else {
           jsonResult.setCode(1001);
           jsonResult.setMsg("没有此管理员");
       }
       return jsonResult;
    }

    @ApiOperation("根据姓名查找管理员")
    @PostMapping("/selectByName")
    public JsonResult selectByName(@RequestBody String name){
        Admin admin = adminService.selectByName(name);
        JsonResult jsonResult = new JsonResult();
        if(admin != null){
            jsonResult.setData(admin);
        }else {
            jsonResult.setCode(1001);
            jsonResult.setMsg("没有此管理员");
        }
        return jsonResult;
    }

    @ApiOperation("找回密码")
    @PostMapping("/getPassword")
    public JsonResult getPassword(@RequestBody int account){
        String password = adminService.getPassword(account);
        JsonResult jsonResult = new JsonResult();
        if(password != null){
            jsonResult.setData(password);
        }else {
            jsonResult.setCode(1001);
            jsonResult.setMsg("账号不存在");
        }
        return jsonResult;
    }

    @ApiOperation("增加管理员")
    @PostMapping("/insertAdmin")
    public JsonResult insertAdmin(@RequestBody Admin admin){
        JsonResult jsonResult = new JsonResult();
        Admin selectAdmin = adminService.selectByAccount(admin.getAccount());
        if(selectAdmin != null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此账号已存在");
        }else {
            adminService.insertAdmin(admin);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.INSERT.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("修改管理员")
    @PostMapping("/updateAdmin")
    public JsonResult updateAdmin(@RequestBody Admin admin){
        JsonResult jsonResult = new JsonResult();
        Admin selectAdmin = adminService.selectByAccount(admin.getAccount());
        if(selectAdmin == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此管理员不存在");
        }else {
            adminService.updateAdmin(admin);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.UPDATE.SUCCESS");
        }
        return jsonResult;
    }

    @ApiOperation("删除管理员")
    @PostMapping("/deleteAdmin")
    public JsonResult deleteAdmin(@RequestBody int account){
        JsonResult jsonResult = new JsonResult();
        Admin selectAdmin = adminService.selectByAccount(account);
        if(selectAdmin == null){
            jsonResult.setCode(1001);
            jsonResult.setMsg("此管理员不存在");
        }else {
            adminService.deleteAdmin(account);
            jsonResult.setCode(1000);
            jsonResult.setMsg("DB.DELETE.SUCCESS");
        }
        return jsonResult;
    }

}
