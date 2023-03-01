package cn.pangchun.scaffold.blog.controller;

import cn.pangchun.scaffold.blog.dto.Person;
import cn.pangchun.scaffold.spider.WebDownloader;
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
        System.out.println(321);

        // 线程执行是异步的,可以监听线程结束后再返回
        WebDownloader t1 = new WebDownloader("https://th.wallhaven.cc/lg/kx/kx82d6.jpg", "C:\\Users\\pangchun\\Desktop\\project\\spring-boot-scaffold\\src\\main\\resources\\wallhaven\\1.png");
        t1.start();
        System.out.println(123);
        return "123456";
    }
}
