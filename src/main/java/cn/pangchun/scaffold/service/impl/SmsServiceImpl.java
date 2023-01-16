package cn.pangchun.scaffold.service.impl;

import cn.pangchun.scaffold.support.ValidatorUtil;
import cn.pangchun.scaffold.dto.Person;
import cn.pangchun.scaffold.entity.Sms;
import cn.pangchun.scaffold.mapper.SmsMapper;
import cn.pangchun.scaffold.service.SmsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl extends ServiceImpl<SmsMapper, Sms> implements SmsService {

    @Override
    public void test(Person person) {
        // 校验
        try {
            ValidatorUtil.validate(person, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(person);
    }
}
