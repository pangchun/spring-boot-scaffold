package cn.pangchun.scaffold.wx.model.entity;

import cn.pangchun.scaffold.wx.enums.WxMsgTemplateEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 推送消息记录
 *
 * @author pangchun
 * @since 2023/3/7
 */
@TableName("t_wx_msg_record")
@Data
public class WxMsgRecord implements Serializable {

    private static final long serialVersionUID = -726094515345495459L;

    @TableId("id")
    private Long id;

    @TableField("touser")
    private String touser;

    @TableField("template_code")
    private WxMsgTemplateEnum templateCode;

    @TableField("data")
    private String data;

    @TableField("sendTime")
    private LocalDateTime sendTime;

    @TableField("result")
    private Boolean result;
}
