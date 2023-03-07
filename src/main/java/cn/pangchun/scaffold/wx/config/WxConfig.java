package cn.pangchun.scaffold.wx.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 微信配置注入
 *
 * @author pangchun
 * @since 2023/3/7
 */
@Data
@Component
public class WxConfig {

    /**
     * 小程序appId
     */
    @Value("${wx.app-id}")
    public String appId;

    /**
     * 小程序appSecret
     */
    @Value("${wx.app-secret}")
    public String appSecret;
}
