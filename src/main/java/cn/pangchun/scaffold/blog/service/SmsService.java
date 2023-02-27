package cn.pangchun.scaffold.blog.service;

import cn.pangchun.scaffold.blog.dto.Person;
import cn.pangchun.scaffold.blog.entity.Sms;
import com.baomidou.mybatisplus.extension.service.IService;

public interface SmsService extends IService<Sms> {

    void test(Person person);
}
