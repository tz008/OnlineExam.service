package com.onlineExam.app.api.controller;


import com.OnlineExam.JsonResult;
import com.onlineExam.app.entity.Admin;
import com.onlineExam.app.service.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "admin接口")
@RequestMapping("/AdminController")
@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/getAllAdmin")
    public Admin selectAll(){
        System.out.println(adminService);
        return adminService.selectAll();
    }

    @GetMapping("/haha")
    @ResponseBody
    public  String Home() {
        return "Hello";
    }
}
