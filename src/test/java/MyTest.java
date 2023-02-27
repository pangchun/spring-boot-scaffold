import cn.pangchun.scaffold.ScaffoldApplication;
import cn.pangchun.scaffold.oss.dto.Person;
import cn.pangchun.scaffold.oss.mapper.SmsMapper;
import cn.pangchun.scaffold.oss.service.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScaffoldApplication.class)
public class MyTest {

    @Autowired
    private SmsMapper smsMapper;

    @Autowired
    private SmsService smsService;

    @Test
    public void test() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(-1);
        person.setSex("男");
        smsService.test(person);
    }
}
