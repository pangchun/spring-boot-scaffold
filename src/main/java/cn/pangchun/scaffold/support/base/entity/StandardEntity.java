package cn.pangchun.scaffold.support.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 标准基类
 *
 * @author pangchun
 * @since 2023/2/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class StandardEntity extends BaseEntity {

    private static final long serialVersionUID = -3019309990233226383L;

    @TableLogic
    @TableField(value = "is_del", fill = FieldFill.INSERT)
    private Boolean del = false;

    @TableField(value = "version")
    @Version
    private Integer version = 1;
}
