package cn.pangchun.scaffold.oss.service;

import cn.pangchun.scaffold.oss.dto.Person;
import cn.pangchun.scaffold.oss.entity.Sms;
import com.baomidou.mybatisplus.extension.service.IService;

public interface SmsService extends IService<Sms> {

    void test(Person person);
}
