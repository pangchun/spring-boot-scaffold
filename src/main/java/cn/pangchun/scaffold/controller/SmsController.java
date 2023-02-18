package cn.pangchun.scaffold.controller;

import cn.pangchun.scaffold.dto.Person;
import cn.pangchun.scaffold.support.response.CommonResponseBody;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
@Validated
@CommonResponseBody
public class SmsController {

    @PostMapping("/test")
    public String test(@RequestBody @Validated Person person) {
        System.out.println(person);
        return "123456";
    }

    @GetMapping("/test1")
    public String test() {
        return "123456";
    }
}
