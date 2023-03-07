package cn.pangchun.scaffold.wx.model.dto;

import cn.pangchun.scaffold.wx.enums.MiniprogramStateEnum;
import cn.pangchun.scaffold.wx.enums.WxMsgTemplateEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * MsgSendDTO
 *
 * @author pangchun
 * @since 2023/3/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Validated
public class MsgSendDTO implements Serializable {

    private static final long serialVersionUID = -1718630415603906153L;

    /**
     * appId
     */
    @NotBlank(message = "appId不能为空")
    private String appId;

    /**
     * 接收者（用户）的 openid
     */
    @NotBlank(message = "touser不能为空")
    private String touser;

    /**
     * 消息模板code
     * 通过code查询数据库获取模板id
     */
    @TableField("template_code")
    private WxMsgTemplateEnum templateCode;

    /**
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转
     */
    @Nullable
    private String page;

    /**
     * 模板内容
     * 传消息模板对象 见template目录
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
