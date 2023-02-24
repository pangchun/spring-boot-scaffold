package cn.pangchun.scaffold.support.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 过滤器配置
 *
 * @author pangchun
 * @since 2023/2/24
 */
@Configuration
public class FilterConfig {

    /**
     * 获取跨域配置
     */
    private CorsConfiguration corsConfiguration(){
        CorsConfiguration cors = new CorsConfiguration();
        // 允许任何的head头部
        cors.addAllowedHeader("*");
        // 允许任何域名使用
        cors.addAllowedOrigin("*");
        // 允许任何的请求方法
        cors.addAllowedMethod("*");
        cors.setAllowCredentials(true);
        cors.setMaxAge(3600L);
        return cors;
    }

    /**
     * 配置跨域过滤器
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration());
        return new CorsFilter(source);
    }
}
