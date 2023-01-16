package cn.pangchun.scaffold.entity;

import cn.pangchun.scaffold.enums.SmsEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_sms")
@Data
public class Sms {

    @TableId("id")
    private Long id;

    @TableField("sms_type")
    private SmsEnum smsType;
}
