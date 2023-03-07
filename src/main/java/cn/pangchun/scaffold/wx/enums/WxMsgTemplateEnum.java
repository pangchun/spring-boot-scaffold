package cn.pangchun.scaffold.wx.enums;

import cn.pangchun.scaffold.wx.model.template.PaymentSuccessNotification;
import lombok.Getter;

/**
 * 微信消息模板枚举
 * 使用枚举关联模板
 *
 * @author pangchun
 * @since 2023/3/7
 */
@Getter
public enum WxMsgTemplateEnum {

    /**
     * 付款成功通知
     */
    paymentSuccessNotification(0, PaymentSuccessNotification.class.getName(), "付款成功通知"),

    ;

    /**
     * 序号
     */
    private final int index;

    /**
     * 对应模板java类名
     */
    private final String className;

    /**
     * 描述
     */
    private final String desc;

    WxMsgTemplateEnum(int index, String className, String desc) {
        this.index = index;
        this.className = className;
        this.desc = desc;
    }
}
