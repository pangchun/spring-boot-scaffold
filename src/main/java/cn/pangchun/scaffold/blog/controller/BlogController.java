package cn.pangchun.scaffold.blog.controller;

import cn.pangchun.scaffold.blog.dto.Person;
import cn.pangchun.scaffold.support.response.CommonResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "博客API")
@RestController
@RequestMapping("/sms")
@Validated
@CommonResponseBody
public class BlogController {

    @ApiOperation("测试1")
    @PostMapping("/test")
    public String test(@RequestBody @Validated Person person) {
        System.out.println(person);
        return "123456";
    }
}
