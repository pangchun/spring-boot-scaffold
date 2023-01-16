package cn.pangchun.scaffold.service;

import cn.pangchun.scaffold.dto.Person;
import cn.pangchun.scaffold.entity.Sms;
import com.baomidou.mybatisplus.extension.service.IService;

public interface SmsService extends IService<Sms> {

    void test(Person person);
}
