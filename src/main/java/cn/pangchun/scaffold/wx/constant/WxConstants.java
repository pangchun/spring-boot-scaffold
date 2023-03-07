package cn.pangchun.scaffold.wx.constant;

/**
 * WxConstants 微信相关常量
 *
 * @author pangchun
 * @since 2023/3/3
 */
public class WxConstants {

    /**
     * 推送订阅消息url [POST方法]
     * 需要手动获取到access_token拼接到url后面
     */
    public static final String SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=";


}
