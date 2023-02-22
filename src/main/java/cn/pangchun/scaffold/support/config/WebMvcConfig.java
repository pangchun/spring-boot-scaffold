package cn.pangchun.scaffold.support.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WebMvc配置
 *
 * @author pangchun
 * @since 2023/2/18
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置消息转换器
     *
     * @param converters 已配置的转换器列表
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 0优先级最高
        converters.add(0, new MappingJackson2HttpMessageConverter());
    }
}