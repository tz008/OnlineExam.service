package demo.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "hello测试接口")
@Controller
public class HelloController {

    @ApiOperation("Demo")
    @GetMapping("/demo")
    @ResponseBody
    public  String Home() {
        return "Hello";
    }

}

