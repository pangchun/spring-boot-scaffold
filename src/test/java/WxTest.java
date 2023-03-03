import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.pangchun.scaffold.ScaffoldApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * WxTest 微信订阅消息推送测试类
 *
 * @author pangchun
 * @since 2023/3/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScaffoldApplication.class)
@Slf4j
public class WxTest {

    /**
     * 获取微信小程序token
     * 1、每次请求都会返回新的token, 之前的token会失效, 新的token有效期为2小时
     * 2、返回：{"access_token":"************","expires_in":7200}
     */
    @Test
    public void getAccessToken() {
        HttpRequest request = HttpUtil.createGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=************&secret=************");
        HttpResponse response = request.execute();
        System.out.println("response.body() = " + response.body());
    }

}
