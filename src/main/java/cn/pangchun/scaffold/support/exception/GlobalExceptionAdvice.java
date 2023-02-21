package cn.pangchun.scaffold.support.exception;

import cn.pangchun.scaffold.support.response.CodeEnum;
import cn.pangchun.scaffold.support.response.CommonResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常增强处理
 *
 * @author pangchun
 * @since 2023/2/21
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    protected final Log logger = LogFactory.getLog(GlobalExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse<String> exceptionHandler(Exception e, HttpServletRequest request) {
        // 获取请求相关的参数
        String method = request.getMethod();
        String servletPath = request.getServletPath();
        // 输出日志
        logger.error("方法名：" + method + "请求路径：" + servletPath);
        return CommonResponse.ofFail(CodeEnum.UNKNOWN_EXCEPTION.code(), CodeEnum.UNKNOWN_EXCEPTION.message());
    }

    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public CommonResponse<String> exceptionHandler(AuthorizationException e, HttpServletRequest request) {
        // 获取请求相关的参数
        String method = request.getMethod();
        String servletPath = request.getServletPath();
        // 输出日志
        logger.error("方法类型：" + method + "请求路径：" + servletPath);
        // 返回
        return CommonResponse.ofFail(CodeEnum.AUTHORIZATION_EXCEPTION.code(), e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public CommonResponse<String> exceptionHandler(BusinessException e, HttpServletRequest request) {
        // 获取请求相关的参数
        String method = request.getMethod();
        String servletPath = request.getServletPath();
        // 输出日志
        logger.error("方法类型：" + method + "请求路径：" + servletPath);
        // 返回
        return CommonResponse.ofFail(CodeEnum.BUSINESS_EXCEPTION.code(), e.getMessage());
    }

    @ExceptionHandler(ParameterException.class)
    @ResponseBody
    public CommonResponse<String> exceptionHandler(ParameterException e, HttpServletRequest request) {
        // 获取请求相关的参数
        String method = request.getMethod();
        String servletPath = request.getServletPath();
        // 输出日志
        logger.error("方法类型：" + method + "请求路径：" + servletPath);
        // 返回
        return CommonResponse.ofFail(CodeEnum.PARAMETER_EXCEPTION.code(), e.getMessage());
    }

    @ExceptionHandler(ServerException.class)
    @ResponseBody
    public CommonResponse<String> exceptionHandler(ServerException e, HttpServletRequest request) {
        // 获取请求相关的参数
        String method = request.getMethod();
        String servletPath = request.getServletPath();
        // 输出日志
        logger.error("方法类型：" + method + "请求路径：" + servletPath);
        // 返回
        return CommonResponse.ofFail(CodeEnum.SERVER_EXCEPTION.code(), e.getMessage());
    }
}
