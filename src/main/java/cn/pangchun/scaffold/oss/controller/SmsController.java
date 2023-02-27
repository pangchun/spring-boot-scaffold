package cn.pangchun.scaffold.oss.controller;

import cn.pangchun.scaffold.oss.dto.Person;
import cn.pangchun.scaffold.support.response.CommonResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "短信API")
@RestController
@RequestMapping("/sms")
@Validated
@CommonResponseBody
public class SmsController {

    @ApiOperation("测试1")
    @PostMapping("/test")
    public String test(@RequestBody @Validated Person person) {
        System.out.println(person);
        return "123456";
    }

    @ApiOperation("测试2")
    @GetMapping("/test1")
    public String test() {
        return "123456";
    }
}
