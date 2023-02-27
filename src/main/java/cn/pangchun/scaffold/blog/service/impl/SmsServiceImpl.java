package cn.pangchun.scaffold.blog.service.impl;

import cn.pangchun.scaffold.support.util.ValidatorUtil;
import cn.pangchun.scaffold.blog.dto.Person;
import cn.pangchun.scaffold.blog.entity.Sms;
import cn.pangchun.scaffold.blog.mapper.SmsMapper;
import cn.pangchun.scaffold.blog.service.SmsService;
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
