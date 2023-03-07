package cn.pangchun.scaffold.wx.model.template;

import cn.pangchun.scaffold.wx.enums.MiniprogramStateEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 微信发送消息请求参数
 * 1、注意：小程序内的请求参数中不使用驼峰命名,使用下划线,因此在请求推送消息接口前需要将WxMessageParam转json,按驼峰转下划线的方式
 *
 * @author pangchun
 * @since 2023/3/6
 */
@Data
@Validated
@Accessors(chain = true)
public class WxMessageParam {

    /**
     * 接收者（用户）的 openid
     */
    @NotBlank(message = "touser不能为空")
    private String touser;

    /**
     * 所需下发的订阅模板id
     */
    @NotBlank(message = "templateId不能为空")
    private String templateId;

    /**
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转
     */
    @Nullable
    private String page;

    /**
     * 模板内容，格式形如 { "key1": { "value": any }, "key2": { "value": any } }的object
     * 此处我们定义为Object,方便接收任何模板的消息体,此外每个模板都用对象定义,可以直接引用
     */
    @NotNull(message = "data不能为空")
    private Object data;

    /**
     * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
     * {@link MiniprogramStateEnum}
     */
    @NotBlank(message = "miniprogramState不能为空")
    private String miniprogramState = MiniprogramStateEnum.formal.name();

    /**
     * 进入小程序查看”的语言类型，支持zh_CN(简体中文)、en_US(英文)、zh_HK(繁体中文)、zh_TW(繁体中文)，默认为zh_CN
     */
    @NotBlank(message = "lang不能为空")
    private String lang = "zh_CN";
}
