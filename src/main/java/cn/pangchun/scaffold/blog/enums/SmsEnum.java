package cn.pangchun.scaffold.blog.enums;

import cn.pangchun.scaffold.support.option.OptionItem;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 短信类型 枚举
 *
 * @author pangchun
 * @since 2023/1/14
 */
@Getter
public enum SmsEnum {
    VERIFICATION(0, "验证码"),
    NOTIFICATION(1, "短信通知"),
    PROMOTION(2, "推广短信"),
    INTERNATION(3, "国际/港澳台消息");

    /**
     * 索引代号
     */
    @EnumValue
    private final Integer index;

    /**
     * 类型描述
     */
    @JsonValue
    private final String description;

    SmsEnum(Integer index, String description) {
        this.index = index;
        this.description = description;
    }

    /**
     * 构造下拉项
     *
     * @return 下拉项
     */
    public static List<OptionItem<String>> getSelectOptions() {
        return Arrays.stream(SmsEnum.values()).map(el -> OptionItem.of(el.getDescription(), el.name())).collect(Collectors.toList());
    }
}
