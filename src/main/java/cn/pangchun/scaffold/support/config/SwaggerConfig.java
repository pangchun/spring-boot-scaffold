package cn.pangchun.scaffold.support.config;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

/**
 * Swagger配置
 * 1、访问链接 http://localhost:8080/scaffold/swagger-ui/index.html
 *
 * @author pangchun
 * @since 2023/2/24
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    // 只有dev、test环境中使用Swagger
    private static final List<String> acceptProfiles = Lists.newArrayList("dev", "test");

    /**
     * 文档信息
     */
    private ApiInfo apiInfo() {
        ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title("Scaffold 接口文档")
                .description("Scaffold项目的接口文档, 由Swagger3提供支持")
                .contact(new Contact("pangchun", "https://github.com/pangchun", "pangchun_mail@qq.com"))
                .version("v0.0.1");
        return builder.build();
    }

    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.OAS_30);
        docket.apiInfo(apiInfo())
                .enable(acceptProfiles.contains(activeProfile))
                .groupName("scaffold")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.pangchun.scaffold"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
