package cn.pangchun.scaffold.oss.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Validated
public class Person {

    @NotBlank(message = "姓名不能为空")
    private String name;

    @Positive(message = "年龄必须为正数")
    @Max(value = 100, message = "年龄最大不能超过100岁")
    private Integer age;

    private String sex;
}
