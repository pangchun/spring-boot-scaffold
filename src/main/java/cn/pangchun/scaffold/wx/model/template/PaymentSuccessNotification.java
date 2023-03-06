package cn.pangchun.scaffold.wx.model.template;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 付款成功通知
 * 1、注意：小程序内的请求参数中不使用驼峰命名,使用下划线,因此在请求推送消息接口前需要将WxMessageParam转json,按驼峰转下划线的方式
 *
 * @author pangchun
 * @since 2023/3/6
 */
@Data
public class PaymentSuccessNotification {

    /**
     * 接收者（用户）的 openid
     */
    @NotBlank(message = "touser不能为空")
    private String touser;


}
