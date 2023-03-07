package cn.pangchun.scaffold.wx.model.entity;

import cn.pangchun.scaffold.wx.enums.WxMsgTemplateEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 消息模板
 *
 * @author pangchun
 * @since 2023/3/7
 */
@TableName("t_wx_msg_template")
@Data
public class WxMsgTemplate implements Serializable {

    private static final long serialVersionUID = 7100682640163563909L;

    @TableId("id")
    private Long id;

    @TableField("template_id")
    private WxMsgTemplateEnum templateId;

    @TableField("template_code")
    private WxMsgTemplateEnum templateCode;
}
