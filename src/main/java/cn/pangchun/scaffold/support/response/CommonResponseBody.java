package cn.pangchun.scaffold.support.response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 统一响应注解：在控制器类或方法上添加此注解后，可以直接返回数据T，不需要自己手动封装CommonResponse类
 *
 * @author pangchun
 * @since 2023/2/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CommonResponseBody {
}
