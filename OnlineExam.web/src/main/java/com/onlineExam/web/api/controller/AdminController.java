package com.onlineExam.web.api.controller;



import com.onlineExam.web.entity.Admin;
import com.onlineExam.web.service.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
