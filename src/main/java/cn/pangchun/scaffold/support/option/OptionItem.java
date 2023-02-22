package cn.pangchun.scaffold.support.option;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 下拉项结构类
 *
 * @author pangchun
 * @since 2023/1/15
 */
@Data
@NoArgsConstructor
public class OptionItem<T> {

    private String name;

    private T value;

    public static <T> OptionItem<T> of(String name, T value) {
        OptionItem<T> item = new OptionItem<>();
        item.setName(name);
        item.setValue(value);
        return item;
    }
}
