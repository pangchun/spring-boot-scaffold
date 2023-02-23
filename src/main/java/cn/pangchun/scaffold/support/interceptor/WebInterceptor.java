package cn.pangchun.scaffold.support.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web请求拦截器
 *
 * @author pangchun
 * @since 2023/2/22
 */
@Slf4j
public class WebInterceptor implements HandlerInterceptor {

    /**
     * controller方法执行前处理, 返回false请求被拦截, 一般用于获取会话信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("当前请求链接:【{}】 请求方法:【{}】", request.getRequestURI(), request.getMethod());
        return true;
    }

    /**
     * 返回渲染视图前处理, 可以对模型数据进行进一步处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 整个请求执行结束时回调, 一般用于释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
