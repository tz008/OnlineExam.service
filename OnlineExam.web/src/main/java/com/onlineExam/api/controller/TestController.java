package com.onlineExam.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "Test接口")
@RequestMapping("/testController")
@Controller
public class TestController {

    @ApiOperation("Demo")
    @GetMapping("/demo")
    @ResponseBody
    public  String Home() {
        return "Hello";
    }

    @ApiOperation("哈哈")
    @GetMapping("/haha")
    @ResponseBody
    public  String haha() {
        return "haha";
    }

}

