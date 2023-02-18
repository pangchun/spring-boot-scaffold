package cn.pangchun.scaffold.support.response;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

/**
 * 统一响应格式增强处理
 *
 * @author pangchun
 * @since 2023/2/18
 */
@RestControllerAdvice
public class CommonResponseAdvice implements ResponseBodyAdvice<Object> {

    private static final Class<? extends Annotation> ANNOTATION_TYPE = CommonResponseBody.class;

    /**
     * 判断类或方法上是否使用了自定义注解 {@link CommonResponseBody}, 是则拦截并进行增强处理
     *
     * @param returnType    接口方法返回值参数
     * @param converterType 消息转换器类型
     * @return 如果使用了 {@link CommonResponseBody} 注解，返回true并调用 {@link #beforeBodyWrite} 方法，否则返回false
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 获取返回值类型
        Class<?> parameterType = returnType.getParameterType();
        // 返回值类型为void，不需要增强处理，直接返回
        if (parameterType.getName().equalsIgnoreCase(void.class.getName())) {
            return false;
        } else {
            return returnType.hasMethodAnnotation(ANNOTATION_TYPE) || AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE);
        }
    }

    /**
     * 对响应体做一些增强处理
     *
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return CommonResponse.ofSuccess(body);
    }
}
