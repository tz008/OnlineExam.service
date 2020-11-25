package com.onlineExam.web.api.controller;

import com.OnlineExam.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "Hello接口")
@RequestMapping("/HelloController")
@Controller
public class HelloController {

    @ApiOperation("Demo")
    @GetMapping("/demo")
    @ResponseBody
    public  String Home() {
        return "Hello";
    }

    @ApiOperation("哈哈")
    @GetMapping("/haha")
    @ResponseBody
    public  JsonResult<String> haha() {
        return new JsonResult<>("哈哈");
    }

}

