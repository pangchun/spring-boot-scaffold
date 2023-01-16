package cn.pangchun.scaffold.controller;

import cn.pangchun.scaffold.dto.Person;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@Validated
public class SmsController {

    @PostMapping("/test")
    public void test(@RequestBody @Validated Person person) {
        System.out.println(person);
    }
}
