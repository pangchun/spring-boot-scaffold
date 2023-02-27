import cn.pangchun.scaffold.ScaffoldApplication;
import cn.pangchun.scaffold.blog.mapper.SmsMapper;
import cn.pangchun.scaffold.blog.service.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScaffoldApplication.class)
public class MyTest {

    @Autowired
    private SmsMapper smsMapper;

    @Autowired
    private SmsService smsService;

    @Value("${oss.endpoint}")
    private String endpoint;

    @Test
    public void test() {
    }
}
