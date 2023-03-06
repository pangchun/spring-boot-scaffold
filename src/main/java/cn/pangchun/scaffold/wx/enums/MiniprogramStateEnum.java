package cn.pangchun.scaffold.wx.enums;

import lombok.Getter;

/**
 * 跳转小程序类型枚举
 * 1、developer为开发版；trial为体验版；formal为正式版；默认为正式版
 *
 * @author pangchun
 * @since 2023/3/6
 */
@Getter
public enum MiniprogramStateEnum {

    /**
     * 开发版
     */
    developer(0, "开发版"),

    /**
     * 体验版
     */
    trial(0, "开发版"),

    /**
     * 正式版 默认
     */
    formal(0, "开发版"),
    ;

    /**
     * 序号
     */
    private final int index;

    /**
     * 描述
     */
    private final String desc;

    MiniprogramStateEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }
}
